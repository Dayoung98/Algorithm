import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1220 {

	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int t=0;t<10;t++) {
			br.readLine(); //테이블 면의 갯수
			arr = new int[100][100];
			for(int i=0;i<100;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<100;j++)
					arr[i][j] = Integer.parseInt(st.nextToken());
			}//배열 입력
			
			
			
			
			
			System.out.println("#"+(t+1));
		}
	}
}
