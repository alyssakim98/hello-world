package data;

import java.io.FileWriter;
import java.io.IOException;

public class MyFileWriter implements AutoCloseable {

	private final FileWriter _writer;
	
	public MyFileWriter(final String fileName) throws IOException{
		_writer = new FileWriter(fileName);
	}
	
	public void writeStuff(String messae) throws IOException{
		_writer.write(messae);
	}
	
	public void close() throws IOException{
		System.out.println("close called automatically...");
		_writer.close();
	}
}
