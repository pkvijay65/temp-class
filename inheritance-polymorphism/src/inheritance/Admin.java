package inheritance;

public class Admin extends User {

    public Admin(String name, String email) {
        super(name, email);
    }

    public void banUser(User user) {
        System.out.println("Admin " + name + " banned user");
    }

    @Override
    public void getPermissions() {
        System.out.println("Full admin access");
    }
}
