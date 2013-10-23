package edu.uah.rsesc.aadl.age.services;

import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import edu.uah.rsesc.aadl.age.services.impl.DefaultStyleProviderService;
import edu.uah.rsesc.aadl.age.services.impl.SimpleServiceFactory;

// CLEAN-UP: Needs to be merged with StyleService
public interface StyleProviderService {
	public static class Factory extends SimpleServiceFactory {
		public Factory() {
			super(StyleProviderService.class, DefaultStyleProviderService.class);
		}
	}
	
	Style getStyle(Diagram diagram, String id);
}
