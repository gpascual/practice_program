package notification_service;

public interface UnusualSpendingsDetector {

  UnusualSpendings detectUnusualSpendings(int userId);
}
