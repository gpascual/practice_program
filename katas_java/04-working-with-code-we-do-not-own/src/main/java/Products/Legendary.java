package Products;

class Legendary extends Product {
  private static final int LEGENDARY_QUALITY = 80;
  private static final int UNDEFINED_SELL_IN = -1;

  Legendary(String name) {
    super(name, UNDEFINED_SELL_IN, LEGENDARY_QUALITY);
  }

  @Override
  public void updateQuality() {}

  @Override
  public Integer getSellIn() {
    return null;
  }
}
