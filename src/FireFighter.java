/********************************
 *	프로젝트 : Algo
 *	패키지   : 
 *	작성일   : 2022. 12. 14.
 *	작성자   : KYJ (callakrsos@naver.com)
 *******************************/

/**
 * @author KYJ (callakrsos@naver.com)
 *
 */

import java.io.*; 
import java.util.*; 

class Node  {
	int row, col; 
	Node(int row, int col) 
	{ 
		this.row = row;
		this.col = col; 
	}
}

public class FireFighter {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st; 
	static int de; 
	static int N , M; // MAP size
	static char MAP[][];
	static Node start;
	static Node fire; 
	static void input() throws IOException { 
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		MAP = new char[N][N]; 
		for(int r =0 ; r < N; r++) 
		{
			MAP[r] = br.readLine().toCharArray();
		}
		st = new StringTokenizer(br.readLine());
		start = new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
	}
	static void setFirePosition()
	{
		for(int r = 0; r< N; r ++) 
		{
			for(int c = 0 ;c < N; c++) 
			{
				if(MAP[r][c] == '$') {
					fire = new Node(r,c); 
					return; 
				}
			}
		}
		return;
	}
	static boolean isOut(int r, int c ) 
	{
		return r  < 0 || c < 0 || r >= N || c >= N; 
	}
	static int dr[] = {-1,1,0,0}; 
	static int dc[] = {0,0,-1,1};

	
	static int minSum = Integer.MAX_VALUE;
	static void bfs2(Node s, char hurdle)
	{
		int visited[][] = new int[N][N]; 
		for(int row = 0 ; row < N; row ++) for(int col = 0 ; col < N; col ++) visited[row][col] = -1;
		Queue<Node> qu = new LinkedList<>(); 
		visited[s.row][s.col] = 0 ;
		qu.add(new Node(s.row,s.col));
		while(!qu.isEmpty())
		{
			Node now = qu.poll(); 
			if(MAP[now.row][now.col]== 'A')
			{
				// 민철 ~> A + A ~> 불
				int ret = visited[now.row][now.col] + fire_to_A[now.row][now.col]; 
				minSum = Integer.min(ret, minSum); 
			}
			for(int t = 0; t < 4; t ++) 
			{
				int nr = now.row + dr[t]; 
				int nc = now.col + dc[t]; 
				if(isOut(nr,nc))continue; 
				if(MAP[nr][nc] == '#')continue; 
				if(MAP[nr][nc] == hurdle)continue; 
				if(visited[nr][nc] >= 0)continue;
				visited[nr][nc] = visited[now.row][now.col] + 1;
				qu.add(new Node(nr,nc)); 
			}
		}
	}
	static int fire_to_A[][] ;  
	static void bfs1(Node s)
	{
		fire_to_A = new int[N][N]; 
		for(int row = 0 ; row < N; row ++) for(int col = 0 ; col < N; col ++) fire_to_A[row][col] = -1;
		Queue<Node> qu = new LinkedList<>(); 
		fire_to_A[s.row][s.col] = 0 ;
		qu.add(new Node(s.row,s.col));
		while(!qu.isEmpty())
		{
			Node now = qu.poll(); 
			for(int t = 0; t < 4; t ++) 
			{
				int nr = now.row + dr[t]; 
				int nc = now.col + dc[t]; 
				if(isOut(nr,nc))continue; 
				if(MAP[nr][nc] == '#')continue;  
				if(fire_to_A[nr][nc] >= 0)continue;
				fire_to_A[nr][nc] = fire_to_A[now.row][now.col] + 1;
				qu.add(new Node(nr,nc)); 
			}
		}
	}
	public static void main(String args[]) throws IOException
	{ 
		input();
		setFirePosition();
		
		bfs1(fire); // $ ~> 각 A 까지 거리 기록하기  
		bfs2(start,'$') ; // 소화기 찾기 , 민철~~~>소화기 +  
		System.out.println(minSum);
	}
}
