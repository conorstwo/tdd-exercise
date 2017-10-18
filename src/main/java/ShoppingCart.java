import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Class to represent a shopping cart and related functions
 */
public class ShoppingCart {

    private final List<Item> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    /**
     * Convenience method for calling function
     * @return - total cost of all items in basket with discounts applied
     */
    public BigDecimal calculateTotalCost() {
        return calculateTotalCost.apply(items);
    }

    /**
     * Calculate the number of the given item in the supplied list
     */
    private final BiFunction<List<Item>, Item, Long> getNumberOfItem = (itemList, item) ->
            itemList.stream()
                    .filter(Objects::nonNull)
                    .filter(currentItem -> item.equals(currentItem))
                    .count();

    /**
     * Calculate the total cost of the items in the basket without discounts
     */
    private final Function<List<Item>, BigDecimal> calculateTotalCostBeforeDiscounts = itemList ->
            itemList.stream()
                .filter(Objects::nonNull)
                .map(Item::getCost)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

    /**
     * Calculate the discount to be subtracted from the total cost for the given item
     * For example: apples are buy 1 get 1 free and cost 60p so the discount to be applied for 2 apples in the basket would be 60p
     */
    private BiFunction<List<Item>, Item, BigDecimal> calculateBuyMultipleGetOneFreeDiscount = (itemList, item) -> {
        final long numberOfItem = getNumberOfItem.apply(itemList, item);
        final long numberOfDiscountsToApply = Math.floorDiv(numberOfItem, item.getNumberOfItemsForBuyMultipleGetOneFreeOffer());
        return item.getCost().multiply(new BigDecimal(numberOfDiscountsToApply));
    };

    /**
     * Calculate the total cost of all items in the basket with discounts applied
     */
    public final Function<List<Item>, BigDecimal> calculateTotalCost = itemList ->
            calculateTotalCostBeforeDiscounts.apply(itemList)
                    .subtract(calculateBuyMultipleGetOneFreeDiscount.apply(itemList, Item.APPLE))
                    .subtract(calculateBuyMultipleGetOneFreeDiscount.apply(itemList, Item.ORANGE));

    public void addItem(final Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }
}
