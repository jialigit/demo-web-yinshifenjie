package com.example.yinshifenjie;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoWebYinshifenjieApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoWebYinshifenjieApplication.class, args);
	}

	@RequestMapping("/divide")
	public List<Integer> divide(int num) {

		return factor(num);
	}

	public List<Integer> factor(int num) {
		ArrayList list = new ArrayList();
		int[] pNum = Prime.findPrimes(num);

		for (int i = 0; pNum[i] * pNum[i] <= num;) {
			if (num % pNum[i] == 0) {
				list.add(new Integer(pNum[i]));
				num /= pNum[i];
			} else
				i++;
		}

		list.add(new Integer(num));
		
		
		
		return list;
	}
}

class Prime {
	public static int[] findPrimes(final int max) {
		int[] prime = new int[max + 1];
		ArrayList list = new ArrayList();

		for (int i = 2; i <= max; i++)
			prime[i] = 1;

		for (int i = 2; i * i <= max; i++) { // 这边可以改进
			if (prime[i] == 1) {
				for (int j = 2 * i; j <= max; j++) {
					if (j % i == 0)
						prime[j] = 0;
				}
			}
		}

		for (int i = 2; i < max; i++) {
			if (prime[i] == 1) {
				list.add(new Integer(i));
			}
		}

		int[] p = new int[list.size()];
		Object[] objs = list.toArray();
		for (int i = 0; i < p.length; i++) {
			p[i] = ((Integer) objs[i]).intValue();
		}

		return p;
	}

	public static void main(String[] args) {
		int[] prime = Prime.findPrimes(1000);

		for (int i = 0; i < prime.length; i++) {
			System.out.print(prime[i] + " ");
		}
//
		System.out.println();
	}
}