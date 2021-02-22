package ua.kpi.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Setter;
import ua.kpi.controller.commands.AddCommand;
import ua.kpi.controller.commands.Command;
import ua.kpi.controller.commands.CommandFactory;
import ua.kpi.controller.commands.DefaultCommand;
import ua.kpi.controller.commands.ExitCommand;
import ua.kpi.controller.commands.SubCommand;
import ua.kpi.view.View;
import ua.kpi.view.Viewable;


@Setter
@AllArgsConstructor( access = AccessLevel.PRIVATE)
@Builder
public class Controller {

  private Viewable view;

  private InputStream in = System.in;
  private BufferedReader reader = new BufferedReader(
      new InputStreamReader(in));

  private CommandFactory commandFactory = CommandFactory.getInstance();
  private Map<String, Command> commands = new HashMap<>();

  public Controller(Viewable view) {
    this.view = view;
    for(String commandName : commandFactory.getCommandNames() ){
      commandFactory.createCommand(commandName)
          .ifPresent( command -> commands.put(commandName, command) );
    }
  }

  // add 2 3
  // exit
  public void handleUserInput() throws IOException {

    while (true) {
      String line = reader.readLine();
      if("exit".equalsIgnoreCase(line.trim())){
        return;
      }
      String[] args = line.split("\\s");
      String commandName = args[0];
      Command command = commands.getOrDefault(commandName,
          DefaultCommand.getInstance());
      String result = command.execute(
          Arrays.copyOfRange(args,1, args.length ));
      view.print(result);
    }

  }
}
