package ex05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class Zipcode2 {

	public static void main(String[] args) throws IOException {
		// ZIPCODE,SIDO,GUGUN,DONG,BUNJI,SEQ
		// 2. (읍면동 건물명: 입력 받아 출력
		
		// 키보드 입력
		Scanner sc = new Scanner(System.in);
		
		String path = Zipcode2.class.getResource("").getPath(); //현재 주소 
		String fname = "zipcode_utf8(1).csv";
		File file = new File(path + fname);
		
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		String title = br.readLine(); //제목줄 skip
		String line = "";
		int ctr = 0;
		
		System.out.println("읍면동 건물명:");
		String inAddr = sc.nextLine(); // inAddr 변수에 읍면동 건물명 입력 받기
				
		while ((line = br.readLine()) != null) {
			String[] li = line.trim().split(",");
			String zipcode = li[0].trim();
			String sido = li[1].trim();
			String gugun = li[2].trim();
			String dong = li[3].trim();
			String bunji = li[4].trim();
			int seq = Integer.parseInt(li[5].trim());

			// indexOf : 문자열에서 위치 찾기
			// contains : 문자열에서 특정 문자열 포함되어 있는지 true, false 로 반환
			// 2. (읍면동 건물명: 입력 받아 출력
			if ( dong.contains(inAddr) ) { // dong 변수에 입력 받은 inAddr이 있는지 확인 후 전체 출력
				String fmt = "[%s] %s %s %s %s %d\n";				
				String addr = String.format(fmt, zipcode, sido, gugun, dong, bunji, seq);
				System.out.print(addr);
				ctr++;
			}
		}
		System.out.println(ctr + "건");
		
		
		br.close();
		fr.close();

	}

}
