package _2차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

import java.io.*;
import java.util.*;

class Node {
	int row, col;

	Node(int row, int col) {
		this.row = row;
		this.col = col;
	}
}

public class 공포게임공략_미완성 {
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M;
	static char MAP[][];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	static boolean isOut(int r, int c) {
		return r < 0 || c < 0 || r >= N || c >= M;
	}

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		MAP = new char[N][M];
		for (int row = 0; row < N; row++) {
			MAP[row] = br.readLine().toCharArray();
		}
	}

	static boolean ghostCanGo(int r, int c, int visited[][]) {
		if (isOut(r, c))
			return false;
		if (MAP[r][c] == '#')
			return false;
		if (visited[r][c] != -1)
			return false;
		return true;
	}

	static boolean minchulCanGo(int r, int c, int visited[][], int Mytime, int[][][] ghostsVisited) {
		if (isOut(r, c))
			return false;
		if (MAP[r][c] == '#')
			return false;
		if (visited[r][c] != -1)
			return false;
		// 고스트들의 도착시간(ghostVisited) vs minchul도착시간(time)
		for (int ghostNum = 0; ghostNum < ghostCnt; ghostNum++) {
			// ghostsVisited[ghostNum][r][c] vs Mytime
			// time > time -> continue;
			// ghostsVisited[ghostNum][r][c] % 2 == Mytime % 2 return false;
		}
		return true;
	}

	static void bfs_ghost(Node start, int visited[][]) {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				visited[r][c] = -1;
			}
		}
		Queue<Node> qu = new LinkedList<>();
		visited[start.row][start.col] = 0;
		qu.add(new Node(start.row, start.col));

		while (!qu.isEmpty()) {
			Node now = qu.poll();

			for (int t = 0; t < 4; t++) {
				int nr = now.row;
				int nc = now.col;
				if (!ghostCanGo(nr, nc, visited))
					continue;
				visited[nr][nc] = visited[now.row][now.col] + 1;
				qu.add(new Node(nr, nc));
			}
		}
	}

	static int bfs_minchul(Node start, int visited[][], int ghostsVisited[][][]) {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				visited[r][c] = -1;
			}
		}
		Queue<Node> qu = new LinkedList<>();
		visited[start.row][start.col] = 0;
		qu.add(new Node(start.row, start.col));

		while (!qu.isEmpty()) {
			Node now = qu.poll();
			if (MAP[now.row][now.col] == 'E') {
				return visited[now.row][now.col];
			}
			int time = visited[now.row][now.col];
			for (int t = 0; t < 4; t++) {
				int nr = now.row;
				int nc = now.col;

				if (!minchulCanGo(nr, nc, visited, time + 1, ghostsVisited))
					continue;
				visited[nr][nc] = visited[now.row][now.col] + 1;
				qu.add(new Node(nr, nc));
			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		input();
		ghostsBFS(); // 고스트 찾아서 bfs돌려서 ghostsVisited 배열 채우기
		int ret = minChulBFS(); //
		System.out.println(ret);
	}
}