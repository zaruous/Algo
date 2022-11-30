
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
public class M3_04_못품 {

	// private static int[][] arr;
	private static int[] visite;
	private static int N;

	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			N = Integer.parseInt(br.readLine());
			// arr = new int[N][N];
			visite = new int[N];

			// for (int c = 0; c < N; c++)
			recursive(0);

			System.out.println(aws);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	static int aws = 0;

	private static void recursive(int cnt) {

		if (cnt >= N) {
			aws++;
			return;
		}

		for (int i = 0; i < N; i++) {

			if (visite[i] == 1)
				continue;
			visite[i] = 1;
			recursive(cnt + 1);
			visite[i] = 0;
		}

	}

}