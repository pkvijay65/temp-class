package polymorphism.overloading;

public class NotificationService {
    public void sendNotification() {
        System.out.println("sending notification to a user");
    }

    public void sendNotification(String users) {
        System.out.println("sending notification to all users");
    }

    int getValue(){
        return 5;
    }


    double y = getValue();

}
