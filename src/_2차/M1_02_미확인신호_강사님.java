package _2차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 슬라이딩 윈도우
 * 
 * @author KYJ (callakrsos@naver.com)
 *
 */
public class M1_02_미확인신호_강사님 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int de;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int M = Integer.parseInt(br.readLine());
		String str = br.readLine();

		int dup = 0;
		int exist[] = new int[200];
		// 첫 번째 구간 dat 등록
		for (int i = 0; i < M; i++) {
			char ch = str.charAt(i);
			if (exist[ch] == 1) {
				dup = 1;
			}
			exist[ch] = 1;
		}

		// 두번째 ~ 마지막구간 sliding window 진행
		int b = M;
		for (int a = 0; a < str.length(); a++) {
			if (b >= str.length())
				break;
			// (a,b] dat로 해당 구간 정보 만들기
			char erase = str.charAt(a);
			char plus = str.charAt(b);
			exist[erase] = 0;
			if (exist[plus] == 1) {
				dup = 1;
			}
			exist[plus] = 1;
			b++;
		}
		if (dup == 1) {
			System.out.println("FAIL");
		} else {
			System.out.println("PASS");
		}

	}

}
