package finaldemo;

/**
 * Final Classes Demo
 * - Cannot be extended (no inheritance)
 * - Use cases: Immutability, Security, Utility classes
 * - Link to Inheritance concepts
 */
public class FinalClasses {

    public static void main(String[] args) {
        System.out.println("=== Final Class - Cannot Be Extended ===\n");

        // Using immutable configuration
        ImmutableConfig config = new ImmutableConfig("production", "https://api.example.com");
        System.out.println("Environment: " + config.getEnvironment());
        System.out.println("API URL: " + config.getApiUrl());

        // Cannot modify after creation - true immutability
        // config.setEnvironment("dev");  // No such method exists!

        System.out.println("\n=== Utility Class (Cannot Extend) ===\n");
        System.out.println("5 + 3 = " + MathHelper.add(5, 3));
        System.out.println("max(10, 7) = " + MathHelper.max(10, 7));
        System.out.println("isEmpty('') = " + StringHelper.isEmpty(""));

        System.out.println("\n=== Java's Final Classes ===");
        System.out.println("String is final: " + String.class.getName());
        System.out.println("Integer is final: " + Integer.class.getName());
        System.out.println("Math is final: " + Math.class.getName());

        // These would be compilation errors:
        // class MyString extends String { }     // ERROR!
        // class MyInteger extends Integer { }   // ERROR!
    }
}

// ==================== EXAMPLE 1: Immutable Configuration ====================

/**
 * Final class = Cannot be extended
 * Combined with private final fields = True immutability
 *
 * Why prevent extension?
 * - If someone extends this, they could add mutable state
 * - They could override methods to return different values
 * - Immutability guarantee would be broken
 */
final class ImmutableConfig {
    private final String environment;
    private final String apiUrl;

    public ImmutableConfig(String environment, String apiUrl) {
        this.environment = environment;
        this.apiUrl = apiUrl;
    }

    public String getEnvironment() {
        return environment;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    // No setters! Object cannot be modified after creation.
}

// This would cause a compilation error:
// class ExtendedConfig extends ImmutableConfig { }  // ERROR! Cannot extend final class

// ==================== EXAMPLE 2: Utility Classes ====================

/**
 * Final utility class with only static methods
 * Similar to java.lang.Math
 *
 * Why final?
 * - No instance needed (all static)
 * - No point in extending (no instance methods to override)
 * - Prevents misuse of inheritance
 */
final class MathHelper {
    // Private constructor - cannot instantiate
    private MathHelper() {
        throw new AssertionError("Utility class - do not instantiate");
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static int min(int a, int b) {
        return a < b ? a : b;
    }
}

final class StringHelper {
    private StringHelper() {}

    public static boolean isEmpty(String s) {
        return s == null || s.length() == 0;
    }

    public static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}

// ==================== EXAMPLE 3: Security-Sensitive Class ====================

/**
 * Final class for security-sensitive operations
 * Preventing extension ensures the validation logic cannot be bypassed
 */
final class PasswordValidator {
    private static final int MIN_LENGTH = 8;

    private PasswordValidator() {}

    public static boolean isValid(String password) {
        if (password == null || password.length() < MIN_LENGTH) {
            return false;
        }
        // Check for at least one digit, one uppercase, one lowercase
        boolean hasDigit = false, hasUpper = false, hasLower = false;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) hasDigit = true;
            if (Character.isUpperCase(c)) hasUpper = true;
            if (Character.isLowerCase(c)) hasLower = true;
        }
        return hasDigit && hasUpper && hasLower;
    }
}

// If PasswordValidator wasn't final, someone could do:
// class WeakValidator extends PasswordValidator {
//     public static boolean isValid(String password) {
//         return true;  // Bypass all validation!
//     }
// }
