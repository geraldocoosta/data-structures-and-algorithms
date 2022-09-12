package org.example;

import java.util.Arrays;

public class MajorityElement {

	public static void main(String[] args) {

		System.out.println(majorityElement(new int[] { 3, 2, 3 }));
		System.out.println(majorityElement2(new int[] { 3, 2, 3 }));
	}

	public static int majorityElement2(int[] nums) {

		int count = 0;
		Integer candidate = null;

		for (int num : nums) {
			if (count == 0) {
				candidate = num;
			}

			var test = num == candidate ? 1 : -1;

			count += test;
		}

		return candidate;
	}

	public static int majorityElement(int[] nums) {

		if (nums == null) {
			return -1;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		Arrays.sort(nums);
		var maxCount = -1;
		var index = -1;

		var count = 1;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				count++;
				if (count > maxCount) {
					maxCount = count;
					index = i;
				}
			} else {
				count = 1;
			}
		}

		return nums[index];
	}

}
