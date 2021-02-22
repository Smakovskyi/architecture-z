package ua.kpi;

import java.io.InputStream;
import java.util.Properties;
import ua.kpi.view.Viewable;

public abstract class MVCFactory {
  public abstract Viewable createView();
  public static MVCFactory getInstance(){
    try {
      InputStream stream = ReflectionSamples.class.getResourceAsStream("/config.properties");
      Properties props = new Properties();
      props.load(stream);
      String className = props.getProperty("factory");
      return (MVCFactory)Class.forName(className).newInstance();
    }catch (Exception ex){
      throw new RuntimeException(ex);
    }
  }
}
