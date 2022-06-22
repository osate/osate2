package org.osate.slicer.iobjadapters;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.errormodel.instance.BindingType;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.InstanceObject;

public class BoundComponentInstanceAdapter implements VertexIObjAdapter {

	private final ComponentInstance comp;
	private final BindingType type;

	public BoundComponentInstanceAdapter(ComponentInstance comp, BindingType bindingType) {
		this.comp = comp;
		this.type = bindingType;
	}

	@Override
	public EObject getContainer() {
		System.err.println("getContainer called unexpectedly on an BoundComponentInstance!");
		return null;
	}

	@Override
	public InstanceObject getInstanceObject() {
		return comp;
	}
}
