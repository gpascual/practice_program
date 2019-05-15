package Products;

class BackstagePasses extends Product {
  private static final int MAXIMUM_QUALITY = 50;

  BackstagePasses(String name, int sellIn, int initialQuality) {
    super(name, sellIn, initialQuality);
  }

  @Override
  public void updateQuality() {
    if (item.sellIn < 0) {
      item.quality = 0;
    }
    else if (item.sellIn <= 5) {
      increaseQuality(3);
    }
    else if (item.sellIn <= 10) {
      increaseQuality(2);
    }
    else {
      increaseQuality(1);
    }

    item.quality = applyMaximumQualityBoundary(item.quality, MAXIMUM_QUALITY);
  }
}
