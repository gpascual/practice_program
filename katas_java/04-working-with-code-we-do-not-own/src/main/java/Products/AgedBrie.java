package Products;

public class AgedBrie extends Product {
  static final String AGED_BRIE_PRODUCT_NAME = "Aged Brie";

  AgedBrie(int sellIn, int initialQuality) {
    super(AGED_BRIE_PRODUCT_NAME, sellIn, initialQuality);
  }

  @Override
  public void updateQuality() {
    --item.sellIn;
    ++item.quality;
  }
}
