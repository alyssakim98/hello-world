package recursive;

import java.math.BigInteger;

public class FactorialTest implements Runnable {

	//private final BigInteger ONE = BigInteger.ONE;
	private final BigInteger FIVE = new BigInteger("5");
	private final BigInteger TWENTYK = new BigInteger("20000");
	
	
	public static void main(String[] args) {
		Thread thread = new Thread(new FactorialTest());
		thread.start();
	}

	@Override
	public void run() {
		/*
		System.out.println(Factorial.calculateFactorial(5));
		System.out.println(Factorial.calculateFactorial(20000));
		*/
		/*
		System.out.println(Factorial.calculateFactorial(1, 5).invoke());
		System.out.println(Factorial.calculateFactorial(1, 20000).invoke());
		*/
		/*
		System.out.println(Factorial.factorial(5));
		System.out.println(Factorial.factorial(20000));
		*/
		
		System.out.println(Factorial.factorial(FIVE));
		System.out.println(String.format("%.10s...", Factorial.factorial(TWENTYK)));
		
	}

}
