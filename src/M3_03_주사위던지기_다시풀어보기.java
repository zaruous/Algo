import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
public class M3_03_주사위던지기_다시풀어보기 {

	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer sc = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(sc.nextToken());
			int M = Integer.parseInt(sc.nextToken());
			if (M == 1)
				recursive("", 0, N);
			if (M == 2) {
				int[] arr = new int[N];
//				arr[0] = 1;
				recursive2(arr, 0, N);
			}
			if (M == 3)
				recursive3("", 0, N, new boolean[7]);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void recursive2(int[] arr, int depth, int limit) {
		if (depth == limit) {

			for (int i = 0, max = arr.length; i < max; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();

			return;
		}

		for (int i = 1; i <= 6; i++) {

			if (depth != 0 && arr[depth - 1] > i)
				continue;
			arr[depth] = i;
			recursive2(arr, depth + 1, limit);
		}
	}

	private static void recursive3(String str, int depth, int limit, boolean[] marker) {
		if (depth == limit) {
			System.out.println(str);
			return;
		}

		for (int i = 1; i <= 6; i++) {
			if (!marker[i]) {
				marker[i] = true;
				recursive3(str + i + " ", depth + 1, limit, marker);
				marker[i] = false;
			}
		}
	}

	private static void recursive(String str, int depth, int limit) {
		if (depth == limit) {
			System.out.println(str);
			return;
		}

		for (int i = 1; i <= 6; i++) {
			recursive(str + i + " ", depth + 1, limit);
		}

	}

}