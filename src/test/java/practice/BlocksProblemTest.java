package practice;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import practice.questions.BlocksProblem;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BlocksProblemTest {

    private static BlocksProblem blocksProblem;

    @BeforeAll
    public static void setUp() {
        blocksProblem = new BlocksProblem();
    }

    @Test
    public void testNotEnoughBlocks() {
        List<List<Character>> blocks = Arrays.asList(
                Arrays.asList('X', 'Q', 'P', 'S', 'W', 'O'),
                Arrays.asList('A', 'B', 'Q', 'T', 'Y', 'Z')
        );

        assertFalse(blocksProblem.canFormWord(blocks, "SAD"));
    }

    @Test
    public void testFailureWithRightNumberOfBlocks() {
        List<List<Character>> blocks = Arrays.asList(
                Arrays.asList('X', 'Q', 'P', 'S', 'W', 'O'),
                Arrays.asList('A', 'B', 'Q', 'T', 'Y', 'Z'),
                Arrays.asList('V', 'G', 'H', 'J', 'K', 'L')
        );

        assertFalse(blocksProblem.canFormWord(blocks, "SAD"));
    }

    @Test
    public void testSuccessWithRightNumberOfBlocks() {
        List<List<Character>> blocks = Arrays.asList(
                Arrays.asList('X', 'Q', 'P', 'S', 'W', 'O'),
                Arrays.asList('A', 'B', 'Q', 'T', 'Y', 'Z'),
                Arrays.asList('V', 'G', 'H', 'J', 'D', 'L')
        );

        assertTrue(blocksProblem.canFormWord(blocks, "SAD"));
    }

    @Test
    public void testSuccessWithRightNumberOfBlocksBacktrackNeeded() {
        List<List<Character>> blocks = Arrays.asList(
                Arrays.asList('A', 'Q', 'P', 'S', 'W', 'O'),
                Arrays.asList('A', 'B', 'Q', 'T', 'Y', 'Z'),
                Arrays.asList('V', 'G', 'H', 'J', 'D', 'L')
        );

        assertTrue(blocksProblem.canFormWord(blocks, "SAD"));
    }

    @Test
    public void testSuccessWithDoubleCharacter() {
        List<List<Character>> blocks = Arrays.asList(
                Arrays.asList('A', 'H', 'P', 'S', 'W', 'O'),
                Arrays.asList('A', 'B', 'Q', 'T', 'Y', 'Z'),
                Arrays.asList('V', 'A', 'H', 'J', 'D', 'L'),
                Arrays.asList('V', 'G', 'H', 'J', 'T', 'L')
        );

        assertTrue(blocksProblem.canFormWord(blocks, "THAT"));
    }

    @Test
    public void testSuccessWithExtraBlocks() {
        List<List<Character>> blocks = Arrays.asList(
                Arrays.asList('X', 'H', 'P', 'Q', 'W', 'O'),
                Arrays.asList('A', 'B', 'R', 'T', 'Y', 'Z'),
                Arrays.asList('V', 'A', 'H', 'J', 'S', 'L'),
                Arrays.asList('V', 'G', 'H', 'J', 'D', 'L')
        );

        assertTrue(blocksProblem.canFormWord(blocks, "SAD"));
    }

}
