package notification_service.tests.acceptance;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

import java.util.ArrayList;

import notification_service.DateProvider;
import notification_service.Month;
import notification_service.Notification;
import notification_service.NotificationSender;
import notification_service.Payment;
import notification_service.Payments;
import notification_service.UnusualSpendingsNotifier;
import notification_service.User;
import notification_service.UserPayments;
import notification_service.Users;

public class NotifyingUsersWithUnusualSpendingsTest {
    @Test
    public void notifying_users_with_unusual_spendings_in_some_categories() {
        DateProvider dateProvider = mock(DateProvider.class);
        Payments payments = mock(Payments.class);
        Users users = mock(Users.class);
        NotificationSender notificationService = mock(NotificationSender.class);
        int userId = 5;
        String userMail = "user@mail.com";
        User user = new User(userId, userMail);
        Notification notification = new Notification(user, notificationContent());
        UnusualSpendingsNotifier unusualSpendingsNotifier = new UnusualSpendingsNotifier(dateProvider, payments, notificationService, users);
        Month currentMonth = new Month(12, 1975);
        Month previousMonth = new Month(11, 1975);

        when(users.getUser(userId)).thenReturn(user);
        when(payments.getForUserAndDate(userId, currentMonth)).thenReturn(getCurrentMonthUserPayments());
        when(payments.getForUserAndDate(userId, previousMonth)).thenReturn(getPreviousMonthUserPayments());
        when(dateProvider.getCurrentMonth()).thenReturn(currentMonth);

        unusualSpendingsNotifier.notify(userId);

        verify(notificationService).send(notification);
    }

    private UserPayments getPreviousMonthUserPayments() {
        ArrayList<Payment> payments = new ArrayList<>();
        payments.add(new Payment(100, "pay", "groceries"));
        payments.add(new Payment(400, "pay2", "travel"));
        payments.add(new Payment(200, "pay3", "entertainment"));
        return new UserPayments(payments);
    }

    private UserPayments getCurrentMonthUserPayments() {
        ArrayList<Payment> payments = new ArrayList<>();
        payments.add(new Payment(150, "pay", "groceries"));
        payments.add(new Payment(600, "pay2", "travel"));
        payments.add(new Payment(299, "pay3", "entertainment"));
        return new UserPayments(payments);
    }

    private String notificationContent() {
        return "Hello card user!\n" +
                                                           "We have detected unusually high spending on your card in these categories:\n" +
                                                           "* You spent $150 on groceries\n" +
                                                           "* You spent $600 on travel\n" +
                                                           "Love,\n" +
                                                           "The Credit Card Company\n";
    }
}
