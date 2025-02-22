package com.shivam.splitwise.command;

import com.shivam.splitwise.models.User;
import com.shivam.splitwise.models.UserSubscriptionType;
import com.shivam.splitwise.repositories.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class AddUser implements Command {
    private CommandExecutor commandExecutor;
    private UserRepository userRepository;

    public AddUser(CommandExecutor commandExecutor,
                   UserRepository userRepository) {
        this.commandExecutor = commandExecutor;
        this.userRepository = userRepository;

        this.commandExecutor.addCommand(this);
    }

    @Override
    public boolean matches(String command) {
        // adduser name phonenumber password
        String[] split = command.split(" ");
        if (split.length > 0 && split[0].equalsIgnoreCase("adduser")) {
            return true;
        }
        return false;
    }

    @Override
    public void execute(String command) {
        // adduser name phonenumber password
        String[] split = command.split(" ");
        if (split.length < 4){
            throw new IllegalArgumentException("please provide all parameters for adding a user");
        }
        User user = new User();
        user.setName(split[1]);
        user.setPhoneNumber(split[2]);
        user.setPassword(split[3]);
        user.setSubscriptionType(UserSubscriptionType.FREE);
        userRepository.save(user);
    }
}
