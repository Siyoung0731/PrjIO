package ex05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Zipcode05_4 {

	public static void main(String[] args) throws IOException {
		//		4. 한국의 시도명 출력 - 17건 
		//		   서울 8080
		//		   부산 3605
		//		   ... 
		//		   충북
		
		List<String> sList = new ArrayList<>();
		List<Integer> sidoctrList = new ArrayList<>();
		
		//file
		String path = Zipcode05_4.class.getResource("").getPath();
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
		int tct = 0; //전체 자료수
		int pos = -1; // 시도 갯수
		int sidoctr = 0; // 시도별 주소 수
		String prevSido = "";
		
		while ((line = br.readLine()) != null) {
			PostVo vo = new PostVo(line);
			String sido = vo.getSido();
			
			if (!sido.equals(prevSido)) {
				sList.add(sido); //sList 에 추가 sList[0] 서울
				sidoctrList.add(1); //sidoctrList 에 추가
				prevSido = sido; //이전 주소를 현재 주소로 변경
//				System.out.println(sido);
				pos++; // 시도 수
			} else {
				sidoctr = sidoctrList.get(pos) + 1; // 시도별 주소 수
				sidoctrList.set(pos, sidoctr); 			
			}
			tct++;	
		}	
		
		br.close();
		fr.close();
		
		for (int i = 0; i < sList.size(); i++) {
			System.out.println(sList.get(i) + "=" + sidoctrList.get(i));
		}
		System.out.println("도시 수: " + (pos + 1));
		System.out.println("전체 자료수: " + tct);
		}
	}


