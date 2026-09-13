class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

         // ==============================
        // DEQUE METHODS - QUICK NOTES
        // ==============================

        // peekFirst() -> Front ka element DEKHO, remove nahi hota
        // peekLast()  -> Back ka element DEKHO, remove nahi hota

        // pollFirst() -> Front ka element REMOVE karo
        // pollLast()  -> Back ka element REMOVE karo

        // offerFirst(x) -> Front mein element ADD karo
        // offerLast(x)  -> Back mein element ADD karo

        // isEmpty() -> Check karo deque empty hai ya nahi
        // size()    -> Deque mein kitne elements hain


// Step 1: Initialize the deque and result array-------------------------------------------------------------------------
        // Deque stores INDICES, not values

        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[n - k + 1];


// Step 2: Setup deque for the first k elements-----------------------------------------------------------------------------

        for (int i = 0; i < k; i++) {

            // Remove all smaller elements from the back

            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);
        }


        // The front of the deque is the max of the first window

        result[0] = nums[deque.peekFirst()];

// Step 3: Process the remaining elements--------------------------------------------------------------------------------

        for (int i = k; i < n; i++) {

            // Remove the element that has slid out of the window

            if (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }


            // Remove all elements smaller than the incoming element

            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }


            // Add current element's index

            deque.offerLast(i);


            // The front of the deque is always the max of the window

            result[i - k + 1] = nums[deque.peekFirst()];
        }

        return result;
    }
}