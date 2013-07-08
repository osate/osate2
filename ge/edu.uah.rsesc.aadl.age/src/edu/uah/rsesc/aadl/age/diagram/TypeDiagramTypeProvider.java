package edu.uah.rsesc.aadl.age.diagram;

/*
 * The type diagram is used to edit component and feature group type
 */
public class TypeDiagramTypeProvider extends AgeDiagramTypeProvider {
	public TypeDiagramTypeProvider() {
		super();
		setFeatureProvider(new TypeFeatureProvider(this));
	}
}
