package by.epam.nb.service;

import by.epam.nb.service.impl.NoteBookConsoleView;
import by.epam.nb.service.impl.NoteBookProvider;

public class ServiceFactory {
	private static ServiceFactory factory = new ServiceFactory();

	private final ProviderService providerService = new NoteBookProvider();
	private final PrinterService printerService = new NoteBookConsoleView();
	
	private ServiceFactory(){}
	
	public static ServiceFactory getInstance(){
		return factory;
	}
	
	public ProviderService getProviderService(){
		return providerService;
	}
	
	public PrinterService getPrinterService(){
		return printerService;
	}
}
