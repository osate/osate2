package org.osate.slicer.iobjadapters;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;

public class FeatureInstanceAdapter implements VertexIObjAdapter {

	private final FeatureInstance feat;

	public FeatureInstanceAdapter(FeatureInstance feat) {
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
}
