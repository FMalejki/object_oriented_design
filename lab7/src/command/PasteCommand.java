package command;

public class PasteCommand extends Command {
    public PasteCommand(Application app, Editor editor){
        super(app, editor);
    }

    @Override
    public boolean execute(){
        saveBackup();
        editor.replaceSelection(app.clipboard);
        System.out.println("Wklejono ze schowka: '" + app.clipboard + "'");
        return true;
    }
}
