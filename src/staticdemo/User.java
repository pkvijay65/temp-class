package staticdemo;

/**
 * Demonstrates static variables and the difference between
 * instance variables and class variables.
 */
public class User {
    // Instance variable - each object has its own copy
    private String name;
    private String email;

    // Static variable - ONE copy shared by ALL instances
    private static int userCount = 0;

    // Static constant
    public static final int MAX_USERS = 1000;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        userCount++; // Increment shared counter
        System.out.println("User #" + userCount + " created: " + name);
    }

    // Instance method - can access both instance and static members
    public void displayInfo() {
        System.out.println("Name: " + name + ", Email: " + email);
        System.out.println("Total users in system: " + userCount);
    }

    // Static method - can ONLY access static members directly
    public static int getUserCount() {
        // System.out.println(name); // ERROR! Can't access instance variable
        return userCount;
    }

    // Static method - utility
    public static boolean canCreateMoreUsers() {
        return userCount < MAX_USERS;
    }

    // Static method - can access instance through parameter
    public static void printUserInfo(User user) {
        System.out.println("User: " + user.name); // OK - accessing through reference
    }

    public String getName() {
        return name;
    }
}
