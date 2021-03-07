import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int number[];
	static int operator[];
	static boolean isVisited[];
	static int max = Integer.MIN_VALUE,min = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
	
		number = new int[N]; //숫자 저장
		operator = new int[N-1]; //연산자 저장  덧셈,뺄셈,곱셈,나눗셈의 순서
		isVisited = new boolean[N-1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) number[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int idx = 0;

		for(int i=0;i<4;i++) {
			int num = Integer.parseInt(st.nextToken());
			for(int j=0;j<num;j++)
				operator[idx++] = i;
		}
		System.out.println(Arrays.toString(operator));
		
		//백트래킹하면서 확인하기
		dfs(0,0,number[0]); //첫번째 숫자 넣기
		System.out.println(max);
		System.out.println(min);
	}
	
	static void dfs(int back,int cnt,int res) {
		if(cnt == N-1) {
			min = min>res?res:min;
			max = max<res?res:max;
			return;
		}
		
//		for(int i=cnt;i<N-1;i++) {
//			//이거 연산자 넣어주면서 큰지 아닌지 확인하기
//			if(operator[i] == '+') dfs(cnt+1,res+number[cnt+1]);
//			else if(operator[i]=='-') dfs(cnt+1,res-number[cnt+1]);
//			else if(operator[i] =='*') dfs(cnt+1,res*number[cnt+1]);
//			else dfs(cnt+1,res/number[cnt+1]);
//		}
		for(int i=0;i<N-1;i++) {
			if(!isVisited[i]) {
				if(operator[i] == 0) {
					res = res + number[cnt+1];
				}
				else if(operator[i] == 1) {
					res = res - number[cnt+1];
				}
				else if(operator[i] == 2) {
					res = res * number[cnt+1];
				}
				else if(operator[i] == 3) {
					res = res / number[cnt+1];
				}
				isVisited[i] = true;
				dfs(i,cnt+1,res);
			}
		}
		isVisited[back] = false;
	}
}
