import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		int arr[] = new int[T];
		int max = Integer.MIN_VALUE;
		for(int t=0;t<T;t++) {
			arr[t] = sc.nextInt();
			if(max<arr[t]) max = arr[t];
		}
		
		int d[] = new int[max+1];
		d[0] = 0;
		if(max>=1) d[1] =1;
		if(max>=2) d[2] =2;
		if(max>=3) d[3] =4;
		
		for(int i=4;i<=max;i++) {
			d[i] = d[i-1] + d[i-2] + d[i-3];
		}
		//System.out.println(Arrays.toString(d));
		for(int t=0;t<T;t++) System.out.println(d[arr[t]]);
	}
}
