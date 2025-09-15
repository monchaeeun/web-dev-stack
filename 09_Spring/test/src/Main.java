import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws Exception{
	
		//버퍼로 읽기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		
		while((line = br.readLine()) != null) {
			System.out.println(line);
		}
		
		Scanner sc = new Scanner(System.in);
		
		//버퍼로 쓰기
		BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
		for(int i = 1; i <= 1000; i++)
		{
			bw.write(sc.nextLine());
			bw.newLine();
		}
				
		
	}
}
