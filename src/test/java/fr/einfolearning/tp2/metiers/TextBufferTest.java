package fr.einfolearning.tp2.metiers;

import org.junit.Test;
import static org.junit.Assert.*;

public class TextBufferTest {

    @Test
    public void ToString_should_Return_Initial_Text(){
        // arrange
        TextBuffer buffer = new TextBuffer("test");

        // act
        String attendu = "test";
        String result = buffer.toString();

        // assert
        assertEquals(attendu, result);
    }

    @Test
    public void ToString_should_Return_Initial_Text_With_Empty_Text(){
        // arrange
        TextBuffer buffer = new TextBuffer("");

        // act
        String attendu = "";
        String result = buffer.toString();

        // assert
        assertEquals(attendu, result);
    }
}
