package org.osate.ge.errormodel.pictogramHandlers;

import javax.inject.Named;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.AadlPackage;
import org.osate.ge.ExtensionPaletteEntry;
import org.osate.ge.SimplePaletteEntry;
import org.osate.ge.ExtensionPaletteEntry.Type;
import org.osate.ge.di.AllowDelete;
import org.osate.ge.di.CanCreate;
import org.osate.ge.di.CreateBusinessObject;
import org.osate.ge.di.GetCreateOwningBusinessObject;
import org.osate.ge.di.GetGraphicalRepresentation;
import org.osate.ge.di.GetName;
import org.osate.ge.di.GetPaletteEntries;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.SetName;
import org.osate.ge.di.ValidateName;
import org.osate.ge.errormodel.ErrorModelCategories;
import org.osate.ge.errormodel.util.ErrorModelBusinessObjectHelper;
import org.osate.ge.errormodel.util.ErrorModelNamingHelper;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.Ellipse;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;

public class ErrorBehaviorStateMachinePictogramHandler {
	private static final Ellipse graphics = new Ellipse();
	
	@IsApplicable
	@AllowDelete
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) ErrorBehaviorStateMachine bo) {
		return true;
	}
	
	@GetPaletteEntries
	public ExtensionPaletteEntry[] getPaletteEntries(final @Named(Names.DIAGRAM_BO) AadlPackage pkg) {
		return new ExtensionPaletteEntry[] { 
			new SimplePaletteEntry(ErrorModelCategories.ERROR_MODEL, Type.CREATE, "Error Behavior State Machine", null, null)
		};
	}
	
	@CanCreate
	public boolean canCreateShape(final @Named(Names.CONTAINER_BO) AadlPackage pkg) {
		return true;
	}

	@GetCreateOwningBusinessObject
	public Object getOwnerBusinessObject(final @Named(Names.CONTAINER_BO) AadlPackage pkg) {
		return ErrorModelBusinessObjectHelper.getOwnerBusinessObjectForErrorModelLibraryElement(pkg);
	}
	
	@CreateBusinessObject
	public Object createBusinessObject(@Named(Names.OWNER_BO) Object ownerBo) {		
		final ErrorModelLibrary errorModelLibrary = ErrorModelBusinessObjectHelper.getOrCreateErrorModelLibrary(ownerBo);
		
		// Create the ErrorBehaviorStateMachine
		final ErrorBehaviorStateMachine newBehavior = (ErrorBehaviorStateMachine)EcoreUtil.create(ErrorModelPackage.eINSTANCE.getErrorBehaviorStateMachine());
		final String newName = ErrorModelNamingHelper.buildUniqueIdentifier(errorModelLibrary, "NewErrorBehaviorStateMachine");
		newBehavior.setName(newName);
		
		// Add the new type to the error model library
		errorModelLibrary.getBehaviors().add(newBehavior);
		
		return newBehavior;
	}	
	
	@GetGraphicalRepresentation
	public Ellipse getGraphicalRepresentation() {
		return graphics;
	}
	
	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) ErrorBehaviorStateMachine stateMachine) {
		return stateMachine.getName();
	}
	
	@ValidateName
	public String validateName(final @Named(Names.BUSINESS_OBJECT) ErrorBehaviorStateMachine stateMachine, final @Named(Names.NAME) String value) {
		final ErrorModelLibrary errorModelLibrary = (ErrorModelLibrary)stateMachine.eContainer();
		return ErrorModelNamingHelper.validateName(errorModelLibrary, stateMachine.getName(), value);
	}
	
	@SetName
	public void setName(final @Named(Names.BUSINESS_OBJECT) ErrorBehaviorStateMachine stateMachine, final @Named(Names.NAME) String value) {
		stateMachine.setName(value);
	}
}
