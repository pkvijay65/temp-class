package interfaces;

/**
 * Functional Interface - has exactly ONE abstract method.
 * Can be used with lambda expressions.
 */
@FunctionalInterface
public interface Calculator {
    int calculate(int a, int b);

    // Default methods don't count against the single abstract method rule
    default int calculateAndDouble(int a, int b) {
        return calculate(a, b) * 2;
    }

    // Static methods don't count either
    static void printResult(int result) {
        System.out.println("Result: " + result);
    }
}
