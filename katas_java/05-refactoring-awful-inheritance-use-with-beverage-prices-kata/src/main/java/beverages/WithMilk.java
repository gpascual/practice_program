package beverages;

public class WithMilk extends BeverageExtra {

  public WithMilk(Beverage beverage) {
    super(beverage);
  }

  @Override
  protected double priceIncrement() {
    return 0.10;
  }
}
