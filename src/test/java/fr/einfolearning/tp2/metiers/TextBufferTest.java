package fr.einfolearning.tp2.metiers;


import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TextBufferTest {

    @Test
    public void ToString_should_Return_Initial_Text() {
        // arrange
        TextBuffer buffer = new TextBuffer("test");

        // act
        String attendu = "test";
        String result = buffer.toString();

        // assert
        assertThat(result, equalTo(attendu)); 
    }

    @Test
    public void ToString_should_Return_Initial_Text_With_Empty_Text() {
        // arrange
        TextBuffer buffer = new TextBuffer("");

        // act
        String attendu = "";
        String result = buffer.toString();

        // assert
        assertThat(result, is(attendu));
    }

    @Test 
    public void insert_should_add_text_at_position(){
        //Arrange
        TextBuffer buffer = new TextBuffer("Diarra");

        //Act
        buffer.ins("Konte", 0);
        String attendu = "KonteDiarra";
        String result = buffer.toString();

        //Assert
        assertThat(result, is(equalTo(attendu)));
    }

    @Test
    public void delete_should_remove_text_in_interval_from_to(){
        //Arrange
        TextBuffer buffer = new TextBuffer("Diarra Konte");

        //Act
        buffer.del(0,7);

        //Assert
        assertThat(buffer.toString(), is(equalTo("Konte")));
    }

    @Test
    public void substr_should_remove_text_in_interval_from_to(){
        //Arrange
        TextBuffer buffer = new TextBuffer("Diarra Konte");

        //Act
        String result = buffer.substr(7,12);

        //Assert
        assertThat(result, is(equalTo("Konte")));
    }

    @Test
    public void substring_should_handle_out_of_bounds_indices(){
        //Arrange
        TextBuffer buffer = new TextBuffer("Diarra Konte");

        //Act
        String result = buffer.substr(-1,30);

        //Assert
        assertThat(result, is("Diarra Konte"));
    }

    @Test 
    public void MaxP_should_return_length(){
        //Arrange
        TextBuffer buffer = new TextBuffer("Diarra Konte");

        int length = buffer.maxP();

        assertThat(length, is(12));
    }
}
