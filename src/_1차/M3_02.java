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
public class M3_02 {

	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer sc = new StringTokenizer(br.readLine());
			int branch = Integer.parseInt(sc.nextToken());
			int level = Integer.parseInt(sc.nextToken());

			recursive(0, branch, level);
			System.out.println(visite);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	static int visite = 0;

	private static void recursive(int currentLevel, int branch, int level) {

		if (level < currentLevel) {
			return;
		}
		visite++;
		for (int i = 0; i < branch; i++) {
			recursive(currentLevel + 1, branch, level);
		}
	}

}