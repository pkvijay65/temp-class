package inheritance;

public class Seller extends User {
    private String storeName;

    public Seller(String name, String email, String storeName) {
        super(name, email);
        this.storeName = storeName;
    }

    public void listProduct(String productName) {
        System.out.println(storeName + " listed: " + productName);
    }

    @Override
    public void getPermissions() {
        System.out.println("Seller access: manage products, view orders, analytics");
    }
}
