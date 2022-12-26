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

public class M2추가_1_인접행렬BFS {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st; 
	static int de; 
	static int N ; 
	static int adj_mat[][];
	static ArrayList<Integer>adj_lst[];
	static void input() throws IOException
	{
		N = Integer.parseInt(br.readLine());
		adj_lst = new ArrayList[N]; 
		for(int node = 0; node < N; node ++)adj_lst[node] = new ArrayList<Integer>();
		adj_mat = new int[N][N];
		for(int row = 0 ; row < N; row ++)
		{
			st = new StringTokenizer(br.readLine());
			for(int col = 0 ; col < N; col ++)
			{
				adj_mat[row][col] = Integer.parseInt(st.nextToken());
				if(adj_mat[row][col] == 1) {
					adj_lst[row].add(col);
				}
			}
		}
	}
	public static void main(String args[]) throws IOException
	{
		input(); 
		de = -1;
		int visited[] = new int[N];
		int start = 0;
		Queue<Integer> qu = new LinkedList<>(); 
		visited[start] = 1; 
		qu.add(start);
		
		while(!qu.isEmpty())
		{
			int now = qu.poll(); 
			//search 
			System.out.print(now + " ");
			
			for(Integer next : adj_lst[now])
			{
				if(visited[next] == 1)continue; 
				visited[next] =1 ; 
				qu.add(next);
			}
//			// 인접행렬 탐색 
//			for(int next = 0 ; next < N; next ++) 
//			{
//				if(adj_mat[now][next] == 0)continue;
//				if(visited[next] == 1)continue; // 이전에 등록된적? 
//				visited[next] = 1; 
//				qu.add(next);
//			}
		}
		
		
	}

}