package task;

public class Task {
  //What is the task about?
  private String description;
  // Who will handle it?
  private String assignedTo;
  //Current status : Pending or Completed
  private String status;

  // Constructor to initialize task
  public Task(String description, String assignedTo){
    this.description = description;
    this.assignedTo = assignedTo;
    this.status = "Pending";
  }

  // public getters (with read only access)
  public String getDescription(){
    return description;
  }
  public String getAssignedTo(){
    return assignedTo;
  }
  public String getStatus(){
    return status;
  }

  //public method to change state safely
  public void completeTask(){
    this.status = "Completed";
  }
}
