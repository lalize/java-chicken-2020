package domain;

public class Table {
    private final int number;
    private final Orders orders;

    public Table(final int number) {
        this.number = number;
        this.orders = Orders.empty();
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public boolean isNumber(int number) {
        return this.number == number;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public int orderSize() {
        return orders.size();
    }
}
