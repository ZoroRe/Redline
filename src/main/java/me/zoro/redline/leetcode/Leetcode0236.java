package me.zoro.redline.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luguanquan
 * @date 2020-05-10 17:19
 */
@Slf4j
public class Leetcode0236 {

	/**
	 * 本来还以为用递归才是影响性能，看来我进入误区了，反而这样递归效率很高
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return root;
		}
		if (root.val == p.val || root.val == q.val) {
			return root;
		}
		// 左右都找到，说明 p q 分别在对应子树的左右子树，因此公共祖先就是当前root
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left != null && right != null) {
			return root;
		}
		if (left != null) {
			return left;
		}
		return right;
	}

	public TreeNode lowestCommonAncestor0(TreeNode root, TreeNode p, TreeNode q) {
		int indexP = -1;
		int indexQ = -1;
		List<TreeNode> list = new ArrayList<>();
		list.add(root);
		if (p == root) {
			indexP = 0;
		}
		if (q == root) {
			indexQ = 0;
		}
		TreeNode current = null;
		int findChildIndex = 0;
		// 0, 1,3,7,15
		//在高度为 level 层的第一个节点是 2的level次幂 - 1, 最后节点是2的level次幂(1除外),因此可以从level2开始校验
		// 当level层完全添加完时，总节点数为 2 的 level 此幂，就是上面提到索引最后的值,深度0不用校验，从深度1开始
//		int levelStartIndex = 1;
//		int finishLevelTotal = 3;
//		int notNullCount = 0;
//		int sigleChildIndex = 0;

		// 找出pq的索引,以及存储它和它比它更浅的节点
		while (indexP == -1 || indexQ == -1) {
			//没有加这种特殊场景就会超时，当某一层只有一个节点且其为 p , q 之一时，当前点即为公共祖先节点(加了还是超时)
//			if (indexP == -1 && indexQ == -1 && list.size() == finishLevelTotal) {
//				notNullCount = 0;
//				for (int i = levelStartIndex; i < finishLevelTotal; i++) {
//					if (list.get(i) != null && notNullCount == 0) {
//						notNullCount = 1;
//						sigleChildIndex = i;
//					} else {
//						break;
//					}
//				}
//				if (notNullCount == 1 && (list.get(sigleChildIndex) == p || list.get(sigleChildIndex) == q)) {
//					return list.get(sigleChildIndex);
//				}
//				//校验后下一次总数升级
//				finishLevelTotal = finishLevelTotal * 2 + 1;
//			}

			current = list.get(findChildIndex++);
			if (current != null) {
				list.add(current.left);
				list.add(current.right);
			} else {
				list.add(null);
				list.add(null);
			}
			for (int i = findChildIndex; i < list.size(); i++) {
				if (p == list.get(i)) {
					indexP = i;
				}
				if (q == list.get(i)) {
					indexQ = i;
				}
			}
		}
		//依次往父节点查公共祖先
		while (indexP != indexQ) {
			if (indexP > indexQ) {
				indexP = (indexP - 1) / 2;
			} else {
				indexQ = (indexQ - 1) / 2;
			}
		}
		return list.get(indexQ);
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			return "TreeNode#{val=" + val + "}";
		}

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);

		Leetcode0236 solution = new Leetcode0236();
		TreeNode result = solution.lowestCommonAncestor0(root, root.left, root.right);
		log.info("result node is: {}", result);

	}
}
