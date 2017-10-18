import java.math.BigDecimal;

/**
 * Enum to represent the possible items sold by the shop
 */
public enum Item {

    APPLE(new BigDecimal(60), 2),
    ORANGE(new BigDecimal(25), 3);

    private final BigDecimal cost;
    private final int numberOfItemsForBuyMultipleGetOneFreeOffer;

    Item(final BigDecimal cost, final int numberOfItemsForBuyMultipleGetOneFreeOffer) {
        this.cost = cost;
        this.numberOfItemsForBuyMultipleGetOneFreeOffer = numberOfItemsForBuyMultipleGetOneFreeOffer;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public int getNumberOfItemsForBuyMultipleGetOneFreeOffer() {
        return numberOfItemsForBuyMultipleGetOneFreeOffer;
    }
}
