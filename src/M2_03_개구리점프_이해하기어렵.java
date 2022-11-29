
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
public class M2_03_개구리점프_이해하기어렵 {

	static class Node implements Comparable<Node> {
		int x1, x2, y;

		public Node(int x1, int x2, int y) {
			super();
			this.x1 = x1;
			this.x2 = x2;
			this.y = y;
		}

		@Override
		public int compareTo(M2_03_개구리점프_이해하기어렵.Node o) {
			return Integer.compare(this.x1, o.x1);
		}
	};

	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer sc = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(sc.nextToken());
			int Q = Integer.parseInt(sc.nextToken());
			Node[] nodes = new Node[N];
			for (int i = 0; i < N; i++) {
				sc = new StringTokenizer(br.readLine());
				nodes[i] = new Node(Integer.parseInt(sc.nextToken()), Integer.parseInt(sc.nextToken()), Integer.parseInt(sc.nextToken()));
			}
			Arrays.sort(nodes);
			for (int i = 0; i < Q; i++) {

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