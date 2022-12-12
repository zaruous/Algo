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
public class M1_02 {

	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String nextInt = br.readLine();
			String[] split = nextInt.split(" ");
			int row = Integer.parseInt(split[0]);
			for (int i = 0; i < row; i++) {
				String readLine = br.readLine();
				int p = 0;
				for (int j = 0; j < readLine.length(); j++) {
					if (readLine.charAt(j) == '1')
						p++;
				}
				System.out.println(p);
			}

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
