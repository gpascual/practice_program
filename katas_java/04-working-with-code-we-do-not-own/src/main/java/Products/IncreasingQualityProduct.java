package Products;

class IncreasingQualityProduct extends Product {
  protected static final int MAXIMUM_QUALITY = 50;

  IncreasingQualityProduct(String name, int sellIn, int initialQuality) {
    super(name, sellIn, initialQuality);
  }

  @Override
  public void updateQuality() {
    increaseQuality(1);
    item.quality = applyMaximumQualityBoundary(item.quality);
  }

  protected int applyMaximumQualityBoundary(int quality) {
    return Math.min(MAXIMUM_QUALITY, quality);
  }

  protected void increaseQuality(int increment) {
    item.quality += increment;
    item.quality = applyMaximumQualityBoundary(item.quality);
  }
}
