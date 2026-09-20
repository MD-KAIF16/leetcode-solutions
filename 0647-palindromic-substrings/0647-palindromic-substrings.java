class Solution {

    public int countSubstrings(String s) {

        int n = s.length();
        int count = 0;

        for (int i = 0; i < n; i++) {

            // Odd palindrome
            count += oddPalindrome(s, i);

            // Even palindrome
            count += evenPalindrome(s, i);
        }

        return count;
    }


    private int oddPalindrome(String s, int i) {

        int left = i;
        int right = i;

        int count = 0;

        while (left >= 0 &&
               right < s.length() &&
               s.charAt(left) == s.charAt(right)) {

            count++;

            left--;
            right++;
        }

        return count;
    }


    private int evenPalindrome(String s, int i) {

        int left = i;
        int right = i + 1;

        int count = 0;

        while (left >= 0 &&
               right < s.length() &&
               s.charAt(left) == s.charAt(right)) {

            count++;

            left--;
            right++;
        }

        return count;
    }
}