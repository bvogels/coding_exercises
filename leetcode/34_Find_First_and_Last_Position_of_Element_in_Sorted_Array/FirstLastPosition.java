public class FirstLastPosition {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums.length == 1 && target == nums[0])  {
            return new int[]{0, 0};
        }
        else if (nums.length == 1) {
            return result;
        }
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == target) {
                result[0] = i;
                while (i < nums.length && nums[i] == target) {
                    result[1] = i;
                    i++;
                }
                return result;
            }
            i++;
        }
        return result;
    }
}
