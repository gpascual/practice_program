package unit_tests;

import beverages.*;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

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
                { "coffee", new Coffee(), 1.20},
                { "tea", new Tea(), 1.50},
                { "hot chocolate", new HotChocolate(), 1.45},
                { "tea with milk", new WithMilk(new Tea()), 1.60},
                { "coffee with milk", new WithMilk(new Coffee()), 1.30},
                { "coffee with milk and cream", new WithCream(new WithMilk(new Coffee())), 1.45},
                { "hot chocolate with cream", new WithCream(new HotChocolate()), 1.60},
        };
    }
}
