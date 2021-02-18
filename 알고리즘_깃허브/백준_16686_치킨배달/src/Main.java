import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	static int totalDistance = Integer.MAX_VALUE;
	static int map[][];
	static int isSelected[];
	static ArrayList<int []> list = new ArrayList<>();
	static ArrayList<int []> house = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map= new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2)
					list.add(new int[] {i,j});
				if(map[i][j] == 1)
					house.add(new int[] {i,j});
					
			}
		}
		isSelected = new int[M];
		//System.out.println("ġŲ �� :"+list.size());
		
		comb(0,0);
		System.out.println(totalDistance);
		
		
	}
	
	static void comb(int cnt,int start) {
		if(cnt == M) {
			//�� ġŲ������ �ּ� �Ÿ� ���ϱ�
			int sum=0;
			for(int i=0,size = house.size();i<size;i++) {
				int min = Integer.MAX_VALUE;
				//int sum = 0;
				int house_arr[] = house.get(i);
//				System.out.println("�� ��ġ :=("+house_arr[0]+","+house_arr[1]+")");
				for(int j=0;j<M;j++) {
					int list_arr[] = list.get(isSelected[j]);
//					System.out.println("ġŲ�� ��ġ :=("+list_arr[0]+","+list_arr[1]+")");
					int distance = Math.abs(list_arr[0]-house_arr[0]) +  Math.abs(list_arr[1]-house_arr[1]);
					//System.out.println("�Ÿ� :"+distance);
					if(min>distance) min = distance; //���� ���̶� ���� ġŲ�� �߿��� ���� ª�� �Ÿ� ����
				}
				sum +=min; //��� ġŲ���̶� ���� ���ؼ� �Ÿ� ����
//				System.out.println("���� �� �Ÿ� :"+min);
			}
//			System.out.println("�� ª�� �Ÿ� :"+sum);
			//������ ġŲ�Ÿ��� �ּҰ� ���ϱ�
			if(totalDistance>sum) totalDistance = sum;
			return;
		}
		
		for(int i=start;i<list.size();i++) {
			isSelected[cnt] = i;
			comb(cnt+1,i+1);
		}
	}
}
