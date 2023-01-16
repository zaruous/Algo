package 세그먼트트리;

import java.io.*;
import java.util.*;

public class 콩쿠르순위예측기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int tree[];

	// init : 어떤 여러개의 data들을 한번에 초기화 ex) arr이라는 배열에 대한 segment tree를 관리해야 하는경우
	static int update(int node, int left, int right, int idx, int val) {
		// 1. idx라는 사람이 left~right범위에 없는 경우
		if (idx < left || right < idx)
			return tree[node];

		// 2. leaf까지 도달한 경우(단일 값을 갖는 node)
		if (left == right) // left == right == idx
			return tree[node] = val; // 각 학번의 사람이 1명이기에 바로 대입

		// 3. left~right '구간'에 idx가 포함되는 경우
		int mid = (left + right) / 2;
		int leftValue = update(node * 2, left, mid, idx, val);
		int rightValue = update(node * 2 + 1, mid + 1, right, idx, val);
		return tree[node] = leftValue + rightValue;
	}

	static int query(int node, int left, int right, int start, int end) {
		// 1. left~right가 start~end범위를 벗어나는 경우
		if (right < start || end < left)
			return 0;

		// 2. left~right가 start~end범위 안에 완벽히 포함되는 경우
		if (start <= left && right <= end)
			return tree[node];

		// 3. left~right가 start~end범위에 '걸쳐'있는 경우
		int mid = (left + right) / 2;
		int leftValue = query(node * 2, left, mid, start, end);
		int rightValue = query(node * 2 + 1, mid + 1, right, start, end);
		return leftValue + rightValue;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		tree = new int[1000001 * 4];

		int Q = Integer.parseInt(br.readLine());
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int oper = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if (oper == 1) {
				update(1, 1, 1000000, num, 1);

				// 1~num이라는 '내 이상의 능력'을 갖는 사람이 '몇 명'인가?
				System.out.println(query(1, 1, 1000000, 1, num) + "위");
			} else {
				update(1, 1, 1000000, num, 0);
				System.out.println(query(1, 1, 1000000, 1, 1000000) + "명");
			}
		}
	}

}
