package ex05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Zipcode01 {

	public static void main(String[] args) throws IOException {
		// ZIPCODE,SIDO,GUGUN,DONG,BUNJI,SEQ
		String path = Zipcode01.class.getResource("").getPath(); //현재 주소 
		String fname = "zipcode_utf8(1).csv";
		File file = new File(path + fname);
		
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		String title = br.readLine(); //제목줄 skip
		String line = "";
		
		int ctr = 0;
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
			//1. 전국의 롯데백화점의 갯수 출력 
			//if ( dong.contains("롯데백화점") ) {
			if ( dong.indexOf("현대백화점") > -1 ) {
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
