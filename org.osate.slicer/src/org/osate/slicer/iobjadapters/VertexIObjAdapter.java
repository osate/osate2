package org.osate.slicer.iobjadapters;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.instance.InstanceObject;

public interface VertexIObjAdapter {

	public EObject getContainer();

	public InstanceObject getInstanceObject();

}
