package app;

import java.util.stream.Stream;
import java.io.File;
import java.io.IOException;

public class ExceptionTest implements Runnable {
	public static void main(String[] args) {
		Thread thread = new Thread(new ExceptionTest());
		thread.start();
	}

	@Override
	public void run() {
		Stream.of("D:\\", "D:\\code_0805.r").map(path -> {
			try {
				return new File(path).getCanonicalPath();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return path;
		}).forEach(System.out::println);
	}
}
