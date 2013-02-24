package org.osate.xtext.aadl2.errormodel.util;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.BasicProperty;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Element;
import org.osate.aadl2.Feature;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.modelsupport.modeltraversal.ForAllElement;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.xtext.aadl2.errormodel.errorModel.ComponentErrorBehavior;
import org.osate.xtext.aadl2.errormodel.errorModel.CompositeErrorBehavior;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.EBSMUseContext;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
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
import org.osate.xtext.aadl2.errormodel.errorModel.TypeMappingSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeTransformationSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeUseContext;

public class EM2Util {
	
	public static String ErrorModelAnnexName = "EMV2";

	public static ContainedNamedElement getOccurenceDistributionProperty(ComponentInstance ci, NamedElement localContext,NamedElement target, TypeSet ts){
		ContainedNamedElement result =  EM2Util.getProperty("EMV2::OccurrenceDistribution",ci,localContext,target,ts);
		return result;
	}
	
	/*
	 * Retrieve the value associated with a containment path
	 * See RDB action to see how it is used.
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
	 * get ErrorModelSubclause object that contains the element object.
	 * @param element error annex element
	 * @return ErrorModelSubclause
	 */
	public static ErrorModelSubclause getContainingErrorModelSubclause(EObject element) {
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
	public static ErrorPropagations getContainingErrorPropagations(EObject element) {
		EObject container = element;
		while (container != null && !(container instanceof ErrorPropagations))
			container = container.eContainer();
		return (ErrorPropagations) container;
	}

	

	/**
	 * get enclosing object within the error annex that is a property list holder.
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
	 * get error propagations object in the classifier containing the element object.
	 * The extends hierarchy and the type in the case of an implementation are searched for the error propagations declaration
	 * This object contains the list of propagations and error flows.
	 * @param element declarative model element or error annex element
	 * @return ErrorPropagations
	 */
	public static ErrorPropagations getContainingClassifierErrorPropagations(EObject element) {
		ErrorPropagations result = null;
		Classifier cl = AadlUtil.getContainingClassifier(element);
		if (cl == null) return null;
		ErrorModelSubclause ems = getErrorModelSubclause(cl);
		if (ems != null) result = ems.getPropagation();
		if (result != null) return result;
		if (cl instanceof ComponentImplementation){
			ems = getErrorModelSubclause(((ComponentImplementation)cl).getType());
			if (ems != null) result = ems.getPropagation();
			if (result != null) return result;
		}
		if (!Aadl2Util.isNull(cl.getExtended())){
			return  getContainingClassifierErrorPropagations(cl.getExtended());
		}
		return null;
	}

	/**
	 * get ErrorModelSubclause object in the classifier containing the element object.
	 * The extends hierarchy and the type in the case of an implementation are searched for the ErrorModelSubclause
	 * @param element declarative model element or error annex element
	 * @return ErrorModelSubclause
	 */
	public static ErrorModelSubclause getContainingClassifierEMV2Subclause(EObject element) {
		Classifier cl = AadlUtil.getContainingClassifier(element);
		if (cl == null) return null;
		ErrorModelSubclause ems = getErrorModelSubclause(cl);
		if (ems != null) return ems;
		if (cl instanceof ComponentImplementation){
			ems = getErrorModelSubclause(((ComponentImplementation)cl).getType());
			if (ems != null) return ems;
		}
		if (!Aadl2Util.isNull(cl.getExtended())){
			return  getContainingClassifierEMV2Subclause(cl.getExtended());
		}
		return null;
	}
	
	/**
	 * find the error propagation point of the specified name
	 * @param eps List of error propagations
	 * @param eppName Name of error propagation point we are looking for
	 * @param pd Directiontype
	 * @param isNot boolean Error Containment
	 * @return ErrorPropagation
	 */
	public static ErrorPropagation findErrorPropagation(ErrorPropagations eps, String eppName, DirectionType pd, boolean isNot){
		for (ErrorPropagation ep : eps.getPropagations()) {
			Feature f = ep.getFeature();
			if (ep.isNot() == isNot && ep.getDirection() == pd && !Aadl2Util.isNull(f)&&(eppName.equalsIgnoreCase(f.getName())||eppName.equalsIgnoreCase(ep.getKind()))){
				return ep;
			}
		}
		return null;
	}
	
	/**
	 * find the outgoing error propagation point of the specified name
	 * @param eps List of error propagations
	 * @param eppName Name of error propagation point we are looking for
	 * @return ErrorPropagation
	 */
	public static ErrorPropagation findIncomingErrorPropagation(ErrorPropagations eps, String eppName){
		return findErrorPropagation(eps, eppName, DirectionType.IN,false);
	}
	
	/**
	 * find the outgoing error propagation point of the specified name
	 * @param eps List of error propagations
	 * @param eppName Name of error propagation point we are looking for
	 * @return ErrorPropagation
	 */
	public static ErrorPropagation findOutgoingErrorPropagation(ErrorPropagations eps, String eppName){
		return findErrorPropagation(eps, eppName, DirectionType.OUT,false);
	}
	
	/**
	 * find the outgoing error containment point of the specified name
	 * @param eps List of error propagations
	 * @param eppName Name of error containment point we are looking for
	 * @return ErrorPropagation
	 */
	public static ErrorPropagation findIncomingErrorContainment(ErrorPropagations eps, String eppName){
		return findErrorPropagation(eps, eppName, DirectionType.IN,true);
	}
	
	/**
	 * find the outgoing error containment point of the specified name
	 * @param eps List of error propagations
	 * @param eppName Name of error containment point we are looking for
	 * @return ErrorPropagation
	 */
	public static ErrorPropagation findOutgoingErrorContainment(ErrorPropagations eps, String eppName){
		return findErrorPropagation(eps, eppName, DirectionType.OUT,true);
	}
	
	/**
	 * Get outgoing error propagation associated with feature instance
	 * @param fi feature instance
	 * @return error propagation
	 */
	public static ErrorPropagation getOutgoingErrorPropagation(FeatureInstance fi){
		ComponentInstance ci = fi.getContainingComponentInstance();
		ErrorPropagations eps = EM2Util.getContainingClassifierErrorPropagations(ci.getComponentClassifier());
		ErrorPropagation ep = EM2Util.findOutgoingErrorPropagation(eps, fi.getName());
		return ep;
	}
	
	/**
	 * Get incoming error propagation associated with feature instance
	 * @param fi feature instance
	 * @return error propagation
	 */
	public static ErrorPropagation getIncomingErrorPropagation(FeatureInstance fi){
		ComponentInstance ci = fi.getContainingComponentInstance();
		ErrorPropagations eps = EM2Util.getContainingClassifierErrorPropagations(ci.getComponentClassifier());
		ErrorPropagation ep = EM2Util.findIncomingErrorPropagation(eps, fi.getName());
		return ep;
	}
	
	/**
	 * Get incoming error propagation associated with component instance access
	 * @param ci component instance
	 * @return error propagation
	 */
	public static ErrorPropagation getIncomingAccessErrorPropagation(ComponentInstance ci){
		ErrorPropagations eps = EM2Util.getContainingClassifierErrorPropagations(ci.getComponentClassifier());
		ErrorPropagation ep = EM2Util.findIncomingErrorPropagation(eps, "access");
		return ep;
	}
	
	/**
	 * Get outgoing error propagation associated with component instance access
	 * @param ci component instance
	 * @return error propagation
	 */
	public static ErrorPropagation getOutgoingAccessErrorPropagation(ComponentInstance ci){
		ErrorPropagations eps = EM2Util.getContainingClassifierErrorPropagations(ci.getComponentClassifier());
		ErrorPropagation ep = EM2Util.findOutgoingErrorPropagation(eps, "access");
		return ep;
	}

	/**
	 * find the error flow whose incoming error propagation point is incie
	 * @param eps List of error propagations
	 * @param incie connection instance end, which can be a component instance or feature instance
	 * @return ErrorFlow
	 */
	public static ErrorFlow findErrorFlow(ErrorPropagations eps, InstanceObject incie){
		for (ErrorFlow ef : eps.getFlows()) {
			Feature f = null;
			if (ef instanceof ErrorPath){
				ErrorPath ep = (ErrorPath)ef;
				 f = ep.getIncoming().getFeature();
			} else if (ef instanceof ErrorSink){
				ErrorSink es = (ErrorSink)ef;
				 f = es.getIncoming().getFeature();
			}
			if (incie instanceof FeatureInstance){
				if (((FeatureInstance)incie).getFeature().equals(f)){
					return ef;
				}
			}
		}
		return null;
	}

	/**
	 * find the error flow whose outgoing error propagation point is incie
	 * @param eps List of error propagations
	 * @param incie connection instance end, which can be a component instance or feature instance
	 * @return ErrorFlow
	 */
	public static ErrorFlow findReverseErrorFlow(ErrorPropagations eps, InstanceObject incie){
		for (ErrorFlow ef : eps.getFlows()) {
			Feature f = null;
			if (ef instanceof ErrorPath){
				ErrorPath ep = (ErrorPath)ef;
				 f = ep.getOutgoing().getFeature();
			} else if (ef instanceof ErrorSource){
				ErrorSource es = (ErrorSource)ef;
				 f = es.getOutgoing().getFeature();
			}
			if (incie instanceof FeatureInstance){
				if (((FeatureInstance)incie).getFeature().equals(f)){
					return ef;
				}
			}
		}
		return null;
	}

	
	/**
	 * return list of error sources
	 * @param eps error propagations
	 * @return EList<ErrorSource> list of error sources
	 */
	public static EList<ErrorSource> getErrorSources(ErrorPropagations eps){
		EList<ErrorSource> result = new BasicEList<ErrorSource>();
		EList<ErrorFlow> flows = eps.getFlows();
		for (ErrorFlow errorFlow : flows) {
			if (errorFlow instanceof ErrorSource)
				result.add((ErrorSource)errorFlow);
		}
		return result;
	}

	/**
	 * get the EM object that contains the condition expression.
	 * Traverses up the expression tree to the enclosing EM object
	 * @param element
	 * @return Error Model object that contains the expression
	 */
	public static EObject getConditionOwner(EObject element) {
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
	public static ErrorBehaviorStateMachine getContainingErrorBehaviorStateMachine(EObject element) {
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
	public static ErrorModelLibrary getContainingErrorModelLibrary(EObject element) {
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
	public static TypeUseContext getContainingTypeUseContext(EObject element) {
		EObject container = element;
		while (container != null && !(container instanceof TypeUseContext))
			container = container.eContainer();
		return (TypeUseContext) container;
	}
	
	
	/**
	 * get containing component error behavior specification
	 * @param element
	 * @return ComponentErrorBehavior or null
	 */
	public static ComponentErrorBehavior getContainingSubclauseComponentErrorBehavior(EObject element){
		ErrorModelSubclause emsc = getContainingErrorModelSubclause(element);
		return emsc ==null?null:(ComponentErrorBehavior) emsc.getComponentBehavior();
	}

	/**
	 * get containing component error behavior specification
	 * @param element
	 * @return ComponentErrorBehavior or null
	 */
	public static ComponentErrorBehavior getContainingComponentErrorBehavior(EObject element){
		EObject container = element;
		while (container != null && !(container instanceof ComponentErrorBehavior))
			container = container.eContainer();
		return (ComponentErrorBehavior) container;
	}

	/**
	 * get the error model subclause for the specified classifier.
	 * Looks for it in classifier being extended if not found.
	 * If not found there then look for it in the component type if the classifier was an implementation.
	 * @param cl CLassifier
	 * @return
	 */
	public static ErrorModelSubclause getErrorModelSubclause(Classifier cl){
		if (cl == null) return null;
		EList<AnnexSubclause> asl = cl.getOwnedAnnexSubclauses();
		for (AnnexSubclause al : asl){
			if (al instanceof ErrorModelSubclause){
				return ((ErrorModelSubclause)al);
			}
		}
		if (!Aadl2Util.isNull(cl.getExtended())){
			return getErrorModelSubclause(cl.getExtended());
		}
		if (cl instanceof ComponentImplementation){
			return getErrorModelSubclause(((ComponentImplementation)cl).getType());
		}
		return null;
	}

	/**
	 * extract the item name from a qualified name, the identifier after the last ::
	 * @param qualname String Qualified name
	 * @return String item name 
	 */
	public static String getItemName(String qualname){
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
	
	public static String getPrintName(NamedElement ne){
		if (ne.getName() != null) return ne.getName();
		if (ne instanceof ErrorPropagation){
			ErrorPropagation ep = (ErrorPropagation)ne;
		if (!Aadl2Util.isNull(ep.getFeature())) return ep.getFeature().getName();
		if (ep.getKind() != null) return ep.getKind();
		}
		return "";
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
	 * @param element model object contained in a component or composite error behavior declaration
	 * @return ErrorBehaviorStateMachine or null
	 */
	public static ErrorBehaviorStateMachine getUsedErrorBehaviorStateMachine(EObject element) {
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
		return (et instanceof ErrorType)?EM2Util.resolveAlias((ErrorType)et):EM2Util.resolveAlias((TypeSet)et);
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
	public static ContainedNamedElement getProperty(String propertyName, ComponentInstance ci,NamedElement localContext,NamedElement target, TypeSet ts){
		ContainedNamedElement result = getPropertyInInstanceHierarchy(propertyName,ci,target,localContext, ts);
		if (result==null&& localContext != null){
			// look up in local context of target reference
			// for example: the flow source in error propagations or transition in component error behavior for a state reference
			EList<PropertyAssociation> props = EM2Util.getContainingPropertiesHolder(localContext);
			if (props != null) {
				result = getProperty(props, propertyName, target,localContext,ts);
			}
		}
		if (result==null){
			// look up in context of target definition
			// for example: for a state reference the properties section of the EBSM that defines the state
			EList<PropertyAssociation> props = EM2Util.getContainingPropertiesHolder(target);
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
	 * @param target the error model element (first item in teh containment path)
	 * @return property association
	 */
	public static ContainedNamedElement getPropertyInInstanceHierarchy(String propertyName, ComponentInstance ci,NamedElement target, 
			NamedElement localContext, TypeSet ts){
		Stack<ComponentInstance> ciStack = new Stack<ComponentInstance>();
		return getPropertyInInstanceHierarchy(propertyName,ci,target,localContext,ciStack, ts);
	}

	private static ContainedNamedElement getPropertyInInstanceHierarchy(String propertyName, ComponentInstance ci,NamedElement target, 
			NamedElement localContext,Stack<ComponentInstance> ciStack, TypeSet ts){
		ContainedNamedElement result = null;

		if (ci.getContainingComponentInstance() != null) {
			ciStack.push(ci);
			result = getPropertyInInstanceHierarchy(propertyName, ci.getContainingComponentInstance(), target,localContext,ciStack,ts);
			ciStack.pop();
		}
		if (result==null){
			ErrorModelSubclause ems = EM2Util.getContainingClassifierEMV2Subclause(ci.getComponentClassifier());
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
	public static ContainedNamedElement getProperty(EList<PropertyAssociation> props,String propertyName, NamedElement target,
			NamedElement localContext, Stack<ComponentInstance> ciStack, TypeSet ts){
		if (props == null) return null;
		ContainedNamedElement result = null;
		for (PropertyAssociation propertyAssociation : props) {
			Property prop = propertyAssociation.getProperty();
			String name = prop.getQualifiedName();
			if (propertyName.equalsIgnoreCase(name)){
				result = EM2Util.isErrorModelElementProperty(propertyAssociation, target,localContext,ciStack,ts);
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
	public static ContainedNamedElement getProperty(EList<PropertyAssociation> props,String propertyName, NamedElement target,
			NamedElement localContext, TypeSet ts){
		if (props == null) return null;
		ContainedNamedElement result = null;
		for (PropertyAssociation propertyAssociation : props) {
			Property prop = propertyAssociation.getProperty();
			String name = prop.getQualifiedName();
			if (propertyName.equalsIgnoreCase(name)){
				result = EM2Util.isErrorModelElementProperty(propertyAssociation, target,localContext,null,ts);
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
	public static ContainedNamedElement isErrorModelElementProperty(PropertyAssociation propertyAssociation, NamedElement target, 
			NamedElement localContext,Stack<ComponentInstance> ciStack, TypeSet ts ){
		EList<ContainedNamedElement> applies = propertyAssociation.getAppliesTos();
		for (ContainedNamedElement containedNamedElement : applies) {
			EList<ContainmentPathElement> cpes = containedNamedElement.getContainmentPathElements();
			int targetsize = (ciStack.size()+1+(localContext==null?0:1));
			boolean nomatch = false;
			if (cpes.size() == targetsize || cpes.size()== targetsize+1){
				for (int i = 0; i< ciStack.size(); i++){
					if (ciStack.get(i).getSubcomponent() != cpes.get(i).getNamedElement()){
						nomatch = true;
						break;
					}
				}
				if (nomatch) break;
				// we are past the component portion of the path
				NamedElement targetel = cpes.get(cpes.size()-1).getNamedElement();
				// check on the last element
				if (targetel instanceof ErrorTypes){
					// it points to an error type or type set
					if (ts !=null){
						if (targetel instanceof ErrorType){
							// we refer to a type
							if (!EM2TypeSetUtil.contains(ts, (ErrorType)targetel)){
								break;
							}
						} else if (targetel instanceof TypeSet){
							// we refer to a type
							if (!EM2TypeSetUtil.contains(ts, (TypeSet)targetel)){
								break;
							}
						}
					}
					targetel = cpes.get(cpes.size()-2).getNamedElement();
					if (targetel == target)
						return containedNamedElement;
				} else {
					// last element should be target element
					if ( target == targetel){
						if (localContext != null){
							// make sure the local context matches the previous element in the path
							NamedElement localContextme = cpes.get(cpes.size()-2).getNamedElement();
							if ( localContext != localContextme){
								break;
							} else {
								return containedNamedElement;
							}
						} else {
							return containedNamedElement;
						}
					} else {
						break;
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
	
	
	public static BasicPropertyAssociation getRecordField(EList<BasicPropertyAssociation> props,String fieldName){
		for (BasicPropertyAssociation propertyAssociation : props) {
			BasicProperty prop = propertyAssociation.getProperty();
			String name = prop.getName();
			if (fieldName.equalsIgnoreCase(name)){
				return propertyAssociation;
			}
		}
		return null;
	}
	
	public static boolean hasErrorPropagations(ComponentInstance ci){
		return hasErrorPropagations(ci.getComponentClassifier());
	}

	public static boolean hasErrorPropagations(ComponentClassifier cl){
		return EM2Util.getContainingClassifierErrorPropagations(cl) != null;
	}
	
	public static boolean hasComponentErrorBehavior(ComponentInstance ci){
		return hasComponentErrorBehavior(ci.getComponentClassifier());
	}
	
	public static boolean hasComponentErrorBehavior(ComponentClassifier cl){
		ErrorModelSubclause emsc = getErrorModelSubclause(cl);
		return emsc.getComponentBehavior() != null;
	}
	
	public static boolean hasCompositeErrorBehavior(ComponentInstance ci){
		return hasCompositeErrorBehavior(ci.getComponentClassifier());
	}
	
	public static boolean hasCompositeErrorBehavior(ComponentClassifier cl){
		ErrorModelSubclause emsc = getErrorModelSubclause(cl);
		return emsc.getCompositeBehavior() != null;
	}
	
	public static ErrorPropagations getErrorPropagations(ComponentInstance ci){
		return getErrorPropagations(ci.getComponentClassifier());
	}

	public static ErrorPropagations getErrorPropagations(Classifier cl){
		return EM2Util.getContainingClassifierErrorPropagations(cl);
	}
	
	public static ComponentErrorBehavior getComponentErrorBehavior(ComponentInstance ci){
		return getComponentErrorBehavior(ci.getComponentClassifier());
	}
	
	public static ComponentErrorBehavior getComponentErrorBehavior(Classifier cl){
		ErrorModelSubclause emsc = getErrorModelSubclause(cl);
		return emsc.getComponentBehavior();
	}
	
	public static CompositeErrorBehavior getCompositeErrorBehavior(ComponentInstance ci){
		return getCompositeErrorBehavior(ci.getComponentClassifier());
	}
	
	public static CompositeErrorBehavior getCompositeErrorBehavior(Classifier cl){
		ErrorModelSubclause emsc = getErrorModelSubclause(cl);
		return emsc.getCompositeBehavior();
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
					(EM2Util.hasErrorPropagations((ComponentInstance)obj)
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
					(EM2Util.hasErrorPropagations((ComponentInstance)obj)
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
					(EM2Util.hasComponentErrorBehavior((ComponentInstance)obj)
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
					(EM2Util.hasComponentErrorBehavior((ComponentInstance)obj)
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
					(EM2Util.hasCompositeErrorBehavior((ComponentInstance)obj)
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
					(EM2Util.hasCompositeErrorBehavior((ComponentInstance)obj)
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

}
