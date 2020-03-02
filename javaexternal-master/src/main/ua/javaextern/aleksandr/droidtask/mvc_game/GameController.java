package main.ua.javaextern.aleksandr.droidtask.mvc_game;

import main.ua.javaextern.aleksandr.droidtask.droid.Droid;
import org.apache.log4j.Logger;

public class GameController {
    private GameModel gameModel;
    private GameView gameView;

    Logger log = Logger.getLogger(GameController.class.getName());

    public GameController(GameModel gameModel, GameView gameView) {
        this.gameModel = gameModel;
        this.gameView = gameView;
    }

    public void process(){
        log.info("PROCESS HAS BEEN STARTED");
        gameView.printGreetings();
        gameView.printDroidList();

        Droid firstFighter = gameModel.chooseDroid();
        gameView.printSecondNumberRequest();
        Droid secondFighter = gameModel.chooseDroid();

        gameView.printChosenDroidNames(firstFighter,secondFighter);

        try{
            processFight(firstFighter, secondFighter);
        }catch(DroidDeadException ex){
            Droid winnerDroid = gameModel.getWinnerDroid(firstFighter, secondFighter);
            gameView.printEndBattle(winnerDroid);
            log.fatal("DroidDeadException",ex);
        }
    }

    private void processFight(Droid firstFighter, Droid secondFighter) throws DroidDeadException {
        while(true){
            Droid attackingDroid = gameModel
                    .getRandomAttackingDroid(firstFighter, secondFighter);
            Droid defendingDroid = gameModel
                    .getDefendingDroid(attackingDroid, firstFighter, secondFighter);
            attackingDroid.attackMove(defendingDroid);
            gameView.printAttackMove(attackingDroid);
            gameView.printDroidParameters(firstFighter);
            gameView.printDroidParameters(secondFighter);
            gameView.print("\n");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
                log.fatal("InterruptedException", e);
            }
            if(!firstFighter.isAlive() || !secondFighter.isAlive()){
                throw new DroidDeadException();
            }
        }
    }
}
