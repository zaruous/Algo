

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/********************************
 *	프로젝트 : Algo
 *	패키지   : 
 *	작성일   : 2022. 11. 28.
 *	작성자   : KYJ (kyjun.kim@miracom.co.kr)
 *******************************/

/**
 * 
 * 연쇄 폭탄
 * 
 * @author KYJ (kyjun.kim@miracom.co.kr)
 *
 */
public class M2_05 {

	static int[] xx = new int[] { 1, -1, 0, 0 };
	static int[] yy = new int[] { 0, 0, -1, 1 };

	static class Node implements Comparable<Node> {
		int x, y, val;

		public Node(int x, int y, int val) {
			super();
			this.x = x;
			this.y = y;
			this.val = val;
		}

		@Override
		public int compareTo(M2_05.Node o) {
			return Integer.compare(this.val, o.val);
		}

	}

	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			int N = Integer.parseInt(br.readLine());

			Map<Integer, Node> m = new HashMap<>();
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer sc = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(sc.nextToken());
					m.put(arr[i][j], new Node(i, j, arr[i][j]));
				}
			}

			int remains = N * N;
			int sec = 0;
			for (sec = 1; sec < 1000; sec++) {
				M2_05.Node node = m.get(sec);
				if (node == null)
					continue;
				if (arr[node.x][node.y] != -1) {

					if (arr[node.x][node.y] != -1) {
						arr[node.x][node.y] = -1;
						remains--;
					}

					for (int p = 0; p < 4; p++) {
						int x = node.x + xx[p];
						int y = node.y + yy[p];
						if (x < 0 || x > N - 1)
							continue;
						if (y < 0 || y > N - 1)
							continue;
						if (arr[x][y] != -1)
							remains--;
						arr[x][y] = -1;
					}
				}
				if (remains <= 0) {
					break;
				}
			}
			System.out.println(sec + "초");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}