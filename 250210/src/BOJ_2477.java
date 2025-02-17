import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_2477 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        int[][] board = new int[6][2];
        for (int r = 0; r < 6; r++){
            for (int c = 0; c < 2; c++){
                board[r][c] = sc.nextInt();
            }
        }

        int big = 1;
        int[] count = new int[5];
        for (int i = 0; i < 6; i++){
            count[board[i][0]]++;
        }
        for (int i = 1; i <= 4; i++){
            if (count[i] == 1) {
                for (int j = 0; j < 6; j++){
                    if (board[j][0] == i) {
                        big *= board[j][1];
                    }
                }
            }
        }

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 4; i++){
            if (board[i][0] == board[i+2][0]) {
                arr.add(i);
            }
        }

        int small = 0;
        if (arr.size() == 2) {
            small = board[arr.get(1)][1] * board[arr.get(1) + 1][1];
        }
        else if (arr.size() == 1) {
            if (arr.get(0) == 0){
                small = board[arr.get(0)][1] * board[arr.get(0) + 1][1];
            }
            else {
                small = board[arr.get(0) + 1][1] * board[arr.get(0) + 2][1];
            }
        }
        else {
            small = board[0][1] * board[5][1];
        }
        System.out.println((big-small)*K);
    }
}
/*
4 2 3 1 3 1     2, 3    3, 4
1 4 2 3 1 3     3       4, 5
3 1 4 2 3 1     x       0, 5
1 3 1 4 2 3     0       0, 1
3 1 3 1 4 2     0, 1    1, 2
2 3 1 3 1 4     1, 2    2, 3
 */