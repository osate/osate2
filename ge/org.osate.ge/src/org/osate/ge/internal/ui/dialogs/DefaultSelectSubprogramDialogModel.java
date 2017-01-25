/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.internal.ui.dialogs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AccessType;
import org.osate.aadl2.BehavioredImplementation;
import org.osate.aadl2.CallContext;
import org.osate.aadl2.CalledSubprogram;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.ProcessorFeature;
import org.osate.aadl2.Prototype;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubprogramAccess;
import org.osate.aadl2.SubprogramGroupAccess;
import org.osate.aadl2.SubprogramGroupClassifier;
import org.osate.aadl2.SubprogramGroupSubcomponent;
import org.osate.aadl2.SubprogramPrototype;
import org.osate.aadl2.SubprogramProxy;
import org.osate.aadl2.SubprogramSubcomponent;
import org.osate.ge.internal.services.AadlFeatureService;
import org.osate.ge.internal.util.AadlHelper;
import org.osate.ge.internal.util.ScopedEMFIndexRetrieval;

/**
 * This is a default implementation of the model used for the SelectSubprogramDialog. 
 * It supplies contexts and subprogram from the ScopedEMFIndexRetrieval and the specified BehavioredImplementation.
 *
 */
public class DefaultSelectSubprogramDialogModel implements SelectSubprogramDialog.Model {
	private static final Object processorContext = new Object();
	private static final Object nullContext = new Object();
	private final AadlFeatureService featureService;
	private final BehavioredImplementation bi;
	private final List<Object> contexts;
	
	public DefaultSelectSubprogramDialogModel(final AadlFeatureService featureService, final BehavioredImplementation bi) {
		this.featureService = featureService;
		this.bi = bi;
		
		// Build a list of contexts
		final List<Object> modifiableContextList = new ArrayList<Object>();

		// Add type contexts
		// data unique type reference
		// subprogram group unique type reference
		// abstract unique type reference
		final Aadl2Package aadl2Package = Aadl2Factory.eINSTANCE.getAadl2Package();
		for(final IEObjectDescription desc : ScopedEMFIndexRetrieval.getAllEObjectsByType(bi.eResource(), aadl2Package.getComponentClassifier())) {
			// Add objects that have care either types or implementations of the same category as the classifier type
			final EClass classifierEClass = desc.getEClass();
			if(aadl2Package.getDataType() == classifierEClass ||
					aadl2Package.getSubprogramGroupType() == classifierEClass || 
					aadl2Package.getAbstractType() == classifierEClass) {
				modifiableContextList.add(desc);
			}
		}
		
		// Add contexts that are related to the component implementation
		// Add Feature Groups and Required Subprogram Group Access Features
		for(final Feature feature : bi.getAllFeatures()) {
			if(feature instanceof FeatureGroup && ((FeatureGroup) feature).getAllFeatureGroupType() != null) {
				modifiableContextList.add(feature);
			} else if(feature instanceof SubprogramGroupAccess) {
				final SubprogramGroupAccess sga = (SubprogramGroupAccess)feature;
				if(sga.getKind() == AccessType.REQUIRES && sga.getAllClassifier() instanceof SubprogramGroupClassifier) {
					modifiableContextList.add(feature);
				}
			}
		}
	
		// Add Subprogram Group Subcomponents
		for(final Subcomponent sc : bi.getAllSubcomponents()) {
			if(sc instanceof SubprogramGroupSubcomponent && sc.getAllClassifier() != null) {
				modifiableContextList.add(sc);
			}
		}

		// Add other contexts
		modifiableContextList.add(processorContext);
		modifiableContextList.add(nullContext);
		
		contexts = Collections.unmodifiableList(modifiableContextList);
	}

	@Override
	public List<Object> getContexts() {
		return contexts;
	}

	@Override
	public List<Object> getSubprograms(final Object context) {
		// Build a list of subprograms
		final List<Object> subprograms = new ArrayList<Object>();
		
		// Cases:
		// Data/Subprogram Group/Abstract Type
		if(context instanceof IEObjectDescription) {
			final IEObjectDescription desc = (IEObjectDescription) context;
			final Classifier contextClassifier = (Classifier)(desc.getEObjectOrProxy().eIsProxy() ? (Classifier)EcoreUtil.resolve(desc.getEObjectOrProxy(), bi.eResource()) : desc.getEObjectOrProxy());
			if(!contextClassifier.eIsProxy()) {
				for(final Feature tmpFeature : contextClassifier.getAllFeatures()) {
					if(tmpFeature instanceof SubprogramAccess) {
						// 	Provides Subprogram Access
						if(((SubprogramAccess)tmpFeature).getKind() == AccessType.PROVIDES) {
							subprograms.add(tmpFeature);
						}
					}
				}
			}
		} else if(context instanceof SubprogramGroupAccess) { // Requires Subprogram Group Access
			// Only subprogram group accesses with kind = Requires and which has a subprogram group classifier should be in the context list
			// Provides Subprogram Access
			final SubprogramGroupClassifier spgClassifier = (SubprogramGroupClassifier)((SubprogramGroupAccess) context).getAllClassifier();
			addProvidesSubprogramAccessesForComponentClassifier(spgClassifier, subprograms);
		} else if(context instanceof FeatureGroup) { // Feature Group
			final FeatureGroup fg = (FeatureGroup)context;
			// Requires subprogram Access if not inverse and Provides subprogram access if is inverse
			final boolean inverted = fg.isInverse();
			for(final Feature tmpFeature : featureService.getAllFeatures(fg.getAllFeatureGroupType())) {
				if(tmpFeature instanceof SubprogramAccess) {
					final AccessType accessKind = ((SubprogramAccess) tmpFeature).getKind();
					if((!inverted && accessKind == AccessType.REQUIRES) || (inverted && accessKind == AccessType.PROVIDES)) {
						subprograms.add(tmpFeature);
					}
				}
			}
		} else if(context instanceof SubprogramGroupSubcomponent) { // Subprogram Group Subcomponent
			// Provides Subprogram
			addProvidesSubprogramAccessesForComponentClassifier(((SubprogramGroupSubcomponent) context).getAllClassifier(), subprograms);
		} else if(context == processorContext) { // Processor Context
			// Subprogram Proxy
			for(final ProcessorFeature processorFeature : AadlHelper.getAllProcessorFeatures(bi)) {
				if(processorFeature instanceof SubprogramProxy) {
					subprograms.add(processorFeature);
				}
			}
		} else if(context == nullContext) { // Null Context
			// Subprogram classifier reference
			final Aadl2Package aadl2Package = Aadl2Factory.eINSTANCE.getAadl2Package();
			for(final IEObjectDescription desc : ScopedEMFIndexRetrieval.getAllEObjectsByType(bi.eResource(), aadl2Package.getComponentClassifier())) {
				// Add objects that have care either types or implementations of the same category as the classifier type
				final EClass classifierEClass = desc.getEClass();
				if(aadl2Package.getSubprogramClassifier().isSuperTypeOf(classifierEClass)) {
					subprograms.add(desc);
				}
			}
			
			// Requires Subprogram Access
			for(final Feature tmpFeature : bi.getAllFeatures()) {
				if(tmpFeature instanceof SubprogramAccess && ((SubprogramAccess)tmpFeature).getKind() == AccessType.REQUIRES) {
					subprograms.add(tmpFeature);
				}							
			}
			
			// Subprogram Subcomponent
			for(final Subcomponent tmpSc : bi.getAllSubcomponents()) {
				if(tmpSc instanceof SubprogramSubcomponent) {
					subprograms.add(tmpSc);
				}
			}
			
			// Subprogram Prototype
			for(final Prototype prototype : bi.getAllPrototypes()) {
				if(prototype instanceof SubprogramPrototype) {
					subprograms.add(prototype);
				}
			}
		}
		
		return Collections.unmodifiableList(subprograms);
	}
	
	/**
	 * Returns a CallContext object from an object provided by getContexts()
	 * @param context
	 * @return
	 */
	public CallContext getCallContext(final Object context) {
		if(context == processorContext || context == nullContext) {
			return null;
		} else if(context instanceof CallContext) {
			return (CallContext)context;
		} else if(context instanceof IEObjectDescription) {
			final IEObjectDescription desc = (IEObjectDescription)context;
			if(desc.getEObjectOrProxy() instanceof CallContext) {
				return (CallContext)desc.getEObjectOrProxy();
			}
		}
			
		throw new RuntimeException("Unhandled case: " + context);

	}
	
	public CalledSubprogram getCalledSubprogram(final Object subprogram) {
		if(subprogram instanceof CalledSubprogram) {
			return (CalledSubprogram)subprogram;
		} else if(subprogram instanceof IEObjectDescription) {
			final IEObjectDescription desc = (IEObjectDescription)subprogram;
			if(desc.getEObjectOrProxy() instanceof CalledSubprogram) {
				return (CalledSubprogram)desc.getEObjectOrProxy();
			}
		} 
		
		throw new RuntimeException("Unhandled case: " + subprogram);
	}

	private void addProvidesSubprogramAccessesForComponentClassifier(final ComponentClassifier cc, final List<Object> subprograms) {
		for(final Feature tmpFeature : cc.getAllFeatures()) {
			if(tmpFeature instanceof SubprogramAccess && ((SubprogramAccess)tmpFeature).getKind() == AccessType.PROVIDES) {
				subprograms.add(tmpFeature);
			}							
		}
	}
	
	@Override
	public String getLabel(final Object value) {
		if(value instanceof IEObjectDescription){
			return ((IEObjectDescription)value).getName().toString("::");
		} else if(value instanceof NamedElement) {
			return ((NamedElement) value).getName();
		} else if(value == processorContext) {
			return "<processor>";
		} else if(value == nullContext) {
			return "";
		} else {
			throw new RuntimeException("Unhandled case");
		}
	}			
}
