import items.Item;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GildedRoseTest {
    @Test
    public void given_an_item_when_sell_in_approaches_then_quality_decreases() {
        ArrayList<Item> items = new ArrayList<Item>();
        Item item = new Item("fromage", 20, 20);
        items.add(item);
        Inventory inventory = new Inventory(items);
        inventory.updateQuality();

        int expedtedSellIn = 19;
        int expedtedQuality = 19;
        assertThat(item.sellIn, is(expedtedSellIn));
        assertThat(item.quality, is(expedtedQuality));
    }
}
