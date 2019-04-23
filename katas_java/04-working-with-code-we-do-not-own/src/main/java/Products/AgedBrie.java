package Products;

public class AgedBrie extends Product {
  private static final int MAXIMUM_QUALITY = 50;

  AgedBrie(String name, int sellIn, int initialQuality) {
    super(name, sellIn, initialQuality);
  }

  @Override
  public void updateQuality() {
    ++item.quality;

    item.quality = Math.min(MAXIMUM_QUALITY, item.quality);
  }
}
