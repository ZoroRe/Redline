package me.zoro.redline.leetcode;

import lombok.extern.slf4j.Slf4j;
import me.zoro.redline.leetcode.entity.ListNode;

/**
 * @author luguanquan
 * @date 2020/5/16 9:36 下午
 * <p>
 * 25. K 个一组翻转链表
 * <p>
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 给你这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 *  
 * <p>
 * 说明：
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Slf4j
public class Leetcode0025 {

	public ListNode reverseKGroup(ListNode head, int k) {
		// 来自题解的一个思路，使用递归，很妙
		if (head == null || head.next == null || k == 1) {
			return head;
		}
		//找出需要反转的下一个节点，命名为 tail, 注意是下一个哦
		ListNode tail = head;
		for (int i = 0; i < k; i++) {
			// 说明不够k个，不需要反转
			if (tail == null) {
				return head;
			}
			tail = tail.next;
		}
		ListNode newHead = reverse(head, tail);
		// 注意这里很秒，经过 reverse 后 head 指向为空，然后他需要指向的就是下一个以 tail 开头的反转
		head.next = reverseKGroup(tail, k);
		return newHead;
	}

	/**
	 * 左闭右开反转
	 * 注意这里反转后，只是反转 head 和 tail(不含tail) 之间的节点
	 * 返回的值会是原始 tail 之前的节点,也就是反转后的 newHead
	 */
	private ListNode reverse(ListNode head, ListNode tail) {
		ListNode pre = null;
		ListNode next = null;
		while (head != tail) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}


	public static void main(String[] args) {
		Leetcode0025 solution = new Leetcode0025();
		ListNode root = new ListNode(1);
		root.next = new ListNode(2);
		root.next.next = new ListNode(3);
		root.next.next.next = new ListNode(4);
		root.next.next.next.next = new ListNode(5);
		ListNode newHead = solution.reverseKGroup(root, 2);
		log.info("反转后:{}", newHead.toArrayString());
	}
}
