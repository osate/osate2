package org.osate.ge.errormodel;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

import javax.inject.Named;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.ge.di.BuildReference;
import org.osate.ge.di.GetProject;
import org.osate.ge.di.GetResource;
import org.osate.ge.di.GetTitle;
import org.osate.ge.di.Names;
import org.osate.ge.di.ResolveReference;
import org.osate.ge.errormodel.model.ErrorTypeLibrary;
import org.osate.ge.services.ReferenceService;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;

public class ErrorModelReferenceHandler {
	private final static String TYPE_BEHAVIOR_STATE_MACHINE = "emv2.behavior";
	private final static String TYPE_ERROR_TYPE_LIBRARY = "emv2.etl";
	private final static String TYPE_ERROR_TYPE = "emv2.et";
	
	@BuildReference
	public String[] getReference(final @Named(Names.BUSINESS_OBJECT) Object bo) {
		if(bo instanceof Element) {
			final Element el = (Element)bo;
			if(el.getElementRoot() instanceof AadlPackage) {
				final AadlPackage pkg = (AadlPackage)el.getElementRoot();
				if(bo instanceof ErrorBehaviorStateMachine) {
					return new String[] {TYPE_BEHAVIOR_STATE_MACHINE, pkg.getQualifiedName().toLowerCase(), ((ErrorBehaviorStateMachine)bo).getQualifiedName().toLowerCase()};				
				} else if(bo instanceof ErrorType) {
					return new String[] {TYPE_ERROR_TYPE, pkg.getQualifiedName().toLowerCase(), ((ErrorType)bo).getQualifiedName().toLowerCase()};				
				}  
			}
		} else if(bo instanceof ErrorTypeLibrary) {
			final ErrorTypeLibrary etl = (ErrorTypeLibrary)bo;
			if(etl.getErrorModelLibrary().getElementRoot() instanceof AadlPackage) {
				final AadlPackage pkg = (AadlPackage)etl.getErrorModelLibrary().getElementRoot();
				return new String[] {TYPE_ERROR_TYPE_LIBRARY, pkg.getQualifiedName().toLowerCase()};
			}
		}
		
		return null;
	}
	
	@GetTitle
	public String getTitle(final @Named(Names.BUSINESS_OBJECT) ErrorTypeLibrary typeLib) {
		final NamedElement elementRoot = typeLib.getErrorModelLibrary().getElementRoot();
		final String packageName = elementRoot == null ? "" : elementRoot.getQualifiedName();
		return packageName + " : Error Type Library";
	}
	
	@GetProject
	public IProject getProject(final @Named(Names.BUSINESS_OBJECT) ErrorTypeLibrary typeLib) {
		// Get the project for the error model library
		final Resource resource = typeLib.getErrorModelLibrary().eResource();
		if(resource != null) {
			final URI uri = resource.getURI();
			if(uri != null) {
				final IPath projectPath = new Path(uri.toPlatformString(true)).uptoSegment(1);
				final IResource projectResource = ResourcesPlugin.getWorkspace().getRoot().findMember(projectPath);
				if(projectResource instanceof IProject) {
					return (IProject)projectResource;
				}
			}
		}

		return null;
	}
	
	@GetResource
	public Resource getResource(final @Named(Names.BUSINESS_OBJECT) ErrorTypeLibrary typeLib) {
		return typeLib.getErrorModelLibrary().eResource();
	}
	
	@ResolveReference
	public Object getReferencedObject(final @Named(Names.REFERENCE) String[] ref, final ReferenceService refService) {
		Objects.requireNonNull(ref, "ref must not be null");

		// Handle types which require 2 reference segments
		if(ref.length < 2) {
			return null;
		}
		
		final String type = ref[0]; 
		final String pkgName = ref[1];
		final AadlPackage pkg = refService.getAadlPackage(pkgName);
		if(pkg == null || pkg.getOwnedPublicSection() == null) {
			return null;
		}

		if(type.equals(TYPE_ERROR_TYPE_LIBRARY)) {
			final Optional<ErrorModelLibrary> errorModelLibrary = pkg.getOwnedPublicSection().getOwnedAnnexLibraries().stream(). // Get annex libraries
					filter(lib -> lib instanceof DefaultAnnexLibrary && ((DefaultAnnexLibrary)lib).getParsedAnnexLibrary() instanceof ErrorModelLibrary). // Filter non EMV2 Libraries
					map(lib -> ((ErrorModelLibrary)((DefaultAnnexLibrary)lib).getParsedAnnexLibrary())). // Get parsed annex library
					findAny();
			
			if(errorModelLibrary.isPresent()) {
				final ErrorModelLibrary errorModelLib = errorModelLibrary.get();
				return new ErrorTypeLibrary(errorModelLib);
			}
			
			return null;
		}
		
		// Handle types which require 3 reference segments
		if(ref.length < 3) {
			return null;
		}
		
		final String qualifiedName = ref[2];
		if(type.equals(TYPE_BEHAVIOR_STATE_MACHINE)) {
			final Optional<ErrorBehaviorStateMachine> behavior = pkg.getOwnedPublicSection().getOwnedAnnexLibraries().stream(). // Get annex libraries
					filter(lib -> lib instanceof DefaultAnnexLibrary && ((DefaultAnnexLibrary)lib).getParsedAnnexLibrary() instanceof ErrorModelLibrary). // Filter non EMV2 Libraries
					map(lib -> ((ErrorModelLibrary)((DefaultAnnexLibrary)lib).getParsedAnnexLibrary()).getBehaviors().stream()). // Get behaviors as stream
					reduce(Stream.empty(), (a, b) -> Stream.concat(a, b)). // Combine streams
					filter(b -> qualifiedName.equalsIgnoreCase(b.getQualifiedName())). // Filter behaviors by name
					findAny();
			
			if(behavior.isPresent()) {
				return behavior.get();
			}
			
			return null;
		} else if(type.equals(TYPE_ERROR_TYPE)) {
			final Optional<ErrorType> errorType = pkg.getOwnedPublicSection().getOwnedAnnexLibraries().stream(). // Get annex libraries
					filter(lib -> lib instanceof DefaultAnnexLibrary && ((DefaultAnnexLibrary)lib).getParsedAnnexLibrary() instanceof ErrorModelLibrary). // Filter non EMV2 Libraries
					map(lib -> ((ErrorModelLibrary)((DefaultAnnexLibrary)lib).getParsedAnnexLibrary()).getTypes().stream()). // Get types as stream
					reduce(Stream.empty(), (a, b) -> Stream.concat(a, b)). // Combine streams
					filter(b -> qualifiedName.equalsIgnoreCase(b.getQualifiedName())). // Filter behaviors by name
					findAny();
			
			if(errorType.isPresent()) {
				return errorType.get();
			}
			
			return null;
		}
		
		return null;
	}
}
