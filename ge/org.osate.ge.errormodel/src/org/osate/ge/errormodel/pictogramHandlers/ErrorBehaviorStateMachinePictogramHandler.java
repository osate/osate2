package org.osate.ge.errormodel.pictogramHandlers;

import javax.inject.Named;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.osate.aadl2.AadlPackage;
import org.osate.ge.errormodel.ErrorModelCategories;
import org.osate.ge.errormodel.util.ErrorModelBusinessObjectHelper;
import org.osate.ge.errormodel.util.ErrorModelNamingHelper;
import org.osate.ge.ext.ExtensionPaletteEntry;
import org.osate.ge.ext.ExtensionPaletteEntry.Type;
import org.osate.ge.ext.Names;
import org.osate.ge.ext.SimplePaletteEntry;
import org.osate.ge.ext.annotations.CanCreate;
import org.osate.ge.ext.annotations.CanRefresh;
import org.osate.ge.ext.annotations.CreateBusinessObject;
import org.osate.ge.ext.annotations.GetCreateOwningBusinessObject;
import org.osate.ge.ext.annotations.GetPaletteEntries;
import org.osate.ge.ext.annotations.RefreshShape;
import org.osate.ge.ext.annotations.RefreshGraphics;
import org.osate.ge.ext.services.PictogramElementService;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;

public class ErrorBehaviorStateMachinePictogramHandler {
	@GetPaletteEntries
	public ExtensionPaletteEntry[] getPaletteEntries() {
		return new ExtensionPaletteEntry[] { 
			new SimplePaletteEntry(ErrorModelCategories.ERROR_MODEL, Type.CREATE, "Error Behavior State Machine", null, null)
		};
	}
	
	@CanCreate
	public boolean canCreateShape(final @Named(Names.CONTAINER) ContainerShape container, final PictogramElementService peService) {
		return peService.getBusinessObject(container) instanceof AadlPackage && container instanceof Diagram;
	}

	@GetCreateOwningBusinessObject
	public Object getOwnerBusinessObject(final @Named(Names.CONTAINER) ContainerShape container, final PictogramElementService peService) {
		return ErrorModelBusinessObjectHelper.getOwnerBusinessObjectForErrorModelLibraryElement(container, peService);
	}
	
	@CreateBusinessObject
	public Object createBusinessObject(@Named(Names.OWNER_BO) Object ownerBo) {		
		final ErrorModelLibrary errorModelLibrary = ErrorModelBusinessObjectHelper.getOrCreateErrorModelLibrary(ownerBo);
		
		// Create the ErrorType
		final ErrorBehaviorStateMachine newBehavior = (ErrorBehaviorStateMachine)EcoreUtil.create(ErrorModelPackage.eINSTANCE.getErrorBehaviorStateMachine());
		final String newErrorTypeName = ErrorModelNamingHelper.buildUniqueIdentifier(errorModelLibrary, "NewErrorBehaviorStateMachine");
		newBehavior.setName(newErrorTypeName);
		
		// Add the new type to the error model library
		errorModelLibrary.getBehaviors().add(newBehavior);
		
		return newBehavior;
	}	
	
	@CanRefresh
	public boolean canRefresh(final @Named(Names.BUSINESS_OBJECT) ErrorBehaviorStateMachine bo) {
		return true;
	}

	@RefreshShape
	public ContainerShape refreshChildren(final @Named(Names.CONTAINER) ContainerShape container, @Named(Names.PICTOGRAM_ELEMENT) ContainerShape shape, 
			final @Named(Names.BUSINESS_OBJECT) ErrorBehaviorStateMachine behavior, final PictogramElementService pes) {
        // Create the container shape
		if(shape == null) {
			final IPeCreateService peCreateService = Graphiti.getPeCreateService();
	        shape = peCreateService.createContainerShape(container, true);			
		}
		
        return shape;
	}
	
	@RefreshGraphics 
	public void refreshGraphics(@Named(Names.PICTOGRAM_ELEMENT) ContainerShape shape) {
		
        // Recreate the graphics algorithm
		final IGaService gaService = Graphiti.getGaService();
        final GraphicsAlgorithm ga = gaService.createPlainEllipse(shape);
        		
		// TODO: Set appropriate size. Should behave like other pictograms. Use current size as minimum and expand as necessary
        ga.setWidth(50);
        ga.setHeight(50);
	}
}
