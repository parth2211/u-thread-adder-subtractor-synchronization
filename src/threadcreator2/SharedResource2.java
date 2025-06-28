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
            System.out.println("User want to add money .... but bank is on Lunch break");
            TimeUnit.MILLISECONDS.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        bankAmount = initialAmount + amount;
        System.out.println("Deposit " + amount);
    }

    public synchronized void sub(long amount) {
        long initialAmount = bankAmount;
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        bankAmount = initialAmount - amount;
        System.out.println("Withdrawn " + amount);
    }

    public long getBankAmount() {
        return bankAmount;
    }
}
