package Products;

import java.util.Objects;

public class ProductSupplier {
  private static final String AGED_BRIE_PRODUCT_NAME = "Aged Brie";
  private static final String SULFURAS_PRODUCT_NAME = "Sulfuras";
  private static final String BACKSTAGE_PASSES_PRODUCT_NAME = "Backstage passes";
  private static final String CONJURED_PRODUCT_NAME = "Conjured";

  public static Product askFor(String name, int sellIn, int initialQuality) {
    switch (name) {
      case AGED_BRIE_PRODUCT_NAME:
        return new IncreasingQualityProduct(AGED_BRIE_PRODUCT_NAME, sellIn, initialQuality);
      case SULFURAS_PRODUCT_NAME:
        return new Legendary(SULFURAS_PRODUCT_NAME);
      case BACKSTAGE_PASSES_PRODUCT_NAME:
        return new BackstagePasses(BACKSTAGE_PASSES_PRODUCT_NAME, sellIn, initialQuality);
      case CONJURED_PRODUCT_NAME:
        return new Conjured(CONJURED_PRODUCT_NAME, sellIn, initialQuality);
      default:
        return new Product(name, sellIn, initialQuality);
    }
  }

  public static Product askFor(String name) throws MissingSellInAndQuality {
    if (Objects.equals(name, SULFURAS_PRODUCT_NAME)) {
      return new Legendary(name);
    }

    throw new MissingSellInAndQuality("Only legendary products don't need either sellIn or quality");
  }

  public static class MissingSellInAndQuality extends Throwable {
    MissingSellInAndQuality(String message) {
      super(message);
    }
  }
}
