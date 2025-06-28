package threadcreator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Adder implements Runnable{

    SharedResource bank;
    List<Long> addList = new ArrayList<>();

    public Adder(SharedResource bank, List<Long> list) {
        this.bank = bank;
        this.addList = list;
    }

    @Override
    public void run() {
        try {
            for(long amount : addList) {
                TimeUnit.MILLISECONDS.sleep(500);
                bank.add(amount);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
