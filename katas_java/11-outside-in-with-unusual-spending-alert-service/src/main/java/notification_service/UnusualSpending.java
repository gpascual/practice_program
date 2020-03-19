package notification_service;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class UnusualSpending {

  private int userId;
  private List<SpendingDelta> spendingDeltas;

  public UnusualSpending(int userId, List<SpendingDelta> spendingDeltas)
  {
    this.userId = userId;
    this.spendingDeltas = spendingDeltas;
  }

  public int getUserId() {
    return userId;
  }

  public boolean hasUnusualSpending() {
    return spendingDeltas.size() > 0;
  }

  public Iterator<SpendingDelta> iterate() {
    return this.spendingDeltas.iterator();
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
    return userId == that.userId &&
           Objects.equals(spendingDeltas, that.spendingDeltas);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, spendingDeltas);
  }

  @Override
  public String toString() {
    return "UnusualSpending{" +
           "userId=" + userId +
           ", spendingDeltas=" + spendingDeltas +
           '}';
  }
}
