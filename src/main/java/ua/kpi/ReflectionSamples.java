package ua.kpi;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.apache.commons.io.FileUtils;
import ua.kpi.model.Calculable;
import ua.kpi.model.Calculator;
import ua.kpi.model.CallMe;
import ua.kpi.model.Human;
import ua.kpi.model.reflection.ProxySample;
import ua.kpi.model.reflection.Utils;

public class ReflectionSamples {


  public static void main(String[] args) throws Exception {
    Calculator calculator = new Calculator();
    calculator.getLastResult();
    Class clazz = calculator.getClass();

    Utils.metodsSample(calculator, clazz);
    Utils.fieldSample(calculator, clazz);
    Utils.classLoadSample();
    Utils.resourcesSample();
    Utils.sampleWithProxy();




  }



}
