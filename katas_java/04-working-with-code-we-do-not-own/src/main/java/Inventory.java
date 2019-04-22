import items.Item;

import java.util.ArrayList;
import java.util.Objects;

public class Inventory {
  private ArrayList<Item> items;
  private ArrayList<Product> products;

  public Inventory() {
    this.items = new ArrayList<>();
    products = new ArrayList<>();
  }

  public void updateQualities() {
    for (Product product : products) {
      product.updateQuality();
    }
    for (Item item : items) {
      --item.sellIn;

      if (item.sellIn < 0) {
        item.quality -= 2;
      } else {
        --item.quality;
      }
    }
  }

  public void addItem(Item item) {
    items.add(item);
  }

  public void addProduct(Product product) {
    products.add(product);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Inventory inventory = (Inventory) o;
    return products.equals(inventory.products);
  }

  @Override
  public int hashCode() {
    return Objects.hash(products);
  }
}
