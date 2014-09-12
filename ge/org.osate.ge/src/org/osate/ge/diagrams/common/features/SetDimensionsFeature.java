package org.osate.ge.diagrams.common.features;

import javax.inject.Inject;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.ArrayableElement;
import org.osate.ge.services.AadlModificationService;
import org.osate.ge.services.BusinessObjectResolutionService;
import org.osate.ge.services.DiagramModificationService;
import org.osate.ge.services.AadlModificationService.AbstractModifier;

public class SetDimensionsFeature extends AbstractCustomFeature {
	private final AadlModificationService aadlModService;
	private final DiagramModificationService diagramModService;
	private final BusinessObjectResolutionService bor;
	
	@Inject
	public SetDimensionsFeature(final AadlModificationService aadlModService, final DiagramModificationService diagramModService, final BusinessObjectResolutionService bor, final IFeatureProvider fp) {
		super(fp);
		this.aadlModService = aadlModService;
		this.diagramModService = diagramModService;
		this.bor = bor;
	}
	
	@Override
    public String getName() {
        return "Set Array Dimensions...";
    }
	
	@Override
	public boolean canUndo(final IContext context) {
		return false;
	}
	
	@Override
	public boolean isAvailable(final IContext context) {
		final ICustomContext customCtx = (ICustomContext)context;
		final PictogramElement[] pes = customCtx.getPictogramElements();		
		if(customCtx.getPictogramElements().length != 1) {
			return false;
		}
		
		final PictogramElement pe = pes[0];
		if(!(pe instanceof Shape)) {
			return false;
		}
		
		// Check that the pictogram represents a mode	
		final Object bo = bor.getBusinessObjectForPictogramElement(pe);
		if(!(bo instanceof ArrayableElement)) {
			return false;
		}
		
		// Only allow setting the value if the new value would be different, the classifier contains nodes, and the classifier has not inherited any modes or mode transitions
		/*final ComponentClassifier cc = (ComponentClassifier)bo;
		return cc.isDerivedModes() != derivedModes && (cc.getOwnedModes().size() > 0 || cc.getOwnedModeTransitions().size() > 0) && cc.getAllModes().size() == cc.getOwnedModes().size() && cc.getAllModeTransitions().size() == cc.getOwnedModeTransitions().size() ;
		*/
		return true;
	}
	
    @Override
    public boolean canExecute(final ICustomContext context) {
    	/*
    	// Only allow changing whether the modes are derived if it is being set to false or if there are no mode transitions. Mode transitions are not allowed
    	// in requires mode clauses
    	final PictogramElement pe = (PictogramElement)context.getPictogramElements()[0];
		final ComponentClassifier cc = (ComponentClassifier)bor.getBusinessObjectForPictogramElement(pe);
    	return !derivedModes || cc.getOwnedModeTransitions().size() == 0;
    	*/
    	return true;
    }
        
	@Override
	public void execute(final ICustomContext context) {
		/*
		final PictogramElement pe = (PictogramElement)context.getPictogramElements()[0];
		final ComponentClassifier cc = (ComponentClassifier)bor.getBusinessObjectForPictogramElement(pe);
		
		aadlModService.modify(cc, new AbstractModifier<ComponentClassifier, Object>() {
			private DiagramModificationService.Modification diagramMod;    	
			
			@Override
			public Object modify(final Resource resource, final ComponentClassifier cc) {
				// Start the diagram modification
     			diagramMod = diagramModService.startModification();
     			
				cc.setDerivedModes(derivedModes);
				diagramMod.markRelatedDiagramsAsDirty(cc);

				return null;
			}
			
	 		@Override
			public void beforeCommit(final Resource resource, final ComponentClassifier cc, final Object modificationResult) {
				diagramMod.commit();
			}
		});
		*/
	}

}
