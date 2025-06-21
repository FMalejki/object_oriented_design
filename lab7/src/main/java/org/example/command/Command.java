package org.example.command;

public abstract class Command {
    public Application app;
    protected Editor editor;
    protected String backup;

    public Command(Application app, Editor editor) {
        this.app = app;
        this.editor = editor;
    }

    public void saveBackup(){
        this.backup = editor.text;
    }

    public void undo(){
        editor.text = this.backup;
    }

    public abstract boolean execute();
}
