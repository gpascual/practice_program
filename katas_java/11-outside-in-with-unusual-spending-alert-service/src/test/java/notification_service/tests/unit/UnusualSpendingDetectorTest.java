package notification_service.tests.unit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import notification_service.DateProvider;
import notification_service.Month;
import notification_service.Payment;
import notification_service.Payments;
import notification_service.UnusualSpendingDetector;
import notification_service.SpendingDelta;
import notification_service.UnusualSpending;
import notification_service.UserPayments;

public class UnusualSpendingDetectorTest {

  @Test
  public void when_there_are_no_current_payments_there_are_no_unusual_spending() {
    Payments payments = mock(Payments.class);
    DateProvider dateProvider = mock(DateProvider.class);
    Month currentMonth = new Month(5, 1945);
    Month previousMonth = new Month(4, 1945);
    int userId = 67;
    when(dateProvider.getCurrentMonth()).thenReturn(currentMonth);
    when(payments.getForUserAndDate(userId, currentMonth)).thenReturn(emptyUserPayments());
    when(payments.getForUserAndDate(userId, previousMonth)).thenReturn(previousMonthManyPayments());
    UnusualSpendingDetector detector = new UnusualSpendingDetector(dateProvider, payments);
    UnusualSpending expectedUnusualSpending = new UnusualSpending(userId, new ArrayList<>());

    UnusualSpending unusualSpending = detector.detectUnusualSpending(userId);

    assertThat(unusualSpending, is(expectedUnusualSpending));
  }

  @Test
  public void when_there_are_no_previous_payments_there_are_no_unusual_spending() {
    Payments payments = mock(Payments.class);
    DateProvider dateProvider = mock(DateProvider.class);
    Month currentMonth = new Month(5, 1945);
    Month previousMonth = new Month(4, 1945);
    int userId = 67;
    when(dateProvider.getCurrentMonth()).thenReturn(currentMonth);
    when(payments.getForUserAndDate(userId, currentMonth)).thenReturn(currentMonthManyPayments());
    when(payments.getForUserAndDate(userId, previousMonth)).thenReturn(emptyUserPayments());
    UnusualSpendingDetector detector = new UnusualSpendingDetector(dateProvider, payments);
    UnusualSpending expectedUnusualSpending = new UnusualSpending(userId, new ArrayList<>());

    UnusualSpending unusualSpending = detector.detectUnusualSpending(userId);

    assertThat(unusualSpending, is(expectedUnusualSpending));
  }

  @Test
  public void detects_unusual_spending_for_many_categories() {
    Payments payments = mock(Payments.class);
    DateProvider dateProvider = mock(DateProvider.class);
    Month currentMonth = new Month(5, 1945);
    Month previousMonth = new Month(4, 1945);
    int userId = 67;
    when(dateProvider.getCurrentMonth()).thenReturn(currentMonth);
    when(payments.getForUserAndDate(userId, currentMonth)).thenReturn(currentMonthManyPayments());
    when(payments.getForUserAndDate(userId, previousMonth)).thenReturn(previousMonthManyPayments());
    UnusualSpendingDetector detector = new UnusualSpendingDetector(dateProvider, payments);
    UnusualSpending expectedUnusualSpending;
    expectedUnusualSpending = new UnusualSpending(userId, Collections.singletonList(new SpendingDelta("groceries", 100, 150)));

    UnusualSpending unusualSpending = detector.detectUnusualSpending(userId);

    assertThat(unusualSpending, is(expectedUnusualSpending));
  }

  private UserPayments emptyUserPayments() {
    return new UserPayments(new ArrayList<>());
  }

  private UserPayments previousMonthManyPayments() {
    return new UserPayments(Arrays.asList(
        new Payment(100, "beer", "groceries"),
        new Payment(10, "Netflix subscription", "entertainment")
    ));
  }

  private UserPayments currentMonthManyPayments() {
    return new UserPayments(Arrays.asList(
        new Payment(135, "toilet paper", "groceries"),
        new Payment(15, "condoms", "groceries"),
        new Payment(14, "Netflix subscription", "entertainment"),
        new Payment(350, "Beretta", "armory")
    ));
  }

}
