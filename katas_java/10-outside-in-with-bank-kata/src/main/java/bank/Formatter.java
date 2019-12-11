package bank;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class Formatter {

    private static final String HEADER = "date || credit || debit || balance\n";

    public String format(Statement statement) {
        if (statement.transactions.size() == 0) {
            return HEADER;
        }

        double balance = 0.0 ;
        ArrayList<Double> balances = new ArrayList<>();
        for (Transaction transaction: statement.transactions) {
            balance += transaction.getAmount();
            balances.add(balance);
        }
        Collections.reverse(balances);

        String output = HEADER;
        ArrayList<Transaction> reversed = new ArrayList<>(statement.transactions);
        Collections.reverse(reversed);
        int index = 0;
        for (Transaction transaction: reversed) {
            output += formatTransaction(transaction, balances.get(index++));
        }
        return output;
    }

    private static String formatTransaction(Transaction transaction, double balance) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        if (transaction.isWithdrawal()) {
            return dateFormat.format(transaction.getCreated()) + " || || " +
                    String.format(Locale.ROOT, "%.2f", -transaction.getAmount()) + " || " +
                    String.format(Locale.ROOT, "%.2f", balance) + "\n";
        }

        return dateFormat.format(transaction.getCreated()) + " || " +
                String.format(Locale.ROOT, "%.2f", transaction.getAmount()) + " || || " +
                String.format(Locale.ROOT, "%.2f", balance) + "\n";
    }
}
