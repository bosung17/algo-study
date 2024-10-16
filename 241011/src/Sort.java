import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort {
	public static void main(String[] args) {
		List<int[]> list = new ArrayList<>();
		int[][] board = new int[3][2];
		
		list.add(new int[] {1, 3});
		list.add(new int[] {1, 2});
		list.add(new int[] {0, 1});
		
		board[0] = new int[] {1, 3};
		board[1] = new int[] {1, 2};
		board[2] = new int[] {0, 1};
		
		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] > o2[0]) {
					return 1;
				} else if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				} else {
					return -1;
				}
			}
		});
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(Arrays.toString(list.get(i)));
		}
		
		System.out.println(Arrays.deepToString(board));
	}
}
