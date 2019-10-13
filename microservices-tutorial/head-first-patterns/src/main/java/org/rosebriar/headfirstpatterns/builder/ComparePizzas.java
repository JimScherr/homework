package org.rosebriar.headfirstpatterns.builder;

import org.springframework.beans.factory.annotation.Autowired;

public class ComparePizzas {
    public static void main(String... args) {
        PizzaStore nyPizzaStore = new NYPizzaStore();
        PizzaStore chicagoPizzaStore = new ChicagoPizzaStore();

        Pizza nyCheese = nyPizzaStore.orderPizza("chees");
        Pizza chicagoCheese = nyPizzaStore.orderPizza("cheese");

    }
}
