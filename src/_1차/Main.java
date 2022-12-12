package _1차;
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			int num[] = new int[400001];
			int index = 0;
			long cnt[] = new long[400001];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				int temp = Integer.parseInt(st.nextToken()) % m;
				if (temp < 0)
					temp += m;

				if (cnt[temp] == 0)
					num[index++] = temp;
				cnt[temp]++;
			}

			int hap_num[] = new int[800_002];
			int hap_index = 0;
			long hap_cnt[] = new long[400_001];
			for (int i = 0; i < index; i++) {
				for (int j = i; j < index; j++) {
					int temp = (num[i] + num[j]);
					if (temp >= m)
						temp -= m;

					if (hap_cnt[temp] == 0)
						hap_num[hap_index++] = temp;

					if (i == j)
						hap_cnt[temp] += cnt[num[i]] * cnt[num[j]];
					else
						hap_cnt[temp] += cnt[num[i]] * cnt[num[j]] * 2;
				}
			}

			int de = 1;
			long ans = 0;

			for (int i = 0; i < hap_index; i++) {
				int temp = k - hap_num[i];
				if (temp < 0)
					temp += m;
				if (hap_cnt[temp] != 0)
					ans += hap_cnt[temp] * hap_cnt[hap_num[i]];
			}
			System.out.println("#" + test_case + " " + ans);
		}
	}
}
