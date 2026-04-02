package ex05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Zipcode05_3 {

	public static void main(String[] args) throws IOException {
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
		
		FileReader fr = new FileReader(inFile);
		BufferedReader br = new BufferedReader(fr); // readLine은 Buffer 에만 있다	
		
		br.readLine(); // 제목줄 skip
		String line = "";
		
		while ((line = br.readLine()) != null) {
			PostVo vo = new PostVo(line);			
			String dong = vo.getDong();
			int seq = vo.getSeq();
			if (dong.contains("부전2동")) {
				System.out.println(seq);
			}
		}	

		br.close();
		fr.close();
	}

}
