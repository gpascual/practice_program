package bank;

import java.util.Date;
import java.util.Objects;

public class Transaction {
    private final Date created;

    private final int amount;

    public Date getCreated() {
        return created;
    }

    public double getAmount() {
        return Double.valueOf(amount);
    }

    public Transaction(Date created, int amount) {
        this.created = created;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return amount == that.amount &&
                Objects.equals(created, that.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(created, amount);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "created=" + created +
                ", amount=" + amount +
                '}';
    }

    public boolean isWithdrawal() {
        return amount < 0;
    }
}
