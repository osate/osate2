package edu.uah.rsesc.aadl.age.diagrams.common.connections;

import javax.inject.Inject;

import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IPeService;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.Context;
import org.osate.aadl2.NamedElement;

import edu.uah.rsesc.aadl.age.diagrams.common.patterns.FeaturePattern;
import edu.uah.rsesc.aadl.age.diagrams.common.util.AnchorService;
import edu.uah.rsesc.aadl.age.diagrams.common.util.BusinessObjectResolutionService;
import edu.uah.rsesc.aadl.age.diagrams.common.util.ShapeService;

public class AadlConnectionInfoProvider extends AbstractConnectionInfoProvider {
	private final AnchorService anchorUtil;
	private final ShapeService shapeHelper;
	
	@Inject
	public AadlConnectionInfoProvider(final BusinessObjectResolutionService bor, final Diagram diagram, final AnchorService anchorUtil, final ShapeService shapeHelper) {
		super(bor, diagram);
		this.anchorUtil = anchorUtil;
		this.shapeHelper = shapeHelper;
	}

	@Override
	public boolean isBusinessObjectApplicable(final Object bo) {
		return bo instanceof org.osate.aadl2.Connection;
	}

	@Override
	public ContainerShape getOwnerShape(final Connection connection) {
		if(connection.getStart().getParent() instanceof ContainerShape) {
			ContainerShape temp = (ContainerShape)connection.getStart().getParent();
			while(temp != null) {
				final Object tempBo = getBusinessObjectResolver().getBusinessObjectForPictogramElement(temp);
				if(tempBo instanceof ComponentImplementation) {
					return temp;
				}
				temp = temp.getContainer();
			}
			
		}

		return null;
	}
	
	@Override
	public Anchor[] getAnchors(final ContainerShape ownerShape, final Object bo) {
		final org.osate.aadl2.Connection connection = (org.osate.aadl2.Connection)bo;
		Anchor a1 = null;
		Anchor a2 = null;
		
		// Get the pictogram elements for the source and destination of the connection
		final PictogramElement sourcePe = getPictogramElement(ownerShape, connection.getAllSource(), connection.getAllSourceContext(), connection.getAllSrcContextComponent());
		final PictogramElement destPe = getPictogramElement(ownerShape, connection.getAllDestination(), connection.getAllDestinationContext(), connection.getAllDstContextComponent());

		// Check if the sourcePe and destPe are valid
		if(sourcePe == null || !(sourcePe instanceof Shape) || destPe == null || !(destPe instanceof Shape)) {
			return null;
		}
		final Shape sourceShape = (Shape)sourcePe;
		final Shape destShape = (Shape)destPe;
		final IPeService peService = Graphiti.getPeService();
		
		// Get the appropriate anchors
		a1 = anchorUtil.getAnchorByName(sourcePe, shapeHelper.doesShapeContain(sourceShape.getContainer(), destShape) ? FeaturePattern.innerConnectorAnchorName : FeaturePattern.outerConnectorAnchorName);
		if(a1 == null) {
			a1 = peService.getChopboxAnchor((AnchorContainer)sourcePe);
		}

		a2 = anchorUtil.getAnchorByName(destPe, shapeHelper.doesShapeContain(destShape.getContainer(), sourceShape) ? FeaturePattern.innerConnectorAnchorName : FeaturePattern.outerConnectorAnchorName);
		if(a2 == null) {
			a2 = peService.getChopboxAnchor((AnchorContainer)destPe);
		}
		
		if(a1 == null || a2 == null) {
			return null;
		}

		return new Anchor[] {a1, a2};
	}
	
	private PictogramElement getPictogramElement(final ContainerShape ownerShape, final ConnectionEnd ce, final Context context, final NamedElement contextComponent) {
		if(ce == null) {
			return null;
		}
		
		// Get the PE for the context component
		PictogramElement pe = null;
		if(contextComponent != null) {
			// Check if the context matches the BO of the owner shape
			if(contextComponent == getBusinessObjectResolver().getBusinessObjectForPictogramElement(ownerShape)){
				pe = ownerShape;
			} else {
				pe = shapeHelper.getChildShapeByElementQualifiedName(ownerShape, contextComponent);
				if(pe == null || !(pe instanceof ContainerShape)) {
					return null;
				}
			}
		} 
		
		if(context != null && contextComponent != context) {
			if(pe == null) {			
				// TODO: Throw exception? Unhandled case. Context without context component
				return null;
			} else {
				// Get the shape for the context
				pe = shapeHelper.getDescendantShapeByElement((ContainerShape)pe, context);
				if(pe == null || !(pe instanceof ContainerShape)) {
					return null;
				}
			}
		}
		
		// If the connection end did not have a context
		if(pe == null) {
			pe = ownerShape;
			if(pe == null || !(pe instanceof ContainerShape)) {
				return null;
			}
		}
		
		// Get Descendant PE
		pe = shapeHelper.getDescendantShapeByElement((ContainerShape)pe, ce);		
		
		// CLEAN-UP: Clarify or remove comments
		// Case: Just CE is valid. (Probably a feature? could be a component)
		// Return it's PE
		
		// Case: CE is valid. Context and context component is the same.
		// Get the PE of Context. Retrieve PE of the child of the context PE for CE.
		
		// Case: CE is valid. Context is a subcomponent. Context is a feature group
		// 

		return pe;
	}
}
