class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length ;
        int start = 0;
        int end = n -1 ;
        while(start<=end){
            int mid = start + (end - start)/2;

            if(nums[mid]==target){
                return mid;
            }

            //check krna hh kaunsa part sort hai 
            if(nums[start]<=nums[mid]){  // agr true hui to left me hh
                if(nums[start]<=target && target <= nums[mid]){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
            else{//agr false hui to right me hh 
                if(nums[mid]<=target && target <= nums[end]){
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}