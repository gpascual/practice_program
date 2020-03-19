package notification_service;

import java.util.Objects;

public class Payment {

  private final int price;
  private final String description;
  private final String category;

  public Payment(int price, String description, String category) {
    this.price = price;
    this.description = description;
    this.category = category;
  }

  public int getPrice() {
    return price;
  }

  public String getCategory() {
    return category;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Payment payment = (Payment) o;
    return price == payment.price &&
           Objects.equals(description, payment.description) &&
           Objects.equals(category, payment.category);
  }

  @Override
  public int hashCode() {
    return Objects.hash(price, description, category);
  }

  @Override
  public String toString() {
    return "Payment{" +
           "price=" + price +
           ", description='" + description + '\'' +
           ", category='" + category + '\'' +
           '}';
  }
}
