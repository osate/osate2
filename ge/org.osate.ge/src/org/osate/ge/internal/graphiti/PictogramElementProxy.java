package org.osate.ge.internal.graphiti;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.osate.ge.internal.DiagramElementProxy;

public class PictogramElementProxy implements DiagramElementProxy {
	private PictogramElement pe;
	
	public PictogramElementProxy(final PictogramElement pe) {
		this.pe = pe;
	}
	
	public PictogramElement getPictogramElement() {
		return pe;
	}
	
	public void setPictogramElement(final PictogramElement pe) {
		this.pe = pe;
	}
}
