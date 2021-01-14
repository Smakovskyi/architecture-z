package ua.kpi.model;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.ArrayMatching.arrayContainingInAnyOrder;
import static org.hamcrest.collection.IsArrayWithSize.arrayWithSize;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Tests for Calculator")
public class CalculatorTest {

  @Nested
  @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
  class Tests_for_addition {

    @Test
    void test_add_two_and_three_receive_five() {
      Calculator calculator = new Calculator();
      int first = 2;
      int second = 3;
      final int expectedResult = 5;

      int actualResult = calculator.add(first, second);

      assertEquals(expectedResult, actualResult);
    }

    @Test
    void test_add_two_and_three_get_last_result_five() {
      Calculator calculator = new Calculator();
      int first = 2;
      int second = 3;
      final int expectedLastResult = 5;

      calculator.add(first, second);
      int actualLastResult = calculator.getLastResult();

      assertEquals(expectedLastResult, actualLastResult);
    }
  }

  @Nested
  @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
  class Tests_for_division {
    @Test
    void test_divide_two_and_zero_raise_exception() {
      Calculator calculator = new Calculator();

      int first = 2;
      int second = 0;

      assertThrows( ArithmeticException.class ,
          () ->calculator.divide(first, second));
    }
  }

  @Nested
  @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
  class Test_for_set_operations{

    @Test
    void test_intersect_two_sets_with_values_receive_non_empty_set(){
      Calculator calculator = new Calculator();
      Integer[] firstSet = {2, 3, 4};
      Integer[] secondSet = { 6, 3, 4, 10};
      Integer[] actualSet = calculator.setIntersection(firstSet, secondSet);
      assertThat(actualSet, arrayWithSize(2) );
      assertThat(actualSet, arrayContainingInAnyOrder(3, 4));
    }

    @Test
    void test_intersect_non_empty_with_empty_receive_empty_set(){
      Calculator calculator = new Calculator();
      Integer[] firstSet = {2, 3, 4};
      Integer[] secondSet = { };
      Integer[] actualSet = calculator.setIntersection(firstSet, secondSet);
      assertThat(actualSet, arrayWithSize(0) );
    }


    @Test
    void test_intersect_two_sets_with_values_receive_set_with_values(){
      Calculator calculator = new Calculator();
      Integer[] firstSet = {2, 3, 4};
      Integer[] secondSet = { 6, 3, 4, 10};
      Integer[] actualSet = calculator.setIntersection(firstSet, secondSet);
      assertThat( actualSet,
          allOf(
              arrayWithSize(2),
              arrayContainingInAnyOrder(3, 4)
          )
      );

    }
  }

}
