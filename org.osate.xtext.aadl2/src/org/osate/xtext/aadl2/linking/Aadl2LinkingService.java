/*
 *
 * <copyright>
 * Copyright  2012 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 */
package org.osate.xtext.aadl2.linking;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.nodemodel.INode;
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
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.aadl2.modelsupport.resources.PredeclaredProperties;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.annexsupport.AnnexLinkingService;
import org.osate.annexsupport.AnnexLinkingServiceRegistry;
import org.osate.annexsupport.AnnexRegistry;
import org.osate.xtext.aadl2.properties.linking.PropertiesLinkingService;

public class Aadl2LinkingService extends PropertiesLinkingService {

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
		NamedElement annex = AadlUtil.getContainingAnnex(context);
		if (annex != null) {
			String annexName = annex.getName();
			if (annexName != null) {
				if (annexlinkingserviceregistry == null) {
					initAnnexLinkingServiceRegistry();
				}
				if (annexlinkingserviceregistry != null) {
					AnnexLinkingService linkingservice = annexlinkingserviceregistry.getAnnexLinkingService(annexName);
					if (linkingservice != null) {
						List<EObject> result = linkingservice
								.resolveAnnexReference(annexName, context, reference, node);
						if (!result.isEmpty()) {
							return result;
						}
					}
				}
			}
		}

//		EMFIndexRetrieval.printEMFIndexEMV2(context);
		final EClass requiredType = reference.getEReferenceType();
		if (requiredType == null) {
			return Collections.<EObject> emptyList();
		}

		final EClass pt = Aadl2Package.eINSTANCE.getPropertyType();
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
			return Collections.EMPTY_LIST;
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
			ConnectedElement connectedElement = (ConnectedElement) context;
			ConnectionEnd ce = findElementInContext(connectedElement, connectedElement.getContext(), name,
					ConnectionEnd.class);
			if (ce != null) {
				return Collections.singletonList((EObject) ce);
			}
			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getTriggerPort() == requiredType) {
			ModeTransitionTrigger trigger = (ModeTransitionTrigger) context;
			TriggerPort triggerPort = findElementInContext(trigger, trigger.getContext(), name, TriggerPort.class);
			if (triggerPort != null) {
				return Collections.singletonList((EObject) triggerPort);
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
			EndToEndFlowElement flowElement = findElementInContext(fs, fs.getContext(), name, EndToEndFlowElement.class);
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
//			Activator.logErrorMessage("Unhandled reference in Aadl2LinkingService: "+reference.getName()+" to "+requiredType.getName());
		}

//		return Collections.emptyList();
	}

	private static Aadl2LinkingService eInstance = null;

	@Deprecated
	public static Aadl2LinkingService getAadl2LinkingService() {
		if (eInstance == null) {
			if (Platform.isRunning()) {
				PredeclaredProperties.initPluginContributedAadl();
			}
			Resource rsrc = OsateResourceUtil.getResource(URI
					.createPlatformResourceURI(PredeclaredProperties.PLUGIN_RESOURCES_PROJECT_NAME
							+ "/AADL_Project.aadl"));
			eInstance = (Aadl2LinkingService) ((LazyLinkingResource) rsrc).getLinkingService();
		}
		return eInstance;
	}
}