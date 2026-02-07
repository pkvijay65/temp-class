//package gotchas;
//
//// Collection of common interview gotchas about Inheritance & Polymorphism
//
//public class InterviewGotchas {
//
//    public static void main(String[] args) {
//        System.out.println("=== GOTCHA 1: Covariant Return Type ===");
//        gotcha1_CovariantReturn();
//
//        System.out.println("\n=== GOTCHA 2: Private Method Not Overridden ===");
//        gotcha2_PrivateMethod();
//
//        System.out.println("\n=== GOTCHA 3: Static Method Hiding ===");
//        gotcha3_StaticHiding();
//
//        System.out.println("\n=== GOTCHA 4: Reference vs Object Type ===");
//        gotcha4_ReferenceVsObject();
//    }
//
//    // GOTCHA 1: Covariant return type
//    static void gotcha1_CovariantReturn() {
//        Dog dog = new Dog();
//        Dog clonedDog = dog.clone();  // Returns Dog, not Animal!
//        System.out.println("Cloned: " + clonedDog.getClass().getSimpleName());
//    }
//
//    // GOTCHA 2: Private methods cannot be overridden
//    static void gotcha2_PrivateMethod() {
//        ParentPrivate p = new ChildPrivate();
//        p.callSecret();  // Calls PARENT's secret(), not child's!
//    }
//
//    // GOTCHA 3: Static methods are hidden, not overridden
//    static void gotcha3_StaticHiding() {
//        ParentStatic p = new ChildStatic();
//        p.staticMethod();  // Calls PARENT's static method!
//
//        ChildStatic c = new ChildStatic();
//        c.staticMethod();  // Calls CHILD's static method
//    }
//
//    // GOTCHA 4: Reference type vs Object type
//    static void gotcha4_ReferenceVsObject() {
//        Parent p = new Child();
//        p.show();  // Output: "Child" - Object type determines behavior
//
//        // p.childOnlyMethod();  // WON'T COMPILE - Reference type limits what you can call
//    }
//}
//
//// Supporting classes for GOTCHA 1
//class Animal {
//    Animal clone() {
//        System.out.println("Cloning Animal");
//        return new Animal();
//    }
//}
//
//class Dog extends Animal {
//    @Override
//    Dog clone() {  // Covariant return - Dog instead of Animal
//        System.out.println("Cloning Dog");
//        return new Dog();
//    }
//}
//
//// Supporting classes for GOTCHA 2
//class ParentPrivate {
//    private void secret() {
//        System.out.println("Parent's secret");
//    }
//
//    public void callSecret() {
//        secret();
//    }
//}
//
//class ChildPrivate extends ParentPrivate {
//    // This is NOT overriding - it's a completely NEW method
//    private void secret() {
//        System.out.println("Child's secret");
//    }
//}
//
//// Supporting classes for GOTCHA 3
//class ParentStatic {
//    static void staticMethod() {
//        System.out.println("Parent static");
//    }
//}
//
//class ChildStatic extends ParentStatic {
//    // This HIDES parent's static method, doesn't override it
//    static void staticMethod() {
//        System.out.println("Child static");
//    }
//}
//
//// Supporting classes for GOTCHA 4
//class Parent {
//    void show() {
//        System.out.println("Parent");
//    }
//}
//
//class Child extends Parent {
//    @Override
//    void show() {
//        System.out.println("Child");
//    }
//
//    void childOnlyMethod() {
//        System.out.println("Only in Child");
//    }
//}
