package edu.uah.rsesc.aadl.age.diagram;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;

public class ComponentImplementationDiagramTypeProvider extends AbstractDiagramTypeProvider {
	public ComponentImplementationDiagramTypeProvider() {
		super();
		setFeatureProvider(new TypeFeatureProvider(this));
	}
}
