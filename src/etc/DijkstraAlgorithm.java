package etc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
	static class Node implements Comparable<Node> {
		int id, weight;

		public Node(int id, int weight) {
			this.id = id;
			this.weight = weight;
		}

		public int compareTo(Node other) {
			return Integer.compare(this.weight, other.weight);
		}
	}

	public static void dijkstra(List<List<Node>> graph, int start) {
		int n = graph.size();
		int[] distances = new int[n];
		Arrays.fill(distances, Integer.MAX_VALUE);
		distances[start] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node node = pq.poll();
			int src = node.id;
			int weight = node.weight;

			if (weight > distances[src]) {
				continue;
			}

			for (Node neighbor : graph.get(src)) {
				int newWeight = distances[src] + neighbor.weight;
				if (newWeight < distances[neighbor.id]) {
					distances[neighbor.id] = newWeight;
					pq.offer(new Node(neighbor.id, newWeight));
				}
			}
		}

		// Output the shortest distances from the start node
		for (int i = 0; i < n; i++) {
			System.out.println("Shortest distance from node " + start + " to node " + i + ": " + distances[i]);
		}
	}

	public static void main(String[] args) {
		int n = 6; // Number of nodes
		List<List<Node>> graph = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}

		// Adding edges to the graph (node, weight)
		graph.get(0).add(new Node(1, 7));
		graph.get(0).add(new Node(2, 9));
		graph.get(0).add(new Node(5, 14));
		graph.get(1).add(new Node(2, 10));
		graph.get(1).add(new Node(3, 15));
		graph.get(2).add(new Node(3, 11));
		graph.get(2).add(new Node(5, 2));
		graph.get(3).add(new Node(4, 6));
		graph.get(4).add(new Node(5, 9));

		dijkstra(graph, 0); // Find shortest paths from node 0
	}
}
