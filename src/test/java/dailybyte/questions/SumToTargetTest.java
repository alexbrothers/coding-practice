package dailybyte.questions;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumToTargetTest {

    private static SumToTarget sumToTarget;

    @BeforeAll
    public static void setUp() {
        sumToTarget = new SumToTarget();
    }

    @Test
    public void testNoCorrectAnswers() {
        List<Integer> nums = Arrays.asList(6, 2, 8, 2, 1);

        List<List<Integer>> result = sumToTarget.sumToTarget(nums, 100);

        assertEquals(0, result.size());
    }

    @Test
    public void testDailyByteExample() {
        List<Integer> nums = Arrays.asList(8, 2, 2, 4, 5, 6, 3);

        List<List<Integer>> result = sumToTarget.sumToTarget(nums, 9);

        assertEquals(4, result.size());

        // Validate first result
        assertEquals(3, result.get(0).size());
        assertEquals(2, result.get(0).get(0));
        assertEquals(2, result.get(0).get(1));
        assertEquals(5, result.get(0).get(2));

        // Validate second result
        assertEquals(3, result.get(1).size());
        assertEquals(2, result.get(1).get(0));
        assertEquals(3, result.get(1).get(1));
        assertEquals(4, result.get(1).get(2));

        // Validate third result
        assertEquals(2, result.get(2).size());
        assertEquals(3, result.get(2).get(0));
        assertEquals(6, result.get(2).get(1));

        // Validate fourth result
        assertEquals(2, result.get(3).size());
        assertEquals(4, result.get(3).get(0));
        assertEquals(5, result.get(3).get(1));
    }

    @Test
    public void testWithNegativeNumbers() {
        List<Integer> nums = Arrays.asList(-9, -2, 7);

        List<List<Integer>> result = sumToTarget.sumToTarget(nums, 5);

        assertEquals(1, result.size());
        assertEquals(2, result.get(0).size());
        assertEquals(-2, result.get(0).get(0));
        assertEquals(7, result.get(0).get(1));
    }

    public void testEndingDuplicate() {
        List<Integer> nums = Arrays.asList(1, 2, 2);

        List<List<Integer>> result = sumToTarget.sumToTarget(nums, 3);

        assertEquals(1, result.size());
        assertEquals(2, result.get(0).size());
        assertEquals(1, result.get(0).get(0));
        assertEquals(2, result.get(0).get(1));
    }

}
