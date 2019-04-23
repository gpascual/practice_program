import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import Products.Product;

import static Products.ProductSupplier.*;


@RunWith(DataProviderRunner.class)
public class GildedRoseTest {

  private static final String DATA_PROVIDER_FORMAT = "%m: %p[0]";

  private Inventory inventory;

  @Before
  public void setUp() {
    inventory = new Inventory();
  }

  @DataProvider(format = DATA_PROVIDER_FORMAT)
  public static Object[][] test_product_update_data_provider() {
    return new Object[][] {
            {"given an product when sell in approaches then quality decreases", askFor("fromage", 20, 20), 19, 19},
            {"given an product with passed sell in when a day passes then quality decreases 2x faster", askFor("fromage", -2, 20), -3, 18},
            {"given a product without any quality left when a day passes then its quality remains zero", askFor("fromage", 2, 0), 1, 0},
            {"given aged brie when a day passes then quality increases", askForAgedBrie(20, 20), 19, 21},
            {"given aged brie created giving the name when a day passes then quality increases", askFor("Aged Brie", 20, 20), 19, 21},
            {"given a product whose quality is 50 when a day passes then its quality doesnt increase anymore", askForAgedBrie(2, 50), 1, 50},
            {"given a legendary product when a day passes then its sell in is null and its quality is always 80", askForSulfuras(), null, 80},
            {"given a legendary product created giving a name when a day passes then its sell in is null and its quality is always 80", askFor("Sulfuras", 20, 20), null, 80},
            {"given backstage passes when a day passes then its quality increases", askForBackstagePasses(20, 20), 19, 21},
            {"given backstage passes created giving the name when a day passes then its quality increases", askFor("Backstage passes", 20, 20), 19, 21},
            {"given backstage passes when there are 10 days to sell in then the quality increases by 2", askForBackstagePasses(11, 20), 10, 22},
            {"given backstage passes when there are less than 10 days to sell in then the quality increases by 2", askForBackstagePasses(10, 20), 9, 22},
            {"given backstage passes when there are 5 days to sell in then the quality increases by 3", askForBackstagePasses(6, 20), 5, 23},
            {"given backstage passes when there are less than 5 days to sell in then the quality increases by 3", askForBackstagePasses(5, 20), 4, 23},
            {"given backstage passes when there sell in has passed then the quality is 0", askForBackstagePasses(0, 20), -1, 0},
            {"given a conjured product when a day passes then its quality decrease by 2", askForConjured(20, 20), 19, 18},
            {"given a conjured product created giving the name with a passed sell in date when a day passes then its quality decrease by 4", askFor("Conjured", 0, 20), -1, 16}
    };
  }

  @Test
  @UseDataProvider("test_product_update_data_provider")
  public void test_product_update(String testDescription, Product product, Integer expectedSellIn, int expectedQuality) {
    inventory.addProduct(product);

    inventory.updateProducts();

    assertThat(product.getSellIn(), is(expectedSellIn));
    assertThat(product.getQuality(), is(expectedQuality));
  }

  @Test
  public void given_a_list_of_products_when_a_day_passes_then_products_are_updated_properly() {
    Product normal = askFor("fromage", -2, 20);
    Product agedBrie = askForAgedBrie(2, 50);
    Product sulfuras = askForSulfuras();

    inventory.addProduct(normal);
    inventory.addProduct(agedBrie);
    inventory.addProduct(sulfuras);


    inventory.updateProducts();

    assertThat(normal.getSellIn(), is(-3));
    assertThat(normal.getQuality(), is(18));
    assertThat(agedBrie.getSellIn(), is(1));
    assertThat(agedBrie.getQuality(), is(50));
    assertThat(sulfuras.getSellIn(), is(nullValue()));
    assertThat(sulfuras.getQuality(), is(80));
  }
}
