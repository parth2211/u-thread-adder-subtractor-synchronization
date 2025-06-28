package threadcreator2;

import java.util.ArrayList;
import java.util.List;

public class Subtractor2 implements Runnable{

    SharedResource2 bank;
    List<Long> subList = new ArrayList<>();

    public Subtractor2(SharedResource2 bank, List<Long> list) {
        this.bank = bank;
        this.subList = list;
    }

    @Override
    public void run() {
        for(long amount : subList) {
            //TimeUnit.MILLISECONDS.sleep(500);
            bank.sub(amount);
        }
    }
}
