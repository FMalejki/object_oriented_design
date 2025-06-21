package org.example.command;

public class Application {
    public String clipboard;
    public Editor editor;
    private CommandHistory history = new CommandHistory();

    public void createUI() {
        editor = new Editor();
        editor.text = "To jest przykładowy tekst do edycji w naszym programie.";
        System.out.println("Utworzono edytor z tekstem: '" + editor.text + "'");
    }

    public void executeCommand(Command command) {
        if (command.execute()) {
            history.push(command);
            System.out.println("Dodano polecenie do historii.");
        }
    }

    public void undo() {
        Command command = history.pop();
        if (command != null) {
            System.out.println("Cofanie ostatniej operacji...");
            command.undo();
        } else {
            System.out.println("Historia jest pusta, nie można cofnąć.");
        }
    }
}
