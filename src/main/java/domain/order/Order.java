package domain.order;

import java.util.Objects;

import domain.menu.Menu;
import domain.menu.MenuRepository;

public class Order {
    private final Menu menu;
    private final Quantity quantity;

    private Order(Menu menu, Quantity quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public static Order of(int menu, int quantity) {
        return new Order(MenuRepository.findByNumber(menu), Quantity.from(quantity));
    }

    public Menu getMenu() {
        return menu;
    }

    public Quantity getQuantity() {
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
        Order order = (Order)o;
        return Objects.equals(menu, order.menu) &&
                Objects.equals(quantity, order.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menu, quantity);
    }

    public int price() {
        return menu.getPrice() * quantity.getValue();
    }

    public Order addQuantity(Quantity quantity) {
        return new Order(menu, this.quantity.add(quantity));
    }
}
