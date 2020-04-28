package questions.leetcode;

/**
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 *
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AloneNum {

    /**
     * 思路:
     * 相同两个数的异或结果为0，对整个数组两两异或可以找出两个不同数字异a,b或的值x。
     * 找到x中不为0的那一位，得出新值y。
     * 用y，进行且操作。可以将数组分组，每一组包含一个单独的数字。
     * （ps:因为x值，可以表示为两个单独数字不同的位。）
     * 然后每组两两异或，得到两个单独的数字
     */
    public int[] singleNumbers(int[] nums) {
        int x = 0;
        for (int num : nums) {
            x ^= num;
        }

        int y = 1;
        while ((x & y) == 0 && x != 0) {
            y = y << 1;
        }

        int[] ret = new int[2];
        for (int num : nums) {
            if ((num & y) == 0) {
                ret[0] ^= num;
            } else {
                ret[1] ^= num;
            }
        }

        return ret;
    }
}
