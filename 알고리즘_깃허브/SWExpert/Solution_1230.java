import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_1230 {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> list;
		StringTokenizer st;
		for(int t=0;t<10;t++) {
			int N = Integer.parseInt(br.readLine()); //원본 암호문의 길이
			list = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<N;i++)
				list.add(st.nextToken());
			
			/*1. I(삽입) x, y, s : 앞에서부터 x의 위치 바로 다음에 y개의 숫자를 삽입한다. s는 덧붙일 숫자들이다.[ ex) I 3 2 123152 487651 ]

			2. D(삭제) x, y : 앞에서부터 x의 위치 바로 다음부터 y개의 숫자를 삭제한다.[ ex) D 4 4 ]

			3. A(추가) y, s : 암호문의 맨 뒤에 y개의 숫자를 덧붙인다. s는 덧붙일 숫자들이다. [ ex) A 2 421257 796813 ]*/
			
			br.readLine(); //명령어의 개수
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				String  s = st.nextToken();
				
				switch (s) {
				case "I":
					int idx = Integer.parseInt(st.nextToken()); // 위치
					int num = Integer.parseInt(st.nextToken());
					for(int i=0;i<num;i++)
						list.add(idx+i, st.nextToken());
					break;

				case "D":
					int idx1 = Integer.parseInt(st.nextToken());
					int num1 = Integer.parseInt(st.nextToken());
					for(int i=0;i<num1;i++)
						list.remove(idx1+i);
					break;
				case "A":
					int num2 = Integer.parseInt(st.nextToken());
					for(int i=0;i<num2;i++)
						list.add(st.nextToken());
					break;
				}
			}
			
			System.out.print("#"+(t+1)+" ");
			for(int i=0;i<10;i++)
				System.out.print(list.get(i)+" ");
			System.out.println();
		}
		
		
	}

}
