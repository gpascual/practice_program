package bank.tests.unit;

import bank.*;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PrinterTest {
    private DefaultPrinter printer;
    private Display display;
    private Formatter formatter;

    @Test
    public void print_a_statement() throws ParseException {
        display = mock(Display.class);
        formatter = mock(Formatter.class);
        printer = new DefaultPrinter(formatter, display);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Statement statement = new Statement(
                new Transaction(dateFormat.parse("10-01-2012"), 500),
                new Transaction(dateFormat.parse("11-01-2012"), -200)
        );

        printer.print(statement);

        verify(display).print("date || credit || debit || balance\n");
        verify(display).print("11/01/2012 || || 200.00 || 300.00\n");
        verify(display).print("10/01/2012 || 500.00 || || 500.00\n");
    }
}
