class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }

        int [] a = new int[26];
        int [] b = new int[26];

        //s1 char ki frequency count in array a ;
        for(char ch : s1.toCharArray()){
            a[ch - 'a']++;
        }

        //window size
        int k = s1.length();

        //s2 ki fre quencuy count in array b 
        for( int i = 0 ; i < k ; i++){
            b[s2.charAt(i)-'a']++;
        }


        //first window check kro 
        if(Arrays.equals(a,b)){
            return true;
        }


        //window ko aage 1-1 krke slide kro
        for(int right = k ; right < s2.length() ;right++){
            b[s2.charAt(right)-'a']++; //new char ko add kro
            b[s2.charAt(right-k) -'a']--;  //old char ko remobve kro


            //same frequncuy match kre return kro
            if(Arrays.equals(a,b)){
                return true ;
            }
        }

        return false;
    }
}