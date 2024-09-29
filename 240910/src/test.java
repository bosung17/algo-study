import java.util.Arrays;

public class test {
	public static void main(String[] args) {
		
		int[] sel = {1,2,3};
		int[] sel2 = new int[3];

		int idx = 0;
		out:
		for (int i = 1; i <= 6; i++) {
			for (int j = 0; j <3; j++) {
			if (sel[j] == i) continue out;
			}
			sel2[idx++] = i;
		}
		
		System.out.println(Arrays.toString(sel2));
	}
}