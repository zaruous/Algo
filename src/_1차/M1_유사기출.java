package _1차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/********************************
 *	프로젝트 : Algo
 *	패키지   : 
 *	작성일   : 2022. 11. 28.
 *	작성자   : KYJ (zaruous@naver.com)
 *******************************/

/**
 * @author KYJ (zaruous@naver.com)
 *
 */
public class M1_유사기출 {

	static int[] arr, arr2;
	static int M;
	static int N;

	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int T = Integer.parseInt(br.readLine());

			for (int tcase = 0; tcase < T; tcase++) {
				// matchVal = 0;
				String[] nmk = br.readLine().split(" ");
				N = Integer.parseInt(nmk[0]);
				M = Integer.parseInt(nmk[1]); // 눈금
				int k = Integer.parseInt(nmk[2]); // 가리키는값

				StringTokenizer st = new StringTokenizer(br.readLine());
				arr = new int[N];
				arr2 = new int[k + 1];
				// visite = new boolean[N];
				for (int i = 0; i < N; i++) {

					// 큰 수를 작은값으로 전처리
					int v = Integer.parseInt(st.nextToken());
					if (v >= M)
						v = v % M;
					else if (v < 0)
						v = (M + (v % M));
					arr[i] = v;
					arr2[v] = 1;
				}

				int recursive = recursive(0, 0, k);

				System.out.println("#" + (tcase + 1) + " " + recursive);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static int recursive(int currentPos, int step, int goals) {
		if (step == 4) {
			if (currentPos == goals)
				return 1;
			else
				return 0;
		}

		int ret = 0;
		for (int i = 0; i < N; i++) {

			// 다음에 이동되는값 = 현재 값 + 다음에 이동할값.
			int nextPos = currentPos + arr[i];

			if (nextPos >= M)
				nextPos = nextPos % M;

			ret += recursive(nextPos, step + 1, goals);
		}
		return ret;

	}

}