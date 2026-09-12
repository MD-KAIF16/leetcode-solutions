class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0 ;
        int zerocnt = 0;
        int n = nums.length;


        for(int r = 0 ; r < n ; r++){
            if(nums[r] == 0) {
                zerocnt++;

            }
            if(zerocnt > k){
                if(nums[left] == 0){
                    zerocnt--;
                }
                left++;
            }
        }

        return n - left;
    }
}