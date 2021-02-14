import java.util.Scanner;
import java.util.Stack;

public class Solution_1223 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		for(int t=0;t<10;t++) {
			int sum = 0;
			
			
			
			int N = sc.nextInt(); //tc ����
			String str = sc.next();

			for(int i=0;i<str.length();i++) {
				if(str.charAt(i)=='*') {
					if(stack.isEmpty()) {
						//������� �׳� push
						stack.push(1); //���ϱ�� 1�� ǥ��
						//System.out.print(stack.peek());
					}
					else {
						//�Ⱥ������
						if(stack.peek() == 0) {
							stack.push(1);
							//System.out.print(stack.peek());
						}
						else {
							stack.pop();
							sb.append('*');
							stack.push(1);
							//System.out.print(stack.peek());
						}
					}
					
				}
				
				else if(str.charAt(i) =='+') {
					if(stack.isEmpty()) {
						stack.push(0);
						//System.out.print(stack.peek());
					}
					else {
						sb.append(stack.peek()==1?'*':'+');
						stack.pop();
						stack.push(0);
						//System.out.print(stack.peek());
					}
				}
				else
					sb.append(str.charAt(i));
			}//���� ǥ������� �ٲ�
			
			//System.out.println();
			//System.out.println(stack.size());
			while(!stack.isEmpty()) {
				char c1 = stack.peek()==0?'+':'*';
				stack.pop();
				sb.append(c1);
			}
			//System.out.println(sb.toString());
			
			Stack<Integer> number = new Stack<>();
			for(int i=0;i<sb.length();i++) {
				if(sb.charAt(i)=='+') {
					int n1 = number.pop();
					int n2 = number.pop();
					number.push(n1+n2);
				}
				else if(sb.charAt(i)=='*') {
					int n1 = number.pop();
					int n2 = number.pop();
					number.push(n1*n2);
				}
				else {
					String s = Character.toString(sb.charAt(i));
					number.push(Integer.parseInt(s));
				}
			}
			System.out.println("#"+(t+1)+" "+number.peek());
			
		}
	}
}
