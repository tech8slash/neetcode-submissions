class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        // Count characters in s1
        for (char c : s1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        int L = 0;

        for (int R = 0; R < s2.length(); R++) {

            char c = s2.charAt(R);
            map2.put(c, map2.getOrDefault(c, 0) + 1);

            // Window size reached
            if (R - L + 1 == s1.length()) {

                if (map1.equals(map2)) {
                    return true;
                }

                // Remove left character
                char left = s2.charAt(L);

                map2.put(left, map2.get(left) - 1);

                if (map2.get(left) == 0) {
                    map2.remove(left);
                }

                L++;
            }
        }

        return false;
    }
}