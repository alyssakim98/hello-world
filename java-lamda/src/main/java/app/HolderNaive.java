package app;

import data.Heavy;

public class HolderNaive implements Runnable {
	
	private Heavy heavy = null;

	public static void main(String[] args){
		Thread thread = new Thread(new HolderNaive());
		thread.start();
	}
	
	public HolderNaive(){
		System.out.println("Holder created.");
	}

	@Override
	public void run() {
		try {
			System.out.println("deferring heavy creation...");
			System.out.println(getHeavy());
			System.out.println(getHeavy());
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public synchronized Heavy getHeavy(){
		if(heavy == null){
			heavy = new Heavy();
		}
		return heavy;
	}
}
