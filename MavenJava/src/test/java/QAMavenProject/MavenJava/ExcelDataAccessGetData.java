package QAMavenProject.MavenJava;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ExcelDataAccessGetData {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ExcelDataAccess d = new ExcelDataAccess();
		
		ArrayList data = d.getData("testData", "TestCases" , "Add Profile");
		
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2));
		
		

	}//main

}//class
