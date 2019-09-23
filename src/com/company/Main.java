package com.company;

public class Main {

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, 2, -1, 2};
        new Solution().maxTwoSubArrays(nums);
    }
}

class Solution {
    /*
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(int[] nums) {
        // write your code
        if (nums == null || nums.length == 0) return 0;
        int size = nums.length;
        int[] left = new int[size];
        int[] right = new int[size];
        int min = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int i = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, sum - min);
            min = Math.min(min, sum);
            left[i++] = max;
        }

        min = 0;
        max = Integer.MIN_VALUE;
        sum = 0;
        for (i = size - 1; i >= 0; i--) {
            sum += nums[i];
            max = Math.max(max, sum - min);
            min = Math.min(min, sum);
            right[i] = max;
        }

        int rst = Integer.MIN_VALUE;
        for (i = 0; i < size - 1; i++) {
            rst = Math.max(rst, left[i] + right[i + 1]);
        }
        return rst;
    }
}