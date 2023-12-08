public class BinarySearchVariation6 {

    // 二分查找变种：搜索插入位置
    public static int searchInsertPosition(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;  // 目标元素已存在，返回索引
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;  // 目标元素不存在，返回插入位置
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 3, 5, 6};
        int target = 5;

        int result = searchInsertPosition(sortedArray, target);

        System.out.println("The target " + target + " should be inserted at index " + result);
    }
}
