import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GildedRoseTest {
  @Test
  public void given_an_item_when_sell_in_approaches_then_quality_decreases() {
    Inventory inventory = new Inventory();
    Product product = new Product("fromage", 20, 20);
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
    Product product = new Product("fromage", -2, 20);
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
    Product product = new Product("Aged Brie", 20, 20);
    inventory.addProduct(product);

    inventory.updateQualities();

    int expectedSellIn = 19;
    int expectedQuality = 21;
    assertThat(product.getSellIn(), is(expectedSellIn));
    assertThat(product.getQuality(), is(expectedQuality));
  }
}
