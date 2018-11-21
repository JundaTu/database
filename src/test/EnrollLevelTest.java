package test;

import com.po.StudentPO;
import com.sevice.EnrollLevel;
import com.sevice.TranscriptLevel;
import org.junit.Test;

import static org.junit.Assert.*;

public class EnrollLevelTest {

    @Test
    public void beginEnroll() throws Exception{
        EnrollLevel enrollLevel = new EnrollLevel();
        StudentPO s1 = new StudentPO();
        s1.setId(3213);
        enrollLevel.beginEnroll(s1);
    }
    public static void main(String[] args) throws Exception{
        EnrollLevel enrollLevel = new EnrollLevel();
        StudentPO s1 = new StudentPO();
        s1.setId(3213);
        enrollLevel.beginEnroll(s1);
    }
}