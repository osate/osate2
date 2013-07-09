package edu.uah.rsesc.aadl.age.diagrams.componentImplementation;

import edu.uah.rsesc.aadl.age.diagrams.common.AgeDiagramTypeProvider;
import edu.uah.rsesc.aadl.age.diagrams.type.TypeFeatureProvider;

public class ComponentImplementationDiagramTypeProvider extends AgeDiagramTypeProvider {
	public ComponentImplementationDiagramTypeProvider() {
		super();
		setFeatureProvider(new TypeFeatureProvider(this));
	}
}
