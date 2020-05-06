package me.zoro.redline.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.PriorityQueue;

/**
 * @author luguanquan
 * @date 2020-05-04 18:23
 * <p>
 * 接雨水2(立体)
 * 给你一个 m x n 的矩阵，其中的值均为非负整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。
 * <p>
 * https://leetcode-cn.com/problems/trapping-rain-water-ii/
 */
@Slf4j
public class Leetcode0407 {


	/**
	 * 注意，相比雨水1，这里可不是简单增加四个方向就够的，而是要增加周围一圈，这个一圈不一定是规则的矩形，只是包裹者目标点的一圈即可
	 *
	 * @param heightMap
	 * @return
	 */
	public int trapRainWater(int[][] heightMap) {
		if (heightMap == null || heightMap.length == 0 || heightMap[0] == null || heightMap[0].length == 0) {
			return 0;
		}
		int n = heightMap.length;
		int m = heightMap[0].length;
		//用一个有限队列记录当前最外层的圈子列表，这个圈子最初从上下左右添加，然后每次检查当前最低的点，对比其上下左右，
		// 然后取新高作为替换当前这个点的新最外层成员,通过上下左右四个点慢慢的就压缩到最里面的点，最终遍历全部，注意要避免重复遍历需要增加一个是否遍历的记录
		PriorityQueue<int[]> outerQueue = new PriorityQueue<>(((o1, o2) -> o1[2] - o2[2]));
		// 标记一个点是否被遍历过
		boolean[][] visited = new boolean[n][m];
		//首先用最外层的构建一个最外层圈子
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				//是上下左右的最外层圈子
				if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
					outerQueue.offer(new int[]{i, j, heightMap[i][j]});
					visited[i][j] = true;
				}
			}
		}
		int result = 0;
		//方向数组，每次取两个，当前坐标加上这连续的两个就成为当前点的周围中一点，顺序分别是:上-右-下-左
		int[] dirs = new int[]{-1, 0, 1, 0, -1};
		// 从当前最外层最小的点开始遍历，每次取一个点，分别去和他上下左右四个点比较，比较后取最高的点替换他，作为新一个最外层圈子的成员，
		// 并且要加上新高的点减去当前点的高度作为当前点接的雨水
		int nx;
		int ny;
		while (!outerQueue.isEmpty()) {
			int[] check = outerQueue.poll();
			for (int i = 0; i < 4; i++) {
				nx = check[0] + dirs[i];
				ny = check[1] + dirs[i + 1];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]) {
					if (heightMap[nx][ny] < check[2]) {
						result += (check[2] - heightMap[nx][ny]);
					}
					visited[nx][ny] = true;
					//两者比较后用更高的点作为向中间压缩进来的最新最外层点
					outerQueue.offer(new int[]{nx, ny, Math.max(check[2], heightMap[nx][ny])});
				}
			}
		}
		return result;
	}


	public static void main(String[] args) {
		Leetcode0407 solution = new Leetcode0407();
		int[][] heightMap = new int[][]{new int[]{12, 13, 1, 12},
				new int[]{13, 4, 13, 12},
				new int[]{13, 8, 10, 12},
				new int[]{12, 13, 12, 12},
				new int[]{13, 13, 13, 13
				}};
//		int[][] heightMap = new int[][]{
//				new int[]{1, 4, 3, 1, 3, 2},
//				new int[]{3, 2, 1, 3, 2, 4},
//				new int[]{2, 3, 3, 2, 3, 1}
//		};

		log.info("result:{}", solution.trapRainWater(heightMap));
	}
}
