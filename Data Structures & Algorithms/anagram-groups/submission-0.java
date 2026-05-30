class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(int i=0; i<strs.length; i++) {
            char[] input = strs[i].toCharArray();
            Arrays.sort(input);
            String key = new String(input);
            if(map.containsKey(key)) {
                ArrayList<String> currentValues = map.get(key);
                currentValues.add(strs[i]);
                map.put(key, currentValues);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(key, list);
            }
        }
        return new ArrayList<>(map.values());
    }
}
