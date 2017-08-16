package data;
import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import data.Navigator;

public class NavigatorTest {

	@Test
	public void calculateStockWorth(){
		final Navigator navigator = new Navigator(ticker -> new BigDecimal("6.01"));
		BigDecimal expected = new BigDecimal("6010.00");
		assertEquals(0, navigator.calculateStockWorth("GOOG", 1000).compareTo(expected), 0.001);
	}
}
