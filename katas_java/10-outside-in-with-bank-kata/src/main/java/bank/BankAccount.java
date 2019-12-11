package bank;

import java.util.Date;

public class BankAccount {
    private Transactions transactions;
    private CCalendar calendar;
    private Display display;
    private Printer printer;

    public BankAccount(Transactions transactions, CCalendar calendar, Display display) {
        this.transactions = transactions;
        this.calendar = calendar;
        this.printer = new Printer(display);
    }

    public BankAccount(Transactions transactions, Printer printer, CCalendar calendar) {
        this.transactions = transactions;
        this.printer = printer;
        this.calendar = calendar;
    }

    public void deposit(int amount) {
        Date today = calendar.getDate();
        transactions.register(today, amount);
    }

    public void withdrawal(int amount) {
        transactions.register(calendar.getDate(), -amount);
    }

    public void print() {
        printer.print(transactions.retrieveStatement());
    }
}
