package beverages;

public class WithCinnamon extends BeverageExtra {

  public WithCinnamon(Beverage beverage) {
    super(beverage);
  }

  @Override
  protected double priceIncrement() {
    return 0.05;
  }
}
