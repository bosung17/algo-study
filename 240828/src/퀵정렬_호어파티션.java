public class 퀵정렬_호어파티션 {
	static int[] arr = {69, 10, 30, 8, 2, 16};
	static int N = arr.length;
	
	public static void main(String[] args) {
		
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
				// 여기 쓰는 중
			}
		}
	}
}
