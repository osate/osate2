package org.osate.ge.internal.businessObjectHandlers;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;
import javax.inject.Named;
import org.eclipse.core.resources.IProject;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.Generalization;
import org.osate.aadl2.GroupExtension;
import org.osate.aadl2.ImplementationExtension;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.Realization;
import org.osate.aadl2.TypeExtension;
import org.osate.ge.di.GetChildren;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.services.SerializableReferenceService;
import org.osate.ge.internal.util.ScopedEMFIndexRetrieval;

/**
 * Handler for the root business object for project overview diagrams
 * This is currently work in progress and is currently disabled. The proejct overview diagram will display all packages that are accessible by the project. 
 * Notes:
 *     Set Diagram Name - "PROJECT_NAME Overview"?
 *     Add UI option to Open Overview Diagram. Update documentation
 *     Issue: Tried to rename built in type. Received error as desired, but shape was renamed and encountered errors after updating.
 *     Issue: Created new package from AADL Navigator and it did not appear even after updating.
 *     Issue: Adding extend data type in another package with generalization business object handler did not add with clause.				
 *     Issue: When adding type to package, diagram is not being updated automatically.
 *     TODO: Ability to rename package
 *         Package disappears... Connections remain. Disappear on save.
 *         Need to keep existing layout. That goes along with refactoring issues though.
 *     TODO: Add ability to create package. Also delete file?
 *     TODO: Ability to delete packages.					
 *     TODO: When showing contents, show relationships between elements. That part is done. However, don't try to do it when not showing contents.				
 *     TODO: When not showing contents, show relationships between packages? Flatten relationships
 *     TODO: Allow editing contents of package from package view?
 *     Consider: Had to modify ClassifierBusinessObject and GeneralizationHandler to allow palette entries for overview. Is there a way to abstract that out to avoid having to change those?
 */
public class ProjectOverviewHandler {	
	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) ProjectOverview bo) {
		return true;
	}
	
	@GetChildren
	public Stream<?> getChildren(final @Named(InternalNames.PROJECT) IProject project, final SerializableReferenceService serializableReferenceService) {
		Stream.Builder<Object> streamBuilder = Stream.builder();
		
		final Set<AadlPackage> packages = new HashSet<>();
		for(final IEObjectDescription desc : ScopedEMFIndexRetrieval.getAllEObjectsByType(project, Aadl2Factory.eINSTANCE.getAadl2Package().getAadlPackage())) {
			final AadlPackage pkg = serializableReferenceService.getAadlPackage(desc.getQualifiedName().toString("::"));
			if(pkg != null) {
				packages.add(pkg);
				streamBuilder.add(pkg);
			}
		}

		// TODO: Only do that when showing contents..
		for(final AadlPackage pkg : packages) {
			addGeneralizationsBetweenPackages(pkg.getPublicSection(), streamBuilder);
			addGeneralizationsBetweenPackages(pkg.getPrivateSection(), streamBuilder);
		}
		
		return streamBuilder.build();
	}
	
	private void addGeneralizationsBetweenPackages(final PackageSection section, final Stream.Builder<Object> boStreamBuilder) {
		if(section == null) {
			return;
		}
		
		for(final NamedElement el : section.getOwnedClassifiers()) {
			if(el instanceof ComponentType) {
				final ComponentType componentType = ((ComponentType)el);
				final TypeExtension te = componentType.getOwnedExtension();
				if(componentType.getOwnedExtension() != null) {
					addIfPackagesDiffer(boStreamBuilder, te);
				}
			} else if(el instanceof ComponentImplementation) {
				final ComponentImplementation componentImplementation = ((ComponentImplementation)el);
	
				// Implementation Extension
				final ImplementationExtension ie = componentImplementation.getOwnedExtension();
				if(ie != null) {
					addIfPackagesDiffer(boStreamBuilder, ie);					
				}
				
				// Realization
				final Realization realization = componentImplementation.getOwnedRealization();
				if(realization != null) {	
					addIfPackagesDiffer(boStreamBuilder, realization);					
				}				
			} else if(el instanceof FeatureGroupType) {
				final FeatureGroupType featureGroupType = ((FeatureGroupType)el);
				final GroupExtension ge = featureGroupType.getOwnedExtension();
				if(ge != null) {
					addIfPackagesDiffer(boStreamBuilder, ge);
				}
			}
		}
	}
	
	private void addIfPackagesDiffer(final Stream.Builder<Object> boStreamBuilder, final Generalization gen) {
		if(gen.getGeneral() != null && gen.getSpecific() != null) {
			if(gen.getGeneral().getElementRoot() != gen.getSpecific().getElementRoot()) {
				boStreamBuilder.add(gen);
			}
		}
	}
}
