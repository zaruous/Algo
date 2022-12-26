import java.io.*;
import java.util.*;

public class 영상압축 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static char MAP[][];
	
	static boolean isSame(int row, int col, int size) { 
		//row,col에서부터 size크기만큼 전부 같은 data인가? 
		for(int i = row; i < row + size; i++)
			for(int j = col; j < col + size; j++)
				if(MAP[i][j] != MAP[row][col])
					return false;
		return true;
	}
	
	static void func(int row, int col, int size) {
		if(isSame(row, col, size)) {
			System.out.print(MAP[row][col]);
		}
		else {
			System.out.print('(');
			for(int r = row; r < row + size; r += size/2)
				for(int c = col; c < col + size; c += size/2)
					func(r, c, size / 2);
			System.out.print(')');
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int size = Integer.parseInt(br.readLine());
		MAP = new char[size][size];
		for(int i = 0; i < size; i++)
		{
			String temp = br.readLine();
			for(int j = 0; j < size; j++)
				MAP[i][j] = temp.charAt(j);
		}
		func(0,0,size);
	}

}