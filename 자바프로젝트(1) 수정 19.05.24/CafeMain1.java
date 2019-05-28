package project_sample1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class CafeMain1 extends Thread{

	public static void main(String[] args){
        	
		CafeImpl1 ob = new CafeImpl1(); 
		int ch;

			try {
				
				FileInputStream fis = new FileInputStream("d:\\doc\\cafe1.txt");
				BufferedReader br = new BufferedReader(new InputStreamReader(fis));
				
				int data;
				char ch1;
				
				while ((data = br.read()) != -1) {
		             
					ch1 = (char)data;
					
					System.out.print(ch1);
					
					//sleep(1000);
					/*my.start();
					my.join();*/
				}fis.close();
				ob.mainMenu();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	
	
