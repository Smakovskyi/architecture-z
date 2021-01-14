package ua.kpi.model;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SetCalculator {
  public Integer[] setIntersection(Integer[] first, Integer second[]){
    Set<Integer> firstSet = Stream.of(first)
        .collect(Collectors.toSet());
    return Stream.of(second)
        .filter( firstSet::contains )
        .collect(Collectors.toSet())
        .stream()
        .toArray(Integer[]::new);
  }

}
