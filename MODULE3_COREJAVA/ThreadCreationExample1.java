// Thread 1: Extending the Thread class
class MyThread extends Thread {
    private String threadName;
    private int printCount;

    // Constructor to give the thread a name
    public MyThread(String name, int count) {
        this.threadName = name;
        this.printCount = count;
        System.out.println("Creating " + threadName);
    }

    // The run() method contains the code that the thread will execute
    @Override
    public void run() {
        System.out.println("Running " + threadName);
        try {
            for (int i = 1; i <= printCount; i++) {
                System.out.println("Thread: " + threadName + ", Message " + i);
                // Pause thread for a short period to see interleaved output
                Thread.sleep(50); // Sleep for 50 milliseconds
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + " exiting.");
    }
}

public class ThreadCreationExample1 {
    public static void main(String[] args) {
        System.out.println("--- Thread Creation Example (Extending Thread) ---");

        // Create instances of MyThread
        MyThread thread1 = new MyThread("Thread-Alpha", 5);
        MyThread thread2 = new MyThread("Thread-Beta", 7);

        // Start the threads. This calls their run() methods.
        // The JVM schedules them to run concurrently.
        thread1.start();
        thread2.start();

        System.out.println("Main thread finished starting child threads.");
    }
}