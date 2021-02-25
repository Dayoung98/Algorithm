import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		str = str.replace("c=", "0");
		str = str.replace("c-", "1");
		str = str.replace("dz=", "2");
		str = str.replace("d-", "3");
		str = str.replace("lj", "4");
		str = str.replace("nj", "5");
		str = str.replace("s=", "6");
		str = str.replace("z=", "7");
		
		System.out.println(str.length());
		
	}
}
