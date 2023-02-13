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
6
3 5 4 6 2 9
0 5

 * 
 * 
 * 
 * @author KYJ (callakrsos@naver.com)
 *
 */
public class M3_01 {

	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer sc = new StringTokenizer(br.readLine());

			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(sc.nextToken());
			}

			sc = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(sc.nextToken());
			int e = Integer.parseInt(sc.nextToken());

			recursive(arr, s, e, s, 0);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @작성자 : KYJ (callakrsos@naver.com)
	 * @작성일 : 2022. 11. 30.
	 * @param arr
	 * @param currentPos
	 * @param endlimit
	 * @param startlimit
	 * @param flag
	 *            0 정방향, 1 역방향
	 */
	static void recursive(int[] arr, int currentPos, int endlimit, int startlimit, int flag) {

		if (startlimit == endlimit) {
			System.out.print(arr[currentPos] + " ");
			return;
		}
		if (currentPos == startlimit && flag == 1) {
			System.out.print(arr[currentPos] + " ");
			return;
		}

		if (currentPos == endlimit) {
			System.out.print(arr[currentPos] + " ");
			recursive(arr, currentPos - 1, endlimit, startlimit, 1);
			return;
		}

		if (currentPos >= startlimit)
			System.out.print(arr[currentPos] + " ");
		recursive(arr, (flag == 0 ? currentPos + 1 : currentPos - 1), endlimit, startlimit, flag);
	}

}