import Logger.Logger;
import services.TaskManager;
import task.Task;
import task.TaskNotFoundException;

public class Main {
  public static void main(String[] args){

    Logger logger = Logger.getInstance();
    // Create TaskManager object
    TaskManager taskManager = new TaskManager();
    // logger.log("INFO"," Application Started Yeah :)");

    taskManager.loadTasksFromFile();
    CLI cli = new CLI(taskManager, logger);
    cli.start();

    
    // // Add Tasks
    // taskManager.addTask(new Task("Complete JAVA OOPS exercise","Akshaya"));
    // taskManager.addTask(new Task("Prepare yourself for JAVA based interview", "Akshaya"));

    // // Show tasks
    // taskManager.showTasks();

    // // Complete first task
    // try {
    //   taskManager.completeTask(0);
    // } catch (TaskNotFoundException e) {
    //   logger.log("ERROR", e.getMessage());
    // }  

    // // Remove a task
    // // taskManager.removeTask(0);

    // // Show Tasks again for verification
    // taskManager.showTasks();

    // logger.log("INFO", " Application stopped :(");
    logger.addLogEnd();
  }
}
