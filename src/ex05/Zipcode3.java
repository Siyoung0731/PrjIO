package ex05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class Zipcode3 {

	public static void main(String[] args) throws IOException {
		// ZIPCODE,SIDO,GUGUN,DONG,BUNJI,SEQ	
			
		//File
		String path = Zipcode3.class.getResource("").getPath(); //현재 주소 
		String fname = "zipcode_utf8(1).csv";
		File file = new File(path + fname);
		if(!file.exists()) {
			System.out.println(file + "이 없습니다");
			System.exit(-1); // 프로그램 강제 종료
		}
		
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		String title = br.readLine(); //제목줄 skip
		String line = "";
		int ctr = 0;
		
		// 3. 부산, 울산, 대구 우편번호
		//부산:3605 ctr1
		//대구:2782 ctr2
		//울산:820 ctr3
		int ctr1 = 0;	//부산
		int ctr2 = 0;	//대구
		int ctr3 = 0;	//울산
			
		while ((line = br.readLine()) != null) {
			String[] li = line.trim().split(",");
			String zipcode = li[0].trim();
			String sido = li[1].trim();
			String gugun = li[2].trim();
			String dong = li[3].trim();
			String bunji = li[4].trim();
			int seq = Integer.parseInt(li[5].trim());
			
//			부산:3605 ctr1
//			대구:2782 ctr2
//			울산:820 ctr3			
			switch(sido) {
				case "부산": ctr1++; break;
				case "대구": ctr2++; break;
				case "울산": ctr3++; break;
			}
		}
		System.out.println("부산: " + ctr1 + "건");
		System.out.println("대구: " + ctr2 + "건");
		System.out.println("울산: " + ctr3 + "건");
		
		
		br.close();
		fr.close();

	}

}
