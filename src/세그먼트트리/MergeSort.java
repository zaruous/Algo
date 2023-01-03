package 세그먼트트리;
import java.io.*;
import java.util.*;

public class MergeSort {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int arr[];

	static void merge(int left, int right) {
		// left ~ right구간을 합침
		int mid = (left + right) / 2;

		int l = left; // 왼쪽 구역의 가장 작은 값
		int r = mid + 1; // 오른쪽 구역의 가장 작은 값

		int temp[] = new int[right - left + 1];
		int index = 0;
		while (l <= mid && r <= right) // <- 왼쪽 구역과 오른쪽 구역을 비교하여 작은 값부터 채우기
			if (arr[l] < arr[r])
				temp[index++] = arr[l++];
			else
				temp[index++] = arr[r++];
		
		while (l <= mid) // 왼쪽 구역이 남았다면
			temp[index++] = arr[l++]; // 왼쪽 구역의 data를 마저 채움
		
		while (r <= right) // 오른쪽 구역이 남았다면
			temp[index++] = arr[r++]; // 오른쪽 구역의 data를 마저 채움

		for (int i = left; i <= right; i++)
			arr[i] = temp[i - left];

	}

	static void mergesort(int left, int right) {

		// data가 1개밖에 없으면 굳이 쪼개거나 정렬할 필요가 X
		if (left >= right)
			return;

		int mid = (left + right) / 2;
		mergesort(left, mid); // <- 왼쪽 구역 정렬
		mergesort(mid + 1, right); // <- 오른쪽 구역 정렬

		merge(left, right);

		for (int i = left; i <= right; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		mergesort(0, N - 1);
	}

}