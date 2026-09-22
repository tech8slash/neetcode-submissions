class Solution {
    public int characterReplacement(String s, int k) {
    HashMap<Character, Integer> map = new HashMap<>();
    int L = 0;
    int res = 0;
    int maxFreq = 0;
    for(int R = 0;R<s.length();R++){
        char c = s.charAt(R);
        map.put(c,map.getOrDefault(c , 0) + 1);
        maxFreq = Math.max(maxFreq,map.get(c));
        if((R - L + 1) - maxFreq > k){
            char left = s.charAt(L);
            map.put(left, map.get(left) - 1);
            L++;
        }
      res = Math.max(res, R - L + 1);
    }
     return res;
    }
}
