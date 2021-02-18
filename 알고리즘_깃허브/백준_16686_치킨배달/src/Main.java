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
		//System.out.println("치킨 집 :"+list.size());
		
		comb(0,0);
		System.out.println(totalDistance);
		
		
	}
	
	static void comb(int cnt,int start) {
		if(cnt == M) {
			//고른 치킨집으로 최소 거리 구하기
			int sum=0;
			for(int i=0,size = house.size();i<size;i++) {
				int min = Integer.MAX_VALUE;
				//int sum = 0;
				int house_arr[] = house.get(i);
//				System.out.println("집 위치 :=("+house_arr[0]+","+house_arr[1]+")");
				for(int j=0;j<M;j++) {
					int list_arr[] = list.get(isSelected[j]);
//					System.out.println("치킨집 위치 :=("+list_arr[0]+","+list_arr[1]+")");
					int distance = Math.abs(list_arr[0]-house_arr[0]) +  Math.abs(list_arr[1]-house_arr[1]);
					//System.out.println("거리 :"+distance);
					if(min>distance) min = distance; //현재 집이랑 여러 치킨집 중에서 가장 짧은 거리 저장
				}
				sum +=min; //모든 치킨집이랑 집에 대해서 거리 저장
//				System.out.println("현재 집 거리 :"+min);
			}
//			System.out.println("젤 짧은 거리 :"+sum);
			//도시의 치킨거리의 최소값 구하기
			if(totalDistance>sum) totalDistance = sum;
			return;
		}
		
		for(int i=start;i<list.size();i++) {
			isSelected[cnt] = i;
			comb(cnt+1,i+1);
		}
	}
}
