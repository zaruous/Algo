package _1차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class M3_08 {
	// 항상 PS에서 꼭 넣고 시작하는 코드
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st; // <- 특정 기준을 통해 문자열을 자르는 역할

	static int N, C;
	static int[][] arr;
	static boolean visite[];

	public static void main(String[] args) throws IOException {

		// StringTokenizer sc = new StringTokenizer(br.readLine());
		C = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());

		arr = new int[C + 1][C + 1];
		visite = new boolean[C + 1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			arr[s][e] = 1;
			arr[e][s] = 1;
		}
		visite[1] = true;
		recursive(1);
		System.out.println(vc);
	}

	static int vc = 0;

	private static void recursive(int now) {

		for (int to = 1; to <= C; to++) {

			if (arr[now][to] == 0)
				continue;
			if (visite[to])
				continue;

			visite[to] = true;
			vc++;
//			System.out.println(now + " " + to);
			recursive(to);
		}
	}
}