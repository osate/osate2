package org.osate.ge.internal.graphiti.features;

import java.util.Objects;

import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

public class AgeAddConnectionContext extends AddConnectionContext {
	private final PictogramElement owner;
	
	public AgeAddConnectionContext(final PictogramElement owner, final Anchor sourceAnchor, final Anchor targetAnchor) {
		super(sourceAnchor, targetAnchor);
		this.owner = Objects.requireNonNull(owner, "owner must not be null");
	}
	
	public PictogramElement getOwner() {
		return owner;
	}
}
