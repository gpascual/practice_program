import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import Products.Product;
import static Products.ProductSupplier.askFor;
import static Products.ProductSupplier.askForAgedBrie;

public class GildedRoseTest {
  @Test
  public void given_an_item_when_sell_in_approaches_then_quality_decreases() {
    Inventory inventory = new Inventory();
    Product product = askFor("fromage", 20, 20);
    inventory.addProduct(product);

    inventory.updateQualities();

    int expectedSellIn = 19;
    int expectedQuality = 19;
    assertThat(product.getSellIn(), is(expectedSellIn));
    assertThat(product.getQuality(), is(expectedQuality));
  }

  @Test
  public void given_an_item_with_passed_sell_in_when_a_day_passes_then_quality_decreases_2x_faster() {
    Inventory inventory = new Inventory();
    Product product = askFor("fromage", -2, 20);
    inventory.addProduct(product);

    inventory.updateQualities();

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

    inventory.updateQualities();

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

    inventory.updateQualities();

    int expectedQuality = 0;
    assertThat(product.getQuality(), is(expectedQuality));
  }
}
