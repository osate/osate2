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
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.Element;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.GroupExtension;
import org.osate.aadl2.ImplementationExtension;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.Realization;
import org.osate.aadl2.TypeExtension;
import org.osate.ge.di.GetChildren;
import org.osate.ge.di.GetGraphic;
import org.osate.ge.di.GetName;
import org.osate.ge.di.HandleDoubleClick;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.di.SetName;
import org.osate.ge.di.ValidateName;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.RectangleBuilder;
import org.osate.ge.internal.DiagramElementProxy;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.query.StandaloneDiagramElementQuery;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.services.QueryService;
import org.osate.ge.internal.util.ScopedEMFIndexRetrieval;
import org.osate.ge.services.GraphicalEditorService;

public class PackageHandler {
	private static final StandaloneDiagramElementQuery parentQuery = StandaloneDiagramElementQuery.create((root) -> root.ancestor(1));
	private static final Graphic packageGraphic = RectangleBuilder.create().lineWidth(2).build();
	
	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) AadlPackage pkg) {
		return true;
	}
	
	@HandleDoubleClick
	public void onDoubleclick(final @Named(Names.BUSINESS_OBJECT) AadlPackage pkg, final GraphicalEditorService editorService) {
		editorService.openBusinessObject(pkg);
	}
	
	@GetGraphic
	public Graphic getGraphicalRepresentation() {
		return packageGraphic;
	}
	
	@GetChildren
	public Stream<?> getChildren(final @Named(Names.BUSINESS_OBJECT) AadlPackage pkg, final @Named(InternalNames.DIAGRAM_ELEMENT_PROXY) DiagramElementProxy diagramElement, final ExtensionService extService, final QueryService queryService) {
		final boolean showObjectsOutsideOfPackage = queryService.getFirstBusinessObject(parentQuery, diagramElement) == null;

		// Build a list of all named elements in the public and private sections of the package
		final Set<Object> children = new HashSet<>();
		final Set<Object> connectionChildren = new HashSet<>();
		populateChildren(pkg, pkg.getPublicSection(), children, connectionChildren, showObjectsOutsideOfPackage, extService);
		populateChildren(pkg, pkg.getPrivateSection(), children, connectionChildren, showObjectsOutsideOfPackage, extService);	
		
		return Stream.concat(children.stream(), connectionChildren.stream());
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
	
	private void populateChildren(final AadlPackage pkg, final PackageSection ps, final Set<Object> children, final Set<Object> connectionChildren, final boolean showObjectsOutsideOfPackage, final ExtensionService extService) {
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
		
		for(final NamedElement el : ps.getOwnedClassifiers()) {
			if(el instanceof ComponentType) {
				final ComponentType componentType = ((ComponentType)el);
				final TypeExtension te = componentType.getOwnedExtension();
				if(componentType.getOwnedExtension() != null) {
					add(showObjectsOutsideOfPackage, pkg, children, componentType.getOwnedExtension().getGeneral());
					add(showObjectsOutsideOfPackage, pkg, connectionChildren, te);
				}
			} else if(el instanceof ComponentImplementation) {
				final ComponentImplementation componentImplementation = ((ComponentImplementation)el);
	
				// Implementation Extension
				final ImplementationExtension ie = componentImplementation.getOwnedExtension();
				if(ie != null) {
					add(showObjectsOutsideOfPackage, pkg, children, ie.getGeneral());
					add(showObjectsOutsideOfPackage, pkg, connectionChildren, ie);					
				}
				
				// Realization
				final Realization realization = componentImplementation.getOwnedRealization();
				if(realization != null) {	
					add(showObjectsOutsideOfPackage, pkg, children, realization.getGeneral());
					add(showObjectsOutsideOfPackage, pkg, connectionChildren, realization);					
				}				
			} else if(el instanceof FeatureGroupType) {
				final FeatureGroupType featureGroupType = ((FeatureGroupType)el);
				final GroupExtension ge = featureGroupType.getOwnedExtension();
				if(ge != null) {
					add(showObjectsOutsideOfPackage, pkg, children, ge.getGeneral());
					add(showObjectsOutsideOfPackage, pkg, connectionChildren, ge);
				}
			}
		}
	}
	
	private void add(final boolean showObjectsOutsideOfPackage, final AadlPackage pkg, final Set<Object> collection, final Element element) {
		if(showObjectsOutsideOfPackage || pkg == element.getElementRoot()) {
			collection.add(element);
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
