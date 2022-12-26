package _2차;

import java.io.*;
import java.util.*;



public class 안나와엘사 {
	
	static class Node {
		int row, col;

		Node(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static char MAP[][];
	static Node anna, elsa;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	static boolean isOut(int r, int c) {
		return r < 0 || c < 0 || r >= N || c >= N;
	}

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		MAP = new char[N][N];
		for (int row = 0; row < N; row++) {
			MAP[row] = br.readLine().toCharArray();
		}
		st = new StringTokenizer(br.readLine());
		anna = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		elsa = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
	}

	static void bfs(Node start, int visited[][]) {
		Queue<Node> qu = new LinkedList<>();
		visited[start.row][start.col] = 0;
		qu.add(new Node(start.row, start.col));

		while (!qu.isEmpty()) {
			Node now = qu.poll();

			for (int t = 0; t < 4; t++) {
				int nr = now.row + dr[t];
				int nc = now.col + dc[t];
				if (isOut(nr, nc))
					continue;
				if (MAP[nr][nc] == '#')
					continue;
				if (visited[nr][nc] != -1)
					continue;
				visited[nr][nc] = visited[now.row][now.col] + 1;
				qu.add(new Node(nr, nc));
			}
		}
	}

	public static void main(String[] args) throws IOException {
		input();
		int visited_anna[][] = new int[N][N];
		int visited_elsa[][] = new int[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				visited_anna[r][c] = -1;
				visited_elsa[r][c] = -1;
			}
		}
		bfs(anna, visited_anna);
		bfs(elsa, visited_elsa);

		int answer[][] = new int[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				answer[r][c] = Integer.max(visited_anna[r][c], visited_elsa[r][c]);
			}
		}

		int minMeetTime = (int) 1e9;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (answer[r][c] == -1)
					continue;
				minMeetTime = Integer.min(answer[r][c], minMeetTime);
			}
		}
		System.out.println(minMeetTime);

	}
}
