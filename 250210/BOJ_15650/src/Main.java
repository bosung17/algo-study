import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++){
            arr[i] = N-i;
        }

        for (int i = (1 << N)-1; i >= 0 ; i--){
            ArrayList ans = new ArrayList<>();
            for (int j = N-1; j >= 0; j--){
                if ((i & 1 << j) != 0) {
                    ans.add(arr[j]);
                }
            }
            if (ans.size() == M) {
                for (int j = 0; j < M; j++){
                    System.out.print(ans.get(j) + " ");
                }
                System.out.println();
            }
        }
    }
}