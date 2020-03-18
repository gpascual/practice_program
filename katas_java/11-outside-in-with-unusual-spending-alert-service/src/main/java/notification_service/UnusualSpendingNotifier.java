package notification_service;

public class UnusualSpendingNotifier {

  private UnusualSpendingDetector detector;
  private UsersNotifier notifier;

  public UnusualSpendingNotifier(DateProvider dateProvider, Payments payments, NotificationSender notificationSender, Users users) {
    this.detector = new UnusualSpendingDetector(dateProvider, payments);
    this.notifier = new UsersNotifier(users, notificationSender);
  }

  public UnusualSpendingNotifier(UnusualSpendingDetector detector, UsersNotifier notifier) {

    this.detector = detector;
    this.notifier = notifier;
  }


  public void notify(int userId) {

    UnusualSpending unusualSpending = detector.detectUnusualSpending(userId);

    if(!unusualSpending.hasUnusualSpending()) {
      return;
    }

    this.notifier.notifyUser(unusualSpending);
  }
}
