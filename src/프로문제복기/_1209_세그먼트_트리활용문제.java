package 프로문제복기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 
 * 정렬된 트리를 유지해야함. 세그먼트 트리
 * @author KYJ (zaruous@naver.com)
 *
 */
public class _1209_세그먼트_트리활용문제 {

	static ArrayList<Integer>[] rankinglist;
	static int N, Q, sameRank;
	static int tree[];
	static final int treeH = 100_001;
	static long sol;

	static void update(int node, int start, int end, int pos, int val) {
		if (pos < start || end < pos)
			return;
		tree[node] = tree[node] + val;
		if (start == end)
			return;
		update(node * 2, start, (start + end) / 2, pos, val);
		update(node * 2 + 1, (start + end) / 2 + 1, end, pos, val);
	}

	static int query(int node, int start, int end, int left, int right, int rank) {
		if (start > right || left > end)
			return 0;
		if (start == end) {
			sameRank = rank;
			return start;
		}
		if (tree[node * 2] >= rank) {
			return query(node * 2, start, (start + end) / 2, left, right, rank);
		} else {
			return query(node * 2 + 1, (start + end) / 2 + 1, end, left, right, rank - tree[node * 2]);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			sol = 0l;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			Q = Integer.parseInt(st.nextToken());
			rankinglist = new ArrayList[treeH + 1];
			for (int i = 0; i <= treeH; i++) {
				rankinglist[i] = new ArrayList<Integer>();
			}
			tree = new int[treeH * 4];
			for (int i = 1; i <= Q; i++) {
				sameRank = 0;
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				if (x == 1) {
					int id = Integer.parseInt(st.nextToken());
					int jumsu = treeH - Integer.parseInt(st.nextToken());
					update(1, 1, treeH, jumsu, 1);
					rankinglist[jumsu].add(id);
				} else {
					int rank = Integer.parseInt(st.nextToken());
					int result = query(1, 1, treeH, 1, treeH, rank);
					sol = sol + rankinglist[result].get(sameRank - 1);
				}
			}
			System.out.println("#" + t + " " + sol);
		}
	}
}
