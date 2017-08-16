package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;

public class CsvReader {

	public static BigDecimal getPrice(final String ticker) {
		try{
			final String fileName = "C:\\Users\\alyssa\\Downloads\\quotes2.csv";
			
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String data = reader.readLine();
			reader.close();
			
			String[] dataItems = data.split(",");
			String price = dataItems[dataItems.length -1];
			//System.out.println(">> price: "+price);
			return new BigDecimal(price);
		}
		catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}
}
