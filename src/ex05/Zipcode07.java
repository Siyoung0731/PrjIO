package ex05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Zipcode07 {

	public static void main(String[] args) {
		// 7. 부산 부산진구의 우편번호를 파일( .csv )로 출력
		String path = Zipcode07.class.getResource("").getPath();
		String inFname = "zipcode_utf8(1).csv";
		String outFname = "zipcode_busanjin.csv";
		
		FileReader fr = null;
		FileWriter fw = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			fr = new FileReader(path + inFname);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) fr.close(); {			
				}				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		br = new BufferedReader(fr);

		try {
			br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String line = "";
		try {
			while ((line = br.readLine()) != null) {
				PostVo pvo = new PostVo(line);
				String sido = pvo.getSido();
				String gugun = pvo.getGugun();
				
				if (sido.equals("부산")) {
					if (gugun.contains("진구")) {
						String result = pvo.getAddress();
						System.out.println(result);
						bw.write(result + "\n");
					} 
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}


