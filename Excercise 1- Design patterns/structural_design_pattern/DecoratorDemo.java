package structural_design_pattern;

// Component interface
interface Coffee {
    String getDescription();
    double cost();
}

// Concrete component
class BasicCoffee implements Coffee {
    public String getDescription() {
        return "Basic Coffee";
    }
    public double cost() {
        return 2.00;
    }
}

// Abstract Decorator
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;
    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }
    public double cost() {
        return decoratedCoffee.cost();
    }
}

// Concrete Decorator - Milk
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Milk";
    }
    public double cost() {
        return decoratedCoffee.cost() + 0.50;
    }
}

// Concrete Decorator - Sugar
class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Sugar";
    }
    public double cost() {
        return decoratedCoffee.cost() + 0.20;
    }
}

// Concrete Decorator - Whipped Cream
class WhippedCreamDecorator extends CoffeeDecorator {
    public WhippedCreamDecorator(Coffee coffee) {
        super(coffee);
    }
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Whipped Cream";
    }
    public double cost() {
        return decoratedCoffee.cost() + 0.70;
    }
}

// Demo client
public class DecoratorDemo {
    public static void main(String[] args) {
        Coffee simpleCoffee = new BasicCoffee();
        System.out.println(simpleCoffee.getDescription() + " $" + simpleCoffee.cost());

        Coffee coffeeWithMilk = new MilkDecorator(simpleCoffee);
        System.out.println(coffeeWithMilk.getDescription() + " $" + coffeeWithMilk.cost());

        Coffee coffeeWithMilkAndSugar = new SugarDecorator(coffeeWithMilk);
        System.out.println(coffeeWithMilkAndSugar.getDescription() + " $" + coffeeWithMilkAndSugar.cost());

        Coffee deluxeCoffee = new WhippedCreamDecorator(coffeeWithMilkAndSugar);
        System.out.println(deluxeCoffee.getDescription() + " $" + deluxeCoffee.cost());
    }
}
