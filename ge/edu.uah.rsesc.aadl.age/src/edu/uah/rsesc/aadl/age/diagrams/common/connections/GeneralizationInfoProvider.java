package edu.uah.rsesc.aadl.age.diagrams.common.connections;

import javax.inject.Inject;

import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IPeService;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Generalization;

import edu.uah.rsesc.aadl.age.diagrams.common.mapping.BusinessObjectResolver;
import edu.uah.rsesc.aadl.age.diagrams.common.util.ShapeService;

public class GeneralizationInfoProvider extends AbstractConnectionInfoProvider {
	private final ShapeService shapeHelper;
	
	@Inject
	public GeneralizationInfoProvider(final BusinessObjectResolver bor, final Diagram diagram, final ShapeService shapeHelper) {
		super(bor, diagram);
		this.shapeHelper = shapeHelper;
	}

	@Override
	public boolean isBusinessObjectApplicable(final Object bo) {
		return bo instanceof Generalization;
	}

	@Override
	public ContainerShape getOwnerShape(final Connection connection) {
		return connection.getParent();
	}

	@Override
	public Anchor[] getAnchors(final ContainerShape ownerShape, final Object bo) {
		final IPeService peService = Graphiti.getPeService();
		final Generalization generalization = (Generalization)bo;
		final Classifier generalClassifier = generalization.getGeneral();
		final Classifier specificClassifier = generalization.getSpecific();

		// Get the pictogram objects for them
		final PictogramElement generalPictogramEl = shapeHelper.getChildShapeByElementQualifiedName(ownerShape, generalClassifier);
		final PictogramElement specificPictogramEl = shapeHelper.getChildShapeByElementQualifiedName(ownerShape, specificClassifier);
		
		if(generalPictogramEl == null) {
			throw new RuntimeException("Unhandled case, referenced general classifier is not in diagram. " + generalClassifier.getQualifiedName());
		}
		
		if(specificPictogramEl == null) {
			throw new RuntimeException("Unhandled case, referenced specific classifier is not in diagram. " + specificClassifier.getQualifiedName());
		}

		// Get anchors
		final Anchor generalAnchor = peService.getChopboxAnchor((AnchorContainer)generalPictogramEl);
		final Anchor specificAnchor = peService.getChopboxAnchor((AnchorContainer)specificPictogramEl);			
		if(generalAnchor == null || specificAnchor == null) {
			throw new RuntimeException("Unhandled case. Unable to get chopbox anchor for pictogram elements");
		}
		
		return new Anchor[] {generalAnchor, specificAnchor};
	}
}
