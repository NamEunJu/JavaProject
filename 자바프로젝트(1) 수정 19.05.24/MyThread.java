package project_sample1;

public class MyThread extends Thread{

	@Override
	public void run() {
		
		synchronized(this){
			
		}
		
		try {
			String n = ".";
			try {
				for (int i = 0; i < 10; i++) {
					System.out.print(n); //9°³
					Thread.sleep(100);
				}
				System.out.println();
			} catch (Exception e) {
			}	
		} catch (Exception e) {
		}
	}
	
}
