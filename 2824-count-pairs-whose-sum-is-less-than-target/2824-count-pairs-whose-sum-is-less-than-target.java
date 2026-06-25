class Solution {
    public int countPairs(List<Integer> nums, int target) {
        //in Question 

        //count all pair sum less then target 

        //Sort in ArrayListy 
        Collections.sort(nums);    //Arrays.sort(nums)

        //both end pointers
        int i = 0 ;
        int j = nums.size()-1 ;        //nums.length
        
        //counter from 0
        int count = 0 ;


        //using two pointer approach 
        while(i < j ){
            int sum = nums.get(i) + nums.get(j) ;   //nums[i]

            if(sum < target){
                count = count + (j - i);
                i++;
            }
            else{
                j--;
            }

        }

        return count ;

    }
}