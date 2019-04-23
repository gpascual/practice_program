import Products.ProductSupplier;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import Products.Product;
import static Products.ProductSupplier.*;

public class GildedRoseTest {
  @Test
  public void given_an_product_when_sell_in_approaches_then_quality_decreases() {
    Inventory inventory = new Inventory();
    Product product = askFor("fromage", 20, 20);
    inventory.addProduct(product);

    inventory.updateProducts();

    int expectedSellIn = 19;
    int expectedQuality = 19;
    assertThat(product.getSellIn(), is(expectedSellIn));
    assertThat(product.getQuality(), is(expectedQuality));
  }

  @Test
  public void given_an_product_with_passed_sell_in_when_a_day_passes_then_quality_decreases_2x_faster() {
    Inventory inventory = new Inventory();
    Product product = askFor("fromage", -2, 20);
    inventory.addProduct(product);

    inventory.updateProducts();

    int expectedSellIn = -3;
    int expectedQuality = 18;
    assertThat(product.getSellIn(), is(expectedSellIn));
    assertThat(product.getQuality(), is(expectedQuality));
  }

  @Test
  public void given_aged_brie_when_a_day_passes_then_quality_increases() {
    Inventory inventory = new Inventory();
    Product product = askForAgedBrie(20, 20);
    Product otherBrie = askFor("Aged Brie", 20, 20);
    inventory.addProduct(product);
    inventory.addProduct(otherBrie);

    inventory.updateProducts();

    int expectedSellIn = 19;
    int expectedQuality = 21;
    assertThat(product.getSellIn(), is(expectedSellIn));
    assertThat(product.getQuality(), is(expectedQuality));
    assertThat(otherBrie.getSellIn(), is(expectedSellIn));
    assertThat(otherBrie.getQuality(), is(expectedQuality));
  }

  @Test
  public void given_a_product_without_any_quality_left_when_a_day_passes_then_its_quality_remains_zero() {
    Inventory inventory = new Inventory();
    Product product = askFor("fromage", 2, 0);
    inventory.addProduct(product);

    inventory.updateProducts();

    int expectedQuality = 0;
    assertThat(product.getQuality(), is(expectedQuality));
  }

  @Test
  public void given_a_product_whose_quality_is_50_when_a_day_passes_then_its_quality_doesnt_increase_anymore() {
    Inventory inventory = new Inventory();
    Product product = askForAgedBrie(2, 50);
    inventory.addProduct(product);

    inventory.updateProducts();

    int expectedQuality = 50;
    assertThat(product.getQuality(), is(expectedQuality));
  }

  @Test
  public void given_a_legendary_product_when_a_day_passes_then_its_quality_remains_80() {
    Inventory inventory = new Inventory();
    Product product = askForSulfuras();
    Product otherSulfuras = askFor("Sulfuras", 20, 20);
    inventory.addProduct(product);
    inventory.addProduct(otherSulfuras);

    inventory.updateProducts();

    int expectedQuality = 80;
    assertThat(product.getQuality(), is(expectedQuality));
    assertThat(otherSulfuras.getQuality(), is(expectedQuality));
  }

  @Test
  public void given_a_legendary_product_when_a_day_passes_then_its_sell_in_is_null() {
    Inventory inventory = new Inventory();
    Product product = askForSulfuras();
    inventory.addProduct(product);

    inventory.updateProducts();

    Integer expectedSellIn = null;
    assertThat(product.getSellIn(), is(expectedSellIn));
  }

  @Test
  public void given_backstage_passes_when_a_day_passes_then_its_quality_increases() {
    Inventory inventory = new Inventory();
    Product product = ProductSupplier.askForBackstagePasses(20, 20);
    Product otherBackstagePasses = askFor("Backstage passes", 20, 20);
    inventory.addProduct(product);
    inventory.addProduct(otherBackstagePasses);

    inventory.updateProducts();

    int expectedSellIn = 19;
    int expectedQuality = 21;
    assertThat(product.getSellIn(), is(expectedSellIn));
    assertThat(product.getQuality(), is(expectedQuality));
    assertThat(otherBackstagePasses.getSellIn(), is(expectedSellIn));
    assertThat(otherBackstagePasses.getQuality(), is(expectedQuality));
  }

  @Test
  public void given_backstage_passes_when_there_are_10_or_less_days_to_sell_in_then_the_quality_increases_by_2() {
    Inventory inventory = new Inventory();
    Product product = askForBackstagePasses(11, 20);
    Product otherBackstagePasses = askForBackstagePasses(10, 20);
    inventory.addProduct(product);
    inventory.addProduct(otherBackstagePasses);

    inventory.updateProducts();

    Integer expectedQuality = 22;
    assertThat(product.getQuality(), is(expectedQuality));
    assertThat(otherBackstagePasses.getQuality(), is(expectedQuality));
  }

  @Test
  public void given_backstage_passes_when_there_are_5_or_less_days_to_sell_in_then_the_quality_increases_by_3() {
    Inventory inventory = new Inventory();
    Product product = askForBackstagePasses(6, 20);
    Product otherBackstagePasses = askForBackstagePasses(5, 20);
    inventory.addProduct(product);
    inventory.addProduct(otherBackstagePasses);

    inventory.updateProducts();

    Integer expectedQuality = 23;
    assertThat(product.getQuality(), is(expectedQuality));
    assertThat(otherBackstagePasses.getQuality(), is(expectedQuality));
  }
}
