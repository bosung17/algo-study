import java.util.Arrays;

public class 병합정렬 {
	static int[] arr = {69, 10, 30, 8, 2, 16};
	static int N = arr.length;
	static int[] temp = new int[N];
	
	public static void main(String[] args) {
		mergeSort(0, N-1);
		System.out.println(Arrays.toString(arr));
	}
	
	static void mergeSort(int left, int right) {
		if (left < right) {
			int mid = (left + right)/2;
			mergeSort(left, mid);
			mergeSort(mid+1, right);
			merge(left, mid, right);
		}
	}
	
	static void merge(int left, int mid, int right) {
		int L = left;
		int R = mid+1;
		int idx = left;
		
		while (L <= mid && R <= right) {
			if (arr[L] <= arr[R]) {
				temp[idx++] = arr[L++];
			}
			else {
				temp[idx++] = arr[R++];
			}
		}
		
		if (L <= mid) {
			for (int i = L; i <= mid; i++) {
				temp[idx++] = arr[i];
			}
		}
		else {
			for (int i = R; i <= right; i++) {
				temp[idx++] = arr[i];
			}
		}
		
		for (int i = left; i <= right; i++) {
			arr[i] = temp[i];
		}
	}
}
