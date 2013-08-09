package edu.uah.rsesc.aadl.age.diagrams.componentImplementation;

import edu.uah.rsesc.aadl.age.diagrams.common.AgeDiagramTypeProvider;

public class ComponentImplementationDiagramTypeProvider extends AgeDiagramTypeProvider {
	public ComponentImplementationDiagramTypeProvider() {
		setFeatureProvider(new ComponentImplementationFeatureProvider(this));
	}
}
