package Logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
  //Static variable to hold one single instance of  Logger
  private static Logger instance;  
  
  //Formatter for timestamp
  private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

  // Private Constructor --> so no one can create Logger objects using new Logger()
  private Logger(){
    System.out.println("Logger Initialized Yeaah!!");
  }

  // public method to create single Logger instance
  // Synchronised used to make it thread-safe(in case of multiple thread accessing it at the same time)
  public static synchronized Logger getInstance(){
    if(instance == null){
      instance = new Logger();
    }
    return instance;
  }

  // Log method to print log messages with a timestamp and a level --> info, warning, error
  public void log(String level, String message){
    String timestamp = LocalDateTime.now().format(formatter);
    System.out.println("[" + timestamp + "] [" + level.toUpperCase() + "]" + message); 
  }
}
