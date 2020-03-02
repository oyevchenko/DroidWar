package main.ua.javaextern.aleksandr.droidtask.mvc_game.droidtask.mvc_entrance;

import main.ua.javaextern.aleksandr.droidtask.guest.Admin;
import main.ua.javaextern.aleksandr.droidtask.guest.Guest;
import main.ua.javaextern.aleksandr.droidtask.guest.User;
import main.ua.javaextern.aleksandr.droidtask.mvc_entrance.EntranceModel;
import main.ua.javaextern.aleksandr.droidtask.mvc_game.droidtask.ConfigurableInputStream;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class TestEntranceModel {

    private EntranceModel model;
    private ConfigurableInputStream in;

    @Before
    public void setup(){
        model = new EntranceModel();
        in = new ConfigurableInputStream();

        System.setIn(in);
    }
    @Ignore
    public void getGuestStatus() throws IOException {
        in.add("admin");                              //TODO proper test, BufferedReader
        Guest guest = model.getGuestStatus();         // doesnt read from ConfigurableInputStream
        assertTrue(guest instanceof Admin);
    }
    @Test
    public void isPasswordValidAdminCase() throws IOException {
        assertTrue(model.isPasswordValid(new Admin(), "admin:admin"));
    }
    @Test
    public void isPasswordValidUserCase() throws IOException {
        assertTrue(model.isPasswordValid(new User(), "user:user"));
    }
    @Test
    public void isPasswordValidWrongCase() throws IOException {
        assertFalse(model.isPasswordValid(new User(), "use:use"));
    }
    @Test
    public void isPasswordRegularRightCase() {
        assertTrue(model.isPasswordRegular("admin:admin"));
        assertTrue(model.isPasswordRegular( "a:a"));
    }
    @Test
    public void isPasswordRegularWrongCase() {
        assertFalse(model.isPasswordRegular("admin_admin"));
        assertFalse(model.isPasswordRegular("admin"));
    }
    @Test
    public void registerUser() throws IOException {
        Guest guest = new User();
        String newPassword = "new:password";
        model.registerNewUser(guest,newPassword);
        assertTrue(model.isPasswordValid(guest, newPassword));
    }
    @Test
    public void getFileAdmin(){
        String filepath = model.getFile(new Admin()).getPath();
        assertEquals("src\\main\\java\\property\\passwords\\admin_passwords.txt", filepath);
    }
    @Test
    public void getFileUser(){
        String filepath = model.getFile(new User()).getPath();
        assertEquals("src\\main\\java\\property\\passwords\\user_passwords.txt", filepath);
    }
    @Ignore
    public void getEntranceTypeSignInCase() throws IOException {
        String input = model.getEntranceType();                  //TODO proper test, BufferedReader
        assertEquals("sign in", input);
    }
    @Ignore
    public void getEntranceTypeSignUpCase() throws IOException {
        String input = model.getEntranceType();                  //TODO proper test, BufferedReader
        assertEquals("sign up", input);
    }

}
