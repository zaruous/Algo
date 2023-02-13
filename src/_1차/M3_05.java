package _1차;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/********************************
 *	프로젝트 : Algo
 *	패키지   : 
 *	작성일   : 2022. 11. 28.
 *	작성자   : KYJ (callakrsos@naver.com)
 *******************************/

/**
 * N-Queen 문제
 * 
 * @author KYJ (callakrsos@naver.com)
 *
 */
public class M3_05 {

	// 항상 PS에서 꼭 넣고 시작하는 코드
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st; // <- 특정 기준을 통해 문자열을 자르는 역할
	static int n, cnt = 0;
	static int[] temp;

	static boolean[] check_sum, check_diff, check_x;

	static void solution(int y) {
		if (y >= n) {// 끝까지 순회한 경우...
			cnt++;
			return;
		}
		// ------------
		for (int x = 0; x < n; x++) {
			if (check_x[x] || check_diff[n + x - y] || check_sum[x + y])
				continue;
			check_diff[n + x - y] = true;
			check_sum[x + y] = true;
			check_x[x] = true;

			solution(y + 1);

			check_diff[n + x - y] = false;
			check_sum[x + y] = false;
			check_x[x] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		// scanf("%d", &n);
		n = Integer.parseInt(br.readLine());
		check_sum = new boolean[300];
		check_diff = new boolean[300];
		check_x = new boolean[300];
		solution(0);
		System.out.println(cnt);
		// printf("%d\n", cnt);

		// return 0;
	}

}