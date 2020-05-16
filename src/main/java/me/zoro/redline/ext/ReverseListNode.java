package me.zoro.redline.ext;

import me.zoro.redline.leetcode.entity.ListNode;

/**
 * @author luguanquan
 * @date 2020/5/16 10:31 上午
 * <p>
 * 单链表反转
 */
public class ReverseListNode {

	public ListNode reverse(ListNode root) {
		if (root == null) {
			return null;
		}
		ListNode pre = null;
		ListNode cur = root;
		ListNode next = cur.next;
		while (next != null) {
			cur.next = pre;
			pre = cur;
			cur = next;
			if (next != null) {
				next = next.next;
			}
		}
		cur.next = pre;
		return cur;
	}

	/**
	 * 反转前kth 个，在 leetcode 25 中每k个反转一次，可以利用同样思想，但要考虑不同边界,这里假设不足k个全部反转
	 *
	 * @param root
	 * @param k
	 * @return
	 */
	public ListNode reverseFrontKth(ListNode root, int k) {
		if (root == null || root.next == null || k == 1) {
			return root;
		}
		ListNode pre = null;
		ListNode cur = root;
		ListNode next = cur.next;

		ListNode reverseStart = cur;
		// 反转k个只需要反转 k-1次
		while (k > 1) {
			if (next == null) {
				break;
			}
			cur.next = pre;
			pre = cur;
			cur = next;
			if (next != null) {
				next = next.next;
			}
		}
		if (cur.next != null) {
			reverseStart.next = cur.next;
		}
		cur.next = pre;
		return cur;
	}
}
