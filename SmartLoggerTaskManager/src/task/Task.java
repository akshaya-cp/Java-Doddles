package task;

public class Task {
  //What is the task about?
  private String description;
  // Who will handle it?
  private String assignedTo;
  //Current status : Pending or Completed
  private TaskStatus status;

  // Constructor to initialize task
  public Task(String description, String assignedTo){
    this.description = description;
    this.assignedTo = assignedTo;
    this.status = TaskStatus.Pending;
  }

  // public getters (with read only access)
  public String getDescription(){
    return description;
  }
  public String getAssignedTo(){
    return assignedTo;
  }
  public TaskStatus getStatus(){
    return status;
  }

  //public method to change state safely
  public void completeTask(){
    this.status = TaskStatus.Completed;
  }
}
