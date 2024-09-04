package SWEA_1251_하나로;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
	static int[] p;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			
			int N = sc.nextInt();
			int E = N*(N-1)/2;	// 간선의 개수
			
			int[][] board = new int[2][N];
			
			for (int r = 0; r < 2; r++) {
				for (int c = 0; c < N; c++) {
					board[r][c] = sc.nextInt();
				}
			}
			
			double[][] edge = new double[E][3];
			// {섬1, 섬2, 거리}
			
			int idx = 0;
			for (int a = 0; a < N-1; a++) {
				for (int b = a+1; b < N; b++) {
					edge[idx][0] = a;
					edge[idx][1] = b;
					edge[idx][2] = Math.pow(board[0][a] - board[0][b],2) + Math.pow(board[1][a] - board[1][b],2);
					idx++;
				}
			}
			
			Arrays.sort(edge, new Comparator<double[]>() {
				
				public int compare(double[] o1, double[] o2) {
					return (int) (o1[2] - o2[2]);
				}
			});
			
			p = new int[N]; // 각 정점의 대장 넣을 배열
			
			for (int i = 0; i < N; i++) {
				p[i] = i;	// 일단 대장은 나임
			}
			
			int count = 0;
			double dist = 0;
			for (int i = 0; i < E; i++) {
				
				int px = findSet((int)edge[i][0]);
				int py = findSet((int)edge[i][1]);
				
				if (px != py) {
					dist += edge[i][2];
					count++;
					union(px, py);
				}
				
				if (count == N-1) break;
			}
			double tax = sc.nextDouble();
			long ans = (long) (dist * tax + 0.5);
			System.out.println("#" + t + " " + ans);
			
		} // tc
	} // main
	
	static int findSet(int x) { // x 인덱스의 대장 찾기
		if (p[x] == x) {	// 대장 저장해둔 배열 p를 봤을 때 자신이 대장이면 출력
			return x;
		}
		else {
			return findSet(p[x]);
		}
	}
	
	static void union(int x, int y) {
		p[y] = x;
	}
}
