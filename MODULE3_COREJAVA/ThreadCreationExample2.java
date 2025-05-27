// Thread 2: Implementing the Runnable interface
class MyRunnable implements Runnable {
    private String threadName;
    private int printCount;

    // Constructor to give the task a name
    public MyRunnable(String name, int count) {
        this.threadName = name;
        this.printCount = count;
        System.out.println("Creating Runnable task: " + threadName);
    }

    // The run() method contains the code that the task will execute
    @Override
    public void run() {
        System.out.println("Running task: " + threadName);
        try {
            for (int i = 1; i <= printCount; i++) {
                System.out.println("Runnable Task: " + threadName + ", Message " + i);
                // Pause thread for a short period
                Thread.sleep(70); // Sleep for 70 milliseconds
            }
        } catch (InterruptedException e) {
            System.out.println("Runnable task " + threadName + " interrupted.");
        }
        System.out.println("Runnable task " + threadName + " exiting.");
    }
}

public class ThreadCreationExample2 {
    public static void main(String[] args) {
        System.out.println("--- Thread Creation Example (Implementing Runnable) ---");

        // Create instances of MyRunnable (the tasks)
        MyRunnable runnable1 = new MyRunnable("Task-X", 6);
        MyRunnable runnable2 = new MyRunnable("Task-Y", 8);

        // Create Thread objects, passing the Runnable tasks to their constructors
        Thread threadA = new Thread(runnable1);
        Thread threadB = new Thread(runnable2);

        // Start the threads. This calls the run() method of the associated Runnable.
        threadA.start();
        threadB.start();

        System.out.println("Main thread finished starting Runnable-based threads.");
    }
}