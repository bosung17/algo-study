package prime_number;

import java.util.Scanner;

//public class Solution {
//	public static void main(String[] args) {
//	
//	Scanner sc = new Scanner(System.in);
//	
//	int D = sc.nextInt();
//	
//	int A = sc.nextInt();
//	int B = sc.nextInt();
//	
//	int count = 0;
//	
//	for (int i=A;i<=B;i++) {
//		if (!(i/100000==D || (i%100000)/10000==D || (i%10000)/1000==D || (i%1000)/100==D || (i%100)/10==D || i%10==D)) {
//			continue;
//		}
//		boolean pN = true;
//		for (int j=2;j<i;j++)
//			if (i%j == 0) {
//				pN = false;
//				break;
//			}
//		if (pN == true){
//			count++;
//		}
//	}
//	System.out.println(count);
//	}
//}

public class Solution{
	public static void main(String[] args) {
		
		int[] arr = new int[1000001];
		
		arr[0] = 1;
		arr[1] = 1;
		
		for(int i=2;i<1000001;i++)
			for(int j=2;j<i;j++)
				if(i%j==0) {
					arr[i]=1;
					break;
				}
		
		Scanner sc = new Scanner(System.in);
		
		int D = sc.nextInt();
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		for (int i=A;i<=B;i++) {
			if (!(i/100000==D || (i%100000)/10000==D || (i%10000)/1000==D || (i%1000)/100==D || (i%100)/10==D || i%10==D)) {
				continue;
			}
			if (arr[i]==0)
				System.out.println(i);
		}
	}
}
