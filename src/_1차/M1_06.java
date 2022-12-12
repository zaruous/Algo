package _1차;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class M1_06 {

	// 항상 PS에서 꼭 넣고 시작하는 코드
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st; // <- 특정 기준을 통해 문자열을 자르는 역할

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String temp = br.readLine();
		int isAlpha[] = new int[256];
		// isAlpha[index : 알파벳] = value : 해당 알파벳이 있었는가?
		// char : 2진수 수, 1byte크기 = 8bits = 2^8 : 0~255
		for (int i = 0; i < temp.length(); i++) {
			char ch = temp.charAt(i);
			isAlpha[ch] = 1; // ch라는 알파벳은 존재한다.
		}

		for (char ch = 'A'; ch <= 'Z'; ch++)
			if (isAlpha[ch] == 1)
				System.out.print(ch);
		// int num = 'a' + 1;
		// System.out.println((char)num);
	}
}
