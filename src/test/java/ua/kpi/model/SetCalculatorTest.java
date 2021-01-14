package ua.kpi.model;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.ArrayMatching.arrayContainingInAnyOrder;
import static org.hamcrest.collection.IsArrayWithSize.arrayWithSize;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Tests for Set Calculator")
public class SetCalculatorTest {
  @Nested
  @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
  class Test_for_set_operations{

    @Test
    void test_intersect_two_sets_with_values_receive_non_empty_set(){
      SetCalculator calculator = new SetCalculator();
      Integer[] firstSet = {2, 3, 4};
      Integer[] secondSet = { 6, 3, 4, 10};
      Integer[] actualSet = calculator.setIntersection(firstSet, secondSet);
      assertThat(actualSet, arrayWithSize(2) );
      assertThat(actualSet, arrayContainingInAnyOrder(3, 4));
    }

    @Test
    void test_intersect_non_empty_with_empty_receive_empty_set(){
      SetCalculator calculator = new SetCalculator();
      Integer[] firstSet = {2, 3, 4};
      Integer[] secondSet = { };
      Integer[] actualSet = calculator.setIntersection(firstSet, secondSet);
      assertThat(actualSet, arrayWithSize(0) );
    }


    @Test
    void test_intersect_two_sets_with_values_receive_set_with_values(){
      SetCalculator calculator = new SetCalculator();
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
