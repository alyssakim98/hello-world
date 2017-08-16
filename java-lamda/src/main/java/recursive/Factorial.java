package recursive;

import static recursive.BigFactorial.decrement;
import static recursive.BigFactorial.multiply;
import static recursive.TailCalls.call;
import static recursive.TailCalls.done;

import java.math.BigInteger;

public class Factorial {

	/*
	public static int calculatefactorial(int number) {
		if( number == 1 ) {
			return number;
		}
		return number * calculatefactorial(number - 1); 
	}
	*/
	/*
	private static TailCall<Integer> calculateFactorial(int factorial, int number) {
		if( number == 1 ) {
			return done(factorial);
		}
		return call(() -> calculateFactorial(factorial * number, number - 1)); 
	}
	
	public static int factorial(int number) {
		return calculateFactorial(1, number).invoke();
	}
	*/
	
	private static TailCall<BigInteger> calculateFactorial(BigInteger factorial, BigInteger number) {
		if( number.equals(BigInteger.ONE) ) {
			return done(factorial);
		}
		return call(() -> calculateFactorial(multiply(factorial, number), decrement(number))); 
	}
	
	public static BigInteger factorial(BigInteger number) {
		return calculateFactorial(BigInteger.ONE, number).invoke();
	}
	

	
	
}
