import java.util.ArrayList;
import java.util.List;


class Order {
    private final List<Burger> burgers;
    private final List<Beverage> beverages;
    private final List<Packaging> packagings;

    public Order() {
        burgers = new ArrayList<>();
        beverages = new ArrayList<>();
        packagings = new ArrayList<>();
    }

    public void addBurger(Burger burger) {
        burgers.add(burger);
    }

    public void addBeverage(Beverage beverage) {
        beverages.add(beverage);
    }

    public void addPackaging(Packaging packaging) {
        packagings.add(packaging);
    }

    public double getTotalCost() {
        double totalCost = 0;

        for (Burger burger : burgers) {
            totalCost += burger.getPrice();
        }

        for (Beverage beverage : beverages) {
            totalCost += beverage.getPrice();
        }

        for (Packaging packaging : packagings) {
            totalCost += packaging.getPrice();
        }

        return totalCost;
    }
}
class Burger {
   public enum Type{
        Vegan(4.99),
        Chicken(9.99);
       private final Double price;
       Type(Double price){
           this.price = price;
       }
    }

    private final double price;

    public Burger(Type type) {
        this.price = type.price;
    }

    public double getPrice() {
        return price;
    }
}
class Beverage {

       public enum Type{
            pepsi(0.99),
            tea(1.5),
            coffee(4.9),
            fanta(2.99),
            sprite(3.5);
            private final Double price;
            Type(Double price){
                this.price = price;
            }
        }
    private final double price;

    public Beverage(Type type) {
        this.price = type.price;
    }

    public double getPrice() {
        return price;
    }
}
class Packaging {
    enum Type{
        here(0.0),
        yourself(1.0);
        private final Double price;
        Type(Double price){
            this.price = price;
        }
    }
    private final double price;

    public Packaging(Type type) {
        this.price = type.price;
    }

    public double getPrice() {
        return price;
    }
}
interface OrderBuilder {
    void chooseBurger(Burger.Type type);
    void chooseBeverage(Beverage.Type type);
    void choosePackaging(Packaging.Type type);
    Order getOrder();
}
class Cashier implements OrderBuilder {
    private Order order;

    public Cashier() {
        order = new Order();
    }

    @Override
    public void chooseBurger(Burger.Type type) {
        // Burger selection logic
        Burger burger = new Burger(type);
        order.addBurger(burger);
    }

    @Override
    public void chooseBeverage(Beverage.Type type) {
        // Beverage selection logic
        Beverage beverage = new Beverage(type);
        order.addBeverage(beverage);
    }

    @Override
    public void choosePackaging(Packaging.Type type) {
        // Packaging selection logic
        Packaging packaging = new Packaging(type);
        order.addPackaging(packaging);
    }

    @Override
    public Order getOrder() {
        return order;
    }
}
public class Lab6_1 {
    public static void main(String[] args) {
        Cashier cashier = new Cashier();
        cashier.chooseBurger(Burger.Type.Vegan);
        cashier.chooseBeverage(Beverage.Type.fanta);
        cashier.choosePackaging(Packaging.Type.here);

        Order order = cashier.getOrder();
        double totalCost = order.getTotalCost();

        System.out.println("Total cost of the order: " + totalCost);
    }

}
