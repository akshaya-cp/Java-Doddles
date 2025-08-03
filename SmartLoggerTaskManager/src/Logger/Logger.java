package Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
  //(Stage 3) code
  private static Logger instance;
  private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
  private static final String LOG_FILE = "SmartLoggerTaskManager/data/logs.txt";


  private Logger(){
    // Ensuring 'data folder exists for log'
    File folder = new File("SmartLoggerTaskManager/data");
    if(!folder.exists()){
      folder.mkdirs();
      System.out.println(" 'data' folder created for logs.");
    }
    System.out.println(" Logger Initialized ");

    //addind heading to separate iterations of the logs
    addLogHeading();
  }

  // Getting signleton instance
  public static synchronized Logger getInstance(){
    if(instance == null){
      instance = new Logger();
    }
    return instance;
  }

  //Add heading at the start of every log collection
  private void addLogHeading(){
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE,true))){
      writer.write("\n-------LOG START: "+ LocalDateTime.now().format(formatter) + " ------");
      writer.newLine();
    } catch (IOException e){
      System.err.println(" Error writing log heading: " + e.getMessage());
    }
    System.out.println(" New log section started!");
  }

  // Add end line after profgram finishes
  public void addLogEnd() {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))){
      writer.write("----- LOG END -----");
      writer.newLine();
    } catch(IOException e){
      System.err.println(" Error writing log end: "+ e.getMessage());
    }
  }

  // Log method : writes to console + file
  public void log(String level, String message){
    String timestamp = LocalDateTime.now().format(formatter);
    String logEntry = "[" + timestamp + "] [" + level.toUpperCase() + "] " + message;

    System.out.println(logEntry);

    // Append log entry to logs.txt
    try(BufferedWriter writer = new BufferedWriter(new  FileWriter(LOG_FILE, true))){
      writer.write(logEntry);
      writer.newLine();   // Move to next line
    } catch (IOException e){
      System.err.println("Error writing log to file: " + e.getMessage());
    }
  }
}
