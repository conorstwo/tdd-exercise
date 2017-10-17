import java.math.BigDecimal;
import java.util.List;

/**
 * Class to represent a shopping cart and related functions
 */
public class ShoppingCart {

    private final List<Item> items;

    public ShoppingCart(final List<Item> items) {
        this.items = items;
    }

    public BigDecimal calculateTotalCost() {
        return items.stream()
                .map(Item::getCost)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<Item> getItems() {
        return items;
    }
}
