package Products;

class Legendary extends Product {
  private static final int LEGENDARY_QUALITY = 80;

  Legendary(String name, int sellIn) {
    super(name, sellIn, LEGENDARY_QUALITY);
  }

  @Override
  public void updateQuality() {}
}
