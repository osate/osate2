package edu.uah.rsesc.aadl.age.diagrams.pkg;

import edu.uah.rsesc.aadl.age.diagrams.common.AgeDiagramTypeProvider;

public class PackageDiagramTypeProvider extends AgeDiagramTypeProvider {
	public PackageDiagramTypeProvider() {
		setFeatureProvider(new PackageFeatureProvider(this));
	}
}
