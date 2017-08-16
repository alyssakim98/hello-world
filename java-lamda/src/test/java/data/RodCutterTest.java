package data;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static data.TestHelper.assertThrows;

public class RodCutterTest {

	private RodCutter _rodCutter;
	private List<Integer> _prices;

	protected RodCutter createCutter() {
		return new RodCutter(false);
	}

	@Before 
	public void initialize() {
		_rodCutter = createCutter();
		_prices = Arrays.asList(1, 1, 2, 2, 3, 4, 5);
	}

	@Test
	public void verboseExceptionTest(){
		_rodCutter.setPrices(_prices);
		try {
			_rodCutter.maxProfit(0);
			fail("Expected exception for zero length.");
		} 
		catch (RodCutterException e) {
			assertTrue("expected", true);
		}
	}

	@Test (expected = RodCutterException.class)
	public void testExceptionTest(){
		_rodCutter.setPrices(_prices);
		_rodCutter.maxProfit(0);
	}

	@Test
	public void conciseExceptionTest(){
		_rodCutter.setPrices(_prices);
		assertThrows(RodCutterException.class, () -> _rodCutter.maxProfit(0));
	}
}
