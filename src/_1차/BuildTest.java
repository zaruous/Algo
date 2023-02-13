package _1차;


import java.util.Scanner;

/********************************
 *	프로젝트 : Algo
 *	패키지   : 
 *	작성일   : 2022. 11. 28.
 *	작성자   : KYJ (callakrsos@naver.com)
 *******************************/

/**
 * @author KYJ (callakrsos@naver.com)
 *
 */
public class BuildTest {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int nextInt = scanner.nextInt();
			switch (nextInt) {
			case 1:
				System.out.println("Hi");
				break;
			case 2:
				System.out.println("Hello");
				break;
			}

		}
	}

}
