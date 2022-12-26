import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 같은이진트리거리 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int arr[];
	static int N;
	static int ans;

	static int func(int node) {
		// 지금 node번 점에 있다.
		// 결과 : node에서부터 leaf까지 한 경로로 갈 때, 가중치의 합

		if (node * 2 > N)
			return arr[node];

		int left = func(node * 2);
		// 왼쪽 자식으로 가라! -> 왼쪽의 가중치 합
		int right = func(node * 2 + 1);
		// 오른쪽 자식으로 가라! -> 오른쪽의 가중치 합

		// 작은 쪽 -> 큰 쪽이 될 수 있도록
		// if(left < right)
		// arr[left] += Math.abs(left - right);
		// else
		// arr[right] += Math.abs(left - right);

		// 결과적으로 두 개의 차이만큼 보정이 필요하다.
		ans += Math.abs(left - right);

		// 보정 후 : (작은쪽->큰쪽) 내 자식들 사이의 가중치 + 내 가중치
		return Math.max(left, right) + arr[node];
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int k = Integer.parseInt(br.readLine());
		N = (1 << (k + 1)) - 1;
		arr = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 2; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			ans += arr[i];
		}
		func(1);
		System.out.println(ans);
	}

}
