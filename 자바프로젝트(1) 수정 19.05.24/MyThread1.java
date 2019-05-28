package project_sample1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MyThread1 extends Thread{

	@Override
	public void run() {
	
		try {
			List<String> lists = new ArrayList<String>();
			
			FileInputStream fis = new FileInputStream("d:\\doc\\tiket.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
				
			int data;
				String n;
				char ch;
				
				while ((data = br.read()) != -1) {
		             
					ch = (char)data;
					
					System.out.print(ch);	
					
					 try {		
						 sleep(1); 
					} catch (Exception e) {
						
					}       			
				}fis.close();
	
		} catch (Exception e) {
			
		}
	}
	
}
