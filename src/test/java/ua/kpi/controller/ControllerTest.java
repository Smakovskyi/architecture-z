package ua.kpi.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ua.kpi.controller.commands.Command;
import ua.kpi.view.View;


@DisplayName("Tests for Controller")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ControllerTest {

  @Test
  void test_handle_user_input_for_add_2_3() throws Exception {
    View view = mock(View.class);
    Controller controller = new Controller(view);

    BufferedReader bufferedReader = mock(BufferedReader.class);
    when(bufferedReader.readLine()).thenReturn("add 2 3").thenReturn("exit");

    InputStream in = mock(InputStream.class);

    Command addCommand = mock(Command.class);
    when(addCommand.execute(any())).thenReturn("5");

    Map<String, Command> commands = mock(Map.class);
    when(commands.getOrDefault(eq("add") , any())).thenReturn(addCommand);

    controller.setIn(in);
    controller.setReader(bufferedReader);
    controller.setCommands(commands);

    controller.handleUserInput();

    verify(bufferedReader, times(2)).readLine();
    verify(commands).getOrDefault(eq("add"),any());
    verify(view).print("5");
  }


  @Test
  void test_handle_user_input_for_add_5_5() throws Exception {
    View view = mock(View.class);
    BufferedReader bufferedReader = mock(BufferedReader.class);
    when(bufferedReader.readLine()).thenReturn("add 5 5").thenReturn("exit");
    InputStream in = mock(InputStream.class);
    Command addCommand = mock(Command.class);
    when(addCommand.execute(any())).thenReturn("10");

    Map<String, Command> commands = mock(Map.class);
    when(commands.getOrDefault(eq("add") , any())).thenReturn(addCommand);


    Controller controller = Controller.builder()
        .view(view)
        .in(in)
        .reader(bufferedReader)
        .commands(commands)
        .build();

    controller.handleUserInput();

    verify(bufferedReader, times(2)).readLine();
    verify(commands).getOrDefault(eq("add"),any());
    verify(view).print("10");
  }
}