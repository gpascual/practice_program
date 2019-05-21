package beverages;

public abstract class BeverageExtra implements Beverage {
  protected final Beverage beverage;

  public BeverageExtra(Beverage beverage) {
    this.beverage = beverage;
  }

  @Override
  public double price() {
    return this.beverage.price() + priceIncrement();
  }

  protected abstract double priceIncrement();
}
