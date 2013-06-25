package edu.uah.rsesc.aadl.age.diagram;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;

public class PackageDiagramTypeProvider extends AbstractDiagramTypeProvider {
	public PackageDiagramTypeProvider() {
		super();
		setFeatureProvider(new PackageFeatureProvider(this));
	}
	
	@Override
	public boolean isAutoUpdateAtStartup() {
		return true;
	}
	/*
	@Override
	public boolean isAutoUpdateAtRuntime() {
		return true;
	}
*/
}
