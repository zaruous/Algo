package _2차;
1
5 4 4
1 2 3
3 4 5
4 5 2
1 3 2
5 3
1 5
2 5
4 2import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 슬라이딩 윈도우
 * 
 * @author KYJ (callakrsos@naver.com)
 *
 */
public class Main2 {
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
		int sum = 0;
		for (int i = 0; i < M; i++) {
			sum += arr[i];
		}
		if (sum == M)
			ret++;

		int s = 0, e = M;
		for (int i = 0; i < N; i++) {
			if (e >= N)
				break;
			
			int o = arr[s];
			int n = arr[e];
			
			
			sum -= o;
			sum += n;
			System.out.println(s+1 + " " + (e) + " : " + sum);
			if(sum == M) ret++;
			
			s++; e++;
			
		}
		System.out.println(ret);

	}
}
