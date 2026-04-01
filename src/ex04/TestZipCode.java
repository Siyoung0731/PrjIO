package ex04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TestZipCode {
	public static void main(String[] args) throws IOException {
		String path = "D:/dev/우편번호/old/";
		String fname = "zipcode_20130201(1).csv";
		
		FileReader fr = new FileReader(path + fname);
		BufferedReader br = new BufferedReader(fr);
		
		String fname2 = "zipcode.txt";
		FileWriter fw = new FileWriter(path + fname2);
		BufferedWriter bw = new BufferedWriter(fw);
		
		String line = "";
		br.readLine();
		while ((line = br.readLine()) != null) {
			Scanner sc = new Scanner(System.in);		
			String [] li = line.trim().split(",");
			String zipcode = li[0].trim();
			String sido = li[1].trim();
			String gugun = li[2].trim();
			String dong = li[3].trim();
			String bunji = li[4].trim();
			String seq = li[5].trim();
	 
			String fmt = "%s %s %s %s %s %s";
			String msg = String.format(fmt, zipcode, sido, gugun, dong,
					bunji, seq);
			bw.write(msg);
		} 
		
		br.close();
		bw.close();
		fr.close();
		fw.close();
	}

}
