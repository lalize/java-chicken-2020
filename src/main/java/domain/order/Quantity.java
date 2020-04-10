package domain.order;

import java.util.Objects;

public class Quantity {
    private static final int MIN = 1;
    private static final int MAX = 99;

    private final int quantity;

    private Quantity(int quantity) {
        validate(quantity);
        this.quantity = quantity;
    }

    private void validate(int quantity) {
        if (quantity < MIN || quantity > MAX) {
            throw new IllegalArgumentException("수량은 1 이상 99이하의 값만 허용합니다.");
        }
    }

    public static Quantity from(String quantity) {
        return from(Integer.parseInt(quantity));
    }

    public static Quantity from(int quantity) {
        return new Quantity(quantity);
    }

    public Quantity add(Quantity that) {
        return add(that.quantity);
    }

    public Quantity add(int quantity) {
        return from(this.quantity + quantity);
    }

    public int getValue() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Quantity that = (Quantity)o;
        return quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity);
    }
}
