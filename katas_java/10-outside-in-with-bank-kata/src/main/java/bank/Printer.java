package bank;

public class Printer {
    private final Formatter formatter;
    private final Display display;

    public Printer(Formatter formatter, Display display) {
        this.formatter = formatter;
        this.display = display;
    }

    public Printer(Display display) {
        this.formatter = new Formatter();
        this.display = display;
    }

    public void print(Statement statement) {
        display.print(formatter.format(statement));
    }
}
