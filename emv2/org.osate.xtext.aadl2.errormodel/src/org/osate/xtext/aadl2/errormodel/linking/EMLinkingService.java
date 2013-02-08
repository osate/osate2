package org.osate.xtext.aadl2.errormodel.linking;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.nodemodel.INode;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Feature;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.xtext.aadl2.errormodel.errorModel.ComponentErrorBehavior;
import org.osate.xtext.aadl2.errormodel.errorModel.CompositeErrorBehavior;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorFlow;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagations;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;
import org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition;
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedObservableErrorPropagationPoint;
import org.osate.xtext.aadl2.errormodel.errorModel.RecoverEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.SubcomponentElement;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeMappingSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeTransformationSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeUseContext;
import org.osate.xtext.aadl2.errormodel.errorModel.impl.SubcomponentElementImpl;
import org.osate.xtext.aadl2.errormodel.util.EM2Util;
import org.osate.xtext.aadl2.properties.linking.PropertiesLinkingService;
import org.osate.xtext.aadl2.properties.util.EMFIndexRetrieval;

public class EMLinkingService extends PropertiesLinkingService {
	
	public EMLinkingService(){
		super();
	}



	@Override
	public List<EObject> getLinkedObjects(EObject context,
			EReference reference, INode node) throws IllegalNodeException {
		final EClass requiredType = reference.getEReferenceType();
		EObject searchResult = null;
		if (requiredType == null)
			return Collections.<EObject> emptyList();

		final String name = getCrossRefNodeAsString(node);
		if (Aadl2Package.eINSTANCE.getNamedElement() == requiredType) {
			// containment path element
			if (context instanceof ContainmentPathElement) {
				ContainedNamedElement path = (ContainedNamedElement) context.eContainer();
				EList<ContainmentPathElement> list = path
						.getContainmentPathElements();
				int idx = list.indexOf(context);
				if (idx > 0) {
					// find next element in namespace of previous element
					ContainmentPathElement el = list.get(idx - 1);
					NamedElement ne = el.getNamedElement();
					if (ne instanceof Subcomponent) {
						ComponentClassifier ns = ((Subcomponent) ne).getClassifier();
						// find annex subclause as context for error model identifier lookup
						if (!Aadl2Util.isNull(ns)){
							ErrorModelSubclause emsc = EM2Util.getErrorModelSubclause(ns);
							ErrorBehaviorStateMachine ebsm = emsc.getUseBehavior();
							ComponentErrorBehavior compbehaviors = EM2Util.getComponentErrorBehavior(ns);
							searchResult = findErrorType(emsc, name);
							if (searchResult == null) searchResult = findTypeSet(emsc, name);
							if (searchResult == null) searchResult = findObservableErrorPropagationPoint(emsc, name);
							if (searchResult==null) searchResult = findErrorPropagationPoint(emsc, name,null);
							if (searchResult==null) searchResult = findErrorFlow(emsc, name);
							if (ebsm != null){
								if (searchResult == null) searchResult = findErrorBehaviorEvent(ebsm, name);
								if (searchResult==null) searchResult = findErrorBehaviorState(ebsm, name);
								if (searchResult==null) searchResult = findErrorBehaviorTransition(ebsm, name);
							}
							if (compbehaviors != null){
								if (searchResult == null) searchResult = findErrorBehaviorEvent(compbehaviors, name);
								if (searchResult==null) searchResult = findErrorBehaviorState(compbehaviors, name);
								if (searchResult==null) searchResult = findErrorBehaviorTransition(compbehaviors, name);
								if (searchResult==null) searchResult = findErrorDetection(compbehaviors, name);
								if (searchResult==null) searchResult = findOutgoingErrorPropagationCondition(compbehaviors, name);
							}
							if (searchResult==null) {
								// look up subcomponent in classifier of previous subcomponent
								searchResult = ns.findNamedElement(name);
							}
						}
					} else {
						searchResult = findErrorType(ne, name);
						if (searchResult == null) searchResult = findTypeSet(ne, name);
						if (searchResult == null) searchResult = findObservableErrorPropagationPoint(ne, name);
						if (searchResult==null) searchResult = findErrorPropagationPoint(ne, name,null);
						if (searchResult==null) searchResult = findErrorFlow(ne, name);
						if (searchResult == null) searchResult = findErrorBehaviorEvent(ne, name);
						if (searchResult==null) searchResult = findErrorBehaviorState(ne, name);
						if (searchResult==null) searchResult = findErrorBehaviorTransition(ne, name);
						if (searchResult==null) searchResult = findErrorDetection(ne, name);
						if (searchResult==null) searchResult = findOutgoingErrorPropagationCondition(ne, name);
					}
				} else {
					// first element in path
					searchResult = findErrorType(context, name);
					if (searchResult == null) searchResult = findTypeSet(context, name);
					if (searchResult == null) searchResult = findObservableErrorPropagationPoint(context, name);
					if (searchResult==null) searchResult = findErrorPropagationPoint(context, name,null);
					if (searchResult==null) searchResult = findErrorFlow(context, name);
					if (searchResult == null) searchResult = findErrorBehaviorEvent(context, name);
					if (searchResult==null) searchResult = findErrorBehaviorState(context, name);
					if (searchResult==null) searchResult = findErrorBehaviorTransition(context, name);
					if (searchResult==null) searchResult = findErrorDetection(context, name);
					if (searchResult==null) searchResult = findOutgoingErrorPropagationCondition(context, name);
					if (searchResult==null) {
						// look up subcomponent
						// need to look up element relative to the previous one
						Classifier ns = ((ContainmentPathElement) context).getContainingClassifier();
						searchResult = ns.findNamedElement(name);
					}
				}
			} else if (context instanceof RecoverEvent){
				Classifier ns = AadlUtil.getContainingClassifier(context);
				searchResult = ns.findNamedElement(name);
			}
		} else if (ErrorModelPackage.eINSTANCE.getErrorType() == requiredType) {
			searchResult = findErrorType(context, name);

		} else if (ErrorModelPackage.eINSTANCE.getErrorModelLibrary() == requiredType) {
			// first look it up in global index
			EObject gobj = getIndexedObject(context, reference, name);
			if (gobj != null ){
				if( gobj.eClass() == requiredType){
					return Collections.singletonList(gobj);
				} else {
					System.out.println("Global lookup of type did not match "+name);
				}
			}
			searchResult = findErrorModelLibrary(context, name);

		} else if (ErrorModelPackage.eINSTANCE.getErrorBehaviorStateOrTypeSet() == requiredType) {
			searchResult = findErrorBehaviorState(context, name);
			if (searchResult == null) searchResult = findTypeSet(context, name);

		} else if (ErrorModelPackage.eINSTANCE.getTypeSet() == requiredType) {
			searchResult = findTypeSet(context, name);

		} else if (ErrorModelPackage.eINSTANCE.getErrorTypes() == requiredType) {
			searchResult = findErrorTypes(context, name);

		} else if (ErrorModelPackage.eINSTANCE.getErrorPropagation() == requiredType) {
			if (reference.getName().equalsIgnoreCase("outgoing")){
				searchResult = findErrorPropagationPoint(context, name,DirectionType.OUT);
			} else if (reference.getName().equalsIgnoreCase("incoming")){
				searchResult = findErrorPropagationPoint(context, name,DirectionType.IN);
			} else {
			searchResult = findErrorPropagationPoint(context, name,null);
			}

		} else if (ErrorModelPackage.eINSTANCE.getTypeMappingSet() == requiredType) {
			searchResult = findTypeMappingSet(context, name);

		} else if (ErrorModelPackage.eINSTANCE.getTypeTransformationSet() == requiredType) {
			searchResult = findTypeTransformationSet(context, name);
		} else if (ErrorModelPackage.eINSTANCE.getErrorBehaviorStateMachine() == requiredType) {
			searchResult = findErrorBehaviorStateMachine(context, name);

		} else if (ErrorModelPackage.eINSTANCE.getErrorBehaviorState() == requiredType) {
			searchResult = findErrorBehaviorState(context, name);

		} else if (ErrorModelPackage.eINSTANCE.getEventOrPropagation() == requiredType) {
			searchResult = findErrorPropagationPoint(context, name,DirectionType.IN);
			if (searchResult == null ){
				if (context instanceof ConditionExpression 
						&& (EM2Util.getConditionExpressionContext((ConditionExpression)context) instanceof ErrorDetection
						|| EM2Util.getConditionExpressionContext((ConditionExpression)context) instanceof ErrorBehaviorTransition)){
					// find it only for transitions
					searchResult = findErrorBehaviorEvent(context, name);
				}
			}

		} else if (ErrorModelPackage.eINSTANCE.getErrorBehaviorEvent() == requiredType) {
			searchResult = findErrorBehaviorEvent(context, name);

		} else if (ErrorModelPackage.eINSTANCE.getErrorBehaviorTransition() == requiredType) {
			searchResult = findErrorBehaviorTransition(context, name);

		} else if (ErrorModelPackage.eINSTANCE.getErrorFlow() == requiredType) {
			searchResult = findErrorFlow(context, name);
			
		} else if (Aadl2Package.eINSTANCE.getSubcomponent()==requiredType) {
//		} else if (Aadl2Package.eINSTANCE.getSubcomponent().isSuperTypeOf(requiredType)) {
			if (context instanceof SubcomponentElement){
				ConditionElement ce = (ConditionElement)context.eContainer();
				EList<SubcomponentElement> sublist = ce.getSubcomponents();
				int idx = sublist.indexOf(context);
			Classifier ns = AadlUtil.getContainingClassifier(context);
			if (idx > 0) {
				SubcomponentElement se = sublist.get(idx-1);
				Subcomponent subcomponent = se.getSubcomponent();
				ns = subcomponent.getAllClassifier();
			}
			EObject res = ns.findNamedElement(name);
			if (res instanceof Subcomponent) {
				searchResult = res;
			}
			}
		}
		if (searchResult != null) {
			return Collections.singletonList(searchResult);
		}
		return Collections.<EObject> emptyList();
	}
	
	
	/**
	 * find the error model library. The String name refers to the package and the default EML name is added ("emv2")
	 * @param context context of search to identify package and EML
	 * @param name
	 * @return
	 */
	public ErrorModelLibrary findErrorModelLibrary(EObject context, String name){

		ErrorModelLibrary eml = (ErrorModelLibrary) EMFIndexRetrieval.getEObjectOfType(context, ErrorModelPackage.eINSTANCE.getErrorModelLibrary(), name+"::"+"emv2");
		if (eml != null) return eml;
		AadlPackage ap = findAadlPackageReference(name, AadlUtil.getContainingPackageSection(context));
		if (ap == null)
			return null;
		PackageSection ps = ap.getOwnedPublicSection();
		EList<AnnexLibrary>all=ps.getOwnedAnnexLibraries();
		for (AnnexLibrary al : all){
			if (al instanceof ErrorModelLibrary){
				return (ErrorModelLibrary)al;
			}
		}
		return null;
	}
	
	
	
	public TypeMappingSet findTypeMappingSet(EObject context, String name){
		ErrorModelLibrary eml = findErrorModelLibrary(context, EM2Util.getPackageName(name));
		if (eml != null){
			EList<TypeMappingSet> tmsl= eml.getMappings();
			for (TypeMappingSet tms : tmsl){
				if (EM2Util.getItemName(name).equalsIgnoreCase(tms.getName())) return tms;
			}
		}
		return null;
	}
	
	public TypeTransformationSet findTypeTransformationSet(EObject context, String name){
		ErrorModelLibrary eml = findErrorModelLibrary(context, EM2Util.getPackageName(name));
		if (eml != null){
			EList<TypeTransformationSet> tmsl= eml.getTransformations();
			for (TypeTransformationSet tms : tmsl){
				if (EM2Util.getItemName(name).equalsIgnoreCase(tms.getName())) return tms;
			}
		}
		return null;
	}
	
	public ErrorBehaviorStateMachine findErrorBehaviorStateMachine(EObject context, String name){
		ErrorModelLibrary eml = findErrorModelLibrary(context, EM2Util.getPackageName(name));
		if (eml != null){
			EList<ErrorBehaviorStateMachine> ebsml= eml.getBehaviors();
			for (ErrorBehaviorStateMachine ebsm : ebsml){
				if (EM2Util.getItemName(name).equalsIgnoreCase(ebsm.getName())) return ebsm;
			}
		}
		return null;
	}

	
	public ErrorBehaviorState findErrorBehaviorState(EObject context, String name){
		ErrorBehaviorStateMachine ebsm = null;
		if (context instanceof ConditionElement && !((ConditionElement)context).getSubcomponents().isEmpty()){
			// look up state in state machine of subcomponent
			ConditionElement tcs = (ConditionElement)context;
			 EList<SubcomponentElement> sublist = tcs.getSubcomponents();
			Subcomponent sub = sublist.get(sublist.size()-1).getSubcomponent();
			ComponentClassifier sc = sub.getAllClassifier();
			if (sc == null) return null;
			ErrorModelSubclause ems = EM2Util.getErrorModelSubclause(sc);
			if (ems == null) return null;
			ebsm = ems.getUseBehavior();
		} else {
			// resolve in local context
			ebsm = EM2Util.getContainingErrorBehaviorStateMachine(context);
			if (ebsm == null) ebsm = EM2Util.getUsedErrorBehaviorStateMachine(context);
		}
		return findErrorBehaviorStateInEBSM(ebsm, name);
	}
	
	public ErrorBehaviorState findErrorBehaviorStateInEBSM(ErrorBehaviorStateMachine ebsm, String name){
		if (ebsm != null){
			EList<ErrorBehaviorState> ebsl= ebsm.getStates();
			for (ErrorBehaviorState ebs : ebsl){
				if (EM2Util.getItemName(name).equalsIgnoreCase(ebs.getName())) return ebs;
			}
			if (ebsm.getExtends() != null){
				return findErrorBehaviorStateInEBSM(ebsm.getExtends(), name);
			}
		}
		return null;
	}
	
	public ErrorBehaviorTransition findErrorBehaviorTransition(EObject context, String name){
		// check in component error behavior clause first
		ComponentErrorBehavior compbehavior = EM2Util.getContainingComponentErrorBehavior(context);
		if (compbehavior != null){
			ErrorBehaviorTransition ebt = findErrorBehaviorTransitionInCEB(compbehavior, name);
			if (ebt != null) return ebt;
		}
		ErrorBehaviorStateMachine ebsm = EM2Util.getContainingErrorBehaviorStateMachine(context);
		if (ebsm == null) ebsm = EM2Util.getUsedErrorBehaviorStateMachine(context);
		if (ebsm != null){
			return findErrorBehaviorTransitionInEBSM(ebsm,name);
		}
		return null;
	}
	
	public ErrorBehaviorTransition findErrorBehaviorTransitionInCEB(ComponentErrorBehavior ceb, String name){
		if (ceb != null){
			EList<ErrorBehaviorTransition> ebsl= ceb.getTransitions();
			for (ErrorBehaviorTransition ebs : ebsl){
				if (EM2Util.getItemName(name).equalsIgnoreCase(ebs.getName())) return ebs;
			}
			ComponentErrorBehavior extceb = getExtendsComponentErrorBehavior(ceb);
			if (extceb != null){
				return findErrorBehaviorTransitionInCEB(extceb, name);
			}
		}
		return null;
	}
	
	public ComponentErrorBehavior getExtendsComponentErrorBehavior(ComponentErrorBehavior ceb){
		Classifier extcl = AadlUtil.getContainingClassifier(ceb).getExtended();
		return Aadl2Util.isNull(extcl)?null:EM2Util.getComponentErrorBehavior(AadlUtil.getContainingClassifier(ceb));
	}
	
	public ErrorBehaviorTransition findErrorBehaviorTransitionInEBSM(ErrorBehaviorStateMachine ebsm, String name){
		if (ebsm != null){
			EList<ErrorBehaviorTransition> ebsl= ebsm.getTransitions();
			for (ErrorBehaviorTransition ebs : ebsl){
				if (EM2Util.getItemName(name).equalsIgnoreCase(ebs.getName())) return ebs;
			}
			if (ebsm.getExtends() != null){
				return findErrorBehaviorTransitionInEBSM(ebsm.getExtends(), name);
			}
		}
		return null;
	}
	
	public ErrorDetection findErrorDetection(EObject context, String name){
		ComponentErrorBehavior compbehavior = EM2Util.getContainingComponentErrorBehavior(context);
		if (compbehavior != null){
			EList<ErrorDetection> ebsl= compbehavior.getErrorDetections();
			for (ErrorDetection ebs : ebsl){
				if (EM2Util.getItemName(name).equalsIgnoreCase(ebs.getName())) return ebs;
			}
			ComponentErrorBehavior extceb = getExtendsComponentErrorBehavior(compbehavior);
			if (extceb != null){
				return findErrorDetection(extceb, name);
			}
		}
		return null;
	}
	
	public OutgoingPropagationCondition findOutgoingErrorPropagationCondition(EObject context, String name){
		ComponentErrorBehavior compbehavior = EM2Util.getContainingComponentErrorBehavior(context);
		if (compbehavior != null){
			EList<OutgoingPropagationCondition> ebsl= compbehavior.getOutgoingPropagationConditions();
			for (OutgoingPropagationCondition ebs : ebsl){
				if (EM2Util.getItemName(name).equalsIgnoreCase(ebs.getName())) return ebs;
			}
			ComponentErrorBehavior extceb = getExtendsComponentErrorBehavior(compbehavior);
			if (extceb != null){
				return findOutgoingErrorPropagationCondition(extceb, name);
			}
		}
		return null;
	}
	
	public ErrorBehaviorEvent findErrorBehaviorEvent(EObject context, String name){
		// this is code to find the error event in the subclause event declaration itself
		ComponentErrorBehavior ceb = EM2Util.getContainingSubclauseComponentErrorBehavior(context);
		if (ceb != null){
			ErrorBehaviorEvent eve = findErrorBehaviorEventinCEB(ceb, name);
			if (eve != null) return eve;
		}
		ErrorBehaviorStateMachine ebsm = EM2Util.getContainingErrorBehaviorStateMachine(context);
		if (ebsm == null) ebsm = EM2Util.getUsedErrorBehaviorStateMachine(context);
		if (ebsm != null){
			return findErrorBehaviorEventInEBSM(ebsm,name);
		}
		return null;
	}
	
	public ErrorBehaviorEvent findErrorBehaviorEventinCEB(ComponentErrorBehavior ceb, String name){
		// this is code to find the error event in the subclause event declaration itself
		if (ceb != null){
			EList<ErrorBehaviorEvent> events = ceb.getEvents();
			if (!events.isEmpty()){
				for (ErrorBehaviorEvent errorEvent : events) {
					if (EM2Util.getItemName(name).equalsIgnoreCase(errorEvent.getName())) return errorEvent;
				}
			}
			ComponentErrorBehavior extceb = getExtendsComponentErrorBehavior(ceb);
			if (extceb != null){
				return findErrorBehaviorEventinCEB(extceb, name);
			}
		}
		return null;
	}
	
	
	public ErrorBehaviorEvent findErrorBehaviorEventInEBSM(ErrorBehaviorStateMachine ebsm, String name){
		if (ebsm != null){
			EList<ErrorBehaviorEvent> ebsl= ebsm.getEvents();
			for (ErrorBehaviorEvent ebs : ebsl){
				if (EM2Util.getItemName(name).equalsIgnoreCase(ebs.getName())) return ebs;
			}
			if (ebsm.getExtends() != null){
				return findErrorBehaviorEventInEBSM(ebsm.getExtends(), name);
			}
		}
		return null;
	}


	public ErrorType findErrorType(EObject context, String typeName){
		return (ErrorType)findEMLNamedTypeElement(context, typeName, ErrorModelPackage.eINSTANCE.getErrorType());
	}
	
	public TypeSet findTypeSet(EObject context, String typeName){
		return (TypeSet)findEMLNamedTypeElement(context, typeName, ErrorModelPackage.eINSTANCE.getTypeSet());
	}
	
	public ErrorTypes findErrorTypes(EObject context, String typeName){
		return (ErrorTypes)findEMLNamedTypeElement(context, typeName, ErrorModelPackage.eINSTANCE.getErrorTypes());
	}
	
	
	public EObject findEMLNamedTypeElement(EObject context, String qualTypeName, EClass eclass){
		String packName = EM2Util.getPackageName(qualTypeName);
		String typeName = EM2Util.getItemName(qualTypeName);
		if (packName != null){
			// qualified reference; look there only
			ErrorModelLibrary eml = findErrorModelLibrary(context, packName);
			// PHF: change to findNamedElementInThisEML if we do not make inherited names externally visible
			return findEMLNamedTypeElement(eml, typeName, eclass);
		}
		ErrorModelLibrary owneml = EM2Util.getContainingErrorModelLibrary(context);
		TypeUseContext tuns = EM2Util.getContainingTypeUseContext(context);
		List<ErrorModelLibrary> otheremls = Collections.EMPTY_LIST;
		if (tuns != null) {
			// we are in a transformation set, mapping set etc.
			otheremls = EM2Util.getUseTypes(tuns);
		} else 		if (owneml != null){
			// lookup in own EML if we are inside an ErrorModelLibrary
			EObject res = findNamedTypeElementInThisEML(owneml, typeName, eclass);
			if (res != null) return res;
			otheremls = owneml.getExtends();
		}
		for (ErrorModelLibrary etll: otheremls){
			// PHF: change to findNamedElementInThisEML if we do not make inherited names externally visible
			EObject res = findEMLNamedTypeElement(etll, typeName, eclass);
			if (res != null) {
				return res;
			}
		}
		return null;
	}
	
	public EObject findNamedTypeElementInThisEML(ErrorModelLibrary eml, String typeName, EClass eclass){
		if (eml == null) return null;
		EList<ErrorTypes> elt = eml.getTypes();
		for (ErrorTypes ets : elt){
			if (eclass.isSuperTypeOf(ets.eClass()) && typeName.equalsIgnoreCase(ets.getName())) return ets;
		}
		return null;
	}
	
	
	public ErrorPropagation findErrorPropagationPoint(EObject context, String name, DirectionType dir){
		ErrorPropagations eps =null;
		if (context instanceof QualifiedObservableErrorPropagationPoint){
			Subcomponent sub = ((QualifiedObservableErrorPropagationPoint)context).getSubcomponent();
			eps =  EM2Util.getContainingClassifierErrorPropagations(sub.getAllClassifier());
		} else {
			eps =  EM2Util.getContainingClassifierErrorPropagations(context);
		}
		if (eps != null){
			for (ErrorPropagation ep : eps.getPropagations()){
				if (!ep.isNot()){
					if (!(context instanceof QualifiedObservableErrorPropagationPoint)){
						Feature f = ep.getFeature();
						if (!Aadl2Util.isNull(f) && f.getName().equalsIgnoreCase(name)&&
								(dir == null||dir.equals(ep.getDirection()))) return ep;
						String kind = ep.getKind();
						if (kind != null && kind.equalsIgnoreCase(name)&&
								(dir == null||dir.equals(ep.getDirection()))) return ep;
					}
					String observe = ep.getName();
					if (ep.isObservable() && observe != null &&  observe.equalsIgnoreCase(name)&&
							(dir == null||dir.equals(ep.getDirection()))) return ep;
				}
			}
			ErrorPropagations exteps = getExtendsErrorPropagations(eps);
			if (exteps != null) return findErrorPropagationPoint(exteps,name,dir);
		}
		return null;
	}
	
	
	public ErrorPropagations getExtendsErrorPropagations(ErrorPropagations ep){
		Classifier extcl = AadlUtil.getContainingClassifier(ep).getExtended();
		return Aadl2Util.isNull(extcl)?null:EM2Util.getErrorPropagations(AadlUtil.getContainingClassifier(ep));
	}
	
	public ErrorPropagation findObservableErrorPropagationPoint(EObject context, String name){
		ErrorPropagations eps =  EM2Util.getContainingClassifierErrorPropagations(context);
		if (eps != null){
			for (ErrorPropagation ep : eps.getPropagations()){
				if (ep.isObservable()){
					if (name.equalsIgnoreCase(ep.getName())) return ep;
				}
			}
			ErrorPropagations exteps = getExtendsErrorPropagations(eps);
			if (exteps != null) return findObservableErrorPropagationPoint(exteps,name);
		}
		return null;
	}
	
	public ErrorFlow findErrorFlow(EObject context, String name){
		ErrorPropagations eps =  EM2Util.getContainingClassifierErrorPropagations(context);
		if (eps != null){
			for (ErrorFlow ef : eps.getFlows()){
				if (name.equalsIgnoreCase(ef.getName())) return ef;
			}
		}
		ErrorPropagations exteps = getExtendsErrorPropagations(eps);
		if (exteps != null) return findErrorFlow(exteps,name);
		return null;
	}

	

}
