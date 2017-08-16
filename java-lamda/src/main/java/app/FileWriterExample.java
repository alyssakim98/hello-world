package app;

import java.io.IOException;

import data.FileWriterEam;
import data.MyFileWriter;

public class FileWriterExample implements Runnable {

	public static void main(String[] args) {
		Thread thread = new Thread(new FileWriterExample());
		thread.start();
	}

	@Override
	public void run() {
		try (final MyFileWriter writer = new MyFileWriter("D:\\peekaboo.txt")){
			writer.writeStuff("peek-a-boo");
			System.out.println("done with the resource...");
			
			FileWriterEam.use("D:\\eam.txt", writerEam -> {
				writerEam.writeStuff("how`");
				writerEam.writeStuff("sweet");
			});
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
	}

}
