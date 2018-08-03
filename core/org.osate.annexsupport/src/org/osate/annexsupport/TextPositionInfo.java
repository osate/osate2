package org.osate.annexsupport;

import org.eclipse.emf.ecore.EObject;

public class TextPositionInfo {

	private EObject modelObject;
	private int offset;
	private int length;

	public TextPositionInfo(EObject modelObject, int offset, int length) {
		setModelObject(modelObject);
		setOffset(offset);
		setLength(length);
	}

	public EObject getModelObject() {
		return modelObject;
	}

	public void setModelObject(EObject modelObject) {
		this.modelObject = modelObject;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

}
