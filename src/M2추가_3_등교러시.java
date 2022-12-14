import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 * 
 * @author KYJ (callakrsos@naver.com)
 *
 */
public class M2추가_3_등교러시 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer sc;
	private static int T, N, W, M, R, K, P;
	// private static int[] arr;

	private static int[][] visited;
	private static int[] cnt;
	static char[][] arr;
	private static int Q;
	private static int[] jw;

	static class Node {
		public Node(int x, int y, int value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}

		int x, y, value;

	}

	public static void main(String[] args) throws IOException {
		sc = new StringTokenizer(br.readLine());
		N = Integer.parseInt(sc.nextToken());
		M = Integer.parseInt(sc.nextToken());

		arr = new char[N][M];
		for (int r = 0; r < N; r++) {
			arr[r] = br.readLine().toCharArray();
		}
		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			sc = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(sc.nextToken());
			int y = Integer.parseInt(sc.nextToken());
			arr[x][y] = 'p';
		}

		// 학교 위치

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == '@') {
					bfs(new Node(i, j, 0));
					return;
				}
			}
		}

	}

	static int[] posx = { 1, -1, 0, 0 };
	static int[] posy = { 0, 0, -1, 1 };

	private static void bfs(Node n) {
		int[][] size = new int[N][M];
		visited = new int[N][M];
		LinkedList<Node> q = new LinkedList<>();
		q.add(n);
		
		long sum = 0;
		while (!q.isEmpty()) {
			Node poll = q.poll();
			
			if (visited[poll.x][poll.y] == 1)
				continue;
			
			visited[poll.x][poll.y] = 1;
			
			if (arr[poll.x][poll.y] == 'p')
				sum += poll.value;

			for (int i = 0; i < 4; i++) {
				int nx = poll.x + posx[i];
				int ny = poll.y + posy[i];
				
				if( nx < 0 || ny < 0 || N-1 < nx || M-1 < ny ) continue;
				if (arr[nx][ny] == '#')
					continue;

				size[nx][ny] = size[poll.x][poll.y] + 1;
				q.add(new Node(nx, ny, size[nx][ny]));
			}
		}
		System.out.println(sum);
	}

}
