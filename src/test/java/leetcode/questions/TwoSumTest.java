package leetcode.questions;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwoSumTest {

    private static TwoSum twoSum;

    @BeforeAll
    public static void setUp() {
        twoSum = new TwoSum();
    }

    @Test
    public void testExampleOne() {
        int[] result = twoSum.twoSum(new int[]{2, 7, 11, 15}, 9);
        assertEquals(result[0], 0);
        assertEquals(result[1], 1);
    }

    @Test
    public void testExampleTwo() {
        int[] result = twoSum.twoSum(new int[]{3, 2, 4}, 6);
        assertEquals(result[0], 1);
        assertEquals(result[1], 2);
    }

    @Test
    public void testExampleThree() {
        int[] result = twoSum.twoSum(new int[]{3, 3}, 6);
        assertEquals(result[0], 0);
        assertEquals(result[1], 1);
    }

}
