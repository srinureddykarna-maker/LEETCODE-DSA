class Solution {
    public int findDuplicate(int[] nums) {

        int slow = nums[0];
        int fast = nums[0];

        boolean phase2 = false;

        while (true) {

            if (!phase2) {
                slow = nums[slow];
                fast = nums[nums[fast]];

                if (slow == fast) {
                    slow = nums[0];
                    phase2 = true;
                }
            } 
            else {
                if (slow == fast) {
                    return slow;
                }

                slow = nums[slow];
                fast = nums[fast];
            }
        }
    }
}