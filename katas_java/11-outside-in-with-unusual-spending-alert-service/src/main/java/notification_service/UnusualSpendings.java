package notification_service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class UnusualSpendings {

  private int userId;
  private ArrayList<UnusualSpending> unusualSpendings;

  public UnusualSpendings(int userId, ArrayList<UnusualSpending> unusualSpendings)
  {
    this.userId = userId;
    this.unusualSpendings = unusualSpendings;
  }

  public void addUnusualSpending(UnusualSpending unusualSpending) {
    unusualSpendings.add(unusualSpending);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UnusualSpendings that = (UnusualSpendings) o;
    return userId == that.userId &&
           Objects.equals(unusualSpendings, that.unusualSpendings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, unusualSpendings);
  }

  @Override
  public String toString() {
    return "UnusualSpendings{" +
           "userId=" + userId +
           ", unusualSpendings=" + unusualSpendings +
           '}';
  }

  public boolean hasUnusualSpendings() {
    return unusualSpendings.size() > 0;
  }
}
