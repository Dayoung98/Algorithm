import java.util.Scanner;
import java.util.Stack;

public class Solution_5432 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Stack<Character> stack = new Stack<>();
		int TC = sc.nextInt();
		
		for(int t=0;t<TC;t++) {
			int sum = 0;
			String str = sc.next();
			for(int i=0;i<str.length();i++) {
				if(str.charAt(i) == '(' && str.charAt(i+1)==')') {
					//레이저면
					sum += stack.size();
					i = i+1;
				}else if(str.charAt(i)=='(') {
					//레이저는 아니고 그냥 (
					stack.push('(');
				}else if(str.charAt(i) ==')'){
					//닫는 버튼 나오면
					sum = sum+1; //1씩 더해주고
					stack.pop(); //레이저 하나 끝나니까 레이저 하나 뺴주기
				}
			}
			
			System.out.println("#"+(t+1)+" "+sum);
		}
	}
}
