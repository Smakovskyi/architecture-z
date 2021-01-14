package ua.kpi.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import lombok.Setter;
import ua.kpi.controller.commands.AddCommand;
import ua.kpi.controller.commands.Command;
import ua.kpi.controller.commands.DefaultCommand;
import ua.kpi.controller.commands.ExitCommand;
import ua.kpi.controller.commands.SubCommand;
import ua.kpi.view.View;


@Setter
public class Controller {

  private View view;

  private InputStream in = System.in;
  private BufferedReader reader = new BufferedReader(
      new InputStreamReader(in));

  private Map<String, Command> commands = new HashMap<>();
  {
    commands.put("add", new AddCommand());
    commands.put("exit", new ExitCommand());
    commands.put("sub", new SubCommand());
  }

  public Controller(View view) {
    this.view = view;
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
