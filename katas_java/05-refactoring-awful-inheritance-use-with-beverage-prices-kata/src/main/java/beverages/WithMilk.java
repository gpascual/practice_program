package beverages;

public class WithMilk implements Beverage {
  private final Tea beverage;

  public WithMilk(Tea tea) {
    this.beverage = tea;
  }

  @Override
  public double price() {
    return this.beverage.price() + 0.10;
  }
}
