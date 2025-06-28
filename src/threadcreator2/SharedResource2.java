package threadcreator2;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SharedResource2 {
    private long bankAmount;

    public SharedResource2(long initialAmount) {
        this.bankAmount = initialAmount;
    }

    public synchronized void add(long amount) {
        long initialAmount = bankAmount;
        try {
            TimeUnit.MILLISECONDS.sleep(new Random().nextInt(500));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        bankAmount = initialAmount + amount;
    }

    public synchronized void sub(long amount) {
        long initialAmount = bankAmount;
        try {
            TimeUnit.MILLISECONDS.sleep(new Random().nextInt(500));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        bankAmount = initialAmount - amount;
    }

    public long getBankAmount() {
        return bankAmount;
    }
}
