import java.util.Arrays;

public class 퀵정렬_호어파티션 {
	static int[] arr = {15, 23, 53, 54, 12, 123, 53, 5};
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
			// R이 마지막 인덱스일 때 L이 인덱스 에러가 나지 않도록 L <= R 조건 한 번 더 설정
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
		
		int temp = arr[left];
		arr[left] = arr[R];
		arr[R] = temp;
		
		return R;
	}
}
