import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int T,N;
	static int office[],house[];
	private static int seq[];
	static ArrayList<Node> customer = new ArrayList<>();
	static int shortestDistance;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine()); //test case 
		
		for(int t=0;t<T;t++) {
			shortestDistance = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine()); //고객 수
			seq = new int[N];
			st = new StringTokenizer(br.readLine());
			office = new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())}; //기사 회사 좌표
			house = new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())}; //기사 집 좌표
			for(int i=0;i<N;i++) {
				customer.add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()))); //고객 집 좌표 
			}
			
			/*System.out.println("회사 :"+Arrays.toString(office));
			System.out.println("고객 집");
			for(int i=0;i<customer.size();i++)
				System.out.println(customer.get(i).x+" "+customer.get(i).y);
			System.out.println("기사 집 :"+Arrays.toString(house));*/
			perm(0,0);
			System.out.println("#"+(t+1)+" "+shortestDistance);
			customer.clear();
		}
		
		//dfs?

	}
	
	private static void dfs() {
		int len = 0;
		//회사랑 첫번째 고객 사이 거리
		len += (Math.abs(office[0] - customer.get(seq[0]).x) + Math.abs(office[1]-customer.get(seq[0]).y));
		for(int i=0,size = seq.length-1;i<size;i++) {
			len += (Math.abs(customer.get(seq[i]).x - customer.get(seq[i+1]).x) + Math.abs(customer.get(seq[i]).y - customer.get(seq[i+1]).y));
			if(len>shortestDistance) break;
		}
		len += (Math.abs(house[0] - customer.get(seq[seq.length-1]).x) + Math.abs(house[1]-customer.get(seq[seq.length-1]).y));
		shortestDistance = (shortestDistance>len)?len:shortestDistance;
		//System.out.println("최단 거리 :"+shortestDistance);
		return;
	}
	
	private static void perm(int cnt,int flag) {
		//비트 마스킹 이용해서 순열 구하기
		if(cnt == N) {
			/*System.out.println("현재 방문 순서");
			System.out.println(Arrays.toString(seq));*/
			dfs();
			return;
		}
		
		for(int idx=0;idx<N;idx++) {
			if((flag & 1<<idx )!=0) continue;
			seq[cnt] = idx;
			perm(cnt+1,flag|1<<idx);
		}
	}
	
	static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
