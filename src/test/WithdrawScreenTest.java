package test;

import com.po.StudentPO;
import com.sevice.WithdrawScreen;
import org.junit.Test;

import static org.junit.Assert.*;

public class WithdrawScreenTest {

    @Test
    public void enterWithdrawScreen() throws Exception{
        StudentPO studentPO = new StudentPO();
        studentPO.setId(3213);
        WithdrawScreen withdrawScreen = new WithdrawScreen();
        withdrawScreen.enterWithdrawScreen(studentPO);
    }

    public static void main(String[] args) throws Exception{
        StudentPO studentPO = new StudentPO();
        studentPO.setId(3213);
        WithdrawScreen withdrawScreen = new WithdrawScreen();
        withdrawScreen.enterWithdrawScreen(studentPO);
    }
}