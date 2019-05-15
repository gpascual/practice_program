package Products;

import java.util.Objects;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    Conjured conjured = (Conjured) o;
    return Objects.equals(conjuredProduct, conjured.conjuredProduct);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), conjuredProduct);
  }
}
