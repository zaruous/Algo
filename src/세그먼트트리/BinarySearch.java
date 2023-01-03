package 세그먼트트리;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinarySearch {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int N;
	private static int[] arr;
	private static StringTokenizer sc;
	private static int K;

	public static void main(String[] args) throws IOException {
		
		N = Integer.parseInt(br.readLine()) ;
		
		sc = new StringTokenizer(br.readLine());
		arr = new int[N + 1]; 
		for(int i=1; i<= N ; i++) {
			arr[i] = Integer.parseInt(sc.nextToken());
		}
		Arrays.sort(arr, 1, arr.length);
		K = Integer.parseInt(br.readLine()) ;
		
		sc = new StringTokenizer(br.readLine());
		for(int i=0; i< K; i++) {
			int srch = Integer.parseInt(sc.nextToken());
			boolean binarySearch = binarySearch(srch, 1, N);
			System.out.print(binarySearch ? "O" : "X");
		}
	}

	private static boolean binarySearch(int srch, int start , int end) {

		if(end == start) {
			return arr[end] == srch;
		}
		int mid = (start + end) / 2;
		
		if(srch <= arr[mid])
			return binarySearch(srch, start, mid);
		else
			return binarySearch(srch, mid + 1, end);
	
	}

}