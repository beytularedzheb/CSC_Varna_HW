package csc.com.br.statemachine.provider;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import csc.com.br.statemachine.contract.IMachineProvider;

public class ConsoleMachineProvider implements IMachineProvider {

	public List<String> getMachine() {
		String line;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		List<String> result = new ArrayList<String>();
		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
			if (line.trim().length() == 0) {
				break;
			}
			result.add(line);
		}
		
		return result;
	}

}
