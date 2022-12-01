import java.io.*;
import java.util.*;

public class M4_06_끊어진트리_못품 {

	// 항상 PS에서 꼭 넣고 시작하는 코드
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st; // <- 특정 기준을 통해 문자열을 자르는 역할

	static int parent[];
	static int Find(int a) {
		if(a == parent[a]) return a;
		parent[a] = Find(parent[a]);
		return parent[a];
	}
	static void Union(int a, int b) {
		int pa = Find(a);
		int pb = Find(b);
		parent[pa] = pb;
	}
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		int up[] = new int[N + 1];
		
		parent = new int[N + 1];
		for(int i = 1; i <= N; i++)
			parent[i] = i;
		
		for(int nodeNumber = 2; nodeNumber <= N; nodeNumber++)
		{
			up[nodeNumber] = Integer.parseInt(br.readLine());
		}
		int query[][] = new int[(N-1) + Q][3];
		for(int i = 0;i < (N-1) + Q; i++)
		{
			st = new StringTokenizer(br.readLine());
			int oper = Integer.parseInt(st.nextToken());
			int a = 0, b = 0;
			if(oper == 0)
				a = Integer.parseInt(st.nextToken());
			else if(oper == 1) {
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
			}
			query[i][0] = oper;
			query[i][1] = a;
			query[i][2] = b;
		}
		ArrayList<String> ans = new ArrayList<>();
		for(int i = (N-1) + Q - 1; i >= 0; i--)
		{
			if(query[i][0] == 0) {
				int a = query[i][1];
				Union(a, up[a]);
			}
			else if(query[i][0] == 1) {
				int a = query[i][1];
				int b = query[i][2];
				if(Find(a) == Find(b)) 
					ans.add("YES");
				else
					ans.add("NO");
			}
		}
		for(int i = ans.size() - 1; i >= 0; i--)
		{
			System.out.println(ans.get(i));
		}
	}
}