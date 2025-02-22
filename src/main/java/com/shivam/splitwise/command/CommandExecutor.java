package com.shivam.splitwise.command;

public interface CommandExecutor {
    void addCommand(Command command);
    void removeCommand(Command command);
    void execute(String command);
}
