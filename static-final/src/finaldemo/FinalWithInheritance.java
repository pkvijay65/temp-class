package finaldemo;

/**
 * Final Keyword with Inheritance & Polymorphism
 * - How final interacts with extends
 * - final method vs overriding
 * - final class vs inheritance
 * - Abstract + Final contradiction
 */
public class FinalWithInheritance {

    public static void main(String[] args) {
        System.out.println("=== Final Method Prevents Overriding ===\n");

        Vehicle car = new Car();
        car.start();
        car.getVIN();  // Cannot be overridden - always returns real VIN

        System.out.println("\n=== Polymorphism Still Works ===\n");

        Vehicle[] vehicles = {new Car(), new Motorcycle()};
        for (Vehicle v : vehicles) {
            v.start();  // Polymorphic call - each type starts differently
            // v.getVIN() - Always calls Vehicle's version (final)
        }

        System.out.println("\n=== What Combinations Are Invalid? ===\n");
        System.out.println("abstract + final class  : INVALID (contradictory)");
        System.out.println("abstract + final method : INVALID (contradictory)");
        System.out.println("final class + final method : VALID (but method final is redundant)");
        System.out.println("interface + final method : INVALID (interface methods must be implemented)");
    }
}

// ==================== FINAL METHOD IN INHERITANCE ====================

abstract class Vehicle {
    private String vin;

    public Vehicle() {
        this.vin = "VIN" + System.currentTimeMillis();
    }

    // Abstract - MUST be overridden
    public abstract void start();

    // Final - CANNOT be overridden (security-critical)
    public final String getVIN() {
        return vin;
    }

    // Regular method - CAN be overridden
    public void honk() {
        System.out.println("Beep beep!");
    }
}

final class Car extends Vehicle {
    @Override
    public void start() {
        System.out.println("Car: Turn key, engine starts");
    }

    @Override
    public void honk() {
        System.out.println("Car: HONK HONK!");
    }

    // This would cause ERROR:
    // @Override
    // public String getVIN() {
    //     return "FAKE-VIN";  // Cannot override final method!
    // }
}



class Motorcycle extends Vehicle {
    @Override
    public void start() {
        System.out.println("Motorcycle: Kick start, vroom!");
    }
}

// ==================== INVALID COMBINATIONS ====================

// ERROR: Abstract class cannot be final
// abstract final class AbstractFinal { }  // Contradiction!
// Reason: abstract = must extend, final = cannot extend

// ERROR: Abstract method cannot be final
// abstract class Example {
//     abstract final void doSomething();  // Contradiction!
// }
// Reason: abstract = must override, final = cannot override

// VALID but redundant: Final class with final methods
final class SecureClass {
    // This final is redundant - class is already final, so nothing can extend it
    public final void secureMethod() {
        System.out.println("Secure operation");
    }
}

// ==================== FINAL IN INTERFACE CONTEXT ====================

interface Printable {
    void print();  // Abstract by default

    // In interface, methods cannot be final
    // final void stamp();  // ERROR! Interface methods cannot be final

    // Default methods also cannot be final
    default void preview() {
        System.out.println("Preview");
    }
    // default final void preview() { }  // ERROR!
}

// Interface fields are implicitly public static final
interface Constants {
    int MAX_SIZE = 100;        // Implicitly: public static final int MAX_SIZE = 100
    String VERSION = "1.0";   // Implicitly: public static final String VERSION = "1.0"
}
