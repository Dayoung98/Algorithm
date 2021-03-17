import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int L,C;
	static char arr[];
	static char pwd[];
	static boolean isVisited[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		pwd = new char[L];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<C;i++) arr[i] = st.nextToken().charAt(0);
		Arrays.sort(arr);
		
		for(int i=0;i<=C-L;i++) {
			isVisited = new boolean[26];
			dfs(i,1,""+arr[i]);
		}
		System.out.println(sb);
	}
	
	 static void dfs(int v, int cnt, String s) {
		isVisited[arr[v]-'a'] = true;
		
		if(cnt == L) {
			if(isPossible()) sb.append(s+"\n");
		}
		
		for(int i=v+1;i<C;i++) {
			if(!isVisited[arr[i]-'a']) dfs(i,cnt+1,s+arr[i]);
		}
		
		isVisited[arr[v]-'a'] = false;
	}
	
	static boolean isPossible() {
		int mo = 0;
		int pwd = 0;
		
		if(isVisited[0]) ++mo;
		if(isVisited[4]) ++mo;
		if(isVisited[8]) ++mo;
		if(isVisited[14]) ++mo;
		if(isVisited[20]) ++mo;
		
		for(int i=0;i<26;i++) {
			if(i ==0 || i==4 || i==8 || i==14 || i== 20) continue;
			
			if(isVisited[i]) ++pwd;
		}
		
		if(mo>0 && pwd>1) return true;
		
		return false;
	}
}
