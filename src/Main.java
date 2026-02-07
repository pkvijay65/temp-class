import inheritance.*;
import polymorphism.*;

// Main entry point - Run all demos
public class Main {

    public static void main(String[] args) {

        Document document = new Document();
        String xy = document.toString();
        Document duplicateDocument = document.duplicate();


        Document pdfDOcument = new PDFDocument();
        Document duplicatePdf = pdfDOcument.duplicate();


        Payment payment = new UPIPayment(10, "abc");
//        Payment payment = new CreditCardPayment(8, "abc");
        payment.process();
        payment.upiSpecificMethod();


        //all good
        UPIPayment upiPayment = new UPIPayment(20, "abc");
        upiPayment.process();
        upiPayment.upiSpecificMethod();

        CreditCardPayment creditCardPayment = new CreditCardPayment(80, "ahfbik");
        creditCardPayment.process();

//not going to happen
//        UPIPayment upiPayment2 = new Payment(50);
//        upiPayment2.upiSpecificMethod();






//        demo1_BasicInheritance();
//        demo2_ConstructorChaining();
//        demo3_MethodOverriding();
//        demo4_Polymorphism();
    }

    static void demo1_BasicInheritance() {
        System.out.println("=== DEMO 1: Basic Inheritance ===\n");

        Customer customer = new Customer("Alice", "alice@mail.com", "123 Main St");
        customer.login();     // Inherited + overridden
        customer.placeOrder(); // Customer's own method
        customer.logout();    // Inherited from User

        System.out.println();
    }

    static void demo2_ConstructorChaining() {
        System.out.println("=== DEMO 2: Constructor Chaining ===\n");
        System.out.println("Watch the order - Parent constructor runs FIRST!\n");

        // Run: constructorchain.ConstructorChainDemo
        System.out.println("(See ConstructorChainDemo.java for full example)\n");
    }

    static void demo3_MethodOverriding() {
        System.out.println("=== DEMO 3: Method Overriding ===\n");

        User user = new User("Generic", "user@mail.com");
        Admin admin = new Admin("Super", "admin@mail.com");

        System.out.print("User permissions: ");
        user.getPermissions();

        System.out.print("Admin permissions: ");
        admin.getPermissions();

        System.out.println();
    }

    static void demo4_Polymorphism() {
        System.out.println("=== DEMO 4: Runtime Polymorphism ===\n");

        // Array of parent type holding different child objects
        User[] users = {
            new Customer("Alice", "a@mail.com", "Addr1"),
            new Seller("Bob", "b@mail.com", "Bob's Shop"),
            new Admin("Charlie", "c@mail.com")
        };

        System.out.println("Same method call, different behaviors:\n");

        for (User u : users) {
            System.out.print(u.getClass().getSimpleName() + " -> ");
            u.getPermissions();
        }

        System.out.println("\n=== Payment Example ===\n");

        Payment[] payments = {
            new CreditCardPayment(100, "1234567812345678"),
            new UPIPayment(100, "user@upi")
        };

        for (Payment p : payments) {
            p.process();
            System.out.println("Fee: $" + String.format("%.2f", p.calculateFee()));
            System.out.println();
        }
    }
}
