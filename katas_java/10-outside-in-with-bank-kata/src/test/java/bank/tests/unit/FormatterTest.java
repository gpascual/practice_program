package bank.tests.unit;

import bank.Formatter;
import bank.Statement;
import bank.Transaction;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class FormatterTest {
    private Formatter formatter;

    @Test
    public void format_an_empty_statement() {
        formatter = new Formatter();
        Statement statement = new Statement();

        String output = formatter.format(statement);

        assertThat(output, is("date || credit || debit || balance\n"));
    }

    @Test
    public void format_a_statement_with_one_deposit() throws ParseException {
        formatter = new Formatter();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Statement statement = new Statement(
                new Transaction(dateFormat.parse("30-11-2017"), 12500)
        );

        String output = formatter.format(statement);

        assertThat(output, is(
                "date || credit || debit || balance\n" +
                "30/11/2017 || 12500.00 || || 12500.00\n"
        ));
    }

    @Test
    public void format_a_statement_with_one_withdrawal() throws ParseException {
        formatter = new Formatter();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Statement statement = new Statement(
                new Transaction(dateFormat.parse("22-12-2017"), -1200)
        );

        String output = formatter.format(statement);

        assertThat(output, is(
                "date || credit || debit || balance\n" +
                        "22/12/2017 || || 1200.00 || -1200.00\n"
        ));
    }

    @Test
    public void format_a_statement_with_some_transactions() throws ParseException {
        formatter = new Formatter();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Statement statement = new Statement(
            new Transaction(dateFormat.parse("19-12-2017"), 100),
            new Transaction(dateFormat.parse("22-12-2017"), -200),
            new Transaction(dateFormat.parse("27-12-2017"), 300)
        );

        String output = formatter.format(statement);

        assertThat(output, is(
                "date || credit || debit || balance\n" +
                "27/12/2017 || 300.00 || || 200.00\n" +
                "22/12/2017 || || 200.00 || -100.00\n" +
                "19/12/2017 || 100.00 || || 100.00\n"
        ));
    }
}
