class Solution {
    public void reverseString(char[] s) {
        //In Question

        //Swap the given character string without using extra space [O(1)] and in place 

        //by Two pointer approach
        int i = 0 ;
        int j = s.length - 1 ;

        while(i < j){
            char temp = s[i];
            s[i] = s[j];         //Cross logc method
            s[j] = temp;
        
         //after operation increment left ponter and decrement right pointer
            i++;
            j--;
        }

        //no return because of void return type
    }
}