package org.osate.slicer.iobjadapters;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.errormodel.instance.ErrorFlowInstance;
import org.osate.aadl2.instance.InstanceObject;

public class ErrorFlowInstanceAdapter implements VertexIObjAdapter {

	private final ErrorFlowInstance efi;

	public ErrorFlowInstanceAdapter(ErrorFlowInstance efi) {
		this.efi = efi;
	}

	@Override
	public EObject getContainer() {
		System.err.println("getContainer called unexpectedly on an ErrorFlowInstance!");
		return null;
	}

	@Override
	public InstanceObject getInstanceObject() {
		return efi;
	}
}
