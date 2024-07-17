package supermario;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] mushroom = new int[10];
		
		for (int i=0; i<10; i++)
			mushroom[i] = sc.nextInt();		// 버섯 점수 입력
		
		int[] sum = new int[10];
		
		for (int i=0; i<10; i++)
			for (int j=0; j<=i; j++)
				sum[i] += mushroom[j];		// i번째 버섯까지 먹었을 때 점수
		
		int[] gap = new int[10];
		
		for (int i=0; i<10; i++) {
			if (sum[i]<=100)
				gap[i] = 100 - sum[i];		// 100보다 작은 sum에 대해 100과의 차이 구하기
			else
				gap[i] = sum[i] - 100;		// 100보다 큰 sum에 대해 100과의 차이 구하기
		}
		
		int mingap = gap[0];
		int N = 0;
		
		for (int i=0; i<10; i++)
			if (gap[i] <= mingap) {				// 등호를 빼면 100에 가까운 수 2개 중 작은 값이 선택됨 -> 큰 값을 선택해야 하므로 등호 넣음
				mingap = gap[i];			// 가장 작은 gap 구하기
				N = i;						// N번째 버섯에서 gap이 가장 작음
			}
		System.out.println(sum[N]);			// N번째 버섯까지의 합(=점수) 출력
	}
}
