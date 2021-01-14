package ua.kpi.model.reflection;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import ua.kpi.ReflectionSamples;
import ua.kpi.model.Calculable;
import ua.kpi.model.Calculator;
import ua.kpi.model.CallMe;
import ua.kpi.model.Human;

public final class Utils {
  private Utils(){}

  public static void fieldSample(Calculator calculator, Class clazz)
      throws NoSuchFieldException, IllegalAccessException {
    Field lastResult = clazz.getDeclaredField("lastResult");
    lastResult.setAccessible(true);
    lastResult.set(calculator, 100500);
    System.out.println("last Result = " + calculator.getLastResult());
  }

  public static void metodsSample(Calculator calculator, Class clazz)
      throws IllegalAccessException, InvocationTargetException {
    for(Method method : clazz.getMethods() ){
      System.out.println(Modifier.toString( method.getModifiers() )
          + " " + method.getReturnType() + " " + method.getName());

      if(method.isAnnotationPresent(CallMe.class)){
        if(method.getParameters().length != 2){
          throw new RuntimeException();
        }
        Object result = method.invoke(calculator, 2, 3);
        System.out.println("Method result = " + result);
      }
    }
  }

  public static void classLoadSample()
      throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
    String className = "ua.kpi.model.Calculator";
    Class<?> dynamicClass = Class.forName(className);

    Object instance = dynamicClass.getDeclaredConstructor().newInstance();
    if( instance instanceof Calculator){
      Calculator calculatorInstance = (Calculator) instance;
      System.out.println("Calculator " + calculatorInstance.getLastResult());
    }
  }

  public static void sampleWithProxy()
      throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
    Class<?> calculatorClass = Class.forName("ua.kpi.model.Calculator");
    Object instance = calculatorClass.getDeclaredConstructor().newInstance();
    boolean allowed = false;
    for(Class inter : instance.getClass().getInterfaces()){
      if( inter == Calculable.class){ allowed = true; }
    }
    if(allowed){
      Calculable calculatorInstance = (Calculable) ProxySample.newProxyInstance(instance);
      System.out.println(" 2 + 3 = " + calculatorInstance.add(2,3));
      System.out.println(" (-2) + 3 = " + calculatorInstance.add(-2,3));
    }
  }

  public static void resourcesSample() throws java.io.IOException {
    InputStream stream = ReflectionSamples.class.getResourceAsStream("/mydata.txt");
    ObjectMapper objectMapper = new ObjectMapper();
    Human human = objectMapper.readValue(stream, Human.class);
    System.out.println(human);
  }


}
