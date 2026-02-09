package abstractclass;

/**
 * Demo class showing abstract class usage.
 */
public class AbstractClassDemo {
    public static void main(String[] args) {
        System.out.println("=== Abstract Class Demo ===\n");

        // Cannot instantiate abstract class
        // Payment p = new Payment(100); // Compilation error!

        // 1. Payment System Example
        System.out.println("--- Payment System ---");

        Payment creditCard = new CreditCardPayment(100.00, "4532015112830366", "John Doe");
        Payment upi = new UPIPayment(50.00, "john@upi");

        // Polymorphism in action
        processPayment(creditCard);
        System.out.println();
        processPayment(upi);

        System.out.println("\n--- Document Export Example ---");

        // 2. Template Method Pattern Example
        DocumentExporter pdfExporter = new PDFExporter("Hello, World!", "Alice");
        pdfExporter.export("document.pdf");

        System.out.println();

        DocumentExporter htmlExporter = new HTMLExporter("Hello, World!", "Bob");
        htmlExporter.export("document.html");
    }

    // Method accepting abstract type - works with any Payment subclass
    public static void processPayment(Payment payment) {
        System.out.println("Processing payment of $" + payment.getAmount());
        payment.process();
        payment.printReceipt();
    }
}
