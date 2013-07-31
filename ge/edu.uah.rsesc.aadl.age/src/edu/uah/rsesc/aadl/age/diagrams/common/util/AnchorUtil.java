package edu.uah.rsesc.aadl.age.diagrams.common.util;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.ChopboxAnchor;
import org.eclipse.graphiti.mm.pictograms.FixPointAnchor;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.services.IPeService;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.Generalization;

import edu.uah.rsesc.aadl.age.diagrams.type.patterns.TypeFeaturePattern;

/**
 * Class the contains miscellaneous methods for dealing with anchors
 * @author philip.alldredge
 *
 */
public class AnchorUtil {
	public static Anchor getAnchorByName(final PictogramElement pe, final String name) {
		if(pe instanceof AnchorContainer) {
			for(final Anchor anchor : ((AnchorContainer)pe).getAnchors()) {
				if(name.equals(PropertyUtil.getName(anchor))) {
					return anchor;
				}
			}	
		}

		return null;
	}
	
	public static ChopboxAnchor createOrUpdateChopboxAnchor(final AnchorContainer container, final String name) {
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		final Anchor retrievedAnchor = getAnchorByName(container, name);

		if(retrievedAnchor == null) {
			final ChopboxAnchor anchor = peCreateService.createChopboxAnchor(container);
	        PropertyUtil.setName(anchor, "center");
	        return anchor;
		}
		else if(retrievedAnchor instanceof ChopboxAnchor) {
			return (ChopboxAnchor)retrievedAnchor;
		}
		else {
			throw new RuntimeException("Retrieved anchor is of invalid type: " + retrievedAnchor.getClass().getName());	
		}        
	}
	
	public static FixPointAnchor createOrUpdateFixPointAnchor(final AnchorContainer container, final String name, final int x, final int y) {
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		final IGaService gaService = Graphiti.getGaService();
		
		// Create or get the anchor by name
		final Anchor retrievedAnchor = getAnchorByName(container, name);
		final FixPointAnchor anchor;
		if(retrievedAnchor == null) {
			anchor = peCreateService.createFixPointAnchor(container);
			PropertyUtil.setName(anchor, name);			
		} else {
			if(!(retrievedAnchor instanceof FixPointAnchor)) {
				throw new RuntimeException("Retrieved anchor is of invalid type: " + retrievedAnchor.getClass().getName());	
			}
			
			anchor = (FixPointAnchor)retrievedAnchor;
		}

		// Configure the anchor
        gaService.createInvisibleRectangle(anchor);
        anchor.setLocation(gaService.createPoint(x, y));
        anchor.setUseAnchorLocationAsConnectionEndpoint(true);
        
        return anchor;
	}
	
	/**
	 * Find the anchors that should be used for a connection representing a generalization.
	 * @param generalization
	 * @param fp
	 * @return an array containing the anchors. General first and then specific. Guaranteed not to be null.
	 */
	public static Anchor[] getAnchorsForGeneralization(final Generalization generalization, final IFeatureProvider fp) {
		final IPeService peService = Graphiti.getPeService();
		final Classifier generalClassifier = generalization.getGeneral();
		final Classifier specificClassifier = generalization.getSpecific();

		// Get the pictogram objects for them
		final PictogramElement generalPictogramEl = fp.getPictogramElementForBusinessObject(generalClassifier);
		final PictogramElement specificPictogramEl = fp.getPictogramElementForBusinessObject(specificClassifier);
		
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
	
	/**
	 * 
	 * @param fs
	 * @param fp
	 * @return an array containing the anchors. Guaranteed not to be null.
	 */
	public static Anchor[] getAnchorsForFlowSpecification(final FlowSpecification fs, final IFeatureProvider fp) {
		Anchor a1 = null;
		Anchor a2 = null;
		
		// Determine the anchors to use for the connection
		switch(fs.getKind()) {
		case PATH:
			{
				final Feature inFeature = fs.getInEnd().getFeature();
				final Feature outFeature = fs.getOutEnd().getFeature();				
				final PictogramElement inPe = fp.getPictogramElementForBusinessObject(inFeature);
				final PictogramElement outPe = fp.getPictogramElementForBusinessObject(outFeature);
				if(inPe instanceof AnchorContainer && outPe instanceof AnchorContainer) {
					a1 = getAnchorByName(inPe, TypeFeaturePattern.connectorAnchorName);
					a2 = getAnchorByName(outPe, TypeFeaturePattern.connectorAnchorName);
				}
				break;
			}
			
		case SOURCE:
			{
				final Feature outFeature = fs.getOutEnd().getFeature();				
				final PictogramElement outPe = fp.getPictogramElementForBusinessObject(outFeature);
				a1 = getAnchorByName(outPe, TypeFeaturePattern.connectorAnchorName);
				a2 = getAnchorByName(outPe, TypeFeaturePattern.sourceAnchorName);	
				break;							
			}
			
			
		case SINK:
			{
				final Feature inFeature = fs.getInEnd().getFeature();
				final PictogramElement inPe = fp.getPictogramElementForBusinessObject(inFeature);
				a1 = getAnchorByName(inPe, TypeFeaturePattern.connectorAnchorName);
				a2 = getAnchorByName(inPe, TypeFeaturePattern.sinkAnchorName);
				break;
			}
			
		default:
			throw new RuntimeException("Unhandled case. Unsupported flow kind: " + fs.getKind());
				
		}
		
		if(a1 == null || a2 == null) {
			throw new RuntimeException("Unhandled case. Unable to get anchors");
		}
		
		return new Anchor[] {a1, a2};
	}
}
