import Logger.Logger;

public class Main {
  public static void main(String[] args){

    // Single Logger instance initialized
    Logger logger1 = Logger.getInstance();
    logger1.log("INFO", "Application has started Akshaya");

    // Get Logger instance again
    Logger logger2 = Logger.getInstance();
    logger2.log("WARNING", "Low Disk Space");

    //Checking if singleton class is properly implemented (# 2 verificatio. methods)
    System.out.println("Logger objects same " + (logger1 == logger2)); // Method 1
    // Method 2
    System.out.println("Logger Hash:" + System.identityHashCode(logger1));
    System.out.println("Logger Hash:" + System.identityHashCode(logger2));
  }
}
