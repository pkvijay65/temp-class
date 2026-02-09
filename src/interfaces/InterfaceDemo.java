package interfaces;

/**
 * Demo class showing various interface concepts.
 */
public class InterfaceDemo {
    public static void main(String[] args) {
        System.out.println("=== Interface Demo ===\n");

        // 1. Basic Interface Implementation
        System.out.println("--- Payment System (Interface) ---");
        Payable wallet = new Wallet("W001", 500.00);
        Payable bankAccount = new BankAccount("1234567890", "HDFC Bank", 10000.00);

        // Using interface static method
        System.out.println("Max transaction limit: " + Payable.formatCurrency(Payable.MAX_TRANSACTION_LIMIT));
        System.out.println();

        // Polymorphism with interfaces
        processPayment(wallet, 100.00);
        System.out.println();
        processPayment(bankAccount, 500.00);

        // 2. Multiple Interface Implementation
        System.out.println("\n--- Multiple Interfaces (Printer) ---");
        AllInOnePrinter allInOne = new AllInOnePrinter("HP OfficeJet Pro");
        BasicPrinter basic = new BasicPrinter("Canon PIXMA");

        // Using Printable reference
        Printable printer = allInOne;
        printer.print("Test document");
        printer.printMultiple("Report", 2);

        System.out.println();

        // Using Scannable reference
        Scannable scanner = allInOne;
        String scannedContent = scanner.scanWithResolution(300);
        System.out.println("Scanned: " + scannedContent);

        // 3. Default Method with Multiple Interfaces
        System.out.println("\n--- Refundable Interface ---");
        Wallet refundableWallet = new Wallet("W002", 1000.00);
        refundableWallet.printRefundPolicy(); // Using default method
        refundableWallet.processRefund(50.00);

        // 4. Functional Interface with Lambda
        System.out.println("\n--- Functional Interface (Lambda) ---");

        // Traditional anonymous class
        Calculator addTraditional = new Calculator() {
            @Override
            public int calculate(int a, int b) {
                return a + b;
            }
        };

        // Lambda expression - much cleaner!
        Calculator add = (a, b) -> a + b;
        Calculator subtract = (a, b) -> a - b;
        Calculator multiply = (a, b) -> a * b;
        Calculator divide = (a, b) -> b != 0 ? a / b : 0;

        System.out.println("10 + 5 = " + add.calculate(10, 5));
        System.out.println("10 - 5 = " + subtract.calculate(10, 5));
        System.out.println("10 * 5 = " + multiply.calculate(10, 5));
        System.out.println("10 / 5 = " + divide.calculate(10, 5));

        // Using default method
        System.out.println("(10 + 5) * 2 = " + add.calculateAndDouble(10, 5));

        // Using static method
        Calculator.printResult(add.calculate(100, 200));

        // 5. Marker Interface
        System.out.println("\n--- Marker Interface ---");
        TempFile temp = new TempFile("cache.tmp");
        String permanentFile = "important.doc";

        cleanupIfDeletable(temp);
        // cleanupIfDeletable(permanentFile); // Won't work - String doesn't implement Deletable

        // 6. Interface Inheritance
        System.out.println("\n--- Interface Inheritance ---");
        FileHandler fileHandler = new FileHandler("data.txt");
        fileHandler.write("Hello, World!");
        String content = fileHandler.read();
        System.out.println("Content: " + content);
        fileHandler.copy(); // Uses default method from ReadWritable
    }

    // Method accepting interface type - works with any Payable
    public static void processPayment(Payable source, double amount) {
        System.out.println("Current balance: " + Payable.formatCurrency(source.getBalance()));
        if (source.canPay(amount)) {
            source.pay(amount);
        } else {
            System.out.println("Cannot process payment of " + Payable.formatCurrency(amount));
        }
    }

    // Using marker interface to check capability
    public static void cleanupIfDeletable(Object obj) {
        if (obj instanceof Deletable) {
            System.out.println("Object " + obj + " is deletable - cleaning up");
            // Perform deletion
        } else {
            System.out.println("Object is NOT deletable - skipping");
        }
    }
}
