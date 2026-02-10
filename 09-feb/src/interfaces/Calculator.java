package interfaces;

/**
 * Functional Interface - has exactly ONE abstract method.
 * Can be used with lambda expressions.
 */
public interface Calculator {
    int calculate(int a, int b);

    void delete();

    default void print(){
        System.out.println("This is a deletable");
    }
}
