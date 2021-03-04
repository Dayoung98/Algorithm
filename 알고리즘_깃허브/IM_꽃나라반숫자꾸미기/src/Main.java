import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=0;t<T;t++) {
			String str = sc.next(); //꽃나라반 호수
			int arr[] = new int[10];
			int result = 0;
			
			for(int i=0;i<str.length();i++)
				arr[str.charAt(i)-'0'] ++;
			
			//System.out.println(Arrays.toString(arr));
			for(int i=0;i<10;i++) {
				if(i == 6 || i == 9) continue;
				result = Math.max(arr[i], result);
			}

			int sum = (arr[6]+arr[9])/2 + (arr[6]+arr[9])%2;
			result = Math.max(result, sum);
			System.out.println("#"+(t+1)+" "+result);
		}
	}
}
