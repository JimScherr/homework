package org.rosebriar.headfirstpatterns.builder;

public class NYPizzaStore extends PizzaStore {
    public NYPizzaStore() {
        super(new NYPizzaFactory());
    }

    @Override
    Pizza createPizza(String type) {
        return simplePizzaFactory.createPizza(type);
    }
}
