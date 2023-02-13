package unionfind;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class M4_3_춘추정국시대 {
	// 항상 PS에서 꼭 넣고 시작하는 코드
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st; // <- 특정 기준을 통해 문자열을 자르는 역할

	static int N, M;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		int[] arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		UnionFind unionFind = new UnionFind(N, arr);
		int T = Integer.parseInt(br.readLine());
		int war = 0;
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();

			int a = st.nextToken().charAt(0) - 64;
			int b = st.nextToken().charAt(0) - 64;

			switch (command) {
			case "alliance":
				unionFind.union(a, b);
				break;
			case "war":
				war = unionFind.war(a, b);

				break;
			}
		}
		System.out.println(war);

		// System.out.println();
	}

	static class UnionFind {

		int[] arr;
		int[] populate;

		public UnionFind(int size, int[] populate) {
			this.arr = new int[size + 1];

			for (int i = 1; i <= size; i++)
				arr[i] = i;

			this.populate = populate;
		}

		public int war(int a, int b) {
			int aa = find(a);
			int bb = find(b);

			if (populate[aa] == populate[bb]) {
				for (int i = 1; i < arr.length; i++) {
					if (arr[i] == aa)
						arr[i] = 0;
				}
				for (int i = 1; i < arr.length; i++) {
					if (arr[i] == bb)
						arr[i] = 0;
				}
			} else if (populate[aa] >= populate[bb]) {
				for (int i = 1; i < arr.length; i++) {
					if (arr[i] == bb)
						arr[i] = 0;
				}
			} else if (populate[aa] <= populate[bb]) {
				// int r = arr[aa];
				for (int i = 1; i < arr.length; i++) {
					if (arr[i] == aa)
						arr[i] = 0;
				}
			}
			int count = 0;
			for (int i = 1; i < arr.length; i++) {
				if (arr[i] != 0)
					count++;
			}
			return count;
		}

		public void union(int a, int b) {
			int aa = find(a);
			int bb = find(b);

			if (aa != bb) {
				arr[aa] = bb;
				populate[bb] += populate[aa];
				populate[aa] = 0;
			}
		}

		public int find(int a) {
			if (arr[a] == a)
				return a;
			return arr[a] = find(arr[a]);
		}

	}

}