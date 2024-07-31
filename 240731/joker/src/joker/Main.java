package joker;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] card = new int[N];
				
		for (int i=0; i<N; i++) {
			card[i] = sc.nextInt();
		}
		
		Arrays.sort(card);
		
//		System.out.println(Arrays.toString(card));
		
		int countzero = 0;
		
		for (int i=0; i<N; i++) {
			if (card[i] == 0)
				countzero++;
			else break;
		}
		
		int[] space = new int[N-1];
		
		for (int i=0; i<N-1; i++) {
			space[i] = card[i+1] - card[i] - 1;
			if (space[i] == -1) {
				space[i] = 0;
			}
		}

		System.out.println(Arrays.toString(space));
		
		
//		System.out.println(countzero);
	}
}
