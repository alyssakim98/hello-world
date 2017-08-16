package app;

import java.util.function.Supplier;

import data.Heavy;

/**
 * Lazy
 * Virtual proxy pattern
 * Lazy instance thread safety
 *
 */
public class Holder implements Runnable {
	
	private Supplier<Heavy> heavy = () -> createAndCacheHeavy();

	public static void main(String[] args){
		Thread thread = new Thread(new Holder());
		thread.start();
	}
	
	public Holder(){
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
	
	public Heavy getHeavy(){
		return heavy.get();
	}
	
	public synchronized Heavy createAndCacheHeavy(){
		class HeavyFactory implements Supplier<Heavy>{
			private final Heavy heavyInstance = new Heavy();
			public Heavy get() {
				return this.heavyInstance;
			}
		}
		if( !HeavyFactory.class.isInstance(heavy)){
			heavy = new HeavyFactory();
		}
		return heavy.get();
		
	}
}
