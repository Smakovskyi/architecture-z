package ua.kpi.model;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import lombok.Getter;

@Getter
public class Calculator implements Calculable {

  private int lastResult;


  @CallMe
  public int add(int first, int second){
    int result = first + second;
    lastResult = result;
    return result;
  }

  public int sub(int first, int second){
    return first - second;
  }

  public Integer[] setIntersection(Integer[] first, Integer second[]){
    Set<Integer> firstSet = Stream.of(first)
        .collect(Collectors.toSet());
    return Stream.of(second)
        .filter( firstSet::contains )
        .collect(Collectors.toSet())
        .stream()
        .toArray(Integer[]::new);
  }


  public int divide(int first, int second) {
    int result = first / second;
    lastResult = result;
    return result;
  }
}
