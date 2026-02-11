package staticdemo;

public class OuterClass {
    private int age;
    private int height;

    public OuterClass(int age, int height) {
        this.age = age;
        this.height = height;
    }


    static class InnerClass {
        private int innerAge;

        public InnerClass(int innerAge) {
            this.innerAge = innerAge;
        }
    }

    class nonStaticInnerClass {
        private int innerNonStaticAge;
        public nonStaticInnerClass(int innerNonStaticAge) {
            this.innerNonStaticAge = innerNonStaticAge;
        }
    }
}
