package _2차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 
 * 
 * @author KYJ (callakrsos@naver.com)
 *
 */
public class M2_추가_5_별헤는밤 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer sc;
	private static int T, N, W, M, R, K, P;
	private static ArrayList<Integer>[] arr;

	private static int[] visited;
	private static int[] cnt;
	// static int[][] arr;
	private static int Q;
	private static int[] jw;
	private static int height;
	private static int width;
	private static int x;
	private static int y;

	public static void main(String[] args) throws IOException {

		sc = new StringTokenizer(br.readLine());
		// 별의 개수
		N = Integer.parseInt(sc.nextToken());
		// 연결의 수
		T = Integer.parseInt(sc.nextToken());

		arr = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}

		for (int i = 0; i < T; i++) {
			sc = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(sc.nextToken());
			int b = Integer.parseInt(sc.nextToken());
			arr[a].add(b);arr[b].add(a);
		}

		LinkedList<Integer> q = new LinkedList<>();
		// canvisite = new int[N+1];
		visited = new int[N + 1];
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			q.add(i);

			if (visited[i] == 1) {
//				cnt++;
			} else {

				while (!q.isEmpty()) {

					Integer now = q.poll();
					if (visited[now] == 1) {
						continue;
					}

					visited[now] = 1;

					ArrayList<Integer> nexts = arr[now];
					for (Integer nt : nexts) {
//						if (visited[nt] == 0) {
							q.add(nt);
//						}
					}
				}
				cnt++;
			}

		}

		System.out.println(cnt);
	}

	static int[] posx = { 1, -1, 0, 0 };
	static int[] posy = { 0, 0, 1, -1 };

}
