package Products;

class AgedBrie extends Product {
  protected static final int MAXIMUM_QUALITY = 50;

  AgedBrie(String name, int sellIn, int initialQuality) {
    super(name, sellIn, initialQuality);
  }

  @Override
  public void updateQuality() {
    ++item.quality;

    item.quality = applyMaximumQualityBoundary(item.quality);
  }

  protected int applyMaximumQualityBoundary(int quality) {
    return Math.min(MAXIMUM_QUALITY, quality);
  }
}
