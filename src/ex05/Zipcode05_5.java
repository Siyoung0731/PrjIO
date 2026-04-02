package ex05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
//Map 사용해서 시도명과 시도별 갯수 구하기
interface Ipo {
	void input(String fname) throws IOException;
	void process();
	void output();
}

class ZipcodeMap implements Ipo {
	
	FileReader fr;
	BufferedReader br;
	
	Map<String, Integer> sidoMap = new HashMap<>();
	int totCnt = 0;
	
	@Override
	public void input(String fname) throws IOException {
		
		fr = new FileReader(fname);
		br = new BufferedReader(fr);
		
		br.readLine();
		String line = "";
		//map put
		while ((line = br.readLine()) != null) {
			PostVo vo = new PostVo(line);
			String sido = vo.getSido();
			
			sidoMap.put(sido, sidoMap.getOrDefault(sido, 0) + 1);
			totCnt++;
		}
		
		br.close();
		fr.close();
	}
	@Override
	public void process() {
		
	}
	@Override
	public void output() {
		for (Map.Entry<String, Integer> sidoList : sidoMap.entrySet()) {
			String key = sidoList.getKey();
			Integer val = sidoList.getValue();
			
			System.out.println(key + "=" + val);
		}
		System.out.println("총" + totCnt + "건");
	}
}

public class Zipcode05_5 {
	//Map 사용
	public static void main(String[] args) throws IOException {
		String path = ZipcodeMap.class.getResource("").getPath();
		String fname = "zipcode_utf8(1).csv";
		ZipcodeMap zMap = new ZipcodeMap();
		
		zMap.input(path + fname);
		zMap.process();
		zMap.output();
	}
}

