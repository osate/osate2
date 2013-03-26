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
import org.osate.aadl2.Element;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
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
import org.osate.xtext.aadl2.errormodel.errorModel.FeatureReference;
import org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition;
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedObservableErrorPropagationPoint;
import org.osate.xtext.aadl2.errormodel.errorModel.RecoverEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.SubcomponentElement;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeMappingSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeTransformationSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeUseContext;
import org.osate.xtext.aadl2.errormodel.errorModel.impl.SubcomponentElementImpl;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;
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
		Element cxt = (Element) context;
		final String name = getCrossRefNodeAsString(node);
		if (Aadl2Package.eINSTANCE.getNamedElement() == requiredType) {
			// containment path element
			if (context instanceof ContainmentPathElement) {
				ContainedNamedElement path = (ContainedNamedElement) context.eContainer();
				EList<ContainmentPathElement> list = path
						.getContainmentPathElements();
				int idx = list.indexOf(context);
				Element cxtElement = ((ContainmentPathElement) context).getContainingClassifier();
				if (idx > 0) {
					// find next element in namespace of previous element
					ContainmentPathElement el = list.get(idx - 1);
					NamedElement ne = el.getNamedElement();
					if (ne instanceof Subcomponent) {
						cxtElement = ((Subcomponent) ne).getClassifier();
					} else
						if (ne instanceof FeatureGroup) {
							cxtElement = ((FeatureGroup) ne).getClassifier();
					} else {
						cxtElement = ne;
					}
				}
				// find annex subclause as context for error model identifier lookup
				if (!Aadl2Util.isNull(cxtElement)){
					searchResult = findErrorType(cxtElement, name);
					if (searchResult != null) return Collections.singletonList(searchResult);
					searchResult = findTypeSet(cxtElement, name);
					if (searchResult != null) return Collections.singletonList(searchResult);
					searchResult = EMV2Util.findErrorPropagationPoint(cxtElement, name,null,false);
					if (searchResult != null) return Collections.singletonList(searchResult);
					searchResult = EMV2Util.findErrorFlow(cxtElement, name);
					if (searchResult != null) return Collections.singletonList(searchResult);
					searchResult = EMV2Util.findErrorBehaviorEvent(cxtElement, name);
					if (searchResult != null) return Collections.singletonList(searchResult);
					searchResult = EMV2Util.findErrorBehaviorState(cxtElement, name);
					if (searchResult != null) return Collections.singletonList(searchResult);
					searchResult = EMV2Util.findErrorBehaviorTransition(cxtElement, name);
					if (searchResult != null) return Collections.singletonList(searchResult);
					searchResult = EMV2Util.findErrorDetection(cxtElement, name);
					if (searchResult != null) return Collections.singletonList(searchResult);
					searchResult = EMV2Util.findOutgoingPropagationCondition(cxtElement, name);
					if (searchResult != null) return Collections.singletonList(searchResult);
					// look up subcomponent in classifier of previous subcomponent, or feature group
					if (cxtElement instanceof Classifier) {
						NamedElement finding = ((Classifier)cxtElement).findNamedElement(name);
						if (finding instanceof Subcomponent || finding instanceof FeatureGroup) searchResult = finding;
					}
					if (searchResult != null) return Collections.singletonList(searchResult);
				}
			} else if (context instanceof RecoverEvent){
				Classifier ns = AadlUtil.getContainingClassifier(context);
				searchResult = ns.findNamedElement(name);
			}
		} else if (Aadl2Package.eINSTANCE.getFeature() == requiredType) {
			if (context instanceof FeatureReference){
				Classifier cl = AadlUtil.getContainingClassifier(context);
				NamedElement ne = cl.findNamedElement(name);
				if (ne instanceof Feature)searchResult = ne; 
			}
		} else if (ErrorModelPackage.eINSTANCE.getErrorType() == requiredType) {
			searchResult = findErrorType(cxt, name);

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
			searchResult = EMV2Util.findErrorBehaviorState(cxt, name);
			if (searchResult == null) searchResult = findTypeSet(cxt, name);

		} else if (ErrorModelPackage.eINSTANCE.getTypeSet() == requiredType) {
			searchResult = findTypeSet(cxt, name);

		} else if (ErrorModelPackage.eINSTANCE.getErrorTypes() == requiredType) {
			searchResult = findErrorTypes(cxt, name);

		} else if (ErrorModelPackage.eINSTANCE.getErrorPropagation() == requiredType) {
			if (reference.getName().equalsIgnoreCase("outgoing")){
				searchResult = EMV2Util.findErrorPropagationPoint(cxt, name,DirectionType.OUT,false);
			} else if (reference.getName().equalsIgnoreCase("incoming")){
				searchResult = EMV2Util.findErrorPropagationPoint(cxt, name,DirectionType.IN,false);
			} else {
				searchResult = EMV2Util.findErrorPropagationPoint(cxt, name,null,false);
			}

		} else if (ErrorModelPackage.eINSTANCE.getTypeMappingSet() == requiredType) {
			searchResult = findTypeMappingSet(context, name);

		} else if (ErrorModelPackage.eINSTANCE.getTypeTransformationSet() == requiredType) {
			searchResult = findTypeTransformationSet(context, name);
		} else if (ErrorModelPackage.eINSTANCE.getErrorBehaviorStateMachine() == requiredType) {
			searchResult = findErrorBehaviorStateMachine(context, name);

		} else if (ErrorModelPackage.eINSTANCE.getErrorBehaviorState() == requiredType) {
			searchResult = EMV2Util.findErrorBehaviorState((Element)context, name);

		} else if (ErrorModelPackage.eINSTANCE.getEventOrPropagation() == requiredType) {
			searchResult = EMV2Util.findErrorPropagationPoint(cxt, name,DirectionType.IN,false);
			if (searchResult == null ){
				if (context instanceof ConditionExpression 
						&& (EMV2Util.getConditionExpressionContext((ConditionExpression)context) instanceof ErrorDetection
						|| EMV2Util.getConditionExpressionContext((ConditionExpression)context) instanceof ErrorBehaviorTransition)){
					// find it only for transitions
					searchResult = EMV2Util.findErrorBehaviorEvent(cxt, name);
				}
			}

		} else if (ErrorModelPackage.eINSTANCE.getErrorBehaviorEvent() == requiredType) {
			searchResult = EMV2Util.findErrorBehaviorEvent(cxt, name);

		} else if (ErrorModelPackage.eINSTANCE.getErrorBehaviorTransition() == requiredType) {
			searchResult = EMV2Util.findErrorBehaviorTransition(cxt, name);

		} else if (ErrorModelPackage.eINSTANCE.getErrorFlow() == requiredType) {
			searchResult = EMV2Util.findErrorFlow(cxt.getContainingClassifier(), name);
			
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
	
	
	public  TypeMappingSet findTypeMappingSet(EObject context, String name){
		ErrorModelLibrary eml = findErrorModelLibrary(context, EMV2Util.getPackageName(name));
		if (eml != null){
			EList<TypeMappingSet> tmsl= eml.getMappings();
			for (TypeMappingSet tms : tmsl){
				if (EMV2Util.getItemName(name).equalsIgnoreCase(tms.getName())) return tms;
			}
		}
		return null;
	}
	
	public  TypeTransformationSet findTypeTransformationSet(EObject context, String name){
		ErrorModelLibrary eml = findErrorModelLibrary(context, EMV2Util.getPackageName(name));
		if (eml != null){
			EList<TypeTransformationSet> tmsl= eml.getTransformations();
			for (TypeTransformationSet tms : tmsl){
				if (EMV2Util.getItemName(name).equalsIgnoreCase(tms.getName())) return tms;
			}
		}
		return null;
	}
	
	public  ErrorBehaviorStateMachine findErrorBehaviorStateMachine(EObject context, String name){
		ErrorModelLibrary eml = findErrorModelLibrary(context, EMV2Util.getPackageName(name));
		if (eml != null){
			EList<ErrorBehaviorStateMachine> ebsml= eml.getBehaviors();
			for (ErrorBehaviorStateMachine ebsm : ebsml){
				if (EMV2Util.getItemName(name).equalsIgnoreCase(ebsm.getName())) return ebsm;
			}
		}
		return null;
	}

	

	public ErrorType findErrorType(Element context, String typeName){
		return (ErrorType)findEMLNamedTypeElement(context, typeName, ErrorModelPackage.eINSTANCE.getErrorType());
	}
	
	public TypeSet findTypeSet(Element context, String typeName){
		return (TypeSet)findEMLNamedTypeElement(context, typeName, ErrorModelPackage.eINSTANCE.getTypeSet());
	}
	
	public ErrorTypes findErrorTypes(Element context, String typeName){
		return (ErrorTypes)findEMLNamedTypeElement(context, typeName, ErrorModelPackage.eINSTANCE.getErrorTypes());
	}
	
	
	public EObject findEMLNamedTypeElement(Element context, String qualTypeName, EClass eclass){
		String packName = EMV2Util.getPackageName(qualTypeName);
		String typeName = EMV2Util.getItemName(qualTypeName);
		if (packName != null){
			// qualified reference; look there only
			ErrorModelLibrary eml = findErrorModelLibrary(context, packName);
			// PHF: change to findNamedElementInThisEML if we do not make inherited names externally visible
			return findEMLNamedTypeElement(eml, typeName, eclass);
		}
		ErrorModelLibrary owneml = EMV2Util.getContainingErrorModelLibrary(context);
		TypeUseContext tuns = EMV2Util.getContainingTypeUseContext(context);
		List<ErrorModelLibrary> otheremls = Collections.EMPTY_LIST;
		if (tuns != null) {
			// we are in a transformation set, mapping set etc.
			otheremls = EMV2Util.getUseTypes(tuns);
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
	

}
