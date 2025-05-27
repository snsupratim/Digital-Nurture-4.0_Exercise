// Base Class (Parent Class or Superclass)
class Animal {
    String name; // An attribute for the animal's name

    public Animal(String name) {
        this.name = name;
    }

    // Method in the base class
    public void makeSound() {
        System.out.println(name + " makes a generic animal sound.");
    }

    public void eat() {
        System.out.println(name + " is eating.");
    }
}

// Subclass (Child Class or Derived Class) that inherits from Animal
// 'extends' keyword signifies inheritance
class Dog extends Animal {
    String breed; // Additional attribute specific to Dog

    // Constructor for Dog class
    // It calls the superclass constructor using 'super()'
    public Dog(String name, String breed) {
        super(name); // Call the constructor of the Animal class to initialize 'name'
        this.breed = breed; // Initialize Dog's specific attribute
    }

    // Method Overriding:
    // The Dog class provides its own implementation of makeSound()
    // It overrides the makeSound() method inherited from the Animal class.
    @Override // This annotation is optional but good practice to indicate overriding
    public void makeSound() {
        System.out.println(name + " (a " + breed + ") barks: Woof! Woof!");
    }

    // Dog-specific method
    public void fetch() {
        System.out.println(name + " is fetching the ball.");
    }
}

// Main class to demonstrate inheritance
public class InheritanceExample {

    public static void main(String[] args) {
        System.out.println("Java Inheritance Demonstration");
        System.out.println("------------------------------");

        // 1. Instantiate an Animal object
        Animal genericAnimal = new Animal("Buddy the Animal");
        System.out.println("Calling methods on Animal object:");
        genericAnimal.makeSound(); // Calls Animal's makeSound()
        genericAnimal.eat();
        System.out.println();

        // 2. Instantiate a Dog object
        Dog myDog = new Dog("Max", "Golden Retriever");
        System.out.println("Calling methods on Dog object:");
        myDog.makeSound(); // Calls Dog's OVERRIDDEN makeSound()
        myDog.eat();       // Calls Animal's eat() (inherited)
        myDog.fetch();     // Calls Dog's specific fetch()
        System.out.println();

        // Polymorphism in action (related to inheritance)
        // An Animal reference can point to a Dog object
        Animal polymorphicAnimal = new Dog("Lucy", "Labrador");
        System.out.println("Calling methods via Animal reference to Dog object:");
        polymorphicAnimal.makeSound(); // Still calls Dog's OVERRIDDEN makeSound()
        polymorphicAnimal.eat();       // Calls Animal's eat()
        // polymorphicAnimal.fetch(); // This would cause a compile-time error
        // because the reference type is Animal,
        // and Animal doesn't have a fetch() method.
        // Even though the object is a Dog, the compiler
        // only sees methods defined in the Animal class for 'polymorphicAnimal'.
        System.out.println();
    }
}