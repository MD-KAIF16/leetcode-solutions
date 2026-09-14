class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {

        int m = mat.length;       // Number of rows
        int n = mat[0].length;    // Number of columns


        // ------------------------------------------------
        // STEP 1: Prefix Sum Matrix banana
        // ------------------------------------------------

        // +1 isliye liya hai taaki boundary handle karna easy ho
        int[][] prefix = new int[m + 1][n + 1];


        // i = 1 se start kar rahe hain
        // kyunki prefix matrix mein 0th row/column extra hai
        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                // Current cell ka prefix sum
                //
                // mat[i-1][j-1] = current actual value
                //
                // prefix[i-1][j] = upar ka sum
                // prefix[i][j-1] = left ka sum
                //
                // prefix[i-1][j-1] ko minus karna hai
                // kyunki woh area 2 baar add ho gaya

                prefix[i][j] =
                        mat[i - 1][j - 1]
                        + prefix[i - 1][j]
                        + prefix[i][j - 1]
                        - prefix[i - 1][j - 1];
            }
        }


        // ------------------------------------------------
        // STEP 2: Answer matrix
        // ------------------------------------------------

        int[][] answer = new int[m][n];


        // Har cell ke liye uska block sum nikalenge
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {


                // ----------------------------------------
                // Block ki boundaries nikal rahe hain
                // ----------------------------------------

                // i-k = upar ki boundary
                // Agar 0 se chhoti ho gayi toh 0 le lo
                int r1 = Math.max(0, i - k);

                // j-k = left boundary
                // Agar 0 se chhoti ho gayi toh 0 le lo
                int c1 = Math.max(0, j - k);

                // i+k = neeche ki boundary
                // Agar matrix se bahar ja rahi hai
                // toh last row (m-1) le lo
                int r2 = Math.min(m - 1, i + k);

                // j+k = right boundary
                // Agar matrix se bahar ja rahi hai
                // toh last column (n-1) le lo
                int c2 = Math.min(n - 1, j + k);


                // ----------------------------------------
                // Prefix matrix mein index 1 se start hota hai
                // isliye sabko +1 kar rahe hain
                // ----------------------------------------

                r1++;
                c1++;
                r2++;
                c2++;


                // ----------------------------------------
                // Ab rectangle ka SUM
                // ----------------------------------------

                answer[i][j] =
                        prefix[r2][c2]              // poora rectangle
                        - prefix[r1 - 1][c2]        // upar wala hatao
                        - prefix[r2][c1 - 1]        // left wala hatao
                        + prefix[r1 - 1][c1 - 1];   // double subtract hua tha,
                                                    // isliye wapas add
            }
        }


        return answer;
    }
}