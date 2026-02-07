package inheritance;

public class SpecificUser extends User{
    String specificProperty;

    public SpecificUser(String name, String email, String specificProperty) {
        super(name, email);
        this.specificProperty = specificProperty;
    }

}
