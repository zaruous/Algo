package _1차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
public class M3_06 {

	static int[] arr = new int[1000];

	public static void main(String[] args) {

		arr[0] = 1004;

		arr[1] = 1680;
		arr[2] = 9941;

		arr[3] = 3367;
		arr[4] = 3261;

		arr[5] = 2976;
		arr[6] = 4889;

		arr[7] = 0;
		arr[8] = 0;

		arr[9] = 1231;
		arr[10] = 6461;

		arr[11] = 7329;
		arr[12] = 5518;

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			int q = Integer.parseInt(br.readLine());

			boolean found = false;
			int idx = -1;
			// for (int i = 0; i <= q; i++) {

			for (int j = 0; j < 13; j++) {
				if (arr[j] == q) {
					found = true;
					idx = j;

					// 직속상사
					if (idx == 0) {
						System.out.println("no boss");
					} else {
						int parentIdx = ((idx - 1) / 2);
						if (parentIdx >= 0)
							System.out.println(arr[parentIdx]);
					}

					// 동료
					if (idx == 0) {
						System.out.println("no company");
					} else {
						int c = (j - 1) % 2;
						if (c > 0)
							c = j - 1;
						else
							c = j + 1;
						System.out.println(arr[c]);
					}

					// 부하 사번
					int s = 2 * j + 1;
					if (arr[s] == 0) {
						System.out.println("no junior");
					} else {
						System.out.println(arr[s] + " " + arr[s + 1]);
					}

					return;
				}
			}

			if (!found) {
				System.out.println("no person");
				return;
			}
			// }

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}