package BOJ_2011_암호코드亡;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;

public class Main {
//	public static void main(String[] args) throws IOException {
//		
//		int[] dp = new int[5001];
//		int[] pw = new int[5001];
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		String str = br.readLine();
//		
//		for (int i = 0; i < str.length(); i++) {
//			pw[i] = (int) str.charAt(i) - '0';
//		}
//		
////		System.out.println(Arrays.toString(pw));
//		
//		dp[0] = 1;
//		
//		if (pw[0] <= 2) dp[1] = 2;
//		else dp[1] = 1;
//		
//		for (int i = 2; i <= 5000; i++) {
//			if (pw[i-1] <= 2) dp[i] = dp[i-2] + 2;
//			else dp[i] = dp[i-1];
//		}
//		
//		System.out.println(dp[str.length()-1]);
//	}
}
// 다시 해야됨