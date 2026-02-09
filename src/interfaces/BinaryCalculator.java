package interfaces;

public class BinaryCalculator (Calculator, Deletable) {

    @Override
    public int calculate(int a, int b) {
        return 0;
    }

    @Override
    public void delete(){
        System.out.println("delete");
    }

}
