package polymorphism;

// Method Overloading - Compile-time Polymorphism
public class Calculator {

    // Overloaded methods - same name, different parameters

    int add(int a, int b) {
        System.out.println("add(int, int) called");
        return a + b;
    }

    double add(double a, double b) {
        System.out.println("add(double, double) called");
        return a + b;
    }

    int add(int a, int b, int c) {
        System.out.println("add(int, int, int) called");
        return a + b + c;
    }

    // This would NOT compile - return type alone is not enough!
    // double add(int a, int b) { return a + b; }

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        System.out.println("Result: " + calc.add(5, 3));
        System.out.println();

        System.out.println("Result: " + calc.add(5.5, 3.2));
        System.out.println();

        System.out.println("Result: " + calc.add(1, 2, 3));
    }
}
