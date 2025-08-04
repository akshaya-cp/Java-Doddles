package services;

import Logger.Logger;
import task.Task;
import task.TaskNotFoundException;
import task.TaskStatus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class TaskManager {
  // Stores all tasks
  private List<Task> tasks = new ArrayList<>();
  // Shared logger to log all actions
  private Logger logger = Logger.getInstance();

  private static final String TASK_FILE = "SmartLoggerTaskManager/data/tasks.txt";

  // Method to add a new task
  public void addTask(Task task){
    tasks.add(task);
    logger.log("INFO", "Task added: " + task.getDescription() + "(Assigned to: " + task.getAssignedTo() + ")");
    saveTaskToFile();
  }

  //complete a existing task
  public void completeTask(int index) throws TaskNotFoundException{
    if(index < tasks.size()){
      Task task = tasks.get(index);
      if(task.getStatus() != TaskStatus.Completed){
        task.completeTask();
        logger.log("SUCCESS","Task Completed: " + task.getDescription());
        saveTaskToFile();
      }else{
        logger.log("WARNING","Task already completed: " + task.getDescription());
      }
      
    }
    else{
      throw new TaskNotFoundException("Task index " + index + " not found!");
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

  //Save Task to File
  private void saveTaskToFile(){
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(TASK_FILE))){
      for (Task t : tasks){
        // Format : description;assignedTo;status
        writer.write(t.getDescription() + ";" + t.getAssignedTo() + ";" + t.getStatus());
        writer.newLine();
      }
      logger.log("INFO", "Tasks saved to file");
    }catch (IOException e){
      logger.log("ERROR", "Failed to save tasks:" + e.getMessage());
    }
  }

  public void loadTasksFromFile() {
    tasks.clear();
    try (BufferedReader reader = new BufferedReader(new FileReader(TASK_FILE))){
      String line;
      while((line = reader.readLine()) != null){
        String[] parts = line.split(";");
        if(parts.length == 3){
          Task task = new Task(parts[0], parts[1]);
          if(parts[2].equals("Completed")) task.completeTask();
          tasks.add(task);
        }
      }
      logger.log("INFO", "Tasks loaded from file.");
    }catch(FileNotFoundException e){
      logger.log("WARNING", "No tasks file found (first run).");
    }catch (IOException e){
      logger.log("ERROR", "Error loading tasks: " + e.getMessage());
    }
  }

  //Remove a task
  public void removeTask(int index){
    Task t = tasks.get(index);
    tasks.remove(index);
    logger.log("INFO","Removed task : " + t.getDescription() + ", Assigned to : " + t.getAssignedTo() + ", Status :  "+ t.getStatus());

  }

  public List<Task> getTasks() {
    return tasks; // For filtering in CLI
  }
}
