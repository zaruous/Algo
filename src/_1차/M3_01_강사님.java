package _1차;
import java.io.*;
import java.util.*;

/**

6
3 5 4 6 2 9
0 5
 

 * @author KYJ (zaruous@naver.com)
 *
 */
public class M3_01_강사님 {
	// 항상 PS에서 꼭 넣고 시작하는 코드
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st; // <- 특정 기준을 통해 문자열을 자르는 역할
	
	static int e;
	static int arr[];
	
	static void func(int now) {
		if(now == e) {
			//끝점(반환점)을 1번 출력
			System.out.print( arr[now] + " " );
			return;
		}
		// 가면서 출력
		System.out.print( arr[now] + " " );
		func(now + 1);
		// 돌아오면서 출력
		System.out.print( arr[now] + " " );
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		func(s);
		
	}
}