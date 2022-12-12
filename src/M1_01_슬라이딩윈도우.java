import java.io.*;
import java.util.*;

/**
 * 슬라이딩 윈도우
 * 
 * @author KYJ (callakrsos@naver.com)
 *
 */
public class M1_01_슬라이딩윈도우 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int T;
	private static StringTokenizer sc;
	private static int N;
	private static int W;
	private static int[] arr;

	public static void main(String[] args) throws IOException {

		T = Integer.parseInt(br.readLine());

		for (int tcase = 1; tcase <= T; tcase++) {
			sc = new StringTokenizer(br.readLine());
			N = Integer.parseInt(sc.nextToken());
			W = Integer.parseInt(sc.nextToken());

			arr = new int[N];
			sc = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(sc.nextToken());
			}

			int size = W;
			int maxsum = Integer.MIN_VALUE;
			int sum = 0;
			int s = 0;
			int e = size - 1;
			int as = 0;
			int ae = 0;

			for (int a = 0; a < size; a++) {
				sum += arr[a];
				as = s;
				ae = size - 1;
			}
			maxsum = sum;

			s++; // 1
			e++; // 5

			for (int a = 1; a < N; a++) {
				if (e  >= N)
					break;

				sum += arr[e];
				sum -= arr[s - 1];

				if (maxsum < sum) {
					maxsum = sum;
					as = s;
					ae = e;
				}
				// System.out.println(s + " " + e + " = " + sum);
				s++;
				e++;

			}

			System.out.println("#" + tcase + " " + as + " " + ae + " " + maxsum);
		}

	}
}
