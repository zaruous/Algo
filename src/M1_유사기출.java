import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/********************************
 *	프로젝트 : Algo
 *	패키지   : 
 *	작성일   : 2022. 11. 28.
 *	작성자   : KYJ (kyjun.kim@miracom.co.kr)
 *******************************/

/**
 * @author KYJ (kyjun.kim@miracom.co.kr)
 *
 */
public class M1_유사기출 {

	static int[] arr;
	static int M;

	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int T = Integer.parseInt(br.readLine());

			for (int tcase = 0; tcase < T; tcase++) {
				// matchVal = 0;
				String[] nmk = br.readLine().split(" ");
				int n = Integer.parseInt(nmk[0]);
				M = Integer.parseInt(nmk[1]); // 눈금
				int k = Integer.parseInt(nmk[2]); // 가리키는값

				String[] dials = br.readLine().split(" ");
				arr = new int[dials.length];
				for (int i = 0; i < dials.length; i++) {
					arr[i] = Integer.parseInt(dials[i]);
				}
				int recursive = recursive(0, 0, k, "");

				System.out.println(recursive);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static int recursive(int currentPos, int step, int goals, String append) {

		if (step == 4) {
			if (currentPos == goals) {
				System.out.println(append);
				return 1;
			}
			return 0;
		}

		int ret = 0;
		for (int i = 0; i < arr.length; i++) {
			// 다음에 이동되는값 = 현재 값 + 다음에 이동할값.
			int nextPos = currentPos + arr[i];

			if (nextPos >= (M))
				nextPos = nextPos % M;
			else if (nextPos < 0)
				nextPos = M + nextPos;

			ret += recursive(nextPos, step + 1, goals, append + " " + arr[i]);
		}
		return ret;

	}

}