package Products;

public class Conjured extends Product {
  private RegularProduct conjuredProduct;

  public Conjured(String conjured, int sellIn, int initialQuality) {
    super(conjured, sellIn, initialQuality);
    this.conjuredProduct = new RegularProduct(conjured, sellIn, initialQuality);
  }

  @Override
  public Integer getSellIn() {
    return conjuredProduct.getSellIn();
  }

  @Override
  public int getQuality() {
    return conjuredProduct.getQuality();
  }

  @Override
  public void updateQuality() {
    conjuredProduct.updateQuality();
    conjuredProduct.updateQuality();
  }

  @Override
  public void updateSellIn() {
    conjuredProduct.updateSellIn();
  }
}
