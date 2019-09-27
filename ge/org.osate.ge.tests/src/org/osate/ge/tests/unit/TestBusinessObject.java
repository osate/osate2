package org.osate.ge.tests.unit;

import org.osate.ge.DockingPosition;
import org.osate.ge.graphics.Point;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;

// Class used for test business objects. Allowed to contain children or have a value specified but not both.
public class TestBusinessObject {
	public final int value;
	public final TestBusinessObject[] children;
	public boolean isConnection = false;
	public RelativeBusinessObjectReference connectionStartReference; // Reference to sibling which is the start of the connection
	public RelativeBusinessObjectReference connectionEndReference; // Reference to sibling which is the end of the connection
	public DockingPosition defaultDockingPosition = DockingPosition.NOT_DOCKABLE;
	
	public TestBusinessObject(final int value) {
		this.value = value;
		this.children = new TestBusinessObject[0];
	}
	
	public TestBusinessObject(final TestBusinessObject[] children) {
		this.value = -1;
		this.children = children;
	}

	public RelativeBusinessObjectReference getRelativeReference() {
		return new RelativeBusinessObjectReference("test_relative", Integer.toString(value), Integer.toString(children.length));
	}

	public Point getTestPosition() {
		return new Point(value, children.length);
	}	
	
	public void makeConnection(final TestBusinessObject startSiblingBo, final TestBusinessObject endSiblingBo) {
		this.isConnection = true;
		connectionStartReference = startSiblingBo == null ? null : startSiblingBo.getRelativeReference();
		connectionEndReference = endSiblingBo == null ? null : endSiblingBo.getRelativeReference();
	}
	
	@Override
	public String toString() {
		return getRelativeReference().toString();
	}
	
	// Helper method to reduce code length
	public static TestBusinessObject newBO(final int v) {
		return new TestBusinessObject(v);
	}
	
	public static TestBusinessObject newBO(final TestBusinessObject... args) {
		return new TestBusinessObject(args);
	}
}
