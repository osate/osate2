package org.osate.slicer.iobjadapters;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.InstanceObject;

public class AccessPropagationAdapter implements VertexIObjAdapter {

	private final ComponentInstance comp;
	private final String name;

	public AccessPropagationAdapter(ComponentInstance comp) {
		this.name = comp.getInstanceObjectPath() + ".access";
		this.comp = comp;
	}

	@Override
	public EObject getContainer() {
		return comp.eContainer();
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
