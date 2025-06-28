package threadcreator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Subtractor implements Runnable{

    SharedResource bank;
    List<Long> subList = new ArrayList<>();

    public Subtractor(SharedResource bank, List<Long> list) {
        this.bank = bank;
        this.subList = list;
    }

    @Override
    public void run() {
        try {
            for(long amount : subList) {
                TimeUnit.MILLISECONDS.sleep(500);
                bank.sub(amount);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
