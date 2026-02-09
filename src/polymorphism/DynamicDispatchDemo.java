package polymorphism;

import inheritance.*;
import polymorphism.overriding.payment.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

// Demonstrates Runtime Polymorphism - Dynamic Method Dispatch
public class DynamicDispatchDemo {

    public static void main(String[] args) {
        UPIPayment upiPayment = new UPIPayment(80, "sa");

        CreditCardPayment creditCardPayment = new CreditCardPayment(80, "sa");

//        Payment payment = new Payment(80);
//        payment.process();


//        Payment payment = new Payment(80);
//        payment.process();

        Payment payment = new UPIPayment(80, "sa");
        payment.process();

        Payment upiPayment2 = new UPIPayment(80, "sa");
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.size();

        //Collections Framework
        List<Integer> list2 = new LinkedList<>();
        list2.addLast(80);
        list2.add(90);
        list2.remove(0);


        Set<Integer> set1 = new HashSet<>();
        set1.add(80);





    }
}
