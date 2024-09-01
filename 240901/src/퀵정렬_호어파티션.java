import java.util.Arrays;

public class 퀵정렬_호어파티션 {
	static int[] arr = {1,2,6,2,5,4,143,6,34,13,634,53};
	static int N = arr.length;
	
	public static void main(String[] args) {
		quickSort(0, N-1);
		System.out.println(Arrays.toString(arr));
	}
	
	static void quickSort(int left, int right) {
		if (left < right) {
			int pivot = partition(left, right);
			quickSort(left, pivot-1);
			quickSort(pivot+1, right);
		}
	}
	
	static int partition(int left, int right) {
		int pivot = arr[left];
		
		int L = left + 1;
		int R = right;
		
		while (L <= R) {
			while (L <= R && arr[L] <= pivot) {
				L++;
			}
			while (arr[R] > pivot) {
				R--;
			}
			if (L < R) {
				int temp = arr[L];
				arr[L] = arr[R];
				arr[R] = temp;
			}
		}
		arr[left] = arr[R];
		arr[R] = pivot;
		
		return R;
	}
}
