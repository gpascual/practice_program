package notification_service.tests.unit;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

import java.util.ArrayList;

import notification_service.UnusualSpending;
import notification_service.UnusualSpendings;
import notification_service.UnusualSpendingsDetector;
import notification_service.UnusualSpendingsNotifier;
import notification_service.UserPayments;
import notification_service.UsersNotifier;

public class UnusualSpendingsNotifierTest {

  @Test
  public void detected_unusual_spendings_are_notified() {
    UnusualSpendingsDetector detector = mock(UnusualSpendingsDetector.class);
    UsersNotifier notifier = mock(UsersNotifier.class);
    int userId = 5;
    UnusualSpendingsNotifier unusualSpendingsNotifier =  new UnusualSpendingsNotifier(detector, notifier);
    UnusualSpendings unusualSpendings = unusualEntertainmentSpendings(userId);
    when(detector.detectUnusualSpendings(userId)).thenReturn(unusualSpendings);

    unusualSpendingsNotifier.notify(userId);

    verify(notifier).notifyUser(unusualSpendings);
  }

  @Test
  public void does_not_notify_when_there_are_no_unusual_spendings() {
    UnusualSpendingsDetector detector = mock(UnusualSpendingsDetector.class);
    UsersNotifier notifier = mock(UsersNotifier.class);
    int userId = 5;
    UnusualSpendingsNotifier unusualSpendingsNotifier =  new UnusualSpendingsNotifier(detector, notifier);
    when(detector.detectUnusualSpendings(userId)).thenReturn(new UnusualSpendings(userId, new ArrayList<>()));

    unusualSpendingsNotifier.notify(userId);

    verify(notifier, never()).notifyUser(any());
  }

  private UnusualSpendings unusualEntertainmentSpendings(int userId) {
    UnusualSpendings unusualSpendings = new UnusualSpendings(userId, new ArrayList<>());
    unusualSpendings.addUnusualSpending(new UnusualSpending("entertainment", 500));

    return unusualSpendings;
  }

  private UserPayments noPayments() {
    return new UserPayments(new ArrayList<>());
  }
}
