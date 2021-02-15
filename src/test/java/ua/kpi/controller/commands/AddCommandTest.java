package ua.kpi.controller.commands;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import ua.kpi.model.Calculator;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("Tests for the AddCommand")
public class AddCommandTest {
  @Mock Calculator calculator;

  @InjectMocks
  AddCommand addCommand = new AddCommand();

  @Test
  void test_execute_with_2_and_3_returns_5(){
    final String expectedResult = "5";
    when( calculator.add(2, 3) ).thenReturn(5);

    String actualResult = addCommand.execute(new String[]{"2", "3"});

    assertThat( actualResult, is(expectedResult));
    verify( calculator ).add(2, 3);
  }

}
