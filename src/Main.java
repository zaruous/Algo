
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/********************************
 *	프로젝트 : Algo
 *	패키지   : 
 *	작성일   : 2022. 11. 28.
 *	작성자   : KYJ (kyjun.kim@miracom.co.kr)
 *******************************/

/**
 * @author KYJ (kyjun.kim@miracom.co.kr)
 *
 */
public class Main {

	static class Node implements Comparable<Node> {
		int x1, x2, y, n;

		public Node(int n, int x1, int x2, int y) {
			super();
			this.n = n;
			this.x1 = x1;
			this.x2 = x2;
			this.y = y;
		}

		@Override
		public int compareTo(Node o) {

			if (this.x2 == o.x2) {
				return Integer.compare(this.x1, o.x1);
			}

			return Integer.compare(this.x2, o.x2);
		}
	};

	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer sc = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(sc.nextToken());
			int Q = Integer.parseInt(sc.nextToken());
			Node[] nodes = new Node[N];

			HashMap<Integer, Main.Node> cache = new HashMap<Integer, Node>();
			for (int i = 0; i < N; i++) {
				sc = new StringTokenizer(br.readLine());
				nodes[i] = new Node((i + 1), Integer.parseInt(sc.nextToken()), Integer.parseInt(sc.nextToken()),
						Integer.parseInt(sc.nextToken()));
				cache.put((i + 1), nodes[i]);
			}
			Arrays.sort(nodes);
			for (int i = 0; i < Q; i++) {
				sc = new StringTokenizer(br.readLine());
				int f = Integer.parseInt(sc.nextToken());
				int t = Integer.parseInt(sc.nextToken());

				Main.Node fnode = cache.get(f);
				Main.Node tnode = cache.get(t);

				if (fnode.x1 <= tnode.x1 && fnode.x2 >= tnode.x1 && fnode.x2 <= tnode.x2) {

				}
			}

			int p = 0;
			int cnt = 0;
			for (int i = 0; i < nodes.length; i++) {

				if (p <= nodes[i].s) {
					p = nodes[i].e;
					cnt++;
				}

			}
			System.out.println(cnt);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void print(M2_03_개구리점프_이해하기어렵.Node[] nodes) {
		for (int i = 0, max = nodes.length; i < max; i++) {
			System.out.printf("%d %d (%d)\n", nodes[i].s, nodes[i].e, nodes[i].width);
		}
	}

}