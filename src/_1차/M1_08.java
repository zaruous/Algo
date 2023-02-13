package _1차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/********************************
 *	프로젝트 : Algo
 *	패키지   : 
 *	작성일   : 2022. 11. 28.
 *	작성자   : KYJ (callakrsos@naver.com)
 *******************************/

/**
 * @author KYJ (callakrsos@naver.com)
 *
 */
public class M1_08 {

	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int T = Integer.parseInt(br.readLine());

			for (int tcase = 0; tcase < T; tcase++) {
				int N = Integer.parseInt(br.readLine());

				int[] dir = new int[N + 1];
				StringTokenizer sc = new StringTokenizer(br.readLine());
				StringTokenizer sc2 = new StringTokenizer(br.readLine());
				for (int j = 1; j < N + 1; j++) {
					int h = Integer.parseInt(sc.nextToken());
					int n = Integer.parseInt(sc2.nextToken());
					dir[n] = h;
				}

				// 정렬결과가 number와 맞이않으면 에러
				int flag = 0;
				for (int i = 1; i < N; i++) {
					if ((dir[i] < dir[i + 1])) {
						flag = 1;
					}
				}

				if (flag == 1)
					System.out.println("NO");
				else
					System.out.println("YES");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
