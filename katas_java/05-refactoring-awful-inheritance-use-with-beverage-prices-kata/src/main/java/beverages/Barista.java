package beverages;

public class Barista {
  private Beverage beverage;
  private boolean hasMilk = false;
  private boolean hasCream = false;
  private boolean hasCinnamon = false;

  public static Barista askForCoffee() {
    return new Barista().withCoffee();
  }

  public static Barista askForTea() {
    return new Barista().withTea();
  }

  public static Barista askForHotChocolate() {
    return new Barista().withHotChocolate();
  }

  private Barista withCoffee() {
    beverage = new Coffee();
    return this;
  }

  private Barista withTea() {
    beverage = new Tea();
    return this;
  }

  private Barista withHotChocolate() {
    beverage = new HotChocolate();
    return this;
  }

  public Barista withMilk() {
    hasMilk = true;
    return this;
  }

  public Barista withCream() {
    hasCream = true;
    return this;
  }

  public Barista withCinnamon() {
    hasCinnamon = true;
    return this;
  }

  public Beverage prepare() {
    if (hasMilk) {
      beverage = new WithMilk(beverage);
    }

    if (hasCream) {
      beverage = new WithCream(beverage);
    }

    if (hasCinnamon) {
      beverage = new WithCinnamon(beverage);
    }

    return beverage;
  }
}
