class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s: strs) {
            // We need delimiter because there might be string "123"
            sb.append(s.length()).append("#").append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        ArrayList<String> list = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            // Find where the delimiter '#' is
            int j = str.indexOf('#', i);
            
            // Extract the full number string and parse it to an integer
            int length = Integer.parseInt(str.substring(i, j));
            
            // The actual string starts right after the '#'
            int stringStart = j + 1;
            int stringEnd = stringStart + length;
            
            list.add(str.substring(stringStart, stringEnd));
            
            // Move our pointer to the start of the next encoded block
            i = stringEnd;
        }
        return list;
    }
}
