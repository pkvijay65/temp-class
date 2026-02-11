package finaldemo;

/**
 * LEARNING OUTCOME: Final Variables
 *
 * A final variable can only be assigned ONCE.
 * Must be initialized: at declaration OR in constructor.
 */
public class FinalVariable {
    int x = 0;                  // Regular variable - can reassign
    final int y;                // Final variable - must init in constructor

    FinalVariable(int x, int y) {
        this.x = x;
        this.y = y;             // OK - first assignment in constructor
    }

    void demo() {
        x = 100;                // OK - regular variable can be reassigned
        // y = 200;             // ERROR - final variable cannot be reassigned
    }
}
