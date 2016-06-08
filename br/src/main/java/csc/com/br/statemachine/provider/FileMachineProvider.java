package csc.com.br.statemachine.provider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import csc.com.br.statemachine.contract.IMachineProvider;

public class FileMachineProvider implements IMachineProvider {

	private final String filePath;

	public FileMachineProvider(String filePath) {
		this.filePath = filePath;
	}

	public List<String> getMachine() {

		BufferedReader bufferedReader = null;
		List<String> result = new ArrayList<String>();

		try {
			bufferedReader = new BufferedReader(new FileReader(filePath));
			String line;

			while ((line = bufferedReader.readLine()) != null) {
				result.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException npe) {
			npe.printStackTrace();
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (Throwable t) {
					t.printStackTrace();
				}
			}
		}
		return result;
	}

}
