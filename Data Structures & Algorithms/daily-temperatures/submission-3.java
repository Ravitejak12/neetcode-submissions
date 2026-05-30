class Solution {
    //Brute force
    // Time complexity: O(n2)
    // Space complexity: O(1) - result is usually considered as constant space. 
    // public int[] dailyTemperatures(int[] temperatures) {
    //    int[] result = new int[temperatures.length];
    //    for(int i=0; i<temperatures.length-1; i++) {
    //     for(int j=i+1; j<temperatures.length; j++) {
    //         if(temperatures[j] > temperatures[i]) {
    //             result[i] = j-i;
    //             break;
    //         }
    //     }
    //    }
    //    return result;
    // }

// Second Solution:
// Time Complexity: O(n)
// Space Complexity: O(n)
    public class Pair {
        public final int first;
        public final int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
       int[] result = new int[temperatures.length];
       Stack<Pair> stack = new Stack<>();

       for(int i=0; i<temperatures.length; i++) {
            while(!stack.isEmpty() && stack.peek().first < temperatures[i]) {
                result[stack.peek().second] = i - stack.peek().second;
                stack.pop();
            }
            stack.push(new Pair(temperatures[i], i));
       }
       
       return result;
    }
}

