package csc.com.br.statemachine;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileAppender implements IWriter {
	
	private File file;
	
	public FileAppender(String filepath) {
		this.file = new File(filepath);
	}

	public void Writer(String output) {
        try {
            FileWriter fw = new FileWriter(file, true);
            PrintWriter writer = new PrintWriter(fw, true);
            
            writer.println(output);
            
            fw.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
