package main.ua.javaextern.aleksandr.droidtask.mvc_entrance;

import main.ua.javaextern.aleksandr.droidtask.guest.Guest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;


public class EntranceController {
    private EntranceView view;
    private EntranceModel model;

    Logger logger = Logger.getLogger(EntranceController.class.getName());

    public EntranceController(EntranceView view, EntranceModel model){
        this.view = view;
        this.model = model;
    }

    public void process() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        view.setUpLanguage();
        view.printStatusRequest();
        Guest guest = model.getGuestStatus(reader);
        view.printSignInOrSignUp();
        if(model.getEntranceType(reader).equals("sign up")){
            view.printNewPasswordRequest();
            model.registerNewUser(guest, getRightPasswordFormat(reader));
        }
        view.printLoginPasswordRequest();
        validatePassword(reader, guest);
        logger.info("The language set up was successful");
    }


    private void validatePassword(BufferedReader reader, Guest guest) throws IOException {
        String password;
        while(true) {
            password = getRightPasswordFormat(reader);
            if (model.isPasswordValid(guest, password)) {
                break;
            }
            view.printWrongPassword();
            logger.info("Password validation was successful");
        }
    }

    private String getRightPasswordFormat(BufferedReader terminalReader) throws IOException {
        String password;
        while (!model.isPasswordRegular(password = terminalReader.readLine())){
            view.printInvalidPasswordFormat();
            logger.info("Invalid password");
        }
        return password;
    }
}
