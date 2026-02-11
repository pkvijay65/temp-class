package interfaces;

/**
 * LEARNING OUTCOME: Functional Interface
 *
 * A functional interface has exactly ONE abstract method.
 * This allows it to be used with lambda expressions.
 *
 * The @FunctionalInterface annotation is optional but recommended -
 * it makes the compiler verify there's exactly one abstract method.
 */
@FunctionalInterface
public interface Calculator {

    double pi = 3.14;

    // The ONE abstract method - this is what lambdas implement
    int calculate(int a, int b);

    // Default methods don't count - you can have as many as you want
    default int calculateAndDouble(int a, int b) {
        return calculate(a, b) * 2;
    }

    // Static methods don't count either
    static void printResult(int result) {
        System.out.println("Result: " + result);
    }
}
