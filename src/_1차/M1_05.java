package _1차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/********************************
 *	프로젝트 : Algo
 *	패키지   : 
 *	작성일   : 2022. 11. 28.
 *	작성자   : KYJ (callakrsos@naver.com)
 *******************************/

/**
 * 블랙리스트
 * 
 * @author KYJ (callakrsos@naver.com)
 *
 */
public class M1_05 {

	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String nextInt = br.readLine();
			String[] split = nextInt.split(" ");
			int row = Integer.parseInt(split[0]);
			int col = Integer.parseInt(split[1]);
			
			
			int apt[] = new int[100001];
			
			for (int i = 0; i < row; i++) {
				String readLine = br.readLine();
				split = readLine.split(" ");
				for (int j = 0; j < split.length; j++) {
					apt[Integer.parseInt(split[j])] += 1;
				}
			}

			nextInt = br.readLine();
			split = nextInt.split(" ");
			int row2 = Integer.parseInt(split[0]);
			int col2 = Integer.parseInt(split[1]);
			int black[][] = new int[row2][col2];
			for (int i = 0; i < row2; i++) {
				String readLine = br.readLine();
				split = readLine.split(" ");
				for (int j = 0; j < split.length; j++) {
					black[i][j] = Integer.parseInt(split[j]);
				}
			}

			int blackcnt = 0;
			for (int i = 0; i < row2; i++) {
				for (int j = 0; j < col2; j++) {
					int idx = black[i][j];
					blackcnt += apt[idx]; apt[idx] = 0;
//					System.out.println(idx+" " +apt[idx]);
				}
			}
			System.out.println(blackcnt);
			System.out.println((row * col) - blackcnt);

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}