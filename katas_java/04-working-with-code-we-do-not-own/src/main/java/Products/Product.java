package Products;

import java.util.Objects;
import items.Item;

abstract public class Product {
  static final int MINIMUM_QUALITY = 0;

  final Item item;

  Product(String name, int sellIn, int initialQuality) {
    item = new Item(name, sellIn, initialQuality);
  }

  abstract public void updateQuality();

  int applyMaximumQualityBoundary(int quality, int maximumQuality) {
    return Math.min(maximumQuality, quality);
  }

  void increaseQuality(int increment) {
    item.quality += increment;
  }

  public Integer getSellIn() {
    return item.sellIn;
  }

  public int getQuality() {
    return item.quality;
  }

  public void updateSellIn() {
    --item.sellIn;
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
