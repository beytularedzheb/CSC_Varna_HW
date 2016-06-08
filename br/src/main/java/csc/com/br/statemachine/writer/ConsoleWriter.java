package csc.com.br.statemachine.writer;

public class ConsoleWriter implements IWriter {

	public void write(String output) {
		System.out.println(output);		
	}

}
