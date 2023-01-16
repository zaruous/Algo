package _2차;
import java.io.*;
import java.util.*;

/**
 * 슬라이딩 윈도우
 * 
 * @author KYJ (zaruous@naver.com)
 *
 */
public class M1추가_1_버스주차요금저렴한곳찾기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int[] arr = new int[] { 1, 2, 3, 3, 5, 1, 0, 1, 3 };
		int size = Integer.parseInt(br.readLine());
		int minsum = Integer.MAX_VALUE;
		int sum = 0;

		for (int a = 0; a < size; a++) {
			sum += arr[a];
		}
		minsum = sum;

		for (int a = size; a < arr.length; a++) {
			sum += arr[a];
			sum -= arr[a - size];
			minsum = Math.min(minsum, sum);

		}

		System.out.println(minsum);

	}
}
