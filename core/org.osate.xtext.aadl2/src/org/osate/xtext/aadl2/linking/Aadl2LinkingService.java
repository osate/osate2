package org.osate.xtext.aadl2.linking;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.nodemodel.INode;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AccessConnection;
import org.osate.aadl2.AccessType;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.CallContext;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentPrototype;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.ConnectedElement;
import org.osate.aadl2.Connection;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.Context;
import org.osate.aadl2.DataPort;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.EndToEndFlowElement;
import org.osate.aadl2.EndToEndFlowSegment;
import org.osate.aadl2.EventDataPort;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureConnection;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupConnection;
import org.osate.aadl2.FeatureGroupPrototype;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.FeaturePrototype;
import org.osate.aadl2.FlowElement;
import org.osate.aadl2.FlowSegment;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.ModeFeature;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Parameter;
import org.osate.aadl2.ParameterConnection;
import org.osate.aadl2.Port;
import org.osate.aadl2.PortConnection;
import org.osate.aadl2.Prototype;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramGroupAccess;
import org.osate.aadl2.SubprogramGroupSubcomponent;
import org.osate.aadl2.SubprogramGroupSubcomponentType;
import org.osate.aadl2.TriggerPort;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.aadl2.modelsupport.resources.PredeclaredProperties;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.xtext.aadl2.properties.linking.PropertiesLinkingService;

public class Aadl2LinkingService extends PropertiesLinkingService {
//	private  ErrorModelLanguageServices emLangS  = new ErrorModelLanguageServices();
//	private ILinkingService emLS = emLangS.getLinkingService();

	public NamedElement getContainingAnnex(EObject obj){
		while (obj != null ){
			if (obj instanceof AnnexLibrary || obj instanceof AnnexSubclause)
				return (NamedElement)obj;
			obj = obj.eContainer();
		}
		return null;
	}
	
	@Override
	public List<EObject> getLinkedObjects(EObject context,
			EReference reference, INode node) throws IllegalNodeException {
		NamedElement annex = getContainingAnnex(context);
		if (annex != null){
			String annexName = annex.getName();
			if (annexName != null && annexName.equalsIgnoreCase("emv2")){
//				return emLS.getLinkedObjects(context, reference, node);
			} else {
				return super.getLinkedObjects(context, reference, node);
			}
		}
		final EClass requiredType = reference.getEReferenceType();
		if (requiredType == null)
			return Collections.<EObject> emptyList();
		
		final EClass pt = Aadl2Package.eINSTANCE.getPropertyType();
		final EClass cl = Aadl2Package.eINSTANCE.getClassifier();
		final EClass sct = Aadl2Package.eINSTANCE.getSubcomponentType();
		final String name = getCrossRefNodeAsString(node);
//		if (sct.isSuperTypeOf(requiredType) || cl.isSuperTypeOf(requiredType)) {
//			// XXX: this code is replicated from PropertiesLinkingService as it is called often
//			// resolve classifier reference
//			EObject e = findClassifier(context, reference,  name);
//			if (e != null ) {
//				// the result satisfied the expected class
//				return Collections.singletonList((EObject) e);
//			}
//				// need to resolve prototype
//			if (Aadl2Package.eINSTANCE.getPrototype().isSuperTypeOf(requiredType)){
//				EObject res = AadlUtil.getContainingClassifier(context)
//						.findNamedElement(name);
//				if (Aadl2Package.eINSTANCE.getDataPrototype()==reference ){
//					if( res instanceof DataPrototype ){
//						return Collections.singletonList(res);
//					}
//				} else if ( res instanceof ComponentPrototype) {
//					return Collections.singletonList(res);
//				}
//			}
//			return Collections.<EObject> emptyList();
//		} else
		if (Aadl2Package.eINSTANCE.getFeatureClassifier() == requiredType) {
			// prototype for feature or component, or data,bus,subprogram, subprogram group classifier
			EObject e = findClassifier(context, reference,  name);
			if (e == null){
				// look for prototype
				e = AadlUtil.getContainingClassifier(context).findNamedElement(name);
				// TODO-phf: this can be removed if the FeatureClassifier class handles it
				if (! (e instanceof FeaturePrototype || e instanceof ComponentPrototype))
					e = null;
			}
			if (e!=null&&requiredType.isSuperTypeOf(e.eClass())){
				return Collections.singletonList((EObject) e);
			}
			return Collections.<EObject> emptyList();
		} else if (Aadl2Package.eINSTANCE.getFeaturePrototype() == requiredType) {
				// look for prototype
				EObject e = AadlUtil.getContainingClassifier(context).findNamedElement(name);
				// TODO-phf: this can be removed if the FeatureClassifier class handles it
				if (e instanceof FeaturePrototype )
					return Collections.singletonList((EObject) e);
				return Collections.<EObject> emptyList();
		} else if (Aadl2Package.eINSTANCE.getConnectionEnd() == requiredType) {
			// resolve connection end
			Context cxt = ((ConnectedElement) context).getContext();
			Connection conn = (Connection) context.eContainer();
			ConnectionEnd ce = null;
			if (conn instanceof PortConnection) {
				ce = findPortConnectionEnd(
						(PortConnection) context.eContainer(), cxt, name);
			} else if (conn instanceof AccessConnection) {
				ce = findAccessConnectionEnd(
						(AccessConnection) context.eContainer(), cxt, name);
			} else if (conn instanceof FeatureGroupConnection) {
				ce = findFeatureGroupConnectionEnd(
						(FeatureGroupConnection) context.eContainer(), cxt, name);
			} else if (conn instanceof FeatureConnection) {
				ce = findFeatureConnectionEnd(
						(FeatureConnection) context.eContainer(), cxt, name);
			} else if (conn instanceof ParameterConnection) {
				ce = findParameterConnectionEnd(
						(ParameterConnection) context.eContainer(), cxt, name);
			}
			if (ce != null) {
				return Collections.singletonList((EObject) ce);
			}
			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getPort() == requiredType) {
			Classifier ns = AadlUtil.getContainingClassifier(context);
			if (context instanceof Feature) {
				// we need to resolve a  feature refinement, thus look up the feature in the 
				// component being extended
				if (ns.getExtended() != null) {
					ns = ns.getExtended();
				} else {
					return Collections.emptyList();
				}
			} else if (context instanceof TriggerPort){
				// we are a trigger port
				Context TPContext = ((TriggerPort)context).getContext();
				if (TPContext instanceof Subcomponent){
					// look up the feature in the ComponentType
					ComponentType ct = ((Subcomponent)TPContext).getComponentType();
					if (ct != null)
						ns = ct;
				}
			}
			EObject searchResult = AadlUtil.findNamedElementInList(ns.getAllFeatures(), name);
			if (searchResult != null && searchResult instanceof Port) {
				return Collections.singletonList((EObject) searchResult);
			}
			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getContext() == requiredType) {
			// represents connection source/dest context as well as flowspec
			// context
			// also used in triggerport
			EObject searchResult = AadlUtil.getContainingClassifier(context)
					.findNamedElement(name);
			if (context instanceof ConnectedElement) {
				// connection context
				EObject conn = context.eContainer();
				if (((conn instanceof FeatureGroupConnection
						|| conn instanceof FeatureConnection ) 
						&& (searchResult instanceof Subcomponent || searchResult instanceof FeatureGroup))
					|| ((conn instanceof AccessConnection) 
						&& (searchResult instanceof Subcomponent 
							|| searchResult instanceof FeatureGroup
							|| searchResult instanceof SubprogramCall))
					|| ((conn instanceof ParameterConnection) 
						&& (searchResult instanceof Parameter
							|| searchResult instanceof SubprogramCall
							|| searchResult instanceof DataPort
							|| searchResult instanceof EventDataPort || searchResult instanceof FeatureGroup))
					|| ((conn instanceof PortConnection) 
						&& (searchResult instanceof FeatureGroup
							|| searchResult instanceof Subcomponent || searchResult instanceof SubprogramCall
							|| searchResult instanceof DataPort || searchResult instanceof EventDataPort)))
					return Collections.singletonList((EObject) searchResult);
			} else if (context instanceof TriggerPort
					|| context instanceof FlowSpecification
					|| context instanceof FlowSegment
					|| context instanceof EndToEndFlowSegment) {
				if (searchResult instanceof Subcomponent
						|| searchResult instanceof FeatureGroup
						|| searchResult instanceof SubprogramCall)
					return Collections.singletonList((EObject) searchResult);
			}
			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getCallContext() == requiredType) {
			EObject searchResult = AadlUtil.getContainingClassifier(context)
					.findNamedElement(name);
			if (searchResult != null
					&& requiredType.isSuperTypeOf(searchResult.eClass())) {
				return Collections.singletonList((EObject) searchResult);
			}
			searchResult = findClassifier(context, reference, name);
			if (searchResult != null ) {
				return Collections.singletonList((EObject) searchResult);
			}
			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getCalledSubprogram() == requiredType) {
			// if cxt then search in context
			Classifier ns = AadlUtil.getContainingClassifier(context);
			CallContext callContext = ((SubprogramCall) context).getContext();
			if (callContext == null){
				// look for prototype, subprogramsubcomponent
				EObject searchResult = ns.findNamedElement(name);
				if (searchResult == null){
					// look for subprogramclassifier
					searchResult = findClassifier(context, reference,  name);
				}
				if (searchResult != null
						&& requiredType.isSuperTypeOf(searchResult.eClass())) {
					return Collections.singletonList((EObject) searchResult);
				}
			} else {
				if (callContext instanceof ComponentType){
					ns = (ComponentType)callContext;
				} else if (callContext instanceof SubprogramGroupSubcomponent){
					ns = ((SubprogramGroupSubcomponent)callContext).getComponentType();
					if (ns == null) {
						return Collections.<EObject> emptyList();
					}
				} else if (callContext instanceof SubprogramGroupAccess && ((SubprogramGroupAccess)callContext).getKind() == AccessType.REQUIRED){
					SubprogramGroupSubcomponentType sst = ((SubprogramGroupAccess)callContext).getSubprogramGroupFeatureClassifier();
					if (sst instanceof Classifier)
						ns = (Classifier) sst;;
					if (ns == null) {
						return Collections.<EObject> emptyList();
					}
				} else if (callContext instanceof FeatureGroup ){
					ns = ((FeatureGroup)callContext).getFeatureGroupType();
					if (ns == null) {
						return Collections.<EObject> emptyList();
					}
				}
				EObject searchResult = ns.findNamedElement(name);
				if (searchResult != null && requiredType.isSuperTypeOf(searchResult.eClass())) {
					return Collections.singletonList((EObject) searchResult);
				}
			}
			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getPrototype() == requiredType) {
			// if context prototype then find in extension source (refined)
			// prototype binding as context
			Classifier ns = AadlUtil.getContainingClassifier(context);
			if (context instanceof Prototype) {
				// we need to resolve a refinement
				if (ns.getExtended() != null) {
					ns = ns.getExtended();
				} else {
					return Collections.emptyList();
				}
			}
			EObject searchResult = ns.findNamedElement(name);
			if (searchResult != null && searchResult instanceof Prototype) {
				return Collections.singletonList((EObject) searchResult);
			}
			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getFlowElement() == requiredType) {
			// look for flow element in flow segment
			FlowSegment fs = (FlowSegment) context;
			Context flowContext = fs.getContext();
			if (flowContext == null){
				ComponentImplementation cc = fs.getContainingComponentImpl();
				if (Aadl2Util.isNull(cc)) return Collections.<EObject> emptyList();;
				EObject searchResult = cc.findNamedElement(name);
				if (searchResult instanceof FlowElement){
					return Collections.singletonList((EObject) searchResult);
				}
			} else {
				if (flowContext instanceof Subcomponent){
					ComponentType cc = ((Subcomponent)flowContext).getComponentType();
					if (Aadl2Util.isNull(cc)) 
						return Collections.<EObject> emptyList();;
					EObject searchResult = cc.findNamedElement(name);
					if (searchResult instanceof FlowSpecification){
						return Collections.singletonList( searchResult);
					}
				}  
			}
			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getEndToEndFlowElement() == requiredType) {
			// look for flow element in flow segment
			EndToEndFlowSegment fs = (EndToEndFlowSegment) context;
			Context flowContext = fs.getContext();
			if (flowContext == null){
				ComponentImplementation cc = fs.getContainingComponentImpl();
				EObject searchResult = cc.findNamedElement(name);
				if (searchResult instanceof EndToEndFlowElement){
					return Collections.singletonList((EObject) searchResult);
				}
			} else {
				if (flowContext instanceof Subcomponent){
					ComponentType cc = ((Subcomponent)flowContext).getComponentType();
					if (Aadl2Util.isNull(cc)) 
						return Collections.<EObject> emptyList();
					EObject searchResult = cc.findNamedElement(name);
					if (searchResult instanceof FlowSpecification){
						return Collections.singletonList( searchResult);
					}
				}  
			}
			return Collections.<EObject> emptyList();

		} else if (pt.isSuperTypeOf(requiredType)) {
			// look for property type in property set
			return findPropertyType(context, reference, name);

		} else if (Aadl2Package.eINSTANCE.getPropertyConstant() == requiredType
				) {
			// look for property constant in property set
			return findPropertyConstant(context, reference, name);

		} else if (Aadl2Package.eINSTANCE.getUnitLiteral() == requiredType) {
			// look for unit literal pointed to by baseUnit
			return findUnitLiteralAsList(context, reference, name);

		} else if (Aadl2Package.eINSTANCE.getEnumerationLiteral() == requiredType) {
			// look for enumeration literal
			return findEnumLiteralAsList(context, reference, name);

		} else if (Aadl2Package.eINSTANCE.getModeTransition() == requiredType) {
			// referenced by in modes
			EObject searchResult = AadlUtil.getContainingClassifier(context)
					.findNamedElement(name);
			if (searchResult != null && searchResult instanceof ModeTransition) {
				return Collections.singletonList((EObject) searchResult);
			}
			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getModeFeature() == requiredType) {
			// referenced by mode transition and inmodes
			EObject searchResult = AadlUtil.getContainingClassifier(context)
					.findNamedElement(name);
			if (searchResult != null && searchResult instanceof ModeFeature) {
				return Collections.singletonList((EObject) searchResult);
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
			if (searchResult != null
					&& searchResult instanceof FlowSpecification) {
				return Collections.singletonList((EObject) searchResult);
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
				return Collections.singletonList((EObject) searchResult);
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
				return Collections.singletonList((EObject) searchResult);
			}
			return Collections.<EObject> emptyList();
		} else if (Aadl2Package.eINSTANCE.getFeatureType() == requiredType) {
			// feature group type or prototype
			FeatureGroupType fgt = findFeatureGroupType(context, name, reference);
			if (fgt == null){
				// need to resolve prototype
				EObject res = AadlUtil.getContainingClassifier(context)
						.findNamedElement(name);
				 if ( res instanceof FeatureGroupPrototype) {
					return Collections.singletonList(res);
				}
			} else{
				return Collections.singletonList((EObject) fgt);
			}
			return Collections.<EObject> emptyList();
		} else if (Aadl2Package.eINSTANCE.getArraySizeProperty() == requiredType) {
			// reference to a property constant or property
			// look for property definition in property set
			List<EObject> result = findPropertyDefinitionAsList(context, reference, name);
			if (result.isEmpty()){
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

	public static Aadl2LinkingService getAadl2LinkingService(){
		if (eInstance == null) {
			Resource rsrc = OsateResourceUtil.getResource(URI.createPlatformResourceURI(PredeclaredProperties.PLUGIN_RESOURCES_DIRECTORY_NAME+"/SEI.aadl"));
			eInstance = (Aadl2LinkingService)((LazyLinkingResource)rsrc).getLinkingService();
		}
		return eInstance;
	}

	

}
