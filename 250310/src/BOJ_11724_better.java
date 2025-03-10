import java.util.Scanner;

public class BOJ_11724_better {
    static int[] parent;
    static int[] rank;  // 각 노드의 트리 깊이를 저장하는 rank 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        parent = new int[N + 1];
        rank = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            rank[i] = 1;  // 처음에는 모든 노드가 높이 1짜리 독립적인 집합
        }

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            union(u, v);
        }

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            if (find(i) == i) ans++;
        }

        System.out.println(ans);
    }

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);  // 경로 압축 적용
        }
        return parent[x];
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            // 랭크가 더 높은 트리에 낮은 트리를 붙임
            if (rank[rootA] > rank[rootB]) {
                parent[rootB] = rootA;
            } else if (rank[rootA] < rank[rootB]) {
                parent[rootA] = rootB;
            } else { // 랭크가 같으면 아무쪽이나 붙이고 rank 증가
                parent[rootB] = rootA;
                rank[rootA]++;
            }
        }
    }
}
