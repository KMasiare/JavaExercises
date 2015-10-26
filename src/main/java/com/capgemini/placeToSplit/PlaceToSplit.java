package com.capgemini.placeToSplit;

/**
 * Given a non-empty array, return true if there is a place to split the array so that the sum of the numbers on one side is equal to the sum of the numbers on the other side.
 * Example:
 * {{{
 * canBalance({1, 1, 1, 2, 1}) → true
 * canBalance({2, 1, 1, 2, 1}) → false
 * canBalance({10, 10}) → true
 * }}}
 */
public final class PlaceToSplit {
	
    private PlaceToSplit() {
    }
    
    private static int countSum(int[] nums) {
    	int sum = 0;
    	for (int i = 0; i < nums.length; i++) {
    		sum += nums[i];
    	}
    	return sum;
    }

    public static boolean canBalance(int[] nums) {
    	int placeToSplit;
    	int leftSum = 0, rightSum = countSum(nums);
    	
    	for (placeToSplit = 0; placeToSplit < nums.length; placeToSplit++) {
    		if (leftSum == rightSum)
    			return true;
    		else {
    			leftSum += nums[placeToSplit];
    			rightSum -= nums[placeToSplit];
    		}
    	}
    	return leftSum == rightSum;
    }
    
    public static void main(String[] argv) {
    	int[] nums = {};
    	System.out.println(canBalance(nums));
    }
}
