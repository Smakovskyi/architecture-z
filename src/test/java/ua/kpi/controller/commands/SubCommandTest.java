package ua.kpi.controller.commands;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ReflectionUtils;
import org.mockito.internal.util.reflection.ReflectionMemberAccessor;
import ua.kpi.model.Calculator;


@DisplayName("Tests for Sub Command")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class SubCommandTest {

  @Test
  void test_execute_with_5_and_2_returns_3() throws Exception{
    String args[] = {"5", "2"};
    final String expectedResult = "3";
    SubCommand subCommand = new SubCommand();
    Calculator calculator = mock(Calculator.class);
    when(calculator.sub(5,2)).thenReturn(3);
    //new ReflectionMemberAccessor().set(subCommand.getClass().getDeclaredField("calculator")
    //, subCommand, calculator);
    subCommand.setCalculator(calculator);

    String actualResult = subCommand.execute(args);

    assertEquals(expectedResult, actualResult);
    verify(calculator).sub(5,2);
  }


}