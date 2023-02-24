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
public class M3_02_1 {

	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			// int N = Integer.parseInt(br.readLine());
			StringTokenizer sc = new StringTokenizer(br.readLine());
			int branch = Integer.parseInt(sc.nextToken());
			int level = Integer.parseInt(sc.nextToken());

			int total = 0;
			for (int i = 0; i <= level; i++) {
				total += Math.pow(branch, i);
			}
			System.out.println(total);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}