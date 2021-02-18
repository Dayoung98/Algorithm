import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	static Queue<int []> queue;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0;t<T;t++) {
			queue = new LinkedList<>();
			int p = sc.nextInt();
			int q = sc.nextInt();
			
			findNumber(p);
			findNumber(q); // 두 개 좌표 구하기
			
			int x=0,y=0;
			while(!queue.isEmpty()) {
				int arr[] = queue.poll();
				x += arr[0];
				y += arr[1];
			}
			
			//System.out.println("x = "+x+" y = "+y);
			int startPoint = 1;
			int result = 1;
			while(true) {
				if(startPoint == x)
					break;
				startPoint++;
				result = result + startPoint;
			}
			
			//System.out.println("x축 :"+startPoint+" result :"+result);
			int endPoint = 1;
			while(true) {
				if(y == endPoint)
					break;
				result = result + startPoint;
				startPoint++;
				endPoint++;
			}
			System.out.println("#"+(t+1)+" "+result);
		}
	}
	
	static void findNumber(int num) {
		int find = 1;
		int startNum = 1;
		while(startNum<num) {
			find++;
			startNum += find;
		}
		
		startNum = startNum - find +1;
		int x= 1, y = find;
		while(true) {
			if(startNum == num)
				break;
			x++;
			y--;
			startNum++;
		}
		//System.out.println(num+"의 좌표 : ("+x+","+y+")");
		queue.offer(new int[] {x,y});
	}
}
