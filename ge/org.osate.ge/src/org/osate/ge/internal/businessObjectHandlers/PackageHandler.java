package org.osate.ge.internal.businessObjectHandlers;

import javax.inject.Named;

import org.eclipse.core.resources.IProject;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.AadlPackage;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.GetName;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.di.ValidateName;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.graphics.FolderGraphicBuilder;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.util.ScopedEMFIndexRetrieval;

public class PackageHandler {
	private final Graphic graphic = FolderGraphicBuilder.create().build();
	
	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) AadlPackage pkg) {
		return true;
	}
	
	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalConfiguration() {
		return GraphicalConfigurationBuilder.create().
				graphic(graphic).
				build();
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
}
