package Products;

class AgedBrie extends Product {
  private static final int MAXIMUM_QUALITY = 50;

  AgedBrie(String name, int sellIn, int initialQuality) {
    initializeProduct(name, sellIn, initialQuality);
  }

  @Override
  public void updateQuality() {
    increaseQuality(1);
    applyMaximumQualityBoundary(getQuality(), MAXIMUM_QUALITY);
  }
}
