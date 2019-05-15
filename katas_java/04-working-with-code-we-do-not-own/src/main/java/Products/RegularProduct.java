package Products;

public class RegularProduct extends Product {
  RegularProduct(String name, int sellIn, int initialQuality) {
    super(name, sellIn, initialQuality);
  }

  @Override
  public void updateQuality() {
    if (item.sellIn < 0) {
      item.quality -= 2;
    } else {
      --item.quality;
    }

    item.quality = Math.max(MINIMUM_QUALITY, item.quality);
  }
}
