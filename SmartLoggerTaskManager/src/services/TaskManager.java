package services;

import Logger.Logger;
import task.Task;
import java.util.*;

public class TaskManager {
  // Stores all tasks
  private List<Task> tasks = new ArrayList<>();
  // Shared logger to log all actions
  private Logger logger = Logger.getInstance();

  // Method to add a new task
  public void addTask(Task task){
    tasks.add(task);
    logger.log("INFO", "Task added: " + task.getDescription() + "(Assigned to: " + task.getAssignedTo() + ")");
  }

  //complete a existing task
  public void completeTask(int index){
    if(index < tasks.size()){
      Task task = tasks.get(index);
      task.completeTask();
      logger.log("SUCCESS","Task Completed: " + task.getDescription());
    }
    else{
      logger.log("ERROR", "Inavalid task index:" + index);
    }
  }

  //Display all taska
  public void showTasks(){
    logger.log("INFO", "Displaying all tasks:");
    for(int i = 0 ;i < tasks.size() ;i++){
      Task t = tasks.get(i);
      System.out.println((i+1) + ". " + t.getDescription() + "| Assigned to: " + t.getAssignedTo() + " | Status: " + t.getStatus());
    }
  }
}
