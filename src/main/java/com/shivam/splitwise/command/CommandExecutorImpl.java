package com.shivam.splitwise.command;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandExecutorImpl implements CommandExecutor {
    private final List<Command> commands = new ArrayList<>();

    @Override
    public void addCommand(Command command) {
        commands.add(command);
    }

    @Override
    public void removeCommand(Command command) {
        commands.remove(command);
    }

    @Override
    public void execute(String command) {
        for (Command command1 : commands) {
            if (command1.matches(command)) {
                command1.execute(command);
                break;
            }
        }
    }
}
