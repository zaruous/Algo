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
public class Main3 {
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

	/**
	 * @작성자 : KYJ (callakrsos@naver.com)
	 * @작성일 : 2022. 12. 12.
	 * @param srch
	 * @param s
	 * @param e
	 * @return
	 */
	private static int binarySearch(char srch, int s, int e) {

		if (e < s) {
			if (arr[s] == srch)
				return 1;
			return 0;
		}
//		 if(e <= N) return 0; 

		int c = 0;
		int mid = (s + e) / 2;
		if (arr[mid] == srch)
			c = (mid - s) - 1;

		int a = binarySearch(srch, s, mid - 1);
		int b = binarySearch(srch, mid + 1, e);
		return a + b + c;
	}
}