package Products;

public class Conjured extends Product {
  private RegularProduct conjuredProduct;

  public Conjured(String name, int sellIn, int initialQuality) {
    this.conjuredProduct = new RegularProduct(name, sellIn, initialQuality);
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
