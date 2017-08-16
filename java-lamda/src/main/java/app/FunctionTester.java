package app;

import java.awt.Color;
import java.math.BigDecimal;
import java.util.function.Consumer;

import data.Navigator;
import data.Camera;
import data.CsvReader;

public class FunctionTester implements Runnable {

	public static void main(String[] args) {
		Thread thread = new Thread(new FunctionTester());
		thread.start();
	}

	public void run() {
		try {
			final Navigator navigator = new Navigator(ticker -> new BigDecimal("6.01"));
			BigDecimal expected = new BigDecimal("6010.00");
			System.out.println(navigator.calculateStockWorth("GOOG", 1000));
			System.out.println(navigator.calculateStockWorth("GOOG", 1000).compareTo(expected));
			
			System.out.println("=====< Read file and Use data >=====");
			final Navigator file = new Navigator(CsvReader::getPrice);
			System.out.println(file.calculateStockWorth("GOOG", 100));
			
			System.out.println("=====< Decorating >=====");
			final Camera camera = new Camera();
			final Consumer<String> printCaptured = (filterInfo) ->
			System.out.println(String.format("with %s: %s", filterInfo, camera.capture(new Color(200, 100, 200))));
			printCaptured.accept("no filter");
			
			camera.setFilters(Color::brighter);
			printCaptured.accept("brighter filter");
			
			camera.setFilters(Color::darker);
			printCaptured.accept("darker filter");
			
			camera.setFilters(Color::brighter, Color::darker);
			printCaptured.accept("birghter & darker filter");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
