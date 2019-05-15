package Products;

class BackstagePasses extends Product {

  BackstagePasses(String name, int sellIn, int initialQuality) {
    initializeProduct(name, sellIn, initialQuality);
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

    applyMaximumQualityBoundary();
  }
}
