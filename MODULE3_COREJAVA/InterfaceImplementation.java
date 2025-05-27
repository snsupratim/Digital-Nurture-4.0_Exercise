// 1. Define the Interface
interface Playable {
    // An interface method is implicitly public and abstract
    void play(); // Method signature, no implementation here
}

// 2. Implement the Interface in the Guitar class
class Guitar implements Playable {
    private String type; // Attribute specific to Guitar

    public Guitar(String type) {
        this.type = type;
    }

    // Provide the implementation for the play() method from the Playable interface
    @Override // Annotation to indicate that this method overrides an interface method
    public void play() {
        System.out.println("The " + type + " Guitar is strumming a melody.");
    }

    // Guitar-specific method
    public void tune() {
        System.out.println("Tuning the " + type + " Guitar.");
    }
}

// 3. Implement the Interface in the Piano class
class Piano implements Playable {
    private int numberOfKeys; // Attribute specific to Piano

    public Piano(int numberOfKeys) {
        this.numberOfKeys = numberOfKeys;
    }

    // Provide the implementation for the play() method from the Playable interface
    @Override
    public void play() {
        System.out.println("The " + numberOfKeys + "-key Piano is playing a classical piece.");
    }

    // Piano-specific method
    public void pressPedal() {
        System.out.println("Pressing the sustain pedal on the " + numberOfKeys + "-key Piano.");
    }
}

// Main class to demonstrate interface implementation
public class InterfaceImplementation {

    public static void main(String[] args) {
        System.out.println("Java Interface Implementation Demonstration");
        System.out.println("-----------------------------------------");

        // 1. Instantiate objects of classes that implement Playable
        Guitar acousticGuitar = new Guitar("Acoustic");
        Piano grandPiano = new Piano(88);

        // 2. Call the play() method on each object
        System.out.println("Playing instruments directly:");
        acousticGuitar.play(); // Calls Guitar's play()
        acousticGuitar.tune(); // Calls Guitar's specific method
        System.out.println();

        grandPiano.play();     // Calls Piano's play()
        grandPiano.pressPedal(); // Calls Piano's specific method
        System.out.println();

        // 3. Demonstrate Polymorphism with Interfaces:
        // A variable of interface type can refer to any object that implements that interface.
        System.out.println("Playing instruments polymorphically via Playable interface:");
        Playable instrument1 = new Guitar("Electric");
        Playable instrument2 = new Piano(61);

        instrument1.play(); // Calls Guitar's play() implementation
        instrument2.play(); // Calls Piano's play() implementation

        // Note: You cannot call Guitar-specific methods (like tune()) on instrument1
        // because the reference type is Playable, which doesn't have a tune() method.
        // To do so, you'd need to cast: ((Guitar)instrument1).tune();
    }
}