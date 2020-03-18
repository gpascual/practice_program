package notification_service;

import java.util.Objects;

public class SpendingDelta {

  public static final double UNUSUAL_INCREMENT_FACTOR = 1.5;
  private final String category;
  private final Integer previousSpending;
  private final Integer currentSpending;

  public SpendingDelta(String category, Integer previousSpending, Integer currentSpending) {

    this.category = category;
    this.previousSpending = previousSpending;
    this.currentSpending = currentSpending;
  }

  public String getCategory() {
    return category;
  }

  public int getAmount() {
    return currentSpending;
  }

  public boolean isUnusual() {
    return previousSpending != null && currentSpending >= UNUSUAL_INCREMENT_FACTOR * previousSpending;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SpendingDelta that = (SpendingDelta) o;
    return Objects.equals(category, that.category) &&
           Objects.equals(previousSpending, that.previousSpending) &&
           Objects.equals(currentSpending, that.currentSpending);
  }

  @Override
  public int hashCode() {
    return Objects.hash(category, previousSpending, currentSpending);
  }

  @Override
  public String toString() {
    return "UnusualSpending{" +
           "category='" + category + '\'' +
           ", previousSpending=" + previousSpending +
           ", currentSpending=" + currentSpending +
           '}';
  }
}
