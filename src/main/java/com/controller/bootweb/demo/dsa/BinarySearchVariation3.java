public class BinarySearchVariation3 {

    // 二分查找变种：查找第一个大于等于目标值的元素的索引
    public static int findFirstGreaterOrEqual(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int result = -1;  // 初始化为-1，表示未找到

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] >= target) {
                result = mid;  // 更新结果，但不停止搜索，继续向左查找第一个大于等于目标值的元素
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 8, 8, 10};
        int target = 7;

        int result = findFirstGreaterOrEqual(sortedArray, target);

        if (result != -1) {
            System.out.println("The first element greater than or equal to " + target + " is at index " + result);
        } else {
            System.out.println("No element greater than or equal to " + target + " found in the array.");
        }
    }
}
