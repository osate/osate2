package org.osate.slicer.iobjadapters;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.InstanceObject;

public class FeatureInstanceAdapter implements VertexIObjAdapter {

	private final ConnectionInstanceEnd feat;
	private final String name;

	public FeatureInstanceAdapter(ConnectionInstanceEnd feat) {
		if (feat instanceof ComponentInstance) {
			this.name = feat.getInstanceObjectPath() + ".access";
		} else {
			this.name = feat.getInstanceObjectPath();
		}
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
