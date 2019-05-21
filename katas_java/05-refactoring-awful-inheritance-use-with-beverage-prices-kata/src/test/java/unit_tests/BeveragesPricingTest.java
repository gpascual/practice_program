package unit_tests;

import beverages.*;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import static beverages.Barista.askForCoffee;
import static beverages.Barista.askForHotChocolate;
import static beverages.Barista.askForTea;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;

@RunWith(DataProviderRunner.class)
public class BeveragesPricingTest {

    private static final double ERROR = 0.001;

    @Test
    @UseDataProvider("beveragePricesToCompute")
    public void computes_beverage_price(String testName, Beverage beverage, double expectedPrice) {
        assertThat(testName + " price went wrong", beverage.price(), is(closeTo(expectedPrice, ERROR)));
    }

    @DataProvider(format = "%p[0] price is %p[2]")
    public static Object[][] beveragePricesToCompute() {
        return new Object[][] {
                { "coffee", askForCoffee().prepare(), 1.20},
                { "tea", askForTea().prepare(), 1.50},
                { "hot chocolate", askForHotChocolate().prepare(), 1.45},
                { "tea with milk", askForTea().withMilk().prepare(), 1.60},
                { "coffee with milk", askForCoffee().withMilk().prepare(), 1.30},
                { "coffee with milk and cream", askForCoffee().withMilk().withCream().prepare(), 1.45},
                { "hot chocolate with cream", askForHotChocolate().withCream().prepare(), 1.60},
                { "tea with cinnamon", askForTea().withCinnamon().prepare(), 1.55},
                { "coffee with cream and cinnamon", askForCoffee().withCream().withCinnamon().prepare(), 1.40},
        };
    }
}
