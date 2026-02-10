package constructorchain;

// Demonstrates constructor chaining in inheritance
// Output order: A -> B -> C (parent first!)

class A {
    A() {
        System.out.println("A constructor");
    }
}

class B extends A {
    B() {
        // super() is automatically inserted here by compiler
        System.out.println("B constructor");
    }
}

class C extends B {
    C() {
        // super() is automatically inserted here by compiler
        System.out.println("C constructor");
    }
}

public class ConstructorChainDemo {
    public static void main(String[] args) {
        System.out.println("Creating new C():");
        System.out.println("---");
        C c = new C();

    }
}
