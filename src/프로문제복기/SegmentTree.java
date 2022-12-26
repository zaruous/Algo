package 프로문제복기;

public class SegmentTree {

	private static int[] tree;

	public static void main(String[] args) {
		int[] arr = { 5, 3, 3, 4, 5, 7, 5, 6 };
		tree = new int[100_001];
		init(arr, 1, 1, arr.length - 1);

		System.out.println(tree);
		System.out.println(sum(0, arr.length - 1, 1, 0, 2));
	}

	/**
	 * @작성자 : KYJ (callakrsos@naver.com)
	 * @작성일 : 2022. 12. 20.
	 * @param arr
	 * @param node
	 * @param start
	 * @param end
	 * @return
	 */
	public static int init(int[] arr, int node, int start, int end) {
		if (start == end) {
			return tree[node] = arr[start];
		}

		int mid = (start + end) / 2;
		return tree[node] = init(arr, node * 2, start, mid) + init(arr, node * 2 + 1, mid + 1, end);
	}

	/**
	 * @작성자 : KYJ (callakrsos@naver.com)
	 * @작성일 : 2022. 12. 20.
	 * @param start
	 * @param end
	 * @param node
	 * @param left
	 * @param right
	 * @return
	 */
	public static int sum(int start, int end, int node, int left, int right) {
		if (left > end || right < start)
			return 0;

		if (left <= start && end <= right)
			return tree[node];

		int mid = (start + end) / 2;

		return sum(start, mid, node * 2, left, right) + sum(mid + 1, start, node * 2 + 1, left, right);
	}
}
