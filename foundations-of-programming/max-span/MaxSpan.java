public class MaxSpan {

    public int maxSpan(int[] nums) {
        int maxSpan = 0;
        int currentSpan;
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j >= 0; j--) {
                if (nums[i] == nums[j]) {
                    currentSpan = j - i + 1;
                    maxSpan = Math.max(currentSpan, maxSpan);
                    break;
                }
            }
        }
        return maxSpan;
    }
}
