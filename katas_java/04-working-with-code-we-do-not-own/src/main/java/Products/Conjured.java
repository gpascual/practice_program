package Products;

public class Conjured extends Product {
  public Conjured(String conjured, int sellIn, int initialQuality) {
    super(conjured, sellIn, initialQuality);
  }

  @Override
  public void updateQuality() {
    super.updateQuality();
    super.updateQuality();
  }
}
