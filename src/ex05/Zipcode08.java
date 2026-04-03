package ex05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Zipcode08 {

	public static void main(String[] args) {
		// 8. 	 zipcode_utf8.csv
//		   -> 서울.csv
//		      부산.csv
//		      
//		      ...
//		      충북.csv   
		String path = Zipcode08.class.getResource("").getPath();
		String inFname = "zipcode_utf8(1).csv";
		String outFname = "zipcode_busanjin.csv";
		
		FileReader fr = null;
		BufferedReader br;
		try {
			fr = new FileReader(path + inFname);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		br = new BufferedReader(fr);
		
		try {
			br.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
