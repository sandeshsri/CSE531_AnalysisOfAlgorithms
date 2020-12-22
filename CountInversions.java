//package com.buffalo.cse531.programmingAssignment;

import java.util.Arrays;
import java.util.Scanner;

public class CountInversions {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			int a[] = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			ArrayAndCount result = sortAndCount(a, n);
			System.out.println(result.count);
		}
	}

	private static ArrayAndCount sortAndCount(int[] a, int n) {
		// TODO Auto-generated method stub
		if (n == 1)
			return new ArrayAndCount(a, 0L);
		int mid = n / 2;
		int[] b = Arrays.copyOfRange(a, 0, mid);
		int[] c = Arrays.copyOfRange(a, mid, n);
		ArrayAndCount first = sortAndCount(b, mid);
		ArrayAndCount second = sortAndCount(c, n - mid);
		ArrayAndCount merged = mergeAndCount(first.arr, second.arr, mid, n - mid);
		return new ArrayAndCount(merged.arr, first.count + second.count + merged.count);
	}

	private static ArrayAndCount mergeAndCount(int[] b, int[] c, int n1, int n2) {
		// TODO Auto-generated method stub
		long count = 0L;
		int[] a = new int[n1 + n2];
		int i = 0, j = 0, k = 0;
		while (i < n1 || j < n2) {
			if (j >= n2 || (i < n1 && b[i] <= c[j])) {
				a[k] = b[i];
				i++;
				k++;
				count += j;
			} else {
				a[k] = c[j];
				j++;
				k++;
			}
		}
		return new ArrayAndCount(a, count);
	}

	static class ArrayAndCount {
		long count;
		int arr[];
		int size;

		public ArrayAndCount(int[] a, long count) {
			// TODO Auto-generated constructor stub
			this.count = count;
			int size = a.length;
			arr = new int[size];
			for (int i = 0; i < size; i++) {
				arr[i] = a[i];
			}
		}
	}
}
