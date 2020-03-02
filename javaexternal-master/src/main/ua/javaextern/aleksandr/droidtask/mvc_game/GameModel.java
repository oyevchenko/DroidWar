package main.ua.javaextern.aleksandr.droidtask.mvc_game;

import main.ua.javaextern.aleksandr.droidtask.droid.BatDroid;
import main.ua.javaextern.aleksandr.droidtask.droid.Droid;
import main.ua.javaextern.aleksandr.droidtask.droid.KarateDroid;
import main.ua.javaextern.aleksandr.droidtask.droid.PizzaDroid;
import org.apache.log4j.Logger;

import java.util.Random;
import java.util.Scanner;

import static main.ua.javaextern.aleksandr.droidtask.mvc_game.DroidsParameters.*;

public class GameModel{

    Logger log = Logger.getLogger(GameModel.class.getName());

    public Droid chooseDroid(){
        Scanner scanner = new Scanner(System.in);
        while(!scanner.hasNextInt()) {
            scanner.next();
        }
        switch (scanner.nextInt()) {
            case 1:
                return new BatDroid(BAT_DROID_NAME, BAT_DROID_ATTACK,
                        BAT_DROID_ARMOR, BAT_DROID_HEALTH);
            case 2:
                return new PizzaDroid(PIZZA_DROID_NAME,PIZZA_DROID_ATTACK,
                        PIZZA_DROID_ARMOR, PIZZA_DROID_HEALTH);
            default:
                return new KarateDroid(KARATE_DROID_NAME, KARATE_DROID_ATTACK,
                        KARATE_DROID_ARMOR, KARATE_DROID_HEALTH);
        }

    }

    public Droid getRandomAttackingDroid(Droid firstFighter, Droid secondFighter) {
        int fortuitousMotion = new Random().nextInt() % 2;
        if(fortuitousMotion == 0){
            return firstFighter;
        }else{
            return secondFighter;
        }
    }

    public Droid getDefendingDroid(Droid attackingDroid, Droid firstFighter, Droid secondFighter) {
        if(attackingDroid.equals(firstFighter)){
            return secondFighter;
        }else{
            return firstFighter;
        }
    }

    public Droid getWinnerDroid(Droid firstFighter, Droid secondFighter){
        if(firstFighter.getHealthValue() > 0){
            return firstFighter;
        }else{
            return secondFighter;
        }
    }
}
