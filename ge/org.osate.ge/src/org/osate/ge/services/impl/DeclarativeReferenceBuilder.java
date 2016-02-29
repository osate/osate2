package org.osate.ge.services.impl;

import java.util.List;
import javax.inject.Named;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Connection;
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
import org.osate.ge.diagrams.componentImplementation.patterns.SubprogramCallOrder;
import org.osate.ge.ext.Names;
import org.osate.ge.ext.annotations.BuildReference;
import org.osate.ge.ext.annotations.GetProject;
import org.osate.ge.ext.annotations.GetTitle;
import org.osate.ge.ui.util.SelectionHelper;

// Handles building references related to the AADL declarative model
public class DeclarativeReferenceBuilder {
	public final static String TYPE_PACKAGE = "package";
	public final static String TYPE_CLASSIFIER = "classifier";
	public final static String TYPE_SUBCOMPONENT = "subcomponent";
	public final static String TYPE_REALIZATION = "realization";
	public final static String TYPE_TYPE_EXTENSION = "type_extension";
	public final static String TYPE_IMPLEMENTATION_EXTENSION = "implementation_extension";
	public final static String TYPE_GROUP_EXTENSION = "group_extension";
	public final static String TYPE_FEATURE = "feature";
	public final static String TYPE_INTERNAL_FEATURE = "internal_feature";
	public final static String TYPE_PROCESSOR_FEATURE = "processor_feature";
	public final static String TYPE_FLOW_SPECIFICATION = "flow_specification";
	public final static String TYPE_CONNECTION = "connection";
	public final static String TYPE_MODE = "mode";
	public final static String TYPE_MODE_TRANSITION = "mode_transition";
	public final static String TYPE_SUBPROGRAM_CALL_SEQUENCE = "subprogram_call_sequence";
	public final static String TYPE_SUBPROGRAM_CALL = "subprogram_call";
	public final static String TYPE_SUBPROGRAM_CALL_ORDER = "subprogram_call_order";
	public final static String TYPE_ANNEX_LIBRARY = "annex_library";
	public final static String TYPE_ANNEX_SUBCLAUSE = "annex_subclause";

	@BuildReference
	public String[] getReference(final @Named(Names.BUSINESS_OBJECT) Object bo) {
		if(bo instanceof AadlPackage) {
			return new String[] {TYPE_PACKAGE, ((AadlPackage)bo).getQualifiedName()};				
		} else if(bo instanceof Classifier) {
			return new String[] {TYPE_CLASSIFIER, ((Classifier)bo).getQualifiedName()};
		} else if(bo instanceof Subcomponent) {
			return new String[] {TYPE_SUBCOMPONENT, ((Subcomponent)bo).getQualifiedName()};
		} else if(bo instanceof Realization) {
			return new String[] {TYPE_REALIZATION, ((Realization)bo).getSpecific().getQualifiedName()};
		} else if(bo instanceof TypeExtension) {
			return new String[] {TYPE_TYPE_EXTENSION, ((TypeExtension)bo).getSpecific().getQualifiedName()};
		} else if(bo instanceof ImplementationExtension) {
			return new String[] {TYPE_IMPLEMENTATION_EXTENSION, ((ImplementationExtension)bo).getSpecific().getQualifiedName()};
		} else if(bo instanceof GroupExtension) {
			return new String[] {TYPE_GROUP_EXTENSION, ((GroupExtension)bo).getSpecific().getQualifiedName()};
		} else if(bo instanceof Feature) {
			return new String[] {TYPE_FEATURE, ((Feature)bo).getQualifiedName()};
		} else if(bo instanceof InternalFeature) {
			return new String[] {TYPE_INTERNAL_FEATURE, ((InternalFeature)bo).getQualifiedName()};
		} else if(bo instanceof ProcessorFeature) {
			return new String[] {TYPE_PROCESSOR_FEATURE, ((ProcessorFeature)bo).getQualifiedName()};
		} else if(bo instanceof FlowSpecification) {
			return new String[] {TYPE_FLOW_SPECIFICATION, ((FlowSpecification)bo).getQualifiedName()};
		} else if(bo instanceof Connection) {
			return new String[] {TYPE_CONNECTION, ((Connection)bo).getQualifiedName()};
		} else if(bo instanceof Mode) {
			return new String[] {TYPE_MODE, ((Mode)bo).getQualifiedName()};
		} else if(bo instanceof ModeTransition) {
			return buildModeTransitionKey((ModeTransition)bo);
		} else if(bo instanceof SubprogramCallSequence) {
			return new String[] {TYPE_SUBPROGRAM_CALL_SEQUENCE, ((SubprogramCallSequence)bo).getQualifiedName()};
		} else if(bo instanceof SubprogramCall) {
			return new String[] {TYPE_SUBPROGRAM_CALL, ((SubprogramCall)bo).getQualifiedName()};
		} else if(bo instanceof SubprogramCallOrder) {
			final SubprogramCallOrder sco = (SubprogramCallOrder)bo;
			return new String[] {TYPE_SUBPROGRAM_CALL_ORDER, sco.previousSubprogramCall.getQualifiedName(), sco.subprogramCall.getQualifiedName()};
		} else if(bo instanceof AnnexLibrary) {
			final AnnexLibrary annexLibrary = (AnnexLibrary)bo;					
			final AadlPackage annexPkg = getAnnexLibraryPackage(annexLibrary);
			if(annexPkg == null) {
				throw new RuntimeException("Unable to retrieve package.");
			}
			
			final int index = getAnnexLibraryIndex(annexLibrary);
			return new String[] {TYPE_ANNEX_LIBRARY, annexPkg.getQualifiedName(), annexLibrary.getName().toLowerCase(), Integer.toString(index)};
		} else if(bo instanceof AnnexSubclause) {
			final AnnexSubclause annexSubclause = (AnnexSubclause)bo;			
			if(annexSubclause.getContainingClassifier() == null) {
				throw new RuntimeException("Unable to retrieve containing classifier.");
			}
			
			final Classifier annexSubclauseClassifier = annexSubclause.getContainingClassifier();	
			final int index = getAnnexSubclauseIndex(annexSubclause);
			return new String[] {TYPE_ANNEX_SUBCLAUSE, annexSubclauseClassifier.getQualifiedName(), annexSubclause.getName().toLowerCase(), Integer.toString(index)};
		} else {
			return null;
		}
	}
	
	private static String getNameForSerialization(final NamedElement ne) {
		return (ne == null || ne.getName() == null) ? "<null>" : ne.getName();
	}
	
	static String[] buildModeTransitionKey(final ModeTransition mt) {
		final List<ModeTransitionTrigger> triggers = mt.getOwnedTriggers();
		final String[] key = new String[5 + (triggers.size() * 2)];
		int index = 0;
		key[index++] = TYPE_MODE_TRANSITION;
		key[index++] = mt.getContainingClassifier().getQualifiedName();
		key[index++] = getNameForSerialization(mt);
		key[index++] = getNameForSerialization(mt.getSource());
		key[index++] = getNameForSerialization(mt.getDestination());
		for(final ModeTransitionTrigger trigger : triggers) {
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
		for(Element o = annexLibrary.getOwner(); o != null; o = o.getOwner()) {
			if(o instanceof AadlPackage) {
				return (AadlPackage)o;
			}
		}
		
		return null;
	}
	
	/**
	 * Returns a 0 based index for referencing an annex library in a list that contains only annex libraries with the same type and owner
	 * @param annexLibrary
	 * @return
	 */
	private int getAnnexLibraryIndex(final AnnexLibrary annexLibrary) {
		final String annexName = annexLibrary.getName();
		if(annexName == null) {
			return -1;
		}
		
		// Get the Aadl Package
		Element tmp = annexLibrary.getOwner();
		while(tmp != null && !(tmp instanceof AadlPackage)) {
			tmp = tmp.getOwner();
		}
		
		int index = 0;
		if(tmp instanceof AadlPackage) {
			for(final AnnexLibrary tmpLibrary : AnnexUtil.getAllDefaultAnnexLibraries((AadlPackage)tmp)) {
				if(tmpLibrary == annexLibrary) {
					return index;
				} else if(annexName.equalsIgnoreCase(tmpLibrary.getName())) {
					index++;
				}
			}
		}

		return -1;
	}
	
	/**
	 * Returns a 0 based index for referencing an annex subclause in a list that contains only annex subclauses with the same type and owner
	 * @param annexLibrary
	 * @return
	 */
	private int getAnnexSubclauseIndex(final AnnexSubclause annexSubclause) {
		final String annexName = annexSubclause.getName();
		if(annexName == null) {
			return -1;
		}
		
		// Get the Classifier
		final Classifier classifier = annexSubclause.getContainingClassifier();
				
		int index = 0;
		for(final AnnexSubclause tmpSubclause : classifier.getOwnedAnnexSubclauses()) {
			if(tmpSubclause == annexSubclause) {
				return index;
			} else if(annexName.equalsIgnoreCase(tmpSubclause.getName())) {
				index++;
			}
		}

		return -1;
	}
	
	@GetTitle
	public String getTitle(final @Named(Names.BUSINESS_OBJECT) Object bo) {
		if(bo instanceof AadlPackage || bo instanceof Classifier) {
			return ((NamedElement) bo).getQualifiedName();
		}
		
		return null;
	}
	
	/**
	 * Handles retrieving the IProject of any EObject
	 * @param bo
	 * @return
	 */
	@GetProject
	public IProject getProject(final @Named(Names.BUSINESS_OBJECT) EObject bo) {
		final Resource resource = ((EObject)bo).eResource();
		if(resource != null) {
			final URI uri = resource.getURI();
			if(uri != null) {
				return SelectionHelper.getProject(uri);
			}
		}

		return null;
	}
}
