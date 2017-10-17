import java.math.BigDecimal;

/**
 * Enum to represent the possible items sold by the shop
 */
public enum Item {

    APPLE(new BigDecimal(60)),
    ORANGE(new BigDecimal(25));

    private final BigDecimal cost;

    Item(final BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getCost() {
        return cost;
    }
}
