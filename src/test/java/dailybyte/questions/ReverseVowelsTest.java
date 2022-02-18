package dailybyte.questions;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReverseVowelsTest {

    private static ReverseVowels reverseVowels;

    @BeforeAll
    public static void setUp() {
        reverseVowels = new ReverseVowels();
    }

    @Test
    public void testReverseVowelsWithNullString() {
        assertNull(reverseVowels.reverseVowels(null));
    }

    @Test
    public void testReverseVowelsWithComputer() {
        assertEquals("cemputor", reverseVowels.reverseVowels("computer"));
    }

    @Test
    public void testReverseVowelsWithTheDailyByte() {
        assertEquals("The Dialy Byte", reverseVowels.reverseVowels("The Daily Byte"));
    }

}
