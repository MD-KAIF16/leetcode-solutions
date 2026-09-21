import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        List<Integer> result = new ArrayList<>();

        // 1. Count characters of p
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        // 2. Sliding window on s
        for (int i = 0; i < s.length(); i++) {

            // Add current character to window
            sCount[s.charAt(i) - 'a']++;

            // If window size becomes greater than p.length(),
            // remove the character that is outside the window
            if (i >= p.length()) {
                sCount[s.charAt(i - p.length()) - 'a']--;
            }

            // 3. Compare frequencies
            if (Arrays.equals(pCount, sCount)) {

                // Starting index of current window
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }
}