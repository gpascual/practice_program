package beverages;

public class WithCinnamon implements Beverage {
  private final Beverage beverage;

  public WithCinnamon(Beverage beverage) {
    this.beverage = beverage;
  }

  @Override
  public double price() {
    return this.beverage.price() + 0.05;
  }
}
