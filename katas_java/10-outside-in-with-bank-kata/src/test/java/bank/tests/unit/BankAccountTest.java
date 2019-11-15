package bank.tests.unit;

import bank.*;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.mockito.Mockito.*;

public class BankAccountTest {

    private Transactions transactions;
    private OutputPrinter outputPrinter;
    private BankAccount bankAccount;

    @Before
    public void setUp() {
        transactions = mock(Transactions.class);
        outputPrinter = mock(OutputPrinter.class);
        bankAccount = new BankAccount(transactions, outputPrinter);
    }

    @Test
    public void deposit_some_amount() {
        int amount = 500;
        bankAccount.deposit(amount);

        verify(transactions).register(amount);
    }

    @Test
    public void withdraw_some_cash() {
        int amount = 500;
        bankAccount.withdrawal(amount);

        verify(transactions).register(-amount);
    }

    @Test
    public void print_account() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Statement statement = new Statement(
                new Transaction(dateFormat.parse("10-01-2012"), 500),
                new Transaction(dateFormat.parse("11-01-2012"), -200)
        );
        when(transactions.generateStatement()).thenReturn(
                statement
        );

        bankAccount.print();

        verify(outputPrinter).print(statement);
    }
}
