package ua.kpi.controller.commands;

import lombok.Setter;
import ua.kpi.model.Calculator;


public interface Command {

  String execute(String args[]);
}
