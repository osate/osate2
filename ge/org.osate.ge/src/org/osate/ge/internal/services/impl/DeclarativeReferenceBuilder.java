package org.osate.ge.internal.services.impl;

import java.util.List;

import javax.inject.Named;

import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Connection;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.Element;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.GroupExtension;
import org.osate.aadl2.ImplementationExtension;
import org.osate.aadl2.InternalFeature;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.ModeTransitionTrigger;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.ProcessorFeature;
import org.osate.aadl2.Realization;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramCallSequence;
import org.osate.aadl2.TypeExtension;
import org.osate.annexsupport.AnnexUtil;
import org.osate.ge.di.BuildCanonicalReference;
import org.osate.ge.di.BuildRelativeReference;
import org.osate.ge.di.Names;
import org.osate.ge.internal.diagram.runtime.CanonicalBusinessObjectReference;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;
import org.osate.ge.internal.model.SubprogramCallOrder;
import org.osate.ge.services.ReferenceBuilderService;

import com.google.common.collect.Lists;

// Handles building references related to the AADL declarative model
public class DeclarativeReferenceBuilder {
	public static CanonicalBusinessObjectReference buildPackageCanonicalReference(final String qualifiedName) {
		return new CanonicalBusinessObjectReference(buildPackageReferenceSegments(qualifiedName));
	}

	private static String[] buildPackageReferenceSegments(final String qualifiedName) {
		return new String[] { DeclarativeReferenceType.PACKAGE.getId(), qualifiedName };
	}

	public static RelativeBusinessObjectReference getPackageRelativeReference(final String qualifiedName) {
		return RelativeBusinessObjectReference.fromNullableSegments(buildPackageReferenceSegments(qualifiedName));
	}

	public static RelativeBusinessObjectReference getClassifierRelativeReference(final String name) {
		return buildSimpleRelativeReference(DeclarativeReferenceType.CLASSIFIER.getId(), name);
	}

	public static RelativeBusinessObjectReference getConnectionRelativeReference(final String name) {
		return buildSimpleRelativeReference(DeclarativeReferenceType.CONNECTION.getId(), name);
	}

	public static RelativeBusinessObjectReference getSubcomponentRelativeReference(final String name) {
		return buildSimpleRelativeReference(DeclarativeReferenceType.SUBCOMPONENT.getId(), name);
	}

	public static RelativeBusinessObjectReference getFeatureRelativeReference(final String name) {
		return buildSimpleRelativeReference(DeclarativeReferenceType.FEATURE.getId(), name);
	}

	public static RelativeBusinessObjectReference getFlowSpecificationRelativeReference(final String name) {
		return buildSimpleRelativeReference(DeclarativeReferenceType.FLOW_SPECIFICATION.getId(), name);
	}

	@BuildRelativeReference
	public RelativeBusinessObjectReference getRelativeReference(final @Named(Names.BUSINESS_OBJECT) Object bo) {
		if (bo instanceof AadlPackage) {
			return getPackageRelativeReference(((AadlPackage) bo).getQualifiedName());
		} else if (bo instanceof Classifier) {
			return getClassifierRelativeReference(((Classifier) bo).getName());
		} else if (bo instanceof Subcomponent) {
			return getSubcomponentRelativeReference(((Subcomponent) bo).getName());
		} else if (bo instanceof Realization) {
			return RelativeBusinessObjectReference.fromNullableSegments(new String[] { DeclarativeReferenceType.REALIZATION.getId() });
		} else if (bo instanceof TypeExtension) {
			return RelativeBusinessObjectReference.fromNullableSegments(new String[] { DeclarativeReferenceType.TYPE_EXTENSION.getId() });
		} else if (bo instanceof ImplementationExtension) {
			return RelativeBusinessObjectReference.fromNullableSegments(new String[] { DeclarativeReferenceType.IMPLEMENTATION_EXTENSION.getId() });
		} else if (bo instanceof GroupExtension) {
			return RelativeBusinessObjectReference.fromNullableSegments(new String[] { DeclarativeReferenceType.GROUP_EXTENSION.getId() });
		} else if (bo instanceof Feature) {
			return getFeatureRelativeReference(((Feature) bo).getName());
		} else if (bo instanceof InternalFeature) {
			return buildSimpleRelativeReference(DeclarativeReferenceType.INTERNAL_FEATURE.getId(),
					((InternalFeature) bo));
		} else if (bo instanceof ProcessorFeature) {
			return buildSimpleRelativeReference(DeclarativeReferenceType.PROCESSOR_FEATURE.getId(),
					((ProcessorFeature) bo));
		} else if (bo instanceof FlowSpecification) {
			return buildSimpleRelativeReference(DeclarativeReferenceType.FLOW_SPECIFICATION.getId(),
					((FlowSpecification) bo));
		} else if (bo instanceof Connection) {
			return buildSimpleRelativeReference(DeclarativeReferenceType.CONNECTION.getId(), ((Connection) bo));
		} else if (bo instanceof Mode) {
			return buildSimpleRelativeReference(DeclarativeReferenceType.MODE.getId(), ((Mode) bo));
		} else if (bo instanceof ModeTransition) {
			final ModeTransition mt = (ModeTransition) bo;
			final String name = mt.getName();
			if (name == null) {
				return buildUnnamedModeTransitionRelativeReference((ModeTransition) bo);
			} else {
				return buildSimpleRelativeReference(DeclarativeReferenceType.MODE_TRANSITION_NAMED.getId(), mt);
			}
		} else if (bo instanceof ModeTransitionTrigger) {
			final ModeTransitionTrigger mtt = (ModeTransitionTrigger) bo;
			return RelativeBusinessObjectReference
					.fromNullableSegments(new String[] { DeclarativeReferenceType.MODE_TRANSITION_TRIGGER.getId(),
							getNameForSerialization(mtt.getContext()),
							getNameForSerialization(mtt.getTriggerPort()) });
		} else if (bo instanceof SubprogramCallSequence) {
			return buildSimpleRelativeReference(DeclarativeReferenceType.SUBPROGRAM_CALL_SEQUENCE.getId(),
					((SubprogramCallSequence) bo));
		} else if (bo instanceof SubprogramCall) {
			return buildSimpleRelativeReference(DeclarativeReferenceType.SUBPROGRAM_CALL.getId(),
					((SubprogramCall) bo));
		} else if (bo instanceof SubprogramCallOrder) {
			final SubprogramCallOrder sco = (SubprogramCallOrder) bo;
			return RelativeBusinessObjectReference
					.fromNullableSegments(new String[] { DeclarativeReferenceType.SUBPROGRAM_CALL_ORDER.getId(),
							getNameForSerialization(sco.previousSubprogramCall),
							getNameForSerialization(sco.subprogramCall) });
		} else if (bo instanceof AnnexLibrary) {
			final AnnexLibrary annexLibrary = (AnnexLibrary) bo;
			final int index = getAnnexLibraryIndex(annexLibrary);
			return RelativeBusinessObjectReference.fromNullableSegments(new String[] {
					DeclarativeReferenceType.ANNEX_LIBRARY.getId(), annexLibrary.getName(), Integer.toString(index) });

		} else if (bo instanceof AnnexSubclause) {
			final AnnexSubclause annexSubclause = (AnnexSubclause) bo;
			if (annexSubclause.getContainingClassifier() == null) {
				throw new RuntimeException("Unable to retrieve containing classifier.");
			}

			final int index = getAnnexSubclauseIndex(annexSubclause);
			return RelativeBusinessObjectReference
					.fromNullableSegments(new String[] { DeclarativeReferenceType.ANNEX_SUBCLAUSE.getId(),
							annexSubclause.getName(), Integer.toString(index) });
		} else {
			return null;
		}
	}

	private static RelativeBusinessObjectReference buildSimpleRelativeReference(final String type,
			final NamedElement bo) {
		if (bo == null) {
			return null;
		}

		return buildSimpleRelativeReference(type, bo.getName());
	}

	private static RelativeBusinessObjectReference buildSimpleRelativeReference(final String type, final String name) {
		// Don't allow null or empty names for simple relative references
		if (name == null || name.length() == 0) {
			return null;
		}

		return RelativeBusinessObjectReference.fromNullableSegments(new String[] { type, name });
	}

	@BuildCanonicalReference
	public String[] getReference(final @Named(Names.BUSINESS_OBJECT) Object bo,
			final ReferenceBuilderService refBuilder) {
		if (bo instanceof AadlPackage) {
			return buildPackageReferenceSegments(((AadlPackage) bo).getQualifiedName());
		} else if (bo instanceof Classifier) {
			return new String[] { DeclarativeReferenceType.CLASSIFIER.getId(),
					((Classifier) bo).getQualifiedName() };
		} else if (bo instanceof Subcomponent) {
			return new String[] { DeclarativeReferenceType.SUBCOMPONENT.getId(),
					((Subcomponent) bo).getQualifiedName() };
		} else if (bo instanceof Realization) {
			return new String[] { DeclarativeReferenceType.REALIZATION.getId(),
					((Realization) bo).getSpecific().getQualifiedName() };
		} else if (bo instanceof TypeExtension) {
			return new String[] { DeclarativeReferenceType.TYPE_EXTENSION.getId(),
					((TypeExtension) bo).getSpecific().getQualifiedName() };
		} else if (bo instanceof ImplementationExtension) {
			return new String[] { DeclarativeReferenceType.IMPLEMENTATION_EXTENSION.getId(),
					((ImplementationExtension) bo).getSpecific().getQualifiedName() };
		} else if (bo instanceof GroupExtension) {
			return new String[] { DeclarativeReferenceType.GROUP_EXTENSION.getId(),
					((GroupExtension) bo).getSpecific().getQualifiedName() };
		} else if (bo instanceof Feature) {
			return new String[] { DeclarativeReferenceType.FEATURE.getId(), ((Feature) bo).getQualifiedName() };
		} else if (bo instanceof InternalFeature) {
			return new String[] { DeclarativeReferenceType.INTERNAL_FEATURE.getId(),
					((InternalFeature) bo).getQualifiedName() };
		} else if (bo instanceof ProcessorFeature) {
			return new String[] { DeclarativeReferenceType.PROCESSOR_FEATURE.getId(),
					((ProcessorFeature) bo).getQualifiedName() };
		} else if (bo instanceof FlowSpecification) {
			return new String[] { DeclarativeReferenceType.FLOW_SPECIFICATION.getId(),
					((FlowSpecification) bo).getQualifiedName() };
		} else if (bo instanceof Connection) {
			return new String[] { DeclarativeReferenceType.CONNECTION.getId(),
					((Connection) bo).getQualifiedName() };
		} else if (bo instanceof Mode) {
			return new String[] { DeclarativeReferenceType.MODE.getId(), ((Mode) bo).getQualifiedName() };
		} else if (bo instanceof ModeTransition) {
			final ModeTransition mt = (ModeTransition) bo;
			final String name = mt.getName();
			if (name == null) {
				return buildUnnamedModeTransitionKey((ModeTransition) bo);
			} else {
				return new String[] { DeclarativeReferenceType.MODE_TRANSITION_NAMED.getId(),
						refBuilder.getReference(mt.eContainer()),
						getNameForSerialization(mt) };
			}
		} else if (bo instanceof ModeTransitionTrigger) {
			final ModeTransitionTrigger mtt = (ModeTransitionTrigger) bo;
			return new String[] { DeclarativeReferenceType.MODE_TRANSITION_TRIGGER.getId(),
					refBuilder.getReference(mtt.eContainer()),
					getNameForSerialization(mtt.getContext()), getNameForSerialization(mtt.getTriggerPort()) };
		} else if (bo instanceof SubprogramCallSequence) {
			return new String[] { DeclarativeReferenceType.SUBPROGRAM_CALL_SEQUENCE.getId(),
					((SubprogramCallSequence) bo).getQualifiedName() };
		} else if (bo instanceof SubprogramCall) {
			return new String[] { DeclarativeReferenceType.SUBPROGRAM_CALL.getId(),
					((SubprogramCall) bo).getQualifiedName() };
		} else if (bo instanceof SubprogramCallOrder) {
			final SubprogramCallOrder sco = (SubprogramCallOrder) bo;
			return new String[] { DeclarativeReferenceType.SUBPROGRAM_CALL_ORDER.getId(),
					sco.previousSubprogramCall.getQualifiedName(),
					sco.subprogramCall.getQualifiedName() };
		} else if (bo instanceof AnnexLibrary) {
			final AnnexLibrary annexLibrary = (AnnexLibrary) bo;
			final AadlPackage annexPkg = getAnnexLibraryPackage(annexLibrary);
			if (annexPkg == null) {
				throw new RuntimeException("Unable to retrieve package.");
			}

			final int index = getAnnexLibraryIndex(annexLibrary);
			return new String[] { DeclarativeReferenceType.ANNEX_LIBRARY.getId(), annexPkg.getQualifiedName(),
					annexLibrary.getName(),
					Integer.toString(index) };
		} else if (bo instanceof AnnexSubclause) {
			final AnnexSubclause annexSubclause = (AnnexSubclause) bo;
			if (annexSubclause.getContainingClassifier() == null) {
				throw new RuntimeException("Unable to retrieve containing classifier.");
			}

			final Classifier annexSubclauseClassifier = annexSubclause.getContainingClassifier();
			final int index = getAnnexSubclauseIndex(annexSubclause);
			return new String[] { DeclarativeReferenceType.ANNEX_SUBCLAUSE.getId(),
					annexSubclauseClassifier.getQualifiedName(),
					annexSubclause.getName(), Integer.toString(index) };
		} else {
			return null;
		}
	}

	static RelativeBusinessObjectReference buildUnnamedModeTransitionRelativeReference(final ModeTransition mt) {
		final List<ModeTransitionTrigger> triggers = mt.getOwnedTriggers();
		final String[] key = new String[4 + (triggers.size() * 2)];
		int index = 0;
		key[index++] = DeclarativeReferenceType.MODE_TRANSITION_UNNAMED.getId();
		key[index++] = getNameForSerialization(mt);
		key[index++] = getNameForSerialization(mt.getSource());
		key[index++] = getNameForSerialization(mt.getDestination());
		for (final ModeTransitionTrigger trigger : triggers) {
			key[index++] = getNameForSerialization(trigger.getContext());
			key[index++] = getNameForSerialization(trigger.getTriggerPort());
		}

		return RelativeBusinessObjectReference.fromNullableSegments(key);
	}

	public static String getNameForSerialization(final NamedElement ne) {
		return (ne == null || ne.getName() == null) ? "<null>" : ne.getName();
	}

	static String[] buildUnnamedModeTransitionKey(final ModeTransition mt) {
		final List<ModeTransitionTrigger> triggers = mt.getOwnedTriggers();
		final String[] key = new String[5 + (triggers.size() * 2)];
		int index = 0;
		key[index++] = DeclarativeReferenceType.MODE_TRANSITION_UNNAMED.getId();
		key[index++] = mt.getContainingClassifier().getQualifiedName();
		key[index++] = getNameForSerialization(mt);
		key[index++] = getNameForSerialization(mt.getSource());
		key[index++] = getNameForSerialization(mt.getDestination());
		for (final ModeTransitionTrigger trigger : triggers) {
			key[index++] = getNameForSerialization(trigger.getContext());
			key[index++] = getNameForSerialization(trigger.getTriggerPort());
		}

		return key;
	}

	/**
	 * Get the package in which the annex library is contained.
	 * @param annex
	 * @return
	 */
	private AadlPackage getAnnexLibraryPackage(final AnnexLibrary annexLibrary) {
		for (Element o = annexLibrary.getOwner(); o != null; o = o.getOwner()) {
			if (o instanceof AadlPackage) {
				return (AadlPackage) o;
			}
		}

		return null;
	}

	/**
	 * Returns a 0 based index for referencing an annex library in a list that contains only annex libraries with the same type and owner
	 * @param annexLibrary
	 * @return
	 */
	private static int getAnnexLibraryIndex(AnnexLibrary annexLibrary) {
		// Get the default annex library if a parsed annex library was specified. This is needed for the comparison later in the function.
		if (!(annexLibrary instanceof DefaultAnnexLibrary)) {
			if (annexLibrary.eContainer() instanceof DefaultAnnexLibrary) {
				annexLibrary = (AnnexLibrary) annexLibrary.eContainer();
			} else {
				return -1;
			}
		}

		final String annexName = annexLibrary.getName();
		if (annexName == null) {
			return -1;
		}

		// Get the Aadl Package
		Element tmp = annexLibrary.getOwner();
		while (tmp != null && !(tmp instanceof AadlPackage)) {
			tmp = tmp.getOwner();
		}

		int index = 0;
		if (tmp instanceof AadlPackage) {
			for (final AnnexLibrary tmpLibrary : AnnexUtil.getAllDefaultAnnexLibraries((AadlPackage) tmp)) {
				if (tmpLibrary == annexLibrary) {
					return index;
				} else if (annexName.equalsIgnoreCase(tmpLibrary.getName())) {
					index++;
				}
			}
		}

		return -1;
	}

	/**
	 * Returns a 0 based index for referencing an annex subclause in a list that contains only annex subclauses with the same type and owner
	 * @return
	 */
	private static int getAnnexSubclauseIndex(AnnexSubclause annexSubclause) {
		// Get the default annex library if a parsed annex subclause was specified. This is needed for the comparison later in the function.
		if (!(annexSubclause instanceof DefaultAnnexSubclause)) {
			if (annexSubclause.eContainer() instanceof DefaultAnnexSubclause) {
				annexSubclause = (AnnexSubclause) annexSubclause.eContainer();
			} else {
				return -1;
			}
		}

		final String annexName = annexSubclause.getName();
		if (annexName == null) {
			return -1;
		}

		// Get all related classifiers
		final Classifier cl = annexSubclause.getContainingClassifier();
		final EList<Classifier> classifiers = cl.getSelfPlusAllExtended();
		if (cl instanceof ComponentImplementation) {
			ComponentType ct = ((ComponentImplementation) cl).getType();
			final EList<Classifier> tclassifiers = ct.getSelfPlusAllExtended();
			classifiers.addAll(tclassifiers);
		}

		int index = 0;

		// Use reversed view of list so that base classifiers will be first. This is needed to ensure subclauses have unique indices
		for (final Classifier tmpClassifier : Lists.reverse(classifiers)) {
			for (final AnnexSubclause tmpSubclause : tmpClassifier.getOwnedAnnexSubclauses()) {
				if (tmpSubclause == annexSubclause) {
					return index;
				} else if (annexName.equalsIgnoreCase(tmpSubclause.getName())) {
					index++;
				}
			}
		}

		return -1;
	}
}

