package _2차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 슬라이딩 윈도우
 * 
 * @author KYJ (zaruous@naver.com)
 *
 */
public class M1_03_예식상서빙_강사님코드 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, r;
	static int arr[];

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		arr = new int[2 * n];// 배열 크기 2배 -> 원형
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			arr[i + n] = arr[i];
		}

	}

	static int de;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			input();
			int m = 2 * r + 1; // 구간의 크기
			int flag = 0;
			// 첫 번째 구간
			int dat[] = new int[201]; // 0 ~ 200
			for (int i = 0; i < m; i++) {
				dat[arr[i]]++;
				if (dat[arr[i]] >= 3) {
					flag = 1;
				}
			}

			// 두 번째 구간 ~ 마지막구간
			// a : 제거해야하는 포인터 , b : 추가해야하는 포인터
			int b = m;
			for (int a = 0; a < 2 * n; a++) {
				if (b >= 2 * n)
					break;
				dat[arr[a]]--;
				dat[arr[b]]++;

				// (a ,b ] : item 이 dat 에 등록
				if (dat[arr[b]] >= 3) {
					flag = 1;
					break;
				}

				b++;
			}

			if (flag == 1) {
				System.out.println("#" + tc + " " + "NO");
			} else {
				System.out.println("#" + tc + " " + "YES");
			}
		}

	}

}
