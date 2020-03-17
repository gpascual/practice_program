package notification_service.tests.unit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import notification_service.DateProvider;
import notification_service.Month;
import notification_service.Payment;
import notification_service.Payments;
import notification_service.RenameMeUnusualSpendingDetector;
import notification_service.UnusualSpending;
import notification_service.UnusualSpendings;
import notification_service.UnusualSpendingsDetector;
import notification_service.UserPayments;

public class UnusualSpendingsDetectorTest {

  @Test
  public void when_there_are_no_current_payments_there_are_no_unusual_spendings() {
    Payments payments = mock(Payments.class);
    DateProvider dateProvider = mock(DateProvider.class);
    Month currentMonth = new Month(5, 1945);
    Month previousMonth = new Month(4, 1945);
    int userId = 67;
    when(dateProvider.getCurrentMonth()).thenReturn(currentMonth);
    when(payments.getForUserAndDate(userId, currentMonth)).thenReturn(new UserPayments(new ArrayList<>()));
    when(payments.getForUserAndDate(userId, previousMonth)).thenReturn(new UserPayments(previousMonthManyPayments()));
    UnusualSpendingsDetector detector = new RenameMeUnusualSpendingDetector(dateProvider, payments);
    UnusualSpendings expectedUnusualSpendings = new UnusualSpendings(userId, new ArrayList<>());

    UnusualSpendings unusualSpendings = detector.detectUnusualSpendings(userId);

    assertThat(unusualSpendings, is(expectedUnusualSpendings));
  }

  @Test
  public void when_there_are_no_previous_payments_there_are_no_unusual_spendings() {
    Payments payments = mock(Payments.class);
    DateProvider dateProvider = mock(DateProvider.class);
    Month currentMonth = new Month(5, 1945);
    Month previousMonth = new Month(4, 1945);
    int userId = 67;
    when(dateProvider.getCurrentMonth()).thenReturn(currentMonth);
    when(payments.getForUserAndDate(userId, currentMonth)).thenReturn(new UserPayments(currentMonthManyPayments()));
    when(payments.getForUserAndDate(userId, previousMonth)).thenReturn(new UserPayments(new ArrayList<>()));
    UnusualSpendingsDetector detector = new RenameMeUnusualSpendingDetector(dateProvider, payments);
    UnusualSpendings expectedUnusualSpendings = new UnusualSpendings(userId, new ArrayList<>());

    UnusualSpendings unusualSpendings = detector.detectUnusualSpendings(userId);

    assertThat(unusualSpendings, is(expectedUnusualSpendings));
  }

  @Test
  public void detects_unusual_spending_for_many_categories() {
    Payments payments = mock(Payments.class);
    DateProvider dateProvider = mock(DateProvider.class);
    Month currentMonth = new Month(5, 1945);
    Month previousMonth = new Month(4, 1945);
    int userId = 67;
    when(dateProvider.getCurrentMonth()).thenReturn(currentMonth);
    when(payments.getForUserAndDate(userId, currentMonth)).thenReturn(new UserPayments(currentMonthManyPayments()));
    when(payments.getForUserAndDate(userId, previousMonth)).thenReturn(new UserPayments(previousMonthManyPayments()));
    UnusualSpendingsDetector detector = new RenameMeUnusualSpendingDetector(dateProvider, payments);
    UnusualSpendings expectedUnusualSpendings;
    expectedUnusualSpendings = new UnusualSpendings(userId, Collections.singletonList(new UnusualSpending("groceries", 150)));

    UnusualSpendings unusualSpendings = detector.detectUnusualSpendings(userId);

    assertThat(unusualSpendings, is(expectedUnusualSpendings));
  }

  private List<Payment> currentMonthManyPayments() {
    List<Payment> payments = Arrays.asList(
        new Payment(135, "toilet paper", "groceries"),
        new Payment(15, "condoms", "groceries"),
        new Payment(14, "Netflix subscription", "entertainment"),
        new Payment(350, "Beretta", "armory")
    );
    return payments;
  }

  private List<Payment> previousMonthManyPayments() {
    List<Payment> payments = Arrays.asList(
        new Payment(100, "beer", "groceries"),
        new Payment(10, "Netflix subscription", "entertainment")
    );
    return payments;
  }

}
