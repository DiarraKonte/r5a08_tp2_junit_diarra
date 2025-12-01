package fr.einfolearning.tp2.metiers;

import fr.einfolearning.tp2.metiers.exceptions.EmacsKillRingOverflowException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class EmacsKillRingTest {

    @Test
    public void add_should_add_element_when_not_full() throws EmacsKillRingOverflowException {
        // Arrange
        EmacsKillRing killRing = new EmacsKillRing();
        String element = "test element";

        // Act
        killRing.add(element);

        // Assert
        assertThat(killRing.currentElt(), is(equalTo(element)));
    }

    @Test
    public void add_should_throw_exception_when_full() throws EmacsKillRingOverflowException {
        // Arrange
        EmacsKillRing killRing = new EmacsKillRing();

        // Fill the kill ring to its maximum capacity (MAX = 20)
        for (int i = 0; i < 20; i++) {
            killRing.add("element " + i);
        }

        // Act & Assert
        Assertions.assertThrows(EmacsKillRingOverflowException.class, () -> {
            killRing.add("overflow element");
        });
    }
}
