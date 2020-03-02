package main.ua.javaextern.aleksandr.droidtask.droid;

import main.ua.javaextern.aleksandr.droidtask.strategy.SimpleAttackStrategy;

public class KarateDroid extends Droid{

    public KarateDroid(String name, int attack, int armor, int health) {
        super(name, attack, armor, health,new SimpleAttackStrategy());
    }

    public KarateDroid() {

    }

    @Override
    void speak() {
        System.out.println("im cooler than kung fury");
    }

}
