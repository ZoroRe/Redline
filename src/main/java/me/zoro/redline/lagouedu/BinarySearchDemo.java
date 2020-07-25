package me.zoro.redline.lagouedu;

/**
 * @author luguanquan
 * @date 2020/7/25 10:50 下午
 * <p>
 * 给定一个经过任意位数的旋转后的排序数组，判断某个数是否在里面【来自拉钩教育算法课程的一道题】
 * <p>
 * 例如，对于一个给定数组[4,5,6,7,0,1,2],他是将一个有序数组的前三位旋转的放在数组末尾，假设输入 target = 0,则输出答案4
 * 即0所在索引为4,如果输入3，则返回-1
 */
public class BinarySearchDemo {
	/**
	 * 思路，简单来说直接遍历O(n),适当两端调整也许能优化点，但还是O(n)
	 * 思考，对于这个数字，因为是排序，可以考虑二分法
	 * 对于如上例子，从数组从取一个位置的值，这个值要么是旋转点，如0(或者7)，则剩下的左边[4,5,6,7]有序,右边[1,2]有序
	 * 要么在左边这如 6,左边有序[4,5]右边[7,0,1,2]旋转后也有序
	 * 或者右边如1,则[2]有序[4,5,6,7,0]旋转有序
	 *
	 * @param arr
	 * @param target
	 * @return
	 */
	public int solution(int[] arr, int target) {
		return bs(arr, target, 0, arr.length - 1);
	}

	private int bs(int[] arr, int target, int start, int end) {
		if (start == end) {
			if (target == arr[start]) {
				return start;
			}
			return -1;
		}
		int middle = (start + end) / 2;
		// 先看目标值是否在有序部分，否则从旋转有序再次划分查找
		if (arr[start] < arr[middle]) {
			//左边有序,在有序范围内，则在里面找
			if (arr[start] <= target && target <= arr[middle]) {
				return bs(arr, target, start, middle);
			}
			//不在范围右边继续bs
			return bs(arr, target, middle + 1, end);
		} else {
			//进入这里所有左边旋转有序，先看右边
			if (arr[middle + 1] <= target && target <= arr[end]) {
				return bs(arr, target, middle + 1, end);
			}
			//在左边
			return bs(arr, target, start, middle);
		}
	}

}
