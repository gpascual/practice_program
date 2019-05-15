package Products;

class AgedBrie extends Product {

  AgedBrie(String name, int sellIn, int initialQuality) {
    initializeProduct(name, sellIn, initialQuality);
  }

  @Override
  public void updateQuality() {
    increaseQuality(1);
    applyMaximumQualityBoundary();
  }
}
