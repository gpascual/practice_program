package bank;

import java.util.Date;

public interface Transactions {
    void register(Date today, int amount);
    Statement retrieveStatement();
}
