import java.util.Scanner;

public class Main {

	static char arr[];
	static boolean isVisited[];
	static int result;
	static int size;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		size = str.length();
		arr = new char[size];
		isVisited = new boolean[size];
		
		for(int i=0;i<size;i++) arr[i] = str.charAt(i);
		
		dfs(0,0,"");
		System.out.println(result);
	}
	
	static void dfs(int cnt,int start,String str) {
		if(cnt == size) {
			System.out.println(str);
			result++;
			return;
		}
		
		for(int i=start;i<size;i++) {
			String str1 = str+arr[i];
			if(isPossible(str1)) dfs(cnt+1,i+1,str1);
		}
	}

	static boolean isPossible(String str) {
		int len = str.length();
		for(int i=0;i<len-1;i++) {
			if(str.substring(i, i+1).equals(str.substring(i+1, i+2))) return false;
		}
		
		return true;
	}
}
