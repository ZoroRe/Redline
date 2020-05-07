package me.zoro.redline.leetcode;

import java.util.concurrent.CountDownLatch;

/**
 * @author luguanquan
 * @date 2020-05-07 19:56
 * <p>
 * 1114. 按序打印
 * <p>
 * 我们提供了一个类：
 * <p>
 * public class Foo {
 *   public void one() { print("one"); }
 *   public void two() { print("two"); }
 *   public void three() { print("three"); }
 * }
 * 三个不同的线程将会共用一个 Foo 实例。
 * <p>
 * 线程 A 将会调用 one() 方法
 * 线程 B 将会调用 two() 方法
 * 线程 C 将会调用 three() 方法
 * 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-in-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode1114 {

	/**
	 *  CountDownLatch
	 */
	public static class Foo {

		CountDownLatch one;
		CountDownLatch two;

		public Foo() {
			one = new CountDownLatch(1);
			one.countDown();
		}


		public void first(Runnable printFirst) throws InterruptedException {
			printFirst.run();
			// printFirst.run() outputs "first". Do not change or remove this line.
			one.countDown();
		}

		public void second(Runnable printSecond) throws InterruptedException {
			one.await();
			// printSecond.run() outputs "second". Do not change or remove this line.
			printSecond.run();
			two.countDown();
		}

		public void third(Runnable printThird) throws InterruptedException {
			two.await();
			// printThird.run() outputs "third". Do not change or remove this line.
			printThird.run();
		}
	}


	/**
	 * synchronized 方式
	 */
	public static class Foo0 {

		private int step;

		public Foo0() {
			step = 1;
		}

		public void first(Runnable printFirst) throws InterruptedException {
			// printFirst.run() outputs "first". Do not change or remove this line.
			synchronized (this) {
				printFirst.run();
				step++;
				notifyAll();
			}
		}

		public void second(Runnable printSecond) throws InterruptedException {
			// printSecond.run() outputs "second". Do not change or remove this line.
			synchronized (this) {
				while (step != 2) {
					wait();
				}
				printSecond.run();
				step++;
				notifyAll();
			}
		}

		public void third(Runnable printThird) throws InterruptedException {
			// printThird.run() outputs "third". Do not change or remove this line.
			synchronized (this) {
				while (step != 3) {
					wait();
				}
				printThird.run();
			}
		}
	}

}
