package ex05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Zipcode05_3 {

	public static void main(String[] args) {
		//		4. 한국의 시도명 출력 - 17건 
		//		   서울 8080
		//		   부산 3605
		//		   ... 
		//		   충북
		String path = Zipcode05_3.class.getResource("").getPath();
		String fname = "zipcode_utf8(1).csv";
		File inFile = new File(path + fname);
		if(!inFile.exists()) {
			System.out.println(fname + "이 없습니다.");
			System.exit(-1);
		}
		
		FileReader fr = null;
		BufferedReader br = null;

		// 기본 공식 try-catch
		try {
			fr = new FileReader(inFile);
			br = new BufferedReader(fr); // readLine은 Buffer 에만 있다	
			
			//6. 부산의 부전2동 우편번호만 화면 출력
			br.readLine(); // skip;
			String line = "";
			
			while ((line = br.readLine()) != null) {
				PostVo vo = new PostVo(line);	
				String sido = vo.getSido();
				String dong = vo.getDong();
				int seq = vo.getSeq();
				if (sido.contains("부산") && dong.contains("부전2동")) {		
						System.out.println(vo);							
				}
			}
				
		} catch (FileNotFoundException e) {
			System.out.println(inFile + "파일이 없습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("데이터 입력에 문제가 있습니다.");
		} catch (Exception e) {
			System.out.println("문제 발생" + e.getMessage());
		}
		finally { //Exception 발생과 상관없이 무조건 실행
			try {
				if(br != null) br.close();
				if(fr != null) fr.close();
		} catch (IOException e) {
			
			}
		}
	}

}
