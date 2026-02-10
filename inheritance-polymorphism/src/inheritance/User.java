package inheritance;

// Parent/Super/Base class
public class User {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;
    String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    protected void login() {
        System.out.println(name + " logged in");
    }

    public void logout() {
        System.out.println(name + " logged out");
    }

    public void getPermissions() {
        System.out.println("Basic read access");
    }
}
