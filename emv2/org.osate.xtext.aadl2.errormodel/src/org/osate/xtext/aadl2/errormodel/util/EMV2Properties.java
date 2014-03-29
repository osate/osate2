package org.osate.xtext.aadl2.errormodel.util;

import java.util.List;
import java.util.Stack;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.Element;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.util.OsateDebug;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.properties.util.GetProperties;
import org.osate.xtext.aadl2.properties.util.InstanceModelUtil;

public class EMV2Properties {

	public static final String INVALID_OCCURRENCE_TYPE = "unknown_distribution";


	
	/**
	 * retrieve the probability
	 * @param ci component instance, subcomponent, or classifier
	 * @param ne named element for which we retrieve the probability
	 * @param ts type set
	 * @return
	 */
	public static double getProbability (NamedElement ci, NamedElement ne, TypeSet ts)
	{
		EList<ContainedNamedElement> PA = EMV2Properties.getOccurenceDistributionProperty(ci,ne,ts);
		double prob = 0;
		if (!PA.isEmpty()){
			prob = EMV2Properties.getOccurenceValue (PA.get(0));
		}
		return prob;
	}
	
	/**
	 * 
	 * @param element - the EMV2 element that refers to the artifact
	 * @param relatedComponent - the component (instance, subcomponent or classifier that have the property association
	 * @return - the text related to the description part of the hazards property. Null if not defined
	 */
	public static String getDescription (NamedElement element, NamedElement relatedComponent)
	{
		TypeSet ts = null;
		
		if (element instanceof ErrorBehaviorState)
		{
			ts = ((ErrorBehaviorState)element).getTypeSet();
		}
		
		if (element instanceof ErrorPropagation)
		{
			ts = ((ErrorPropagation)element).getTypeSet();
		}
		
		if (element instanceof ErrorEvent)
		{
			ts = ((ErrorEvent)element).getTypeSet();
		}
		
		EList<ContainedNamedElement> PA = EMV2Properties.getHazardsProperty(relatedComponent,element,ts);
		
		if (PA.isEmpty())
		{
			return null;
		}
		// XXX TODO we may get more than one back, one each for different types
		for (ModalPropertyValue modalPropertyValue : AadlUtil.getContainingPropertyAssociation(PA.get(0)).getOwnedValues()) {
			PropertyExpression val = modalPropertyValue.getOwnedValue();
			if (val instanceof RecordValue)
			{
				RecordValue rv = (RecordValue)val;
				EList<BasicPropertyAssociation> fields = rv.getOwnedFieldValues();
				BasicPropertyAssociation xref = GetProperties.getRecordField(fields, "description");
				if (xref != null){
					PropertyExpression peVal = xref.getOwnedValue();
					if (peVal instanceof StringLiteral){
						String text = ((StringLiteral)peVal).getValue();
						text = text.replace('\"', ' ');
						return text;
					}
				} 
			}
			if (val instanceof ListValue)
			{
				ListValue lv = (ListValue)val;
				for (PropertyExpression pe : lv.getOwnedListElements())
				{
					if (pe instanceof RecordValue)
					{
						RecordValue rv = (RecordValue) pe;
						EList<BasicPropertyAssociation> fields = rv.getOwnedFieldValues();
						BasicPropertyAssociation xref = GetProperties.getRecordField(fields, "description");
						if (xref != null){
							PropertyExpression peVal = xref.getOwnedValue();
							if (peVal instanceof StringLiteral){
								String text = ((StringLiteral)peVal).getValue();
								text = text.replace('\"', ' ');
								return text;
							}
						} 
					}
				}
			}
		}
		return null;
	}
	
	
	/**
	 * 
	 * @param element - the EMV2 element that referes to the artifact
	 * @param relatedComponent - the component the component (instance, subcomponent or classifier) that have the property association
	 * @return - the text related to the failure part of the hazards property. Null if not defined
	 */
	public static String getFailure (NamedElement element, NamedElement relatedComponent)
	{
		TypeSet ts = null;
		
		if (element instanceof ErrorBehaviorState)
		{
			ts = ((ErrorBehaviorState)element).getTypeSet();
		}
		
		if (element instanceof ErrorPropagation)
		{
			ts = ((ErrorPropagation)element).getTypeSet();
		}
		
		if (element instanceof ErrorEvent)
		{
			ts = ((ErrorEvent)element).getTypeSet();
		}
		
		EList<ContainedNamedElement> PA = EMV2Properties.getHazardsProperty(relatedComponent,element,ts);
		
		if (PA.isEmpty())
		{
			return null;
		}
		// XXX TODO we may get more than one back, one each for different types
		for (ModalPropertyValue modalPropertyValue : AadlUtil.getContainingPropertyAssociation(PA.get(0)).getOwnedValues()) {
			PropertyExpression val = modalPropertyValue.getOwnedValue();
			if (val instanceof RecordValue)
			{
				RecordValue rv = (RecordValue)val;
				EList<BasicPropertyAssociation> fields = rv.getOwnedFieldValues();
				BasicPropertyAssociation xref = GetProperties.getRecordField(fields, "failure");
				if (xref != null){
					PropertyExpression peVal = xref.getOwnedValue();
					if (peVal instanceof StringLiteral){
						String text = ((StringLiteral)peVal).getValue();
						text = text.replace('\"', ' ');
						return text;
					}
				} 
			}
			if (val instanceof ListValue)
			{
				ListValue lv = (ListValue)val;
				for (PropertyExpression pe : lv.getOwnedListElements())
				{
					if (pe instanceof RecordValue)
					{
						RecordValue rv = (RecordValue) pe;
						EList<BasicPropertyAssociation> fields = rv.getOwnedFieldValues();
						BasicPropertyAssociation xref = GetProperties.getRecordField(fields, "failure");
						if (xref != null){
							PropertyExpression peVal = xref.getOwnedValue();
							if (peVal instanceof StringLiteral){
								String text = ((StringLiteral)peVal).getValue();
								text = text.replace('\"', ' ');
								return text;
							}
						} 
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * retrieve the hazards property
	 * @param ci Component instance, subcomponent or classifier
	 * @param target target error model element
	 * @param ts TypeSet
	 * @return
	 */
	public static EList<ContainedNamedElement> getHazardsProperty(NamedElement ci, Element target, TypeSet ts){
		EList<ContainedNamedElement> result =  getProperty("EMV2::hazards",ci,target,ts);
		if (result.isEmpty()) result =  getProperty("ARP4761::hazards",ci,target,ts);
		if (result.isEmpty()) result =  getProperty("MILSTD882::hazards",ci,target,ts);
		return result;
	}

	/**
	 * Retrieve the value of the OccurenceDistribution property of the
	 * EMV2 property. You can use it like this:
	 * 	ContainedNamedElement PA = EM2Util.getOccurenceDistributionProperty(instance,null,ee,null);
	 * res = EM2Util.getOccurenceValue (PA);
	 * 
	 * @see		Util
	 * @param 	ci				Component instance, subcomponent or classifier that contains the property
	 * @param target			the property
	 * @param ts				corresponding typeset or null
	 * @return
	 */
	public static EList<ContainedNamedElement> getOccurenceDistributionProperty(NamedElement ci, NamedElement target, TypeSet ts){
		EList<ContainedNamedElement> result =  getProperty("EMV2::OccurrenceDistribution",ci,target,ts);
		
		if (result.size() == 0)
		{
			ComponentCategory cat = null;
			if (ci instanceof ComponentInstance){
				cat = ((ComponentInstance)ci).getComponentClassifier().getCategory();
				// processor binding for instances only
//			} else if (ci instanceof Subcomponent){
//				cat = ((Subcomponent)ci).getCategory();
//			} else if (ci instanceof ComponentClassifier){
//				cat = ((ComponentClassifier)ci).getCategory();
			} else {
				return result;
			}
			if ((cat == ComponentCategory.PROCESS)||
					(cat == ComponentCategory.ABSTRACT) ||
					(cat == ComponentCategory.VIRTUAL_PROCESSOR) ||
					(cat == ComponentCategory.SYSTEM))
			{
				List<ComponentInstance> cpus = InstanceModelUtil.getProcessorBinding((ComponentInstance)ci);
				ComponentInstance cpu = cpus.isEmpty() ? null : cpus.get(0);
				if (cpu != null)
				{
					return getOccurenceDistributionProperty(cpu,  target, ts);
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
	 * get list of property associations in enclosing object within the error annex that has a properties section.
	 * ErrorModelLibrary, ErrorBehaviorStateMachine have properties sections
	 * Note: we assume the PA list in the subclause has been handled.
	 * @param element declarative model element or error annex element
	 * @return PS list of ErrorModelLibrary, ErrorBehaviorStateMachine
	 */
	public static EList<PropertyAssociation> getPropertyAssociationListInContext(Element element) {
		EObject container = element;
		while (container != null ){
//			if (container instanceof ErrorModelSubclause ){
//				return ((ErrorModelSubclause)container).getProperties();
//			}
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

	/** return list of property associations that meet the property name
	 * 
	 * @param props property association list from the properties section
	 * @param propertyName name of property
	 * @return EList<PropertyAssociation>
	 */
	public static List<PropertyAssociation> getPropertyAssociationsMatchingName(EList<PropertyAssociation> props,String propertyName){
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
	 * return containment path of all PA in list that match the target.
	 * Should be only one matching.
	 * @param props list of property associations from the properties section in the error model of ci
	 * @param propertyName name of property we are looking for
	 * @param target the error model element
	 * @param ciStack stack of nested CI below the ci of the props; those names may show up in the path
	 * @return list of paths
	 */
	public static EList<ContainedNamedElement> getMatchingPropertiesInList(EList<PropertyAssociation> props,String propertyName, Element target,
			 Stack<NamedElement> ciStack, TypeSet ts){
		if (props.isEmpty()  ) return new BasicEList<ContainedNamedElement>();
		EList<ContainedNamedElement> result = new BasicEList<ContainedNamedElement>();
		for (PropertyAssociation propertyAssociation : props) {
			Property prop = propertyAssociation.getProperty();
			String name = prop.getQualifiedName();
			if (propertyName.equalsIgnoreCase(name)){
				ContainedNamedElement res = isErrorModelElementProperty(propertyAssociation, target,ciStack,ts);
				if (res!=null)
				result.add(res);
			}
		}
		return result;
	}
	
	/**
	 * check to see if the first part of the path matches the stack.
	 * Note, the order of items on the stack is the inverse of that in the path.
	 * If ciStack is null or empty return true.
	 * @param ciStack
	 * @param cpes
	 * @return
	 */
	private static boolean matchCIStack(Stack<NamedElement> ciStack,EList<ContainmentPathElement> cpes){
		if (ciStack == null || ciStack.isEmpty())
		{
			return true;
		}
		int offset = ciStack.size()-1;
		int idx;
		for (int i = 0; i< ciStack.size(); i++)
		{
			idx = offset - i;
			/**
			 * Check that we does not go into out of bounds
			 * and raise an exception.
			 * FIXME-JD: check if this logic is correct.
			 */
			if (idx >= cpes.size())
			{
				return false;
			}
			NamedElement el = ciStack.get(i);
			if (el instanceof ComponentInstance){
				el = ((ComponentInstance)el).getSubcomponent();
			}
			if (el != cpes.get(idx).getNamedElement())
			{
				return false;
			}
		}
		return true;
	}
	
	/**
	 * return the containment path if the stack combined with the target and optionally the type set match the containment path of a property association.
	 * It is sufficient for one of the paths in the PA to match.
	 * ciStack represents the path from the context of the PA to the component instance whose property we want to retrieve
	 * The desired type set ts must be contained in the type set named in the containment path
	 * @param propertyAssociation PropertyAssociation that is the candidate
	 * @param ciStack (can be null or empty) ComponentInstance in instance model hierarchy with the error model element, whose property we are retrieving (or null)
	 * @param target Element the target object in the error model whose property we retrieve
	 * @param ts type set that must contain the last element if it is a type
	 * @return ContainedNamedElement the containment path that matches
	 */
	public static ContainedNamedElement isErrorModelElementProperty(PropertyAssociation propertyAssociation, Element target, 
			Stack<NamedElement> ciStack, TypeSet ts ){
		boolean matchStack = false;
		EList<ContainedNamedElement> applies = propertyAssociation.getAppliesTos();
		for (ContainedNamedElement containedNamedElement : applies) {
			EList<ContainmentPathElement> cpes = containedNamedElement.getContainmentPathElements();
			matchStack = matchCIStack(ciStack, cpes);
			if (matchStack) {
				// we are past the component portion of the path
				NamedElement typeelement =null;
				NamedElement lastel = null;
				if (ts != null){
					if (cpes.size()<2) continue;
					typeelement = cpes.get(cpes.size()-1).getNamedElement();
					lastel = cpes.get(cpes.size()-2).getNamedElement();
				} else {
					if (cpes.size()<1) continue;
					lastel = cpes.get(cpes.size()-1).getNamedElement();
				}
				if (typeelement != null){
					// check to see if the desired ts is contained in the PA containment path
					if (typeelement instanceof ErrorType){
						// we refer to a type
						if ((lastel instanceof ErrorType) && (EM2TypeSetUtil.contains((ErrorType)lastel,ts))){
							return containedNamedElement;
						}
					} else if (typeelement instanceof TypeSet){
						// we refer to a type
						if (EM2TypeSetUtil.contains((TypeSet)typeelement,ts)){
							// skip to next iteration
							return containedNamedElement;
						}
					} else {
						// last element is not a type or type set
						// must match target.
						// Note: property on target matches all targets with types
						if (typeelement != target) {
							return containedNamedElement;
						}
					}
				}
				
				/**
				 * Finally, in last resort, we try to see if the lastelement
				 * of the path corresponds to the target.
				 */
				if (lastel == target) {
					return containedNamedElement;
				}
			}
		}
		return null;
	}

	/**
	 * return containment paths of all PA in list whose property name and target/ts match
	 * @param props
	 * @param propertyName
	 * @param target
	 * @param ts
	 * @return EList<ContainedNamedElement>
	 */
	public static EList<ContainedNamedElement> getMatchingErrorModelElementPropertyAssociationsInList(EList<PropertyAssociation> props,String propertyName, Element target,
			 TypeSet ts){
		EList<ContainedNamedElement> result = new BasicEList<ContainedNamedElement>();
		if (props == null) return result;
		for (PropertyAssociation propertyAssociation : props) {
			Property prop = propertyAssociation.getProperty();
			String name = prop.getQualifiedName();
			if (propertyName.equalsIgnoreCase(name)){
				ContainedNamedElement res = isErrorModelElementProperty(propertyAssociation, target,null,ts);
				if (res!=null)
				result.add(res);
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
	 * @param ci ComponentInstance the component instance, subcomponent, or classifier with the error model element, whose property we are retrieving
	 * @param target Element the target object in the error model whose property we retrieve (the element may carry an error type)
	 * @param ts Type Set null or any error type in the type set as part of the target error model element
	 * @return
	 */
	public static EList<ContainedNamedElement> getProperty(String propertyName, NamedElement ci,Element target, TypeSet ts){
		EList<ContainedNamedElement> result = getPropertyInInstanceHierarchy(propertyName,ci,target, ts);
		if (result.isEmpty()){
			// look up in context of target definition
			// for example: for a state reference the properties section of the EBSM that defines the state
			EList<PropertyAssociation> props = getPropertyAssociationListInContext(target);
			if (props != null) {
				result = getMatchingErrorModelElementPropertyAssociationsInList(props, propertyName, target,ts);
			}
		}
		return result;
	}

	/**
	 * recurse up the component hierarchy to look for the PA from the outside in.
	 * For each component instance, handle inherited properties based on subclause inheritance ordering
	 * @param propertyName
	 * @param ci the component instance whose subclause property section we are looking for the property
	 * @param target
	 * @param ciStack stack of CIS that are down the hierarchy towards the target emv2 subclause
	 * @param ts
	 * @return
	 */
	private static EList<ContainedNamedElement> getPropertyInInstanceHierarchy(String propertyName, ComponentInstance ci,Element target, 
			Stack<NamedElement> ciStack, TypeSet ts){
		if (ci != null ) {
			if (ci.getContainingComponentInstance() != null){
				ciStack.push(ci);
				EList<ContainedNamedElement> result = getPropertyInInstanceHierarchy(propertyName, ci.getContainingComponentInstance(), target,ciStack,ts);
				ciStack.pop();
				if (!result.isEmpty()) return result;
			} 
			// deals with inherited properties by walking subclause inheritance
			EList<ErrorModelSubclause> emslist = EMV2Util.getAllContainingClassifierEMV2Subclauses(ci);
			for (ErrorModelSubclause ems : emslist) {
				EList<PropertyAssociation> props = ems.getProperties();
				EList<ContainedNamedElement>result = getMatchingPropertiesInList(props, propertyName, target, ciStack,ts);
				if (!result.isEmpty()){
					return result;
				}
			}
		}
		return new BasicEList<ContainedNamedElement>();
	}


	/**
	 * retrieve an error model property (such as Hazard) attached to an error model element based on contained property associations
	 * in the annex subclause properties section.
	 * Here we come down the component instance hierarchy to find the outmost property association
	 * in the properties section of the annex subclauses. Those are the ones that can override down the component hierarchy.
	 * @param propertyName name of property we are looking for
	 * @param ci component instance whose EM element has the property
	 * @param target the error model element (which is optionally followed by a type that is contained in the typeset ts
	 * @param ts the type set
	 * @return Containmentpath of the PA that matches the parameters.
	 * we return the path because the PA applies to more than element
	 */
	public static EList<ContainedNamedElement> getPropertyInInstanceHierarchy(String propertyName, NamedElement ci,Element target, 
			TypeSet ts){
		Stack<NamedElement> ciStack = new Stack<NamedElement>();
		ComponentClassifier cl = null;
		if (ci instanceof ComponentInstance){
			return getPropertyInInstanceHierarchy(propertyName,(ComponentInstance)ci,target,ciStack, ts);
		}
		if (ci instanceof Subcomponent){
			ciStack.push(ci);
			cl = ((Subcomponent)ci).getAllClassifier();
		}
		if (ci instanceof ComponentClassifier){
			cl = (ComponentClassifier)ci;
		}
		if (cl != null){
			// deals with inherited properties by walking subclause inheritance
			EList<ErrorModelSubclause> emslist = EMV2Util.getAllContainingClassifierEMV2Subclauses(cl);
			for (ErrorModelSubclause ems : emslist) {
				EList<PropertyAssociation> props = ems.getProperties();
				EList<ContainedNamedElement>result = getMatchingPropertiesInList(props, propertyName, target, ciStack,ts);
				if (!result.isEmpty()){
					return result;
				}
			}
		}
		return null;
	}
	

	/**
	 * get Severity
	 * @param ci component instance, subcomponent, or classifier
	 * @param target Error Model element
	 * @param ts Typeset
	 * @return path to element with property
	 */
	public static EList<ContainedNamedElement> getSeverityProperty(NamedElement ci, Element target, TypeSet ts){
		EList<ContainedNamedElement> result = EMV2Properties.getProperty("EMV2::Severity",ci,target,ts);
//		if (result==null)result = EMV2Properties.getProperty("ARP4761::Severity",ci,target,ts);
//		if (result==null)result = EMV2Properties.getProperty("MILSTD882::Severity",ci,target,ts);
		return result;
	}
	
	/**
	 * get likelihood
	 * @param ci component instance, subcomponent, or classifier
	 * @param target Error Model element
	 * @param ts Typeset
	 * @return path to element with property
	 */
	public static EList<ContainedNamedElement> getLikelihoodProperty(NamedElement ci, Element target, TypeSet ts){
		EList<ContainedNamedElement> result = EMV2Properties.getProperty("EMV2::Likelihood",ci,target,ts);
//		if (result==null)result = EMV2Properties.getProperty("ARP4761::Likelihood",ci,target,ts);
//		if (result==null)result = EMV2Properties.getProperty("MILSTD882::Likelihood",ci,target,ts);
		return result;
	}
	


}
