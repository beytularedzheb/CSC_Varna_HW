package csc.com.br.statemachine.writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileAppender implements IWriter {

	private File file;

	public FileAppender(String filepath) {
		this.file = new File(filepath);
	}

	public void write(String output) {
		FileWriter fw = null;
		PrintWriter writer = null;
		
		try {
			fw = new FileWriter(file, true);
			writer = new PrintWriter(fw, true);

			writer.println(output);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null && fw != null) {
				try {
					fw.close();
					writer.close();
				} catch (Throwable t) {
					t.printStackTrace();
				}
			}
		}
	}
}
