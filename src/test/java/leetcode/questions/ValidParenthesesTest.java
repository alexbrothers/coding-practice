package leetcode.questions;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidParenthesesTest {

    private static ValidParentheses validParentheses;

    @BeforeAll
    public static void setUp() {
        validParentheses = new ValidParentheses();
    }

    @Test
    public void testSimple() {
        assertTrue(validParentheses.isValid("()"));
    }

    @Test
    public void testNonNested() {
        assertTrue(validParentheses.isValid("()[]{}"));
    }

    @Test
    public void testNested() {
        assertTrue(validParentheses.isValid("({[][]})"));
    }

    @Test
    public void testNonNestedFailure() {
        assertFalse(validParentheses.isValid("(]"));
    }

    @Test
    public void testClosingFirst() {
        assertFalse(validParentheses.isValid(")("));
    }

    @Test
    public void testExtraClosing() {
        assertFalse(validParentheses.isValid("()]"));
    }

    @Test
    public void testExtraOpening() {
        assertFalse(validParentheses.isValid("([]){"));
    }

}
