package Products;

class BackstagePasses extends AgedBrie {
  BackstagePasses(String name, int sellIn, int initialQuality) {
    super(name, sellIn, initialQuality);
  }

  @Override
  public void updateQuality() {
    if (item.sellIn <= 10) {
      item.quality +=2;
      item.quality = Math.min(MAXIMUM_QUALITY, item.quality);
      return;
    }

    super.updateQuality();
  }
}
