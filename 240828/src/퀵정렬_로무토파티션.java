import java.util.Arrays;

public class 퀵정렬_로무토파티션 {
	static int[] arr = {12, 15, 32, 45, 123, 5, 12, 55};
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
		int pivot = arr[right];
		int i = left - 1;
		for (int j = left; j < right; j++) {
			if (arr[j] < pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		arr[right] = arr[i+1];
		arr[i+1] = pivot;
		return i + 1;
	}
}

//3 6 4 3 7 2 5
//3 4 6 3 7 2 5
//3 4 3 6 7 2 5
//3 4 3 2 7 6 5
//      i   j