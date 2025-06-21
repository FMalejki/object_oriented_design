package command;

public class CommandDemo {
    public static void main(String[] args){
        Application app = new Application();
        app.createUI();

        System.out.println("\n--- KROK 1: Wykonanie operacji CUT ---");
        Command cut = new CutCommand(app, app.editor);
        app.executeCommand(cut);
        System.out.println("Stan edytora po CUT: '" + app.editor.text + "'");

        System.out.println("\n--- KROK 2: Wykonanie operacji PASTE ---");
        Command paste = new PasteCommand(app, app.editor);
        app.executeCommand(paste);
        System.out.println("Stan edytora po PASTE: '" + app.editor.text + "'");
        
        System.out.println("\n--- KROK 3: Wykonanie operacji COPY (nie trafia do historii) ---");
        Command copy = new CopyCommand(app, app.editor);
        app.executeCommand(copy);
        System.out.println("Stan edytora po COPY: '" + app.editor.text + "'");

        System.out.println("\n--- KROK 4: Cofnięcie ostatniej modyfikującej operacji (PASTE) ---");
        app.undo();
        System.out.println("Stan edytora po UNDO: '" + app.editor.text + "'");

        System.out.println("\n--- KROK 5: Cofnięcie kolejnej operacji (CUT) ---");
        app.undo();
        System.out.println("Stan edytora po drugim UNDO: '" + app.editor.text + "'");

        System.out.println("\n--- KROK 6: Próba kolejnego cofnięcia ---");
        app.undo();
    }
}
