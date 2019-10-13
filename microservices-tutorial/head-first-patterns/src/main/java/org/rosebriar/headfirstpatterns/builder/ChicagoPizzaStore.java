package org.rosebriar.headfirstpatterns.builder;

public class ChicagoPizzaStore extends PizzaStore {
    public ChicagoPizzaStore() {
        super(new ChicagoPizzaFactory());
    }

    @Override
    Pizza createPizza(String type) {
        return simplePizzaFactory.createPizza(type);
    }
}
