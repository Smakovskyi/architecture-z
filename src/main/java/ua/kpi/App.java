package ua.kpi;

import java.io.IOException;
import ua.kpi.controller.Controller;
import ua.kpi.view.View;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        View view = new View();
        Controller controller = new Controller(view);
        controller.handleUserInput();
    }
}
