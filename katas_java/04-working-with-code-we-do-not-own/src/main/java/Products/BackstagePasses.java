package Products;

class BackstagePasses extends Product {
  private static final int MAXIMUM_QUALITY = 50;

  BackstagePasses(int sellIn, int initialQuality) {
    initializeProduct("Backstage passes", sellIn, initialQuality);
  }

  @Override
  public void updateQuality() {
    if (getSellIn() < 0) {
      removeRemainingQuality();
    }
    else if (getSellIn() <= 5) {
      increaseQuality(3);
    }
    else if (getSellIn() <= 10) {
      increaseQuality(2);
    }
    else {
      increaseQuality(1);
    }

    applyMaximumQualityBoundary(getQuality(), MAXIMUM_QUALITY);
  }
}
