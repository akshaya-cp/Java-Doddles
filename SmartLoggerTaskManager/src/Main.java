import Logger.Logger;
import services.TaskManager;
import task.Task;

public class Main {
  public static void main(String[] args){

    //(Stage 1 Code)

    // // Single Logger instance initialized
    // Logger logger1 = Logger.getInstance();
    // logger1.log("INFO", "Application has started Akshaya");

    // // Get Logger instance again
    // Logger logger2 = Logger.getInstance();
    // logger2.log("WARNING", "Low Disk Space");

    // //Checking if singleton class is properly implemented (# 2 verificatio. methods)
    // System.out.println("Logger objects same " + (logger1 == logger2)); // Method 1
    // // Method 2
    // System.out.println("Logger Hash:" + System.identityHashCode(logger1));
    // System.out.println("Logger Hash:" + System.identityHashCode(logger2));

    //(Stage 2 Code)

    Logger logger = Logger.getInstance();
    logger.log("INFO"," Application Started Yeah :)");

    // Create TaskManager object
    TaskManager taskManager = new TaskManager();

    // Add Tasks
    taskManager.addTask(new Task("Complete JAVA OOPS exercise","Akshaya"));
    taskManager.addTask(new Task("Prepare yourself for JAVA based interview", "Akshaya"));

    // Show tasks
    taskManager.showTasks();

    // Complete first task
    taskManager.completeTask(0);

    // Remove a task
    taskManager.removeTask(0);

    // Show Tasks again for verification
    taskManager.showTasks();

    logger.log("INFO", " Application stopped :(");
  }
}
