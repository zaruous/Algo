import java.io.*;
import java.util.*;

public class M1_07_연료게이지 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int de;

	static boolean func(char par) {
		return par == '#'; // # 이면 return true, _ return false
	}

	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			String gage = br.readLine();
			// # 이 존재하는 최대 인덱스 찾기
			int answer = -1;
			int s = 0;
			int e = gage.length() - 1;
			while (s <= e) {
				int mid = (s + e) / 2;
				if (func(gage.charAt(mid))) {
					// # 이면
					answer = Integer.max(answer, mid);
					s = mid + 1;
				} else {
					e = mid - 1;
				}
			}
			int kan = answer + 1;
			System.out.println(kan * 100 / gage.length() + "%");
		}
	}

}
