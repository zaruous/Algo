import java.io.*;
import java.util.*;

public class M4_추가1_전기차충전_떠오르기어렵 {

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
		// a가 작은수, b가 큰수
		int pa = Find(Math.min(a, b));
		int pb = Find(Math.max(a, b));
		parent[pb] = pa;
	}
	
	public static void main(String[] args) throws IOException {
		int G = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		parent = new int[G + 1];
		for(int i = 0; i <= G; i++)
			parent[i] = i; // 충전기를 비워줌(대표 == 비어있는 충전기)
		int cnt = 0;
		for(int i = 0; i < P; i++)
		{
			int ver = Integer.parseInt(br.readLine());
			int p_ver = Find(ver); // ver의 전기차를 충전할 충전기 버전
			// 사용하는 버전 : 1~G버전, 0이라는 버전을 사용해야 한다? 
			// <- 없는 버전을 써야한다. <- 사용할 수 있는 충전기가 없다.
			if(p_ver == 0)
				break;
			
			Union(p_ver - 1, p_ver);
			cnt++;
		}
		System.out.print(cnt);
	}
}