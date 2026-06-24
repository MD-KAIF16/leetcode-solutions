class Solution {
    public boolean isPalindrome(String s) {
        //In Question

        //1. Avoid Upper and lower -> I Choose Letter in LowerCase  (.isLowerCase())
        //2. Avoid Non Alpha numeric -> I avoid (.isLetterOrDigit())

        //Start taking both the ends pointer 

        int i = 0 ;
        int j = s.length() - 1;

        //Use Two Pointer Approach from both the end 
        while(i<j){
            //taking both the characters first 
            char left = s.charAt(i);  //Left Char
            char right = s.charAt(j);  //Right char 

            //Finding exact matching position for bpth the pointers by eliminating non ulpha numeric character

            //For i pointer 
            if(!Character.isLetterOrDigit(left)){  //if character is alphanumeric condition become true 
                 i = i+1; //so i increment the pointer 
                 continue ;  //current iteration ko skip krdega 
            }

            //For j pointer 
            if(!Character.isLetterOrDigit(right)){  //if character is alphanumeric condition become true 
                 j=j-1; //so j decrement the pointer 
                 continue ; //current iteration ko skip krdega 
            }

            //Last Main step comparing both the character in lowercase -> toLowerCase()
            if(Character.toLowerCase(left) != Character.toLowerCase(right))  
             ////Comparing both the left and right characters if condition becomes true return false 
            {
               return false ;
            }

            //if while condition not completeed 
            i=i+1;
            j=j-1;

        }
 

        //if nothing is happens then 
        return true ;

        
    }
}