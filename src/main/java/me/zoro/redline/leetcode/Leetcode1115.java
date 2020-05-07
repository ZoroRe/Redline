package me.zoro.redline.leetcode;

import java.util.concurrent.Semaphore;

/**
 * @author luguanquan
 * @date 2020-05-07 20:29
 * <p>
 * 1115. 交替打印FooBar
 * <p>
 * 我们提供一个类：
 * <p>
 * class FooBar {
 * public void foo() {
 *     for (int i = 0; i < n; i++) {
 *       print("foo");
 *     }
 * }
 * <p>
 * public void bar() {
 *     for (int i = 0; i < n; i++) {
 *       print("bar");
 *     }
 * }
 * }
 * 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。
 * <p>
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-foobar-alternately
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode1115 {

	public static class FooBar {

		private int n;
		private Semaphore semaphoreFoo;
		private Semaphore semaphoreBar;

		public FooBar(int n) {
			this.n = n;
			semaphoreFoo = new Semaphore(1);
			semaphoreBar = new Semaphore(1);
			try {
				semaphoreBar.acquire();
			} catch (InterruptedException e) {

			}
		}

		public void foo(Runnable printFoo) throws InterruptedException {

			for (int i = 0; i < n; i++) {
				semaphoreFoo.acquire();
				// printFoo.run() outputs "foo". Do not change or remove this line.
				printFoo.run();
				semaphoreBar.release();
			}
		}

		public void bar(Runnable printBar) throws InterruptedException {

			for (int i = 0; i < n; i++) {
				// printBar.run() outputs "bar". Do not change or remove this line.
				semaphoreBar.acquire();
				printBar.run();
				semaphoreFoo.release();
			}
		}
	}
}
