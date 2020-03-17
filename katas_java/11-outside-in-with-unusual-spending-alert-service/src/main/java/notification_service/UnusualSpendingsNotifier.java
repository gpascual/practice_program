package notification_service;

public class UnusualSpendingsNotifier {

  private DateProvider dateProvider;
  private Payments payments;
  private NotificationSender notificationSender;
  private Users users;
  private UnusualSpendingsDetector detector;
  private UsersNotifier notifier;

  public UnusualSpendingsNotifier(DateProvider dateProvider, Payments payments, NotificationSender notificationSender, Users users) {
    this.dateProvider = dateProvider;
    this.payments = payments;
    this.notificationSender = notificationSender;
    this.users = users;
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
