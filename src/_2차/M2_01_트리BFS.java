package _2차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 
 * 
 * @author KYJ (callakrsos@naver.com)
 *
 */
public class M2_01_트리BFS {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int T;
	private static StringTokenizer sc;
	private static int N;
	private static int W;
	private static int[] arr;
	private static int M;
	private static int R;
	private static int K;
	private static int[][] board;

	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());

		sc = new StringTokenizer(br.readLine());
		arr = new int[T];
		for (int i = 0; i < T; i++) {
			arr[i] = Integer.parseInt(sc.nextToken());
		}

		board = new int[T][T];

		for (int i = 0; i < T; i++) {
			sc = new StringTokenizer(br.readLine());
			for (int j = 0; j < T; j++) {
				board[i][j] = Integer.parseInt(sc.nextToken());
			}
		}

		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(0);
		System.out.print(arr[0] + " ");
		while (!q.isEmpty()) {

			int x = q.poll();
			for (int i = 0; i < T; i++) {
				if (board[x][i] != 0) {
					System.out.print(arr[i] + " ");
					q.add(i);
				}
			}
		}
	}

}