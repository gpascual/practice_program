package notification_service;

import java.util.Iterator;

public class UsersNotifier {

  private final Users users;
  private final NotificationSender notificationSender;

  public UsersNotifier(Users users, NotificationSender notificationSender) {

    this.users = users;
    this.notificationSender = notificationSender;
  }

  public void notifyUser(UnusualSpendings unusualSpendings) {
    User user = users.getUser(unusualSpendings.getUserId());

    String list = "";
    for (Iterator<UnusualSpending> it = unusualSpendings.iterate(); it.hasNext(); ) {
      UnusualSpending unusualSpending = it.next();
      list = list.concat(String.format("* You spent $%s on %s\n", unusualSpending.getAmount(), unusualSpending.getCategory()));
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
