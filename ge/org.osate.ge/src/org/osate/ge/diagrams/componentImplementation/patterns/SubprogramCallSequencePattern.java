package org.osate.ge.diagrams.componentImplementation.patterns;

import javax.inject.Inject;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Display;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.BehavioredImplementation;
import org.osate.aadl2.CallContext;
import org.osate.aadl2.CalledSubprogram;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramCallSequence;
import org.osate.ge.diagrams.common.AadlElementWrapper;
import org.osate.ge.diagrams.common.AgeImageProvider;
import org.osate.ge.diagrams.common.Categorized;
import org.osate.ge.diagrams.common.patterns.AgePattern;
import org.osate.ge.dialogs.DefaultSelectSubprogramDialogModel;
import org.osate.ge.dialogs.SelectSubprogramDialog;
import org.osate.ge.services.AadlFeatureService;
import org.osate.ge.services.AadlModificationService;
import org.osate.ge.services.BusinessObjectResolutionService;
import org.osate.ge.services.DiagramModificationService;
import org.osate.ge.services.AadlModificationService.AbstractModifier;
import org.osate.ge.services.NamingService;
import org.osate.ge.services.ShapeCreationService;

public class SubprogramCallSequencePattern extends AgePattern implements Categorized {
	private final NamingService namingService;
	private final ShapeCreationService shapeCreationService;
	private final AadlModificationService aadlModService;
	private final DiagramModificationService diagramModService;
	private final AadlFeatureService featureService;
	private final BusinessObjectResolutionService bor;
	
	@Inject
	public SubprogramCallSequencePattern(final NamingService namingService, final ShapeCreationService shapeCreationService, final AadlModificationService aadlModService,
			final DiagramModificationService diagramModService, final AadlFeatureService featureService, final BusinessObjectResolutionService bor) {
		this.namingService = namingService;
		this.shapeCreationService = shapeCreationService;
		this.aadlModService = aadlModService;
		this.diagramModService = diagramModService;
		this.featureService = featureService;
		this.bor = bor;		
	}
	
	@Override
	public Category getCategory() {
		return Category.SUBPROGRAM_CALLS;
	}

	@Override
	public boolean isMainBusinessObjectApplicable(final Object mainBusinessObject) {
		final Object bo = AadlElementWrapper.unwrap(mainBusinessObject);
		return bo instanceof SubprogramCallSequence;
	}
	
	// Create
	@Override
	public boolean isPaletteApplicable() {
		return bor.getBusinessObjectForPictogramElement(getDiagram()) instanceof BehavioredImplementation;
	}
	
	@Override
	public String getCreateName() {
		return "Subprogram Call Sequence";
	}
		
	@Override
	public String getCreateImageId(){
		final Aadl2Package p = Aadl2Factory.eINSTANCE.getAadl2Package();
		return AgeImageProvider.getImage(p.getSubprogramCallSequence());
	}
	
	@Override
	public boolean canCreate(final ICreateContext context) {		
		final Object containerBo = bor.getBusinessObjectForPictogramElement(context.getTargetContainer());
		return !(context.getTargetContainer() instanceof Diagram) && containerBo instanceof BehavioredImplementation;
	}
	
	@Override
	public Object[] create(final ICreateContext context) {
		final BehavioredImplementation bi = (BehavioredImplementation)bor.getBusinessObjectForPictogramElement(context.getTargetContainer());
		if(bi == null) {
			return EMPTY;
		}
		
		final DefaultSelectSubprogramDialogModel subprogramSelectionModel = new DefaultSelectSubprogramDialogModel(featureService, bi);

		final SelectSubprogramDialog dlg = new SelectSubprogramDialog(Display.getCurrent().getActiveShell(), subprogramSelectionModel);
		if(dlg.open() == Dialog.CANCEL) {
			return EMPTY;
		}
		
		// Get the CallContext and Called Subprogram
		final CallContext callContext = subprogramSelectionModel.getCallContext(dlg.getSelectedContext());		
		final CalledSubprogram calledSubprogram = subprogramSelectionModel.getCalledSubprogram(dlg.getSelectedSubprogram());
	
		// Get the classifier
		final String newScsName = namingService.buildUniqueIdentifier(bi, "new_call_sequence");
		final String initialSubprogramCallName = namingService.buildUniqueIdentifier(bi, "new_call");
		
		// Make the modification
		final SubprogramCallSequence newScs = aadlModService.modify(bi, new AbstractModifier<BehavioredImplementation, SubprogramCallSequence>() {
			private DiagramModificationService.Modification diagramMod;
			
			@Override
			public SubprogramCallSequence modify(final Resource resource, final BehavioredImplementation bi) {
				
				// Handle diagram updates
	 			diagramMod = diagramModService.startModification();
	 			diagramMod.markRelatedDiagramsAsDirty(bi);
	 			
	 			final SubprogramCallSequence newScs = bi.createOwnedSubprogramCallSequence();
	 			newScs.setName(newScsName);

	 			// Create an initial call. Needed because call sequences must have at least one call
	 			final SubprogramCall initialSubprogramCall = newScs.createOwnedSubprogramCall();
	 			initialSubprogramCall.setName(initialSubprogramCallName);	 			
	 			initialSubprogramCall.setContext(callContext);
	 			initialSubprogramCall.setCalledSubprogram(calledSubprogram);
	 			
				// Clear the no calls flag
	 			bi.setNoCalls(false);
				
				return newScs;
			}
			
			@Override
			public void beforeCommit(final Resource resource, final BehavioredImplementation bi, final SubprogramCallSequence newScs) {
				diagramMod.commit();
				shapeCreationService.createShape(context.getTargetContainer(), newScs, context.getX(), context.getY());							
			}
		});

		// Return the new call sequence if it was created
		return newScs == null ? EMPTY : new Object[] {newScs};
	}
}
