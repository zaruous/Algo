import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class M4_01 {
	// 항상 PS에서 꼭 넣고 시작하는 코드
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st; // <- 특정 기준을 통해 문자열을 자르는 역할

	static int N, M;
	private static int[][] arr;

	public static void main(String[] args) throws IOException {

		N = Integer.parseInt(br.readLine());

		arr = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int a = Integer.parseInt(st.nextToken());
				arr[i][j] = a;
			}
		}

		M4_01.UnionFind unionFind = new UnionFind(N);
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				if (arr[i][j] == 0)
					continue;
				if (i == j)
					continue;

				if (!unionFind.union(i, j)) {
					System.out.println("WARNING");
					return;
				}
			}
		}

		System.out.println("STABLE");

		// 프린트

	}

	static class UnionFind {
		int size;
		int[] inbox;

		public UnionFind(int size) {
			super();
			this.size = size;
			inbox = new int[size + 1];
			for (int i = 1; i <= size; i++)
				inbox[i] = i;
		}

		public boolean union(int a, int b) {
			int aa = find(a);
			int bb = find(b);

			if (aa == bb)
				return false;

			inbox[aa] = bb;
			return true;
		}

		public int find(int n) {
			if (inbox[n] == n)
				return n;
			return inbox[n] = find(inbox[n]);
		}
	}

}