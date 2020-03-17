package notification_service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserPayments {

  private final ArrayList<Payment> payments;

  public UserPayments(ArrayList<Payment> payments) {

    this.payments = payments;
  }

  public Map<String, Integer> groupByCategory() {
    Map<String, Integer> groupedSpending = new HashMap<>();

    for (Payment payment: payments) {
      groupedSpending.put(
          payment.getCategory(),
          groupedSpending.getOrDefault(payment.getCategory(), 0) + payment.getPrice()
      );
    }

    return groupedSpending;
  }
}
