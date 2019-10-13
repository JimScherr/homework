package org.rosebriar.headfirstpatterns.builder;


public abstract class PizzaStore {
    SimplePizzaFactory simplePizzaFactory;

    @SuppressWarnings("unused")
    private PizzaStore(){
        // Classes the extend PizzaStore *must* provide a pizza creation factory
    }

    public PizzaStore(SimplePizzaFactory simplePizzaFactory) {
        this.simplePizzaFactory = simplePizzaFactory;
    }

    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.box();
        pizza.cut();
        return pizza;
    }

    abstract Pizza createPizza(String type);
}
