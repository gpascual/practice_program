package bank.tests.acceptance;

import bank.*;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.mockito.Mockito.*;

public class PrintingAccountStatementOnConsoleTest {

    private Transactions transactions;
    private BankAccount bankAccount;
    private CCalendar calendar;
    private Display display;

    @Before
    public void setUp() throws Exception {
        transactions = mock(Transactions.class);
        calendar = mock(CCalendar.class);
        display = mock(Display.class);
        bankAccount = new BankAccount(transactions, calendar, display);
    }

    @Test
    public void printing_statement_including_deposit_and_withdrawal() throws ParseException {
        /**
         *     > Given a client makes a deposit of 1000 on 10-01-2012
         *     > And a deposit of 2000 on 13-01-2012
         *     > And a withdrawal of 500 on 14-01-2012
         *     > When she prints her bank statement
         *     > Then she would see
         *     > date || credit || debit || balance
         *     > 14/01/2012 || || 500.00 || 2500.00
         *     > 13/01/2012 || 2000.00 || || 3000.00
         *     > 10/01/2012 || 1000.00 || || 1000.00
         */
        //Given
        when(calendar.getDate()).thenReturn(
                new SimpleDateFormat("dd-MM-yyyy").parse("10-01-2012"),
                new SimpleDateFormat("dd-MM-yyyy").parse("13-01-2012"),
                new SimpleDateFormat("dd-MM-yyyy").parse("14-01-2012")
        );
        bankAccount.deposit(1000);
        bankAccount.deposit(2000);
        bankAccount.withdrawal(500);

        spy(display).print("date || credit || debit || balance\n");
        spy(display).print("14/01/2012 || || 500.00 || 2500.00\n");
        spy(display).print("13/01/2012 || 2000.00 || || 3000.00\n");
        spy(display).print("10/01/2012 || 1000.00 || || 1000.00\n");
        bankAccount.print();
    }
}
