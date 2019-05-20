package beverages;

public class WithCream implements Beverage {
  private final HotChocolate hotChocolate;

  public WithCream(HotChocolate hotChocolate) {
    this.hotChocolate = hotChocolate;
  }

  @Override
  public double price() {
    return this.hotChocolate.price() + 0.15;
  }
}
