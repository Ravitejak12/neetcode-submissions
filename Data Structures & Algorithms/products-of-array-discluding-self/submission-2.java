// Intuition
// For each index, we need the product of all elements before it and all elements after it.
// Instead of recomputing the product repeatedly, we can pre-compute two helpful arrays:

// Prefix product: pref[i] = product of all elements to the left of i
// Suffix product: suff[i] = product of all elements to the right of i
// Then, the final answer for each index is simply:

// result[i] = pref[i] × suff[i]

// This works because:

// The pref handles everything before the index
// The suff handles everything after the index
// Both pieces together form the product of all numbers except the one at that position.
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] leftProduct = new int[len];
        int[] rightProduct = new int[len];
        int[] result = new int[len];
        leftProduct[0] = 1;
        rightProduct[len-1] = 1;

        for(int i=1; i<len ; i++) {
            leftProduct[i] = nums[i-1] * leftProduct[i-1];
        }

        for(int j=len-2; j>=0; j--) {
            rightProduct[j] = nums[j+1] * rightProduct[j+1];
        }

        for(int k=0; k<len; k++) {
            result[k] = leftProduct[k] * rightProduct[k];
        }
        return result;
    }
}  
