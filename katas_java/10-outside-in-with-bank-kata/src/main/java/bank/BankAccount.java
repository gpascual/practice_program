package bank;

public class BankAccount {
    private Transactions transactions;
    private CCalendar calendar;
    private Display display;
    private Printer printer;

    public BankAccount(Transactions transactions, Printer printer) {
        this.transactions = transactions;
        this.printer = printer;
    }

    public BankAccount(Transactions transactions, CCalendar calendar, Display display) {
        this.transactions = transactions;
        this.calendar = calendar;
        this.printer = new Printer(display);
    }

    public void deposit(int amount) {
        transactions.register(amount);
    }

    public void withdrawal(int amount) {
        transactions.register(-amount);
    }

    public void print() {
        printer.print(transactions.retrieveStatement());
    }
}
