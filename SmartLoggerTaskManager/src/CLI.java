
import java.util.Scanner;
import java.util.stream.Collectors;

import Logger.Logger;
import services.TaskManager;
import task.TaskStatus;
import task.Task;
import task.TaskNotFoundException;

public class CLI {
  
  private TaskManager taskManager;
  private Logger logger;
  private Scanner scanner;
  
  public CLI(TaskManager taskManager, Logger logger){
    this.taskManager = taskManager;
    this.logger = logger;
    this.scanner = new Scanner(System.in);
  }

  public void start() {
    logger.log("INFO" ," ---- CLI Started ---- ");
    int choice;

    do {
      System.out.println("\n===== Task Manager =====");
      System.out.println("1. Add Task");
      System.out.println("2. Complete Task");
      System.out.println("3. View All Tasks");
      System.out.println("4. View Pending Tasks");
      System.out.println("5. View Completed Tasks");
      System.out.println("6. Exit");
      System.out.print("Enter choice: ");
      choice = scanner.nextInt();
      scanner.nextLine();

      switch(choice) {
        case 1: addTask(); break;
        case 2: completeTask(); break;
        case 3: taskManager.showTasks(); break;
        case 4: showFilteredTasks(TaskStatus.Pending); break;
        case 5: showFilteredTasks(TaskStatus.Completed); break;
        case 6: logger.log("INFO", "Exiting CLI..."); break;
        default: System.out.println("❌ Invalid choice. Try again!");
      }
    } while(choice != 6);

    scanner.close();
  }

  private void addTask() {
    System.out.print("Enter task description: ");
    String description = scanner.nextLine();
    System.out.print("Assign to: ");
    String assignedTo = scanner.nextLine();

    Task task = new Task(description, assignedTo);
    taskManager.addTask(task);
  }

  private void completeTask() {
    taskManager.showTasks();
    System.out.print(" Enter task number to complete: ");
    int index = scanner.nextInt() - 1;

    try {
      taskManager.completeTask(index);
    } catch(TaskNotFoundException e) {
      logger.log("ERROR", e.getMessage());
    }
  }

  private void showFilteredTasks(TaskStatus status) {
    System.out.println("\n --- " + status + " Tasks ---");
    taskManager.getTasks().stream().filter(task -> task.getStatus() == status).collect(Collectors.toList()).forEach(task -> System.out.println("- " + task.getDescription() + " (Assigned to: )" + task.getAssignedTo() + ")"));
  }
}
