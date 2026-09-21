import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        int n = s.length();

        // Current window ke unique characters
        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int max = 0;

        for (int right = 0; right < n; right++) {

            char rchr = s.charAt(right);

            // Duplicate mile to left ko move karo
            while (set.contains(rchr)) {
                set.remove(s.charAt(left));
                left++;
            }

            // Current character add karo
            set.add(rchr);

            // Maximum window length update karo
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}