package polymorphism.overloading;

/**
 * LEARNING OUTCOME: Method Overloading
 *
 * Same method name, different parameters.
 * Compiler picks the right method based on arguments.
 */
public class NotificationService {

    // Overloaded method 1: Send to single user
    public void sendNotification(String message, String userId) {
        System.out.println("Sending to " + userId + ": " + message);
    }

    // Overloaded method 2: Send to multiple users
    public void sendNotification(String message, String[] userIds) {
        for (String id : userIds) {
            System.out.println("Sending to " + id + ": " + message);
        }
    }

    // Overloaded method 3: Broadcast to all
    public void sendNotification(String message) {
        System.out.println("Broadcasting: " + message);
    }

    public static void main(String[] args) {
        NotificationService service = new NotificationService();

        service.sendNotification("Hello");                        // Calls method 3
        service.sendNotification("Hi", "user1");                  // Calls method 1
        service.sendNotification("Hey", new String[]{"u1", "u2"}); // Calls method 2
    }
}
