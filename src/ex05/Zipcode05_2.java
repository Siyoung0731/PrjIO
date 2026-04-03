package ex05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//ZIPCODE,SIDO,GUGUN,DONG,BUNJI,SEQ
//1. 전국의 롯데백화점의 갯수 출력
//2. (읍면동 건물명: 입력 받아 출력
//3. 부산, 울산, 대구 우편번호
//	부산:3605
//	대구:820
//	울산:2782
//	5. 한국의 시도명 우편번호 출력 - 17건 
//	   서울 8080
//	   부산 3605
//	   ... 
//	   충북
//Post class 확인
//zipcode_utf8.csv 읽어서
//시도별 우편번호(주소) 갯수를 출력
//Fields
//6. 부산의 부전2동 우편번호만 화면 출력
//7. 부산 부산진구의 우편번호를 파일( .csv )로 출력
//8. 	 zipcode_utf8.csv
//	   -> 서울.csv
//	      부산.csv
//	      
//	      ...
//	      충북.csv      
public class Zipcode05_2 {

	public static void main(String[] args) throws IOException {
		//		4. 한국의 시도명 출력 - 17건 
		//		   서울 8080
		//		   부산 3605
		//		   ... 
		//		   충북
		String path = Zipcode05_2.class.getResource("").getPath();
		String fname = "zipcode_utf8(1).csv";
		File inFile = new File(path + fname);
		if(!inFile.exists()) {
			System.out.println(fname + "이 없습니다.");
			System.exit(-1);
		}
		
		FileReader fr = new FileReader(inFile);
		BufferedReader br = new BufferedReader(fr); // readLine은 Buffer 에만 있다
				
		br.readLine(); // 제목줄 skip
		String line = "";
		int tct = 0;
		String prevSido = "";
		
		long startTime = System.nanoTime(); // 시작 시간
		
		int ctr = 0;	
		while ((line = br.readLine()) != null) {
			PostVo vo = new PostVo(line);
			String sido = vo.getSido();
			if (!sido.equals(prevSido)) {
				prevSido = sido;
				System.out.println(sido);
				ctr++;
			}
			//System.out.println(vo.toString());
			tct++;	
		}		
		long endTime = System.nanoTime(); // 끝 시간
		double exectTime = (endTime - startTime)/1000.0/1000.0/1000.0; // 실행 시간 = 시작시간 - 끝시간
		br.close();
		fr.close();
		
		System.out.println("도시 수: " + ctr);
		System.out.println("전체 자료수: " + tct);
		System.out.println("실행시간: " + exectTime + "s");
	}

}
