package bank;

public class BankAccount {
    private Transactions transactions;
    private CCalendar calendar;
    private Display display;
    private OutputPrinter outputPrinter;

    public BankAccount(Transactions transactions, OutputPrinter outputPrinter) {
        this.transactions = transactions;
        this.outputPrinter = outputPrinter;
    }

    public BankAccount(Transactions transactions, CCalendar calendar, Display display) {
        this.transactions = transactions;
        this.calendar = calendar;
        this.display = display;
    }

    public void deposit(int amount) {
        transactions.register(amount);
    }

    public void withdrawal(int amount) {
        transactions.register(-amount);
    }

    public void print() {
        outputPrinter.print(transactions.generateStatement());
    }
}
