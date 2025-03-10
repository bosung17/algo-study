import java.util.*;

public class BOJ_17472 {
	static int N, M;
	static int[][] map;
	static int[] parent, rank;
	static int islandCount = 1;
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

		// 1. BFS를 이용해 섬을 2 ~ N+1번으로 번호 설정
		boolean[][] visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					islandCount++;
					bfs(i, j, islandCount, visited);
				}
			}
		}

		// 2. 다리 찾기
		findBridges();

		// 3. 크루스칼 알고리즘으로 최소 신장 트리 구하기
		int result = kruskal();
		System.out.println(result);
	}

	// BFS로 섬을 구분하여 번호를 2부터 부여
	static void bfs(int x, int y, int id, boolean[][] visited) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y });
		visited[x][y] = true;
		map[x][y] = id;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cx = cur[0], cy = cur[1];

			for (int i = 0; i < 4; i++) {
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

	// 다리 찾기
	static void findBridges() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] >= 2) { // 섬에서 출발하는 것만 고려
					int island = map[i][j];
					for (int d = 0; d < 2; d++) {
						int x = i, y = j, length = 0;

						while (true) {
							x += dx[d];
							y += dy[d];

							if (x < 0 || y < 0 || x >= N || y >= M || map[x][y] == island)
								break;

							if (map[x][y] == 0) { // 바다
								length++;
							} else { // 다른 섬을 만남
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

	// 크루스칼 알고리즘으로 최소 신장 트리(MST) 구하기
	static int kruskal() {
		parent = new int[islandCount + 1];
		rank = new int[islandCount + 1];
		for (int i = 0; i <= islandCount; i++) {
			parent[i] = i;
			rank[i] = 1;
		}

		// 다리를 길이 기준으로 정렬
		bridges.sort(Comparator.comparingInt(a -> a[2]));

		int mstWeight = 0, connected = 0;
		for (int[] bridge : bridges) {
			int u = bridge[0], v = bridge[1], w = bridge[2];

			if (union(u, v)) {
				mstWeight += w;
				connected++;
				if (connected == islandCount - 2)
					break;
			}
		}

		// 모든 섬이 연결되지 않으면 -1 반환
		return (connected == islandCount - 2) ? mstWeight : -1;
	}

	// 유니온 파인드 - find 연산 (경로 압축 적용)
	static int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}

	// 유니온 파인드 - union 연산 (랭크 기반 합치기)
	static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);

		if (rootA != rootB) {
			if (rank[rootA] > rank[rootB]) {
				parent[rootB] = rootA;
			} else if (rank[rootA] < rank[rootB]) {
				parent[rootA] = rootB;
			} else {
				parent[rootB] = rootA;
				rank[rootA]++;
			}
			return true;
		}
		return false;
	}
}
