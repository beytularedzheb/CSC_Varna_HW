package csc.com.br.dataprovider;

import java.security.InvalidParameterException;

import csc.com.br.dataprovider.commandproviders.ICommandProvider;
import csc.com.br.dataprovider.machineproviders.IMachineProvider;

public class DataProvider implements IDataProvider {

	private IMachineProvider machineProvider;
	private ICommandProvider commandProvider;

	public DataProvider(final IMachineProvider machineProvider, final ICommandProvider commandProvider) {
		setMachineProvider(machineProvider);
		setCommandProvider(commandProvider);
	}

	public ICommandProvider getCommandProvider() {
		return this.commandProvider;
	}

	public IMachineProvider getMachineProvider() {

		return this.machineProvider;
	}

	private void setCommandProvider(final ICommandProvider commandProvider) {
		if (commandProvider == null) {
			throw new InvalidParameterException("Command provider can not be null!!!");
		}
		this.commandProvider = commandProvider;
	}

	private void setMachineProvider(final IMachineProvider machineProvider) {
		if (machineProvider == null) {
			throw new InvalidParameterException("Machine provider can not be null!!!");
		}
		this.machineProvider = machineProvider;
	}

}
