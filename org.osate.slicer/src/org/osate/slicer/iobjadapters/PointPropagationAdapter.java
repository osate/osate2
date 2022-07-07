package org.osate.slicer.iobjadapters;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.InstanceObject;

public class PointPropagationAdapter implements VertexIObjAdapter {

	private final ComponentInstance comp;
	private final String propagationName;
	private final String name;

	public PointPropagationAdapter(ComponentInstance comp, String propagationName) {
		this.name = comp.getInstanceObjectPath().replace(".EMV2", "") + "." + propagationName;
		this.comp = comp;
		this.propagationName = propagationName;
	}

	@Override
	public EObject getContainer() {
		System.err.println("getContainer called unexpectedly on an PointPropagationInstance!");
		return null;
	}

	@Override
	public InstanceObject getInstanceObject() {
		return comp;
	}

	@Override
	public String getName() {
		return name;
	}
}
