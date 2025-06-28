import threadcreator.Adder;
import threadcreator.SharedResource;
import threadcreator.Subtractor;
import threadcreator2.Adder2;
import threadcreator2.SharedResource2;
import threadcreator2.Subtractor2;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SharedResource2 sharedResource = new SharedResource2(1000);

        Thread adder2 = new Thread(new Adder2(sharedResource, new ArrayList<>(Arrays.asList(800L))));
        Thread subtractor2 = new Thread(new Subtractor2(sharedResource, new ArrayList<>(Arrays.asList(200L, 100L, 500L))));

        long currentTime = System.currentTimeMillis();

        adder2.start();
        subtractor2.start();

        try {
            subtractor2.join();
            System.out.println(" Total time taken by subtractor thread: " + (System.currentTimeMillis() - currentTime));
            adder2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Final amount : " + sharedResource.getBankAmount() + " Total time taken : " +
                (System.currentTimeMillis() - currentTime));
    }
}