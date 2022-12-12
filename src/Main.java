import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * 
 * @author KYJ (callakrsos@naver.com)
 *
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int T;
	private static StringTokenizer sc;
	private static int N;
	private static int W;
	private static char[] arr;
	private static int M;
	private static int R;
	private static int K;

	public static void main(String[] args) throws IOException {

		N = Integer.parseInt(br.readLine());
		// sc = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr = br.readLine().toCharArray();
			int cnt = binarySearch('#', 0, arr.length);
			System.out.println((cnt * 100) / arr.length);
		}

	}

	static int sw = Integer.MAX_VALUE;

	/**
	 * @작성자 : KYJ (callakrsos@naver.com)
	 * @작성일 : 2022. 12. 12.
	 * @param srch
	 * @param s
	 * @param e
	 * @return
	 */
	private static int binarySearch(char srch, int s, int e) {

		if (s > e) {
			return e;
		}

		int c = 0;
		int mid = (s + e) / 2;

		if (arr[mid] == srch) {
			sw = Integer.max(sw, mid);
			return binarySearch(srch, mid + 1, e);
		} else {
			sw = Integer.max(sw, mid);
			return binarySearch(srch, mid - 1, e);
		}

	}
}