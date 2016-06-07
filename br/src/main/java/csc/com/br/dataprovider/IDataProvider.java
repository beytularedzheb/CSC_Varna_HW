package csc.com.br.dataprovider;

import csc.com.br.dataprovider.machineprovider.ICommandProvider;
import csc.com.br.dataprovider.machineprovider.IMachineProvider;

public interface IDataProvider {
	ICommandProvider getCommandProvider();
	IMachineProvider getMachineProvider();
}
