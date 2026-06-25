class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //In question 
        //nums1 = m elment 
        //nums2 = n element 

        //o/p   nums1= m+n element 
      

      //usign two pointer appproach 
      //attacking both end the pointer in both the array

        int i = m - 1 ;
        int j = n - 1 ;

        //nums1 containing in output m+n elemnt so
        int k = m+n -1 ;

        while(i >= 0  && j >= 0){
            if(nums1[i] >= nums2[j]){
                nums1[k] = nums1[i];
                i--;
            }
            else{
                nums1[k] = nums2[j];
                j--;
            }

            k--;
        }
  

  //if ith position is less than 0 so all element goes directly into it 
  
        while(j>=0){
            nums1[k] = nums2[j];
            k--;
            j--;
        }
    }
}