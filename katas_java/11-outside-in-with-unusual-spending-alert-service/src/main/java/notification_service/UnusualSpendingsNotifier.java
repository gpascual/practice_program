package notification_service;

public class UnusualSpendingsNotifier {

  private UnusualSpendingsDetector detector;
  private UsersNotifier notifier;

  public UnusualSpendingsNotifier(DateProvider dateProvider, Payments payments, NotificationSender notificationSender, Users users) {
    this.detector = new RenameMeUnusualSpendingDetector(dateProvider, payments);
    this.notifier = new UsersNotifier(users, notificationSender);
  }

  public UnusualSpendingsNotifier(UnusualSpendingsDetector detector, UsersNotifier notifier) {

    this.detector = detector;
    this.notifier = notifier;
  }


  public void notify(int userId) {

    UnusualSpendings unusualSpendings = detector.detectUnusualSpendings(userId);

    if(!unusualSpendings.hasUnusualSpendings()) {
      return;
    }

    this.notifier.notifyUser(unusualSpendings);
  }
}
