package me.zoro.redline.leetcode;

import me.zoro.redline.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luguanquan
 * @date 2020-05-13 22:16
 *
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *  
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * 通过次数130,654提交次数208,096
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Leetcode0102 {

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if(root == null){
			return result;
		}
		List<TreeNode> nodes = new ArrayList<>();
		nodes.add(root);
		int idxLevelStart = 0;
		int idxLevelEnd = 0;
		int idxCurrentNode = 0;
		while(idxCurrentNode < nodes.size()){
			if(idxCurrentNode == idxLevelStart){
				result.add(new ArrayList<Integer>());
			}
			result.get(result.size() - 1).add(nodes.get(idxCurrentNode).val);
			if(nodes.get(idxCurrentNode).left != null){
				nodes.add(nodes.get(idxCurrentNode).left);
			}
			if(nodes.get(idxCurrentNode).right != null){
				nodes.add(nodes.get(idxCurrentNode).right);
			}
			//添加下一层节点
			if(idxCurrentNode == idxLevelEnd){
				idxLevelStart = idxCurrentNode + 1;
				idxLevelEnd = nodes.size() - 1;
			}
			idxCurrentNode++;
		}
		return result;
	}

	/**
	 * 解法1
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrder1(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}
		List<List<Integer>> result = new ArrayList<>();
		List<List<TreeNode>> levels = new ArrayList<>();
		List<TreeNode> rootLevel = new ArrayList<>();
		rootLevel.add(root);
		levels.add(rootLevel);
		List<TreeNode> currentLevel;
		int level = 0;
		int nextLevel = 1;
		while (level < levels.size()) {
			currentLevel = levels.get(level);
			if (currentLevel != null) {
				for (TreeNode item : currentLevel) {
					//保存当前节点
					if (result.size() == level) {
						result.add(new ArrayList<Integer>());
					}
					result.get(level).add(item.val);
					//添加下一层节点
					if (levels.size() == nextLevel) {
						levels.add(new ArrayList<TreeNode>());
					}
					if (item.left != null) {
						levels.get(nextLevel).add(item.left);
					}
					if (item.right != null) {
						levels.get(nextLevel).add(item.right);
					}
				}
			}
			level++;
			nextLevel++;
		}
		return result;
	}


}
