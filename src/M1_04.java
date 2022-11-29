
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
public class M1_04 {

	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String nextInt = br.readLine();
			String[] split = nextInt.split(" ");
			int row = Integer.parseInt(split[0]);
			int col = Integer.parseInt(split[1]);
			char d[] = new char[row * col];

			int slide = 0;
			String fullText = "";
			for (int i = 0; i < row; i++) {
				String readLine = br.readLine();
				fullText = fullText.concat(readLine);
				for (int j = 0; j < readLine.length(); j++) {
					d[slide++] = readLine.charAt(j);
				}
			}

			int findLen = Integer.parseInt(br.readLine());
			String findStr = br.readLine();

			for (int i = 0; i < (row * col) - findStr.length()+1; i++) {

				boolean find = false;
				for (int j = 0; j < findLen; j++) {
					if (d[i + j] != findStr.charAt(j)) {
						find = false;
						break;
					}
					find = true;
				}
				if (find) {
					System.out.println("("+((i) / col) + "," + (i % (col))+")");
				}
			}

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
