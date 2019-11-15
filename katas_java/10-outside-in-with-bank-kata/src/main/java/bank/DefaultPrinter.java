package bank;

public class DefaultPrinter implements OutputPrinter {
    private final Formatter formatter;
    private final Display display;

    public DefaultPrinter(Formatter formatter, Display display) {
        this.formatter = formatter;
        this.display = display;
    }

    @Override
    public void print(Statement statement) {

    }
}
