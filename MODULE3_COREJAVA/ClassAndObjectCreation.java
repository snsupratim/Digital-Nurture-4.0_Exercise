// Define the Car class
class Car {
    // Attributes (instance variables)
    String make;
    String model;
    int year;
    String color; // Adding another attribute for more detail

    // Constructor: A special method used to initialize objects of the class
    // It has the same name as the class and no return type.
    public Car(String make, String model, int year, String color) {
        this.make = make;      // 'this.make' refers to the instance variable, 'make' refers to the parameter
        this.model = model;
        this.year = year;
        this.color = color;
        System.out.println("A new " + year + " " + make + " " + model + " (" + color + ") object created!");
    }

    // Method to display car details
    public void displayDetails() {
        System.out.println("--- Car Details ---");
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Color: " + color);
        System.out.println("-------------------");
    }

    // You can add more methods, e.g., to simulate car actions
    public void startEngine() {
        System.out.println(make + " " + model + "'s engine started!");
    }

    public void stopEngine() {
        System.out.println(make + " " + model + "'s engine stopped.");
    }
}

// Main class to create and use Car objects
public class ClassAndObjectCreation {

    public static void main(String[] args) {
        System.out.println("Java Class and Object Creation Demonstration");
        System.out.println("------------------------------------------");

        // 1. Create the first Car object (instance of the Car class)
        // 'new Car(...)' calls the constructor of the Car class
        Car car1 = new Car("Toyota", "Camry", 2022, "Silver");

        // 2. Call the method on car1 object to display its details
        car1.displayDetails();
        car1.startEngine();
        System.out.println(); // Blank line for separation

        // 3. Create a second Car object
        Car car2 = new Car("Honda", "Civic", 2023, "Blue");

        // 4. Call the method on car2 object
        car2.displayDetails();
        car2.stopEngine();
        System.out.println();

        // 5. Create a third Car object
        Car car3 = new Car("Ford", "Mustang", 2024, "Red");
        car3.displayDetails();
        System.out.println();

        // You can also access and modify attributes directly (if they are public)
        System.out.println("Changing " + car1.make + " " + car1.model + "'s year...");
        car1.year = 2025; // Directly changing an attribute
        car1.displayDetails(); // Display updated details
    }
}