package 세그먼트트리;

import java.io.*;
import java.util.*;

public class RangeMinimumQueryCode {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }; // 실제 배열 값
	static int tree[]; // segment tree의 값을 저장할 배열

	static int init(int node, int left, int right) {
		// tree의 node번째 위치에는 배열의 left~right에 해당하는 결과를 갖고있다.
		// 해당 결과를 반환

		// 단일값을 갖는 node
		if (left == right) {
			tree[node] = arr[left]; // arr[right]
			return tree[node];
		}

		int mid = (left + right) / 2;
		// 왼쪽 자식에서 제일 작은 값(left~mid)
		int leftValue = init(node * 2, left, mid);
		// 오른쪽 자식에서 제일 작은 값(mid+1~right)
		int rightValue = init(node * 2 + 1, mid + 1, right);

		tree[node] = Math.min(leftValue, rightValue);
		return tree[node];
	}

	// node, left, right <- 3가지 정보 : tree라는 구조를 탐색할때 필요한 정보
	static int query(int node, int left, int right, int start, int end) {
		// node번째, left~right라는 범위의 제일 작은 값을 기반으로
		// start~end라는 구간에서 제일 작은 값

		// 1. 구간을 완전히 벗어나는 경우
		if (right < start || end < left) // 원하는 data가 포함되지 않는다.
			return 2134567890; // <- *필요 없는 data(결과에 영향을 주지 않을 data)*

		// 2. 구간에 완전히 포함되는 경우(내가 원하는 값을 다 갖고 있는 경우)
		if (start <= left && right <= end)
			return tree[node]; // left~right구간에 대한 정보를 통째로 가져가서 사용

		// 3. 겹치는 경우(애매하게 걸쳐있는 경우)
		int mid = (left + right) / 2;
		// <- left~mid까지 구간에 start~end에 포함되는 data에 대한 결과
		int leftValue = query(node * 2, left, mid, start, end);
		// <- mid+1~right까지 구간에 start~end에 포함되는 data에 대한 결과
		int rightValue = query(node * 2 + 1, mid + 1, right, start, end);

		return Math.min(leftValue, rightValue);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		arr = new int[N];
		tree = new int[N * 4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		init(1, 0, N - 1);
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			s -= 1;
			e -= 1;
			System.out.println(query(1, 0, N - 1, s, e));
		}

	}

}