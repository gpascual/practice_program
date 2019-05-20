package beverages;

public class WithCream implements Beverage {
  private final Beverage beverage;

  public WithCream(Beverage beverage) {
    this.beverage = beverage;
  }

  @Override
  public double price() {
    return this.beverage.price() + 0.15;
  }
}
