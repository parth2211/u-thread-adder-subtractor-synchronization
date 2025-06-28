package threadcreator;

public class SharedResource {
    private long bankAmount;

    public SharedResource(long initialAmount) {
        this.bankAmount = initialAmount;
    }

    public void add(long amount) {
        bankAmount += amount;
    }

    public void sub(long amount) {
        bankAmount -= amount;
    }

    public long getBankAmount() {
        return bankAmount;
    }
}
