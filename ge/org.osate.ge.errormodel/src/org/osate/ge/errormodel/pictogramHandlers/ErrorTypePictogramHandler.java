package org.osate.ge.errormodel.pictogramHandlers;

import javax.inject.Named;

import org.eclipse.emf.ecore.util.EcoreUtil;
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
import org.osate.ge.errormodel.model.ErrorTypeLibrary;
import org.osate.ge.errormodel.util.ErrorModelNamingHelper;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.Ellipse;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;

public class ErrorTypePictogramHandler {
	private static final Ellipse graphics = new Ellipse();
	
	@IsApplicable
	@AllowDelete
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) ErrorType errorType) {
		return true;
	}
	
	@GetPaletteEntries
	public ExtensionPaletteEntry[] getPaletteEntries(final @Named(Names.DIAGRAM_BO) ErrorTypeLibrary typeLib) {
		return new ExtensionPaletteEntry[] { 
			new SimplePaletteEntry(ErrorModelCategories.ERROR_MODEL, Type.CREATE, "Error Type", null, null)
		};
	}
	
	@CanCreate
	public boolean canCreateShape(final @Named(Names.CONTAINER_BO) ErrorTypeLibrary errorTypeLib) {
		return true;
	}

	@GetCreateOwningBusinessObject
	public Object getOwnerBusinessObject(final @Named(Names.CONTAINER_BO) ErrorTypeLibrary typeLib) {
		return typeLib.getErrorModelLibrary();
	}
	
	@CreateBusinessObject
	public Object createBusinessObject(@Named(Names.OWNER_BO) final ErrorModelLibrary errorModelLibrary) {				
		// Create the ErrorType
		final ErrorType newErrorType = (ErrorType)EcoreUtil.create(ErrorModelPackage.eINSTANCE.getErrorType());
		final String newErrorTypeName = ErrorModelNamingHelper.buildUniqueIdentifier(errorModelLibrary, "NewErrorType");
		newErrorType.setName(newErrorTypeName);
		
		// Add the new type to the error model library
		errorModelLibrary.getTypes().add(newErrorType);
		
		return newErrorType;
	}

	@GetGraphicalRepresentation
	public Ellipse getGraphicalRepresentation() {
		return graphics;
	}
	
	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) ErrorType bo) {
		return bo.getName();
	}
	
	@ValidateName
	public String validateName(final @Named(Names.BUSINESS_OBJECT) ErrorType errorType, final @Named(Names.NAME) String value) {
		final ErrorModelLibrary errorModelLibrary = (ErrorModelLibrary)errorType.eContainer();
		return ErrorModelNamingHelper.validateName(errorModelLibrary, errorType.getName(), value);
	}
	
	@SetName
	public void setName(final @Named(Names.BUSINESS_OBJECT) ErrorType bo, final @Named(Names.NAME) String value) {
		bo.setName(value);
	}
}
