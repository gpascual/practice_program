package bank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Statement {
    List<Transaction> transactions;

    public Statement(Transaction... transactions) {
        this.transactions = new ArrayList<>(Arrays.asList(transactions));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Statement statement = (Statement) o;
        return Objects.equals(transactions, statement.transactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactions);
    }

    @Override
    public String toString() {
        return "Statement{" +
                "transactions=" + transactions +
                '}';
    }
}
