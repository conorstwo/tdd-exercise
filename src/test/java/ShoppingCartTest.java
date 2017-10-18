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
        final ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(Item.APPLE);

        assertThat(shoppingCart.calculateTotalCost(), is(new BigDecimal(60)));
    }

    @Test
    public void testOneOrangeCosts25() {
        final ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(Item.ORANGE);

        assertThat(shoppingCart.calculateTotalCost(), is(new BigDecimal(25)));
    }

    @Test
    public void testEmptyBasketCosts0() {
        final ShoppingCart shoppingCart = new ShoppingCart();

        assertThat(shoppingCart.calculateTotalCost(), is(new BigDecimal(0)));
    }

    @Test
    public void testBasketContainingNullCosts0() {
        final ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(null);

        assertThat(shoppingCart.calculateTotalCost(), is(new BigDecimal(0)));
    }

    @Test
    public void testCalculateTotal() {
        final ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(Item.APPLE);
        shoppingCart.addItem(Item.APPLE);
        shoppingCart.addItem(Item.ORANGE);
        shoppingCart.addItem(Item.APPLE);

        assertThat(shoppingCart.calculateTotalCost(), is(new BigDecimal(205)));
    }

}
