package Products;

import java.util.Objects;
import items.Item;

public class Product {
  protected final Item item;

  Product(String name, int sellIn, int initialQuality) {
    item = new Item(name, sellIn, initialQuality);
  }

  public static Product create(String name, int sellIn, int initialQuality) {
    if (Objects.equals(name, AgedBrie.AGED_BRIE_PRODUCT_NAME)) {
      return new AgedBrie(sellIn, initialQuality);
    }
    return new Product(name, sellIn, initialQuality);
  }

  public static Product createAgedBrie(int sellIn, int initialQuality) {
    return new AgedBrie(sellIn, initialQuality);
  }

  public int getSellIn() {
    return item.sellIn;
  }

  public int getQuality() {
    return item.quality;
  }

  public void updateQuality() {
    --item.sellIn;

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
