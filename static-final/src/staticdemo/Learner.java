package staticdemo;

public class Learner {
    static int count = 0;
    String name;

    static {
        System.out.println("static block");
        System.out.println("I am starting during class loading");
    }


    Learner(String name) {
        this.name = name;
        count++;
    }

    public String getName() {
        return name;
    }

    public static int getCount() {
        return count;
    }

}
