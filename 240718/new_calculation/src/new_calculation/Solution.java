package new_calculation;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		int[][] arr = new int[300][300];
		
		for (int i=1; i<300; i++)
			for (int j=1; j<300; j++) {
				arr[i][j] = (i*i+2*i*j+j*j-i-(3*j)+2)/2;
			}
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		int[] K = new int[t];
		int[] Px = new int[t];
		int[] Py = new int[t];
		int[] Qx = new int[t];
		int[] Qy = new int[t];
		
		for (int k=0; k<t; k++) {
			int px = 0;
			int py = 0;
			int a = sc.nextInt();
			for (int i=1; i<300; i++)
				for (int j=1; j<300; j++) {
					if (arr[i][j] == a) {
						px=i;
						py=j;
					}
				}
			
			int qx = 0;
			int qy = 0;
			int b = sc.nextInt();
			for (int i=1; i<300; i++)
				for (int j=1; j<300; j++) {
					if (arr[i][j] == b) {
						qx=i;
						qy=j;
					}
				}
			K[k] = k;
			Px[k] = px;
			Py[k] = py;
			Qx[k] = qx;
			Qy[k] = qy;
		}
		
		for (int i=0; i<t;i++)
			System.out.println("#"+(K[i]+1)+" "+arr[Px[i]+Qx[i]][Py[i]+Qy[i]]);
		
	}
}