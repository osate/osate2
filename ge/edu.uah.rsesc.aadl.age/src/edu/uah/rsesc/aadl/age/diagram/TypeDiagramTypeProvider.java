package edu.uah.rsesc.aadl.age.diagram;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;

/*
 * The type diagram is used to edit component and feature group type
 */
public class TypeDiagramTypeProvider extends AbstractDiagramTypeProvider {
	public TypeDiagramTypeProvider() {
		super();
		setFeatureProvider(new TypeFeatureProvider(this));
	}
}
