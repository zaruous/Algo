package _1차;

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
public class M1_03 {

	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String nextInt = br.readLine();
			String[] split = nextInt.split(" ");
			int row = Integer.parseInt(split[0]);
			int col = Integer.parseInt(split[1]);
			int d[][] = new int[row][col];

			for (int i = 0; i < row; i++) {
				String readLine = br.readLine();
				split = readLine.split(" ");
				for (int j = 0; j < split.length; j++) {
					d[i][j] = Integer.parseInt(split[j]);
				}
			}

			int max = Integer.MIN_VALUE;
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					int w = getMaxWidth(d, i, j);
					int h = getMaxHeight(d, i, j, w);
					int s = sum(d, i, j, w, h);
					max = Integer.max(s, max);
				}
			}
			System.out.println(max);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	private static int sum(int[][] d, int i, int j, int w, int h) {

		int sum = 0;
		for (int a = i; a < (i + h); a++) {
			for (int b = j; b < (j + w); b++) {
				sum += d[a][b];
			}
		}
		return sum;
	}

	private static int getMaxWidth(int[][] arr, int i, int j) {

		int w = 0;
		for (int a = j; a < arr[0].length; a++) {
			if (arr[i][a] == 0)
				return w;
			w++;
		}
		return w;
	}

	private static int getMaxHeight(int[][] arr, int i, int j, int maxw) {

		int h = 0;
		for (int a = i; a < arr.length; a++) {

			for (int b = j; b < (j + maxw); b++) {
				if (arr[a][b] == 0)
					return h;
			}
			h++;
		}
		return h;
	}
}
