package omok;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[][] table = new int[19][19];
		
		for (int i=0; i<19; i++) {
			for (int j=0; j<19; j++) {
				table[i][j] = sc.nextInt();
			}
		}
		
		int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
		int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
		
		boolean find = false;
		
		for (int i=0; i<19; i++) 
			for (int j=0; j<19; j++) {
				if (table[i][j] == 1) {
					for (int k=0; k<8; k++) {
						int count = 0;
						int movedI = i + dx[k];
						int movedJ = j + dy[k];
						for (int l=0; l<5; l++) {
							if (table[movedI][movedJ] == 1) {
								count += 1;
								movedI += dx[k];
								movedJ += dy[k];
							}
						}
						if (count == 4) {
							System.out.println("1");
							System.out.println((i+1) + " " + (j+1));
							find = true;
						}
					}
				}
				else if (table[i][j] == 2) {
					for (int k=0; k<8; k++) {
						int count = 0;
						int movedI = i + dx[k];
						int movedJ = j + dy[k];
						for (int l=0; l<5; l++) {
							if (table[movedI][movedJ] == 2) {
								count += 1;
								movedI += dx[k];
								movedJ += dy[k];
							}
						}
						if (count == 4) {
							System.out.println("2");
							System.out.println((i+1) + " " + (j+1));
							find = true;
						}
					}
				}
			if (find == true)
				break;
			}
		
		if (find == false)
			System.out.println("0");
	}
}
