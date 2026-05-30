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
