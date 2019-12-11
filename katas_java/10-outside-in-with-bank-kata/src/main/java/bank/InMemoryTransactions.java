package bank;

import java.util.ArrayList;
import java.util.Date;

public class InMemoryTransactions implements Transactions {
    public ArrayList<Transaction> transactions = new ArrayList<>();

    @Override
    public void register(Date today, int amount) {
        Transaction transaction = new Transaction(today, amount);
        transactions.add(transaction);
    }

    @Override
    public Statement retrieveStatement() {
        return new Statement(transactions);
    }
}
