
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
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
public class M2_01 {

	static class Node implements Comparable<Node> {
		int n;
		char ch;

		public Node(int n, char ch) {
			super();
			this.n = n;
			this.ch = ch;
		}

		@Override
		public int compareTo(Node a) {
			return Integer.compare(a.n, n);
		}
	};

	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int N = Integer.parseInt(br.readLine());

			StringTokenizer sc = new StringTokenizer(br.readLine());
			StringTokenizer sc2 = new StringTokenizer(br.readLine());
			Node[] nodes = new Node[N];
			for (int i = 0; i < N; i++) {
				int n = Integer.parseInt(sc.nextToken());
				char ch = sc2.nextToken().charAt(0);
				M2_01.Node node = new Node(n, ch);
				nodes[i] = node;
			}

			Arrays.sort(nodes, new Comparator<Node>() {

				@Override
				public int compare(M2_01.Node o1, M2_01.Node o2) {
					return Integer.compare(o1.n, o2.n);
				}
			});
			print(nodes, 1);

			Arrays.sort(nodes, new Comparator<Node>() {

				@Override
				public int compare(M2_01.Node o1, M2_01.Node o2) {
					return -1 * Integer.compare(o1.n, o2.n);
				}
			});
			print(nodes, 1);
			
			Arrays.sort(nodes, new Comparator<Node>() {

				@Override
				public int compare(M2_01.Node o1, M2_01.Node o2) {

					if (o1.n % 2 == 0 && o2.n % 2 == 0) {
						int a = o1.n * o1.ch;
						int b = o2.n * o2.ch;
						return Integer.compare(a, b);
					} else if (o1.n % 2 != 0 && o2.n % 2 == 0) {
						return 1;
					} else if (o1.n % 2 == 0 && o2.n % 2 != 0) {
						return -1;
					}
					int a = o1.n * o1.ch;
					int b = o2.n * o2.ch;
					return Integer.compare(a, b);

				}
			});
			print(nodes, 2);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void print(M2_01.Node[] nodes, int type) {

		for (int i = 0, max = nodes.length; i < max; i++) {
			System.out.print(nodes[i].n + " ");
		}

		if (type == 2) {
			System.out.println();
			for (int i = 0, max = nodes.length; i < max; i++) {
				System.out.print(nodes[i].ch + " ");
			}
		}

		System.out.println();
	}

}