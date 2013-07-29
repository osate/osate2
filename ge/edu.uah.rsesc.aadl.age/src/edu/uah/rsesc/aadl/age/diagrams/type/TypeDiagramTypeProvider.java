package edu.uah.rsesc.aadl.age.diagrams.type;

import edu.uah.rsesc.aadl.age.diagrams.common.AgeDiagramTypeProvider;

/*
 * The type diagram is used to edit component and feature group type
 */
public class TypeDiagramTypeProvider extends AgeDiagramTypeProvider {
	public TypeDiagramTypeProvider() {
		setFeatureProvider(new TypeFeatureProvider(this));
	}
}
