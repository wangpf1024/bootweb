public class BinarySearchVariation7 {

    // 二分查找变种：寻找峰值
    public static int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[mid + 1]) {
                // 峰值可能在左侧
                high = mid;
            } else {
                // 峰值可能在右侧（包括 mid 本身）
                low = mid + 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 1};

        int peakIndex = findPeakElement(array);

        System.out.println("The peak element is at index " + peakIndex);
    }
}
