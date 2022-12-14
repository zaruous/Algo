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
public class Main4 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int T;
	private static StringTokenizer sc;
	private static int N;
	private static int W;
	private static int[] arr;
	private static int M;
	private static int R;
	private static int K;

	public static void main(String[] args) throws IOException {

		sc = new StringTokenizer(br.readLine());

		N = Integer.parseInt(sc.nextToken());
		T = Integer.parseInt(sc.nextToken());

		sc = new StringTokenizer(br.readLine());

		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(sc.nextToken());
		}

		int teamMaxMin = Integer.MAX_VALUE;
		int min = Integer.MAX_VALUE;
		int sum = 0;

		for (int i = 0; i < T; i++) {
			sum += arr[i];
		}
		min = sum;

		int div = N / T + (N % T == 0 ? 0 : 1);
		int s = 0, e = div;

		int mins = 0, mine = 0;
		for (int i = 0; i < N; i++) {

			int a = arr[s % N];
			int b = arr[e % N];

			sum -= a;
			sum += b;

			if (Integer.min(min, sum) == sum) {
				mins = s % N;
				mine = e % N;
				min = Integer.min(min, sum);
			}

			// teamMaxMin = Integer.min(max, teamMaxMin);
			System.out.println(min + " a  : " + a + " b : " + b);

			s++;
			e++;
		}
		System.out.println(aa(mins, mine));

	}

	static int aa(int ss, int ee) {
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < T; i++) {
			sum += arr[i];
		}
		max = sum;

		int div = N / T + (N % T == 0 ? 0 : 1);
		int s = 0, e = div;

		for (int i = 0; i < N; i++) {

			if ((e <= ss || s  <= ee )) {
				s++;
				e++;
				continue;
			}

			int a = arr[s % N];
			int b = arr[e % N];

			sum -= a;
			sum += b;

			// if(Integer.max(max, sum) == sum)
			// {
			//
			// }
			max = Integer.max(max, sum);
			// teamMaxMin = Integer.min(max, teamMaxMin);
			System.out.println("v " + max + " a  : " + a + " b : " + b);

			s++;
			e++;

		}
		System.out.println();
		return max;
	}

}