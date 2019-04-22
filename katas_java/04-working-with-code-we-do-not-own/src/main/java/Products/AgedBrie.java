package Products;

public class AgedBrie extends Product {

  AgedBrie(String name, int sellIn, int initialQuality) {
    super(name, sellIn, initialQuality);
  }

  @Override
  public void updateQuality() {
    --item.sellIn;
    ++item.quality;
  }
}
