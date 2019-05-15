package Products;

public class RegularProduct extends Product {
  RegularProduct(String name, int sellIn, int initialQuality) {
    initializeProduct(name, sellIn, initialQuality);
  }

  @Override
  public void updateQuality() {
    if (getSellIn() < 0) {
      decreaseQuality(2);
    } else {
      decreaseQuality(1);
    }

    applyMinimumQualityBoundary(getQuality(), MINIMUM_QUALITY);
  }
}
