import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 다시 풀어봐야함. 생각의 틀
 * 
 * @author KYJ (callakrsos@naver.com)
 *
 */
public class M1_06_BinarySearch {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int T;
	private static StringTokenizer sc;
	private static int N;
	private static int W;
	private static int[] srch, arr;
	private static int M;
	private static int R;
	private static int K;

	public static void main(String[] args) throws IOException {

		N = Integer.parseInt(br.readLine());
		sc = new StringTokenizer(br.readLine());

		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(sc.nextToken());
		}

		Arrays.sort(arr);

		K = Integer.parseInt(br.readLine());
		srch = new int[K];
		sc = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {

			srch[i] = Integer.parseInt(sc.nextToken());
			boolean ret = binarySearch(srch[i], 0, N);
			System.out.print((ret ? "O" : "X"));
		}

	}

	/**
	 * @작성자 : KYJ (callakrsos@naver.com)
	 * @작성일 : 2022. 12. 12.
	 * @param srch
	 * @param s
	 * @param e
	 * @return
	 */
	private static boolean binarySearch(int srch, int s, int e) {

		if (e < s) {
			if (arr[s] == srch)
				return true;
			return false;
		}

		int mid = (s + e) / 2;
		if (arr[mid] == srch)
			return true;
		if (srch < arr[mid]) {
			return binarySearch(srch, s, mid - 1);
		} else {
			return binarySearch(srch, mid + 1, e);
		}
	}
}