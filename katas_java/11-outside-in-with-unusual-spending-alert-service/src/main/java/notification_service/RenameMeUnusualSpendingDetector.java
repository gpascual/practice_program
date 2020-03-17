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

    if (currentMonthSpendings.get("entertainment") >= 1.5*previousMonthSpendings.get("entertainment") ) {
      unusualSpendings.addUnusualSpending(new UnusualSpending("entertainment", currentMonthSpendings.get("entertainment")));
    }

    return unusualSpendings;
  }
}
