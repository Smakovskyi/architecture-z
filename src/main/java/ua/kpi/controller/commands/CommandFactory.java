package ua.kpi.controller.commands;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CommandFactory {
  private static CommandFactory instance = new CommandFactory();

  private CommandFactory(){};

  public static CommandFactory getInstance(){
    return instance;
  }

  public Optional<Command> createCommand(String name){
    switch(name){
      case "add": return Optional.of(new AddCommand());
      case "exit": return Optional.of(new ExitCommand());
      case "sub": return Optional.of(new SubCommand());
      default: return Optional.empty();
    }
  }

  public List<String> getCommandNames(){
    return Arrays.asList("add", "exit", "sub");
  }
}
