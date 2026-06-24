class Solution {
    public int[] sortedSquares(int[] nums) {
        //In Question 

        //given array nums in increasing order 
        //o/p -> return new  sorted square of each number array

        //Make new array 
        int[] res = new int[nums.length];

        //Taking two pointer approach
        int i = 0 ;
        int j = nums.length - 1;
        int k = res.length - 1; // approaching from right pointer

        while(i <= j){ //Compare with both the ends 
              if(Math.abs(nums[i]) > Math.abs(nums[j])){  //the big number becomes big square and putted into the array
                  res[k] = nums[i]*nums[i];  //approaching from right pointer
                  i++ ; //increament from older array
              }
              else{
                 res[k] = nums[j]*nums[j];  //approaching from right pointer
                  j-- ; //decreament from older array
              }

              //by refracting kth position
              k--;  //decrease k position for every operation
        }
            return res;
    }
}