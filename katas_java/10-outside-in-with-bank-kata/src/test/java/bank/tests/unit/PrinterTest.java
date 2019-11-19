package bank.tests.unit;

import bank.*;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.mockito.Mockito.*;

public class PrinterTest {
    private Printer printer;
    private Display display;
    private Formatter formatter;

    @Test
    public void print_a_statement() throws ParseException {
        display = mock(Display.class);
        formatter = mock(Formatter.class);
        printer = new Printer(formatter, display);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Statement statement = new Statement(
                new Transaction(dateFormat.parse("10-01-2012"), 500),
                new Transaction(dateFormat.parse("11-01-2012"), -200)
        );
        String expectedOutput = "date || credit || debit || balance\n" +
                "11/01/2012 || || 200.00 || 300.00\n" +
                "10/01/2012 || 500.00 || || 500.00\n";
        when(formatter.format(statement)).thenReturn(expectedOutput);

        printer.print(statement);

        verify(display).print(expectedOutput);
    }
}
