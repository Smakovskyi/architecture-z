package ua.kpi.controller.commands;

public class DefaultCommand implements Command {

  private static DefaultCommand defaultCommand = new DefaultCommand();

  public static Command getInstance() {
    return defaultCommand;
  }

  @Override
  public String execute(String[] args) {
    return "usage: \nadd 2 3 \nexit";
  }
}
