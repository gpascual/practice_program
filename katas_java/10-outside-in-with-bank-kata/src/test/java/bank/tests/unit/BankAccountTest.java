package bank.tests.unit;

import bank.*;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.mockito.Mockito.*;

public class BankAccountTest {

    private Transactions transactions;
    private Printer printer;
    private BankAccount bankAccount;

    @Before
    public void setUp() {
        transactions = mock(Transactions.class);
        printer = mock(Printer.class);
        bankAccount = new BankAccount(transactions, printer);
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
        when(transactions.retrieveStatement()).thenReturn(
                statement
        );

        bankAccount.print();

        verify(printer).print(statement);
    }
}
