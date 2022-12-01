import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class M4_02_인디언합창단_다시풀어보면좋음_UnionFind {
	// 항상 PS에서 꼭 넣고 시작하는 코드
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st; // <- 특정 기준을 통해 문자열을 자르는 역할

	static int N, M;

	public static void main(String[] args) throws IOException {

		N = Integer.parseInt(br.readLine());

		M4_02_인디언합창단_다시풀어보면좋음_UnionFind.UnionFind unionFind = new UnionFind(26);

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			char a = st.nextToken().charAt(0);
			char b = st.nextToken().charAt(0);
			unionFind.union(a, b);
		}

		int teamCount = 0;
		int soloCount = 0;
		for (int i = 1; i <= 26; i++) {
			int findCount = unionFind.findCount(i);
			if (findCount == 1)
				soloCount++;
			else if (findCount == 0)
				continue;
			else
				teamCount++;

		}

		System.out.println(teamCount);
		System.out.println(soloCount);

	}

	static class UnionFind {
		int size;
		int[] inbox;
		int[] inbox2;

		public UnionFind(int size) {
			super();
			this.size = size;
			inbox = new int[size + 1];
			inbox2 = new int[size + 1];

			for (int i = 1; i <= size; i++)
				inbox[i] = i;
			for (int i = 1; i <= size; i++)
				inbox2[i] = 1;
		}

		public int findCount(int i) {
			return inbox2[i];
		}

		public int union(char a, char b) {
			int aa = find(a - 64);
			int bb = find(b - 64);

			/* 핵심. */
			if (aa != bb) {
				inbox[aa] = bb;
				inbox2[bb] += inbox2[aa];
				inbox2[aa] = 0;
			}
			return inbox2[bb];
		}

		public int find(int n) {
			if (inbox[n] == n)
				return n;
			return inbox[n] = find(inbox[n]);
		}
	}

}