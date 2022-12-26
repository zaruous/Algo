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
public class M1_03_예식상서빙 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int T;
	private static StringTokenizer sc;
	private static int N;
	private static int W;
	private static int[] arr;
	private static int M;
	private static int R;

	public static void main(String[] args) throws IOException {

		T = Integer.parseInt(br.readLine());

		for (int tcase = 1; tcase <= T; tcase++) {
			sc = new StringTokenizer(br.readLine());
			N = Integer.parseInt(sc.nextToken());
			R = Integer.parseInt(sc.nextToken()) % N;

			int[] arr = new int[N];
			// for (int i = 0; i < N; i++) {
			sc = new StringTokenizer(br.readLine());
			for (int k = 0; k < N; k++)
				arr[k] = Integer.parseInt(sc.nextToken());
			// }

			int[] chk = new int[1_000_000];

			chk[arr[0]] += 1;
			// System.out.println(arr[0]);
			for (int i = 1; i <= R; i++) {
				int j = arr[i];
				chk[j] += 1;
				// System.out.println(j);
			}

			for (int i = 0; i < R; i++) {
				int j = arr[N - i - 1];
				chk[j] += 1;
				// System.out.println(j);
			}

			int s = (N - R), e = R;
			s++;
			e++;
			boolean err = false;
			for (int i = 0; i < N; i++) {
				// if (e >= N)
				// break;

				int o = arr[(s - 1) % N];
				int n = arr[e % N];

				// System.out.println("o : " + o + " " + " n " + n);
				// if (chk[o] > 0)

				// System.out.println("-" + o + " +" + n);
				chk[n] += 1;
				chk[o] -= 1;
				
				if (chk[n] >= 3) {
					err = true;
					break;
				}
				

				s++;
				e++;
			}

			if (err)
				System.out.println("#" + tcase + " NO");
			else
				System.out.println("#" + tcase + " YES");
		}

	}
}
