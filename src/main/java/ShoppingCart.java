import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class to represent a shopping cart and related functions
 */
public class ShoppingCart {

    private final List<Item> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    /**
     * Calculate the total cost of all items in the basket with discounts applied
     * @return total cost of all items in the basket after discounts
     */
    public BigDecimal calculateTotalCost() {
        return calculateTotalCostBeforeDiscounts()
                .subtract(calculateBuyMultipleGetOneFreeDiscount(Item.APPLE))
                .subtract(calculateBuyMultipleGetOneFreeDiscount(Item.ORANGE));
    }

    /**
     * Calculate the total cost of the items in the basket without discounts
     * @return the pre discounts total cost of the items
     */
    private BigDecimal calculateTotalCostBeforeDiscounts() {
        return items.stream()
                .filter(Objects::nonNull)
                .map(Item::getCost)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    /**
     * Calculate the discount to be subtracted from the total cost for the given item
     * For example: apples are buy 1 get 1 free and cost 60p so the discount to be applied for 2 apples in the basket would be 60p
     * @param item - value of {@link Item}
     * @return the discount from the buy multiple get one free offer
     */
    private BigDecimal calculateBuyMultipleGetOneFreeDiscount(final Item item) {
        final long numberOfItem = getNumberOfItem(item);
        final long numberOfDiscountsToApply = Math.floorDiv(numberOfItem, item.getNumberOfItemsForBuyMultipleGetOneFreeOffer());
        return item.getCost().multiply(new BigDecimal(numberOfDiscountsToApply));
    }

    /**
     * Calculate the number of the given item in the shopping cart
     * @param item - the item to count
     * @return the number of the item in the cart
     */
    private long getNumberOfItem(final Item item) {
        return items.stream()
                .filter(Objects::nonNull)
                .filter(currentItem -> item.equals(currentItem))
                .count();
    }

    public void addItem(final Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }
}
