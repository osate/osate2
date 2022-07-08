package org.osate.slicer.iobjadapters;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;

public class FeatureInstanceAdapter implements VertexIObjAdapter {

	private final FeatureInstance feat;
	private final String name;

	public FeatureInstanceAdapter(FeatureInstance feat) {
		this.name = feat.getInstanceObjectPath();
		this.feat = feat;
	}

	@Override
	public EObject getContainer() {
		return feat.eContainer();
	}

	@Override
	public InstanceObject getInstanceObject() {
		return feat;
	}

	@Override
	public String getName() {
		return name;
	}
}
