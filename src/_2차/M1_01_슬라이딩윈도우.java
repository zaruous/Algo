package _2차;
import java.io.*;
import java.util.*;

/**
 * 슬라이딩 윈도우
 * 
 * @author KYJ (callakrsos@naver.com)
 *
 */
public class M1_01_슬라이딩윈도우 {
	static int N, M; // N : 배열의 크기 , M : 각 구간의 크기
	static int arr[];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}

	static int de;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			input();
			// 1. 첫 번째 구간합구하기
			int sum = 0;
			for (int i = 0; i < M; i++) {
				sum += arr[i];
			}
			int maxSum = sum;
			int maxStart = 0;
			int maxEnd = M - 1;

			// 2. 두 번째 ~ 마지막 구간
			// a : 제거하는 역할 , b : 추가 하는 역할
			int b = M;
			for (int a = 0; a < N; a++) {
				if (b >= N)
					break;
				sum -= arr[a];
				sum += arr[b];
				// (a, b] 구간의 합을 for 문안돌리고 2 번연산만에 해결!
				if (maxSum < sum) {
					maxStart = a + 1;
					maxEnd = b;
					maxSum = sum;
				}
				b++;
			}

			System.out.println("#" + tc + " " + maxStart + " " + maxEnd + " " + maxSum);
		}
	}
}
