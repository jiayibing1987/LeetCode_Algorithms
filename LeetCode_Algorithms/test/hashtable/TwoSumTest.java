package hashtable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {

    private TwoSum twoSum;

    @BeforeEach
    void setUp() {
        twoSum = new TwoSum();
    }

    @Test
    void testBasicCase() {
        // [2, 7] sum to 9 → indices 0 and 1
        int[] nums = {2, 7, 11, 15};
        int[] result = twoSum.twoSum(nums, 9);
        assertTrue(nums[result[0]] + nums[result[1]] == 9);
    }

    @Test
    void testDuplicateValues() {
        // [2, 4] sum to 6 → indices 1 and 2
        int[] nums = {3, 2, 4};
        int[] result = twoSum.twoSum(nums, 6);
        assertTrue(nums[result[0]] + nums[result[1]] == 6);
    }

    @Test
    void testSamePairNotUsedTwice() {
        // Ensures index i is not reused (e.g., 3+3=6 but only one 3)
        int[] nums = {3, 2, 4};
        int[] result = twoSum.twoSum(nums, 6);
        assertNotEquals(result[0], result[1], "Same index should not be used twice");
    }

    @Test
    void testTwinElements() {
        // [3, 3] → indices 0 and 1
        int[] nums = {3, 3};
        int[] result = twoSum.twoSum(nums, 6);
        assertTrue(nums[result[0]] + nums[result[1]] == 6);
        assertNotEquals(result[0], result[1]);
    }

    @Test
    void testNegativeNumbers() {
        // [-3, 4] sum to 1
        int[] nums = {-3, 4, 1, 7};
        int[] result = twoSum.twoSum(nums, 1);
        assertTrue(nums[result[0]] + nums[result[1]] == 1);
    }

    @Test
    void testLargerArray() {
        // [11, 15] sum to 26 → indices 2 and 3
        int[] nums = {2, 7, 11, 15};
        int[] result = twoSum.twoSum(nums, 26);
        assertTrue(nums[result[0]] + nums[result[1]] == 26);
    }

    @Test
    void testResultIndicesAreValid() {
        int[] nums = {2, 7, 11, 15};
        int[] result = twoSum.twoSum(nums, 9);
        assertTrue(result[0] >= 0 && result[0] < nums.length);
        assertTrue(result[1] >= 0 && result[1] < nums.length);
    }
}