package singleton;

public class Logger {
    // Step 1: Create a private static instance of the class
    private static Logger instance;

    // Step 2: Make the constructor private
    private Logger() {
        System.out.println("Logger initialized.");
    }

    // Step 3: Provide a public static method to get the instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Example method to simulate logging
    public void log(String message) {
        System.out.println("[LOG]: " + message);
    }
}

class SingletonTest {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("This is the first log message.");

        Logger logger2 = Logger.getInstance();
        logger2.log("This is the second log message.");

        // Check if both logger1 and logger2 refer to the same object
        if (logger1 == logger2) {
            System.out.println("Both logger instances are the same (singleton works).");
        } else {
            System.out.println("Different instances exist (singleton failed).");
        }
    }
}
