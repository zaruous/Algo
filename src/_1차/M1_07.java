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
public class M1_07 {

	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int N = Integer.parseInt(br.readLine());

			// int[] numbers = new int[9999];
			String[] names = new String[10000];

			// 0 처음 인식, 1입장, 2퇴장
			int[] inout = new int[10000];
			for (int i = 0; i < N; i++) {
				String[] inputs = br.readLine().split(" ");
				String command = inputs[0];
				int number = Integer.parseInt(inputs[1]);
				
				switch (command) {
				case "1":
					String name = inputs[2];
					if (names[number] == null) {
						names[number] = name;
						System.out.println(number + " " + "OK");
					} else {
						System.out.println(number + " " + "ERROR");
					}

					break;
				case "2":
					if (names[number] == null) {
						System.out.println(number + " " + "ERROR");
						break;
					}

					if (inout[number] == 0) {
						System.out.println(number + " " + names[number] + " ENTER");
						inout[number] = 1;
					} else if (inout[number] == 1) {
						System.out.println(number + " " + names[number] + " EXIT");
						inout[number] = 2;
					} else if (inout[number] == 2) {
						System.out.println(number + " " + names[number] + " ENTER");
						inout[number] = 1;
					}
					break;
				}

			}

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
