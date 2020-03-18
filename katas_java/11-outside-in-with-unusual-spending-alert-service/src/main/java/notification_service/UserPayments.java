package notification_service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class UserPayments {

  private final List<Payment> payments;

  public UserPayments(List<Payment> payments) {

    this.payments = payments;
  }

  public Map<String, Integer> groupByCategory() {
    Map<String, Integer> groupedSpending = new LinkedHashMap<>();

    for (Payment payment: payments) {
      groupedSpending.put(
          payment.getCategory(),
          groupedSpending.getOrDefault(payment.getCategory(), 0) + payment.getPrice()
      );
    }

    return groupedSpending;
  }
}
