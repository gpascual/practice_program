package notification_service;

import java.util.Iterator;

public class UsersNotifier {

  private final Users users;
  private final NotificationSender notificationSender;

  public UsersNotifier(Users users, NotificationSender notificationSender) {

    this.users = users;
    this.notificationSender = notificationSender;
  }

  public void notifyUser(UnusualSpending unusualSpending) {
    if (!unusualSpending.hasUnusualSpending()) {
      return;
    }

    User user = users.getUser(unusualSpending.getUserId());

    String list = "";
    for (Iterator<SpendingDelta> it = unusualSpending.iterate(); it.hasNext(); ) {
      SpendingDelta spendingDelta = it.next();
      list = list.concat(String.format("* You spent $%s on %s\n", spendingDelta.getAmount(), spendingDelta.getCategory()));
    }
    notificationSender.send(new Notification(user,
        "Hello card user!\n\n"
        + "We have detected unusually high spending on your card in these categories:\n\n"
        + list
        + "\n"
        + "Love,\n\n"
        + "The Credit Card Company\n")
    );
  }
}
