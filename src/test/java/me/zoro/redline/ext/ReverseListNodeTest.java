package me.zoro.redline.ext;

import me.zoro.redline.leetcode.entity.ListNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author luguanquan
 * @date 2020/5/16 10:40 上午
 */
@DisplayName("单链表反转")
public class ReverseListNodeTest {

	@DisplayName("三指针移动法")
	@Test
	public void reverseTest() {
		ListNode root = null;
		ReverseListNode reverseListNode = new ReverseListNode();
		assertEquals(root, reverseListNode.reverse(root));

		root = new ListNode(5);
		assertEquals("[5]", reverseListNode.reverse(root).toArrayString());

		root = new ListNode(5);
		root.next = new ListNode(6);
		assertEquals("[6,5]", reverseListNode.reverse(root).toArrayString());

		root = new ListNode(5);
		root.next = new ListNode(6);
		root.next.next = new ListNode(7);
		assertEquals("[7,6,5]", reverseListNode.reverse(root).toArrayString());
	}

	@DisplayName("反转前k个指针(长度小于K反转全部)")
	@Test
	public void reverseFrontKthTest() {
		ListNode root = null;
		ReverseListNode reverseListNode = new ReverseListNode();
		assertEquals(root, reverseListNode.reverseFrontKth(root, 1));

		root = new ListNode(1);
		assertEquals(root, reverseListNode.reverseFrontKth(root, 1));

		root = new ListNode(1);
		root.next = new ListNode(2);
		root.next.next = new ListNode(3);
		assertEquals("[1,2,3]", reverseListNode.reverseFrontKth(root, 1).toArrayString());

		root = new ListNode(1);
		root.next = new ListNode(2);
		root.next.next = new ListNode(3);
		assertEquals("[3,2,1]", reverseListNode.reverseFrontKth(root, 3).toArrayString());

	}
}
