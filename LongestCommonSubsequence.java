//package com.buffalo.cse531.programmingAssignment;

import java.util.Scanner;

public class LongestCommonSubsequence {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			String A = sc.nextLine();
			String B = sc.nextLine();
			int n = A.length();
			int m = B.length();
			int[][] opt = new int[n + 1][m + 1];
			int[][] pi = new int[n + 1][m + 1];
			/*
			 * 0 -> diagonal 1 -> left 2 -> up
			 */
			for (int j = 0; j <= m; j++) {
				opt[0][j] = 0;
			}
			for (int i = 1; i <= n; i++) {
				opt[i][0] = 0;
				for (int j = 1; j <= m; j++) {
					if (A.charAt(i - 1) == B.charAt(j - 1)) {
						opt[i][j] = opt[i - 1][j - 1] + 1;
						pi[i][j] = 0;
					} else if (opt[i][j - 1] >= opt[i - 1][j]) {
						opt[i][j] = opt[i][j - 1];
						pi[i][j] = 1;
					} else {
						opt[i][j] = opt[i - 1][j];
						pi[i][j] = 2;
					}
				}
			}
			int i = n, j = m;
			StringBuilder S = new StringBuilder();
			while (i > 0 && j > 0) {
				if (pi[i][j] == 0) {
					S = S.append(A.charAt(i - 1));
					i--;
					j--;
				} else if (pi[i][j] == 1) {
					j--;
				} else {
					i--;
				}
			}
			System.out.println(opt[n][m]);
			System.out.println(S.reverse());
		}
	}
}
