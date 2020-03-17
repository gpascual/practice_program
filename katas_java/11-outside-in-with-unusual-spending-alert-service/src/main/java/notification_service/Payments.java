package notification_service;

public interface Payments {

  UserPayments getForUserAndDate(int userId, Month currentMonth);
}
