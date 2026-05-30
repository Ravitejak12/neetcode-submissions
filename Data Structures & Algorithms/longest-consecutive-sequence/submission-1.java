class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums) {
            set.add(i);
        }

        int longestSeq=0;
        
        for(int currentNum : nums) {
            if(!set.contains(currentNum-1)) {
                int count = 1;
                while(set.contains(currentNum+count)) {
                    count++;
                }
                longestSeq = Math.max(longestSeq, count);
            }
        }
        return longestSeq;

    }
}
