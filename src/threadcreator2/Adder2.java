package threadcreator2;

import java.util.ArrayList;
import java.util.List;

public class Adder2 implements Runnable{

    SharedResource2 bank;
    List<Long> addList = new ArrayList<>();

    public Adder2(SharedResource2 bank, List<Long> list) {
        this.bank = bank;
        this.addList = list;
    }

    @Override
    public void run() {
        for(long amount : addList) {
            //TimeUnit.MILLISECONDS.sleep(500);
            bank.add(amount);
        }
    }
}
