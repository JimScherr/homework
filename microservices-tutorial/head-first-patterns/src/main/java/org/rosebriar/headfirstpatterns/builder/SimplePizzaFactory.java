package org.rosebriar.headfirstpatterns.builder;

import org.springframework.stereotype.Service;

public abstract class SimplePizzaFactory {
    public abstract Pizza createPizza(String type);
}
