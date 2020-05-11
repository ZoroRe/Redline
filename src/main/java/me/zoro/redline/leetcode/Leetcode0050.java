package me.zoro.redline.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * @author luguanquan
 * @date 2020-05-11 22:23
 */
@Slf4j
public class Leetcode0050 {

	public double myPow(double x, int n) {

		//分治，大学白读系类，看了题解才懂
		if (n == 0) {
			return 1;
		}
		if (n < 0) {
			// 这里 int 边界值有坑，不能直接取 -n,因为这里 -n 还是 Integer.MIN_VALUE
			if (n == Integer.MIN_VALUE) {
				return 1 / myPow(x, -(n + 1)) * x;
			}
			return 1 / myPow(x, -n);
		}
		return n % 2 == 1 ? x * myPow(x, n - 1) : myPow(x * x, n / 2);

		//对折过程,测试用例只过 303 / 304
        /*
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return x;
        }
        if(n == -1){
            return 1 / x;
        }
        boolean positive = n > 0;
        if(!positive){
            n = -n;
        }
        double result = 1.0D;
        while(n > 0){
            if(n % 2 == 1){
                result = result * x;
            }
            x = x * x;
            n = n / 2;
        }
        return positive ? result : 1 / result;
        */

		// 测试用例只通过 301/304
        /*if(n == 0){
            return 1;
        }
        if(Math.abs(x - 1.0) < 0.00000000001){
            return 1;
        }
        boolean positive = n > 0;
        if(!positive){
            n = -n;
        }
        double result = x;
        n--;
        while(n > 0){
            result = result * x;
            n--;
        }
        return positive ? result : 1 / result;
        */

		// 我就试试这样行不行,醉了真的可以
        /*
        return Math.pow(x, n);
        */
	}

	public static void main(String[] args) {
		log.info("xxxxxxxxxx {}, {},{},{}", Integer.MAX_VALUE, Integer.MIN_VALUE, -Integer.MAX_VALUE,
				-Integer.MIN_VALUE);
	}
}
