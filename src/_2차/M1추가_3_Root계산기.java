package _2차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 다시 풀어봐야함. 생각의 틀
 * 
 * @author KYJ (zaruous@naver.com)
 *
 */
public class M1추가_3_Root계산기 {
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

		long ret = binarySearch(0, 10_000_000);
		System.out.println(ret);

	}

	private static long binarySearch(long s, long e) {

		if (s > e)
			return e;

		long mid = (s + e) / 2;
		long doubl = mid * mid;
		if (doubl == N) {
			return mid;
		}

		if (doubl > N)
			return binarySearch(s, mid - 1);
		else
			return binarySearch(mid + 1, e);
	}

}