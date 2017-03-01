package com.gmail.yuomelyanchuk;

import java.util.Scanner;

public class Main {
	static boolean isArifmetic(int[] mass) {
		boolean b = true;
		int tmp = mass[0] - mass[1];
		for (int i = 0; i < mass.length - 1; i++) {
			if (mass[i] - mass[i + 1] != tmp) {
				b = false;
				return (b);
			}
		}
		return (b);
	}

	static boolean isGeometric(int[] mass) {
		boolean b = true;
		if (mass[0] == 0) {
			return (false);
		}
		int tmp = mass[1] / mass[0];
		for (int i = 0; i < mass.length - 1; i++) {
			if (mass[i] * tmp != mass[i + 1]) {
				b = false;
				return (b);
			}
		}
		return (b);
	}

	static boolean isPower(int[] mass) {
		boolean b = false;
		if (mass[0] == 0) {
			return (b);
		}
		for (int i = 1; i < 9; i++) {
			boolean tmp = true;
			for (int j = 1; j < mass.length; j++) {
				if (Math.pow(j, i) != mass[j - 1]) {
					tmp = false;
				}
			}
			b = tmp;
			if (b) {
				return (b);
			}
		}
		return (b);
	}

	static int sequencePower(int[] mass) {
		boolean b = false;
		for (int i = 1; i < 9; i++) {
			boolean tmp = true;
			for (int j = 1; j < mass.length; j++) {
				if (Math.pow(j, i) != mass[j - 1]) {
					tmp = false;
				}
			}
			b = tmp;
			if (b) {
				return (i);
			}
		}
		return (0);
	}

	static int testingType(int[] mass) {
		int tmp = 0;
		if (isArifmetic(mass)) {
			tmp = 1;
		}
		if (isGeometric(mass)) {
			tmp = 2;
		}
		if (isPower(mass)) {
			tmp = 3;
		}
		return (tmp);
	}

	static int unswer(int type, int[] mass) {
		if (type == 1) {
			return (mass[mass.length - 1] + (mass[mass.length - 2] - mass[mass.length - 3]));
		}
		if (type == 2) {
			return (mass[mass.length - 1] * (mass[mass.length - 2] / mass[mass.length - 3]));
		}
		if (type == 3) {
			return (int) Math.pow(mass.length + 1, sequencePower(mass));

		}

		return (0);

	}

	public static void main(String[] args) {
		System.out.println("enter a sequence of numbers through ',' end press enter");
		Scanner sc = new Scanner(System.in);
		String[] tmp = sc.nextLine().split("[,]");
		int[] seq = new int[tmp.length];
		for (int i = 0; i < seq.length; i++) {
			seq[i] = Integer.parseInt(tmp[i]);
		}
		System.out.println(unswer(testingType(seq), seq));

	}

}
