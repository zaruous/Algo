import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 다시 풀어봐야함. 생각의 틀. DP같은 문제
 * 
 * @author KYJ (callakrsos@naver.com)
 *
 */
public class M1_04_구간의합_접근이어렵 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int T;
	private static StringTokenizer sc;
	private static int N;
	private static int W;
	private static int[] arr;
	private static int M;
	private static int R;

	public static void main(String[] args) throws IOException {
		sc = new StringTokenizer(br.readLine());
		N = Integer.parseInt(sc.nextToken());
		M = Integer.parseInt(sc.nextToken());
		sc = new StringTokenizer(br.readLine());

		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(sc.nextToken());
		}

		int ret = 0;

		int b = 0;
		int sum = 0;
		for (int a = 0; a < N; a++) {

			while (b < N && (sum + arr[b]) < M) {
				sum += arr[b];
				b++;
			}

			if (b < N && (sum + arr[b]) == M) {
				ret++;
			}

			sum -= arr[a];

		}
		System.out.println(ret);

	}
}