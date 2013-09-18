package edu.uah.rsesc.aadl.age.diagrams.common.connections;

import javax.inject.Inject;

import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ModeTransition;

import edu.uah.rsesc.aadl.age.diagrams.common.patterns.AgePattern;
import edu.uah.rsesc.aadl.age.diagrams.common.patterns.ModePattern;
import edu.uah.rsesc.aadl.age.services.AnchorService;
import edu.uah.rsesc.aadl.age.services.BusinessObjectResolutionService;
import edu.uah.rsesc.aadl.age.services.ShapeService;

public class ModeTransitionInfoProvider extends AbstractConnectionInfoProvider {
	private final AnchorService anchorUtil;
	private final ShapeService shapeHelper;
	
	@Inject
	public ModeTransitionInfoProvider(final BusinessObjectResolutionService bor, final Diagram diagram, final AnchorService anchorUtil, final ShapeService shapeHelper) {
		super(bor, diagram);
		this.anchorUtil = anchorUtil;
		this.shapeHelper = shapeHelper;
	}

	@Override
	public boolean isBusinessObjectApplicable(final Object bo) {
		return bo instanceof ModeTransition;
	}

	@Override
	public ContainerShape getOwnerShape(final Connection connection) {
		if(connection.getStart().getParent() instanceof ContainerShape) {
			ContainerShape temp = (ContainerShape)connection.getStart().getParent();
			while(temp != null) {
				final Object tempBo = getBusinessObjectResolver().getBusinessObjectForPictogramElement(temp);
				if(tempBo instanceof ComponentClassifier) {
					return temp;
				}
				temp = temp.getContainer();
			}
			
		}

		return null;
	}
	
	@Override
	public Anchor[] getAnchors(final ContainerShape ownerShape, final Object bo) {
		final ModeTransition mt = (ModeTransition)bo;
		final ContainerShape srcShape = (ContainerShape)shapeHelper.getChildShapeByElementQualifiedName(ownerShape, mt.getSource());
		final ContainerShape dstShape = (ContainerShape)shapeHelper.getChildShapeByElementQualifiedName(ownerShape, mt.getDestination());
		if(srcShape == null || dstShape == null) {
			return null;
		}				
		
		final Anchor a1 = anchorUtil.getAnchorByName(shapeHelper.getChildShapeByName(srcShape, ModePattern.innerModeShapeName), AgePattern.chopboxAnchorName);
		final Anchor a2 = anchorUtil.getAnchorByName(shapeHelper.getChildShapeByName(dstShape, ModePattern.innerModeShapeName), AgePattern.chopboxAnchorName);		
		
		if(a1 == null || a2 == null) {
			return null;
		}
		
		return new Anchor[] {a1, a2};
	}
}
