package bank;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class InMemoryTransactions implements Transactions {
    public ArrayList<Transaction> transactions = new ArrayList<>();

    @Override
    public void register(int amount) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date today = null;
        try {
            today = dateFormat.parse("30-11-2017");
        } catch (ParseException e) {
            e.printStackTrace();
            return;
        }

        Transaction transaction = new Transaction(today, amount);
        transactions.add(transaction);
    }

    @Override
    public Statement retrieveStatement() {
        return null;
    }
}
