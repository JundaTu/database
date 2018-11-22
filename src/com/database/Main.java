package com.database;

import com.otherUsefulObject.ConsForLevels;
import com.po.StudentPO;
import com.sevice.*;


public class Main {

    public static void main(String[] args) throws Exception{
        LoginScreen loginScreen = new LoginScreen();
        StudentPO studentPO = loginScreen.login();
        TranscriptLevel transcriptLevel = new TranscriptLevel();
        EnrollLevel enrollLevel = new EnrollLevel();
        WithdrawScreen withdrawScreen = new WithdrawScreen();
        PersonalDetailScreen personalDetailScreen = new PersonalDetailScreen();

        StudentMenu studentMenu = new StudentMenu();
        int code = studentMenu.enterSomeoneMenu(studentPO);
        while (true) {
            switch (code) {
                case ConsForLevels.LOGOUT:
                    studentPO = loginScreen.login();
                case ConsForLevels.STUDENT_MENU:
                    code = studentMenu.enterSomeoneMenu(studentPO);
                    break;
                case ConsForLevels.TRANSCRIPT:
                    code = transcriptLevel.getTranscript(studentPO);
                    break;
                case ConsForLevels.ENROLL:
                    code = enrollLevel.beginEnroll(studentPO);
                    break;
                case ConsForLevels.WITHDRAW:
                    code = withdrawScreen.enterWithdrawScreen(studentPO);
                    break;
                case ConsForLevels.PERSONAL:
                    code = personalDetailScreen.enterPersonalScreen(studentPO);
                    break;
                case ConsForLevels.EXIT:
                    System.out.println("Good bye!");
                    return;
            }
        }
    }


}
