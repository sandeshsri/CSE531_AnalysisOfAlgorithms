//package com.buffalo.cse531.programmingAssignment;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Kruskal {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			int[] vertices = new int[N + 1];
			int[][] edge = new int[M][3];

			int[][] result = new int[N - 1][2];

			int[] parent = new int[N + 1];
			for (int i = 1; i < N + 1; i++) {
				vertices[i] = i;
				parent[i] = -1;
			}

			for (int i = 0; i < M; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}

			Arrays.sort(edge, new Comparator<int[]>() {
				@Override
				public int compare(int[] edge1, int[] edge2) {
					// TODO Auto-generated method stub
					return edge1[2] - edge2[2];
				}
			});
			int count = 0;
			int totalWeight = 0;
			for (int i = 0; i < M && count < N; i++) {
				int u = root(parent, edge[i][0]);
				int v = root(parent, edge[i][1]);
				if (u != v) {
					result[count][0] = edge[i][0];
					result[count][1] = edge[i][1];
					count++;
					totalWeight += edge[i][2];
					parent[u] = v;
				}
			}

			System.out.println(totalWeight);
			for (int i = 0; i < count; i++) {
				System.out.println(result[i][0] + " " + result[i][1]);
			}
		}
	}

	private static int root(int[] parent, int v) {
		// TODO Auto-generated method stub
		if (parent[v] == -1)
			return v;
		parent[v] = root(parent, parent[v]);
		return parent[v];
	}

}
