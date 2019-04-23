package Products;

class BackstagePasses extends IncreasingQualityProduct {
  BackstagePasses(String name, int sellIn, int initialQuality) {
    super(name, sellIn, initialQuality);
  }

  @Override
  public void updateQuality() {
    if (item.sellIn <= 5) {
      increaseQuality(3);
      return;
    }
    if (item.sellIn <= 10) {
      increaseQuality(2);
      return;
    }

    super.updateQuality();
  }
}
