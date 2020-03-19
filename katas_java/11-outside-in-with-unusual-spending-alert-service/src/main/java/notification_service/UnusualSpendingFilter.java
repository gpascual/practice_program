package notification_service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UnusualSpendingFilter {

  private final int userId;
  private final Map<String, Integer> currentSpending;
  private final Map<String, Integer> previousSpending;

  public UnusualSpendingFilter(int userId, Map<String, Integer> currentSpending, Map<String, Integer> previousSpending) {

    this.userId = userId;
    this.currentSpending = currentSpending;
    this.previousSpending = previousSpending;
  }

  public UnusualSpending filter() {
    return new UnusualSpending(
        userId,
        mapToSpendingDelta().stream()
          .filter(SpendingDelta::isUnusual)
          .collect(Collectors.toList())
    );
  }

  private List<SpendingDelta> mapToSpendingDelta() {
    return currentSpending.entrySet().stream()
        .map(entry -> {
          String category = entry.getKey();
          Integer currentSpending = entry.getValue();
          Integer previousSpending = this.previousSpending.getOrDefault(category, null);
          return new SpendingDelta(category, previousSpending, currentSpending);
        })
        .collect(Collectors.toList());
  }
}
