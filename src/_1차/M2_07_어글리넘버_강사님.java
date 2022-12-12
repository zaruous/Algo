package _1차;
import java.io.*;
import java.util.*;

public class M2_07_어글리넘버_강사님 {
	// 항상 PS에서 꼭 넣고 시작하는 코드
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st; // <- 특정 기준을 통해 문자열을 자르는 역할

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		PriorityQueue<Long> pq = new PriorityQueue<>();
		pq.add((long) 1);
		long ugly[] = new long[1501];
		long last = -1; // 마지막으로 꺼냈던 ugly number
		int cnt = 1; // 이번에 꺼낸 ugly number가 몇 번째 ugly number
		while (cnt <= 1500) {
			long now = pq.poll(); // 앞에서 찾았던 ugly number
			if (last == now)
				continue;
			ugly[cnt] = now;
			pq.add(now * 2);
			pq.add(now * 3);
			pq.add(now * 5);
			last = now;
			cnt++;
		}
		print(ugly);
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			System.out.print(ugly[num] + " ");
		}
	}

	private static void print(long[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}

}