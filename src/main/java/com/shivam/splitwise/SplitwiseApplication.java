package com.shivam.splitwise;

import com.shivam.splitwise.command.CommandExecutor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Scanner;

@SpringBootApplication
@EnableJpaAuditing
public class SplitwiseApplication implements CommandLineRunner {
    private Scanner scanner;
    private CommandExecutor commandExecutor;

    public SplitwiseApplication(CommandExecutor commandExecutor) {
        this.scanner = new Scanner(System.in);
        this.commandExecutor = commandExecutor;
    }

    @Override
    public void run(String... args) throws Exception {
        while (true){
            String command = scanner.nextLine();
            commandExecutor.execute(command);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(SplitwiseApplication.class, args);
    }

}
