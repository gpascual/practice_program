package Products;

import java.util.Objects;
import items.Item;

abstract public class Product {
  private static final int MINIMUM_QUALITY = 0;
  private static final int MAXIMUM_QUALITY = 50;

  private Item item;

  final void initializeProduct(String name, int sellIn, int initialQuality) {
    item = new Item(name, sellIn, initialQuality);
  }

  abstract public void updateQuality();

  void applyMinimumQualityBoundary() {
    item.quality = Math.max(Product.MINIMUM_QUALITY, item.quality);
  }

  void applyMaximumQualityBoundary() {
    item.quality = Math.min(MAXIMUM_QUALITY, item.quality);
  }

  void removeRemainingQuality() {
    item.quality = 0;
  }

  void increaseQuality(int increment) {
    item.quality += increment;
  }

  void decreaseQuality(int decrement) {
    item.quality -= decrement;
  }

  public void updateSellIn() {
    --item.sellIn;
  }

  public Integer getSellIn() {
    return item.sellIn;
  }

  public int getQuality() {
    return item.quality;
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
