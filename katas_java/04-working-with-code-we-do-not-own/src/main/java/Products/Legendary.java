package Products;

class Legendary extends Product {
  Legendary(String name, int sellIn) {
    super(name, sellIn, 80);
  }

  @Override
  public void updateQuality() {
    --item.sellIn;
  }
}
