package ua.kpi.model;

import lombok.Getter;

@Getter
public class Calculator implements Calculable {

  private int lastResult;


  @CallMe
  public int add(int first, int second){
    return first + second;
  }

  public int sub(int first, int second){
    return first - second;
  }


}
