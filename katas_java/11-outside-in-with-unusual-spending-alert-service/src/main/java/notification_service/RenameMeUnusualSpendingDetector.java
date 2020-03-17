package notification_service;

import java.util.ArrayList;
import java.util.Map;

public class RenameMeUnusualSpendingDetector implements UnusualSpendingsDetector {

  private final DateProvider dateProvider;
  private final Payments payments;

  public RenameMeUnusualSpendingDetector(DateProvider dateProvider, Payments payments) {this.dateProvider = dateProvider;
    this.payments = payments;
  }

  @Override
  public UnusualSpendings detectUnusualSpendings(int userId) {
    UnusualSpendings unusualSpendings = new UnusualSpendings(userId, new ArrayList<>());

    Month currentMonth = dateProvider.getCurrentMonth();
    Month previousMonth = currentMonth.previousMonth();
    UserPayments currentMonthPayments = payments.getForUserAndDate(userId, currentMonth);
    UserPayments previousMonthPayments = payments.getForUserAndDate(userId, previousMonth);

    Map<String, Integer> currentMonthSpendings = currentMonthPayments.groupByCategory();
    Map<String, Integer> previousMonthSpendings = previousMonthPayments.groupByCategory();

    if (currentMonthSpendings.isEmpty() || previousMonthSpendings.isEmpty()) {
      return unusualSpendings;
    }

    for (Map.Entry<String, Integer> entry : currentMonthSpendings.entrySet()) {
      String category = entry.getKey();
      Integer currentSpending = entry.getValue();
      if (previousMonthSpendings.containsKey(category) && currentSpending >= 1.5 * previousMonthSpendings.get(category)) {
        unusualSpendings.addUnusualSpending(new UnusualSpending(category, currentSpending));
      }
    }

    return unusualSpendings;
  }
}
