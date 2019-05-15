package Products;

public class ProductSupplier {

  public static Product askFor(String name, int sellIn, int initialQuality) {
    return new RegularProduct(name, sellIn, initialQuality);
  }

  public static Product askForAgedBrie(String name, int sellIn, int initialQuality) {
    return new AgedBrie(name, sellIn, initialQuality);
  }

  public static Product askForLegendary(String name) {
    return new Legendary(name);
  }

  public static Product askForBackstagePasses(String name, int sellIn, int initialQuality) {
    return new BackstagePasses(name, sellIn, initialQuality);
  }

  public static Product askForConjured(String name, int sellIn, int initialQuality) {
    return new Conjured(name, sellIn, initialQuality);
  }
}
