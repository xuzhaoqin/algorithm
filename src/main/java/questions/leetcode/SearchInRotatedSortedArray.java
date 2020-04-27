package questions.leetcode;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        int retIndex = -1;
        while (leftIndex <= rightIndex) {

            int mid = (rightIndex + leftIndex) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            //只旋转一次，必然有一边是全有序的 ，优先判断全有序的
            if (nums[leftIndex] <= nums[mid]) {
                if (nums[leftIndex] <= target && target < nums[mid]) {
                    rightIndex = mid - 1;
                } else {
                    leftIndex = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[rightIndex]) {
                    leftIndex = mid + 1;
                } else {
                    rightIndex = mid - 1;
                }
            }

        }

        return retIndex;
    }

    public static void main(String[] args) {
        int[] a = new int[]{4,5,6,7,0,1,2};
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        System.out.println(searchInRotatedSortedArray.search(a, 0));
    }
}
