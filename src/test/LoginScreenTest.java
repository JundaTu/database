package test;

import com.sevice.LoginScreen;
import org.junit.Test;
//import sun.jvm.hotspot.StackTrace;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class LoginScreenTest {

    @Test
    public void login() {
        LoginScreen loginScreen = new LoginScreen();
        int id = 3213;
        String password = "lunch";
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");

        System.setIn(new ByteArrayInputStream(password.getBytes()));
        int inputId = sc.nextInt();
        System.out.println(inputId);
//        try {
//            loginScreen.login();
//        } catch (Exception e) {
//            System.out.println("Can not find this student");
//        }
    }
}