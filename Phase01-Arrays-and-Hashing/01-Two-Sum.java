
/*
 * =====================================================
 * PROBLEM 01: TWO SUM
 * =====================================================
 *
 * Platform   : LeetCode
 * Link       : https://leetcode.com/problems/two-sum/
 * Topic      : Arrays & Hashing
 * Difficulty : Easy
 *
 * PROBLEM STATEMENT:
 *
 * Given an array of integers nums and an integer target,
 * return the indices of two numbers whose sum equals
 * the target.
 *
 * You cannot use the same element twice.
 *
 * EXAMPLE:
 *
 * Input  : nums = [2, 7, 11, 15], target = 9
 * Output : [0, 1]
 *
 * Explanation:
 * nums[0] + nums[1] = 2 + 7 = 9
 *
 * =====================================================
 * APPROACH 1: BRUTE FORCE
 * =====================================================
 *
 * EXPLANATION:
 *
 * The simplest approach is to check every possible pair
 * of numbers using two nested loops.
 *
 * STEPS:
 *
 * 1. Use the first loop to select an element.
 * 2. Use the second loop to select another element.
 * 3. Check whether their sum equals the target.
 * 4. If yes, return their indices.
 * 5. Otherwise, continue checking the remaining pairs.
 *
 * DRY RUN:
 *
 * nums = [2, 7, 11, 15]
 * target = 9
 *
 * i = 0, j = 1
 * nums[0] + nums[1] = 2 + 7 = 9
 *
 * Answer = [0, 1]
 *
 * JAVA CODE:
 *
 * public int[] twoSumBruteForce(int[] nums, int target) {
 *
 *     for (int i = 0; i < nums.length; i++) {
 *
 *         for (int j = i + 1; j < nums.length; j++) {
 *
 *             if (nums[i] + nums[j] == target) {
 *                 return new int[]{i, j};
 *             }
 *         }
 *     }
 *
 *     return new int[]{};
 * }
 *
 * TIME COMPLEXITY  : O(n²)
 * SPACE COMPLEXITY : O(1)
 *
 * WHY?
 * We check every possible pair using nested loops.
 * No additional data structure is required.
 *
 *
 * =====================================================
 * APPROACH 2: OPTIMAL - HASHMAP
 * =====================================================
 *
 * EXPLANATION:
 *
 * Instead of checking every possible pair, we can use
 * a HashMap to make searching faster.
 *
 * The main idea is to find the complement.
 *
 * complement = target - current number
 *
 * If the complement already exists in our HashMap,
 * we have found the two required numbers.
 *
 * STEPS:
 *
 * 1. Create a HashMap to store numbers and their indices.
 * 2. Traverse the array.
 * 3. Calculate the complement.
 * 4. Check if the complement exists in the HashMap.
 * 5. If found, return both indices.
 * 6. Otherwise, store the current number and its index.
 *
 * DRY RUN:
 *
 * nums = [2, 7, 11, 15]
 * target = 9
 *
 * ITERATION 1:
 * Current number = 2
 * Complement = 9 - 2 = 7
 * 7 is not present in the map.
 * Store {2: 0}
 *
 * ITERATION 2:
 * Current number = 7
 * Complement = 9 - 7 = 2
 * 2 exists in the map at index 0.
 *
 * Answer = [0, 1]
 *
 * JAVA CODE:
 *
 * import java.util.HashMap;
 *
 * public int[] twoSum(int[] nums, int target) {
 *
 *     HashMap<Integer, Integer> map = new HashMap<>();
 *
 *     for (int i = 0; i < nums.length; i++) {
 *
 *         int complement = target - nums[i];
 *
 *         if (map.containsKey(complement)) {
 *             return new int[]{map.get(complement), i};
 *         }
 *
 *         map.put(nums[i], i);
 *     }
 *
 *     return new int[]{};
 * }
 *
 * TIME COMPLEXITY  : O(n) average
 * SPACE COMPLEXITY : O(n)
 *
 * WHY?
 * We traverse the array only once.
 * HashMap provides O(1) average lookup and insertion.
 *
 *
 * =====================================================
 * APPROACH COMPARISON
 * =====================================================
 *
 * Approach       Time Complexity    Space Complexity
 * -----------------------------------------------------
 * Brute Force    O(n²)               O(1)
 * HashMap        O(n) average        O(n)
 *
 *
 * =====================================================
 * KEY LEARNINGS
 * =====================================================
 *
 * 1. Array traversal using nested loops.
 * 2. HashMap and key-value pairs.
 * 3. containsKey() method.
 * 4. Complement-based searching.
 * 5. Improving time complexity using extra space.
 *
 * =====================================================
 * REVISION CHECKLIST
 * =====================================================
 *
 * [ ] Understand the brute-force approach.
 * [ ] Understand why HashMap is better.
 * [ ] Write both approaches without looking.
 * [ ] Explain time and space complexity.
 * [ ] Solve the problem independently on LeetCode.
 *
 * =====================================================
 */

import java.util.HashMap;

class Solution {

    // APPROACH 1: BRUTE FORCE

    public int[] twoSumBruteForce(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{};
    }


    // APPROACH 2: OPTIMAL - HASHMAP

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{};
    }
}
