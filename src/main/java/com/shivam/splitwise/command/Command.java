package com.shivam.splitwise.command;

public interface Command {
    boolean matches(String command);
    void execute(String command);
}
