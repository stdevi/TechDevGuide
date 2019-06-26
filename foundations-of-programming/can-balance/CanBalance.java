public class CanBalance {

    public boolean canBalance(int[] nums) {
        int rightSum = 0;
        int leftSum = 0;

        for (int num : nums) {
            rightSum += num;
        }
        for (int num : nums) {
            leftSum += num;
            rightSum -= num;
            if (leftSum == rightSum) return true;
        }
        return false;
    }
}
