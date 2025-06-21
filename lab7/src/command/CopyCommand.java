package command;

public class CopyCommand extends Command {
    public CopyCommand(Application app, Editor editor) {
        super(app, editor);
    }

    @Override
    public boolean execute(){
        app.clipboard = editor.getSelection();
        System.out.println("Skopiowano do schowka: '" + app.clipboard + "'");
        return false;
    }
}
