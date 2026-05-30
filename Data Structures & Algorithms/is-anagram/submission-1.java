class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length() || s== null || t == null) {
            return false;
        }
        int[] sChars = new int[26];
        

        for(int i=0; i<s.length(); i++) {
            sChars[s.charAt(i) - 'a']++;
        }
        for(int i=0; i<t.length(); i++) {
            sChars[t.charAt(i) - 'a']--;
        }

        for(int i=0; i<sChars.length; i++) {
            if(sChars[i] > 0) {
                return false;
            }
        }

        return true;


    }
}
