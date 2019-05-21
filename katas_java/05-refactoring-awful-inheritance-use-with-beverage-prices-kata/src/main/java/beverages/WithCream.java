package beverages;

public class WithCream extends BeverageExtra {

  public WithCream(Beverage beverage) {
    super(beverage);
  }

  @Override
  protected double priceIncrement() {
    return 0.15;
  }
}
