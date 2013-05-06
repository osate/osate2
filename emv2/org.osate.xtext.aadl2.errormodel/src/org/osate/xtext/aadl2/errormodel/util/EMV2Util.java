package org.osate.xtext.aadl2.errormodel.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Element;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.Feature;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.modelsupport.modeltraversal.ForAllElement;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.xtext.aadl2.errormodel.errorModel.ComponentErrorBehavior;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.EBSMUseContext;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorFlow;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagations;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSink;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;
import org.osate.xtext.aadl2.errormodel.errorModel.FeatureReference;
import org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPaths;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPoint;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPointConnection;
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedPropagationPoint;
import org.osate.xtext.aadl2.errormodel.errorModel.SubcomponentElement;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeMappingSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeTransformationSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeUseContext;

public class EMV2Util {
	
	public final static String ErrorModelAnnexName = "EMV2";
	private static EClass EMV2subclauseEClass = Aadl2Package.eINSTANCE.getAnnexSubclause();
	public static final String INVALID_OCCURRENCE_TYPE = "unknown_distribution";
	/**
	 * Get the error-annex subclause for a given Component Instance
	 * @param ci	The component instance that contains the error model subclause
	 * @return EList<AnnexSubclause> list of ErrorModelSubclause objects
	 */
	public static EList<AnnexSubclause> getErrorAnnexSubclauses (ComponentInstance ci)
	{
		return ci.getComponentClassifier().getAllAnnexSubclauses(EMV2subclauseEClass);
	}
	
	public static ContainedNamedElement getHazardProperty(ComponentInstance ci, Element localContext,Element target, TypeSet ts){
		ContainedNamedElement result =  EMV2Util.getProperty("EMV2::hazard",ci,localContext,target,ts);
		return result;
	}
	/**
	 * Retrieve the value of the OccurenceDistribution property of the
	 * EMV2 property. You can use it like this:
	 * 	ContainedNamedElement PA = EM2Util.getOccurenceDistributionProperty(instance,null,ee,null);
     * res = EM2Util.getOccurenceValue (PA);
     * 
     * @see		Util
	 * @param 	ci				ComponentInstance object that contains the property
	 * @param localContext		the context or null
	 * @param target			the property
	 * @param ts				corresponding typeset or null
	 * @return
	 */
	public static ContainedNamedElement getOccurenceDistributionProperty(ComponentInstance ci, NamedElement localContext,NamedElement target, TypeSet ts){
		ContainedNamedElement result =  EMV2Util.getProperty("EMV2::OccurrenceDistribution",ci,localContext,target,ts);
		return result;
	}
	
	/**
	 * Retrieve the value associated with a containment path
	 * See RDB action to see how it is used.
	 *
	 * @param PAContainmentPath value get from getOccurenceDistributionProperty
	 */
	public static double getOccurenceValue (final ContainedNamedElement PAContainmentPath)
	{
		double result;
		
		result = 0;
		
		if (PAContainmentPath == null)
		{
			return 0;
		}
		
		for (ModalPropertyValue modalPropertyValue : AadlUtil.getContainingPropertyAssociation(PAContainmentPath).getOwnedValues()) {
			PropertyExpression val = modalPropertyValue.getOwnedValue();
			if (val instanceof RecordValue){
	
				RecordValue rv = (RecordValue)val;
				EList<BasicPropertyAssociation> fields = rv.getOwnedFieldValues();
				// for all error types/aliases in type set or the element identified in the containment clause 
				for (BasicPropertyAssociation bpa : fields)
				{
					if (bpa.getProperty().getName().equalsIgnoreCase("probabilityvalue"))
					{
						if (bpa.getValue() instanceof RealLiteral)
						{
							RealLiteral rl = (RealLiteral)bpa.getValue();
							result = rl.getScaledValue();
						}
					}
				}
			}
		}
		return result;
	}
	
	
	/**
	 * Retrieve the type/kind of distribution associated
	 * with the Occurrence property
	 * See PRISM converter to see how it is used.
	 *
	 * @param PAContainmentPath string value describing the distribution get from getOccurenceDistributionProperty
	 */
	public static String getOccurenceType (final ContainedNamedElement PAContainmentPath)
	{
		if (PAContainmentPath == null)
		{
			return "unknown_distribution";
		}
		
		for (ModalPropertyValue modalPropertyValue : AadlUtil.getContainingPropertyAssociation(PAContainmentPath).getOwnedValues()) {
			PropertyExpression val = modalPropertyValue.getOwnedValue();
			if (val instanceof RecordValue){
	
				RecordValue rv = (RecordValue)val;
				EList<BasicPropertyAssociation> fields = rv.getOwnedFieldValues();
				// for all error types/aliases in type set or the element identified in the containment clause 
				for (BasicPropertyAssociation bpa : fields)
				{
					if (bpa.getProperty().getName().equalsIgnoreCase("distribution"))
					{
						if (bpa.getValue() instanceof NamedValue)
						{
							EnumerationLiteral el = (EnumerationLiteral)((NamedValue)bpa.getValue()).getNamedValue();
							return (el.getName().toLowerCase());
							
							//RealLiteral rl = (NamedValue)bpa.getValue();
							//result = rl.getScaledValue();
						}
					}
				}
			}
		}
		return "unknown_distribution";
	}
	
	
	
	/**
	 * get ErrorModelSubclause object that contains the element object.
	 * @param element error annex element
	 * @return ErrorModelSubclause
	 */
	public static ErrorModelSubclause getContainingErrorModelSubclause(Element element) {
		EObject container = element;
		while (container != null && !(container instanceof ErrorModelSubclause))
			container = container.eContainer();
		return (ErrorModelSubclause) container;
	}

	/**
	 * get error propagations object that contains the element object.
	 * @param element  error annex element
	 * @return ErrorPropagations
	 */
	public static ErrorPropagations getContainingErrorPropagations(Element element) {
		EObject container = element;
		while (container != null && !(container instanceof ErrorPropagations))
			container = container.eContainer();
		return (ErrorPropagations) container;
	}

	

	/**
	 * get enclosing object within the error annex that has a properties section..
	 * ErrorModelLibrary, ErrorBehaviorStateMachine, and ErrorModelSubclause have properties sections
	 * @param element declarative model element or error annex element
	 * @return ErrorModelLibrary, ErrorBehaviorStateMachine, ErrorModelSubclause
	 */
	public static EList<PropertyAssociation> getContainingPropertiesHolder(Element element) {
		EObject container = element;
		while (container != null ){
			if (container instanceof ErrorModelSubclause ){
				return ((ErrorModelSubclause)container).getProperties();
			}
			if (container instanceof ErrorModelLibrary ){
				return ((ErrorModelLibrary)container).getProperties();
			}
			if (container instanceof ErrorBehaviorStateMachine ){
				return ((ErrorBehaviorStateMachine)container).getProperties();
			}
			container = container.eContainer();
		}
		return null;
	}


	/**
	 * get ErrorModelSubclause object in the classifier 
	 * @param cl classifier
	 * @return ErrorModelSubclause
	 */
	private static void getClassifierEMV2Subclause(Classifier cl,EList<ErrorModelSubclause> result) {
		ErrorModelSubclause ems = getOwnEMV2Subclause(cl);
		if (ems != null) result.add(ems);
	}

	/**
	 * recursively add all EMV2 subclauses of classifier and its extends ancestors
	 * in case of implementations do not follow to the type
	 * cl can be null or an unresolved proxy.
	 * if cl has a subclause its subclause is added before following the extends hierarhy
	 * @param cl Component Implementation
	 * @param result list of EMV2 subclauses
	 */
	private static void getAllClassifierEMV2Subclause(Classifier cl,EList<ErrorModelSubclause> result) {
		if (!Aadl2Util.isNull(cl)){
			getClassifierEMV2Subclause(cl, result);
			getAllClassifierEMV2Subclause(cl.getExtended(),result);
		}
	}

	/**
	 * return the list of EMV2 subclauses of the classifier and 
	 * The extends hierarchy and the type in the case of an implementation are searched for the ErrorModelSubcany of its extends ancestors
	 * @param element declarative model element or error annex element
	 * @return ErrorModelSubclause
	 */
	public static EList<ErrorModelSubclause> getAllContainingClassifierEMV2Subclauses(Element element) {
		EList<ErrorModelSubclause> result = new BasicEList<ErrorModelSubclause>();
		Classifier cl = element.getContainingClassifier();
		if (cl instanceof ComponentImplementation){
			getAllClassifierEMV2Subclause(cl, result);
			getAllClassifierEMV2Subclause(((ComponentImplementation)cl).getType(),result);
		} else {
			getAllClassifierEMV2Subclause(cl, result);
		}
		return result;
	}


	/**
	 * get the error model subclause for the specified classifier.
     * Does not look in the extends hierarchy
	 * @param cl CLassifier
	 * @return
	 */
	public static ErrorModelSubclause getOwnEMV2Subclause(Classifier cl){
		if (cl == null) return null;
		EList<AnnexSubclause> asl = cl.getOwnedAnnexSubclauses();
		for (AnnexSubclause al : asl){
			if (al instanceof ErrorModelSubclause){
				return ((ErrorModelSubclause)al);
			}
		}
		return null;
	}

	/**
	 * get the error model subclause for the specified classifier.
	 * It effectively returns the first subclause that applies to the classifier.
	 * This is the subclause that determines the EBSM to be used (specified in use behavior).
	 * The mthods goes up the extends hierarchy, and in the case of an implementation
	 * tries its type and the type's hierarchy.
	 * 
	 * @param cl Classifier
	 * @return
	 */
	public static ErrorModelSubclause getClassifierEMV2Subclause(Classifier cl){
		if (cl == null) return null;
		ErrorModelSubclause ems = getOwnEMV2Subclause(cl);
		if (ems != null) return ems;
		if (cl instanceof ComponentImplementation){
			ems = getExtendsEMV2Subclause((ComponentImplementation)cl);
			if (ems != null) return ems;
			ems = getExtendsEMV2Subclause(((ComponentImplementation)cl).getType());
			if (ems != null) return ems;
		} else {
			ems = getExtendsEMV2Subclause(cl);
			if (ems != null) return ems;
		}
		return null;
	}
	
	/**
	 * find the first subclause on the classifier or its extends hierachy.
	 * When used on a component implementation this method does not go from an implemetnation to a type.
	 * 
	 * @param cl
	 * @return
	 */
	public static ErrorModelSubclause getExtendsEMV2Subclause(Classifier cl){
		if (cl == null) return null;
		ErrorModelSubclause ems = getOwnEMV2Subclause(cl);
		if (ems != null) return ems;
		if (!Aadl2Util.isNull(cl.getExtended())){
			ems= getExtendsEMV2Subclause(cl.getExtended());
			if (ems != null) return ems;
		}
		return null;
	}
	
	
	/**
	 * find propagation point including those inherited from classifiers being extended
	 * @param element context
	 * @param name String
	 * @return PropagationPoint propagation point
	 */
	public static PropagationPoint findPropagationPoint(Element element, String name){
		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(element);
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			PropagationPaths eps = errorModelSubclause.getPropagationPaths();
			if (eps!= null){
				EList<PropagationPoint> eflist = eps.getPoints();
				for (PropagationPoint propPoint : eflist) {
					if ( name.equalsIgnoreCase(propPoint.getName())){
						return propPoint;
					}
				}
			}
		}
		return null;
	}

	
	/**
	 * Find error propagation point in the extends hierarchy of the containing component of context
	 * @param context
	 * @param name
	 * @param dir
	 * @param isNot
	 * @return
	 */
	public static ErrorPropagation findErrorPropagationPoint(Element context, String name, DirectionType dir, boolean isNot){
		EList<ErrorModelSubclause> emslist =null;
		if (context instanceof QualifiedPropagationPoint){
			Subcomponent sub = ((QualifiedPropagationPoint)context).getSubcomponent();
			emslist =  getAllContainingClassifierEMV2Subclauses(sub.getAllClassifier());
		} else {
			emslist = getAllContainingClassifierEMV2Subclauses(context);
		}
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			ErrorPropagation res = findErrorPropagation(errorModelSubclause, name, dir, isNot);
			if (res != null) return res;
		}
		return null;
	}
	
	/**
	 * Find error propagation point in the EMV2 subclause only
	 * @param ems
	 * @param name
	 * @param dir
	 * @param isNot
	 * @return
	 */
	public static ErrorPropagation findErrorPropagation(ErrorModelSubclause ems, String name, DirectionType dir, boolean isNot){
		ErrorPropagations eps = ems.getErrorPropagations();
		if (eps != null){
			for (ErrorPropagation ep : eps.getPropagations()){
				if (ep.isNot() == isNot&& (dir == null ||ep.getDirection()== dir)){
					// do we need to check (context instanceof QualifiedObservableErrorPropagationPoint)
					EList<FeatureReference> refs = ep.getFeaturerefs();
					if (!refs.isEmpty()){
						String refname = "";
						for (FeatureReference featureReference : refs) {
							if (Aadl2Util.isNull(featureReference.getFeature())) return null;
							refname = refname + (refname.isEmpty()?"":".")+featureReference.getFeature().getName();
						}
						if (refname.equalsIgnoreCase(name)) return ep;
					}
					String kind = ep.getKind();
					if (kind != null && kind.equalsIgnoreCase(name)&&
							(dir == null||dir.equals(ep.getDirection()))) return ep;
				}
			}
		}
		return null;
	}

	
	/**
	 * find the incoming error propagation point of the specified name
	 * @param element the model element in the context of which we find the error propagation
	 * @param eppName Name of error propagation point we are looking for
	 * @return ErrorPropagation
	 */
	public static ErrorPropagation findIncomingErrorPropagation(Element element, String eppName){
		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(element);
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			ErrorPropagation res = findErrorPropagation(errorModelSubclause, eppName, DirectionType.IN,false);
			if (res != null) return res;
		}
		return null;
	}
	public static ErrorPropagation findIncomingErrorPropagation(EList<ErrorModelSubclause> emslist, String eppName){
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			ErrorPropagation res = findErrorPropagation(errorModelSubclause, eppName, DirectionType.IN,false);
			if (res != null) return res;
		}
		return null;
	}
	
	
	/**
	 * find the outgoing error propagation point of the specified name
	 * @param element the model element in the context of which we find the error propagation
	 * @param eppName Name of error propagation point we are looking for
	 * @return ErrorPropagation
	 */
	public static ErrorPropagation findOutgoingErrorPropagation(Element element, String eppName){
		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(element);
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			ErrorPropagation res = findErrorPropagation(errorModelSubclause, eppName, DirectionType.OUT,false);
			if (res != null) return res;
		}
		return null;
	}
	
	public static ErrorPropagation findOutgoingErrorPropagation(EList<ErrorModelSubclause> emslist, String eppName){
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			ErrorPropagation res = findErrorPropagation(errorModelSubclause, eppName, DirectionType.OUT,false);
			if (res != null) return res;
		}
		return null;
	}
	
	/**
	 * find the outgoing error containment point of the specified name
	 * @param element the model element in the context of which we find the error propagation
	 * @param eppName Name of error propagation point we are looking for
	 * @return ErrorPropagation
	 */
	public static ErrorPropagation findOutgoingErrorContainment(Element element, String eppName){
		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(element);
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			ErrorPropagation res = findErrorPropagation(errorModelSubclause, eppName, DirectionType.OUT,true);
			if (res != null) return res;
		}
		return null;
	}
	
	public static ErrorPropagation findOutgoingErrorContainment(EList<ErrorModelSubclause> emslist, String eppName){
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			ErrorPropagation res = findErrorPropagation(errorModelSubclause, eppName, DirectionType.OUT,true);
			if (res != null) return res;
		}
		return null;
	}
	
	
	/**
	 * find the incoming error propagation point of the specified name
	 * @param element the model element in the context of which we find the error propagation
	 * @param eppName Name of error propagation point we are looking for
	 * @return ErrorPropagation
	 */
	public static ErrorPropagation findIncomingErrorContainment(Element element, String eppName){
		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(element);
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			ErrorPropagation res = findErrorPropagation(errorModelSubclause, eppName, DirectionType.IN,true);
			if (res != null) return res;
		}
		return null;
	}
	public static ErrorPropagation findIncomingErrorContainment(EList<ErrorModelSubclause> emslist, String eppName){
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			ErrorPropagation res = findErrorPropagation(errorModelSubclause, eppName, DirectionType.IN,true);
			if (res != null) return res;
		}
		return null;
	}
	
	/**
	 * Get outgoing error propagation associated with feature instance
	 * @param fi feature instance
	 * @return error propagation
	 */
	public static ErrorPropagation getOutgoingErrorPropagation(FeatureInstance fi){
		ComponentInstance ci = fi.getContainingComponentInstance();
		return EMV2Util.findOutgoingErrorPropagation(ci.getComponentClassifier(), fi.getName());
	}
	
	/**
	 * Get incoming error propagation associated with feature instance
	 * @param fi feature instance
	 * @return error propagation
	 */
	public static ErrorPropagation getIncomingErrorPropagation(FeatureInstance fi){
		ComponentInstance ci = fi.getContainingComponentInstance();
		return EMV2Util.findIncomingErrorPropagation(ci.getComponentClassifier(), fi.getName());
	}
	
	/**
	 * Get outgoing error propagation associated with feature instance
	 * @param fi feature instance
	 * @return error propagation
	 */
	public static ErrorPropagation getOutgoingErrorContainment(FeatureInstance fi){
		ComponentInstance ci = fi.getContainingComponentInstance();
		return EMV2Util.findOutgoingErrorContainment(ci.getComponentClassifier(), fi.getName());
	}
	
	/**
	 * Get incoming error propagation associated with feature instance
	 * @param fi feature instance
	 * @return error propagation
	 */
	public static ErrorPropagation getIncomingErrorContainment(FeatureInstance fi){
		ComponentInstance ci = fi.getContainingComponentInstance();
		return EMV2Util.findIncomingErrorContainment(ci.getComponentClassifier(), fi.getName());
	}
	
	/**
	 * Get incoming error propagation associated with component instance access
	 * @param ci component instance
	 * @return error propagation
	 */
	public static ErrorPropagation getIncomingAccessErrorPropagation(ComponentInstance ci){
		return EMV2Util.findIncomingErrorPropagation(ci.getComponentClassifier(), "access");
	}
	
	/**
	 * Get outgoing error propagation associated with component instance access
	 * @param ci component instance
	 * @return error propagation
	 */
	public static ErrorPropagation getOutgoingAccessErrorPropagation(ComponentInstance ci){
		return EMV2Util.findOutgoingErrorPropagation(ci.getComponentClassifier(), "access");
	}

	/**
	 * Get incoming error Containment associated with component instance access
	 * @param ci component instance
	 * @return error propagation
	 */
	public static ErrorPropagation getIncomingAccessErrorContainment(ComponentInstance ci){
		return EMV2Util.findIncomingErrorContainment(ci.getComponentClassifier(), "access");
	}
	
	/**
	 * Get outgoing error Containment associated with component instance access
	 * @param ci component instance
	 * @return error propagation
	 */
	public static ErrorPropagation getOutgoingAccessErrorContainment(ComponentInstance ci){
		return EMV2Util.findOutgoingErrorContainment(ci.getComponentClassifier(), "access");
	}


	/**
	 * find error flow starting with given classifier by looking through all error flows
	 * @param cl
	 * @param name
	 * @return ErrorFlow
	 */
	public static ErrorFlow findErrorFlow(Element el, String name){
		Classifier cl= el.getContainingClassifier();
		if (cl != null){
			Collection<ErrorFlow> eflist = getAllErrorFlows(cl);
			return (ErrorFlow) AadlUtil.findNamedElementInList(eflist, name);
		}
		return null;
	}

	

	/**
	 * find the error flow whose incoming error propagation point is flowSource
	 * @param eps List of error propagations
	 * @param flowSource ErrorPropagation
	 * @return ErrorFlow list
	 */
	public static EList<ErrorFlow> findErrorFlowFrom(Collection<ErrorFlow> efs, ErrorPropagation flowSource){
		EList<ErrorFlow> result = new BasicEList<ErrorFlow>();
		for (ErrorFlow ef : efs) {
			ErrorPropagation eprop = null;
			if (ef instanceof ErrorPath){
				ErrorPath ep = (ErrorPath)ef;
				 eprop = ep.getIncoming();
			} else if (ef instanceof ErrorSink){
				ErrorSink es = (ErrorSink)ef;
				 eprop =es.getIncoming();
			}
			if (eprop != null && eprop == flowSource){
				result.add(ef);
			}
		}
		return result;
	}

		/**
		 * find the error flow whose outgoing error propagation point is flowSource
	 * @param eps List of error propagations
	 * @param flowSource ErrorPropagation
	 * @return ErrorFlow list
		 */
	public static EList<ErrorFlow> findReverseErrorFlowFrom(Collection<ErrorFlow> efs, ErrorPropagation flowSource){
		EList<ErrorFlow> result = new BasicEList<ErrorFlow>();
		for (ErrorFlow ef : efs) {
			ErrorPropagation eprop = null;
			if (ef instanceof ErrorPath){
				ErrorPath ep = (ErrorPath)ef;
				eprop=ep.getOutgoing();
			} else if (ef instanceof ErrorSource){
				ErrorSource es = (ErrorSource)ef;
				eprop=es.getOutgoing();
			}
			if (eprop != null && eprop == flowSource){
				result.add(ef);
			}
		}
		return result;
	}
	
	
	public static ErrorBehaviorState findErrorBehaviorState(Element context, String name){
		ErrorBehaviorStateMachine ebsm;
		if (context instanceof ConditionElement && !((ConditionElement)context).getSubcomponents().isEmpty()){
			// look up state in state machine of subcomponent
			ConditionElement tcs = (ConditionElement)context;
			 EList<SubcomponentElement> sublist = tcs.getSubcomponents();
			Subcomponent sub = sublist.get(sublist.size()-1).getSubcomponent();
			ComponentClassifier sc = sub.getAllClassifier();
			if (sc == null) return null;
			return findErrorBehaviorStateinUseBehavior( sc,name);
		} else {
			// resolve in local context, which is assumed to be an EBSM
			ebsm = EMV2Util.getContainingErrorBehaviorStateMachine(context);
			if (ebsm == null) ebsm = EMV2Util.getUsedErrorBehaviorStateMachine(context);
			return findErrorBehaviorStateInEBSM(ebsm, name);
		}
	}
	
	/**
	 * find the first subclause and look for this Use Behavior.
	 * Since Use behavior is optional it might not find any 
	 * It will not assume that Use Behavior is inherited
	 * @param cl
	 * @param name
	 * @return
	 */
	public static ErrorBehaviorState findErrorBehaviorStateinUseBehavior(Classifier cl, String name){
		if (cl == null) return null;
		// XXX if we want to support inherit of Use Behavior we call getClassifierUseBehavior to get the EBSM
		// and then do a find on it.
			ErrorModelSubclause ems = getClassifierEMV2Subclause(cl);
			ErrorBehaviorStateMachine ebsm = ems.getUseBehavior();
			if (ebsm != null){
				return findErrorBehaviorStateInEBSM(ebsm, name);
			}
			return null;
	}
	
	/**
	 * find error behavior state in state machine
	 * @param ebsm
	 * @param name
	 * @return
	 */
	public static ErrorBehaviorState findErrorBehaviorStateInEBSM(ErrorBehaviorStateMachine ebsm, String name){
		if (ebsm != null){
			EList<ErrorBehaviorState> ebsl= ebsm.getStates();
			for (ErrorBehaviorState ebs : ebsl){
				if (EMV2Util.getItemNameWithoutQualification(name).equalsIgnoreCase(ebs.getName())) return ebs;
			}
			// enable if we support extends on EBSM
//			if (ebsm.getExtends() != null){
//				return findErrorBehaviorStateInEBSM(ebsm.getExtends(), name);
//			}
		}
		return null;
	}
	
	

	/**
	 * get the subclause use behavior (EBSM) for the specified classifier.
     * Does not look in the extends hierarchy
	 * @param cl CLassifier
	 * @return ErrorBehaviorStateMachine
	 */
	public static ErrorBehaviorStateMachine getOwnUseBehavior(Classifier cl){
		if (cl == null) return null;
		EList<AnnexSubclause> asl = cl.getOwnedAnnexSubclauses();
		for (AnnexSubclause al : asl){
			if (al instanceof ErrorModelSubclause){
				return ((ErrorModelSubclause)al).getUseBehavior();
			}
		}
		return null;
	}

	/**
	 * get the subclause use behavior (EBSM) for the specified classifier.
	 * It effectively returns the first EBSM that applies to the classifier.
	 * The method goes up the extends hierarchy, and in the case of an implementation
	 * tries its type and the type's hierarchy.
	 * 
	 * @param cl Classifier
	 * @return
	 */
	public static ErrorBehaviorStateMachine getClassifierUseBehavior(Classifier cl){
		if (cl == null) return null;
		ErrorModelSubclause ems = getOwnEMV2Subclause(cl);
		if (ems != null) {
			ErrorBehaviorStateMachine ebsm = ems.getUseBehavior();
			if (ebsm != null)
				return ebsm;
		}
		if (cl instanceof ComponentImplementation){
			ems = getExtendsEMV2Subclause((ComponentImplementation)cl);
			if (ems != null) {
				ErrorBehaviorStateMachine ebsm = ems.getUseBehavior();
				if (ebsm != null)
					return ebsm;
			}
			ems = getExtendsEMV2Subclause(((ComponentImplementation)cl).getType());
			if (ems != null) {
				ErrorBehaviorStateMachine ebsm = ems.getUseBehavior();
				if (ebsm != null)
					return ebsm;
			}
		} else {
			ems = getExtendsEMV2Subclause(cl);
			if (ems != null) {
				ErrorBehaviorStateMachine ebsm = ems.getUseBehavior();
				if (ebsm != null)
					return ebsm;
			}
		}
		return null;
	}
	
	/**
	 * find the first subclause Use Behavior on the classifier or its extends hierachy.
	 * When used on a component implementation this method does not go from an implemetnation to a type.
	 * 
	 * @param cl
	 * @return
	 */
	public static ErrorBehaviorStateMachine getExtendsUseBehavior(Classifier cl){
		if (cl == null) return null;
		ErrorModelSubclause ems = getOwnEMV2Subclause(cl);
		if (ems != null) {
			ErrorBehaviorStateMachine ebsm = ems.getUseBehavior();
			if (ebsm != null)
				return ebsm;
		}
		if (!Aadl2Util.isNull(cl.getExtended())){
			ems= getExtendsEMV2Subclause(cl.getExtended());
			if (ems != null) {
				ErrorBehaviorStateMachine ebsm = ems.getUseBehavior();
				if (ebsm != null)
					return ebsm;
			}
		}
		return null;
	}
	
	
	/**
	 * find error behavior transition in the specified context, i.e., its enclosing classifier subclause or inherited subclauses
	 * we look in the component error behavior sections first, and then in the EBSM of the use behavior.
	 * @param context
	 * @param name
	 * @return
	 */
	public static ErrorBehaviorTransition findErrorBehaviorTransition(Element context, String name){
		Classifier cl = context.getContainingClassifier();
		if (cl != null){
			// we are not in an error library
			ErrorBehaviorTransition ebt = findErrorBehaviorTransitioninCEB(cl, name);
			if (ebt != null) return ebt;
			// find it in the EBSM from the use behavior
			return findErrorBehaviorTransitioninUseBehavior(cl, name);
		} else {
			// we are inside an error library resolving transition references
			ErrorBehaviorStateMachine ebsm = EMV2Util.getContainingErrorBehaviorStateMachine(context);
			if (ebsm == null) ebsm = EMV2Util.getUsedErrorBehaviorStateMachine(context);
			return findErrorBehaviorTransitionInEBSM(ebsm, name);
		}
	}
	
	
	/**
	 * find the first subclause and look for this Use Behavior.
	 * Since Use behavior is optional it might not find any 
	 * It will not assume that Use Behavior is inherited
	 * @param cl
	 * @param name
	 * @return
	 */
	public static ErrorBehaviorTransition findErrorBehaviorTransitioninUseBehavior(Classifier cl, String name){
		if (cl == null) return null;
		// XXX if we want to support inherit of Use Behavior we call getClassifierUseBehavior to get the EBSM
		// and then do a find on it.
			ErrorModelSubclause ems = getClassifierEMV2Subclause(cl);
			ErrorBehaviorStateMachine ebsm = ems.getUseBehavior();
			if (ebsm != null){
				return findErrorBehaviorTransitionInEBSM(ebsm, name);
			}
			return null;
	}

	
	
	/**
	 * find transition in EBSM
	 * @param ebsm
	 * @param name
	 * @return
	 */
	public static ErrorBehaviorTransition findErrorBehaviorTransitionInEBSM(ErrorBehaviorStateMachine ebsm, String name){
		if (ebsm != null){
			EList<ErrorBehaviorTransition> ebsl= ebsm.getTransitions();
			for (ErrorBehaviorTransition ebs : ebsl){
				if (EMV2Util.getItemNameWithoutQualification(name).equalsIgnoreCase(ebs.getName())) return ebs;
			}
			// enable if we introduce extends of EBSM
//			if (ebsm.getExtends() != null){
//				return findErrorBehaviorTransitionInEBSM(ebsm.getExtends(), name);
//			}
		}
		return null;
	}
	
	/**
	 * find the error behavior transition in the component error behavior looking in all inherited subclauses according to extends and type of implementation
	 * @param cl
	 * @param name
	 * @return
	 */
	public static ErrorBehaviorTransition findErrorBehaviorTransitioninCEB(Classifier cl, String name){
		if (cl == null) return null;
		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(cl);
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			ErrorBehaviorTransition res = findOwnErrorBehaviorTransition(errorModelSubclause, name);
			if (res != null) return res;
		}
		return null;
	}

	/**
	 * find transition in given subclause component error behavior
	 * @param ems
	 * @param name
	 * @return
	 */
	public static ErrorBehaviorTransition findOwnErrorBehaviorTransition(ErrorModelSubclause ems, String name){
		if (ems == null) return null;
		ComponentErrorBehavior ceb = ems.getComponentBehavior();
		if (ceb != null){
			EList<ErrorBehaviorTransition> transitions = ceb.getTransitions();
			for (ErrorBehaviorTransition errorBehaviorTransition : transitions) {
				if (name.equalsIgnoreCase(errorBehaviorTransition.getName())) return errorBehaviorTransition;
			}
		}
		return null;
	}

	public static ErrorBehaviorEvent findOwnErrorBehaviorEvent(ErrorModelSubclause ems, String name){
		if (ems == null) return null;
		ComponentErrorBehavior ceb = ems.getComponentBehavior();
		if (ceb != null){
			EList<ErrorBehaviorEvent> events = ceb.getEvents();
			for (ErrorBehaviorEvent errorBehaviorEvent : events) {
				if (name.equalsIgnoreCase(errorBehaviorEvent.getName())) return errorBehaviorEvent;
			}
		}
		return null;
	}

	
	/**
	 * find the error behavior event in the component error behavior looking in all inherited subclauses according to extends and type of implementation
	 * @param cl
	 * @param name
	 * @return
	 */
	public static ErrorBehaviorEvent findErrorBehaviorEventinCEB(Classifier cl, String name){
		if (cl == null) return null;
		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(cl);
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			ErrorBehaviorEvent res = findOwnErrorBehaviorEvent(errorModelSubclause, name);
			if (res != null) return res;
		}
		return null;
	}

	
	/**
	 * find error behavior event in the specified context, i.e., its enclosing classifier subclause or inherited subclauses
	 * we look in the component error behavior sections first, and then in the EBSM of the use behavior.
	 * @param context
	 * @param name
	 * @return
	 */
	public static ErrorBehaviorEvent findErrorBehaviorEvent(Element context, String name){
		Classifier cl = context.getContainingClassifier();
		if (cl != null){
			// we are not in an error library
			ErrorBehaviorEvent ebt = findErrorBehaviorEventinCEB(cl, name);
			if (ebt != null) return ebt;
			// find it in the EBSM from the use behavior
			return findErrorBehaviorEventinUseBehavior(cl, name);
		} else {
			// we are inside an error library resolving transition references
			ErrorBehaviorStateMachine ebsm = EMV2Util.getContainingErrorBehaviorStateMachine(context);
			if (ebsm == null) ebsm = EMV2Util.getUsedErrorBehaviorStateMachine(context);
			return findErrorBehaviorEventInEBSM(ebsm, name);
		}
	}
	
	
	
	/**
	 * find the first subclause and look for this Use Behavior.
	 * Since Use behavior is optional it might not find any 
	 * It will not assume that Use Behavior is inherited
	 * @param cl
	 * @param name
	 * @return
	 */
	public static ErrorBehaviorEvent findErrorBehaviorEventinUseBehavior(Classifier cl, String name){
		if (cl == null) return null;
		// XXX if we want to support inherit of Use Behavior we call getClassifierUseBehavior to get the EBSM
		// and then do a find on it.
			ErrorModelSubclause ems = getClassifierEMV2Subclause(cl);
			ErrorBehaviorStateMachine ebsm = ems.getUseBehavior();
			if (ebsm != null){
				return findErrorBehaviorEventInEBSM(ebsm, name);
			}
			return null;
	}

	
	public static ErrorBehaviorEvent findErrorBehaviorEventInEBSM(ErrorBehaviorStateMachine ebsm, String name){
		if (ebsm != null){
			EList<ErrorBehaviorEvent> ebsl= ebsm.getEvents();
			for (ErrorBehaviorEvent ebs : ebsl){
				if (EMV2Util.getItemNameWithoutQualification(name).equalsIgnoreCase(ebs.getName())) return ebs;
			}
			// enable if we support extends of EBSM
//			if (ebsm.getExtends() != null){
//				return findErrorBehaviorEventInEBSM(ebsm.getExtends(), name);
//			}
		}
		return null;
	}
	
	
	/**
	 * find Error Detection in own subclause component error behavior
	 * @param ems
	 * @param name
	 * @return
	 */
	public static ErrorDetection findOwnErrorDetection(ErrorModelSubclause ems, String name){
		if (ems == null) return null;
		ComponentErrorBehavior ceb = ems.getComponentBehavior();
		if (ceb != null){
			EList<ErrorDetection> detections = ceb.getErrorDetections();
			for (ErrorDetection errorDetection : detections) {
				if (name.equalsIgnoreCase(errorDetection.getName())) return errorDetection;
			}
		}
		return null;
	}

	
	/**
	 * find the error detection in the component error behavior looking in all inherited subclauses according to extends and type of implementation
	 * @param cl
	 * @param name
	 * @return
	 */
	public static ErrorDetection findErrorDetectioninCEB(Classifier cl, String name){
		if (cl == null) return null;
		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(cl);
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			ErrorDetection res = findOwnErrorDetection(errorModelSubclause, name);
			if (res != null) return res;
		}
		return null;
	}

	
	/**
	 * find error detection in the specified context, i.e., its enclosing classifier subclause or inherited subclauses
	 * we look in the component error behavior sections .
	 * @param context
	 * @param name
	 * @return
	 */
	public static ErrorDetection findErrorDetection(Element context, String name){
		Classifier cl = context.getContainingClassifier();
		if (cl != null){
			// we are not in an error library
			ErrorDetection ebt = findErrorDetectioninCEB(cl, name);
			 return ebt;
		}
		return null;
	}
	
	
	/**
	 * find Error Detection in own subclause component error behavior
	 * @param ems
	 * @param name
	 * @return
	 */
	public static OutgoingPropagationCondition findOwnOutgoingPropagationCondition(ErrorModelSubclause ems, String name){
		if (ems == null) return null;
		ComponentErrorBehavior ceb = ems.getComponentBehavior();
		if (ceb != null){
			EList<OutgoingPropagationCondition> outgoingPs = ceb.getOutgoingPropagationConditions();
			for (OutgoingPropagationCondition outgoingPropagationCondition : outgoingPs) {
				if (name.equalsIgnoreCase(outgoingPropagationCondition.getName())) return outgoingPropagationCondition;
			}
		}
		return null;
	}

	
	/**
	 * find the error detection in the component error behavior looking in all inherited subclauses according to extends and type of implementation
	 * @param cl
	 * @param name
	 * @return
	 */
	public static OutgoingPropagationCondition findOutgoingPropagationConditioninCEB(Classifier cl, String name){
		if (cl == null) return null;
		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(cl);
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			OutgoingPropagationCondition res = findOwnOutgoingPropagationCondition(errorModelSubclause, name);
			if (res != null) return res;
		}
		return null;
	}

	
	/**
	 * find error detection in the specified context, i.e., its enclosing classifier subclause or inherited subclauses
	 * we look in the component error behavior sections .
	 * @param context
	 * @param name
	 * @return
	 */
	public static OutgoingPropagationCondition findOutgoingPropagationCondition(Element context, String name){
		Classifier cl = context.getContainingClassifier();
		if (cl != null){
			// we are not in an error library
			return findOutgoingPropagationConditioninCEB(cl, name);
		}
		return null;
	}

	
	/**
	 * return list of outgoing error propagations including those inherited from classifiers being extended
	 * @param cl Classifier
	 * @return Collection<ErrorPropagation> list of ErrorPropagations excluding duplicates
	 */
	public static Collection<ErrorPropagation> getAllOutgoingErrorPropagations(Classifier cl){
		Collection<ErrorPropagation> props = getAllErrorPropagations(cl);
		BasicEList<ErrorPropagation> result = new BasicEList<ErrorPropagation>();
		for (ErrorPropagation errorPropagation : props) {
			if (errorPropagation.getDirection().equals(DirectionType.OUT)){
				result.add(errorPropagation);
			}
		}
		return result;
	}
	
	/**
	 * return list of error propagations including those inherited from classifiers being extended
	 * @param cl Classifier
	 * @return Collection<ErrorPropagation> list of ErrorPropagations excluding duplicates
	 */
	public static Collection<ErrorPropagation> getAllIncomingErrorPropagations(Classifier cl){
		Collection<ErrorPropagation> props = getAllErrorPropagations(cl);
		BasicEList<ErrorPropagation> result = new BasicEList<ErrorPropagation>();
		for (ErrorPropagation errorPropagation : props) {
			if (errorPropagation.getDirection().equals(DirectionType.IN)){
				result.add(errorPropagation);
			}
		}
		return result;
	}
	
	/**
	 * return list of error propagations including those inherited from classifiers being extended
	 * @param cl Classifier
	 * @return Collection<ErrorPropagation> list of ErrorPropagation excluding duplicates
	 */
	public static Collection<ErrorPropagation> getAllErrorPropagations(Classifier cl){
		HashMap<String,ErrorPropagation> result = new HashMap<String,ErrorPropagation>();
		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(cl);
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			ErrorPropagations eps = errorModelSubclause.getErrorPropagations();
			if (eps!= null){
				EList<ErrorPropagation> eflist = eps.getPropagations();
				for (ErrorPropagation errorProp : eflist) {
					if (!errorProp.isNot()){
						String epname = EMV2Util.getPrintName(errorProp);
						if (!result.containsKey(epname)){
							result.put(epname,errorProp);
						}
					}
				}
			}
		}
		return result.values();
	}
	
	/**
	 * return list of error containments including those inherited from classifiers being extended
	 * @param cl Classifier
	 * @return Collection<ErrorPropagation> list of ErrorPropagations excluding duplicates
	 */
	public static Collection<ErrorPropagation> getAllErrorContainments(Classifier cl){
		HashMap<String,ErrorPropagation> result = new HashMap<String,ErrorPropagation>();
		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(cl);
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			ErrorPropagations eps = errorModelSubclause.getErrorPropagations();
			if (eps!= null){
				EList<ErrorPropagation> eflist = eps.getPropagations();
				for (ErrorPropagation errorProp : eflist) {
					if (!errorProp.isNot()){
						String epname = EMV2Util.getPrintName(errorProp);
						if (!result.containsKey(epname)){
							result.put(epname,errorProp);
						}
					}
				}
			}
		}
		return result.values();
	}

	
	/**
	 * return list of error flow including those inherited from classifiers being extended
	 * @param cl Classifier
	 * @return Collection<ErrorFlow> list of error flow
	 */
	public static Collection<ErrorFlow> getAllErrorFlows(Classifier cl){
		HashMap<String,ErrorFlow> result = new HashMap<String,ErrorFlow>();
		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(cl);
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			ErrorPropagations eps = errorModelSubclause.getErrorPropagations();
			if (eps!= null){
				EList<ErrorFlow> eflist = eps.getFlows();
				for (ErrorFlow errorFlow : eflist) {
					if (!result.containsKey(errorFlow.getName())){
						result.put(errorFlow.getName(),errorFlow);
					}
				}
			}
		}
		return result.values();
	}

	
	
	/**
	 * return list of error sources including those inherited from classifiers being extended
	 * @param cl Classifier
	 * @return Collection<ErrorSource> list of error flow
	 */
	public static Collection<ErrorSource> getAllErrorSources(Classifier cl){
		HashMap<String,ErrorSource> result = new HashMap<String,ErrorSource>();
		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(cl);
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			ErrorPropagations eps = errorModelSubclause.getErrorPropagations();
			if (eps!= null){
				EList<ErrorFlow> eflist = eps.getFlows();
				for (ErrorFlow errorFlow : eflist) {
					if (errorFlow instanceof ErrorSource){
						if( !result.containsKey(errorFlow.getName())){
							result.put(errorFlow.getName(),(ErrorSource)errorFlow);
						}
					}
				}
			}
		}
		return result.values();
	}

	
	/**
	 * return list of propagation points including those inherited from classifiers being extended
	 * @param cl Classifier
	 * @return Collection<PropagationPoint> list of propagation points as HashMap for quick lookup of names
	 */
	public static Collection<PropagationPoint> getAllPropagationPoints(Classifier cl){
		HashMap<String,PropagationPoint> result = new HashMap<String,PropagationPoint>();
		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(cl);
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			PropagationPaths eps = errorModelSubclause.getPropagationPaths();
			if (eps!= null){
				EList<PropagationPoint> eflist = eps.getPoints();
				for (PropagationPoint propPoint : eflist) {
					if ( !result.containsKey(propPoint.getName())){
						result.put(propPoint.getName(),propPoint);
					}
				}
			}
		}
		return result.values();
	}

	
	
	/**
	 * return list of PropagationPointConnections including those inherited from classifiers being extended
	 * @param cl Classifier
	 * @return Collection<PropagationPointConnection> list of PropagationPointConnections as HashMap for quick lookup of names
	 */
	public static Collection<PropagationPointConnection> getAllPropagationPointConnections(Classifier cl){
		HashMap<String,PropagationPointConnection> result = new HashMap<String,PropagationPointConnection>();
		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(cl);
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			PropagationPaths eps = errorModelSubclause.getPropagationPaths();
			if (eps!= null){
				EList<PropagationPointConnection> eflist = eps.getConnections();
				for (PropagationPointConnection propPointConn : eflist) {
					if ( !result.containsKey(propPointConn.getName())){
						result.put(propPointConn.getName(),propPointConn);
					}
				}
			}
		}
		return result.values();
	}
	

	
	/**
	 * return list of ErrorBehaviorEvents including those inherited from classifiers being extended
	 * @param cl Classifier
	 * @return Collection<ErrorBehaviorEvent> list of ErrorBehaviorEvents as HashMap for quick lookup of names
	 */
	public static Collection<ErrorBehaviorEvent> getAllErrorBehaviorEvents(Classifier cl){
		HashMap<String,ErrorBehaviorEvent> result = new HashMap<String,ErrorBehaviorEvent>();
		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(cl);
		boolean foundEBSM = false;
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			ErrorBehaviorStateMachine ebsm = errorModelSubclause.getUseBehavior();
			ComponentErrorBehavior ceb = errorModelSubclause.getComponentBehavior();
			if (ceb!= null){
				EList<ErrorBehaviorEvent> eflist = ceb.getEvents();
				for (ErrorBehaviorEvent ebe : eflist) {
					if ( !result.containsKey(ebe.getName())){
						result.put(ebe.getName(),ebe);
					}
				}
			}
			if (!foundEBSM && ebsm!= null){
				foundEBSM = true;
				EList<ErrorBehaviorEvent> eflist = ebsm.getEvents();
				for (ErrorBehaviorEvent ebe : eflist) {
					if ( !result.containsKey(ebe.getName())){
						result.put(ebe.getName(),ebe);
					}
				}
			}

		}
		return result.values();
	}

	
	/**
	 * return list of ErrorBehaviorStates including those inherited from classifiers being extended
	 * @param cl Classifier
	 * @return Collection<ErrorBehaviorState> list of ErrorBehaviorStates as HashMap for quick lookup of names
	 */
	public static Collection<ErrorBehaviorState> getAllErrorBehaviorStates(Classifier cl){
		HashMap<String,ErrorBehaviorState> result = new HashMap<String,ErrorBehaviorState>();
		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(cl);
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			ErrorBehaviorStateMachine ebsm = errorModelSubclause.getUseBehavior();
			if ( ebsm!= null){
				EList<ErrorBehaviorState> eflist = ebsm.getStates();
				for (ErrorBehaviorState ebs : eflist) {
					if ( !result.containsKey(ebs.getName())){
						result.put(ebs.getName(),ebs);
					}
				}
				return result.values();
			}

		}
		return Collections.EMPTY_LIST;
	}

	
	/**
	 * return list of ErrorBehaviorEvents including those inherited from classifiers being extended
	 * @param cl Classifier
	 * @return Collection<ErrorBehaviorEvent> list of ErrorBehaviorEvents as HashMap for quick lookup of names
	 */
	public static Collection<ErrorBehaviorTransition> getAllErrorBehaviorTransitions(Classifier cl){
		BasicEList<ErrorBehaviorTransition> unlist = new BasicEList<ErrorBehaviorTransition>();
		Collection<ErrorBehaviorTransition> res = getAllErrorBehaviorTransitions(cl, unlist).values();
		
		BasicEList<ErrorBehaviorTransition> result = new BasicEList<ErrorBehaviorTransition>();
		result.addAll(res);
		result.addAll(unlist);
		return result;
	}
	
	/**
	 * return list of ErrorBehaviorTransition including those inherited from classifiers being extended
	 * @param cl Classifier
	 * @param unnamed Collection of unnamed ErrorBehaviorTransition
	 * @return Collection<ErrorBehaviorTransition> list of ErrorBehaviorTransition as HashMap for quick lookup of names
	 */
	public static HashMap<String,ErrorBehaviorTransition>  getAllErrorBehaviorTransitions(Classifier cl,Collection<ErrorBehaviorTransition> unnamed){
		HashMap<String,ErrorBehaviorTransition> result = new HashMap<String,ErrorBehaviorTransition>();
		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(cl);
		boolean foundEBSM = false;
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			ErrorBehaviorStateMachine ebsm = errorModelSubclause.getUseBehavior();
			ComponentErrorBehavior ceb = errorModelSubclause.getComponentBehavior();
			if (ceb!= null){
				EList<ErrorBehaviorTransition> eflist = ceb.getTransitions();
				for (ErrorBehaviorTransition ebt : eflist) {
					if (ebt.getName() == null){
						unnamed.add(ebt);
					} else{
						if ( !result.containsKey(ebt.getName())){
							result.put(ebt.getName(),ebt);
						}
					}
				}
			}
			if (!foundEBSM && ebsm!= null){
				foundEBSM = true;
				EList<ErrorBehaviorTransition> eflist = ebsm.getTransitions();
				for (ErrorBehaviorTransition ebt : eflist) {
					if (ebt.getName() == null){
						unnamed.add(ebt);
					} else{
						if ( !result.containsKey(ebt.getName())){
							result.put(ebt.getName(),ebt);
						}
					}
				}
			}

		}
		return result;
	}
	
	/**
	 * return list of OutgoingPropagationCondition including those inherited from classifiers being extended
	 * @param cl Classifier
	 * @return Collection<OutgoingPropagationCondition> list of OutgoingPropagationCondition 
	 */
	public static Collection<OutgoingPropagationCondition> getAllOutgoingPropagationConditions(Classifier cl){
		BasicEList<OutgoingPropagationCondition> unlist = new BasicEList<OutgoingPropagationCondition>();
		Collection<OutgoingPropagationCondition> res = getAllOutgoingPropagationConditions(cl, unlist).values();
		res.addAll(unlist);
		return res;
	}
	
	/**
	 * return list of OutgoingPropagationCondition including those inherited from classifiers being extended
	 * @param cl Classifier
	 * @param unnamed Collection of unnamed OutgoingPropagationCondition
	 * @return Collection<ErrorBehaviorTransition> list of OutgoingPropagationCondition as HashMap for quick lookup of names
	 */
	public static HashMap<String,OutgoingPropagationCondition>  getAllOutgoingPropagationConditions(Classifier cl,Collection<OutgoingPropagationCondition> unnamed){
		HashMap<String,OutgoingPropagationCondition> result = new HashMap<String,OutgoingPropagationCondition>();
		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(cl);
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			ComponentErrorBehavior ceb = errorModelSubclause.getComponentBehavior();
			if (ceb!= null){
				EList<OutgoingPropagationCondition> eflist = ceb.getOutgoingPropagationConditions();
				for (OutgoingPropagationCondition ebt : eflist) {
					if (ebt.getName() == null){
						unnamed.add(ebt);
					} else{
						if ( !result.containsKey(ebt.getName())){
							result.put(ebt.getName(),ebt);
						}
					}
				}
			}
		}
		return result;
	}

	
	/**
	 * return list of OutgoingPropagationCondition including those inherited from classifiers being extended
	 * @param cl Classifier
	 * @return Collection<OutgoingPropagationCondition> list of OutgoingPropagationCondition 
	 */
	public static Collection<ErrorDetection> getAllErrorDetections(Classifier cl){
		BasicEList<ErrorDetection> unlist = new BasicEList<ErrorDetection>();
		Collection<ErrorDetection> res = getAllErrorDetections(cl, unlist).values();
		res.addAll(unlist);
		return res;
	}
	
	/**
	 * return list of OutgoingPropagationCondition including those inherited from classifiers being extended
	 * @param cl Classifier
	 * @param unnamed Collection of unnamed OutgoingPropagationCondition
	 * @return Collection<ErrorBehaviorTransition> list of OutgoingPropagationCondition as HashMap for quick lookup of names
	 */
	public static HashMap<String,ErrorDetection>  getAllErrorDetections(Classifier cl,Collection<ErrorDetection> unnamed){
		HashMap<String,ErrorDetection> result = new HashMap<String,ErrorDetection>();
		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(cl);
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			ComponentErrorBehavior ceb = errorModelSubclause.getComponentBehavior();
			if (ceb!= null){
				EList<ErrorDetection> eflist = ceb.getErrorDetections();
				for (ErrorDetection ebt : eflist) {
					if (ebt.getName() == null){
						unnamed.add(ebt);
					} else{
						if ( !result.containsKey(ebt.getName())){
							result.put(ebt.getName(),ebt);
						}
					}
				}
			}
		}
		return result;
	}

	
	/**
	 * return list of NamedElements in error model subclause
	 * @param ems error model subclause
	 * @return Collection<NamedElement> list of defined named elements
	 */
	public static Collection<NamedElement> getAllNamedElements(ErrorModelSubclause ems){
		Collection<NamedElement> result = new BasicEList<NamedElement>();
		ErrorPropagations props = ems.getErrorPropagations();
		getAllNamedElements(props, result);
		ComponentErrorBehavior ceb = ems.getComponentBehavior();
		getAllNamedElements(ceb, result);
		return result;
	}

	
	public static void getAllNamedElements(ErrorPropagations props, Collection<NamedElement> result){
		if (props == null) return;
		result.addAll(props.getPropagations());
			result.addAll( props.getFlows());
	}
	
	public static void getAllNamedElements(ComponentErrorBehavior ceb, Collection<NamedElement> result){
		if (ceb == null) return;
		result.addAll(ceb.getEvents());
		result.addAll( ceb.getTransitions());
		result.addAll( ceb.getOutgoingPropagationConditions());
		result.addAll( ceb.getErrorDetections());
	}
	
	public static void getAllNamedElements(ErrorBehaviorStateMachine ebsm, Collection<NamedElement> result){
		if (ebsm == null) return;
		result.addAll(ebsm.getEvents());
		result.addAll( ebsm.getStates());
		result.addAll( ebsm.getTransitions());
	}


	/**
	 * get the EM object that contains the condition expression.
	 * Traverses up the expression tree to the enclosing EM object
	 * @param element
	 * @return Error Model object that contains the expression
	 */
	public static EObject getConditionOwner(Element element) {
		EObject container = element;
		while (container != null && (container instanceof ConditionExpression))
			container = container.eContainer();
		return container ;
	}

	/**
	 * get the state machine that contains the EM element 
	 * @param element
	 * @return ErrorBehaviorStateMachine object or null if element is not inside an EBSM
	 */
	public static ErrorBehaviorStateMachine getContainingErrorBehaviorStateMachine(Element element) {
		EObject container = element;
		while (container != null && !(container instanceof ErrorBehaviorStateMachine))
			container = container.eContainer();
		return (ErrorBehaviorStateMachine) container;
	}

	/**
	 * get the enclosing error model library.
	 * Returns null if the element is not in a error model library
	 * @param element
	 * @return ErrorModelLibrary or null
	 */
	public static ErrorModelLibrary getContainingErrorModelLibrary(Element element) {
		EObject container = element;
		while (container != null && !(container instanceof ErrorModelLibrary))
			container = container.eContainer();
		return (ErrorModelLibrary) container;
	}


	/**
	 * get the enclosing type use context
	 * A type use context is is the object that contains use references to error model/type libraries 
	 * @param element
	 * @return Type transformation set, type mapping set, error propagations object, EBSM, 
	 * component error behavior, composite error behavior
	 * or null if not in any
	 */
	public static TypeUseContext getContainingTypeUseContext(Element element) {
		EObject container = element;
		while (container != null && !(container instanceof TypeUseContext))
			container = container.eContainer();
		return (TypeUseContext) container;
	}
	
	/**
	 * return the feature the error propagation is pointing to or null
	 * @param ep
	 * @return Feature
	 */
	public static Feature getFeature(ErrorPropagation ep){
		EList<FeatureReference> freflist = ep.getFeaturerefs();
		if (!freflist.isEmpty()){
			FeatureReference fref = freflist.get(freflist.size()-1);
			NamedElement f = fref.getFeature();
			if (f instanceof Feature){
				return (Feature) f;
			}
		}
		return null;
	}
	
	/**
	 * return true if error propagation points to an access point
	 * @param ep
	 * @return Feature
	 */
	public static boolean isAccess(ErrorPropagation ep){
		String s = ep.getKind();
		return s.equalsIgnoreCase("access");
	}
	

	/**
	 * extract the item name from a qualified name, the identifier after the last ::
	 * @param qualname String Qualified name
	 * @return String item name 
	 */
	public static String getItemNameWithoutQualification(String qualname){
		final int idx = qualname.lastIndexOf("::");
		if (idx != -1) {
			return qualname.substring(idx + 2);
		}
		return qualname;
	}

	/**
	 * extract the package name of a qualified name, everything up to the last :: or null
	 * @param qualname
	 * @return String
	 */
	public static String getPackageName(String qualname){
		final int idx = qualname.lastIndexOf("::");
		if (idx != -1) {
			return qualname.substring(0, idx);
		}
		return null;
	}
	
	public static String getPrintName(Element el){
		if (el instanceof NamedElement){
			NamedElement ne = (NamedElement)el;
			if(ne.getName() != null) return ne.getName();
		}
		if (el instanceof ErrorPropagation){
			ErrorPropagation ep = (ErrorPropagation)el;
			return getPrintName(ep);
		}
		return "";
	}
	
	/**
	 * get printName of Error Propagation
	 * @param ep
	 * @return
	 */
	public static String getPrintName(ErrorPropagation ep){
		EList<FeatureReference> refs = ep.getFeaturerefs();
		String refname = "";
		if (refs.isEmpty()){
			if (ep.getKind() != null) return ep.getKind();
		} else {
		for (FeatureReference featureReference : refs) {
			if (Aadl2Util.isNull(featureReference.getFeature())) return null;
			refname = refname + (refname.isEmpty()?"":".")+featureReference.getFeature().getName();
		}
		}
		return refname;
	}
	
	public static String getPrintName(TypeSet ts){
			return getPrintableName(ts, ", ");
	}
	
	
	public static String getPrintName(ErrorModelLibrary eml){
			return AadlUtil.getContainingPackage(eml).getName();
	}

	
	public static String getTableName(TypeSet ts){
			return getPrintableName(ts, "/");
	}
	
	public static String getPrintableName(TypeSet ts,String separator){
		if (ts == null) return "";
		String res ="{";
		EList<TypeToken> te = ts.getElementType();
		boolean docomma = false;
		for (TypeToken typeSetElement : te) {
			 EList<ErrorType> et = typeSetElement.getType();
			if (docomma) res = res+separator; else docomma = true;
			if (et != null&& !et.isEmpty()){
				boolean doproduct = false;
				for (ErrorType errorType : et) {
					if (doproduct) res = res+"+"; else doproduct = true;
					res = res + errorType.getName();
				}
			}
		}
		return res+"}";
	}
	
	public static String getPrintName(TypeToken tu){
		return "{"+getName(tu)+"}";
	}
	
	public static String getName(TypeToken tu){
		if (tu == null) return "";
		String res ="";
		EList<ErrorType> te = tu.getType();
		boolean docomma = false;
		for (ErrorType et : te) {
			if (docomma) res = res+"+"; else docomma = true;
			res = res + et.getName();
		}
		return res;
	}
	
	public static String getPrintName(EList<TypeToken> tul){
		String res ="(";
		for (TypeToken tu : tul) {
			res = res + "\n "+getPrintName(tu);
		}
		return res+"\n)";
	}

	/**
	 * get the EBSM referenced in the enclosing context, i.e., by the
	 * component error behavior or composite error behavior declaration
	 * or contained in the element if it is a classifier.
	 * @param element model object contained in a component or composite error behavior declaration
	 * @return ErrorBehaviorStateMachine or null
	 */
	public static ErrorBehaviorStateMachine getUsedErrorBehaviorStateMachine(EObject element) {
		if (element instanceof Classifier){
			Classifier cl = (Classifier)element;
			 return EMV2Util.getClassifierUseBehavior(cl);
		}
		EObject container = element;
		while (container != null && !(container instanceof EBSMUseContext))
			container = container.eContainer();
		if (container == null) return null;
		return getUseBehavior((EBSMUseContext) container);
	}

	/**
	 * resolve the errortype if it is an alias, otherwise return the error type
	 * @param et ErrorType that may be an alias
	 * @return ErrorType without alias
	 */
	public static ErrorType resolveAlias(ErrorType et){
		if (Aadl2Util.isNull(et)) return null;
		while (!Aadl2Util.isNull(et.getAliasedType())){
			et = et.getAliasedType();
		}
		return et;
	}

	/**
	 * resolve the typeset if it is an alias, otherwise return the typeset
	 * @param typeset TypeSet
	 * @return TypeSet resolved TypeSet
	 */
	public static TypeSet resolveAlias(TypeSet typeset){
		if (Aadl2Util.isNull(typeset)) return null;
		if (!Aadl2Util.isNull(typeset.getReference())){
			typeset = typeset.getReference();
		}
		while (!Aadl2Util.isNull(typeset.getAliasedType())){
			typeset = typeset.getAliasedType();
		}
		return typeset;
	}
	
	/**
	 * find the actual ErrorTypes following the alias link
	 * @param et
	 * @return
	 */
	public static ErrorTypes resolveAlias(ErrorTypes et){
		if (Aadl2Util.isNull(et)) return null;
		return (et instanceof ErrorType)?EMV2Util.resolveAlias((ErrorType)et):EMV2Util.resolveAlias((TypeSet)et);
	}
	

	/**
	 *  figure out the target typetoken based on the source and type mappings
	 * Path can be a connection instance, a flow spec instance, or an error flow
	 * @param path connection instance, flow spec instance, error flow
	 * @param path path of mapping
	 * @return TypeToken
	 */
	public static TypeToken mapToken(TypeToken sourceToken,EObject path){
		TypeToken result = sourceToken;
		if (path instanceof ConnectionInstance){
			if (sourceToken != null){
				// TODO lookup type transformations for connections and use them to determine target type
			}
		} else if (path instanceof ErrorPath){
			ErrorPath epath = (ErrorPath)path;
			// map the token
			TypeToken ttup = epath.getTargetToken();
			if (ttup == null){
				// map token via tms
				TypeMappingSet tms = epath.getTypeMappingSet();
				if (tms != null){
					result = EM2TypeSetUtil.mapTypeToken(sourceToken, tms);
				}
			}
		} else if (path instanceof FlowSpecificationInstance){
			// pass on source token
		}
		return result;
	}

	
	/**
	 * get UseBehavior, i.e., the referenced error behavior state machine
	 * @param context
	 * @return ErrorBehaviorStateMachine
	 */
	public static ErrorBehaviorStateMachine getUseBehavior(EBSMUseContext context){
		if (context instanceof ErrorModelSubclause) return ((ErrorModelSubclause)context).getUseBehavior();
		return null;
	}
	
	/**
	 * get list of ErrorModelLibraries listed in UseTypes
	 * @param context Type use context
	 * @return EList<ErrorModelLibrary>
	 */
	public static EList<ErrorModelLibrary> getUseTypes(TypeUseContext context){
		if (context instanceof ErrorModelSubclause) return ((ErrorModelSubclause)context).getUseTypes();
		if (context instanceof TypeTransformationSet) return ((TypeTransformationSet)context).getUseTypes();
		if (context instanceof TypeMappingSet) return ((TypeMappingSet)context).getUseTypes();
		if (context instanceof ErrorBehaviorStateMachine) return ((ErrorBehaviorStateMachine)context).getUseTypes();
		return null;
	}
	
	/**
	 * find the model object that contains the condition expression
	 * @param ce Condition Expression
	 * @return EObject
	 */
	public static EObject getConditionExpressionContext(ConditionExpression ce){
		EObject res = ce;
		while (res instanceof ConditionExpression){
			res = res.eContainer();
		}
		return res;
	}
	
	/** return list of property associations that meet the property name
	 * 
	 * @param props property association list from the properties section
	 * @param propertyName name of property
	 * @return EList<PropertyAssociation>
	 */
	public static List<PropertyAssociation> getProperty(EList<PropertyAssociation> props,String propertyName){
		List<PropertyAssociation> result = new BasicEList<PropertyAssociation>();
		for (PropertyAssociation propertyAssociation : props) {
			Property prop = propertyAssociation.getProperty();
			String name = prop.getQualifiedName();
			if (propertyName.equalsIgnoreCase(name)){
				result.add(propertyAssociation);
			}
		}
		return result;
	}
	
	/**
	 * find property by first looking for it down the component instance hierarchy to ci
	 * Then try to find it in the local context if not null. The context is the context object of the referenced target.
	 * For example: the transition for a state reference.
	 * Finally, we look for the property at the definition site of the referenced object.
	 * NOTE: the target element may actually be contained in a different context from the context in which we are interested in its property.
	 * For example, we are interested in the occurrence distribution for an error state. It actually is contained in an error behavior state machine.
	 * We are interested in its property value in the context of of the reference to the state, e.g., an error source.
	 * In some cases we are interested in the state as it is associated with the component via the use behavior clause.
	 * In that case there is no local context for the state reference.
	 * @param propertyName String
	 * @param ci ComponentInstance the component with the error model element, whose property we are retrieving
	 * @param localContext Element the object that contains the reference to a target object, or null.
	 * @param target Element the target object in the error model whose property we retrieve
	 * @return
	 */
	public static ContainedNamedElement getProperty(String propertyName, ComponentInstance ci,Element localContext,Element target, TypeSet ts){
		ContainedNamedElement result = getPropertyInInstanceHierarchy(propertyName,ci,target,localContext, ts);
		if (result==null&& localContext != null){
			// look up in local context of target reference
			// for example: the flow source in error propagations or transition in component error behavior for a state reference
			EList<PropertyAssociation> props = EMV2Util.getContainingPropertiesHolder(localContext);
			if (props != null) {
				result = getProperty(props, propertyName, target,localContext,ts);
			}
		}
		if (result==null){
			// look up in context of target definition
			// for example: for a state reference the properties section of the EBSM that defines the state
			EList<PropertyAssociation> props = EMV2Util.getContainingPropertiesHolder(target);
			if (props != null) {
				result = getProperty(props, propertyName, target,localContext,ts);
			}
		}
		return result;
	}
	
	
	/**
	 * retrieve an error model property (such as Hazard) attached to an error model element based on contained property associations
	 * in the annex subclause properties section.
	 * Here we come down the component instance hierarchy to find the outmost property association
	 * in the properties section of the annex subclauses. Those are the ones that can override down the component hierarchy.
	 * @param props list of property associations from the properties section in the error model
	 * @param propertyName name of property we are looking for
	 * @param target the error model element (first item in the containment path)
	 * @return property association
	 */
	public static ContainedNamedElement getPropertyInInstanceHierarchy(String propertyName, ComponentInstance ci,Element target, 
			Element localContext, TypeSet ts){
		Stack<ComponentInstance> ciStack = new Stack<ComponentInstance>();
		return getPropertyInInstanceHierarchy(propertyName,ci,target,localContext,ciStack, ts);
	}

	private static ContainedNamedElement getPropertyInInstanceHierarchy(String propertyName, ComponentInstance ci,Element target, 
			Element localContext,Stack<ComponentInstance> ciStack, TypeSet ts){
		ContainedNamedElement result = null;

		if ((ci != null ) && (ci.getContainingComponentInstance() != null)) 
		{
			ciStack.push(ci);
			result = getPropertyInInstanceHierarchy(propertyName, ci.getContainingComponentInstance(), target,localContext,ciStack,ts);
			ciStack.pop();
		}
		if ((ci != null) && (result==null))
		{
			ErrorModelSubclause ems = EMV2Util.getClassifierEMV2Subclause(ci.getComponentClassifier());
			if (ems != null) {
				EList<PropertyAssociation> props = ems.getProperties();
				result = getProperty(props, propertyName, target, localContext,ciStack,ts);
			}
		}
		return result;
	}


	
	/**
	 * retrieve an error model property (such as Hazard) attached to an error model element.
	 * @param props list of property associations from the properties section in the error model
	 * @param propertyName name of property we are looking for
	 * @param target the error model element
	 * @param ciStack stack of nested CI
	 * @return property association
	 */
	public static ContainedNamedElement getProperty(EList<PropertyAssociation> props,String propertyName, Element target,
			Element localContext, Stack<ComponentInstance> ciStack, TypeSet ts){
		if (props == null) return null;
		ContainedNamedElement result = null;
		for (PropertyAssociation propertyAssociation : props) {
			Property prop = propertyAssociation.getProperty();
			String name = prop.getQualifiedName();
			if (propertyName.equalsIgnoreCase(name)){
				result = EMV2Util.isErrorModelElementProperty(propertyAssociation, target,localContext,ciStack,ts);
				if (result!=null)
				return result;
			}
		}
		return result;
	}
	
	/**
	 * retrieve an error model property (such as Hazard) attached to an error model element.
	 * @param props list of property associations from the properties section in the error model
	 * @param propertyName name of property we are looking for
	 * @param target the error model element
	 * @param ciStack stack of nested CI
	 * @return property association
	 */
	public static ContainedNamedElement getProperty(EList<PropertyAssociation> props,String propertyName, Element target,
			Element localContext, TypeSet ts){
		if (props == null) return null;
		ContainedNamedElement result = null;
		for (PropertyAssociation propertyAssociation : props) {
			Property prop = propertyAssociation.getProperty();
			String name = prop.getQualifiedName();
			if (propertyName.equalsIgnoreCase(name)){
				result = EMV2Util.isErrorModelElementProperty(propertyAssociation, target,localContext,null,ts);
				if (result!=null)
				return result;
			}
		}
		return result;
	}
	
	/**
	 * determine whether the property applies to specified error model element or elements contained in it
	 * (typically error types inside an error model element)
	 * ciStack represents the path from the context of the PA to the component instance whose property we want to retrieve
	 * In other words target must be the last or second to last element in a path.
	 * @param propertyAssociation PropertyAssociation that is the candidate
	 * @param ciStack ComponentInstance in instance model hierarchy with the error model element, whose property we are retrieving
	 * @param localContext Element the object that contains the reference to a target object, or null.
	 * @param target Element the target object in the error model whose property we retrieve
	 * @return ContainedNamedElement the containment path that matches
	 */
	public static ContainedNamedElement isErrorModelElementProperty(PropertyAssociation propertyAssociation, Element target, 
			Element localContext,Stack<ComponentInstance> ciStack, TypeSet ts ){
		if (ciStack == null)
		{
			return null;
		}
		EList<ContainedNamedElement> applies = propertyAssociation.getAppliesTos();
		for (ContainedNamedElement containedNamedElement : applies) {
			EList<ContainmentPathElement> cpes = containedNamedElement.getContainmentPathElements();
			int targetsize = (ciStack.size()+1+(localContext==null?0:1));
			boolean match = true;
			if (cpes.size() == targetsize || cpes.size()== targetsize+1){
				for (int i = 0; i< ciStack.size(); i++){
					if (ciStack.get(i).getSubcomponent() != cpes.get(i).getNamedElement()){
						match = false;
						break;
					}
				}
				if (match) {
				// we are past the component portion of the path
				NamedElement targetel = cpes.get(cpes.size()-1).getNamedElement();
				// check on the last element
				boolean typematch = true;
				if (targetel instanceof ErrorTypes){
					// it points to an error type or type set
					if (ts !=null){
						if (targetel instanceof ErrorType){
							// we refer to a type
							if (!EM2TypeSetUtil.contains(ts, (ErrorType)targetel)){
								typematch = false;
							}
						} else if (targetel instanceof TypeSet){
							// we refer to a type
							if (!EM2TypeSetUtil.contains(ts, (TypeSet)targetel)){
								typematch = false;
							}
						}
					}
					if (typematch){
						targetel = cpes.get(cpes.size()-2).getNamedElement();
						if (targetel == target)
							return containedNamedElement;
					}
				} else {
					// last element should be target element
					if ( target == targetel){
						if (localContext != null){
							// make sure the local context matches the previous element in the path
							NamedElement localContextme = cpes.get(cpes.size()-2).getNamedElement();
							if ( localContext == localContextme){
								return containedNamedElement;
							}
						} else {
							return containedNamedElement;
						}
					}
				}
				}
			}
		}
		return null;
	}
	
	/**
	 * get list of error types, one for each containment path
	 * We assume that each path is of length one
	 * @param containedNamedElement Containment path
	 * @return EList<ErrorType>
	 */
	public static ErrorType getContainmentErrorType(ContainedNamedElement containedNamedElement){
			EList<ContainmentPathElement> cpes = containedNamedElement.getContainmentPathElements();
			if (cpes.size()==1){
				ContainmentPathElement cpe = cpes.get(0);
				NamedElement appliestome = cpe.getNamedElement();
				if (appliestome instanceof ErrorType)
					return((ErrorType)appliestome);
			}
		return null;
	}
	
	/**
	 * test only current classifier, not inherited
	 * @param ci
	 * @return
	 */
	public static boolean hasErrorPropagations(ComponentInstance ci){
		return hasErrorPropagations(ci.getComponentClassifier());
	}

	public static boolean hasErrorPropagations(ComponentClassifier cl){
		ErrorModelSubclause ems = getClassifierEMV2Subclause(cl);
		return ems != null && ems.getErrorPropagations() != null;
	}
	
	public static boolean hasComponentErrorBehavior(ComponentInstance ci){
		return hasComponentErrorBehavior(ci.getComponentClassifier());
	}
	
	/**
	 * 
	 * @param cl 	The component classifier that is under test to have
	 * 				an error-annex subclause.
	 * @return		True is the component classifier has an error annex
	 * 				subclause. False otherwise.
	 */
	public static boolean hasComponentErrorBehavior(ComponentClassifier cl){
		ErrorModelSubclause emsc = getClassifierEMV2Subclause(cl);
		return (emsc != null&& emsc.getComponentBehavior() != null);
	}
	
	public static boolean hasCompositeErrorBehavior(ComponentInstance ci){
		return hasCompositeErrorBehavior(ci.getComponentClassifier());
	}
	
	public static boolean hasCompositeErrorBehavior(ComponentClassifier cl){
		ErrorModelSubclause emsc = getClassifierEMV2Subclause(cl);
		return emsc != null&&emsc.getCompositeBehavior() != null;
	}
	
	/**
	 * retrieve list of component instances that have error propagations specified
	 * For process component instances do not recurse below and include the component instance
	 * even if no error propagation is attached.
	 * For other component instances include the component instance if it does not have children even if it does not include
	 * error propagations
	 * @param ci ComponentInstance
	 * @return EList of leaf component instances
	 */
	public static EList<ComponentInstance> getComponentInstancesWithErrorPropagations(ComponentInstance ci){
		EList result = new ForAllElement(){
			@Override
			protected boolean suchThat(Element obj) {
				return (obj instanceof ComponentInstance&&
					(EMV2Util.hasErrorPropagations((ComponentInstance)obj)
							|| ((ComponentInstance)obj).getComponentInstances().isEmpty()
							|| ((ComponentInstance)obj).getCategory() == ComponentCategory.PROCESS
							));
			}
		}.processPreOrderComponentInstanceStop(ci);
		return result ;
	}
	
	/**
	 * retrieve list of component instances that have error propagations specified
	 * For process component instances or component instance without children, do not recurse below and do not include the component instance
	 * @param ci ComponentInstance
	 * @return EList of leaf component instances
	 */
	public static EList<ComponentInstance> getComponentInstancesWithErrorPropagationsOnly(ComponentInstance ci){
		EList result = new ForAllElement(){
			@Override
			protected boolean suchThat(Element obj) {
				return (obj instanceof ComponentInstance&&
					(EMV2Util.hasErrorPropagations((ComponentInstance)obj)
							));
			}
			@Override
			protected boolean processStop (Element theElement) {
				if (suchThat((Element) theElement)) {
					if (theElement instanceof NamedElement){
						//{ System.out.println(((NamedElement) theElement).getName());}
						action((Element) theElement);
						return true;
					}
				}
				if (((ComponentInstance)theElement).getCategory() == ComponentCategory.PROCESS)	{
					return true;
				} else {
					return false;
				}
			}
		}.processPreOrderComponentInstanceStop(ci);
		return result ;
	}
	
	/**
	 * retrieve list of component instances that have component error behavior specified
	 * For process component instances do not recurse below and include the component instance
	 * even if no error propagation is attached.
	 * Foe other component instances include the component instance if it does not have children even if it does not include
	 * error propagations
	 * @param ci ComponentInstance
	 * @return EList of leaf component instances
	 */
	public static EList<ComponentInstance> getComponentInstancesWithComponentErrorBehavior(ComponentInstance ci){
		EList result = new ForAllElement(){
			@Override
			protected boolean suchThat(Element obj) {
				return (obj instanceof ComponentInstance&&
					(EMV2Util.hasComponentErrorBehavior((ComponentInstance)obj)
							|| ((ComponentInstance)obj).getComponentInstances().isEmpty()
							|| ((ComponentInstance)obj).getCategory() == ComponentCategory.PROCESS
							));
			}
		}.processPreOrderComponentInstanceStop(ci);
		return result ;
	}
	
	
	/**
	 * retrieve list of component instances that have component error behavior specified
	 * For process component instances or component instance without children, do not recurse below and do not include the component instance
	 * @param ci ComponentInstance
	 * @return EList of leaf component instances
	 */
	public static EList<ComponentInstance> getComponentInstancesWithComponentErrorBehaviorOnly(ComponentInstance ci){
		EList result = new ForAllElement(){
			@Override
			protected boolean suchThat(Element obj) {
				return (obj instanceof ComponentInstance&&
					(EMV2Util.hasComponentErrorBehavior((ComponentInstance)obj)
							));
			}
			@Override
			protected boolean processStop (Element theElement) {
				if (suchThat((Element) theElement)) {
					if (theElement instanceof NamedElement){
						//{ System.out.println(((NamedElement) theElement).getName());}
						action((Element) theElement);
						return true;
					}
				}
				if (((ComponentInstance)theElement).getCategory() == ComponentCategory.PROCESS)	{
					return true;
				} else {
					return false;
				}
			}
		}.processPreOrderComponentInstanceStop(ci);
		return result ;
	}

	
	/**
	 * retrieve list of component instances that have composite error behavior specified
	 * For process component instances do not recurse below and include the component instance
	 * even if no error propagation is attached.
	 * Foe other component instances include the component instance if it does not have children even if it does not include
	 * error propagations
	 * @param ci ComponentInstance
	 * @return EList of leaf component instances
	 */
	public static EList<ComponentInstance> getCompositeInstancesWithComponentErrorBehavior(ComponentInstance ci){
		EList result = new ForAllElement(){
			@Override
			protected boolean suchThat(Element obj) {
				return (obj instanceof ComponentInstance&&
					(EMV2Util.hasCompositeErrorBehavior((ComponentInstance)obj)
							|| ((ComponentInstance)obj).getComponentInstances().isEmpty()
							|| ((ComponentInstance)obj).getCategory() == ComponentCategory.PROCESS
							));
			}
		}.processPreOrderComponentInstanceStop(ci);
		return result ;
	}
	
	/**
	 * retrieve list of component instances that have composite error behavior specified
	 * For process component instances or component instance without children, do not recurse below and do not include the component instance
	 * @param ci ComponentInstance
	 * @return EList of leaf component instances
	 */
	public static EList<ComponentInstance> getComponentInstancesWithhasCompositeErrorBehaviorOnly(ComponentInstance ci){
		EList result = new ForAllElement(){
			@Override
			protected boolean suchThat(Element obj) {
				return (obj instanceof ComponentInstance&&
					(EMV2Util.hasCompositeErrorBehavior((ComponentInstance)obj)
							));
			}
			@Override
			protected boolean processStop (Element theElement) {
				if (suchThat((Element) theElement)) {
					if (theElement instanceof NamedElement){
						//{ System.out.println(((NamedElement) theElement).getName());}
						action((Element) theElement);
						return true;
					}
				}
				if (((ComponentInstance)theElement).getCategory() == ComponentCategory.PROCESS)	{
					return true;
				} else {
					return false;
				}
			}
		}.processPreOrderComponentInstanceStop(ci);
		return result ;
	}
	
	/**
	 * returns the feature instance in the component instance that is referenced by the Error Propagation (or Containment)
	 * @param ep
	 * @param ci
	 * @return
	 */
	public static FeatureInstance findFeatureInstance(ErrorPropagation ep, ComponentInstance ci){
		EList<FeatureReference> frefs = ep.getFeaturerefs();
		if (frefs.isEmpty()) return null;
		InstanceObject container = ci;
		for (FeatureReference featureReference : frefs) {
			NamedElement ne = featureReference.getFeature();
			if (ne instanceof Feature){
				Feature fe = (Feature)ne;
				FeatureInstance fi = (container instanceof ComponentInstance?
						((ComponentInstance)container).findFeatureInstance(fe):
							((FeatureInstance)container).findFeatureInstance(fe));
				if (fi != null){
					container = fi;
				} else {
					return null;
				}
			} else {
				return null;
			}
		}
		return (FeatureInstance)container;
	}
	
	/**
	 * returns the feature instance in the component instance that is referenced by the Error Propagation (or Containment)
	 * @param ep
	 * @param ci
	 * @return
	 */
	public static NamedElement getErrorPropagationPoint(ErrorPropagation ep, ComponentInstance ci){
		EList<FeatureReference> frefs = ep.getFeaturerefs();
		if (frefs.isEmpty()) return ci;
		return frefs.get(frefs.size()-1).getFeature();
	}
	
	/**
	 * return true if error propagation points to feature instance
	 * @param ep Error Propagation (or Containment)
	 * @param fi Feature Instance
	 * @return Boolean
	 */
	public static boolean isErrorPropagationOf(ErrorPropagation ep, FeatureInstance fi){
		Feature fif = fi.getFeature();
		if (Aadl2Util.isNull(fif)) return false;
		EList<FeatureReference> frefs = ep.getFeaturerefs();
		if (frefs.isEmpty()) return false;
		for (int i = frefs.size()-1; i >0; i--) {
			FeatureReference fref = frefs.get(i);
			if (Aadl2Util.isNull(fref.getFeature())||fref.getFeature() != fi.getFeature()){
				return false;
			}
		}
		return true;
	}
	

}
