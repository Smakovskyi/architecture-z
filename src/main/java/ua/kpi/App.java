package ua.kpi;

import java.io.IOException;
import ua.kpi.controller.Controller;
import ua.kpi.view.View;
import ua.kpi.view.Viewable;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        MVCFactory factory = MVCFactory.getInstance();
        Viewable view = factory.createView();

        Controller controller = new Controller(view);
        controller.handleUserInput();

    }
}
