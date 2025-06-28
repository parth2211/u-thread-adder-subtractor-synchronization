import threadcreator.Adder;
import threadcreator.SharedResource;
import threadcreator.Subtractor;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource(1000);

        Thread adder = new Thread(new Adder(sharedResource, new ArrayList<>(Arrays.asList(500L, 400L))));
        Thread subtractor = new Thread(new Subtractor(sharedResource, new ArrayList<>(Arrays.asList(200L, 200L, 500L))));

        adder.start();
        subtractor.start();

        try {
            adder.join();
            subtractor.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Final amount : " + sharedResource.getBankAmount());
    }
}