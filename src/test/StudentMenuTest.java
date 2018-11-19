package test;

import com.po.StudentPO;
import com.sevice.StudentMenu;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentMenuTest {

    @Test
    public void enterSomeoneMenu() {
        StudentPO studentPO = new StudentPO();
        studentPO.setId(3213);

        StudentMenu studentMenu = new StudentMenu();
        int rs = 0;
        try {
            rs = studentMenu.enterSomeoneMenu(studentPO);
        } catch (Exception e) {
            System.out.print(".......");
        }
        System.out.print(rs);

    }
}