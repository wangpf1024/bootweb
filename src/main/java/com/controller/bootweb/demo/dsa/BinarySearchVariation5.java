public class BinarySearchVariation5 {

    // 二分查找变种：在旋转数组中查找目标元素的索引
    public static int searchInRotatedArray(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // 判断哪一部分是有序的
            if (nums[low] <= nums[mid]) {  // 左半部分有序
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {  // 右半部分有序
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;  // 未找到目标元素
    }

    public static void main(String[] args) {
        int[] rotatedArray = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;

        int result = searchInRotatedArray(rotatedArray, target);

        if (result != -1) {
            System.out.println("The target " + target + " is at index " + result + " in the rotated array.");
        } else {
            System.out.println("The target " + target + " is not found in the rotated array.");
        }
    }
}
