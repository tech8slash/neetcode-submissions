class Solution {
    public String minWindow(String s, String t) {
        if(t.isEmpty()) return "";
       Map<Character, Integer> countT = new HashMap<>();
       Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

       int have = 0;
       int l = 0;
       int need = countT.size();
       int resLength = Integer.MAX_VALUE;
       int[] res = {-1,-1};

       for(int r = 0;r<s.length();r++){
         char c = s.charAt(r);
         window.put(c, window.getOrDefault(c, 0)+1);

         if(countT.containsKey(c) && window.get(c).equals(countT.get(c))){
            have++;
         }

         while(have == need){
            if((r - l + 1)<resLength){
                resLength = r - l + 1;
                res[0] = l;
                res[1] = r;
            }
            char leftchar = s.charAt(l);
            window.put(leftchar,window.get(leftchar) - 1);
            if(countT.containsKey(leftchar) && window.get(leftchar)<countT.get(leftchar)){
                have--;
            }
            l++;
         }
       }
       return resLength == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
