package notification_service.tests.unit;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import notification_service.Notification;
import notification_service.NotificationSender;
import notification_service.SpendingDelta;
import notification_service.UnusualSpending;
import notification_service.User;
import notification_service.Users;
import notification_service.UsersNotifier;

public class UsersNotifierTest {
  @Test
  public void notifies_user_when_an_unusual_spending_is_made() {
    Users users = mock(Users.class);
    NotificationSender notificationSender = mock(NotificationSender.class);
    UsersNotifier usersNotifier = new UsersNotifier(users, notificationSender);
    User user = new User(1, "pacheco@adevinta.es");
    when(users.getUser(1)).thenReturn(user);
    UnusualSpending unusualSpending = new UnusualSpending(1, Collections.singletonList(
        new SpendingDelta("groceries", 202, 405)
    ));

    usersNotifier.notifyUser(unusualSpending);

    verify(notificationSender).send(new Notification(user,
        "Hello card user!\n\n"
        + "We have detected unusually high spending on your card in these categories:\n\n"
        + "* You spent $405 on groceries\n\n"
        + "Love,\n\n"
        + "The Credit Card Company\n"
    ));
  }

  @Test
  public void notifies_user_if_unusual_spending_are_made() {
    Users users = mock(Users.class);
    NotificationSender notificationSender = mock(NotificationSender.class);
    UsersNotifier usersNotifier = new UsersNotifier(users, notificationSender);
    User user = new User(1, "pacheco@adevinta.es");
    when(users.getUser(1)).thenReturn(user);
    UnusualSpending unusualSpending = new UnusualSpending(1, Arrays.asList(
        new SpendingDelta("groceries", 74, 148),
        new SpendingDelta("travel", 464, 928)
    ));

    usersNotifier.notifyUser(unusualSpending);

    verify(notificationSender).send(new Notification(user,
        "Hello card user!\n\n"
        + "We have detected unusually high spending on your card in these categories:\n\n"
        + "* You spent $148 on groceries\n"
        + "* You spent $928 on travel\n\n"
        + "Love,\n\n"
        + "The Credit Card Company\n"
    ));
  }

  @Test
  public void does_not_notify_user_if_no_unusual_spending_are_made() {
    Users users = mock(Users.class);
    NotificationSender notificationSender = mock(NotificationSender.class);
    UsersNotifier usersNotifier = new UsersNotifier(users, notificationSender);
    User user = new User(1, "pacheco@adevinta.es");
    when(users.getUser(1)).thenReturn(user);
    UnusualSpending unusualSpending = new UnusualSpending(1, Collections.emptyList());

    usersNotifier.notifyUser(unusualSpending);

    verify(notificationSender, never()).send(any());
  }
}
