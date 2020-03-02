package main.ua.javaextern.aleksandr.droidtask.strategy;
import main.ua.javaextern.aleksandr.droidtask.droid.Droid;

public class SimpleAttackStrategy implements AttackStrategy {

    @Override
    public void attack(Droid droid, int attackValue) {
        if (droid.getArmorValue() > 0) {
            droid.setArmorValue(droid.getArmorValue() - attackValue / 2);
        } else {
            droid.setHealthValue(droid.getHealthValue() - attackValue);
        }
    }
}
