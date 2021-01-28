/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.xtext.aadl2.linking;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AccessType;
import org.osate.aadl2.CallContext;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentImplementationReference;
import org.osate.aadl2.ComponentPrototype;
import org.osate.aadl2.ComponentPrototypeActual;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.ConnectedElement;
import org.osate.aadl2.Connection;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.Context;
import org.osate.aadl2.DataPrototype;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.EndToEndFlowElement;
import org.osate.aadl2.EndToEndFlowSegment;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupPrototype;
import org.osate.aadl2.FeatureGroupPrototypeActual;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.FeaturePrototype;
import org.osate.aadl2.FeatureType;
import org.osate.aadl2.FlowElement;
import org.osate.aadl2.FlowSegment;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.Generalization;
import org.osate.aadl2.ModeFeature;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.ModeTransitionTrigger;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Port;
import org.osate.aadl2.Prototype;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubcomponentType;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramGroupAccess;
import org.osate.aadl2.SubprogramGroupSubcomponent;
import org.osate.aadl2.SubprogramGroupSubcomponentType;
import org.osate.aadl2.SubprogramType;
import org.osate.aadl2.TriggerPort;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.annexsupport.AnnexLinkingService;
import org.osate.annexsupport.AnnexLinkingServiceRegistry;
import org.osate.annexsupport.AnnexRegistry;
import org.osate.xtext.aadl2.properties.linking.PropertiesLinkingService;

import com.google.inject.Inject;

public class Aadl2LinkingService extends PropertiesLinkingService {

	@Inject
	IResourceScopeCache linkingCache;

	AnnexLinkingServiceRegistry annexlinkingserviceregistry;

	protected void Aadl2linkingService() {
		initAnnexLinkingServiceRegistry();
	}

	protected void initAnnexLinkingServiceRegistry() {
		if (annexlinkingserviceregistry == null) {
			annexlinkingserviceregistry = (AnnexLinkingServiceRegistry) AnnexRegistry
					.getRegistry(AnnexRegistry.ANNEX_LINKINGSERVICE_EXT_ID);
		}
	}

	@Override
	public List<EObject> getLinkedObjects(EObject context, EReference reference, INode node)
			throws IllegalNodeException {
		List<EObject> result;
		String crossRefString = getCrossRefNodeAsString(node);
		boolean global = crossRefString.contains("::");

		result = linkingCache.get(global ? crossRefString : node, context.eResource(),
				() -> doGetLinkedObjects(context, reference, node));
		return result;
	}

	private List<EObject> doGetLinkedObjects(EObject context, EReference reference, INode node)
			throws IllegalNodeException {
		NamedElement annex = AadlUtil.getContainingAnnex(context);
		if (annex != null && !(reference == Aadl2Package.eINSTANCE.getModalElement_InMode())) {
			String annexName = annex.getName();
			if (annexName != null) {
				if (annexlinkingserviceregistry == null) {
					initAnnexLinkingServiceRegistry();
				}
				if (annexlinkingserviceregistry != null) {
					AnnexLinkingService linkingservice = annexlinkingserviceregistry.getAnnexLinkingService(annexName);
					if (linkingservice != null) {
						return linkingservice.resolveAnnexReference(annexName, context, reference, node);
					}
				}
			}
			return Collections.<EObject> emptyList();
		}

		final EClass requiredType = reference.getEReferenceType();
		if (requiredType == null) {
			return Collections.<EObject> emptyList();
		}

		Aadl2Package.eINSTANCE.getPropertyType();
		final EClass cl = Aadl2Package.eINSTANCE.getClassifier();
		final EClass sct = Aadl2Package.eINSTANCE.getSubcomponentType();
		final String name = getCrossRefNodeAsString(node);
		if (sct.isSuperTypeOf(requiredType) || cl.isSuperTypeOf(requiredType)) {
			// XXX: this code can be replicated in Aadl2LinkingService as it is called often in the core
			// resolve classifier reference
			EObject e = findClassifier(context, reference, name);
			if (e != null) {
				// the result satisfied the expected class
				return Collections.singletonList(e);
			}
			if (!(context instanceof Generalization) && sct.isSuperTypeOf(requiredType)) {
				// need to resolve prototype
				Classifier containingClassifier = AadlUtil.getContainingClassifier(context);
				/*
				 * This test was put here as a quick and dirty fix to a NullPointerException that was
				 * being thrown while typing up a component type renames statement. Need to figure out
				 * what we should really be doing for renames.
				 */
				if (containingClassifier != null) {
					EObject res = AadlUtil.getContainingClassifier(context).findNamedElement(name);
					if (Aadl2Package.eINSTANCE.getDataPrototype() == reference) {
						if (res instanceof DataPrototype) {
							return Collections.singletonList(res);
						}
					} else if (res instanceof ComponentPrototype) {
						return Collections.singletonList(res);
					}
				}
			}
			return Collections.emptyList();
		} else if (Aadl2Package.eINSTANCE.getFeatureClassifier().isSuperTypeOf(requiredType)) {
			// prototype for feature or component, or data,bus,subprogram, subprogram group classifier
			EObject e = findClassifier(context, reference, name);
			if (Aadl2Util.isNull(e) && !(context instanceof Generalization)
					&& !Aadl2Package.eINSTANCE.getComponentType().isSuperTypeOf(requiredType)) {
				// look for prototype
				e = AadlUtil.getContainingClassifier(context).findNamedElement(name);
				// TODO-phf: this can be removed if the FeatureClassifier class handles it
				if (!(e instanceof FeaturePrototype || e instanceof ComponentPrototype)) {
					e = null;
				}
			}
			if (e != null && requiredType.isSuperTypeOf(e.eClass())) {
				return Collections.singletonList(e);
			}
			return Collections.<EObject> emptyList();
		} else if (Aadl2Package.eINSTANCE.getFeaturePrototype() == requiredType) {
			// look for prototype
			EObject e = AadlUtil.getContainingClassifier(context).findNamedElement(name);
			// TODO-phf: this can be removed if the FeatureClassifier class handles it
			if (e instanceof FeaturePrototype) {
				return Collections.singletonList(e);
			}
			return Collections.<EObject> emptyList();
		} else if (Aadl2Package.eINSTANCE.getConnectionEnd() == requiredType) {
			// resolve connection end
			ConnectionEnd ce = null;
			if (context.eContainer() instanceof ConnectedElement) {
				ConnectedElement contextParent = (ConnectedElement) context.eContainer();
				if (contextParent.getConnectionEnd() instanceof FeatureGroup) {
					ce = findElementInContext(contextParent, (FeatureGroup) contextParent.getConnectionEnd(), name,
							ConnectionEnd.class);
				}
			} else {
				ConnectedElement connectedElement = (ConnectedElement) context;
				ce = findElementInContext(connectedElement, connectedElement.getContext(), name, ConnectionEnd.class);
			}
			if (ce != null) {
				return Collections.singletonList((EObject) ce);
			}
			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getTriggerPort() == requiredType) {
			if (context instanceof ModeTransitionTrigger) {
				ModeTransitionTrigger trigger = (ModeTransitionTrigger) context;
				TriggerPort triggerPort = findElementInContext(trigger, trigger.getContext(), name, TriggerPort.class);
				if (triggerPort != null) {
					return Collections.singletonList((EObject) triggerPort);
				}
			}
			return Collections.emptyList();
		} else if (Aadl2Package.eINSTANCE.getPort().isSuperTypeOf(requiredType)) {
			Classifier ns = AadlUtil.getContainingClassifier(context);
			if (context instanceof Feature) {
				// we need to resolve a feature refinement, thus look up the feature in the
				// component being extended
				if (ns.getExtended() != null) {
					ns = ns.getExtended();
				} else {
					return Collections.emptyList();
				}
//			} else if (context instanceof ModeTransitionTrigger){
//				// we are a mode transition trigger
//				Context triggerContext = ((ModeTransitionTrigger)context).getContext();
//				if (triggerContext instanceof Subcomponent){
//					// look up the feature in the ComponentType
//					ComponentType ct = ((Subcomponent)triggerContext).getComponentType();
//					if (ct != null)
//						ns = ct;
//				}
//				if (triggerContext instanceof FeatureGroup){
//					// look up the feature in the FeaturegroupType
//					 FeatureGroupType ct = ((FeatureGroup)triggerContext).getFeatureGroupType();
//					if (ct != null)
//						ns = ct;
//				}
			}
			EObject searchResult = AadlUtil.findNamedElementInList(ns.getAllFeatures(), name);
			if (searchResult != null && searchResult instanceof Port) {
				return Collections.singletonList(searchResult);
			}
			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getContext() == requiredType) {
			// represents connection source/dest context as well as flowspec
			// context
			// also used in triggerport
			EObject searchResult = AadlUtil.getContainingClassifier(context).findNamedElement(name);
			if (searchResult instanceof Context) {
				return Collections.singletonList(searchResult);
			}
			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getCallContext() == requiredType) {
			EObject searchResult = AadlUtil.getContainingClassifier(context).findNamedElement(name);
			if (searchResult != null && requiredType.isSuperTypeOf(searchResult.eClass())) {
				return Collections.singletonList(searchResult);
			}
			searchResult = findClassifier(context, reference, name);
			if (searchResult != null) {
				return Collections.singletonList(searchResult);
			}
			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getCalledSubprogram() == requiredType) {
			Classifier ns = AadlUtil.getContainingClassifier(context);
			EObject searchResult;
			if (!(context instanceof SubprogramCall)
					|| (context instanceof SubprogramCall && ((SubprogramCall) context).getContext() == null)) {
				// first check whether it is a reference to a classifier
				searchResult = findClassifier(context, reference, name);
				if (searchResult != null && requiredType.isSuperTypeOf(searchResult.eClass())) {
					return Collections.singletonList(searchResult);
				}
				// if it was a qualified component type name it would have been found before
				if (name.contains("::")) {
					// Qualified classifier should have been found before
					return Collections.<EObject> emptyList();
				}
				// no package qualifier. Look up in local name space, e.g., subprogram access feature or subprogram subcomponent
				searchResult = ns.findNamedElement(name);
				if (searchResult != null && requiredType.isSuperTypeOf(searchResult.eClass())) {
					return Collections.singletonList(searchResult);
				}
			}
			// we have a name with context
			// lets first find it in its context
			if (context instanceof SubprogramCall) {
				// we have a context
				// lets set it and find the called subprogram
				SubprogramCall callSpec = (SubprogramCall) context;
				CallContext callContext = callSpec.getContext();
				if (callContext instanceof ComponentType) {
					// first try to find subprogram implementation
					ComponentType ct = (ComponentType) callContext;
					String implname = ct.getQualifiedName() + "." + name;
					searchResult = findClassifier(context, reference, implname);
					if (searchResult != null && searchResult instanceof ComponentImplementation) {
						return Collections.singletonList(searchResult);
					}
					ns = (ComponentType) callContext;
				} else if (callContext instanceof SubprogramGroupSubcomponent) {
					ns = ((SubprogramGroupSubcomponent) callContext).getComponentType();
					if (Aadl2Util.isNull(ns)) {
						return Collections.<EObject> emptyList();
					}
				} else if (callContext instanceof SubprogramGroupAccess
						&& ((SubprogramGroupAccess) callContext).getKind() == AccessType.REQUIRES) {
					SubprogramGroupSubcomponentType sst = ((SubprogramGroupAccess) callContext)
							.getSubprogramGroupFeatureClassifier();
					if (sst instanceof Classifier) {
						ns = (Classifier) sst;
					}
					if (Aadl2Util.isNull(ns)) {
						return Collections.<EObject> emptyList();
					}
				} else if (callContext instanceof FeatureGroup) {
					ns = ((FeatureGroup) callContext).getFeatureGroupType();
					if (Aadl2Util.isNull(ns)) {
						return Collections.<EObject> emptyList();
					}
				}
				searchResult = ns.findNamedElement(name);
				if (!Aadl2Util.isNull(searchResult) && requiredType.isSuperTypeOf(searchResult.eClass())) {
					return Collections.singletonList(searchResult);
				}
				// it might be a component implementation. The type is already recorded in the context
				if (callContext instanceof SubprogramType) {
					String contextName = ((SubprogramType) callContext).getName();
					searchResult = findClassifier(context, reference, contextName + "." + name);
					if (!Aadl2Util.isNull(searchResult)) {
						return Collections.singletonList(searchResult);
					}
					return Collections.<EObject> emptyList();
				}
			}

			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getPrototype() == requiredType) {
			// if context prototype then find in extension source (refined)
			// prototype binding as context
			EObject searchResult = null;
			Classifier ns = null;
			if (context.eContainer() instanceof Subcomponent) {
				Subcomponent sub = (Subcomponent) context.eContainer();
				ns = sub.getAllClassifier();
				if (!Aadl2Util.isNull(ns)) {
					searchResult = ns.findNamedElement(name);
				}
			} else if (context.eContainer() instanceof ComponentPrototypeActual) {
				ComponentPrototypeActual cpa = (ComponentPrototypeActual) context.eContainer();
				SubcomponentType subT = cpa.getSubcomponentType();
				if (subT instanceof ComponentClassifier) {
					searchResult = ((ComponentClassifier) subT).findNamedElement(name);
				}
			} else if (context.eContainer() instanceof FeatureGroupPrototypeActual) {
				FeatureGroupPrototypeActual cpa = (FeatureGroupPrototypeActual) context.eContainer();
				FeatureType subT = cpa.getFeatureType();
				if (subT instanceof FeatureGroupType) {
					searchResult = ((FeatureGroupType) subT).findNamedElement(name);
				}
			} else if (context.eContainer() instanceof ComponentImplementationReference) {
				ns = ((ComponentImplementationReference) context.eContainer()).getImplementation();
				if (!Aadl2Util.isNull(ns)) {
					searchResult = ns.findNamedElement(name);
				}
			} else {
				// If resolving a prototype binding formal, don't resolve to a local prototype. Go to the generals.
				// We could be in a prototype refinement. Go to the generals so that we don't resolve to context.
				ns = AadlUtil.getContainingClassifier(context);
				for (Iterator<Classifier> iter = ns.getGenerals().iterator(); searchResult == null && iter.hasNext();) {
					searchResult = iter.next().findNamedElement(name);
				}
			}
			if (!Aadl2Util.isNull(searchResult) && searchResult instanceof Prototype) {
				return Collections.singletonList(searchResult);
			}
			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getFlowElement() == requiredType) {
			// look for flow element in flow segment
			FlowSegment fs = (FlowSegment) context;
			FlowElement flowElement = findElementInContext(fs, fs.getContext(), name, FlowElement.class);
			if (flowElement != null) {
				return Collections.singletonList((EObject) flowElement);
			}
			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getEndToEndFlowElement() == requiredType) {
			// look for flow element in flow segment
			EndToEndFlowSegment fs = (EndToEndFlowSegment) context;
			EndToEndFlowElement flowElement = findElementInContext(fs, fs.getContext(), name,
					EndToEndFlowElement.class);
			if (flowElement != null) {
				return Collections.singletonList((EObject) flowElement);
			}
			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getModeTransition() == requiredType) {
			// referenced by in modes
			EObject searchResult = AadlUtil.getContainingClassifier(context).findNamedElement(name);
			if (searchResult != null && searchResult instanceof ModeTransition) {
				return Collections.singletonList(searchResult);
			}
			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getModeFeature() == requiredType) {
			// referenced by inmodes in connections and flows
			EObject searchResult = AadlUtil.getContainingClassifier(context).findNamedElement(name);
			if (searchResult != null && searchResult instanceof ModeFeature) {
				return Collections.singletonList(searchResult);
			}
			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getFlowSpecification() == requiredType) {
			// refined flow spec
			// referenced by flow implementation
			// also referenced in flow elements in impl and etef
			Classifier ns = AadlUtil.getContainingClassifier(context);
			if (context instanceof FlowSpecification) {
				// we need to resolve a refinement
				if (ns.getExtended() != null) {
					ns = ns.getExtended();
				} else {
					return Collections.emptyList();
				}
			}
			EObject searchResult = ns.findNamedElement(name);
			if (searchResult != null && searchResult instanceof FlowSpecification) {
				return Collections.singletonList(searchResult);
			}
			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getEndToEndFlow() == requiredType) {
			// refined flow spec
			// referenced by flow implementation
			// also referenced in flow elements in impl and etef
			Classifier ns = AadlUtil.getContainingClassifier(context);
			if (context instanceof EndToEndFlow) {
				// we need to resolve a refinement
				if (ns.getExtended() != null) {
					ns = ns.getExtended();
				} else {
					return Collections.emptyList();
				}
			}
			EObject searchResult = ns.findNamedElement(name);
			if (searchResult != null && searchResult instanceof EndToEndFlow) {
				return Collections.singletonList(searchResult);
			}
			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getConnection() == requiredType) {
			// refined to, flow elements
			Classifier ns = AadlUtil.getContainingClassifier(context);
			if (context instanceof Connection) {
				// we need to resolve a refinement
				if (ns.getExtended() != null) {
					ns = ns.getExtended();
				} else {
					return Collections.emptyList();
				}
			}
			EObject searchResult = ns.findNamedElement(name);
			if (searchResult != null && searchResult instanceof Connection) {
				return Collections.singletonList(searchResult);
			}
			return Collections.<EObject> emptyList();
		} else if (Aadl2Package.eINSTANCE.getFeatureType() == requiredType) {
			// feature group type or prototype
			FeatureGroupType fgt = findFeatureGroupType(context, name, reference);
			if (Aadl2Util.isNull(fgt)) {
				// need to resolve prototype
				EObject res = AadlUtil.getContainingClassifier(context).findNamedElement(name);
				if (res instanceof FeatureGroupPrototype) {
					return Collections.singletonList(res);
				}
			} else {
				return Collections.singletonList((EObject) fgt);
			}
			return Collections.<EObject> emptyList();
		} else if (Aadl2Package.eINSTANCE.getArraySizeProperty() == requiredType) {
			// reference to a property constant or property
			// look for property definition in property set
			List<EObject> result = findPropertyDefinitionAsList(context, reference, name);
			if (result.isEmpty()) {
				result = findPropertyConstant(context, reference, name);

			}
			return result;
		} else {

			List<EObject> res = super.getLinkedObjects(context, reference, node);
			return res;
		}
	}
}