package flatten;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	public static int[] BubbleSort(int[] a) {
		int N = a.length;
		for (int i=0; i<N; i++) {
			for (int j=0; i+j<N-1; j++) {
				if (a[j]>a[j+1]) {
					int temp = 0;
					temp = a[j+1];
					a[j+1] = a[j];
					a[j] = temp;
				}
			}
		}
		return a;
	}
	
//	public static int[] countingSort(int[] a) {
//		int[] counts = new int[101];
//		for (int i=0; i<a.length; i++) {
//			counts[a[i]]++;
//		}
//		for (int i=0; i<counts.length-1; i++) {
//			counts[i+1] += counts[i];
//		}
//		int[] sortedA = new int[a.length];
//		for (int i=a.length-1; i>=0; i--) {
//			counts[a[i]]--;
//			sortedA[counts[a[i]]] = a[i];
//		}
//		for (int i = 0; i<a.length;i++)
//			a[i] = sortedA[i];
//		return a;
//	}
	
	public static int[] countingSort(int[] arr) {
		
		int max = 0;
		
		for (int i=0; i<arr.length; i++) {
			if (arr[i]>max) {
				max = arr[i];
			}
		}
		
		int[] counts = new int[max+1];
		
		for (int i=0; i<arr.length; i++) {
			counts[arr[i]]++;
		}
		
		for (int i=0; i<counts.length-1; i++) {
			counts[i+1] += counts[i];
		}
		
		int[] sortedArr = new int[arr.length];
		
		for (int i=arr.length-1; i>=0; i--) {
			counts[arr[i]]--;
			sortedArr[counts[arr[i]]] = arr[i];
		}
		
		for (int i=0; i<arr.length; i++) {
			arr[i] = sortedArr[i];
		}
		
		return arr;
	}
	
	public static void main(String[] args) {
		
//		int[] a = {1,4,7,4,1,3,7,9,3,5};
//		
//		countingSort(a);
//		
//		System.out.println(Arrays.toString(a));
		
		Scanner sc = new Scanner(System.in);
		
		int diff[] = new int[10];
		
		for (int t=0; t<10; t++) {
			
			int dump = sc.nextInt();
			
			int[] box = new int[100];
			
			for (int i=0; i<100; i++) {
				box[i] = sc.nextInt();
			}
			
			for (int i=0; i<dump; i++) {
				countingSort(box);
				box[0] += 1;
				box[99] -= 1;
				if (box[99] - box[0] <= 1) {
					break;
				}
			}
			countingSort(box);
			
			diff[t] = box[99] - box[0];
		}
		
		for (int i=0; i<10; i++) {
			System.out.println("#" + (i+1) + " " + diff[i]);
		}
	}
}
