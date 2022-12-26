package _2차;

/********************************
 *	프로젝트 : Algo
 *	패키지   : 
 *	작성일   : 2022. 12. 13.
 *	작성자   : KYJ (callakrsos@naver.com)
 *******************************/

/**
 * @author KYJ (callakrsos@naver.com)
 *
 */

import java.io.*;
import java.util.*;

class Node {
	int row, col;

	Node(int row, int col) {
		this.row = row;
		this.col = col;
	}
}

public class Bloom코드 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static final int UNENROLLED = 0;
	static int de;
	static int N, M; // MAP size
	static Node start1, start2;

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		start1 = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		st = new StringTokenizer(br.readLine());
		start2 = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
	}

	static boolean isOut(int r, int c) {
		return r < 0 || c < 0 || r >= N || c >= M;
	}

	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	public static void main(String args[]) throws IOException {
		input();
		Queue<Node> qu = new LinkedList<>();
		int visited[][] = new int[N][M]; // visited + level
		visited[start1.row][start1.col] = 1; // 날짜 기록
		visited[start2.row][start2.col] = 1;
		qu.add(start1);
		qu.add(start2);
		int maxDay = -1;
		while (!qu.isEmpty()) {
			Node now = qu.poll();

			// 상하좌우 = 인접 next
			for (int t = 0; t < 4; t++) {
				int nr = now.row + dr[t];
				int nc = now.col + dc[t];
				if (isOut(nr, nc))
					continue;
				if (visited[nr][nc] != UNENROLLED)
					continue;
				visited[nr][nc] = visited[now.row][now.col] + 1;
				maxDay = Integer.max(maxDay, visited[nr][nc] );
				qu.add(new Node(nr, nc));
			}
		}
		System.out.println(maxDay);
	}
}
