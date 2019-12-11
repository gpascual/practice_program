package bank.tests.integration;

import bank.InMemoryTransactions;
import bank.Statement;
import bank.Transaction;
import org.hamcrest.core.Is;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

public class InMemoryTransactionsTest {

    @Test
    public void register_a_deposit() throws ParseException {
        InMemoryTransactions inMemoryTransactions = new InMemoryTransactions();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date today = dateFormat.parse("30-11-2017");

        inMemoryTransactions.register(today, 500);

        Transaction transaction = new Transaction(today, 500);
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction);
        assertThat(inMemoryTransactions.transactions, Is.is(transactions));
    }

    @Test
    public void retrieve_statement() throws ParseException {
        InMemoryTransactions inMemoryTransactions = new InMemoryTransactions();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date today = dateFormat.parse("30-11-2017");

        Transaction transaction = new Transaction(today, 500);
        inMemoryTransactions.transactions.add(transaction);

        Statement statement = inMemoryTransactions.retrieveStatement();

        assertThat(statement, Is.is(new Statement(transaction)));
    }
}
