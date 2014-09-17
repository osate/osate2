package org.osate.ge.diagrams.common.features;

import javax.inject.Inject;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Display;
import org.osate.aadl2.ArrayableElement;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.dialogs.EditDimensionsDialog;
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
        return "Modify Dimensions...";
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
		
		// Check that the pictogram represents an Arrayable Element
		final Object bo = bor.getBusinessObjectForPictogramElement(pe);
		if(!(bo instanceof ArrayableElement)) {
			return false;
		}
		
		final Object diagramBo = bor.getBusinessObjectForPictogramElement(getDiagram());
		final ArrayableElement ae = (ArrayableElement)bo;
		return ae.getContainingClassifier() == diagramBo;
	}
	
    @Override
    public boolean canExecute(final ICustomContext context) {
    	return true;
    }
        
	@Override
	public void execute(final ICustomContext context) {
		final PictogramElement pe = (PictogramElement)context.getPictogramElements()[0];
		final ArrayableElement ae = (ArrayableElement)bor.getBusinessObjectForPictogramElement(pe);
		
		final EditDimensionsDialog dlg = new EditDimensionsDialog(Display.getCurrent().getActiveShell(), ae.getArrayDimensions(), ae instanceof Subcomponent);
		if(dlg.open() == Dialog.CANCEL) {
			return;
		}
		
		// Update the dimensions
		aadlModService.modify(ae, new AbstractModifier<ArrayableElement, Object>() {
			private DiagramModificationService.Modification diagramMod;    	
			
			@Override
			public Object modify(final Resource resource, final ArrayableElement ae) {
				// Start the diagram modification
     			diagramMod = diagramModService.startModification();
     			
				// Clear existing flows
				ae.getArrayDimensions().clear();
				ae.getArrayDimensions().addAll(dlg.getDimensions());
				
				diagramMod.markRelatedDiagramsAsDirty(ae.getContainingClassifier());
				
				return null;
			}
			
	 		@Override
			public void beforeCommit(final Resource resource, final ArrayableElement ae, final Object modificationResult) {
				diagramMod.commit();
			}
		});
	}

}
