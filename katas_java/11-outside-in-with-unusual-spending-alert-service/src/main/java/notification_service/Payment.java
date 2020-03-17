package notification_service;

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
}
