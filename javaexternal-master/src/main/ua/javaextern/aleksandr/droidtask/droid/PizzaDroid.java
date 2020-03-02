package main.ua.javaextern.aleksandr.droidtask.droid;

import main.ua.javaextern.aleksandr.droidtask.strategy.SimpleAttackStrategy;

public class PizzaDroid extends Droid{

    public PizzaDroid(String name,int attack, int armor, int health) {
        super(name, attack, armor, health, new SimpleAttackStrategy());
    }

    public PizzaDroid() {

    }

    @Override
    void speak() {
        System.out.println("*pizza theme playing*");
    }

}
