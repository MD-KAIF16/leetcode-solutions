class Solution {

    //Making Palindrome checkmethod
    public boolean ispalindrome(int i , int j , String s ){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }

            i++;
            j--;
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        //In Question 

       //One character could be delete so still it is palindrome

       //Taking two ends pointer from two pointer approach
       int i = 0 ;
       int j = s.length() - 1;

       while(i<j){

        //taking both ends characters
        char left = s.charAt(i);
        char right = s.charAt(j);
        

        //taking that pointer where both character fails to match
        if(left!=right ){
            return ispalindrome(i+1,j,s) || ispalindrome(i,j-1,s);   //if any condition becomes true then it is Valid palindrome 
        }
        
        i++;
        j--;
    
       }
        return true;
       
    }
    
}