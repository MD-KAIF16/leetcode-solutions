class Solution {

    public String longestPalindrome(String s) {

        int n = s.length();

        String ans = "";

        for (int i = 0; i < n; i++) {

            // Odd length palindrome
            String odd = oddPalindrome(s, i);

            // Even length palindrome
            String even = evenPalindrome(s, i);

            if (odd.length() > ans.length()) {
                ans = odd;
            }

            if (even.length() > ans.length()) {
                ans = even;
            }
        }

        return ans;
    }


    // aba, racecar
    private String oddPalindrome(String s, int i) {

        int left = i;
        int right = i;

        while (left >= 0 &&
               right < s.length() &&
               s.charAt(left) == s.charAt(right)) {

            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }


    // bb, abba
    private String evenPalindrome(String s, int i) {

        int left = i;
        int right = i + 1;

        while (left >= 0 &&
               right < s.length() &&
               s.charAt(left) == s.charAt(right)) {

            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }
}