package Products;

import java.util.Objects;

public class ProductSupplier {
  private static final String AGED_BRIE_PRODUCT_NAME = "Aged Brie";

  public static Product askFor(String name, int sellIn, int initialQuality) {
    if (Objects.equals(name, AGED_BRIE_PRODUCT_NAME)) {
      return new AgedBrie(AGED_BRIE_PRODUCT_NAME, sellIn, initialQuality);
    }
    return new Product(name, sellIn, initialQuality);
  }

  public static Product askForAgedBrie(int sellIn, int initialQuality) {
    return new AgedBrie(AGED_BRIE_PRODUCT_NAME, sellIn, initialQuality);
  }
}
