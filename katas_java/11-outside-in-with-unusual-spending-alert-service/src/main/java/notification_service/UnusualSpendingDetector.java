package notification_service;

import java.util.ArrayList;
import java.util.Map;

public class UnusualSpendingDetector {

  private final DateProvider dateProvider;
  private final Payments payments;

  public UnusualSpendingDetector(DateProvider dateProvider, Payments payments) { this.dateProvider = dateProvider;
    this.payments = payments;
  }

  public UnusualSpending detectUnusualSpending(int userId) {
    UnusualSpending unusualSpending = new UnusualSpending(userId, new ArrayList<>());

    Month currentMonth = dateProvider.getCurrentMonth();
    Month previousMonth = currentMonth.previousMonth();
    UserPayments currentMonthPayments = payments.getForUserAndDate(userId, currentMonth);
    UserPayments previousMonthPayments = payments.getForUserAndDate(userId, previousMonth);

    Map<String, Integer> currentMonthSpending = currentMonthPayments.groupByCategory();
    Map<String, Integer> previousMonthSpending = previousMonthPayments.groupByCategory();

    if (currentMonthSpending.isEmpty() || previousMonthSpending.isEmpty()) {
      return unusualSpending;
    }

    for (Map.Entry<String, Integer> entry : currentMonthSpending.entrySet()) {
      String category = entry.getKey();
      Integer currentSpending = entry.getValue();

      SpendingDelta spendingDelta = new SpendingDelta(category, previousMonthSpending.getOrDefault(category, null), currentSpending);

      if (spendingDelta.isUnusual()) {
        unusualSpending.addUnusualSpending(spendingDelta);
      }
    }

    return unusualSpending;
  }
}
