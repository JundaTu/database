package test;

import com.po.StudentPO;
import com.sevice.TranscriptLevel;
import org.junit.Test;

import static org.junit.Assert.*;

public class TranscriptLevelTest {

    @Test
    public void getTranscript() throws Exception{
        StudentPO studentPO = new StudentPO();
        studentPO.setId(3213);
        TranscriptLevel transcriptLevel = new TranscriptLevel();
        transcriptLevel.getTranscript(studentPO);
    }
}