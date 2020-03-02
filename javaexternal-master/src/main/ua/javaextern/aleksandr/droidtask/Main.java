package main.ua.javaextern.aleksandr.droidtask;

import main.ua.javaextern.aleksandr.droidtask.mvc_entrance.EntranceController;
import main.ua.javaextern.aleksandr.droidtask.mvc_entrance.EntranceModel;
import main.ua.javaextern.aleksandr.droidtask.mvc_entrance.EntranceView;
import main.ua.javaextern.aleksandr.droidtask.mvc_game.GameController;
import main.ua.javaextern.aleksandr.droidtask.mvc_game.GameModel;
import main.ua.javaextern.aleksandr.droidtask.mvc_game.GameView;
import org.apache.log4j.Logger;

import java.io.IOException;


public class Main {

    public static void main(String[] args) {
       Logger log =  Logger.getLogger(Main.class.getName());

        EntranceModel entranceModel = new EntranceModel();
        EntranceView entranceView = new EntranceView();
        EntranceController entranceController = new EntranceController(entranceView,entranceModel);
        try {
            entranceController.process();
        } catch (IOException e) {

            e.printStackTrace();
            log.fatal("IOException", e);
        }

        GameModel gameModel = new GameModel();
        GameView gameView = new GameView();
        GameController gameController = new GameController(gameModel, gameView);
        gameController.process();
        log.info("LET`S START THE BATTLE");

    }
}
