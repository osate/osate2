package edu.uah.rsesc.aadl.age.diagram;

public class PackageDiagramTypeProvider extends AgeDiagramTypeProvider {
	public PackageDiagramTypeProvider() {
		super();
		setFeatureProvider(new PackageFeatureProvider(this));
	}
}
