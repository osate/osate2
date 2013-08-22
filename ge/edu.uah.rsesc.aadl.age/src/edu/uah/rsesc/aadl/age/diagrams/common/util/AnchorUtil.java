package edu.uah.rsesc.aadl.age.diagrams.common.util;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.ChopboxAnchor;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.FixPointAnchor;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.services.IPeService;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Connection;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.Context;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FlowEnd;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.Generalization;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.ModeTransitionTrigger;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.TriggerPort;

import edu.uah.rsesc.aadl.age.diagrams.common.patterns.AgePattern;
import edu.uah.rsesc.aadl.age.diagrams.common.patterns.FeaturePattern;
import edu.uah.rsesc.aadl.age.diagrams.common.patterns.ModePattern;

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
	        PropertyUtil.setName(anchor, name);
	        return anchor;
		}
		else if(retrievedAnchor instanceof ChopboxAnchor) {
			return (ChopboxAnchor)retrievedAnchor;
		}
		else {
			throw new RuntimeException("Retrieved anchor is of invalid type: " + retrievedAnchor.getClass().getName());	
		}        
	}
	
	public static FixPointAnchor createOrUpdateFixPointAnchor(final AnchorContainer shape, final String name, final int x, final int y) {
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		final IGaService gaService = Graphiti.getGaService();
		
		// Create or get the anchor by name
		final Anchor retrievedAnchor = getAnchorByName(shape, name);
		final FixPointAnchor anchor;
		if(retrievedAnchor == null) {
			anchor = peCreateService.createFixPointAnchor(shape);
			PropertyUtil.setName(anchor, name);
			// Theoretically this could be done for the retrieved anchor as well to ensure it has the proper graphical algorithm. Practically it causes problem for Graphiti
			// for an unknown reason when moving feature groups. We do it only when creating the anchor for that reason
			gaService.createInvisibleRectangle(anchor);			
		} else {
			if(!(retrievedAnchor instanceof FixPointAnchor)) {
				throw new RuntimeException("Retrieved anchor is of invalid type: " + retrievedAnchor.getClass().getName());	
			}
			
			anchor = (FixPointAnchor)retrievedAnchor;
		}

		// Configure the anchor
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
	 * Determines whether s1 contains s2
	 * @param s1
	 * @param s2
	 * @return
	 */
	private static boolean doesShapeContain(final Shape s1, final Shape s2) {
		Shape temp = s2.getContainer();
		while(temp != null) {
			if(temp == s1) {
				return true;
			}
			
			temp = temp.getContainer();
		}
		return false;
	}
	
	// TODO: Document arguments
	public static Anchor[] getAnchorsForConnection(final ComponentImplementation componentImplementation, final Connection connection, final IFeatureProvider fp) {
		Anchor a1 = null;
		Anchor a2 = null;
		
		// Get the pictogram elements for the source and destination of the connection
		final PictogramElement sourcePe = getPictogramElement(componentImplementation, connection.getAllSource(), connection.getAllSourceContext(), connection.getAllSrcContextComponent(), fp);
		final PictogramElement destPe = getPictogramElement(componentImplementation, connection.getAllDestination(), connection.getAllDestinationContext(), connection.getAllDstContextComponent(), fp);
		
		// Check if the sourcePe and destPe are valid
		if(sourcePe == null || !(sourcePe instanceof Shape) || destPe == null || !(destPe instanceof Shape)) {
			return null;
		}
		final Shape sourceShape = (Shape)sourcePe;
		final Shape destShape = (Shape)destPe;
		final IPeService peService = Graphiti.getPeService();
		
		// Get the appropriate anchors
		a1 = getAnchorByName(sourcePe, doesShapeContain(sourceShape.getContainer(), destShape) ? FeaturePattern.innerConnectorAnchorName : FeaturePattern.outerConnectorAnchorName);
		if(a1 == null) {
			a1 = peService.getChopboxAnchor((AnchorContainer)sourcePe);
		}

		a2 = getAnchorByName(destPe, doesShapeContain(destShape.getContainer(), sourceShape) ? FeaturePattern.innerConnectorAnchorName : FeaturePattern.outerConnectorAnchorName);
		if(a2 == null) {
			a2 = peService.getChopboxAnchor((AnchorContainer)destPe);
		}
		
		if(a1 == null || a2 == null) {
			return null;
		}

		return new Anchor[] {a1, a2};
	}
	
	/**
	 * 
	 * @return an array containing the anchors. Guaranteed not to be null.
	 */
	public static Anchor[] getAnchorsForFlowSpecification(final FlowSpecification fs, final ContainerShape ownerShape, final IFeatureProvider fp) {
		Anchor a1 = null;
		Anchor a2 = null;
		
		final PictogramElement inPe = getFlowEndPictogramElement(fs.getAllInEnd(), ownerShape, fp);
		final PictogramElement outPe = getFlowEndPictogramElement(fs.getAllOutEnd(), ownerShape, fp);
		
		// Determine the anchors to use for the connection
		switch(fs.getKind()) {
		case PATH:
			{
				a1 = getAnchorByName(inPe, FeaturePattern.innerConnectorAnchorName);
				a2 = getAnchorByName(outPe, FeaturePattern.innerConnectorAnchorName);
				break;
			}
			
		case SOURCE:
			{
				a1 = getAnchorByName(outPe, FeaturePattern.innerConnectorAnchorName);
				a2 = getAnchorByName(outPe, FeaturePattern.flowSpecificationAnchorName);	
				break;
			}

		case SINK:
			{
				a1 = getAnchorByName(inPe, FeaturePattern.innerConnectorAnchorName);
				a2 = getAnchorByName(inPe, FeaturePattern.flowSpecificationAnchorName);	
				break;		
			}
			
		default:
			throw new RuntimeException("Unhandled case. Unsupported flow kind: " + fs.getKind());
				
		}

		if(a1 == null || a2 == null) {
			return null;
		}
		
		return new Anchor[] {a1, a2};
	}
	
	public static Anchor[] getAnchorsForModeTransition(final ModeTransition mt, final IFeatureProvider fp) {
		final ContainerShape srcShape = (ContainerShape)fp.getPictogramElementForBusinessObject(mt.getSource());
		final ContainerShape dstShape = (ContainerShape)fp.getPictogramElementForBusinessObject(mt.getDestination());
		if(srcShape == null || dstShape == null) {
			return null;
		}				
		
		final Anchor a1 = getAnchorByName(ShapeHelper.getChildShapeByName(srcShape, ModePattern.innerModeShapeName), AgePattern.chopboxAnchorName);
		final Anchor a2 = getAnchorByName(ShapeHelper.getChildShapeByName(dstShape, ModePattern.innerModeShapeName), AgePattern.chopboxAnchorName);		
		
		if(a1 == null || a2 == null) {
			return null;
		}
		
		return new Anchor[] {a1, a2};
	}
	
	/**
	 * Returns the anchor for the feature references by a mode transition trigger
	 * @param trigger
	 * @param ownerShape the shape corresponding to the owner of the mode and mode transition. Should be a representation of Component Classifier.
	 * @param fp
	 * @return
	 */
	public static Anchor getAnchorForModeTransitionTrigger(final ModeTransitionTrigger trigger, final ContainerShape ownerShape, final ContainerShape modeShape, final IFeatureProvider fp) {
		if(trigger instanceof TriggerPort) {
			final TriggerPort tp = (TriggerPort)trigger;
			final ContainerShape portShapeOwner = tp.getContext() == null ? ownerShape : ShapeHelper.getChildShapeByElement(ownerShape, tp.getContext(), fp);
			final ContainerShape portShape = (portShapeOwner == null || tp.getPort() == null) ? null : ShapeHelper.getChildShapeByElement(portShapeOwner, tp.getPort(), fp);
			
			// Get appropriate anchor depending on whether the port belongs to the component classifier or a subcomponent
			return getAnchorByName(portShape, doesShapeContain(portShape.getContainer(), modeShape) ? FeaturePattern.innerConnectorAnchorName : FeaturePattern.outerConnectorAnchorName);
		} else {
			// Unhandled case
			return null;
		}
	}
	
	/**
	 * 
	 * @param componentImplementation the component implementation to use as a context for resolving the connection end if necessary
	 * @param ce
	 * @param context
	 * @param contextComponent
	 * @param fp
	 * @return
	 */
	private static PictogramElement getPictogramElement(final ComponentImplementation componentImplementation, final ConnectionEnd ce, final Context context, final NamedElement contextComponent, final IFeatureProvider fp) {
		if(ce == null) {
			return null;
		}
		
		// Get the PE for the context component
		PictogramElement pe = null;
		if(contextComponent != null) {
			pe = fp.getPictogramElementForBusinessObject(contextComponent);
			if(pe == null || !(pe instanceof ContainerShape)) {
				return null;
			}
		} 
		
		if(context != null && contextComponent != context) {
			if(pe == null) {			
				// TODO: Throw exception? Unhandled case. Context without context component
				return null;
			} else {
				// Get the shape for the context
				pe = ShapeHelper.getDescendantShapeByElement((ContainerShape)pe, context, fp);
				if(pe == null || !(pe instanceof ContainerShape)) {
					return null;
				}
			}
		}
		
		// If the connection end did not have a context
		if(pe == null) {
			pe = fp.getPictogramElementForBusinessObject(componentImplementation);
			if(pe == null || !(pe instanceof ContainerShape)) {
				return null;
			}
		}
		
		// Get Descendant PE
		pe = ShapeHelper.getDescendantShapeByElement((ContainerShape)pe, ce, fp);
		
		// CLEAN-UP: Clarify or remove comments
		// Case: Just CE is valid. (Probably a feature? could be a component)
		// Return it's PE
		
		// Case: CE is valid. Context and context component is the same.
		// Get the PE of Context. Retrieve PE of the child of the context PE for CE.
		
		// Case: CE is valid. Context is a subcomponent. Context is a feature group
		// 

		return pe;
	}
	
	public static PictogramElement getFlowEndPictogramElement(final FlowEnd fe, final ContainerShape ownerShape, final IFeatureProvider fp) {
		if(fe == null) {
			return null;
		}
		
		if(fe.getContext() instanceof FeatureGroup) {
			final FeatureGroup fg = (FeatureGroup)fe.getContext();
			final PictogramElement fgPe = ShapeHelper.getChildShapeByElement(ownerShape, fg, fp);
			if(fgPe instanceof ContainerShape) {
				final ContainerShape fgCs = FeaturePattern.getFeatureShape((ContainerShape)fgPe);
				return ShapeHelper.getChildShapeByElement(fgCs, fe.getFeature(), fp);
			}
			
		} else {
			return ShapeHelper.getChildShapeByElement(ownerShape, fe.getFeature(), fp);
		}
		
		
		return null;
	}
}
