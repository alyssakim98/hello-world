package data;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEam {

	private final FileWriter _writer;
	
	private FileWriterEam(final String fileName) throws IOException{
		_writer = new FileWriter(fileName);
	}
	
	public void writeStuff(String messae) throws IOException{
		_writer.write(messae);
	}
	
	private void close() throws IOException {
		System.out.println("close called automatically...");
		_writer.close();
	}
	
	public static void use(final String fileName, final UseInstance<FileWriterEam, IOException> block) throws IOException {
		final FileWriterEam writerEam = new FileWriterEam(fileName);
		try {
			block.accept(writerEam);
		} finally {
			writerEam.close();
		}
	}
}
