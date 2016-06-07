package csc.com.br.dataprovider;

import csc.com.br.dataprovider.commandproviders.ICommandProvider;
import csc.com.br.dataprovider.machineproviders.IMachineProvider;

public interface IDataProvider {
	ICommandProvider getCommandProvider();
	IMachineProvider getMachineProvider();
}
