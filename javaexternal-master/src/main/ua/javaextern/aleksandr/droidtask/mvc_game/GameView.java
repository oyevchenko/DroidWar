package main.ua.javaextern.aleksandr.droidtask.mvc_game;

import main.ua.javaextern.aleksandr.droidtask.droid.Droid;
import main.ua.javaextern.aleksandr.droidtask.mvc_entrance.EntranceView;

import java.util.Locale;
import java.util.ResourceBundle;

public class GameView {

    private static final String MESSAGES_BUNDLE_NAME = "property/game_messages/text";

    private ResourceBundle bundle = ResourceBundle.getBundle(MESSAGES_BUNDLE_NAME,
            new Locale(EntranceView.getLANGUAGE()));

    private static final String SPACE_SIGN = " ";
    private static final String COMMA_SIGN = ",";
    private static final String NEXT_LINE = "\n";

    private static final String GREETINGS = "input.greetings";
    private static final String SECOND_NUMBER_REQUEST = "input.number.request";
    private static final String DROIDS_LIST = "input.droid.list";
    private static final String DROID_NAMES_ANNOUNCEMENT = "input.names.announcement";
    private static final String DROID_ATTACK_MOVE = "input.attack.move";
    private static final String DROID_PARAMETERS = "input.droid.parameters";
    private static final String END_BATTLE = "input.battle.end";


    void print(String message){
        System.out.println(message);
    }

    void printGreetings(){
        print(bundle.getString(GREETINGS));
    }

    void printSecondNumberRequest(){
        print(bundle.getString(SECOND_NUMBER_REQUEST));
    }

    void printDroidList(){
        print(bundle.getString(DROIDS_LIST));
    }

    void printChosenDroidNames(Droid firstFighter, Droid secondFighter){
        print(bundle.getString(DROID_NAMES_ANNOUNCEMENT) +
                SPACE_SIGN + firstFighter.getName() + COMMA_SIGN +
                SPACE_SIGN + secondFighter.getName() + NEXT_LINE);
    }

    void printAttackMove(Droid droid){
        print(droid.getName() + SPACE_SIGN + bundle.getString(DROID_ATTACK_MOVE));
    }
    void printDroidParameters(Droid droid){
        print(droid.getName() + SPACE_SIGN + bundle.getString(DROID_PARAMETERS) + SPACE_SIGN +
                droid.getArmorValue() + SPACE_SIGN + droid.getHealthValue());
    }

    void printEndBattle(Droid droid){
        print(bundle.getString(END_BATTLE) + SPACE_SIGN + droid.getName());
    }
}
