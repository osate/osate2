package edu.uah.rsesc.aadl.age.services.impl;

import org.eclipse.ui.services.AbstractServiceFactory;
import org.eclipse.ui.services.IServiceLocator;

public abstract class SimpleServiceFactory extends AbstractServiceFactory {
	private final Class<?> interfaceClass;
	private final Class<?> instanceClass;
	
	public SimpleServiceFactory(final Class<?> interfaceClass, final Class<?> instanceClass) {
		this.interfaceClass = interfaceClass;
		this.instanceClass = instanceClass;
	}
	
	@Override
	public Object create(@SuppressWarnings("rawtypes") final Class serviceInterface, final IServiceLocator parentLocator, final IServiceLocator locator) {
		if(interfaceClass.equals(serviceInterface)) {
			try {
				return instanceClass.newInstance();
			} catch (Exception ex) {
				throw new RuntimeException(ex);
			}
		}
		
		return null;
	}
}
