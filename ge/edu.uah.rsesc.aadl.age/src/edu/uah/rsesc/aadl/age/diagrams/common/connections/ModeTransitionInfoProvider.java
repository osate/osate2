package edu.uah.rsesc.aadl.age.diagrams.common.connections;

import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ModeTransition;

import edu.uah.rsesc.aadl.age.diagrams.common.mapping.BusinessObjectResolver;
import edu.uah.rsesc.aadl.age.diagrams.common.patterns.AgePattern;
import edu.uah.rsesc.aadl.age.diagrams.common.patterns.ModePattern;
import edu.uah.rsesc.aadl.age.diagrams.common.util.AnchorUtil;
import edu.uah.rsesc.aadl.age.diagrams.common.util.ShapeHelper;

public class ModeTransitionInfoProvider extends AbstractConnectionInfoProvider {
	public ModeTransitionInfoProvider(final BusinessObjectResolver bor, final Diagram diagram) {
		super(bor, diagram);
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
		final ContainerShape srcShape = (ContainerShape)ShapeHelper.getChildShapeByElementQualifiedName(ownerShape, mt.getSource(), getBusinessObjectResolver());
		final ContainerShape dstShape = (ContainerShape)ShapeHelper.getChildShapeByElementQualifiedName(ownerShape, mt.getDestination(), getBusinessObjectResolver());
		if(srcShape == null || dstShape == null) {
			return null;
		}				
		
		final Anchor a1 = AnchorUtil.getAnchorByName(ShapeHelper.getChildShapeByName(srcShape, ModePattern.innerModeShapeName), AgePattern.chopboxAnchorName);
		final Anchor a2 = AnchorUtil.getAnchorByName(ShapeHelper.getChildShapeByName(dstShape, ModePattern.innerModeShapeName), AgePattern.chopboxAnchorName);		
		
		if(a1 == null || a2 == null) {
			return null;
		}
		
		return new Anchor[] {a1, a2};
	}
}
