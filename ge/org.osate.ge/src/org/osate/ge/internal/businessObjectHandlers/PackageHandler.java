package org.osate.ge.internal.businessObjectHandlers;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;
import javax.inject.Named;

import org.eclipse.core.resources.IProject;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PackageSection;
import org.osate.ge.di.GetChildren;
import org.osate.ge.di.GetName;
import org.osate.ge.di.HandleDoubleClick;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.di.SetName;
import org.osate.ge.di.ValidateName;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.util.ScopedEMFIndexRetrieval;
import org.osate.ge.services.GraphicalEditorService;
import org.osate.ge.services.QueryService;

public class PackageHandler {
	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) AadlPackage pkg) {
		return true;
	}
	
	@HandleDoubleClick
	public void onDoubleclick(final @Named(Names.BUSINESS_OBJECT) AadlPackage pkg, final GraphicalEditorService editorService) {
		editorService.openBusinessObject(pkg);
	}
		
	@GetChildren
	public Stream<?> getChildren(final @Named(Names.BUSINESS_OBJECT) AadlPackage pkg, final ExtensionService extService, final QueryService queryService) {
		// Build a list of all named elements in the public and private sections of the package
		final Set<Object> children = new HashSet<>();
		populateChildren(pkg, pkg.getPublicSection(), children, extService);
		populateChildren(pkg, pkg.getPrivateSection(), children, extService);	
		
		return children.stream();
	}
	
	private NamedElement getParsedAnnexLibrary(final NamedElement annexLibrary) {
		if(annexLibrary instanceof DefaultAnnexLibrary) {
			final NamedElement parsedLib = ((DefaultAnnexLibrary) annexLibrary).getParsedAnnexLibrary();
			
			// Don't return libraries which inherit from DefaultAnnexLibrary
			if(parsedLib instanceof DefaultAnnexLibrary) {
				return null;
			}
			
			return parsedLib;
		}
		
		return null;
	}
	
	private void populateChildren(final AadlPackage pkg, final PackageSection ps, final Set<Object> children, final ExtensionService extService) {
		if(ps == null) {
			return;
		}
		
		children.addAll(ps.getOwnedClassifiers());
		
		for(final AnnexLibrary annexLibrary : ps.getOwnedAnnexLibraries()) {
			//children.addAll(ps.getOwnedAnnexLibraries());
			final NamedElement parsedAnnexLibrary = getParsedAnnexLibrary(annexLibrary);
			final boolean specializedHandling = parsedAnnexLibrary != null && extService.getApplicableBusinessObjectHandler(parsedAnnexLibrary) != null;

			// Create the generic shape if specialized handling wasn't used
			if(specializedHandling) {
				children.add(parsedAnnexLibrary);
			} else {
				children.add(annexLibrary);
			}
		}
	}
	
	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) AadlPackage pkg) {
		return pkg.getQualifiedName();
	}
	
	@ValidateName
	public String validateName(final @Named(Names.BUSINESS_OBJECT) AadlPackage pkg, final @Named(Names.NAME) String value, 
			final @Named(InternalNames.PROJECT) IProject project, final NamingService namingService) {
    	// If the name hasn't changed or has only changed case
    	if(value.equalsIgnoreCase(pkg.getQualifiedName())) {
    		return null;
    	}
    	    
    	final String[] segments = value.split("::");
    	for(String segment : segments) {
    		if(segment.length() == 0) {
    			return "One of the segments in the package name is empty.";
    		}
    		
        	if(!namingService.isValidIdentifier(segment)) {
        		return "The segment '" + segment + "' is not valid.";
        	}
    	}
    	// Compare names with other packages
		for(final IEObjectDescription desc : ScopedEMFIndexRetrieval.getAllEObjectsByType(project, Aadl2Factory.eINSTANCE.getAadl2Package().getAadlPackage())) {
			if(value.equalsIgnoreCase(desc.getQualifiedName().toString("::"))) {
				return "The specified name conflicts with an existing package.";
			}
		}
		
        // The value is valid
        return null;        
	}
	
	@SetName
	public void setName(final @Named(Names.BUSINESS_OBJECT) AadlPackage pkg, final @Named(Names.NAME) String value) {
		pkg.setName(value);
	}
}
