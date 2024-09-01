import java.util.Arrays;

public class 퀵정렬_로무토파티션 {
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
		int i = left - 1;
		int pivot = arr[right];
		
		for (int j = left; j < right; j++) {
			if (arr[j] <= pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		arr[right] = arr[i+1];
		arr[i+1] = pivot;
		return i+1;
	}
}
