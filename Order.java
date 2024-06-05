// Creational pattern

public interface Order {
    void prepare();
}

class PizzaOrder implements Order {
    @Override
    public void prepare() {
        System.out.println("Preparing pizza...");
    }
}

class SaladOrder implements Order {
    @Override
    public void prepare() {
        System.out.println("Preparing salad...");
    }
}

class OrderFactory {
    public static Order getOrder(String type) {
        if (type.equals("pizza")) {
            return new PizzaOrder();
        } else if (type.equals("salad")) {
            return new SaladOrder();
        } else {
            throw new IllegalArgumentException("Invalid order type");
        }
    }
}