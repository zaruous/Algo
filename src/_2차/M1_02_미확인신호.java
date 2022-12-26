package _2차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 슬라이딩 윈도우
 * 
 * @author KYJ (callakrsos@naver.com)
 *
 */
public class M1_02_미확인신호 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int T;
	private static StringTokenizer sc;
	private static int N;
	private static int W;
	private static int[] arr;
	private static int M;

	public static void main(String[] args) throws IOException {

		T = Integer.parseInt(br.readLine());

		for (int tcase = 1; tcase <= T; tcase++) {
			M = Integer.parseInt(br.readLine());
			char[] arr = br.readLine().toCharArray();

			int[] check = new int[1000];
			boolean dupleExists = false;
			for (int i = 0; i < M; i++) {
				if (check[arr[i]] == 1) {
					dupleExists = true;
					break;
				} else
					check[arr[i]] = 1;

			}

			if (dupleExists) {
				System.out.println("#" + tcase + " FAIL");
				continue;
			}

			int s = 1;
			int e = s + M - 1;

			for (int i = 1; i < arr.length; i++) {
				if (e >= arr.length) {
					break;
				}
				check[arr[s - 1]] = 0;
				if (check[arr[e]] == 1) {
					dupleExists = true;
					break;
				} else
					check[arr[e]] = 1;
				s++;
				e++;
			}
			if (dupleExists) {
				System.out.println("#" + tcase + " FAIL");
			} else
				System.out.println("#" + tcase + " PASS");
		}

	}
}
