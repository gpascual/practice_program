package Products;

import java.util.Objects;
import items.Item;

public class Product {
  private static final int MINIMUM_QUALITY = 0;

  protected final Item item;

  Product(String name, int sellIn, int initialQuality) {
    item = new Item(name, sellIn, initialQuality);
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

  public void updateQuality() {
    if (item.sellIn < 0) {
      item.quality -= 2;
    } else {
      --item.quality;
    }

    item.quality = Math.max(MINIMUM_QUALITY, item.quality);
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
