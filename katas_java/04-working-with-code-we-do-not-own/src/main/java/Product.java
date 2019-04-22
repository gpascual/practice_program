import items.Item;

import java.util.Objects;

public class Product {
  private final Item item;

  public Product(String name, int sellIn, int initialQuality) {
    item = new Item(name, sellIn, initialQuality);
  }

  public int getSellIn() {
    return item.sellIn;
  }

  public int getQuality() {
    return item.quality;
  }

  public void updateQuality() {
    --item.sellIn;

    if (Objects.equals(item.name, "Aged Brie")) {
      ++item.quality;
      return;
    }

    if (item.sellIn < 0) {
      item.quality -= 2;
    } else {
      --item.quality;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Product product = (Product) o;
    return item.equals(product.item);
  }

  @Override
  public int hashCode() {
    return Objects.hash(item);
  }
}
