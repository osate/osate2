/*
Copyright (c) 2015, Rockwell Collins.
Developed with the sponsorship of Defense Advanced Research Projects Agency (DARPA).

Permission is hereby granted, free of charge, to any person obtaining a copy of this data, 
including any software or models in source or binary form, as well as any drawings, specifications, 
and documentation (collectively "the Data"), to deal in the Data without restriction, including
without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, 
and/or sell copies of the Data, and to permit persons to whom the Data is furnished to do so, 
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or 
substantial portions of the Data.

THE DATA IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT 
LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
IN NO EVENT SHALL THE AUTHORS, SPONSORS, DEVELOPERS, CONTRIBUTORS, OR COPYRIGHT HOLDERS BE LIABLE 
FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
ARISING FROM, OUT OF OR IN CONNECTION WITH THE DATA OR THE USE OR OTHER DEALINGS IN THE DATA.
*/
package org.osate.ge.internal.connections;

import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.ge.internal.patterns.FeaturePattern;
import org.osate.ge.internal.services.AnchorService;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.ShapeService;

public class ConnectionReferenceInfoProvider extends AbstractConnectionInfoProvider {
	private final AnchorService anchorService;
	private final ShapeService shapeService;
	
	public ConnectionReferenceInfoProvider(final BusinessObjectResolutionService bor, final Diagram diagram, final AnchorService anchorService, final ShapeService shapeService) {
		super(bor, diagram);
		this.anchorService = anchorService;
		this.shapeService = shapeService;
	}

	@Override
	public boolean isBusinessObjectApplicable(Object bo) {
		return bo instanceof ConnectionReference;
	}

	@Override
	public ContainerShape getOwnerShape(final Connection connection) {
		if(connection.getStart() != null && connection.getStart().getParent() instanceof ContainerShape && 
				connection.getEnd() != null && connection.getEnd().getParent() instanceof ContainerShape) {
				
				final ContainerShape startParent = (ContainerShape)connection.getStart().getParent();
				final ContainerShape endParent = (ContainerShape)connection.getEnd().getParent();
				
				// Get the lowest common ancestor
				ContainerShape temp1 = startParent;
				while(temp1 != null) {
					ContainerShape temp2 = endParent;
					while(temp2 != null) {
						if(temp1 == temp2) {
							final Object temp1Bo = getBusinessObjectResolver().getBusinessObjectForPictogramElement(temp1);
							if(temp1Bo instanceof ComponentInstance) {
								return temp1;
							}						
						}
						temp2 = temp2.getContainer();
					}
					
					temp1 = temp1.getContainer();
				}
			}

			return null;
	}

	@Override
	public Anchor[] getAnchors(final ContainerShape ownerShape, final Object bo) {
		final ConnectionReference cr = (ConnectionReference)bo;
		
		// Get the component instance in which the source and destination are contained 
		final ComponentInstance srcComponentInstance = cr.getSource().getComponentInstance();
		final ComponentInstance dstComponentInstance = cr.getDestination().getComponentInstance();
		if(srcComponentInstance == null || dstComponentInstance == null) {
			return null;
		}
		
		final Shape srcShape = shapeService.findDescendantShapeByReference(ownerShape, cr.getSource());
		if(srcShape == null) {
			return null;
		}
		
		final Shape dstShape = shapeService.findDescendantShapeByReference(ownerShape, cr.getDestination());	
		if(dstShape == null) {
			return null;
		}
		
		// Case
		// 
		// Source Belongs to a Child of Destination's Container
		final Anchor srcAnchor;
		final Anchor dstAnchor;
		if(isParent(dstComponentInstance, srcComponentInstance)) {
			srcAnchor = getAnchorOrChopbox(srcShape, FeaturePattern.outerConnectorAnchorName);
			dstAnchor = getAnchorOrChopbox(dstShape, FeaturePattern.innerConnectorAnchorName);
		} else if(isParent(srcComponentInstance, dstComponentInstance)) { // Destination Belongs to a Child of Source's Container
			srcAnchor = getAnchorOrChopbox(srcShape, FeaturePattern.innerConnectorAnchorName);
			dstAnchor = getAnchorOrChopbox(dstShape, FeaturePattern.outerConnectorAnchorName);
		} else { // Source and Destination Belong to Siblings
			srcAnchor = getAnchorOrChopbox(srcShape, FeaturePattern.outerConnectorAnchorName);
			dstAnchor = getAnchorOrChopbox(dstShape, FeaturePattern.outerConnectorAnchorName);
		}

		if(srcAnchor == null || dstAnchor == null) {
			return null;
		}

		return new Anchor[] {srcAnchor, dstAnchor};
	}
	
	/**
	 * Returns the anchor with the specified name. If that anchor cannot be found, it returns the chopbox anchor.
	 * @param shape
	 * @param anchorName
	 * @return
	 */
	private Anchor getAnchorOrChopbox(final Shape shape, final String anchorName) {
		Anchor result = anchorService.getAnchorByName(shape, anchorName);
		if(result == null) {
			result = Graphiti.getPeService().getChopboxAnchor(shape);
		}
		return result;
	}
	
	boolean isParent(final ComponentInstance potentialParent, final ComponentInstance ci) {
		ComponentInstance tmpCi = ci.getContainingComponentInstance();
		while(tmpCi != null) {
			if(potentialParent == tmpCi) {
				return true;
			}
			tmpCi = tmpCi.getContainingComponentInstance();
		}
		
		return false;
	}
}
