package notification_service;

import java.util.Objects;

public class Month {

  private final int month;
  private final int year;

  public Month(int month, int year) {

    this.month = month;
    this.year = year;
  }

  public Month previousMonth() {
    int newMonth;
    int newYear;
    if(month == 1) {
      newMonth = 12;
      newYear = year - 1;
    } else {
      newMonth = month - 1;
      newYear = year;
    }

    return new Month(newMonth, newYear);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Month month1 = (Month) o;
    return month == month1.month &&
           year == month1.year;
  }

  @Override
  public int hashCode() {
    return Objects.hash(month, year);
  }

  @Override
  public String toString() {
    return "Month{" +
           "month=" + month +
           ", year=" + year +
           '}';
  }
}
