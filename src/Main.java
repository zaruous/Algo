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
public class Main {

	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int Q = Integer.parseInt(br.readLine());
			int[] arr = new int[1501];

			int idx = 1;
			for (int i = 1, max = 1_000_000; i < max; i++) {

				if ((i == 1) || ((i % 2 == 0) || (i % 3 == 0) || (i % 5 == 0))) {
					arr[idx++] = i;
				}

				if (idx >= 1501)
					break;
			}
			print(arr);

			// StringTokenizer sc = new StringTokenizer(br.readLine());
			// for (int i = 0; i < Q; i++) {
			// int qu = Integer.parseInt(sc.nextToken());
			// System.out.print(arr[qu] + " ");
			// }
			// System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.print (arr[i] + " ");
	}

}
