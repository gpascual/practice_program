package notification_service.tests.unit;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import notification_service.SpendingDelta;
import notification_service.UnusualSpending;
import notification_service.UnusualSpendingDetector;
import notification_service.UnusualSpendingNotifier;
import notification_service.UsersNotifier;

public class UnusualSpendingNotifierTest {

  @Test
  public void detected_unusual_spending_are_notified() {
    UnusualSpendingDetector detector = mock(UnusualSpendingDetector.class);
    UsersNotifier notifier = mock(UsersNotifier.class);
    int userId = 5;
    UnusualSpendingNotifier unusualSpendingNotifier =  new UnusualSpendingNotifier(detector, notifier);
    UnusualSpending unusualSpending = unusualEntertainmentSpending(userId);
    when(detector.detectUnusualSpending(userId)).thenReturn(unusualSpending);

    unusualSpendingNotifier.notify(userId);

    verify(notifier).notifyUser(unusualSpending);
  }

  @Test
  public void does_not_notify_when_there_are_no_unusual_spending() {
    UnusualSpendingDetector detector = mock(UnusualSpendingDetector.class);
    UsersNotifier notifier = mock(UsersNotifier.class);
    int userId = 5;
    UnusualSpendingNotifier unusualSpendingNotifier =  new UnusualSpendingNotifier(detector, notifier);
    when(detector.detectUnusualSpending(userId)).thenReturn(new UnusualSpending(userId, new ArrayList<>()));

    unusualSpendingNotifier.notify(userId);

    verify(notifier, never()).notifyUser(any());
  }

  private UnusualSpending unusualEntertainmentSpending(int userId) {

    return new UnusualSpending(userId, Collections.singletonList(new SpendingDelta("entertainment", 250, 500)));
  }
}
