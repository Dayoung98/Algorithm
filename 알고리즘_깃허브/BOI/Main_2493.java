import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main_2493 {
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		Stack<int []> stack = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			int height = Integer.parseInt(st.nextToken());
			while(!stack.isEmpty()) {
				if(stack.peek()[1] >=height) {
					System.out.print(stack.peek()[0]+" ");
					break;
				}
				stack.pop();
			}
			
			if(stack.isEmpty()) {
				System.out.print("0 ");
			}
			stack.push(new int[] {i+1,height});
		}
		
	}

}
