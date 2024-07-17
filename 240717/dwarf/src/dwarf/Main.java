package dwarf;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		int[] height = new int[9];	
		int sum = 0;
		
		Scanner sc = new Scanner(System.in);
		
		for (int i=0; i<9; i++) {
			height[i] = sc.nextInt();	// 난쟁이 키 입력
			sum += height[i];			// 9명의 난쟁이의 키의 합
		}
		
		Arrays.sort(height);			// 난쟁이 키 오름차순 나열
		
		int N = sum;
		int I = 0;
		int J = 0;						// I번째, J번째의 가짜 난쟁이
		
		while(true) {
			for (int i=0; i<9; i++)
				for (int j=0; j<9; j++) {
					N = sum - height[i] - height[j];
					if (N==100) {
						I = i;
						J = j;
						break;			// sum에서 2명의 키를 뺐을 때 100이 되면 가짜 난쟁이 찾음!
					}
				}
			break;
		}
		
		for (int i=0; i<9; i++)
			if (i!=I)
				if(i!=J)
					System.out.println(height[i]); // I번째와 J번째 난쟁이 빼고 키 출력
		
	}

}