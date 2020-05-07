package me.zoro.redline.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luguanquan
 * @date 2020-05-07 18:59
 * <p>
 * 572. 另一个树的子树
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。
 * s 也可以看做它自身的一棵子树。
 * <p>
 * https://leetcode-cn.com/problems/subtree-of-another-tree/
 */
public class Leetcode0572 {

	public boolean isSubtree(TreeNode s, TreeNode t) {
		List<TreeNode> listS = new ArrayList<>();
		listS.add(s);
		TreeNode currentS = null;
		while (listS.size() > 0) {
			//添加左右子树作为下次校验的根节点
			currentS = listS.get(0);
			if (currentS.left != null) {
				listS.add(currentS.left);
			}
			if (currentS.right != null) {
				listS.add(currentS.right);
			}
			//比较currentS节点未根的子树和t子树是否一致
			if (isSame(currentS, t)) {
				return true;
			}
			listS.remove(0);
		}
		return false;
	}

	public boolean isSame(TreeNode s, TreeNode t) {
		if (s == null && t == null) {
			return true;
		}
		if ((s == null && t != null) || (s != null && t == null)) {
			return false;
		}
		if (s.val != t.val) {
			return false;
		}
		return isSame(s.left, t.left) && isSame(s.right, t.right);
	}

	/**
	 * 树节点
	 */
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
