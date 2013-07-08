package edu.uah.rsesc.aadl.age.diagram;

public class ComponentImplementationDiagramTypeProvider extends AgeDiagramTypeProvider {
	public ComponentImplementationDiagramTypeProvider() {
		super();
		setFeatureProvider(new TypeFeatureProvider(this));
	}
}
