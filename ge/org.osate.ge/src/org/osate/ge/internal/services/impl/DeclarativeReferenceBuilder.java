/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.internal.services.impl;

import java.util.List;
import javax.inject.Named;
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
import org.osate.ge.internal.model.SubprogramCallOrder;
import org.osate.ge.services.ReferenceBuilderService;
import org.osate.ge.di.Names;
import org.osate.ge.di.BuildReference;
import org.osate.ge.di.BuildRelativeReference;

// Handles building references related to the AADL declarative model
public class DeclarativeReferenceBuilder {
	public final static String TYPE_PROJECT_OVERVIEW = "project_overview";
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
	public final static String TYPE_MODE_TRANSITION_UNNAMED = "mode_transition";
	public final static String TYPE_MODE_TRANSITION_NAMED = "mt";
	public final static String TYPE_MODE_TRANSITION_TRIGGER = "mtt";
	public final static String TYPE_SUBPROGRAM_CALL_SEQUENCE = "subprogram_call_sequence";
	public final static String TYPE_SUBPROGRAM_CALL = "subprogram_call";
	public final static String TYPE_SUBPROGRAM_CALL_ORDER = "subprogram_call_order";
	public final static String TYPE_ANNEX_LIBRARY = "annex_library";
	public final static String TYPE_ANNEX_SUBCLAUSE = "annex_subclause";

	@BuildRelativeReference 
	public String[] getRelativeReference(final @Named(Names.BUSINESS_OBJECT) Object bo) {		
		if(bo instanceof AadlPackage) {
			return new String[] {TYPE_PACKAGE, ((AadlPackage)bo).getQualifiedName()};				
		} if(bo instanceof Classifier) {
			return buildSimpleRelativeReference(TYPE_CLASSIFIER, ((Classifier)bo));
		} else if(bo instanceof Subcomponent) {
			return buildSimpleRelativeReference(TYPE_SUBCOMPONENT, ((Subcomponent)bo));
		} else if(bo instanceof Realization) {
			return new String[] {TYPE_REALIZATION };
		} else if(bo instanceof TypeExtension) {
			return new String[] {TYPE_TYPE_EXTENSION };
		} else if(bo instanceof ImplementationExtension) {
			return new String[] {TYPE_IMPLEMENTATION_EXTENSION };
		} else if(bo instanceof GroupExtension) {
			return new String[] {TYPE_GROUP_EXTENSION };
		} else if(bo instanceof Feature) {
			return buildSimpleRelativeReference(TYPE_FEATURE, ((Feature)bo));
		} else if(bo instanceof InternalFeature) {
			return buildSimpleRelativeReference(TYPE_INTERNAL_FEATURE, ((InternalFeature)bo));
		} else if(bo instanceof ProcessorFeature) {
			return buildSimpleRelativeReference(TYPE_PROCESSOR_FEATURE, ((ProcessorFeature)bo));
		} else if(bo instanceof FlowSpecification) {
			return buildSimpleRelativeReference(TYPE_FLOW_SPECIFICATION, ((FlowSpecification)bo));
		} else if(bo instanceof Connection) {
			return buildSimpleRelativeReference(TYPE_CONNECTION, ((Connection)bo));
		} else if(bo instanceof Mode) {
			return buildSimpleRelativeReference(TYPE_MODE, ((Mode)bo));
		} else if(bo instanceof ModeTransition) {
			final ModeTransition mt = (ModeTransition)bo;
			final String name = mt.getName();
			if(name == null) {
				return buildUnnamedModeTransitionRelativeReference((ModeTransition)bo);
			} else {
				return buildSimpleRelativeReference(TYPE_MODE_TRANSITION_NAMED, mt);
			}
		} else if(bo instanceof ModeTransitionTrigger) {
			final ModeTransitionTrigger mtt = (ModeTransitionTrigger)bo;
			return new String[] {TYPE_MODE_TRANSITION_TRIGGER, getNameForSerialization(mtt.getContext()), getNameForSerialization(mtt.getTriggerPort())};
		} else if(bo instanceof SubprogramCallSequence) {
			return buildSimpleRelativeReference(TYPE_SUBPROGRAM_CALL_SEQUENCE, ((SubprogramCallSequence)bo));
		} else if(bo instanceof SubprogramCall) {
			return buildSimpleRelativeReference(TYPE_SUBPROGRAM_CALL, ((SubprogramCall)bo));
		} else if(bo instanceof SubprogramCallOrder) {
			final SubprogramCallOrder sco = (SubprogramCallOrder)bo;
			return new String[] {TYPE_SUBPROGRAM_CALL_ORDER, getNameForSerialization(sco.previousSubprogramCall), getNameForSerialization(sco.subprogramCall)};
		} else if(bo instanceof AnnexLibrary) {
			final AnnexLibrary annexLibrary = (AnnexLibrary)bo;					
			final int index = getAnnexLibraryIndex(annexLibrary);
			return new String[] {TYPE_ANNEX_LIBRARY, annexLibrary.getName(), Integer.toString(index)};

		} else if(bo instanceof AnnexSubclause) {
			final AnnexSubclause annexSubclause = (AnnexSubclause)bo;			
			if(annexSubclause.getContainingClassifier() == null) {
				throw new RuntimeException("Unable to retrieve containing classifier.");
			}
			
			final int index = getAnnexSubclauseIndex(annexSubclause);
			return new String[] {TYPE_ANNEX_SUBCLAUSE, annexSubclause.getName(), Integer.toString(index)};
		} else {
			return null;
		}
	}
	
	private String[] buildSimpleRelativeReference(final String type, final NamedElement bo) {
		return new String[] {type, getNameForSerialization(bo)};
	}
	
	@BuildReference
	public String[] getReference(final @Named(Names.BUSINESS_OBJECT) Object bo, final ReferenceBuilderService refBuilder) {
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
			final ModeTransition mt = (ModeTransition)bo;
			final String name = mt.getName();
			if(name == null) {
				return buildUnnamedModeTransitionKey((ModeTransition)bo);
			} else {
				return new String[] {TYPE_MODE_TRANSITION_NAMED, refBuilder.getReference(mt.eContainer()), getNameForSerialization(mt)};
			}
		} else if(bo instanceof ModeTransitionTrigger) {
			final ModeTransitionTrigger mtt = (ModeTransitionTrigger)bo;
			return new String[] {TYPE_MODE_TRANSITION_TRIGGER, refBuilder.getReference(mtt.eContainer()), getNameForSerialization(mtt.getContext()), getNameForSerialization(mtt.getTriggerPort())};
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
			return new String[] {TYPE_ANNEX_LIBRARY, annexPkg.getQualifiedName(), annexLibrary.getName(), Integer.toString(index)};
		} else if(bo instanceof AnnexSubclause) {
			final AnnexSubclause annexSubclause = (AnnexSubclause)bo;			
			if(annexSubclause.getContainingClassifier() == null) {
				throw new RuntimeException("Unable to retrieve containing classifier.");
			}
			
			final Classifier annexSubclauseClassifier = annexSubclause.getContainingClassifier();	
			final int index = getAnnexSubclauseIndex(annexSubclause);
			return new String[] {TYPE_ANNEX_SUBCLAUSE, annexSubclauseClassifier.getQualifiedName(), annexSubclause.getName(), Integer.toString(index)};
		} else {
			return null;
		}
	}

	static String[] buildUnnamedModeTransitionRelativeReference(final ModeTransition mt) {
		final List<ModeTransitionTrigger> triggers = mt.getOwnedTriggers();
		final String[] key = new String[4 + (triggers.size() * 2)];
		int index = 0;
		key[index++] = TYPE_MODE_TRANSITION_UNNAMED;
		key[index++] = getNameForSerialization(mt);
		key[index++] = getNameForSerialization(mt.getSource());
		key[index++] = getNameForSerialization(mt.getDestination());
		for(final ModeTransitionTrigger trigger : triggers) {
			key[index++] = getNameForSerialization(trigger.getContext());
			key[index++] = getNameForSerialization(trigger.getTriggerPort());
		}

		return key;
	}
	
	public static String getNameForSerialization(final NamedElement ne) {
		return (ne == null || ne.getName() == null) ? "<null>" : ne.getName();
	}
	
	static String[] buildUnnamedModeTransitionKey(final ModeTransition mt) {
		final List<ModeTransitionTrigger> triggers = mt.getOwnedTriggers();
		final String[] key = new String[5 + (triggers.size() * 2)];
		int index = 0;
		key[index++] = TYPE_MODE_TRANSITION_UNNAMED;
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
}

