import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	// 항상 PS에서 꼭 넣고 시작하는 코드
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st; // <- 특정 기준을 통해 문자열을 자르는 역할

	static int N, M;

	static class Node implements Comparable<Node> {
		int x1, x2, width;
		int anser;

		public Node(int x1, int width) {
			super();
			this.x1 = x1;
			this.x2 = x1 + width;
			this.width = width;
		}

		@Override
		public int compareTo(Main.Node o) {

			if (this.x1 == o.x1)
				return Integer.compare(this.x2, o.x2);
			return Integer.compare(this.x1, o.x1);
		}

	}

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 프린트

		PriorityQueue<Main.Node> priorityQueue = new PriorityQueue<Node>();
		ArrayList<Main.Node> questions = new ArrayList<Main.Node>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int req = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			Node e = new Node(req, cost);
			priorityQueue.add(e);
			questions.add(e);
		}

		int[] marker = new int[M];
		int min = Integer.MAX_VALUE;
		int idx = 0;
		while (!priorityQueue.isEmpty()) {
			Main.Node poll = priorityQueue.poll();
			for (int i = 0; i < marker.length; i++) {
				if (marker[i] < min) {
					marker[i] = min ;
					idx = i;
				}
			}
			// marker[0] = poll.x2;

			poll.anser = (idx + 1);
		}
		questions.forEach(n -> {
			// System.out.println(n.x1 + " " + n.width + " " + n.anser);
			System.out.println(n.anser);
			// System.out.println(n.anser);
		});

	}

}