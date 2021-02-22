package ua.kpi;

import ua.kpi.view.View;
import ua.kpi.view.Viewable;

public class MVCConsoleFactory extends MVCFactory {

  @Override
  public Viewable createView() {
    return new View();
  }
}
