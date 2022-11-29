
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

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
public class M1_01 {

	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String nextInt = br.readLine();
			int input = Integer.parseInt(nextInt);
			switch (input) {
			case 1:
				nextInt = br.readLine();
				int count = Integer.parseInt(nextInt);
				int sum = 0;
				long sub = 1;
				String t = br.readLine();

				String[] split = t.split(" ");
				for (int i = 0; i < split.length; i++) {
					int tmp = Integer.parseInt(split[i]);
					sum += tmp;
					sub *= tmp;
				}

				System.out.println(sum + " " + sub);
				break;
			case 2:
				nextInt = br.readLine();
				count = Integer.parseInt(nextInt);
				int maxlen = Integer.MIN_VALUE;
				int minlen = Integer.MAX_VALUE;
				String maxStr = "";
				String minStr = "";
				for (int i = 0; i < count; i++) {
					t = br.readLine();

					if (t.length() > maxlen)
						maxStr = t;
					if (t.length() < minlen)
						minStr = t;

					maxlen = Integer.max(t.length(), maxlen);
					minlen = Integer.min(t.length(), minlen);
				}
				System.out.println(maxStr);
				System.out.println(minStr);
				break;
			case 3:

				String tmp = br.readLine();
				String[] inputs = tmp.split(" ");
				int row = Integer.parseInt(inputs[0]);
				int col = Integer.parseInt(inputs[1]);

				int[][] arr = new int[row][col];
				int[] dis = new int[100];
				Arrays.fill(dis, Integer.MAX_VALUE);
				int minval = Integer.MAX_VALUE;
				for (int i = 0; i < row; i++) {
					t = br.readLine();
					inputs = t.split(" ");
					for (int j = 0; j < col; j++) {
						arr[i][j] = Integer.parseInt(inputs[j]);
						if (dis[arr[i][j]] == Integer.MAX_VALUE)
							dis[arr[i][j]] = 1;
						else
							dis[arr[i][j]] += 1;
						minval = Integer.min(arr[i][j], minval);
					}

				}

				// int mincount = Integer.MAX_VALUE;
				// for (int i = 0; i < 100; i++) {
				// mincount = Integer.min(mincount, dis[i]);
				// }

				System.out.println(minval);
				System.out.println(dis[minval] + "개");

				break;
			}

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
