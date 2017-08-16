package recursive;

import java.math.BigInteger;

public class BigFactorial {
	
	public static BigInteger decrement(BigInteger number) {
		return number.subtract(BigInteger.ONE);
	}
	
	public static BigInteger multiply(BigInteger first, BigInteger second) {
		return first.multiply(second);
	}
}
