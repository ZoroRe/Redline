package me.zoro.redline.leetcode.entity;

/**
 * @author luguanquan
 * @date 2020/5/16 10:31 上午
 */
public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int val) {
		this.val = val;
	}

	@Override
	public String toString() {
		return "ListNode{" +
				"val=" + val +
				", next=" + next +
				'}';
	}

	public String toArrayString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		ListNode node = this;
		while (node != null) {
			builder.append(node.val);
			node = node.next;
			if (node != null) {
				builder.append(",");
			}
		}
		builder.append("]");
		return builder.toString();
	}
}
