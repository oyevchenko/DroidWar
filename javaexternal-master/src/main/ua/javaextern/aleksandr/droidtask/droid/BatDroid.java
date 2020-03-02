package main.ua.javaextern.aleksandr.droidtask.droid;

import main.ua.javaextern.aleksandr.droidtask.strategy.SimpleAttackStrategy;

public class BatDroid extends Droid {

    public BatDroid(String name, int attack, int armor, int health) {
        super(name, attack, armor, health,new SimpleAttackStrategy());
    }

    public BatDroid() {
        super();
    }


    @Override
    void speak() {
        System.out.println("*ultrasound*");
    }

}
