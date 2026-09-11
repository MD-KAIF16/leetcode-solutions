class Solution {
    public int maxArea(int[] height) {
        int n = height.length ;
        int l = 0;
        int r = n-1;
        int maxArea = -1;

        while( l < r)
        {
            int width = r - l;

            int ht = Math.min(height[l], height[r]); 

            int area = width * ht ;

            maxArea = Math.max(maxArea , area);

            if(height[l] < height[r]){
                l++;
            }
            else{
                r--;
            }

        }

        return maxArea;
    }
}