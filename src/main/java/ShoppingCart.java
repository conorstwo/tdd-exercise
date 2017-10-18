import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to represent a shopping cart and related functions
 */
public class ShoppingCart {

    private final List<Item> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    /**
     * Calculate the total cost of all items in the basket
     * @return total cost of all items in the basket
     */
    public BigDecimal calculateTotalCost() {
        return items.stream()
                .filter(item -> item != null)
                .map(Item::getCost)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void addItem(final Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }
}
