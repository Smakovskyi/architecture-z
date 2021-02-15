package ua.kpi.model;


import lombok.Getter;

@Getter
public class Calculator implements Calculable {

  private static Calculator instance = new Calculator();
  private int lastResult;

  public static Calculator getInstance(){
    return instance;
  }

  @CallMe
  public int add(int first, int second){
    int result = first + second;
    lastResult = result;
    return result;
  }

  public int sub(int first, int second){
    return first - second;
  }




  public int divide(int first, int second) {
    int result = first / second;
    lastResult = result;
    return result;
  }
}
