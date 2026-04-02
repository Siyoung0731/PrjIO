package ex05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class Zipcode4 {

	public static void main(String[] args) throws IOException {
		// ZIPCODE,SIDO,GUGUN,DONG,BUNJI,SEQ	
		
		// 키보드
		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 시도를 입력하세요(부산, 대구, 경남)");
		String sidos = sc.nextLine(); // 부산, 대구, 경남
		String[] sis = sidos.trim().split(",");
		String [] sidoList = new String[sis.length];
		int [] ctr = new int[sis.length];
		
		for (int i = 0; i < sidoList.length; i++) {
			sis[i] = sis[i].trim();
			sidoList[i] = sis[i];
			ctr[i] = 0;
		}

		//File
		String path = Zipcode4.class.getResource("").getPath(); //현재 주소 
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
		
		// 3. 부산, 울산, 대구 우편번호
		//부산:3605 ctr[0]
		//대구:2782 ctr[1]
		//경남:820 ctr[2]
		
		while ((line = br.readLine()) != null) {
			String[] li = line.trim().split(",");
			String zipcode = li[0].trim();
			String sido = li[1].trim();
			String gugun = li[2].trim();
			String dong = li[3].trim();
			String bunji = li[4].trim();
			int seq = Integer.parseInt(li[5].trim());
					
			for (int i = 0; i < sis.length; i++) {
				if (sido.equals(sis[i])) {		
					ctr[i] ++;
				}
			}
			for (int i = 0; i < sis.length; i++) {
				System.out.println(sis[i] + ":" + ctr[i] + "건");
			}
		}
		br.close();
		fr.close();
	}
}
