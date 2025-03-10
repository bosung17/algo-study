import java.util.*;

public class BOJ_17472_Prim {
    static int N, M;
    static int[][] map;
    static int islandCount = 1; // 처음 1로 시작, BFS로 섬을 2번부터 번호 부여
    static List<int[]> bridges = new ArrayList<>();

    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        // 1. BFS를 이용해 섬을 2 ~ (섬의 총 개수+1)번으로 번호 설정
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    islandCount++;
                    bfs(i, j, islandCount, visited);
                }
            }
        }

        // 2. 다리 찾기 (문제 조건에 따라 다리를 놓을 때는 우, 하 방향만 사용)
        findBridges();

        // 3. 프림 알고리즘으로 최소 신장 트리(MST) 구하기
        int result = prim();
        System.out.println(result);
    }

    // BFS로 섬을 구분하여 번호를 2부터 부여 (섬을 올바르게 구분하기 위해 4방향 모두 탐색)
    static void bfs(int x, int y, int id, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { x, y });
        visited[x][y] = true;
        map[x][y] = id;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0], cy = cur[1];

            for (int i = 0; i < 4; i++) { // 4방향 탐색 (상, 하, 좌, 우)
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    map[nx][ny] = id;
                    queue.add(new int[] { nx, ny });
                }
            }
        }
    }

    // 다리 찾기 (문제 조건: 다리는 한 방향으로만 직선 이어져야 하고, 길이가 2 이상이어야 함)
    // 여기서는 우, 하 방향만 탐색
    static void findBridges() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] >= 2) { // 섬에서 출발하는 것만 고려
                    int island = map[i][j];
                    for (int d = 0; d < 2; d++) { // 우(→)와 하(↓) 방향만 탐색
                        int x = i, y = j, length = 0;

                        while (true) {
                            x += dx[d];
                            y += dy[d];

                            if (x < 0 || y < 0 || x >= N || y >= M || map[x][y] == island)
                                break;

                            if (map[x][y] == 0) { // 바다인 경우 길이 증가
                                length++;
                            } else { // 다른 섬을 만났을 경우
                                if (length >= 2) {
                                    bridges.add(new int[] { island, map[x][y], length });
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    // 프림 알고리즘으로 MST 구하기
    static int prim() {
        // 그래프 구성: 각 섬(노드)마다 인접한 다리(간선) 목록 저장
        // 섬 번호는 2번부터 islandCount까지 사용되므로, 크기는 islandCount+1로 설정
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= islandCount; i++) {
            graph.add(new ArrayList<>());
        }
        // bridges 리스트에 저장된 다리 정보를 양방향으로 그래프에 추가
        for (int[] bridge : bridges) {
            int u = bridge[0], v = bridge[1], w = bridge[2];
            graph.get(u).add(new int[] { v, w });
            graph.get(v).add(new int[] { u, w });
        }

        boolean[] visited = new boolean[islandCount + 1];
        // PriorityQueue의 원소는 {섬 번호, 다리 비용}이며, 비용 오름차순 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        // 임의의 시작 섬: 번호가 2부터 시작하므로 2번 섬 선택
        pq.offer(new int[] { 2, 0 });

        int mstWeight = 0;
        int count = 0;
        // 전체 섬의 개수 = islandCount - 1 (초기 islandCount는 1에서 시작했으므로)
        int totalIslands = islandCount - 1;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int island = cur[0], cost = cur[1];

            if (visited[island]) continue;
            visited[island] = true;
            mstWeight += cost;
            count++;

            // 현재 섬에서 갈 수 있는 모든 다리(간선)를 확인
            for (int[] next : graph.get(island)) {
                int nextIsland = next[0], nextCost = next[1];
                if (!visited[nextIsland]) {
                    pq.offer(new int[] { nextIsland, nextCost });
                }
            }
        }

        // 모든 섬이 연결되지 않았으면 -1 반환
        return (count == totalIslands) ? mstWeight : -1;
    }
}
