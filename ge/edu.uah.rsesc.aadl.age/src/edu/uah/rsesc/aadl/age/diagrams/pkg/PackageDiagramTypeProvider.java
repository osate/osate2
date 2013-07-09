package edu.uah.rsesc.aadl.age.diagrams.pkg;

import edu.uah.rsesc.aadl.age.diagrams.common.AgeDiagramTypeProvider;

public class PackageDiagramTypeProvider extends AgeDiagramTypeProvider {
	public PackageDiagramTypeProvider() {
		super();
		setFeatureProvider(new PackageFeatureProvider(this));
	}
}
