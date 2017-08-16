package app;

import data.defaultif.SeaPlane;

public class DefaultMethodTest implements Runnable {

	public static void main(String[] args){
		Thread thread = new Thread(new DefaultMethodTest());
		thread.start();
	}

	@Override
	public void run() {
		SeaPlane plane = new SeaPlane();
		plane.takeOff();
		plane.turn();
		plane.cruise();
		plane.land();
	}
}
