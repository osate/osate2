package org.osate.slicer.iobjadapters;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.errormodel.instance.ErrorFlowInstance;
import org.osate.aadl2.instance.InstanceObject;

public class ErrorFlowInstanceAdapter implements VertexIObjAdapter {

	private final ErrorFlowInstance efi;
	private final String name;

	public ErrorFlowInstanceAdapter(ErrorFlowInstance efi) {
		this.name = efi.getInstanceObjectPath().replace(".EMV2", "");
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

	@Override
	public String getName() {
		return name;
	}
}
