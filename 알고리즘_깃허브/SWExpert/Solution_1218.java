import java.util.Scanner;
import java.util.Stack;

public class Solution_1218 {

	public static void main(String[] args) {
		Stack<Character> left = new Stack<>();
		Scanner sc = new Scanner(System.in);
		int isTrue=0;
		
		for(int i=0;i<10;i++) {
			int len = sc.nextInt();
			
			String str = sc.next();
			for(int j=0;j<str.length();j++) {
				char c = str.charAt(j);
				//System.out.print("들어온 문자 :"+c);
				if(c == '(' || c=='[' || c=='{' || c=='<') {
					left.push(c);
					//System.out.println("\t넣은 문자 :"+left.peek());
				}
				else {
					//System.out.println("\t뺄 문자 :"+left.peek());
					if(left.isEmpty()) {
						left.push('x');
						break;
					}
					if(c ==')' && left.peek()=='(')
						left.pop();
					else if(c ==']' && left.peek()=='[')
						left.pop();
					else if(c =='}' && left.peek()=='{') 
						left.pop();
					else if(c =='>' && left.peek()=='<')
						left.pop();
					else
						break;
				}
			}

			if(left.empty())
				System.out.println("#"+(i+1)+" "+1);
			else
				System.out.println("#"+(i+1)+" "+0);
			left.clear();
		}
		
		sc.close();
		
	}
}
