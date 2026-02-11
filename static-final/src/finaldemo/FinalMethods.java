package finaldemo;

/**
 * Final Methods Demo
 * - Prevents overriding in child classes
 * - Link to Inheritance & Polymorphism concepts
 * - Use cases: security, template methods
 */
public class FinalMethods {

    public static void main(String[] args) {
        System.out.println("=== Final Method - Prevents Overriding ===\n");

        BankAccount account = new SavingsAccount("SA001", 1000);
        account.deposit(500);
        System.out.println("Balance: $" + account.getBalance());

        // Even though we're using SavingsAccount, getBalance() is final
        // so it CANNOT be overridden to return fake values

        System.out.println("\n=== Template Method Pattern ===\n");

        DocumentProcessor pdfProcessor = new PDFProcessor();
        pdfProcessor.processDocument("report.pdf");

        System.out.println();

        DocumentProcessor wordProcessor = new WordProcessor();
        wordProcessor.processDocument("letter.docx");
    }
}

// ==================== EXAMPLE 1: Security-Critical Method ====================

class BankAccount {
    private String accountId;
    protected double balance;

    public BankAccount(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    // FINAL - Cannot be overridden! Ensures accurate balance reporting
    public final double getBalance() {
        return balance;
    }

    // Can be overridden - different account types may have different deposit rules
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        }
    }

    // FINAL - Critical audit method, must not be tampered
    public final String getAccountId() {
        return accountId;
    }
}

class SavingsAccount extends BankAccount {
    private static final double BONUS_RATE = 0.01;

    public SavingsAccount(String accountId, double balance) {
        super(accountId, balance);
    }

    // This is ALLOWED - deposit is not final
    @Override
    public void deposit(double amount) {
        double bonus = amount * BONUS_RATE;
        super.deposit(amount + bonus);
        System.out.println("Bonus added: $" + bonus);
    }

    // This would be ERROR - getBalance() is final
    // @Override
//     public double getBalance() {
//         return balance * 2;  // Fraudulent attempt blocked!
//     }
}

// ==================== EXAMPLE 2: Template Method Pattern ====================

abstract class DocumentProcessor {

    // FINAL template method - defines the algorithm skeleton
    // Child classes cannot change the process order
    public final void processDocument(String filename) {
        System.out.println("Processing: " + filename);
        validate(filename);
        parse();        // Abstract - child implements
        transform();    // Abstract - child implements
        save(filename);
        System.out.println("Complete: " + filename);
    }

    // Final - validation logic must not be bypassed
    private final void validate(String filename) {
        if (filename == null || filename.isEmpty()) {
            throw new IllegalArgumentException("Invalid filename");
        }
        System.out.println("  [✓] Validated");
    }

    // Abstract - each processor implements differently
    protected abstract void parse();
    protected abstract void transform();

    // Final - save logic is standard
    private final void save(String filename) {
        System.out.println("  [✓] Saved to disk");
    }
}

class PDFProcessor extends DocumentProcessor {
    @Override
    protected void parse() {
        System.out.println("  [✓] Parsed PDF structure");
    }

    @Override
    protected void transform() {
        System.out.println("  [✓] Applied PDF transformations");
    }
}

class WordProcessor extends DocumentProcessor {
    @Override
    protected void parse() {
        System.out.println("  [✓] Parsed Word document");
    }

    @Override
    protected void transform() {
        System.out.println("  [✓] Applied Word transformations");
    }
}
