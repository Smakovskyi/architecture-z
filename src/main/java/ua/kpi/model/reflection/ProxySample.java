package ua.kpi.model.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxySample implements InvocationHandler {

    private Object ref;

    private ProxySample(Object ref) {
      this.ref = ref;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
      if (args.length == 2) {
        if (((Number) args[0]).doubleValue() >= 0 &&
            ((Number) args[1]).doubleValue() >= 0) {
          return method.invoke(ref, args);
        } else {
          throw new IllegalArgumentException("Not allowed");
        }

      }
      return method.invoke(ref, args);
    }

    public static Object newProxyInstance(Object obj) {
      return java.lang.reflect.Proxy.newProxyInstance(
          obj.getClass().getClassLoader(),
          obj.getClass().getInterfaces(),
          new ProxySample(obj));
    }
}


