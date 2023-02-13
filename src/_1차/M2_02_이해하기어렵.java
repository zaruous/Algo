package _1차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/********************************
 *	프로젝트 : Algo
 *	패키지   : 
 *	작성일   : 2022. 11. 28.
 *	작성자   : KYJ (callakrsos@naver.com)
 *******************************/

/**
 * @author KYJ (callakrsos@naver.com)
 *
 */
public class M2_02_이해하기어렵 {

	static class Node implements Comparable<Node> {
		int s, e, width;

		public Node(int s, int e, int width) {
			super();
			this.s = s;
			this.e = e;
			this.width = width;
		}

		@Override
		public int compareTo(M2_02_이해하기어렵.Node o) {
			if (this.e == o.e)
				return Integer.compare(this.s, o.s);

			return Integer.compare(this.e, o.e);

			// return -1 * Integer.compare(this.width, o.width);
		}
	};

	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int N = Integer.parseInt(br.readLine());

			Node[] nodes = new Node[N];
			for (int i = 0; i < N; i++) {
				StringTokenizer sc = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(sc.nextToken());
				int e = Integer.parseInt(sc.nextToken());
				int width = e - s;
				nodes[i] = new Node(s, e, width);
			}

			Arrays.sort(nodes);
			// print(nodes);
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

}