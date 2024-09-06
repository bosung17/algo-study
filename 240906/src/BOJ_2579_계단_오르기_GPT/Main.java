package BOJ_2579_계단_오르기_GPT; // 얘도 틀림 ㅋ

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();  // 계단의 개수
        
        // 계단 점수를 역순으로 입력받음 (stair[0]이 마지막 계단)
        int[] stair = new int[301];
        int[] dp = new int[301];

        for (int i = N - 1; i >= 0; i--) {
            stair[i] = sc.nextInt();
        }

        // 첫 번째 계단(즉, 역순에서 가장 마지막 계단)은 무조건 밟는다는 조건
        dp[0] = stair[0];
        
        if (N > 1) {
            dp[1] = stair[0] + stair[1];  // 첫 번째와 두 번째 계단을 밟는 경우
        }
        if (N > 2) {
            dp[2] = stair[0] + stair[2];  // 첫 번째와 세 번째 계단을 밟는 경우만 고려
        }

        // DP 진행: 연속으로 세 칸을 밟을 수 없다는 조건에 맞춰서 점화식 설정
        for (int i = 3; i < N; i++) {
            dp[i] = Math.max(dp[i - 2] + stair[i], dp[i - 3] + stair[i - 1] + stair[i]);
        }

        // 마지막 계단에 도달했을 때의 최대 점수 출력
        System.out.println(dp[N - 1]);

        sc.close();
    }
}
