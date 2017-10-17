import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Tests for {@link ShoppingCart}
 */
public class ShoppingCartTest {

    @Test
    public void testOneAppleCosts60() {
        final List<Item> items = Arrays.asList(Item.APPLE);
        final ShoppingCart shoppingCart = new ShoppingCart(items);

        assertThat(shoppingCart.calculateTotalCost(), is(new BigDecimal(60)));
    }

    @Test
    public void testOneOrangeCosts25() {
        final List<Item> items = Arrays.asList(Item.ORANGE);
        final ShoppingCart shoppingCart = new ShoppingCart(items);

        assertThat(shoppingCart.calculateTotalCost(), is(new BigDecimal(25)));
    }

    @Test
    public void testEmptyBasketCosts0() {
        final List<Item> items = Arrays.asList();
        final ShoppingCart shoppingCart = new ShoppingCart(items);

        assertThat(shoppingCart.calculateTotalCost(), is(new BigDecimal(0)));
    }

    @Test
    public void testCalculateTotal() {
        final List<Item> items = Arrays.asList(Item.APPLE, Item.APPLE, Item.ORANGE, Item.APPLE);
        final ShoppingCart shoppingCart = new ShoppingCart(items);

        assertThat(shoppingCart.calculateTotalCost(), is(new BigDecimal(205)));
    }

}
