package notification_service;

import java.util.Objects;

public class UnusualSpending {

  private final String category;
  private final int amount;

  public UnusualSpending(String category, int amount) {
    this.category = category;
    this.amount = amount;
  }

  public String getCategory() {
    return category;
  }

  public int getAmount() {
    return amount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UnusualSpending that = (UnusualSpending) o;
    return amount == that.amount &&
           Objects.equals(category, that.category);
  }

  @Override
  public int hashCode() {
    return Objects.hash(category, amount);
  }

  @Override
  public String toString() {
    return "UnusualSpending{" +
           "category='" + category + '\'' +
           ", amount=" + amount +
           '}';
  }
}
