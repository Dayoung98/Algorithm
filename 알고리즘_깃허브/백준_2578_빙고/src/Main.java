import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int map[][] = new int[5][5];
	static int result=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i=0;i<5;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}//�迭 �Է�
		int num = 5;
		while(num>0) {
			st = new StringTokenizer(br.readLine());
			int arr[] = new int[5];
			for(int i=0;i<5;i++)
				arr[i] = Integer.parseInt(st.nextToken());
			
			for(int i=0;i<5;i++) {
				for(int j=0;j<5;j++) {
					if(map[i][j] == arr[i]) {
						map[i][j] = 0;
						result++;
						break;	
					}
				}
			}
			num--;
		}
	}
	
	static void findBingo() {
		//�������� �����ϴ���
		for(int i=0;i<5;i++) {
			
		}
		
		//�������� �����ϴ���
		
		
		//�밢������ �����ϴ���
	}
}
