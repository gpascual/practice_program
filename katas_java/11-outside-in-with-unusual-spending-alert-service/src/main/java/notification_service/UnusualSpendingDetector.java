package notification_service;

public class UnusualSpendingDetector {

  private final DateProvider dateProvider;
  private final Payments payments;

  public UnusualSpendingDetector(DateProvider dateProvider, Payments payments) { this.dateProvider = dateProvider;
    this.payments = payments;
  }

  public UnusualSpending detectUnusualSpending(int userId) {

    Month currentMonth = dateProvider.getCurrentMonth();
    Month previousMonth = currentMonth.previousMonth();
    UserPayments currentMonthPayments = payments.getForUserAndDate(userId, currentMonth);
    UserPayments previousMonthPayments = payments.getForUserAndDate(userId, previousMonth);

    return new UnusualSpendingFilter(userId, currentMonthPayments.groupByCategory(), previousMonthPayments.groupByCategory()).filter();
  }

}
