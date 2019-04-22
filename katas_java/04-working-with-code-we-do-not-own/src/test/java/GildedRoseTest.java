import items.Item;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GildedRoseTest {
  @Test
  public void given_an_item_when_sell_in_approaches_then_quality_decreases() {
    Inventory inventory = new Inventory();
    Item item = new Item("fromage", 20, 20);
    inventory.addItem(item);

    inventory.updateQuality();

    int expectedSellIn = 19;
    int expectedQuality = 19;
    assertThat(item.sellIn, is(expectedSellIn));
    assertThat(item.quality, is(expectedQuality));
  }
}
