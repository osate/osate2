package edu.uah.rsesc.aadl.age.styles;

import org.eclipse.ui.services.AbstractServiceFactory;
import org.eclipse.ui.services.IServiceLocator;

public class StyleProviderFactory extends AbstractServiceFactory {
	public StyleProviderFactory() {
	}
	
	@Override
	public Object create(@SuppressWarnings("rawtypes") final Class serviceInterface, final IServiceLocator parentLocator, final IServiceLocator locator) {
		if(StyleProvider.class.equals(serviceInterface)) {
			return new DefaultStyleProvider();
		}
		
		return null;
	}
}
