package org.rosebriar.headfirstpatterns.builder;

public class ChicagoPizzaFactory extends SimplePizzaFactory {
    @Override
    public Pizza createPizza(String type) {
        return new ChicagoCheesePizza();
    }
}
