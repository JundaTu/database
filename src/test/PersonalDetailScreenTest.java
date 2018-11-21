package test;

import com.po.StudentPO;
import com.sevice.PersonalDetailScreen;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonalDetailScreenTest {

    @Test
    public void enterPersonalScreen() {
    }
    public static void main(String[] args) throws Exception{
        StudentPO studentPO = new StudentPO();
        studentPO.setId(3213);
        PersonalDetailScreen personalDetailScreen = new PersonalDetailScreen();
        personalDetailScreen.enterPersonalScreen(studentPO);
    }
}