package org.osate.ge.internal;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.inject.Named;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.BehavioredImplementation;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentPrototype;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Connection;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.GroupExtension;
import org.osate.aadl2.ImplementationExtension;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.Realization;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubprogramAccess;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramCallSequence;
import org.osate.aadl2.SubprogramClassifier;
import org.osate.aadl2.SubprogramImplementation;
import org.osate.aadl2.SubprogramProxy;
import org.osate.aadl2.SubprogramSubcomponent;
import org.osate.aadl2.SubprogramSubcomponentType;
import org.osate.aadl2.SubprogramType;
import org.osate.aadl2.TypeExtension;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.di.Activate;
import org.osate.ge.di.Names;
import org.osate.ge.internal.businessObjectHandlers.ModeTransitionTriggerHandler;
import org.osate.ge.internal.model.BusinessObjectProxy;
import org.osate.ge.internal.model.SubprogramCallOrder;
import org.osate.ge.internal.model.Tag;
import org.osate.ge.internal.services.ExtensionRegistryService;
import org.osate.ge.internal.services.ReferenceService;
import org.osate.ge.internal.services.impl.DeclarativeReferenceBuilder;
import org.osate.ge.internal.util.AadlFeatureUtil;
import org.osate.ge.internal.util.AadlHelper;
import org.osate.ge.internal.util.AadlSubcomponentUtil;
import org.osate.ge.internal.util.AadlSubprogramCallUtil;
import org.osate.ge.internal.util.ScopedEMFIndexRetrieval;

public class AadlBusinessObjectProvider {
	private final ModeTransitionTriggerHandler mttHandler = new ModeTransitionTriggerHandler();

	@Activate
	public Stream<?> getBusinessObjects(final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc,
			final ExtensionRegistryService extRegistryService, final ReferenceService refService) {

		final Object bo = boc.getBusinessObject();
		// An IProject is specified as the business object for contextless diagrams.
		if (bo instanceof IProject) { // Special handling for project
			final IProject project = (IProject) bo;

			// Perform an incremental project build to ensure new packages are included.
			try {
				project.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, new NullProgressMonitor());
			} catch (CoreException e) {
				throw new RuntimeException(e);
			}

			Stream<Object> packages = getPackages(project);

			// If no packages were found, assume that the project needs to be built. This can happen if the Eclipse process is forcefully terminated.
			if (packages == null) {
				try {
					project.build(IncrementalProjectBuilder.FULL_BUILD, new NullProgressMonitor());
				} catch (CoreException e) {
					throw new RuntimeException(e);
				}

				packages = getPackages(project);
			}

			return packages;
		} else if (bo instanceof AadlPackage) {
			return getChildren((AadlPackage)bo, extRegistryService);
		} else if(bo instanceof Classifier) {
			return getChildren((Classifier)bo, true, extRegistryService);
		} else if(bo instanceof FeatureGroup) {
			final FeatureGroupType fgt = AadlFeatureUtil.getFeatureGroupType(boc, (FeatureGroup)bo);
			return fgt == null ? null : AadlFeatureUtil.getAllFeatures(fgt).stream();
		} else if(bo instanceof Subcomponent) {
			return getChildren((Subcomponent)bo, boc, extRegistryService);
		} else if(bo instanceof SubprogramCall) {
			return getChildren((SubprogramCall)bo);
		} else if(bo instanceof SubprogramCallSequence) {
			return getChildren((SubprogramCallSequence)bo);
		} else if(bo instanceof ModeTransition) {
			final ModeTransition mt = ((ModeTransition) bo);
			final String modeTransitionTriggersDesc = mt.getOwnedTriggers().stream().map(mtt -> mttHandler.getName(mtt))
					.collect(Collectors.joining(","));
			return Stream.concat(mt.getOwnedTriggers().stream(),
					Stream.of(new Tag(Tag.KEY_MODE_TRANSITION_TRIGGERS, modeTransitionTriggersDesc)));
		} else if(bo instanceof ComponentInstance) {
			return getChildren((ComponentInstance)bo);
		} else if(bo instanceof FeatureInstance) {
			return ((FeatureInstance)bo).getFeatureInstances().stream();
		} else if(bo instanceof Connection) {
			if(!((Connection) bo).isAllBidirectional()) {
				return Stream.of(new Tag(Tag.KEY_UNIDIRECTIONAL, null));
			}
		} else if(bo instanceof ConnectionInstance) {
			if(!((ConnectionInstance) bo).isBidirectional()) {
				return Stream.of(new Tag(Tag.KEY_UNIDIRECTIONAL, null));
			}
		}

		return null;
	}

	/**
	 * Returns null if no packages are found. This is needed so that it can be determined if the project needs to be rebuilt.
	 * @param project
	 */
	private static Stream<Object> getPackages(final IProject project) {
		Stream.Builder<Object> packages = null;

		for (final IEObjectDescription desc : ScopedEMFIndexRetrieval.getAllEObjectsByType(project,
				Aadl2Factory.eINSTANCE.getAadl2Package().getAadlPackage())) {
			if (packages == null) {
				packages = Stream.builder();
			}

			final String pkgQualifiedName = desc.getQualifiedName().toString("::");
			packages.add(new BusinessObjectProxy(pkgQualifiedName, desc.getEClass(),
					DeclarativeReferenceBuilder.buildPackageCanonicalReference(pkgQualifiedName),
					DeclarativeReferenceBuilder.getPackageRelativeReference(pkgQualifiedName)));
		}

		return packages == null ? null : packages.build();
	}

	// Declarative Model
	private static Stream<Object> getChildren(final AadlPackage pkg, final ExtensionRegistryService extRegistryService) {
		// Build a list of all named elements in the public and private sections of the package
		final Set<Object> children = new HashSet<>();
		populateChildren(pkg, pkg.getPublicSection(), children, extRegistryService);
		populateChildren(pkg, pkg.getPrivateSection(), children, extRegistryService);

		return children.stream();
	}

	private static void populateChildren(final AadlPackage pkg, final PackageSection ps, final Set<Object> children, final ExtensionRegistryService extRegistryService) {
		if(ps == null) {
			return;
		}

		children.addAll(ps.getOwnedClassifiers());

		for(final AnnexLibrary annexLibrary : ps.getOwnedAnnexLibraries()) {
			final NamedElement parsedAnnexLibrary = getParsedAnnexLibrary(annexLibrary);
			final boolean specializedHandling = parsedAnnexLibrary != null && extRegistryService.getApplicableBusinessObjectHandler(parsedAnnexLibrary) != null;

			// Only contribute the annex object if a BOH for the annex does not exist. The annex plugin is expected to contribute the object as needed.
			if (!specializedHandling) {
				children.add(annexLibrary);
			}
		}
	}

	private static NamedElement getParsedAnnexLibrary(final NamedElement annexLibrary) {
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

	private static AnnexSubclause getParsedAnnexSubclause(final NamedElement annexSubclause) {
		if(annexSubclause instanceof DefaultAnnexSubclause) {
			final AnnexSubclause parsedSubclause = ((DefaultAnnexSubclause) annexSubclause).getParsedAnnexSubclause();

			// Don't return libraries which inherit from DefaultAnnexSubclause
			if(parsedSubclause instanceof DefaultAnnexSubclause) {
				return null;
			}

			return parsedSubclause;
		}

		return null;
	}

	private static Stream<?> getChildren(final Subcomponent sc,
			final BusinessObjectContext scBoc,
			final ExtensionRegistryService extRegistryService) {
		final ComponentClassifier cc = AadlSubcomponentUtil.getComponentClassifier(scBoc, sc);
		if(cc == null) {
			return null;
		}

		Stream<?> results = getChildren(cc, false, extRegistryService);

		final String scTypeTxt = AadlSubcomponentUtil.getSubcomponentTypeDescription(sc, scBoc);
		if(scTypeTxt != null) {
			results = Stream.concat(results, Stream.of(new Tag(Tag.KEY_SUBCOMPONENT_TYPE, scTypeTxt)));
		}

		return results;
	}

	private static Stream<?> getChildren(final SubprogramCall call) {
		final SubprogramType subprogramType = getSubprogramType(call);
		Stream<?> results = Stream.empty();
		if(subprogramType != null) {
			results = Stream.concat(results,
					Stream.concat(AadlFeatureUtil.getAllDeclaredFeatures(subprogramType).stream(),
							subprogramType.getAllFlowSpecifications().stream()));
		}

		final String calledSubprogramReference = AadlSubprogramCallUtil.getCalledSubprogramDescription(call);
		if(calledSubprogramReference != null) {
			results = Stream.concat(results, Stream.of(new Tag(Tag.KEY_SUBPROGRAM_CALL_CALLED_SUBPROGRAM, calledSubprogramReference)));
		}

		return results;
	}

	private static Stream<?> getChildren(final SubprogramCallSequence cs) {
		return Stream.concat(cs.getOwnedSubprogramCalls().stream(), SubprogramCallOrder.getSubprogramCallOrders(cs.getOwnedSubprogramCalls()).stream());
	}

	/**
	 * Finds and returns the SubprogramType associated with the specified model element.
	 * @param element
	 * @return
	 */
	private static SubprogramType getSubprogramType(final EObject element) {
		if(element instanceof SubprogramType) {
			return (SubprogramType)element;
		} else if(element instanceof SubprogramCall) {
			return getSubprogramType(((SubprogramCall) element).getCalledSubprogram());
		} else if(element instanceof SubprogramImplementation) {
			return ((SubprogramImplementation)element).getType();
		} else if(element instanceof SubprogramSubcomponent) {
			return getSubprogramType(((SubprogramSubcomponent) element).getSubprogramSubcomponentType());
		} else if(element instanceof SubprogramAccess) {
			final SubprogramSubcomponentType scType = ((SubprogramAccess) element).getSubprogramFeatureClassifier();
			return getSubprogramType(scType);
		} else if(element instanceof SubprogramProxy) {
			final SubprogramClassifier scClassifier = ((SubprogramProxy) element).getSubprogramClassifier();
			return getSubprogramType(scClassifier);
		} else if(element instanceof ComponentPrototype) {
			final ComponentClassifier constrainingClassifier = ((ComponentPrototype) element).getConstrainingClassifier();
			return getSubprogramType(constrainingClassifier);
		} else {
			// Unsupported case. Possibly prototype
			return null;
		}
	}

	private static Stream<?> getChildren(final Classifier classifier,
			final boolean includeGeneralizations,
			final ExtensionRegistryService extRegistryService) {
		Stream<?> children = Stream.empty();

		// Shapes
		children = Stream.concat(children, AadlFeatureUtil.getAllDeclaredFeatures(classifier).stream());

		if(classifier instanceof ComponentImplementation) {
			final ComponentImplementation ci = (ComponentImplementation)classifier;
			children = Stream.concat(children, AadlHelper.getAllInternalFeatures(ci).stream());
			children = Stream.concat(children, AadlHelper.getAllProcessorFeatures(ci).stream());
			children = Stream.concat(children, ci.getAllSubcomponents().stream());
		}

		if(classifier instanceof BehavioredImplementation) {
			children = Stream.concat(children, AadlHelper.getAllSubprogramCallSequences((BehavioredImplementation)classifier).stream());
		}

		if(classifier instanceof ComponentClassifier) {
			children = Stream.concat(children, ((ComponentClassifier)classifier).getAllModes().stream());
		}

		// Annex Subclauses
		final Stream.Builder<AnnexSubclause> subclauseStreamBuilder = Stream.builder();
		for(final AnnexSubclause annexSubclause : getAllDefaultAnnexSubclauses(classifier)) {
			final AnnexSubclause parsedAnnexSubclause = getParsedAnnexSubclause(annexSubclause);
			final boolean specializedHandling = parsedAnnexSubclause != null && extRegistryService.getApplicableBusinessObjectHandler(parsedAnnexSubclause) != null;

			// Only contribute the annex object if a BOH for the annex does not exist. The annex plugin is expected to contribute the object as needed.
			if (!specializedHandling) {
				subclauseStreamBuilder.add(annexSubclause);
			}
		}
		children = Stream.concat(children, subclauseStreamBuilder.build());

		// Connections
		if(classifier instanceof ComponentClassifier) {
			children = Stream.concat(children, ((ComponentClassifier)classifier).getAllModeTransitions().stream());
		}

		if(classifier instanceof ComponentImplementation) {
			children = Stream.concat(children, ((ComponentImplementation)classifier).getAllConnections().stream());
		}

		final ComponentType componentType;
		if(classifier instanceof ComponentType) {
			componentType = (ComponentType)classifier;
		} else if(classifier instanceof ComponentImplementation) {
			componentType = ((ComponentImplementation)classifier).getType();
		} else {
			componentType = null;
		}

		if(componentType != null) {
			children = Stream.concat(children, componentType.getAllFlowSpecifications().stream());
		}

		// Add generalizations
		if(includeGeneralizations) {
			if(classifier instanceof ComponentType) {
				final ComponentType ct = ((ComponentType)classifier);
				final TypeExtension te = ct.getOwnedExtension();
				if(te != null) {
					children = Stream.concat(children, Stream.of(te));
				}
			} else if(classifier instanceof ComponentImplementation) {
				final ComponentImplementation componentImplementation = ((ComponentImplementation)classifier);

				// Implementation Extension
				final ImplementationExtension ie = componentImplementation.getOwnedExtension();
				if(ie != null) {
					children = Stream.concat(children, Stream.of(ie));
				} else {
					// Realization
					final Realization realization = componentImplementation.getOwnedRealization();
					if (realization != null) {
						children = Stream.concat(children, Stream.of(realization));
					}
				}
			} else if(classifier instanceof FeatureGroupType) {
				final FeatureGroupType featureGroupType = ((FeatureGroupType)classifier);
				final GroupExtension ge = featureGroupType.getOwnedExtension();
				if(ge != null) {
					children = Stream.concat(children, Stream.of(ge));
				}
			}
		}

		return children;
	}

	/**
	 * Returns all the default annex subclauses owned by a classifier or any extended or implemented classifiers.
	 * @param topClassifier
	 * @return
	 */
	private static EList<AnnexSubclause> getAllDefaultAnnexSubclauses(final Classifier topClassifier) {
		final EList<AnnexSubclause> result = new BasicEList<AnnexSubclause>();
		if(topClassifier == null) {
			return result;
		}

		final EList<Classifier> classifiers = topClassifier.getSelfPlusAllExtended();
		if (topClassifier instanceof ComponentImplementation) {
			ComponentType ct = ((ComponentImplementation) topClassifier).getType();
			if(ct != null) { // May be null in the case of an invalid model.
				final EList<Classifier> tclassifiers = ct.getSelfPlusAllExtended();
				classifiers.addAll(tclassifiers);
			}
		}

		for (Classifier classifier : classifiers) {
			result.addAll(classifier.getOwnedAnnexSubclauses());
		}
		return result;
	}

	// Instance Model
	private static Stream<?> getChildren(ComponentInstance ci) {
		Stream.Builder<Object> connectionReferenceStreamBuilder = Stream.builder();
		for(final ConnectionInstance connectionInstance : ci.getConnectionInstances()) {
			for(final ConnectionReference cr : connectionInstance.getConnectionReferences()) {
				connectionReferenceStreamBuilder.add(cr);
			}
		}

		return Stream.of(ci.getModeInstances().stream(),
				ci.getModeTransitionInstances().stream(),
				ci.getFlowSpecifications().stream(), ci.getComponentInstances().stream(),
				ci.getFeatureInstances().stream(), connectionReferenceStreamBuilder.build()).flatMap(o -> o);
	}
}
