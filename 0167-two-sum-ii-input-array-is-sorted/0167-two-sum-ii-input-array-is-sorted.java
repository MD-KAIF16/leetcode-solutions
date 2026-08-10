class Solution {
    public int[] twoSum(int[] num, int target) {
        int n = num.length ;
        int left = 0;
        int right = n-1;
        while(left < right ){
            int sum = num[left] + num[right];

            if( sum > target){
                right--;
            }

            else if( sum < target ){
                left++;
            }
            else{
                return new int[] {left+1 , right+1};
            }
        }

        return new int[] {-1 , -1};
    }
}