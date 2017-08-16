package data;

import java.math.BigDecimal;
import java.util.function.Function;

public class Navigator {

	private Function<String, BigDecimal> _priceFinder;
	
	public Navigator(Function<String, BigDecimal> priceFinder){
		_priceFinder = priceFinder;
	}
	
	public BigDecimal calculateStockWorth (final String ticker, final int shares){
		System.out.print("Multiply: "+shares+" ---------> ");
		return _priceFinder.apply(ticker).multiply(BigDecimal.valueOf(shares));
	}
}
