
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/********************************
 *	프로젝트 : Algo
 *	패키지   :
 *	작성일   : 2022. 11. 28.
 *	작성자   : KYJ (kyjun.kim@miracom.co.kr)
 *******************************/

/**
 *
 * 폭탄설치로봇
 *
 * @author KYJ (kyjun.kim@miracom.co.kr)
 *
 */
public class M2_추가1 {

	static int[] xx = new int[] { 1, -1, 0, 0 };
	static int[] yy = new int[] { 0, 0, -1, 1 };

	static class Node implements Comparable<Node> {
		int n, x, y;

		public Node(int n, int x, int y) {
			this.n = n;
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(M2_추가1.Node o) {
			return Integer.compare(this.n, o.n);
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Node) {
				Node node = (Node) obj;
				return this.n == node.n;
			}
			return false;
		}

	}

	public static void main(String[] aa) {

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			StringTokenizer sc = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(sc.nextToken());
			int M = Integer.parseInt(sc.nextToken());

			int SIZE = 1000;

			/*
			 * 0 : 폭탄이 설치된적이 없음 1 : 폭탄이 설치되어 폭파된 적 있음. 2 : 유효 폭탄 3 : 무효 폭탄
			 */
			int[][] arr = new int[SIZE][SIZE];
			int[][] boomNumber = new int[SIZE][SIZE];

			PriorityQueue<Node> queue = new PriorityQueue<>();

			for (int i = 0, max = N + M; i < max; i++) {
				String t = br.readLine();
				String[] args = t.split(" ");
				if (args.length == 1) {

					Node current = null;
					int n = 0;
					while ((current = queue.poll()) != null) {
						n = current.n;
						if (arr[current.x][current.y] == 1 || arr[current.x][current.y] == 3 || arr[current.x][current.y] == 0) {
							continue;
						}

						// 폭파
						for (int j = 0; j < 4; j++) {
							int px = current.x + xx[j];
							int py = current.y + yy[j];
							if (px < 0 || py < 0 || px >= SIZE || py >= SIZE)
								continue;

							if (arr[px][py] == 0) {
								arr[px][py] = 1;
							} else if (arr[px][py] == 2) {
								arr[px][py] = 3;
							}
						}
						arr[current.x][current.y] = 1;
						boomNumber[current.x][current.y] = 0;
						System.out.println(n);
						break;
					}
					if (current == null) {
						System.out.println("-1");
						continue;
					}

					// boom
				} else {
					int n = Integer.parseInt(args[0]);
					int r = Integer.parseInt(args[1]);
					int c = Integer.parseInt(args[2]);

					// 이전 폭탄이 있으면 해체.
					/*
					 * if(!queue.isEmpty()){ Node prev= queue.poll();
					 * boomNumber[r][c] = 0; //유효폭탄인경우 if(arr[prev.x] [prev.y]
					 * == 2){ //폭탄이 설치된적없음으로 세팅 arr[prev.x] [prev.y] = 0; }
					 * //무효폭탄인 경우 else if(arr[prev.x] [prev.y] == 3){
					 * arr[prev.x] [prev.y] = 1; } }
					 */
					// 폭탄이 설치된적이 없으면 설치
					if (arr[r][c] == 0) {
						queue.add(new Node(n, r, c));
						arr[r][c] = 2;
					}
					// 이미 폭탄이 있으면 이전 폭탄을 해체하고 다시 설치

					else if (arr[r][c] == 2 || arr[r][c] == 3) {
						int beforeBoomNumber = boomNumber[r][c];
						// 큐에서 제거.
						queue.remove(new Node(beforeBoomNumber, r, c));
						// boom 넘버를 새로 등록
						queue.add(new Node(n, r, c));
					}

					boomNumber[r][c] = n;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}