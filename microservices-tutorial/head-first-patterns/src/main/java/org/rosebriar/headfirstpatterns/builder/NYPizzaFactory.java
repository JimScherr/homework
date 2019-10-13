package org.rosebriar.headfirstpatterns.builder;

public class NYPizzaFactory extends SimplePizzaFactory {
    @Override
    public Pizza createPizza(String type) {
        return new NYCheesePizza();
    }
}
