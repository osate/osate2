/**
 * <copyright>
 * Copyright  2008 by Carnegie Mellon University, all rights reserved.
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
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 *
 * $Id: Aadl2Switch.java,v 1.90 2011-04-11 13:35:56 lwrage Exp $
 */
package org.osate.aadl2.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.osate.aadl2.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.osate.aadl2.Aadl2Package
 * @generated
 */
public class Aadl2Switch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Aadl2Package modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Aadl2Switch() {
		if (modelPackage == null) {
			modelPackage = Aadl2Package.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case Aadl2Package.ELEMENT: {
			Element element = (Element) theEObject;
			T result = caseElement(element);
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.COMMENT: {
			Comment comment = (Comment) theEObject;
			T result = caseComment(comment);
			if (result == null) {
				result = caseElement(comment);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.TYPE: {
			Type type = (Type) theEObject;
			T result = caseType(type);
			if (result == null) {
				result = caseNamedElement(type);
			}
			if (result == null) {
				result = caseElement(type);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.NAMED_ELEMENT: {
			NamedElement namedElement = (NamedElement) theEObject;
			T result = caseNamedElement(namedElement);
			if (result == null) {
				result = caseElement(namedElement);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.PROPERTY_ASSOCIATION: {
			PropertyAssociation propertyAssociation = (PropertyAssociation) theEObject;
			T result = casePropertyAssociation(propertyAssociation);
			if (result == null) {
				result = caseElement(propertyAssociation);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.PROPERTY: {
			Property property = (Property) theEObject;
			T result = caseProperty(property);
			if (result == null) {
				result = caseBasicProperty(property);
			}
			if (result == null) {
				result = caseAbstractNamedValue(property);
			}
			if (result == null) {
				result = caseArraySizeProperty(property);
			}
			if (result == null) {
				result = caseTypedElement(property);
			}
			if (result == null) {
				result = caseNamedElement(property);
			}
			if (result == null) {
				result = caseElement(property);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.BASIC_PROPERTY: {
			BasicProperty basicProperty = (BasicProperty) theEObject;
			T result = caseBasicProperty(basicProperty);
			if (result == null) {
				result = caseTypedElement(basicProperty);
			}
			if (result == null) {
				result = caseNamedElement(basicProperty);
			}
			if (result == null) {
				result = caseElement(basicProperty);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.TYPED_ELEMENT: {
			TypedElement typedElement = (TypedElement) theEObject;
			T result = caseTypedElement(typedElement);
			if (result == null) {
				result = caseNamedElement(typedElement);
			}
			if (result == null) {
				result = caseElement(typedElement);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.PROPERTY_TYPE: {
			PropertyType propertyType = (PropertyType) theEObject;
			T result = casePropertyType(propertyType);
			if (result == null) {
				result = caseType(propertyType);
			}
			if (result == null) {
				result = caseNamedElement(propertyType);
			}
			if (result == null) {
				result = caseElement(propertyType);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.ABSTRACT_NAMED_VALUE: {
			AbstractNamedValue abstractNamedValue = (AbstractNamedValue) theEObject;
			T result = caseAbstractNamedValue(abstractNamedValue);
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.ARRAY_SIZE_PROPERTY: {
			ArraySizeProperty arraySizeProperty = (ArraySizeProperty) theEObject;
			T result = caseArraySizeProperty(arraySizeProperty);
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.PROPERTY_EXPRESSION: {
			PropertyExpression propertyExpression = (PropertyExpression) theEObject;
			T result = casePropertyExpression(propertyExpression);
			if (result == null) {
				result = caseElement(propertyExpression);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.METACLASS_REFERENCE: {
			MetaclassReference metaclassReference = (MetaclassReference) theEObject;
			T result = caseMetaclassReference(metaclassReference);
			if (result == null) {
				result = casePropertyOwner(metaclassReference);
			}
			if (result == null) {
				result = caseElement(metaclassReference);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.PROPERTY_OWNER: {
			PropertyOwner propertyOwner = (PropertyOwner) theEObject;
			T result = casePropertyOwner(propertyOwner);
			if (result == null) {
				result = caseElement(propertyOwner);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.CLASSIFIER: {
			Classifier classifier = (Classifier) theEObject;
			T result = caseClassifier(classifier);
			if (result == null) {
				result = caseNamespace(classifier);
			}
			if (result == null) {
				result = caseType(classifier);
			}
			if (result == null) {
				result = caseNamedElement(classifier);
			}
			if (result == null) {
				result = caseElement(classifier);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.NAMESPACE: {
			Namespace namespace = (Namespace) theEObject;
			T result = caseNamespace(namespace);
			if (result == null) {
				result = caseNamedElement(namespace);
			}
			if (result == null) {
				result = caseElement(namespace);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.CLASSIFIER_FEATURE: {
			ClassifierFeature classifierFeature = (ClassifierFeature) theEObject;
			T result = caseClassifierFeature(classifierFeature);
			if (result == null) {
				result = caseNamedElement(classifierFeature);
			}
			if (result == null) {
				result = caseElement(classifierFeature);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.GENERALIZATION: {
			Generalization generalization = (Generalization) theEObject;
			T result = caseGeneralization(generalization);
			if (result == null) {
				result = caseDirectedRelationship(generalization);
			}
			if (result == null) {
				result = caseRelationship(generalization);
			}
			if (result == null) {
				result = caseElement(generalization);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.DIRECTED_RELATIONSHIP: {
			DirectedRelationship directedRelationship = (DirectedRelationship) theEObject;
			T result = caseDirectedRelationship(directedRelationship);
			if (result == null) {
				result = caseRelationship(directedRelationship);
			}
			if (result == null) {
				result = caseElement(directedRelationship);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.RELATIONSHIP: {
			Relationship relationship = (Relationship) theEObject;
			T result = caseRelationship(relationship);
			if (result == null) {
				result = caseElement(relationship);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.ANNEX_SUBCLAUSE: {
			AnnexSubclause annexSubclause = (AnnexSubclause) theEObject;
			T result = caseAnnexSubclause(annexSubclause);
			if (result == null) {
				result = caseModalElement(annexSubclause);
			}
			if (result == null) {
				result = caseNamedElement(annexSubclause);
			}
			if (result == null) {
				result = caseElement(annexSubclause);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.MODAL_ELEMENT: {
			ModalElement modalElement = (ModalElement) theEObject;
			T result = caseModalElement(modalElement);
			if (result == null) {
				result = caseNamedElement(modalElement);
			}
			if (result == null) {
				result = caseElement(modalElement);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.MODE: {
			Mode mode = (Mode) theEObject;
			T result = caseMode(mode);
			if (result == null) {
				result = caseModeFeature(mode);
			}
			if (result == null) {
				result = caseClassifierFeature(mode);
			}
			if (result == null) {
				result = caseNamedElement(mode);
			}
			if (result == null) {
				result = caseElement(mode);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.MODE_FEATURE: {
			ModeFeature modeFeature = (ModeFeature) theEObject;
			T result = caseModeFeature(modeFeature);
			if (result == null) {
				result = caseClassifierFeature(modeFeature);
			}
			if (result == null) {
				result = caseNamedElement(modeFeature);
			}
			if (result == null) {
				result = caseElement(modeFeature);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.PROTOTYPE: {
			Prototype prototype = (Prototype) theEObject;
			T result = casePrototype(prototype);
			if (result == null) {
				result = caseStructuralFeature(prototype);
			}
			if (result == null) {
				result = caseCalledSubprogram(prototype);
			}
			if (result == null) {
				result = caseRefinableElement(prototype);
			}
			if (result == null) {
				result = caseClassifierFeature(prototype);
			}
			if (result == null) {
				result = caseNamedElement(prototype);
			}
			if (result == null) {
				result = caseElement(prototype);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.STRUCTURAL_FEATURE: {
			StructuralFeature structuralFeature = (StructuralFeature) theEObject;
			T result = caseStructuralFeature(structuralFeature);
			if (result == null) {
				result = caseRefinableElement(structuralFeature);
			}
			if (result == null) {
				result = caseClassifierFeature(structuralFeature);
			}
			if (result == null) {
				result = caseNamedElement(structuralFeature);
			}
			if (result == null) {
				result = caseElement(structuralFeature);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.REFINABLE_ELEMENT: {
			RefinableElement refinableElement = (RefinableElement) theEObject;
			T result = caseRefinableElement(refinableElement);
			if (result == null) {
				result = caseNamedElement(refinableElement);
			}
			if (result == null) {
				result = caseElement(refinableElement);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.CALLED_SUBPROGRAM: {
			CalledSubprogram calledSubprogram = (CalledSubprogram) theEObject;
			T result = caseCalledSubprogram(calledSubprogram);
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.PROTOTYPE_BINDING: {
			PrototypeBinding prototypeBinding = (PrototypeBinding) theEObject;
			T result = casePrototypeBinding(prototypeBinding);
			if (result == null) {
				result = caseElement(prototypeBinding);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.CONTAINED_NAMED_ELEMENT: {
			ContainedNamedElement containedNamedElement = (ContainedNamedElement) theEObject;
			T result = caseContainedNamedElement(containedNamedElement);
			if (result == null) {
				result = caseElement(containedNamedElement);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.CONTAINMENT_PATH_ELEMENT: {
			ContainmentPathElement containmentPathElement = (ContainmentPathElement) theEObject;
			T result = caseContainmentPathElement(containmentPathElement);
			if (result == null) {
				result = caseElement(containmentPathElement);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.ARRAY_RANGE: {
			ArrayRange arrayRange = (ArrayRange) theEObject;
			T result = caseArrayRange(arrayRange);
			if (result == null) {
				result = caseElement(arrayRange);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.MODAL_PROPERTY_VALUE: {
			ModalPropertyValue modalPropertyValue = (ModalPropertyValue) theEObject;
			T result = caseModalPropertyValue(modalPropertyValue);
			if (result == null) {
				result = caseModalElement(modalPropertyValue);
			}
			if (result == null) {
				result = caseNamedElement(modalPropertyValue);
			}
			if (result == null) {
				result = caseElement(modalPropertyValue);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.BEHAVIORAL_FEATURE: {
			BehavioralFeature behavioralFeature = (BehavioralFeature) theEObject;
			T result = caseBehavioralFeature(behavioralFeature);
			if (result == null) {
				result = caseClassifierFeature(behavioralFeature);
			}
			if (result == null) {
				result = caseNamedElement(behavioralFeature);
			}
			if (result == null) {
				result = caseElement(behavioralFeature);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.ARRAY_DIMENSION: {
			ArrayDimension arrayDimension = (ArrayDimension) theEObject;
			T result = caseArrayDimension(arrayDimension);
			if (result == null) {
				result = caseElement(arrayDimension);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.ARRAY_SIZE: {
			ArraySize arraySize = (ArraySize) theEObject;
			T result = caseArraySize(arraySize);
			if (result == null) {
				result = caseElement(arraySize);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.ARRAYABLE_ELEMENT: {
			ArrayableElement arrayableElement = (ArrayableElement) theEObject;
			T result = caseArrayableElement(arrayableElement);
			if (result == null) {
				result = caseElement(arrayableElement);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.COMPONENT_IMPLEMENTATION_REFERENCE: {
			ComponentImplementationReference componentImplementationReference = (ComponentImplementationReference) theEObject;
			T result = caseComponentImplementationReference(componentImplementationReference);
			if (result == null) {
				result = caseElement(componentImplementationReference);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.COMPONENT_IMPLEMENTATION: {
			ComponentImplementation componentImplementation = (ComponentImplementation) theEObject;
			T result = caseComponentImplementation(componentImplementation);
			if (result == null) {
				result = caseComponentClassifier(componentImplementation);
			}
			if (result == null) {
				result = caseClassifier(componentImplementation);
			}
			if (result == null) {
				result = caseSubcomponentType(componentImplementation);
			}
			if (result == null) {
				result = caseFeatureClassifier(componentImplementation);
			}
			if (result == null) {
				result = caseNamespace(componentImplementation);
			}
			if (result == null) {
				result = caseType(componentImplementation);
			}
			if (result == null) {
				result = caseNamedElement(componentImplementation);
			}
			if (result == null) {
				result = caseElement(componentImplementation);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.COMPONENT_CLASSIFIER: {
			ComponentClassifier componentClassifier = (ComponentClassifier) theEObject;
			T result = caseComponentClassifier(componentClassifier);
			if (result == null) {
				result = caseClassifier(componentClassifier);
			}
			if (result == null) {
				result = caseSubcomponentType(componentClassifier);
			}
			if (result == null) {
				result = caseFeatureClassifier(componentClassifier);
			}
			if (result == null) {
				result = caseNamespace(componentClassifier);
			}
			if (result == null) {
				result = caseType(componentClassifier);
			}
			if (result == null) {
				result = caseNamedElement(componentClassifier);
			}
			if (result == null) {
				result = caseElement(componentClassifier);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.SUBCOMPONENT_TYPE: {
			SubcomponentType subcomponentType = (SubcomponentType) theEObject;
			T result = caseSubcomponentType(subcomponentType);
			if (result == null) {
				result = caseType(subcomponentType);
			}
			if (result == null) {
				result = caseNamedElement(subcomponentType);
			}
			if (result == null) {
				result = caseElement(subcomponentType);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.FEATURE_CLASSIFIER: {
			FeatureClassifier featureClassifier = (FeatureClassifier) theEObject;
			T result = caseFeatureClassifier(featureClassifier);
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.MODE_TRANSITION: {
			ModeTransition modeTransition = (ModeTransition) theEObject;
			T result = caseModeTransition(modeTransition);
			if (result == null) {
				result = caseModeFeature(modeTransition);
			}
			if (result == null) {
				result = caseClassifierFeature(modeTransition);
			}
			if (result == null) {
				result = caseNamedElement(modeTransition);
			}
			if (result == null) {
				result = caseElement(modeTransition);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.MODE_TRANSITION_TRIGGER: {
			ModeTransitionTrigger modeTransitionTrigger = (ModeTransitionTrigger) theEObject;
			T result = caseModeTransitionTrigger(modeTransitionTrigger);
			if (result == null) {
				result = caseElement(modeTransitionTrigger);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.CONTEXT: {
			Context context = (Context) theEObject;
			T result = caseContext(context);
			if (result == null) {
				result = caseNamedElement(context);
			}
			if (result == null) {
				result = caseElement(context);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.TRIGGER_PORT: {
			TriggerPort triggerPort = (TriggerPort) theEObject;
			T result = caseTriggerPort(triggerPort);
			if (result == null) {
				result = caseNamedElement(triggerPort);
			}
			if (result == null) {
				result = caseElement(triggerPort);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.COMPONENT_TYPE: {
			ComponentType componentType = (ComponentType) theEObject;
			T result = caseComponentType(componentType);
			if (result == null) {
				result = caseComponentClassifier(componentType);
			}
			if (result == null) {
				result = caseClassifier(componentType);
			}
			if (result == null) {
				result = caseSubcomponentType(componentType);
			}
			if (result == null) {
				result = caseFeatureClassifier(componentType);
			}
			if (result == null) {
				result = caseNamespace(componentType);
			}
			if (result == null) {
				result = caseType(componentType);
			}
			if (result == null) {
				result = caseNamedElement(componentType);
			}
			if (result == null) {
				result = caseElement(componentType);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.FEATURE: {
			Feature feature = (Feature) theEObject;
			T result = caseFeature(feature);
			if (result == null) {
				result = caseStructuralFeature(feature);
			}
			if (result == null) {
				result = caseFeatureConnectionEnd(feature);
			}
			if (result == null) {
				result = caseArrayableElement(feature);
			}
			if (result == null) {
				result = caseRefinableElement(feature);
			}
			if (result == null) {
				result = caseClassifierFeature(feature);
			}
			if (result == null) {
				result = caseConnectionEnd(feature);
			}
			if (result == null) {
				result = caseNamedElement(feature);
			}
			if (result == null) {
				result = caseElement(feature);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.FEATURE_CONNECTION_END: {
			FeatureConnectionEnd featureConnectionEnd = (FeatureConnectionEnd) theEObject;
			T result = caseFeatureConnectionEnd(featureConnectionEnd);
			if (result == null) {
				result = caseConnectionEnd(featureConnectionEnd);
			}
			if (result == null) {
				result = caseNamedElement(featureConnectionEnd);
			}
			if (result == null) {
				result = caseElement(featureConnectionEnd);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.CONNECTION_END: {
			ConnectionEnd connectionEnd = (ConnectionEnd) theEObject;
			T result = caseConnectionEnd(connectionEnd);
			if (result == null) {
				result = caseNamedElement(connectionEnd);
			}
			if (result == null) {
				result = caseElement(connectionEnd);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.COMPONENT_PROTOTYPE: {
			ComponentPrototype componentPrototype = (ComponentPrototype) theEObject;
			T result = caseComponentPrototype(componentPrototype);
			if (result == null) {
				result = casePrototype(componentPrototype);
			}
			if (result == null) {
				result = caseSubcomponentType(componentPrototype);
			}
			if (result == null) {
				result = caseFeatureClassifier(componentPrototype);
			}
			if (result == null) {
				result = caseStructuralFeature(componentPrototype);
			}
			if (result == null) {
				result = caseCalledSubprogram(componentPrototype);
			}
			if (result == null) {
				result = caseType(componentPrototype);
			}
			if (result == null) {
				result = caseRefinableElement(componentPrototype);
			}
			if (result == null) {
				result = caseClassifierFeature(componentPrototype);
			}
			if (result == null) {
				result = caseNamedElement(componentPrototype);
			}
			if (result == null) {
				result = caseElement(componentPrototype);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.FLOW_SPECIFICATION: {
			FlowSpecification flowSpecification = (FlowSpecification) theEObject;
			T result = caseFlowSpecification(flowSpecification);
			if (result == null) {
				result = caseFlowFeature(flowSpecification);
			}
			if (result == null) {
				result = caseModalPath(flowSpecification);
			}
			if (result == null) {
				result = caseFlowElement(flowSpecification);
			}
			if (result == null) {
				result = caseStructuralFeature(flowSpecification);
			}
			if (result == null) {
				result = caseFlow(flowSpecification);
			}
			if (result == null) {
				result = caseModalElement(flowSpecification);
			}
			if (result == null) {
				result = caseEndToEndFlowElement(flowSpecification);
			}
			if (result == null) {
				result = caseRefinableElement(flowSpecification);
			}
			if (result == null) {
				result = caseClassifierFeature(flowSpecification);
			}
			if (result == null) {
				result = caseNamedElement(flowSpecification);
			}
			if (result == null) {
				result = caseElement(flowSpecification);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.FLOW_FEATURE: {
			FlowFeature flowFeature = (FlowFeature) theEObject;
			T result = caseFlowFeature(flowFeature);
			if (result == null) {
				result = caseStructuralFeature(flowFeature);
			}
			if (result == null) {
				result = caseFlow(flowFeature);
			}
			if (result == null) {
				result = caseRefinableElement(flowFeature);
			}
			if (result == null) {
				result = caseClassifierFeature(flowFeature);
			}
			if (result == null) {
				result = caseNamedElement(flowFeature);
			}
			if (result == null) {
				result = caseElement(flowFeature);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.FLOW: {
			Flow flow = (Flow) theEObject;
			T result = caseFlow(flow);
			if (result == null) {
				result = caseNamedElement(flow);
			}
			if (result == null) {
				result = caseElement(flow);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.MODAL_PATH: {
			ModalPath modalPath = (ModalPath) theEObject;
			T result = caseModalPath(modalPath);
			if (result == null) {
				result = caseModalElement(modalPath);
			}
			if (result == null) {
				result = caseNamedElement(modalPath);
			}
			if (result == null) {
				result = caseElement(modalPath);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.FLOW_ELEMENT: {
			FlowElement flowElement = (FlowElement) theEObject;
			T result = caseFlowElement(flowElement);
			if (result == null) {
				result = caseEndToEndFlowElement(flowElement);
			}
			if (result == null) {
				result = caseNamedElement(flowElement);
			}
			if (result == null) {
				result = caseElement(flowElement);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.END_TO_END_FLOW_ELEMENT: {
			EndToEndFlowElement endToEndFlowElement = (EndToEndFlowElement) theEObject;
			T result = caseEndToEndFlowElement(endToEndFlowElement);
			if (result == null) {
				result = caseNamedElement(endToEndFlowElement);
			}
			if (result == null) {
				result = caseElement(endToEndFlowElement);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.FLOW_END: {
			FlowEnd flowEnd = (FlowEnd) theEObject;
			T result = caseFlowEnd(flowEnd);
			if (result == null) {
				result = caseElement(flowEnd);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.TYPE_EXTENSION: {
			TypeExtension typeExtension = (TypeExtension) theEObject;
			T result = caseTypeExtension(typeExtension);
			if (result == null) {
				result = caseGeneralization(typeExtension);
			}
			if (result == null) {
				result = caseDirectedRelationship(typeExtension);
			}
			if (result == null) {
				result = caseRelationship(typeExtension);
			}
			if (result == null) {
				result = caseElement(typeExtension);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.FEATURE_GROUP: {
			FeatureGroup featureGroup = (FeatureGroup) theEObject;
			T result = caseFeatureGroup(featureGroup);
			if (result == null) {
				result = caseDirectedFeature(featureGroup);
			}
			if (result == null) {
				result = caseContext(featureGroup);
			}
			if (result == null) {
				result = caseFeatureGroupConnectionEnd(featureGroup);
			}
			if (result == null) {
				result = caseCallContext(featureGroup);
			}
			if (result == null) {
				result = caseFeature(featureGroup);
			}
			if (result == null) {
				result = caseStructuralFeature(featureGroup);
			}
			if (result == null) {
				result = caseFeatureConnectionEnd(featureGroup);
			}
			if (result == null) {
				result = caseArrayableElement(featureGroup);
			}
			if (result == null) {
				result = caseRefinableElement(featureGroup);
			}
			if (result == null) {
				result = caseClassifierFeature(featureGroup);
			}
			if (result == null) {
				result = caseConnectionEnd(featureGroup);
			}
			if (result == null) {
				result = caseNamedElement(featureGroup);
			}
			if (result == null) {
				result = caseElement(featureGroup);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.CALL_CONTEXT: {
			CallContext callContext = (CallContext) theEObject;
			T result = caseCallContext(callContext);
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.DIRECTED_FEATURE: {
			DirectedFeature directedFeature = (DirectedFeature) theEObject;
			T result = caseDirectedFeature(directedFeature);
			if (result == null) {
				result = caseFeature(directedFeature);
			}
			if (result == null) {
				result = caseStructuralFeature(directedFeature);
			}
			if (result == null) {
				result = caseFeatureConnectionEnd(directedFeature);
			}
			if (result == null) {
				result = caseArrayableElement(directedFeature);
			}
			if (result == null) {
				result = caseRefinableElement(directedFeature);
			}
			if (result == null) {
				result = caseClassifierFeature(directedFeature);
			}
			if (result == null) {
				result = caseConnectionEnd(directedFeature);
			}
			if (result == null) {
				result = caseNamedElement(directedFeature);
			}
			if (result == null) {
				result = caseElement(directedFeature);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.FEATURE_GROUP_CONNECTION_END: {
			FeatureGroupConnectionEnd featureGroupConnectionEnd = (FeatureGroupConnectionEnd) theEObject;
			T result = caseFeatureGroupConnectionEnd(featureGroupConnectionEnd);
			if (result == null) {
				result = caseConnectionEnd(featureGroupConnectionEnd);
			}
			if (result == null) {
				result = caseNamedElement(featureGroupConnectionEnd);
			}
			if (result == null) {
				result = caseElement(featureGroupConnectionEnd);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.FEATURE_TYPE: {
			FeatureType featureType = (FeatureType) theEObject;
			T result = caseFeatureType(featureType);
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.FEATURE_GROUP_TYPE: {
			FeatureGroupType featureGroupType = (FeatureGroupType) theEObject;
			T result = caseFeatureGroupType(featureGroupType);
			if (result == null) {
				result = caseClassifier(featureGroupType);
			}
			if (result == null) {
				result = caseFeatureType(featureGroupType);
			}
			if (result == null) {
				result = caseNamespace(featureGroupType);
			}
			if (result == null) {
				result = caseType(featureGroupType);
			}
			if (result == null) {
				result = caseNamedElement(featureGroupType);
			}
			if (result == null) {
				result = caseElement(featureGroupType);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.GROUP_EXTENSION: {
			GroupExtension groupExtension = (GroupExtension) theEObject;
			T result = caseGroupExtension(groupExtension);
			if (result == null) {
				result = caseGeneralization(groupExtension);
			}
			if (result == null) {
				result = caseDirectedRelationship(groupExtension);
			}
			if (result == null) {
				result = caseRelationship(groupExtension);
			}
			if (result == null) {
				result = caseElement(groupExtension);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.BUS_ACCESS: {
			BusAccess busAccess = (BusAccess) theEObject;
			T result = caseBusAccess(busAccess);
			if (result == null) {
				result = caseAccess(busAccess);
			}
			if (result == null) {
				result = caseFeature(busAccess);
			}
			if (result == null) {
				result = caseAccessConnectionEnd(busAccess);
			}
			if (result == null) {
				result = caseStructuralFeature(busAccess);
			}
			if (result == null) {
				result = caseFeatureConnectionEnd(busAccess);
			}
			if (result == null) {
				result = caseArrayableElement(busAccess);
			}
			if (result == null) {
				result = caseRefinableElement(busAccess);
			}
			if (result == null) {
				result = caseClassifierFeature(busAccess);
			}
			if (result == null) {
				result = caseConnectionEnd(busAccess);
			}
			if (result == null) {
				result = caseNamedElement(busAccess);
			}
			if (result == null) {
				result = caseElement(busAccess);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.ACCESS: {
			Access access = (Access) theEObject;
			T result = caseAccess(access);
			if (result == null) {
				result = caseFeature(access);
			}
			if (result == null) {
				result = caseAccessConnectionEnd(access);
			}
			if (result == null) {
				result = caseStructuralFeature(access);
			}
			if (result == null) {
				result = caseFeatureConnectionEnd(access);
			}
			if (result == null) {
				result = caseArrayableElement(access);
			}
			if (result == null) {
				result = caseRefinableElement(access);
			}
			if (result == null) {
				result = caseClassifierFeature(access);
			}
			if (result == null) {
				result = caseConnectionEnd(access);
			}
			if (result == null) {
				result = caseNamedElement(access);
			}
			if (result == null) {
				result = caseElement(access);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.ACCESS_CONNECTION_END: {
			AccessConnectionEnd accessConnectionEnd = (AccessConnectionEnd) theEObject;
			T result = caseAccessConnectionEnd(accessConnectionEnd);
			if (result == null) {
				result = caseConnectionEnd(accessConnectionEnd);
			}
			if (result == null) {
				result = caseNamedElement(accessConnectionEnd);
			}
			if (result == null) {
				result = caseElement(accessConnectionEnd);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.BUS_SUBCOMPONENT_TYPE: {
			BusSubcomponentType busSubcomponentType = (BusSubcomponentType) theEObject;
			T result = caseBusSubcomponentType(busSubcomponentType);
			if (result == null) {
				result = caseSubcomponentType(busSubcomponentType);
			}
			if (result == null) {
				result = caseFeatureClassifier(busSubcomponentType);
			}
			if (result == null) {
				result = caseType(busSubcomponentType);
			}
			if (result == null) {
				result = caseNamedElement(busSubcomponentType);
			}
			if (result == null) {
				result = caseElement(busSubcomponentType);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.DATA_ACCESS: {
			DataAccess dataAccess = (DataAccess) theEObject;
			T result = caseDataAccess(dataAccess);
			if (result == null) {
				result = caseAccess(dataAccess);
			}
			if (result == null) {
				result = caseFlowElement(dataAccess);
			}
			if (result == null) {
				result = caseParameterConnectionEnd(dataAccess);
			}
			if (result == null) {
				result = casePortConnectionEnd(dataAccess);
			}
			if (result == null) {
				result = caseFeature(dataAccess);
			}
			if (result == null) {
				result = caseAccessConnectionEnd(dataAccess);
			}
			if (result == null) {
				result = caseEndToEndFlowElement(dataAccess);
			}
			if (result == null) {
				result = caseStructuralFeature(dataAccess);
			}
			if (result == null) {
				result = caseFeatureConnectionEnd(dataAccess);
			}
			if (result == null) {
				result = caseArrayableElement(dataAccess);
			}
			if (result == null) {
				result = caseRefinableElement(dataAccess);
			}
			if (result == null) {
				result = caseClassifierFeature(dataAccess);
			}
			if (result == null) {
				result = caseConnectionEnd(dataAccess);
			}
			if (result == null) {
				result = caseNamedElement(dataAccess);
			}
			if (result == null) {
				result = caseElement(dataAccess);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.PARAMETER_CONNECTION_END: {
			ParameterConnectionEnd parameterConnectionEnd = (ParameterConnectionEnd) theEObject;
			T result = caseParameterConnectionEnd(parameterConnectionEnd);
			if (result == null) {
				result = caseConnectionEnd(parameterConnectionEnd);
			}
			if (result == null) {
				result = caseNamedElement(parameterConnectionEnd);
			}
			if (result == null) {
				result = caseElement(parameterConnectionEnd);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.PORT_CONNECTION_END: {
			PortConnectionEnd portConnectionEnd = (PortConnectionEnd) theEObject;
			T result = casePortConnectionEnd(portConnectionEnd);
			if (result == null) {
				result = caseConnectionEnd(portConnectionEnd);
			}
			if (result == null) {
				result = caseNamedElement(portConnectionEnd);
			}
			if (result == null) {
				result = caseElement(portConnectionEnd);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.DATA_SUBCOMPONENT_TYPE: {
			DataSubcomponentType dataSubcomponentType = (DataSubcomponentType) theEObject;
			T result = caseDataSubcomponentType(dataSubcomponentType);
			if (result == null) {
				result = caseSubcomponentType(dataSubcomponentType);
			}
			if (result == null) {
				result = caseFeatureClassifier(dataSubcomponentType);
			}
			if (result == null) {
				result = caseType(dataSubcomponentType);
			}
			if (result == null) {
				result = caseNamedElement(dataSubcomponentType);
			}
			if (result == null) {
				result = caseElement(dataSubcomponentType);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.DATA_PORT: {
			DataPort dataPort = (DataPort) theEObject;
			T result = caseDataPort(dataPort);
			if (result == null) {
				result = casePort(dataPort);
			}
			if (result == null) {
				result = caseContext(dataPort);
			}
			if (result == null) {
				result = caseParameterConnectionEnd(dataPort);
			}
			if (result == null) {
				result = caseDirectedFeature(dataPort);
			}
			if (result == null) {
				result = casePortConnectionEnd(dataPort);
			}
			if (result == null) {
				result = caseTriggerPort(dataPort);
			}
			if (result == null) {
				result = caseFeature(dataPort);
			}
			if (result == null) {
				result = caseStructuralFeature(dataPort);
			}
			if (result == null) {
				result = caseFeatureConnectionEnd(dataPort);
			}
			if (result == null) {
				result = caseArrayableElement(dataPort);
			}
			if (result == null) {
				result = caseRefinableElement(dataPort);
			}
			if (result == null) {
				result = caseClassifierFeature(dataPort);
			}
			if (result == null) {
				result = caseConnectionEnd(dataPort);
			}
			if (result == null) {
				result = caseNamedElement(dataPort);
			}
			if (result == null) {
				result = caseElement(dataPort);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.PORT: {
			Port port = (Port) theEObject;
			T result = casePort(port);
			if (result == null) {
				result = caseDirectedFeature(port);
			}
			if (result == null) {
				result = casePortConnectionEnd(port);
			}
			if (result == null) {
				result = caseTriggerPort(port);
			}
			if (result == null) {
				result = caseFeature(port);
			}
			if (result == null) {
				result = caseStructuralFeature(port);
			}
			if (result == null) {
				result = caseFeatureConnectionEnd(port);
			}
			if (result == null) {
				result = caseArrayableElement(port);
			}
			if (result == null) {
				result = caseRefinableElement(port);
			}
			if (result == null) {
				result = caseClassifierFeature(port);
			}
			if (result == null) {
				result = caseConnectionEnd(port);
			}
			if (result == null) {
				result = caseNamedElement(port);
			}
			if (result == null) {
				result = caseElement(port);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.EVENT_DATA_PORT: {
			EventDataPort eventDataPort = (EventDataPort) theEObject;
			T result = caseEventDataPort(eventDataPort);
			if (result == null) {
				result = casePort(eventDataPort);
			}
			if (result == null) {
				result = caseContext(eventDataPort);
			}
			if (result == null) {
				result = caseParameterConnectionEnd(eventDataPort);
			}
			if (result == null) {
				result = caseDirectedFeature(eventDataPort);
			}
			if (result == null) {
				result = casePortConnectionEnd(eventDataPort);
			}
			if (result == null) {
				result = caseTriggerPort(eventDataPort);
			}
			if (result == null) {
				result = caseFeature(eventDataPort);
			}
			if (result == null) {
				result = caseStructuralFeature(eventDataPort);
			}
			if (result == null) {
				result = caseFeatureConnectionEnd(eventDataPort);
			}
			if (result == null) {
				result = caseArrayableElement(eventDataPort);
			}
			if (result == null) {
				result = caseRefinableElement(eventDataPort);
			}
			if (result == null) {
				result = caseClassifierFeature(eventDataPort);
			}
			if (result == null) {
				result = caseConnectionEnd(eventDataPort);
			}
			if (result == null) {
				result = caseNamedElement(eventDataPort);
			}
			if (result == null) {
				result = caseElement(eventDataPort);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.EVENT_PORT: {
			EventPort eventPort = (EventPort) theEObject;
			T result = caseEventPort(eventPort);
			if (result == null) {
				result = casePort(eventPort);
			}
			if (result == null) {
				result = caseDirectedFeature(eventPort);
			}
			if (result == null) {
				result = casePortConnectionEnd(eventPort);
			}
			if (result == null) {
				result = caseTriggerPort(eventPort);
			}
			if (result == null) {
				result = caseFeature(eventPort);
			}
			if (result == null) {
				result = caseStructuralFeature(eventPort);
			}
			if (result == null) {
				result = caseFeatureConnectionEnd(eventPort);
			}
			if (result == null) {
				result = caseArrayableElement(eventPort);
			}
			if (result == null) {
				result = caseRefinableElement(eventPort);
			}
			if (result == null) {
				result = caseClassifierFeature(eventPort);
			}
			if (result == null) {
				result = caseConnectionEnd(eventPort);
			}
			if (result == null) {
				result = caseNamedElement(eventPort);
			}
			if (result == null) {
				result = caseElement(eventPort);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.PARAMETER: {
			Parameter parameter = (Parameter) theEObject;
			T result = caseParameter(parameter);
			if (result == null) {
				result = caseDirectedFeature(parameter);
			}
			if (result == null) {
				result = caseContext(parameter);
			}
			if (result == null) {
				result = caseParameterConnectionEnd(parameter);
			}
			if (result == null) {
				result = caseFeature(parameter);
			}
			if (result == null) {
				result = caseStructuralFeature(parameter);
			}
			if (result == null) {
				result = caseFeatureConnectionEnd(parameter);
			}
			if (result == null) {
				result = caseArrayableElement(parameter);
			}
			if (result == null) {
				result = caseRefinableElement(parameter);
			}
			if (result == null) {
				result = caseClassifierFeature(parameter);
			}
			if (result == null) {
				result = caseConnectionEnd(parameter);
			}
			if (result == null) {
				result = caseNamedElement(parameter);
			}
			if (result == null) {
				result = caseElement(parameter);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.SUBPROGRAM_ACCESS: {
			SubprogramAccess subprogramAccess = (SubprogramAccess) theEObject;
			T result = caseSubprogramAccess(subprogramAccess);
			if (result == null) {
				result = caseAccess(subprogramAccess);
			}
			if (result == null) {
				result = caseCalledSubprogram(subprogramAccess);
			}
			if (result == null) {
				result = caseFeature(subprogramAccess);
			}
			if (result == null) {
				result = caseAccessConnectionEnd(subprogramAccess);
			}
			if (result == null) {
				result = caseStructuralFeature(subprogramAccess);
			}
			if (result == null) {
				result = caseFeatureConnectionEnd(subprogramAccess);
			}
			if (result == null) {
				result = caseArrayableElement(subprogramAccess);
			}
			if (result == null) {
				result = caseRefinableElement(subprogramAccess);
			}
			if (result == null) {
				result = caseClassifierFeature(subprogramAccess);
			}
			if (result == null) {
				result = caseConnectionEnd(subprogramAccess);
			}
			if (result == null) {
				result = caseNamedElement(subprogramAccess);
			}
			if (result == null) {
				result = caseElement(subprogramAccess);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.SUBPROGRAM_SUBCOMPONENT_TYPE: {
			SubprogramSubcomponentType subprogramSubcomponentType = (SubprogramSubcomponentType) theEObject;
			T result = caseSubprogramSubcomponentType(subprogramSubcomponentType);
			if (result == null) {
				result = caseSubcomponentType(subprogramSubcomponentType);
			}
			if (result == null) {
				result = caseFeatureClassifier(subprogramSubcomponentType);
			}
			if (result == null) {
				result = caseType(subprogramSubcomponentType);
			}
			if (result == null) {
				result = caseNamedElement(subprogramSubcomponentType);
			}
			if (result == null) {
				result = caseElement(subprogramSubcomponentType);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.SUBPROGRAM_GROUP_ACCESS: {
			SubprogramGroupAccess subprogramGroupAccess = (SubprogramGroupAccess) theEObject;
			T result = caseSubprogramGroupAccess(subprogramGroupAccess);
			if (result == null) {
				result = caseAccess(subprogramGroupAccess);
			}
			if (result == null) {
				result = caseCallContext(subprogramGroupAccess);
			}
			if (result == null) {
				result = caseFeature(subprogramGroupAccess);
			}
			if (result == null) {
				result = caseAccessConnectionEnd(subprogramGroupAccess);
			}
			if (result == null) {
				result = caseStructuralFeature(subprogramGroupAccess);
			}
			if (result == null) {
				result = caseFeatureConnectionEnd(subprogramGroupAccess);
			}
			if (result == null) {
				result = caseArrayableElement(subprogramGroupAccess);
			}
			if (result == null) {
				result = caseRefinableElement(subprogramGroupAccess);
			}
			if (result == null) {
				result = caseClassifierFeature(subprogramGroupAccess);
			}
			if (result == null) {
				result = caseConnectionEnd(subprogramGroupAccess);
			}
			if (result == null) {
				result = caseNamedElement(subprogramGroupAccess);
			}
			if (result == null) {
				result = caseElement(subprogramGroupAccess);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.SUBPROGRAM_GROUP_SUBCOMPONENT_TYPE: {
			SubprogramGroupSubcomponentType subprogramGroupSubcomponentType = (SubprogramGroupSubcomponentType) theEObject;
			T result = caseSubprogramGroupSubcomponentType(subprogramGroupSubcomponentType);
			if (result == null) {
				result = caseSubcomponentType(subprogramGroupSubcomponentType);
			}
			if (result == null) {
				result = caseFeatureClassifier(subprogramGroupSubcomponentType);
			}
			if (result == null) {
				result = caseType(subprogramGroupSubcomponentType);
			}
			if (result == null) {
				result = caseNamedElement(subprogramGroupSubcomponentType);
			}
			if (result == null) {
				result = caseElement(subprogramGroupSubcomponentType);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.ABSTRACT_FEATURE: {
			AbstractFeature abstractFeature = (AbstractFeature) theEObject;
			T result = caseAbstractFeature(abstractFeature);
			if (result == null) {
				result = caseDirectedFeature(abstractFeature);
			}
			if (result == null) {
				result = caseTriggerPort(abstractFeature);
			}
			if (result == null) {
				result = caseFeature(abstractFeature);
			}
			if (result == null) {
				result = caseStructuralFeature(abstractFeature);
			}
			if (result == null) {
				result = caseFeatureConnectionEnd(abstractFeature);
			}
			if (result == null) {
				result = caseArrayableElement(abstractFeature);
			}
			if (result == null) {
				result = caseRefinableElement(abstractFeature);
			}
			if (result == null) {
				result = caseClassifierFeature(abstractFeature);
			}
			if (result == null) {
				result = caseConnectionEnd(abstractFeature);
			}
			if (result == null) {
				result = caseNamedElement(abstractFeature);
			}
			if (result == null) {
				result = caseElement(abstractFeature);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.FEATURE_PROTOTYPE: {
			FeaturePrototype featurePrototype = (FeaturePrototype) theEObject;
			T result = caseFeaturePrototype(featurePrototype);
			if (result == null) {
				result = casePrototype(featurePrototype);
			}
			if (result == null) {
				result = caseStructuralFeature(featurePrototype);
			}
			if (result == null) {
				result = caseCalledSubprogram(featurePrototype);
			}
			if (result == null) {
				result = caseRefinableElement(featurePrototype);
			}
			if (result == null) {
				result = caseClassifierFeature(featurePrototype);
			}
			if (result == null) {
				result = caseNamedElement(featurePrototype);
			}
			if (result == null) {
				result = caseElement(featurePrototype);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.FEATURE_GROUP_PROTOTYPE: {
			FeatureGroupPrototype featureGroupPrototype = (FeatureGroupPrototype) theEObject;
			T result = caseFeatureGroupPrototype(featureGroupPrototype);
			if (result == null) {
				result = casePrototype(featureGroupPrototype);
			}
			if (result == null) {
				result = caseFeatureType(featureGroupPrototype);
			}
			if (result == null) {
				result = caseStructuralFeature(featureGroupPrototype);
			}
			if (result == null) {
				result = caseCalledSubprogram(featureGroupPrototype);
			}
			if (result == null) {
				result = caseRefinableElement(featureGroupPrototype);
			}
			if (result == null) {
				result = caseClassifierFeature(featureGroupPrototype);
			}
			if (result == null) {
				result = caseNamedElement(featureGroupPrototype);
			}
			if (result == null) {
				result = caseElement(featureGroupPrototype);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.SUBCOMPONENT: {
			Subcomponent subcomponent = (Subcomponent) theEObject;
			T result = caseSubcomponent(subcomponent);
			if (result == null) {
				result = caseStructuralFeature(subcomponent);
			}
			if (result == null) {
				result = caseModalElement(subcomponent);
			}
			if (result == null) {
				result = caseContext(subcomponent);
			}
			if (result == null) {
				result = caseFlowElement(subcomponent);
			}
			if (result == null) {
				result = caseArrayableElement(subcomponent);
			}
			if (result == null) {
				result = caseRefinableElement(subcomponent);
			}
			if (result == null) {
				result = caseClassifierFeature(subcomponent);
			}
			if (result == null) {
				result = caseEndToEndFlowElement(subcomponent);
			}
			if (result == null) {
				result = caseNamedElement(subcomponent);
			}
			if (result == null) {
				result = caseElement(subcomponent);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.MODE_BINDING: {
			ModeBinding modeBinding = (ModeBinding) theEObject;
			T result = caseModeBinding(modeBinding);
			if (result == null) {
				result = caseElement(modeBinding);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.FLOW_IMPLEMENTATION: {
			FlowImplementation flowImplementation = (FlowImplementation) theEObject;
			T result = caseFlowImplementation(flowImplementation);
			if (result == null) {
				result = caseModalPath(flowImplementation);
			}
			if (result == null) {
				result = caseClassifierFeature(flowImplementation);
			}
			if (result == null) {
				result = caseFlow(flowImplementation);
			}
			if (result == null) {
				result = caseModalElement(flowImplementation);
			}
			if (result == null) {
				result = caseNamedElement(flowImplementation);
			}
			if (result == null) {
				result = caseElement(flowImplementation);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.FLOW_SEGMENT: {
			FlowSegment flowSegment = (FlowSegment) theEObject;
			T result = caseFlowSegment(flowSegment);
			if (result == null) {
				result = caseElement(flowSegment);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.CONNECTION: {
			Connection connection = (Connection) theEObject;
			T result = caseConnection(connection);
			if (result == null) {
				result = caseStructuralFeature(connection);
			}
			if (result == null) {
				result = caseModalPath(connection);
			}
			if (result == null) {
				result = caseFlowElement(connection);
			}
			if (result == null) {
				result = caseRefinableElement(connection);
			}
			if (result == null) {
				result = caseClassifierFeature(connection);
			}
			if (result == null) {
				result = caseModalElement(connection);
			}
			if (result == null) {
				result = caseEndToEndFlowElement(connection);
			}
			if (result == null) {
				result = caseNamedElement(connection);
			}
			if (result == null) {
				result = caseElement(connection);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.CONNECTED_ELEMENT: {
			ConnectedElement connectedElement = (ConnectedElement) theEObject;
			T result = caseConnectedElement(connectedElement);
			if (result == null) {
				result = caseElement(connectedElement);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.IMPLEMENTATION_EXTENSION: {
			ImplementationExtension implementationExtension = (ImplementationExtension) theEObject;
			T result = caseImplementationExtension(implementationExtension);
			if (result == null) {
				result = caseGeneralization(implementationExtension);
			}
			if (result == null) {
				result = caseDirectedRelationship(implementationExtension);
			}
			if (result == null) {
				result = caseRelationship(implementationExtension);
			}
			if (result == null) {
				result = caseElement(implementationExtension);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.REALIZATION: {
			Realization realization = (Realization) theEObject;
			T result = caseRealization(realization);
			if (result == null) {
				result = caseGeneralization(realization);
			}
			if (result == null) {
				result = caseDirectedRelationship(realization);
			}
			if (result == null) {
				result = caseRelationship(realization);
			}
			if (result == null) {
				result = caseElement(realization);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.END_TO_END_FLOW: {
			EndToEndFlow endToEndFlow = (EndToEndFlow) theEObject;
			T result = caseEndToEndFlow(endToEndFlow);
			if (result == null) {
				result = caseFlowFeature(endToEndFlow);
			}
			if (result == null) {
				result = caseModalPath(endToEndFlow);
			}
			if (result == null) {
				result = caseEndToEndFlowElement(endToEndFlow);
			}
			if (result == null) {
				result = caseStructuralFeature(endToEndFlow);
			}
			if (result == null) {
				result = caseFlow(endToEndFlow);
			}
			if (result == null) {
				result = caseModalElement(endToEndFlow);
			}
			if (result == null) {
				result = caseRefinableElement(endToEndFlow);
			}
			if (result == null) {
				result = caseClassifierFeature(endToEndFlow);
			}
			if (result == null) {
				result = caseNamedElement(endToEndFlow);
			}
			if (result == null) {
				result = caseElement(endToEndFlow);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.END_TO_END_FLOW_SEGMENT: {
			EndToEndFlowSegment endToEndFlowSegment = (EndToEndFlowSegment) theEObject;
			T result = caseEndToEndFlowSegment(endToEndFlowSegment);
			if (result == null) {
				result = caseElement(endToEndFlowSegment);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.ABSTRACT_SUBCOMPONENT: {
			AbstractSubcomponent abstractSubcomponent = (AbstractSubcomponent) theEObject;
			T result = caseAbstractSubcomponent(abstractSubcomponent);
			if (result == null) {
				result = caseSubcomponent(abstractSubcomponent);
			}
			if (result == null) {
				result = caseAbstract(abstractSubcomponent);
			}
			if (result == null) {
				result = caseStructuralFeature(abstractSubcomponent);
			}
			if (result == null) {
				result = caseModalElement(abstractSubcomponent);
			}
			if (result == null) {
				result = caseContext(abstractSubcomponent);
			}
			if (result == null) {
				result = caseFlowElement(abstractSubcomponent);
			}
			if (result == null) {
				result = caseArrayableElement(abstractSubcomponent);
			}
			if (result == null) {
				result = caseRefinableElement(abstractSubcomponent);
			}
			if (result == null) {
				result = caseClassifierFeature(abstractSubcomponent);
			}
			if (result == null) {
				result = caseEndToEndFlowElement(abstractSubcomponent);
			}
			if (result == null) {
				result = caseNamedElement(abstractSubcomponent);
			}
			if (result == null) {
				result = caseElement(abstractSubcomponent);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.ABSTRACT: {
			Abstract abstract_ = (Abstract) theEObject;
			T result = caseAbstract(abstract_);
			if (result == null) {
				result = caseNamedElement(abstract_);
			}
			if (result == null) {
				result = caseElement(abstract_);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.ABSTRACT_SUBCOMPONENT_TYPE: {
			AbstractSubcomponentType abstractSubcomponentType = (AbstractSubcomponentType) theEObject;
			T result = caseAbstractSubcomponentType(abstractSubcomponentType);
			if (result == null) {
				result = caseSubcomponentType(abstractSubcomponentType);
			}
			if (result == null) {
				result = caseType(abstractSubcomponentType);
			}
			if (result == null) {
				result = caseNamedElement(abstractSubcomponentType);
			}
			if (result == null) {
				result = caseElement(abstractSubcomponentType);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.ACCESS_CONNECTION: {
			AccessConnection accessConnection = (AccessConnection) theEObject;
			T result = caseAccessConnection(accessConnection);
			if (result == null) {
				result = caseConnection(accessConnection);
			}
			if (result == null) {
				result = caseStructuralFeature(accessConnection);
			}
			if (result == null) {
				result = caseModalPath(accessConnection);
			}
			if (result == null) {
				result = caseFlowElement(accessConnection);
			}
			if (result == null) {
				result = caseRefinableElement(accessConnection);
			}
			if (result == null) {
				result = caseClassifierFeature(accessConnection);
			}
			if (result == null) {
				result = caseModalElement(accessConnection);
			}
			if (result == null) {
				result = caseEndToEndFlowElement(accessConnection);
			}
			if (result == null) {
				result = caseNamedElement(accessConnection);
			}
			if (result == null) {
				result = caseElement(accessConnection);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.PARAMETER_CONNECTION: {
			ParameterConnection parameterConnection = (ParameterConnection) theEObject;
			T result = caseParameterConnection(parameterConnection);
			if (result == null) {
				result = caseConnection(parameterConnection);
			}
			if (result == null) {
				result = caseStructuralFeature(parameterConnection);
			}
			if (result == null) {
				result = caseModalPath(parameterConnection);
			}
			if (result == null) {
				result = caseFlowElement(parameterConnection);
			}
			if (result == null) {
				result = caseRefinableElement(parameterConnection);
			}
			if (result == null) {
				result = caseClassifierFeature(parameterConnection);
			}
			if (result == null) {
				result = caseModalElement(parameterConnection);
			}
			if (result == null) {
				result = caseEndToEndFlowElement(parameterConnection);
			}
			if (result == null) {
				result = caseNamedElement(parameterConnection);
			}
			if (result == null) {
				result = caseElement(parameterConnection);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.PORT_CONNECTION: {
			PortConnection portConnection = (PortConnection) theEObject;
			T result = casePortConnection(portConnection);
			if (result == null) {
				result = caseConnection(portConnection);
			}
			if (result == null) {
				result = caseStructuralFeature(portConnection);
			}
			if (result == null) {
				result = caseModalPath(portConnection);
			}
			if (result == null) {
				result = caseFlowElement(portConnection);
			}
			if (result == null) {
				result = caseRefinableElement(portConnection);
			}
			if (result == null) {
				result = caseClassifierFeature(portConnection);
			}
			if (result == null) {
				result = caseModalElement(portConnection);
			}
			if (result == null) {
				result = caseEndToEndFlowElement(portConnection);
			}
			if (result == null) {
				result = caseNamedElement(portConnection);
			}
			if (result == null) {
				result = caseElement(portConnection);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.FEATURE_CONNECTION: {
			FeatureConnection featureConnection = (FeatureConnection) theEObject;
			T result = caseFeatureConnection(featureConnection);
			if (result == null) {
				result = caseConnection(featureConnection);
			}
			if (result == null) {
				result = caseStructuralFeature(featureConnection);
			}
			if (result == null) {
				result = caseModalPath(featureConnection);
			}
			if (result == null) {
				result = caseFlowElement(featureConnection);
			}
			if (result == null) {
				result = caseRefinableElement(featureConnection);
			}
			if (result == null) {
				result = caseClassifierFeature(featureConnection);
			}
			if (result == null) {
				result = caseModalElement(featureConnection);
			}
			if (result == null) {
				result = caseEndToEndFlowElement(featureConnection);
			}
			if (result == null) {
				result = caseNamedElement(featureConnection);
			}
			if (result == null) {
				result = caseElement(featureConnection);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.FEATURE_GROUP_CONNECTION: {
			FeatureGroupConnection featureGroupConnection = (FeatureGroupConnection) theEObject;
			T result = caseFeatureGroupConnection(featureGroupConnection);
			if (result == null) {
				result = caseConnection(featureGroupConnection);
			}
			if (result == null) {
				result = caseStructuralFeature(featureGroupConnection);
			}
			if (result == null) {
				result = caseModalPath(featureGroupConnection);
			}
			if (result == null) {
				result = caseFlowElement(featureGroupConnection);
			}
			if (result == null) {
				result = caseRefinableElement(featureGroupConnection);
			}
			if (result == null) {
				result = caseClassifierFeature(featureGroupConnection);
			}
			if (result == null) {
				result = caseModalElement(featureGroupConnection);
			}
			if (result == null) {
				result = caseEndToEndFlowElement(featureGroupConnection);
			}
			if (result == null) {
				result = caseNamedElement(featureGroupConnection);
			}
			if (result == null) {
				result = caseElement(featureGroupConnection);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.PROCESSOR_FEATURE: {
			ProcessorFeature processorFeature = (ProcessorFeature) theEObject;
			T result = caseProcessorFeature(processorFeature);
			if (result == null) {
				result = caseStructuralFeature(processorFeature);
			}
			if (result == null) {
				result = caseRefinableElement(processorFeature);
			}
			if (result == null) {
				result = caseClassifierFeature(processorFeature);
			}
			if (result == null) {
				result = caseNamedElement(processorFeature);
			}
			if (result == null) {
				result = caseElement(processorFeature);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.INTERNAL_FEATURE: {
			InternalFeature internalFeature = (InternalFeature) theEObject;
			T result = caseInternalFeature(internalFeature);
			if (result == null) {
				result = caseStructuralFeature(internalFeature);
			}
			if (result == null) {
				result = caseFeatureConnectionEnd(internalFeature);
			}
			if (result == null) {
				result = casePortConnectionEnd(internalFeature);
			}
			if (result == null) {
				result = caseTriggerPort(internalFeature);
			}
			if (result == null) {
				result = caseRefinableElement(internalFeature);
			}
			if (result == null) {
				result = caseClassifierFeature(internalFeature);
			}
			if (result == null) {
				result = caseConnectionEnd(internalFeature);
			}
			if (result == null) {
				result = caseNamedElement(internalFeature);
			}
			if (result == null) {
				result = caseElement(internalFeature);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.EVENT_SOURCE: {
			EventSource eventSource = (EventSource) theEObject;
			T result = caseEventSource(eventSource);
			if (result == null) {
				result = caseInternalFeature(eventSource);
			}
			if (result == null) {
				result = caseStructuralFeature(eventSource);
			}
			if (result == null) {
				result = caseFeatureConnectionEnd(eventSource);
			}
			if (result == null) {
				result = casePortConnectionEnd(eventSource);
			}
			if (result == null) {
				result = caseTriggerPort(eventSource);
			}
			if (result == null) {
				result = caseRefinableElement(eventSource);
			}
			if (result == null) {
				result = caseClassifierFeature(eventSource);
			}
			if (result == null) {
				result = caseConnectionEnd(eventSource);
			}
			if (result == null) {
				result = caseNamedElement(eventSource);
			}
			if (result == null) {
				result = caseElement(eventSource);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.EVENT_DATA_SOURCE: {
			EventDataSource eventDataSource = (EventDataSource) theEObject;
			T result = caseEventDataSource(eventDataSource);
			if (result == null) {
				result = caseInternalFeature(eventDataSource);
			}
			if (result == null) {
				result = caseStructuralFeature(eventDataSource);
			}
			if (result == null) {
				result = caseFeatureConnectionEnd(eventDataSource);
			}
			if (result == null) {
				result = casePortConnectionEnd(eventDataSource);
			}
			if (result == null) {
				result = caseTriggerPort(eventDataSource);
			}
			if (result == null) {
				result = caseRefinableElement(eventDataSource);
			}
			if (result == null) {
				result = caseClassifierFeature(eventDataSource);
			}
			if (result == null) {
				result = caseConnectionEnd(eventDataSource);
			}
			if (result == null) {
				result = caseNamedElement(eventDataSource);
			}
			if (result == null) {
				result = caseElement(eventDataSource);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.DATA_CLASSIFIER: {
			DataClassifier dataClassifier = (DataClassifier) theEObject;
			T result = caseDataClassifier(dataClassifier);
			if (result == null) {
				result = caseComponentClassifier(dataClassifier);
			}
			if (result == null) {
				result = caseData(dataClassifier);
			}
			if (result == null) {
				result = caseDataSubcomponentType(dataClassifier);
			}
			if (result == null) {
				result = caseClassifier(dataClassifier);
			}
			if (result == null) {
				result = caseSubcomponentType(dataClassifier);
			}
			if (result == null) {
				result = caseFeatureClassifier(dataClassifier);
			}
			if (result == null) {
				result = caseNamespace(dataClassifier);
			}
			if (result == null) {
				result = caseType(dataClassifier);
			}
			if (result == null) {
				result = caseNamedElement(dataClassifier);
			}
			if (result == null) {
				result = caseElement(dataClassifier);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.DATA: {
			Data data = (Data) theEObject;
			T result = caseData(data);
			if (result == null) {
				result = caseNamedElement(data);
			}
			if (result == null) {
				result = caseElement(data);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.PORT_PROXY: {
			PortProxy portProxy = (PortProxy) theEObject;
			T result = casePortProxy(portProxy);
			if (result == null) {
				result = caseProcessorFeature(portProxy);
			}
			if (result == null) {
				result = caseFeatureConnectionEnd(portProxy);
			}
			if (result == null) {
				result = casePortConnectionEnd(portProxy);
			}
			if (result == null) {
				result = caseTriggerPort(portProxy);
			}
			if (result == null) {
				result = caseStructuralFeature(portProxy);
			}
			if (result == null) {
				result = caseConnectionEnd(portProxy);
			}
			if (result == null) {
				result = caseRefinableElement(portProxy);
			}
			if (result == null) {
				result = caseClassifierFeature(portProxy);
			}
			if (result == null) {
				result = caseNamedElement(portProxy);
			}
			if (result == null) {
				result = caseElement(portProxy);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.SUBPROGRAM_PROXY: {
			SubprogramProxy subprogramProxy = (SubprogramProxy) theEObject;
			T result = caseSubprogramProxy(subprogramProxy);
			if (result == null) {
				result = caseProcessorFeature(subprogramProxy);
			}
			if (result == null) {
				result = caseAccessConnectionEnd(subprogramProxy);
			}
			if (result == null) {
				result = caseCalledSubprogram(subprogramProxy);
			}
			if (result == null) {
				result = caseStructuralFeature(subprogramProxy);
			}
			if (result == null) {
				result = caseConnectionEnd(subprogramProxy);
			}
			if (result == null) {
				result = caseRefinableElement(subprogramProxy);
			}
			if (result == null) {
				result = caseClassifierFeature(subprogramProxy);
			}
			if (result == null) {
				result = caseNamedElement(subprogramProxy);
			}
			if (result == null) {
				result = caseElement(subprogramProxy);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.SUBPROGRAM_CLASSIFIER: {
			SubprogramClassifier subprogramClassifier = (SubprogramClassifier) theEObject;
			T result = caseSubprogramClassifier(subprogramClassifier);
			if (result == null) {
				result = caseComponentClassifier(subprogramClassifier);
			}
			if (result == null) {
				result = caseSubprogram(subprogramClassifier);
			}
			if (result == null) {
				result = caseSubprogramSubcomponentType(subprogramClassifier);
			}
			if (result == null) {
				result = caseClassifier(subprogramClassifier);
			}
			if (result == null) {
				result = caseSubcomponentType(subprogramClassifier);
			}
			if (result == null) {
				result = caseFeatureClassifier(subprogramClassifier);
			}
			if (result == null) {
				result = caseCalledSubprogram(subprogramClassifier);
			}
			if (result == null) {
				result = caseNamespace(subprogramClassifier);
			}
			if (result == null) {
				result = caseType(subprogramClassifier);
			}
			if (result == null) {
				result = caseNamedElement(subprogramClassifier);
			}
			if (result == null) {
				result = caseElement(subprogramClassifier);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.SUBPROGRAM: {
			Subprogram subprogram = (Subprogram) theEObject;
			T result = caseSubprogram(subprogram);
			if (result == null) {
				result = caseNamedElement(subprogram);
			}
			if (result == null) {
				result = caseCalledSubprogram(subprogram);
			}
			if (result == null) {
				result = caseElement(subprogram);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.ANNEX_LIBRARY: {
			AnnexLibrary annexLibrary = (AnnexLibrary) theEObject;
			T result = caseAnnexLibrary(annexLibrary);
			if (result == null) {
				result = caseNamedElement(annexLibrary);
			}
			if (result == null) {
				result = caseElement(annexLibrary);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.DEFAULT_ANNEX_LIBRARY: {
			DefaultAnnexLibrary defaultAnnexLibrary = (DefaultAnnexLibrary) theEObject;
			T result = caseDefaultAnnexLibrary(defaultAnnexLibrary);
			if (result == null) {
				result = caseAnnexLibrary(defaultAnnexLibrary);
			}
			if (result == null) {
				result = caseNamedElement(defaultAnnexLibrary);
			}
			if (result == null) {
				result = caseElement(defaultAnnexLibrary);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.DEFAULT_ANNEX_SUBCLAUSE: {
			DefaultAnnexSubclause defaultAnnexSubclause = (DefaultAnnexSubclause) theEObject;
			T result = caseDefaultAnnexSubclause(defaultAnnexSubclause);
			if (result == null) {
				result = caseAnnexSubclause(defaultAnnexSubclause);
			}
			if (result == null) {
				result = caseModalElement(defaultAnnexSubclause);
			}
			if (result == null) {
				result = caseNamedElement(defaultAnnexSubclause);
			}
			if (result == null) {
				result = caseElement(defaultAnnexSubclause);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.PUBLIC_PACKAGE_SECTION: {
			PublicPackageSection publicPackageSection = (PublicPackageSection) theEObject;
			T result = casePublicPackageSection(publicPackageSection);
			if (result == null) {
				result = casePackageSection(publicPackageSection);
			}
			if (result == null) {
				result = caseNamespace(publicPackageSection);
			}
			if (result == null) {
				result = caseNamedElement(publicPackageSection);
			}
			if (result == null) {
				result = caseElement(publicPackageSection);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.PACKAGE_SECTION: {
			PackageSection packageSection = (PackageSection) theEObject;
			T result = casePackageSection(packageSection);
			if (result == null) {
				result = caseNamespace(packageSection);
			}
			if (result == null) {
				result = caseNamedElement(packageSection);
			}
			if (result == null) {
				result = caseElement(packageSection);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.PACKAGE_RENAME: {
			PackageRename packageRename = (PackageRename) theEObject;
			T result = casePackageRename(packageRename);
			if (result == null) {
				result = caseNamedElement(packageRename);
			}
			if (result == null) {
				result = caseElement(packageRename);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.AADL_PACKAGE: {
			AadlPackage aadlPackage = (AadlPackage) theEObject;
			T result = caseAadlPackage(aadlPackage);
			if (result == null) {
				result = caseModelUnit(aadlPackage);
			}
			if (result == null) {
				result = caseNamedElement(aadlPackage);
			}
			if (result == null) {
				result = caseElement(aadlPackage);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.MODEL_UNIT: {
			ModelUnit modelUnit = (ModelUnit) theEObject;
			T result = caseModelUnit(modelUnit);
			if (result == null) {
				result = caseNamedElement(modelUnit);
			}
			if (result == null) {
				result = caseElement(modelUnit);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.PRIVATE_PACKAGE_SECTION: {
			PrivatePackageSection privatePackageSection = (PrivatePackageSection) theEObject;
			T result = casePrivatePackageSection(privatePackageSection);
			if (result == null) {
				result = casePackageSection(privatePackageSection);
			}
			if (result == null) {
				result = caseNamespace(privatePackageSection);
			}
			if (result == null) {
				result = caseNamedElement(privatePackageSection);
			}
			if (result == null) {
				result = caseElement(privatePackageSection);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.COMPONENT_TYPE_RENAME: {
			ComponentTypeRename componentTypeRename = (ComponentTypeRename) theEObject;
			T result = caseComponentTypeRename(componentTypeRename);
			if (result == null) {
				result = caseNamedElement(componentTypeRename);
			}
			if (result == null) {
				result = caseElement(componentTypeRename);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.FEATURE_GROUP_TYPE_RENAME: {
			FeatureGroupTypeRename featureGroupTypeRename = (FeatureGroupTypeRename) theEObject;
			T result = caseFeatureGroupTypeRename(featureGroupTypeRename);
			if (result == null) {
				result = caseNamedElement(featureGroupTypeRename);
			}
			if (result == null) {
				result = caseElement(featureGroupTypeRename);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.COMPONENT_PROTOTYPE_BINDING: {
			ComponentPrototypeBinding componentPrototypeBinding = (ComponentPrototypeBinding) theEObject;
			T result = caseComponentPrototypeBinding(componentPrototypeBinding);
			if (result == null) {
				result = casePrototypeBinding(componentPrototypeBinding);
			}
			if (result == null) {
				result = caseElement(componentPrototypeBinding);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.COMPONENT_PROTOTYPE_ACTUAL: {
			ComponentPrototypeActual componentPrototypeActual = (ComponentPrototypeActual) theEObject;
			T result = caseComponentPrototypeActual(componentPrototypeActual);
			if (result == null) {
				result = caseArrayableElement(componentPrototypeActual);
			}
			if (result == null) {
				result = caseElement(componentPrototypeActual);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.FEATURE_GROUP_PROTOTYPE_BINDING: {
			FeatureGroupPrototypeBinding featureGroupPrototypeBinding = (FeatureGroupPrototypeBinding) theEObject;
			T result = caseFeatureGroupPrototypeBinding(featureGroupPrototypeBinding);
			if (result == null) {
				result = casePrototypeBinding(featureGroupPrototypeBinding);
			}
			if (result == null) {
				result = caseElement(featureGroupPrototypeBinding);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.FEATURE_GROUP_PROTOTYPE_ACTUAL: {
			FeatureGroupPrototypeActual featureGroupPrototypeActual = (FeatureGroupPrototypeActual) theEObject;
			T result = caseFeatureGroupPrototypeActual(featureGroupPrototypeActual);
			if (result == null) {
				result = caseFeaturePrototypeActual(featureGroupPrototypeActual);
			}
			if (result == null) {
				result = caseArrayableElement(featureGroupPrototypeActual);
			}
			if (result == null) {
				result = caseElement(featureGroupPrototypeActual);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.FEATURE_PROTOTYPE_ACTUAL: {
			FeaturePrototypeActual featurePrototypeActual = (FeaturePrototypeActual) theEObject;
			T result = caseFeaturePrototypeActual(featurePrototypeActual);
			if (result == null) {
				result = caseArrayableElement(featurePrototypeActual);
			}
			if (result == null) {
				result = caseElement(featurePrototypeActual);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.FEATURE_PROTOTYPE_BINDING: {
			FeaturePrototypeBinding featurePrototypeBinding = (FeaturePrototypeBinding) theEObject;
			T result = caseFeaturePrototypeBinding(featurePrototypeBinding);
			if (result == null) {
				result = casePrototypeBinding(featurePrototypeBinding);
			}
			if (result == null) {
				result = caseElement(featurePrototypeBinding);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.ACCESS_SPECIFICATION: {
			AccessSpecification accessSpecification = (AccessSpecification) theEObject;
			T result = caseAccessSpecification(accessSpecification);
			if (result == null) {
				result = caseFeaturePrototypeActual(accessSpecification);
			}
			if (result == null) {
				result = caseArrayableElement(accessSpecification);
			}
			if (result == null) {
				result = caseElement(accessSpecification);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.PORT_SPECIFICATION: {
			PortSpecification portSpecification = (PortSpecification) theEObject;
			T result = casePortSpecification(portSpecification);
			if (result == null) {
				result = caseFeaturePrototypeActual(portSpecification);
			}
			if (result == null) {
				result = caseArrayableElement(portSpecification);
			}
			if (result == null) {
				result = caseElement(portSpecification);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.FEATURE_PROTOTYPE_REFERENCE: {
			FeaturePrototypeReference featurePrototypeReference = (FeaturePrototypeReference) theEObject;
			T result = caseFeaturePrototypeReference(featurePrototypeReference);
			if (result == null) {
				result = caseFeaturePrototypeActual(featurePrototypeReference);
			}
			if (result == null) {
				result = caseArrayableElement(featurePrototypeReference);
			}
			if (result == null) {
				result = caseElement(featurePrototypeReference);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.SUBPROGRAM_CALL_SEQUENCE: {
			SubprogramCallSequence subprogramCallSequence = (SubprogramCallSequence) theEObject;
			T result = caseSubprogramCallSequence(subprogramCallSequence);
			if (result == null) {
				result = caseBehavioralFeature(subprogramCallSequence);
			}
			if (result == null) {
				result = caseModalElement(subprogramCallSequence);
			}
			if (result == null) {
				result = caseClassifierFeature(subprogramCallSequence);
			}
			if (result == null) {
				result = caseNamedElement(subprogramCallSequence);
			}
			if (result == null) {
				result = caseElement(subprogramCallSequence);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.SUBPROGRAM_CALL: {
			SubprogramCall subprogramCall = (SubprogramCall) theEObject;
			T result = caseSubprogramCall(subprogramCall);
			if (result == null) {
				result = caseBehavioralFeature(subprogramCall);
			}
			if (result == null) {
				result = caseContext(subprogramCall);
			}
			if (result == null) {
				result = caseClassifierFeature(subprogramCall);
			}
			if (result == null) {
				result = caseNamedElement(subprogramCall);
			}
			if (result == null) {
				result = caseElement(subprogramCall);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.BEHAVIORED_IMPLEMENTATION: {
			BehavioredImplementation behavioredImplementation = (BehavioredImplementation) theEObject;
			T result = caseBehavioredImplementation(behavioredImplementation);
			if (result == null) {
				result = caseComponentImplementation(behavioredImplementation);
			}
			if (result == null) {
				result = caseComponentClassifier(behavioredImplementation);
			}
			if (result == null) {
				result = caseClassifier(behavioredImplementation);
			}
			if (result == null) {
				result = caseSubcomponentType(behavioredImplementation);
			}
			if (result == null) {
				result = caseFeatureClassifier(behavioredImplementation);
			}
			if (result == null) {
				result = caseNamespace(behavioredImplementation);
			}
			if (result == null) {
				result = caseType(behavioredImplementation);
			}
			if (result == null) {
				result = caseNamedElement(behavioredImplementation);
			}
			if (result == null) {
				result = caseElement(behavioredImplementation);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.ABSTRACT_TYPE: {
			AbstractType abstractType = (AbstractType) theEObject;
			T result = caseAbstractType(abstractType);
			if (result == null) {
				result = caseComponentType(abstractType);
			}
			if (result == null) {
				result = caseAbstractClassifier(abstractType);
			}
			if (result == null) {
				result = caseCallContext(abstractType);
			}
			if (result == null) {
				result = caseComponentClassifier(abstractType);
			}
			if (result == null) {
				result = caseAbstract(abstractType);
			}
			if (result == null) {
				result = caseAbstractSubcomponentType(abstractType);
			}
			if (result == null) {
				result = caseBusSubcomponentType(abstractType);
			}
			if (result == null) {
				result = caseDataSubcomponentType(abstractType);
			}
			if (result == null) {
				result = caseDeviceSubcomponentType(abstractType);
			}
			if (result == null) {
				result = caseMemorySubcomponentType(abstractType);
			}
			if (result == null) {
				result = caseProcessorSubcomponentType(abstractType);
			}
			if (result == null) {
				result = caseProcessSubcomponentType(abstractType);
			}
			if (result == null) {
				result = caseSubprogramGroupSubcomponentType(abstractType);
			}
			if (result == null) {
				result = caseSubprogramSubcomponentType(abstractType);
			}
			if (result == null) {
				result = caseSystemSubcomponentType(abstractType);
			}
			if (result == null) {
				result = caseThreadGroupSubcomponentType(abstractType);
			}
			if (result == null) {
				result = caseThreadSubcomponentType(abstractType);
			}
			if (result == null) {
				result = caseVirtualBusSubcomponentType(abstractType);
			}
			if (result == null) {
				result = caseVirtualProcessorSubcomponentType(abstractType);
			}
			if (result == null) {
				result = caseClassifier(abstractType);
			}
			if (result == null) {
				result = caseSubcomponentType(abstractType);
			}
			if (result == null) {
				result = caseFeatureClassifier(abstractType);
			}
			if (result == null) {
				result = caseNamespace(abstractType);
			}
			if (result == null) {
				result = caseType(abstractType);
			}
			if (result == null) {
				result = caseNamedElement(abstractType);
			}
			if (result == null) {
				result = caseElement(abstractType);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.ABSTRACT_CLASSIFIER: {
			AbstractClassifier abstractClassifier = (AbstractClassifier) theEObject;
			T result = caseAbstractClassifier(abstractClassifier);
			if (result == null) {
				result = caseComponentClassifier(abstractClassifier);
			}
			if (result == null) {
				result = caseAbstract(abstractClassifier);
			}
			if (result == null) {
				result = caseAbstractSubcomponentType(abstractClassifier);
			}
			if (result == null) {
				result = caseBusSubcomponentType(abstractClassifier);
			}
			if (result == null) {
				result = caseDataSubcomponentType(abstractClassifier);
			}
			if (result == null) {
				result = caseDeviceSubcomponentType(abstractClassifier);
			}
			if (result == null) {
				result = caseMemorySubcomponentType(abstractClassifier);
			}
			if (result == null) {
				result = caseProcessorSubcomponentType(abstractClassifier);
			}
			if (result == null) {
				result = caseProcessSubcomponentType(abstractClassifier);
			}
			if (result == null) {
				result = caseSubprogramGroupSubcomponentType(abstractClassifier);
			}
			if (result == null) {
				result = caseSubprogramSubcomponentType(abstractClassifier);
			}
			if (result == null) {
				result = caseSystemSubcomponentType(abstractClassifier);
			}
			if (result == null) {
				result = caseThreadGroupSubcomponentType(abstractClassifier);
			}
			if (result == null) {
				result = caseThreadSubcomponentType(abstractClassifier);
			}
			if (result == null) {
				result = caseVirtualBusSubcomponentType(abstractClassifier);
			}
			if (result == null) {
				result = caseVirtualProcessorSubcomponentType(abstractClassifier);
			}
			if (result == null) {
				result = caseClassifier(abstractClassifier);
			}
			if (result == null) {
				result = caseSubcomponentType(abstractClassifier);
			}
			if (result == null) {
				result = caseFeatureClassifier(abstractClassifier);
			}
			if (result == null) {
				result = caseNamespace(abstractClassifier);
			}
			if (result == null) {
				result = caseType(abstractClassifier);
			}
			if (result == null) {
				result = caseNamedElement(abstractClassifier);
			}
			if (result == null) {
				result = caseElement(abstractClassifier);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.VIRTUAL_PROCESSOR_SUBCOMPONENT_TYPE: {
			VirtualProcessorSubcomponentType virtualProcessorSubcomponentType = (VirtualProcessorSubcomponentType) theEObject;
			T result = caseVirtualProcessorSubcomponentType(virtualProcessorSubcomponentType);
			if (result == null) {
				result = caseSubcomponentType(virtualProcessorSubcomponentType);
			}
			if (result == null) {
				result = caseType(virtualProcessorSubcomponentType);
			}
			if (result == null) {
				result = caseNamedElement(virtualProcessorSubcomponentType);
			}
			if (result == null) {
				result = caseElement(virtualProcessorSubcomponentType);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.VIRTUAL_BUS_SUBCOMPONENT_TYPE: {
			VirtualBusSubcomponentType virtualBusSubcomponentType = (VirtualBusSubcomponentType) theEObject;
			T result = caseVirtualBusSubcomponentType(virtualBusSubcomponentType);
			if (result == null) {
				result = caseSubcomponentType(virtualBusSubcomponentType);
			}
			if (result == null) {
				result = caseType(virtualBusSubcomponentType);
			}
			if (result == null) {
				result = caseNamedElement(virtualBusSubcomponentType);
			}
			if (result == null) {
				result = caseElement(virtualBusSubcomponentType);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.THREAD_GROUP_SUBCOMPONENT_TYPE: {
			ThreadGroupSubcomponentType threadGroupSubcomponentType = (ThreadGroupSubcomponentType) theEObject;
			T result = caseThreadGroupSubcomponentType(threadGroupSubcomponentType);
			if (result == null) {
				result = caseSubcomponentType(threadGroupSubcomponentType);
			}
			if (result == null) {
				result = caseType(threadGroupSubcomponentType);
			}
			if (result == null) {
				result = caseNamedElement(threadGroupSubcomponentType);
			}
			if (result == null) {
				result = caseElement(threadGroupSubcomponentType);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.THREAD_SUBCOMPONENT_TYPE: {
			ThreadSubcomponentType threadSubcomponentType = (ThreadSubcomponentType) theEObject;
			T result = caseThreadSubcomponentType(threadSubcomponentType);
			if (result == null) {
				result = caseSubcomponentType(threadSubcomponentType);
			}
			if (result == null) {
				result = caseType(threadSubcomponentType);
			}
			if (result == null) {
				result = caseNamedElement(threadSubcomponentType);
			}
			if (result == null) {
				result = caseElement(threadSubcomponentType);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.SYSTEM_SUBCOMPONENT_TYPE: {
			SystemSubcomponentType systemSubcomponentType = (SystemSubcomponentType) theEObject;
			T result = caseSystemSubcomponentType(systemSubcomponentType);
			if (result == null) {
				result = caseSubcomponentType(systemSubcomponentType);
			}
			if (result == null) {
				result = caseType(systemSubcomponentType);
			}
			if (result == null) {
				result = caseNamedElement(systemSubcomponentType);
			}
			if (result == null) {
				result = caseElement(systemSubcomponentType);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.PROCESS_SUBCOMPONENT_TYPE: {
			ProcessSubcomponentType processSubcomponentType = (ProcessSubcomponentType) theEObject;
			T result = caseProcessSubcomponentType(processSubcomponentType);
			if (result == null) {
				result = caseSubcomponentType(processSubcomponentType);
			}
			if (result == null) {
				result = caseType(processSubcomponentType);
			}
			if (result == null) {
				result = caseNamedElement(processSubcomponentType);
			}
			if (result == null) {
				result = caseElement(processSubcomponentType);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.MEMORY_SUBCOMPONENT_TYPE: {
			MemorySubcomponentType memorySubcomponentType = (MemorySubcomponentType) theEObject;
			T result = caseMemorySubcomponentType(memorySubcomponentType);
			if (result == null) {
				result = caseSubcomponentType(memorySubcomponentType);
			}
			if (result == null) {
				result = caseType(memorySubcomponentType);
			}
			if (result == null) {
				result = caseNamedElement(memorySubcomponentType);
			}
			if (result == null) {
				result = caseElement(memorySubcomponentType);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.DEVICE_SUBCOMPONENT_TYPE: {
			DeviceSubcomponentType deviceSubcomponentType = (DeviceSubcomponentType) theEObject;
			T result = caseDeviceSubcomponentType(deviceSubcomponentType);
			if (result == null) {
				result = caseSubcomponentType(deviceSubcomponentType);
			}
			if (result == null) {
				result = caseType(deviceSubcomponentType);
			}
			if (result == null) {
				result = caseNamedElement(deviceSubcomponentType);
			}
			if (result == null) {
				result = caseElement(deviceSubcomponentType);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.PROCESSOR_SUBCOMPONENT_TYPE: {
			ProcessorSubcomponentType processorSubcomponentType = (ProcessorSubcomponentType) theEObject;
			T result = caseProcessorSubcomponentType(processorSubcomponentType);
			if (result == null) {
				result = caseSubcomponentType(processorSubcomponentType);
			}
			if (result == null) {
				result = caseType(processorSubcomponentType);
			}
			if (result == null) {
				result = caseNamedElement(processorSubcomponentType);
			}
			if (result == null) {
				result = caseElement(processorSubcomponentType);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.ABSTRACT_IMPLEMENTATION: {
			AbstractImplementation abstractImplementation = (AbstractImplementation) theEObject;
			T result = caseAbstractImplementation(abstractImplementation);
			if (result == null) {
				result = caseBehavioredImplementation(abstractImplementation);
			}
			if (result == null) {
				result = caseAbstractClassifier(abstractImplementation);
			}
			if (result == null) {
				result = caseComponentImplementation(abstractImplementation);
			}
			if (result == null) {
				result = caseAbstract(abstractImplementation);
			}
			if (result == null) {
				result = caseAbstractSubcomponentType(abstractImplementation);
			}
			if (result == null) {
				result = caseBusSubcomponentType(abstractImplementation);
			}
			if (result == null) {
				result = caseDataSubcomponentType(abstractImplementation);
			}
			if (result == null) {
				result = caseDeviceSubcomponentType(abstractImplementation);
			}
			if (result == null) {
				result = caseMemorySubcomponentType(abstractImplementation);
			}
			if (result == null) {
				result = caseProcessorSubcomponentType(abstractImplementation);
			}
			if (result == null) {
				result = caseProcessSubcomponentType(abstractImplementation);
			}
			if (result == null) {
				result = caseSubprogramGroupSubcomponentType(abstractImplementation);
			}
			if (result == null) {
				result = caseSubprogramSubcomponentType(abstractImplementation);
			}
			if (result == null) {
				result = caseSystemSubcomponentType(abstractImplementation);
			}
			if (result == null) {
				result = caseThreadGroupSubcomponentType(abstractImplementation);
			}
			if (result == null) {
				result = caseThreadSubcomponentType(abstractImplementation);
			}
			if (result == null) {
				result = caseVirtualBusSubcomponentType(abstractImplementation);
			}
			if (result == null) {
				result = caseVirtualProcessorSubcomponentType(abstractImplementation);
			}
			if (result == null) {
				result = caseComponentClassifier(abstractImplementation);
			}
			if (result == null) {
				result = caseClassifier(abstractImplementation);
			}
			if (result == null) {
				result = caseSubcomponentType(abstractImplementation);
			}
			if (result == null) {
				result = caseFeatureClassifier(abstractImplementation);
			}
			if (result == null) {
				result = caseNamespace(abstractImplementation);
			}
			if (result == null) {
				result = caseType(abstractImplementation);
			}
			if (result == null) {
				result = caseNamedElement(abstractImplementation);
			}
			if (result == null) {
				result = caseElement(abstractImplementation);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.BUS_SUBCOMPONENT: {
			BusSubcomponent busSubcomponent = (BusSubcomponent) theEObject;
			T result = caseBusSubcomponent(busSubcomponent);
			if (result == null) {
				result = caseSubcomponent(busSubcomponent);
			}
			if (result == null) {
				result = caseAccessConnectionEnd(busSubcomponent);
			}
			if (result == null) {
				result = caseBus(busSubcomponent);
			}
			if (result == null) {
				result = caseStructuralFeature(busSubcomponent);
			}
			if (result == null) {
				result = caseModalElement(busSubcomponent);
			}
			if (result == null) {
				result = caseContext(busSubcomponent);
			}
			if (result == null) {
				result = caseFlowElement(busSubcomponent);
			}
			if (result == null) {
				result = caseArrayableElement(busSubcomponent);
			}
			if (result == null) {
				result = caseConnectionEnd(busSubcomponent);
			}
			if (result == null) {
				result = caseRefinableElement(busSubcomponent);
			}
			if (result == null) {
				result = caseClassifierFeature(busSubcomponent);
			}
			if (result == null) {
				result = caseEndToEndFlowElement(busSubcomponent);
			}
			if (result == null) {
				result = caseNamedElement(busSubcomponent);
			}
			if (result == null) {
				result = caseElement(busSubcomponent);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.BUS: {
			Bus bus = (Bus) theEObject;
			T result = caseBus(bus);
			if (result == null) {
				result = caseNamedElement(bus);
			}
			if (result == null) {
				result = caseElement(bus);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.DATA_SUBCOMPONENT: {
			DataSubcomponent dataSubcomponent = (DataSubcomponent) theEObject;
			T result = caseDataSubcomponent(dataSubcomponent);
			if (result == null) {
				result = caseSubcomponent(dataSubcomponent);
			}
			if (result == null) {
				result = caseAccessConnectionEnd(dataSubcomponent);
			}
			if (result == null) {
				result = caseData(dataSubcomponent);
			}
			if (result == null) {
				result = caseParameterConnectionEnd(dataSubcomponent);
			}
			if (result == null) {
				result = casePortConnectionEnd(dataSubcomponent);
			}
			if (result == null) {
				result = caseStructuralFeature(dataSubcomponent);
			}
			if (result == null) {
				result = caseModalElement(dataSubcomponent);
			}
			if (result == null) {
				result = caseContext(dataSubcomponent);
			}
			if (result == null) {
				result = caseFlowElement(dataSubcomponent);
			}
			if (result == null) {
				result = caseArrayableElement(dataSubcomponent);
			}
			if (result == null) {
				result = caseConnectionEnd(dataSubcomponent);
			}
			if (result == null) {
				result = caseRefinableElement(dataSubcomponent);
			}
			if (result == null) {
				result = caseClassifierFeature(dataSubcomponent);
			}
			if (result == null) {
				result = caseEndToEndFlowElement(dataSubcomponent);
			}
			if (result == null) {
				result = caseNamedElement(dataSubcomponent);
			}
			if (result == null) {
				result = caseElement(dataSubcomponent);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.DEVICE_SUBCOMPONENT: {
			DeviceSubcomponent deviceSubcomponent = (DeviceSubcomponent) theEObject;
			T result = caseDeviceSubcomponent(deviceSubcomponent);
			if (result == null) {
				result = caseSubcomponent(deviceSubcomponent);
			}
			if (result == null) {
				result = caseDevice(deviceSubcomponent);
			}
			if (result == null) {
				result = caseStructuralFeature(deviceSubcomponent);
			}
			if (result == null) {
				result = caseModalElement(deviceSubcomponent);
			}
			if (result == null) {
				result = caseContext(deviceSubcomponent);
			}
			if (result == null) {
				result = caseFlowElement(deviceSubcomponent);
			}
			if (result == null) {
				result = caseArrayableElement(deviceSubcomponent);
			}
			if (result == null) {
				result = caseRefinableElement(deviceSubcomponent);
			}
			if (result == null) {
				result = caseClassifierFeature(deviceSubcomponent);
			}
			if (result == null) {
				result = caseEndToEndFlowElement(deviceSubcomponent);
			}
			if (result == null) {
				result = caseNamedElement(deviceSubcomponent);
			}
			if (result == null) {
				result = caseElement(deviceSubcomponent);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.DEVICE: {
			Device device = (Device) theEObject;
			T result = caseDevice(device);
			if (result == null) {
				result = caseNamedElement(device);
			}
			if (result == null) {
				result = caseElement(device);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.MEMORY_SUBCOMPONENT: {
			MemorySubcomponent memorySubcomponent = (MemorySubcomponent) theEObject;
			T result = caseMemorySubcomponent(memorySubcomponent);
			if (result == null) {
				result = caseSubcomponent(memorySubcomponent);
			}
			if (result == null) {
				result = caseMemory(memorySubcomponent);
			}
			if (result == null) {
				result = caseStructuralFeature(memorySubcomponent);
			}
			if (result == null) {
				result = caseModalElement(memorySubcomponent);
			}
			if (result == null) {
				result = caseContext(memorySubcomponent);
			}
			if (result == null) {
				result = caseFlowElement(memorySubcomponent);
			}
			if (result == null) {
				result = caseArrayableElement(memorySubcomponent);
			}
			if (result == null) {
				result = caseRefinableElement(memorySubcomponent);
			}
			if (result == null) {
				result = caseClassifierFeature(memorySubcomponent);
			}
			if (result == null) {
				result = caseEndToEndFlowElement(memorySubcomponent);
			}
			if (result == null) {
				result = caseNamedElement(memorySubcomponent);
			}
			if (result == null) {
				result = caseElement(memorySubcomponent);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.MEMORY: {
			Memory memory = (Memory) theEObject;
			T result = caseMemory(memory);
			if (result == null) {
				result = caseNamedElement(memory);
			}
			if (result == null) {
				result = caseElement(memory);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.PROCESS_SUBCOMPONENT: {
			ProcessSubcomponent processSubcomponent = (ProcessSubcomponent) theEObject;
			T result = caseProcessSubcomponent(processSubcomponent);
			if (result == null) {
				result = caseSubcomponent(processSubcomponent);
			}
			if (result == null) {
				result = caseProcess(processSubcomponent);
			}
			if (result == null) {
				result = caseStructuralFeature(processSubcomponent);
			}
			if (result == null) {
				result = caseModalElement(processSubcomponent);
			}
			if (result == null) {
				result = caseContext(processSubcomponent);
			}
			if (result == null) {
				result = caseFlowElement(processSubcomponent);
			}
			if (result == null) {
				result = caseArrayableElement(processSubcomponent);
			}
			if (result == null) {
				result = caseRefinableElement(processSubcomponent);
			}
			if (result == null) {
				result = caseClassifierFeature(processSubcomponent);
			}
			if (result == null) {
				result = caseEndToEndFlowElement(processSubcomponent);
			}
			if (result == null) {
				result = caseNamedElement(processSubcomponent);
			}
			if (result == null) {
				result = caseElement(processSubcomponent);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.PROCESS: {
			org.osate.aadl2.Process process = (org.osate.aadl2.Process) theEObject;
			T result = caseProcess(process);
			if (result == null) {
				result = caseNamedElement(process);
			}
			if (result == null) {
				result = caseElement(process);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.PROCESSOR_SUBCOMPONENT: {
			ProcessorSubcomponent processorSubcomponent = (ProcessorSubcomponent) theEObject;
			T result = caseProcessorSubcomponent(processorSubcomponent);
			if (result == null) {
				result = caseSubcomponent(processorSubcomponent);
			}
			if (result == null) {
				result = caseProcessor(processorSubcomponent);
			}
			if (result == null) {
				result = caseStructuralFeature(processorSubcomponent);
			}
			if (result == null) {
				result = caseModalElement(processorSubcomponent);
			}
			if (result == null) {
				result = caseContext(processorSubcomponent);
			}
			if (result == null) {
				result = caseFlowElement(processorSubcomponent);
			}
			if (result == null) {
				result = caseArrayableElement(processorSubcomponent);
			}
			if (result == null) {
				result = caseRefinableElement(processorSubcomponent);
			}
			if (result == null) {
				result = caseClassifierFeature(processorSubcomponent);
			}
			if (result == null) {
				result = caseEndToEndFlowElement(processorSubcomponent);
			}
			if (result == null) {
				result = caseNamedElement(processorSubcomponent);
			}
			if (result == null) {
				result = caseElement(processorSubcomponent);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.PROCESSOR: {
			Processor processor = (Processor) theEObject;
			T result = caseProcessor(processor);
			if (result == null) {
				result = caseNamedElement(processor);
			}
			if (result == null) {
				result = caseElement(processor);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.SYSTEM_SUBCOMPONENT: {
			SystemSubcomponent systemSubcomponent = (SystemSubcomponent) theEObject;
			T result = caseSystemSubcomponent(systemSubcomponent);
			if (result == null) {
				result = caseSubcomponent(systemSubcomponent);
			}
			if (result == null) {
				result = caseSystem(systemSubcomponent);
			}
			if (result == null) {
				result = caseStructuralFeature(systemSubcomponent);
			}
			if (result == null) {
				result = caseModalElement(systemSubcomponent);
			}
			if (result == null) {
				result = caseContext(systemSubcomponent);
			}
			if (result == null) {
				result = caseFlowElement(systemSubcomponent);
			}
			if (result == null) {
				result = caseArrayableElement(systemSubcomponent);
			}
			if (result == null) {
				result = caseRefinableElement(systemSubcomponent);
			}
			if (result == null) {
				result = caseClassifierFeature(systemSubcomponent);
			}
			if (result == null) {
				result = caseEndToEndFlowElement(systemSubcomponent);
			}
			if (result == null) {
				result = caseNamedElement(systemSubcomponent);
			}
			if (result == null) {
				result = caseElement(systemSubcomponent);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.SYSTEM: {
			org.osate.aadl2.System system = (org.osate.aadl2.System) theEObject;
			T result = caseSystem(system);
			if (result == null) {
				result = caseNamedElement(system);
			}
			if (result == null) {
				result = caseElement(system);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.SUBPROGRAM_SUBCOMPONENT: {
			SubprogramSubcomponent subprogramSubcomponent = (SubprogramSubcomponent) theEObject;
			T result = caseSubprogramSubcomponent(subprogramSubcomponent);
			if (result == null) {
				result = caseSubcomponent(subprogramSubcomponent);
			}
			if (result == null) {
				result = caseAccessConnectionEnd(subprogramSubcomponent);
			}
			if (result == null) {
				result = caseSubprogram(subprogramSubcomponent);
			}
			if (result == null) {
				result = caseStructuralFeature(subprogramSubcomponent);
			}
			if (result == null) {
				result = caseModalElement(subprogramSubcomponent);
			}
			if (result == null) {
				result = caseContext(subprogramSubcomponent);
			}
			if (result == null) {
				result = caseFlowElement(subprogramSubcomponent);
			}
			if (result == null) {
				result = caseArrayableElement(subprogramSubcomponent);
			}
			if (result == null) {
				result = caseConnectionEnd(subprogramSubcomponent);
			}
			if (result == null) {
				result = caseCalledSubprogram(subprogramSubcomponent);
			}
			if (result == null) {
				result = caseRefinableElement(subprogramSubcomponent);
			}
			if (result == null) {
				result = caseClassifierFeature(subprogramSubcomponent);
			}
			if (result == null) {
				result = caseEndToEndFlowElement(subprogramSubcomponent);
			}
			if (result == null) {
				result = caseNamedElement(subprogramSubcomponent);
			}
			if (result == null) {
				result = caseElement(subprogramSubcomponent);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.SUBPROGRAM_GROUP_SUBCOMPONENT: {
			SubprogramGroupSubcomponent subprogramGroupSubcomponent = (SubprogramGroupSubcomponent) theEObject;
			T result = caseSubprogramGroupSubcomponent(subprogramGroupSubcomponent);
			if (result == null) {
				result = caseSubcomponent(subprogramGroupSubcomponent);
			}
			if (result == null) {
				result = caseAccessConnectionEnd(subprogramGroupSubcomponent);
			}
			if (result == null) {
				result = caseSubprogramGroup(subprogramGroupSubcomponent);
			}
			if (result == null) {
				result = caseCallContext(subprogramGroupSubcomponent);
			}
			if (result == null) {
				result = caseStructuralFeature(subprogramGroupSubcomponent);
			}
			if (result == null) {
				result = caseModalElement(subprogramGroupSubcomponent);
			}
			if (result == null) {
				result = caseContext(subprogramGroupSubcomponent);
			}
			if (result == null) {
				result = caseFlowElement(subprogramGroupSubcomponent);
			}
			if (result == null) {
				result = caseArrayableElement(subprogramGroupSubcomponent);
			}
			if (result == null) {
				result = caseConnectionEnd(subprogramGroupSubcomponent);
			}
			if (result == null) {
				result = caseRefinableElement(subprogramGroupSubcomponent);
			}
			if (result == null) {
				result = caseClassifierFeature(subprogramGroupSubcomponent);
			}
			if (result == null) {
				result = caseEndToEndFlowElement(subprogramGroupSubcomponent);
			}
			if (result == null) {
				result = caseNamedElement(subprogramGroupSubcomponent);
			}
			if (result == null) {
				result = caseElement(subprogramGroupSubcomponent);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.SUBPROGRAM_GROUP: {
			SubprogramGroup subprogramGroup = (SubprogramGroup) theEObject;
			T result = caseSubprogramGroup(subprogramGroup);
			if (result == null) {
				result = caseNamedElement(subprogramGroup);
			}
			if (result == null) {
				result = caseElement(subprogramGroup);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.THREAD_SUBCOMPONENT: {
			ThreadSubcomponent threadSubcomponent = (ThreadSubcomponent) theEObject;
			T result = caseThreadSubcomponent(threadSubcomponent);
			if (result == null) {
				result = caseSubcomponent(threadSubcomponent);
			}
			if (result == null) {
				result = caseThread(threadSubcomponent);
			}
			if (result == null) {
				result = caseStructuralFeature(threadSubcomponent);
			}
			if (result == null) {
				result = caseModalElement(threadSubcomponent);
			}
			if (result == null) {
				result = caseContext(threadSubcomponent);
			}
			if (result == null) {
				result = caseFlowElement(threadSubcomponent);
			}
			if (result == null) {
				result = caseArrayableElement(threadSubcomponent);
			}
			if (result == null) {
				result = caseRefinableElement(threadSubcomponent);
			}
			if (result == null) {
				result = caseClassifierFeature(threadSubcomponent);
			}
			if (result == null) {
				result = caseEndToEndFlowElement(threadSubcomponent);
			}
			if (result == null) {
				result = caseNamedElement(threadSubcomponent);
			}
			if (result == null) {
				result = caseElement(threadSubcomponent);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.THREAD: {
			org.osate.aadl2.Thread thread = (org.osate.aadl2.Thread) theEObject;
			T result = caseThread(thread);
			if (result == null) {
				result = caseNamedElement(thread);
			}
			if (result == null) {
				result = caseElement(thread);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.THREAD_GROUP_SUBCOMPONENT: {
			ThreadGroupSubcomponent threadGroupSubcomponent = (ThreadGroupSubcomponent) theEObject;
			T result = caseThreadGroupSubcomponent(threadGroupSubcomponent);
			if (result == null) {
				result = caseSubcomponent(threadGroupSubcomponent);
			}
			if (result == null) {
				result = caseThreadGroup(threadGroupSubcomponent);
			}
			if (result == null) {
				result = caseStructuralFeature(threadGroupSubcomponent);
			}
			if (result == null) {
				result = caseModalElement(threadGroupSubcomponent);
			}
			if (result == null) {
				result = caseContext(threadGroupSubcomponent);
			}
			if (result == null) {
				result = caseFlowElement(threadGroupSubcomponent);
			}
			if (result == null) {
				result = caseArrayableElement(threadGroupSubcomponent);
			}
			if (result == null) {
				result = caseRefinableElement(threadGroupSubcomponent);
			}
			if (result == null) {
				result = caseClassifierFeature(threadGroupSubcomponent);
			}
			if (result == null) {
				result = caseEndToEndFlowElement(threadGroupSubcomponent);
			}
			if (result == null) {
				result = caseNamedElement(threadGroupSubcomponent);
			}
			if (result == null) {
				result = caseElement(threadGroupSubcomponent);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.THREAD_GROUP: {
			org.osate.aadl2.ThreadGroup threadGroup = (org.osate.aadl2.ThreadGroup) theEObject;
			T result = caseThreadGroup(threadGroup);
			if (result == null) {
				result = caseNamedElement(threadGroup);
			}
			if (result == null) {
				result = caseElement(threadGroup);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.VIRTUAL_BUS_SUBCOMPONENT: {
			VirtualBusSubcomponent virtualBusSubcomponent = (VirtualBusSubcomponent) theEObject;
			T result = caseVirtualBusSubcomponent(virtualBusSubcomponent);
			if (result == null) {
				result = caseSubcomponent(virtualBusSubcomponent);
			}
			if (result == null) {
				result = caseVirtualBus(virtualBusSubcomponent);
			}
			if (result == null) {
				result = caseStructuralFeature(virtualBusSubcomponent);
			}
			if (result == null) {
				result = caseModalElement(virtualBusSubcomponent);
			}
			if (result == null) {
				result = caseContext(virtualBusSubcomponent);
			}
			if (result == null) {
				result = caseFlowElement(virtualBusSubcomponent);
			}
			if (result == null) {
				result = caseArrayableElement(virtualBusSubcomponent);
			}
			if (result == null) {
				result = caseRefinableElement(virtualBusSubcomponent);
			}
			if (result == null) {
				result = caseClassifierFeature(virtualBusSubcomponent);
			}
			if (result == null) {
				result = caseEndToEndFlowElement(virtualBusSubcomponent);
			}
			if (result == null) {
				result = caseNamedElement(virtualBusSubcomponent);
			}
			if (result == null) {
				result = caseElement(virtualBusSubcomponent);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.VIRTUAL_BUS: {
			VirtualBus virtualBus = (VirtualBus) theEObject;
			T result = caseVirtualBus(virtualBus);
			if (result == null) {
				result = caseNamedElement(virtualBus);
			}
			if (result == null) {
				result = caseElement(virtualBus);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.VIRTUAL_PROCESSOR_SUBCOMPONENT: {
			VirtualProcessorSubcomponent virtualProcessorSubcomponent = (VirtualProcessorSubcomponent) theEObject;
			T result = caseVirtualProcessorSubcomponent(virtualProcessorSubcomponent);
			if (result == null) {
				result = caseSubcomponent(virtualProcessorSubcomponent);
			}
			if (result == null) {
				result = caseVirtualProcessor(virtualProcessorSubcomponent);
			}
			if (result == null) {
				result = caseStructuralFeature(virtualProcessorSubcomponent);
			}
			if (result == null) {
				result = caseModalElement(virtualProcessorSubcomponent);
			}
			if (result == null) {
				result = caseContext(virtualProcessorSubcomponent);
			}
			if (result == null) {
				result = caseFlowElement(virtualProcessorSubcomponent);
			}
			if (result == null) {
				result = caseArrayableElement(virtualProcessorSubcomponent);
			}
			if (result == null) {
				result = caseRefinableElement(virtualProcessorSubcomponent);
			}
			if (result == null) {
				result = caseClassifierFeature(virtualProcessorSubcomponent);
			}
			if (result == null) {
				result = caseEndToEndFlowElement(virtualProcessorSubcomponent);
			}
			if (result == null) {
				result = caseNamedElement(virtualProcessorSubcomponent);
			}
			if (result == null) {
				result = caseElement(virtualProcessorSubcomponent);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.VIRTUAL_PROCESSOR: {
			VirtualProcessor virtualProcessor = (VirtualProcessor) theEObject;
			T result = caseVirtualProcessor(virtualProcessor);
			if (result == null) {
				result = caseNamedElement(virtualProcessor);
			}
			if (result == null) {
				result = caseElement(virtualProcessor);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.ABSTRACT_PROTOTYPE: {
			AbstractPrototype abstractPrototype = (AbstractPrototype) theEObject;
			T result = caseAbstractPrototype(abstractPrototype);
			if (result == null) {
				result = caseComponentPrototype(abstractPrototype);
			}
			if (result == null) {
				result = caseAbstract(abstractPrototype);
			}
			if (result == null) {
				result = caseAbstractSubcomponentType(abstractPrototype);
			}
			if (result == null) {
				result = caseBusSubcomponentType(abstractPrototype);
			}
			if (result == null) {
				result = caseDataSubcomponentType(abstractPrototype);
			}
			if (result == null) {
				result = caseDeviceSubcomponentType(abstractPrototype);
			}
			if (result == null) {
				result = caseMemorySubcomponentType(abstractPrototype);
			}
			if (result == null) {
				result = caseProcessorSubcomponentType(abstractPrototype);
			}
			if (result == null) {
				result = caseProcessSubcomponentType(abstractPrototype);
			}
			if (result == null) {
				result = caseSubprogramGroupSubcomponentType(abstractPrototype);
			}
			if (result == null) {
				result = caseSubprogramSubcomponentType(abstractPrototype);
			}
			if (result == null) {
				result = caseSystemSubcomponentType(abstractPrototype);
			}
			if (result == null) {
				result = caseThreadGroupSubcomponentType(abstractPrototype);
			}
			if (result == null) {
				result = caseThreadSubcomponentType(abstractPrototype);
			}
			if (result == null) {
				result = caseVirtualBusSubcomponentType(abstractPrototype);
			}
			if (result == null) {
				result = caseVirtualProcessorSubcomponentType(abstractPrototype);
			}
			if (result == null) {
				result = casePrototype(abstractPrototype);
			}
			if (result == null) {
				result = caseSubcomponentType(abstractPrototype);
			}
			if (result == null) {
				result = caseFeatureClassifier(abstractPrototype);
			}
			if (result == null) {
				result = caseStructuralFeature(abstractPrototype);
			}
			if (result == null) {
				result = caseCalledSubprogram(abstractPrototype);
			}
			if (result == null) {
				result = caseType(abstractPrototype);
			}
			if (result == null) {
				result = caseRefinableElement(abstractPrototype);
			}
			if (result == null) {
				result = caseClassifierFeature(abstractPrototype);
			}
			if (result == null) {
				result = caseNamedElement(abstractPrototype);
			}
			if (result == null) {
				result = caseElement(abstractPrototype);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.BUS_CLASSIFIER: {
			BusClassifier busClassifier = (BusClassifier) theEObject;
			T result = caseBusClassifier(busClassifier);
			if (result == null) {
				result = caseComponentClassifier(busClassifier);
			}
			if (result == null) {
				result = caseBus(busClassifier);
			}
			if (result == null) {
				result = caseBusSubcomponentType(busClassifier);
			}
			if (result == null) {
				result = caseClassifier(busClassifier);
			}
			if (result == null) {
				result = caseSubcomponentType(busClassifier);
			}
			if (result == null) {
				result = caseFeatureClassifier(busClassifier);
			}
			if (result == null) {
				result = caseNamespace(busClassifier);
			}
			if (result == null) {
				result = caseType(busClassifier);
			}
			if (result == null) {
				result = caseNamedElement(busClassifier);
			}
			if (result == null) {
				result = caseElement(busClassifier);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.BUS_TYPE: {
			BusType busType = (BusType) theEObject;
			T result = caseBusType(busType);
			if (result == null) {
				result = caseComponentType(busType);
			}
			if (result == null) {
				result = caseBusClassifier(busType);
			}
			if (result == null) {
				result = caseComponentClassifier(busType);
			}
			if (result == null) {
				result = caseBus(busType);
			}
			if (result == null) {
				result = caseBusSubcomponentType(busType);
			}
			if (result == null) {
				result = caseClassifier(busType);
			}
			if (result == null) {
				result = caseSubcomponentType(busType);
			}
			if (result == null) {
				result = caseFeatureClassifier(busType);
			}
			if (result == null) {
				result = caseNamespace(busType);
			}
			if (result == null) {
				result = caseType(busType);
			}
			if (result == null) {
				result = caseNamedElement(busType);
			}
			if (result == null) {
				result = caseElement(busType);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.BUS_IMPLEMENTATION: {
			BusImplementation busImplementation = (BusImplementation) theEObject;
			T result = caseBusImplementation(busImplementation);
			if (result == null) {
				result = caseComponentImplementation(busImplementation);
			}
			if (result == null) {
				result = caseBusClassifier(busImplementation);
			}
			if (result == null) {
				result = caseComponentClassifier(busImplementation);
			}
			if (result == null) {
				result = caseBus(busImplementation);
			}
			if (result == null) {
				result = caseBusSubcomponentType(busImplementation);
			}
			if (result == null) {
				result = caseClassifier(busImplementation);
			}
			if (result == null) {
				result = caseSubcomponentType(busImplementation);
			}
			if (result == null) {
				result = caseFeatureClassifier(busImplementation);
			}
			if (result == null) {
				result = caseNamespace(busImplementation);
			}
			if (result == null) {
				result = caseType(busImplementation);
			}
			if (result == null) {
				result = caseNamedElement(busImplementation);
			}
			if (result == null) {
				result = caseElement(busImplementation);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.BUS_PROTOTYPE: {
			BusPrototype busPrototype = (BusPrototype) theEObject;
			T result = caseBusPrototype(busPrototype);
			if (result == null) {
				result = caseComponentPrototype(busPrototype);
			}
			if (result == null) {
				result = caseBus(busPrototype);
			}
			if (result == null) {
				result = caseBusSubcomponentType(busPrototype);
			}
			if (result == null) {
				result = casePrototype(busPrototype);
			}
			if (result == null) {
				result = caseSubcomponentType(busPrototype);
			}
			if (result == null) {
				result = caseFeatureClassifier(busPrototype);
			}
			if (result == null) {
				result = caseStructuralFeature(busPrototype);
			}
			if (result == null) {
				result = caseCalledSubprogram(busPrototype);
			}
			if (result == null) {
				result = caseType(busPrototype);
			}
			if (result == null) {
				result = caseRefinableElement(busPrototype);
			}
			if (result == null) {
				result = caseClassifierFeature(busPrototype);
			}
			if (result == null) {
				result = caseNamedElement(busPrototype);
			}
			if (result == null) {
				result = caseElement(busPrototype);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.DATA_TYPE: {
			DataType dataType = (DataType) theEObject;
			T result = caseDataType(dataType);
			if (result == null) {
				result = caseComponentType(dataType);
			}
			if (result == null) {
				result = caseDataClassifier(dataType);
			}
			if (result == null) {
				result = caseCallContext(dataType);
			}
			if (result == null) {
				result = caseComponentClassifier(dataType);
			}
			if (result == null) {
				result = caseData(dataType);
			}
			if (result == null) {
				result = caseDataSubcomponentType(dataType);
			}
			if (result == null) {
				result = caseClassifier(dataType);
			}
			if (result == null) {
				result = caseSubcomponentType(dataType);
			}
			if (result == null) {
				result = caseFeatureClassifier(dataType);
			}
			if (result == null) {
				result = caseNamespace(dataType);
			}
			if (result == null) {
				result = caseType(dataType);
			}
			if (result == null) {
				result = caseNamedElement(dataType);
			}
			if (result == null) {
				result = caseElement(dataType);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.DATA_IMPLEMENTATION: {
			DataImplementation dataImplementation = (DataImplementation) theEObject;
			T result = caseDataImplementation(dataImplementation);
			if (result == null) {
				result = caseComponentImplementation(dataImplementation);
			}
			if (result == null) {
				result = caseDataClassifier(dataImplementation);
			}
			if (result == null) {
				result = caseComponentClassifier(dataImplementation);
			}
			if (result == null) {
				result = caseData(dataImplementation);
			}
			if (result == null) {
				result = caseDataSubcomponentType(dataImplementation);
			}
			if (result == null) {
				result = caseClassifier(dataImplementation);
			}
			if (result == null) {
				result = caseSubcomponentType(dataImplementation);
			}
			if (result == null) {
				result = caseFeatureClassifier(dataImplementation);
			}
			if (result == null) {
				result = caseNamespace(dataImplementation);
			}
			if (result == null) {
				result = caseType(dataImplementation);
			}
			if (result == null) {
				result = caseNamedElement(dataImplementation);
			}
			if (result == null) {
				result = caseElement(dataImplementation);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.DATA_PROTOTYPE: {
			DataPrototype dataPrototype = (DataPrototype) theEObject;
			T result = caseDataPrototype(dataPrototype);
			if (result == null) {
				result = caseComponentPrototype(dataPrototype);
			}
			if (result == null) {
				result = caseData(dataPrototype);
			}
			if (result == null) {
				result = caseDataSubcomponentType(dataPrototype);
			}
			if (result == null) {
				result = casePrototype(dataPrototype);
			}
			if (result == null) {
				result = caseSubcomponentType(dataPrototype);
			}
			if (result == null) {
				result = caseFeatureClassifier(dataPrototype);
			}
			if (result == null) {
				result = caseStructuralFeature(dataPrototype);
			}
			if (result == null) {
				result = caseCalledSubprogram(dataPrototype);
			}
			if (result == null) {
				result = caseType(dataPrototype);
			}
			if (result == null) {
				result = caseRefinableElement(dataPrototype);
			}
			if (result == null) {
				result = caseClassifierFeature(dataPrototype);
			}
			if (result == null) {
				result = caseNamedElement(dataPrototype);
			}
			if (result == null) {
				result = caseElement(dataPrototype);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.DEVICE_CLASSIFIER: {
			DeviceClassifier deviceClassifier = (DeviceClassifier) theEObject;
			T result = caseDeviceClassifier(deviceClassifier);
			if (result == null) {
				result = caseComponentClassifier(deviceClassifier);
			}
			if (result == null) {
				result = caseDevice(deviceClassifier);
			}
			if (result == null) {
				result = caseDeviceSubcomponentType(deviceClassifier);
			}
			if (result == null) {
				result = caseClassifier(deviceClassifier);
			}
			if (result == null) {
				result = caseSubcomponentType(deviceClassifier);
			}
			if (result == null) {
				result = caseFeatureClassifier(deviceClassifier);
			}
			if (result == null) {
				result = caseNamespace(deviceClassifier);
			}
			if (result == null) {
				result = caseType(deviceClassifier);
			}
			if (result == null) {
				result = caseNamedElement(deviceClassifier);
			}
			if (result == null) {
				result = caseElement(deviceClassifier);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.DEVICE_TYPE: {
			DeviceType deviceType = (DeviceType) theEObject;
			T result = caseDeviceType(deviceType);
			if (result == null) {
				result = caseComponentType(deviceType);
			}
			if (result == null) {
				result = caseDeviceClassifier(deviceType);
			}
			if (result == null) {
				result = caseComponentClassifier(deviceType);
			}
			if (result == null) {
				result = caseDevice(deviceType);
			}
			if (result == null) {
				result = caseDeviceSubcomponentType(deviceType);
			}
			if (result == null) {
				result = caseClassifier(deviceType);
			}
			if (result == null) {
				result = caseSubcomponentType(deviceType);
			}
			if (result == null) {
				result = caseFeatureClassifier(deviceType);
			}
			if (result == null) {
				result = caseNamespace(deviceType);
			}
			if (result == null) {
				result = caseType(deviceType);
			}
			if (result == null) {
				result = caseNamedElement(deviceType);
			}
			if (result == null) {
				result = caseElement(deviceType);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.DEVICE_IMPLEMENTATION: {
			DeviceImplementation deviceImplementation = (DeviceImplementation) theEObject;
			T result = caseDeviceImplementation(deviceImplementation);
			if (result == null) {
				result = caseComponentImplementation(deviceImplementation);
			}
			if (result == null) {
				result = caseDeviceClassifier(deviceImplementation);
			}
			if (result == null) {
				result = caseComponentClassifier(deviceImplementation);
			}
			if (result == null) {
				result = caseDevice(deviceImplementation);
			}
			if (result == null) {
				result = caseDeviceSubcomponentType(deviceImplementation);
			}
			if (result == null) {
				result = caseClassifier(deviceImplementation);
			}
			if (result == null) {
				result = caseSubcomponentType(deviceImplementation);
			}
			if (result == null) {
				result = caseFeatureClassifier(deviceImplementation);
			}
			if (result == null) {
				result = caseNamespace(deviceImplementation);
			}
			if (result == null) {
				result = caseType(deviceImplementation);
			}
			if (result == null) {
				result = caseNamedElement(deviceImplementation);
			}
			if (result == null) {
				result = caseElement(deviceImplementation);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.DEVICE_PROTOTYPE: {
			DevicePrototype devicePrototype = (DevicePrototype) theEObject;
			T result = caseDevicePrototype(devicePrototype);
			if (result == null) {
				result = caseComponentPrototype(devicePrototype);
			}
			if (result == null) {
				result = caseDevice(devicePrototype);
			}
			if (result == null) {
				result = caseDeviceSubcomponentType(devicePrototype);
			}
			if (result == null) {
				result = casePrototype(devicePrototype);
			}
			if (result == null) {
				result = caseSubcomponentType(devicePrototype);
			}
			if (result == null) {
				result = caseFeatureClassifier(devicePrototype);
			}
			if (result == null) {
				result = caseStructuralFeature(devicePrototype);
			}
			if (result == null) {
				result = caseCalledSubprogram(devicePrototype);
			}
			if (result == null) {
				result = caseType(devicePrototype);
			}
			if (result == null) {
				result = caseRefinableElement(devicePrototype);
			}
			if (result == null) {
				result = caseClassifierFeature(devicePrototype);
			}
			if (result == null) {
				result = caseNamedElement(devicePrototype);
			}
			if (result == null) {
				result = caseElement(devicePrototype);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.MEMORY_CLASSIFIER: {
			MemoryClassifier memoryClassifier = (MemoryClassifier) theEObject;
			T result = caseMemoryClassifier(memoryClassifier);
			if (result == null) {
				result = caseComponentClassifier(memoryClassifier);
			}
			if (result == null) {
				result = caseMemory(memoryClassifier);
			}
			if (result == null) {
				result = caseMemorySubcomponentType(memoryClassifier);
			}
			if (result == null) {
				result = caseClassifier(memoryClassifier);
			}
			if (result == null) {
				result = caseSubcomponentType(memoryClassifier);
			}
			if (result == null) {
				result = caseFeatureClassifier(memoryClassifier);
			}
			if (result == null) {
				result = caseNamespace(memoryClassifier);
			}
			if (result == null) {
				result = caseType(memoryClassifier);
			}
			if (result == null) {
				result = caseNamedElement(memoryClassifier);
			}
			if (result == null) {
				result = caseElement(memoryClassifier);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.MEMORY_TYPE: {
			MemoryType memoryType = (MemoryType) theEObject;
			T result = caseMemoryType(memoryType);
			if (result == null) {
				result = caseComponentType(memoryType);
			}
			if (result == null) {
				result = caseMemoryClassifier(memoryType);
			}
			if (result == null) {
				result = caseComponentClassifier(memoryType);
			}
			if (result == null) {
				result = caseMemory(memoryType);
			}
			if (result == null) {
				result = caseMemorySubcomponentType(memoryType);
			}
			if (result == null) {
				result = caseClassifier(memoryType);
			}
			if (result == null) {
				result = caseSubcomponentType(memoryType);
			}
			if (result == null) {
				result = caseFeatureClassifier(memoryType);
			}
			if (result == null) {
				result = caseNamespace(memoryType);
			}
			if (result == null) {
				result = caseType(memoryType);
			}
			if (result == null) {
				result = caseNamedElement(memoryType);
			}
			if (result == null) {
				result = caseElement(memoryType);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.MEMORY_IMPLEMENTATION: {
			MemoryImplementation memoryImplementation = (MemoryImplementation) theEObject;
			T result = caseMemoryImplementation(memoryImplementation);
			if (result == null) {
				result = caseComponentImplementation(memoryImplementation);
			}
			if (result == null) {
				result = caseMemoryClassifier(memoryImplementation);
			}
			if (result == null) {
				result = caseComponentClassifier(memoryImplementation);
			}
			if (result == null) {
				result = caseMemory(memoryImplementation);
			}
			if (result == null) {
				result = caseMemorySubcomponentType(memoryImplementation);
			}
			if (result == null) {
				result = caseClassifier(memoryImplementation);
			}
			if (result == null) {
				result = caseSubcomponentType(memoryImplementation);
			}
			if (result == null) {
				result = caseFeatureClassifier(memoryImplementation);
			}
			if (result == null) {
				result = caseNamespace(memoryImplementation);
			}
			if (result == null) {
				result = caseType(memoryImplementation);
			}
			if (result == null) {
				result = caseNamedElement(memoryImplementation);
			}
			if (result == null) {
				result = caseElement(memoryImplementation);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.MEMORY_PROTOTYPE: {
			MemoryPrototype memoryPrototype = (MemoryPrototype) theEObject;
			T result = caseMemoryPrototype(memoryPrototype);
			if (result == null) {
				result = caseComponentPrototype(memoryPrototype);
			}
			if (result == null) {
				result = caseMemory(memoryPrototype);
			}
			if (result == null) {
				result = caseMemorySubcomponentType(memoryPrototype);
			}
			if (result == null) {
				result = casePrototype(memoryPrototype);
			}
			if (result == null) {
				result = caseSubcomponentType(memoryPrototype);
			}
			if (result == null) {
				result = caseFeatureClassifier(memoryPrototype);
			}
			if (result == null) {
				result = caseStructuralFeature(memoryPrototype);
			}
			if (result == null) {
				result = caseCalledSubprogram(memoryPrototype);
			}
			if (result == null) {
				result = caseType(memoryPrototype);
			}
			if (result == null) {
				result = caseRefinableElement(memoryPrototype);
			}
			if (result == null) {
				result = caseClassifierFeature(memoryPrototype);
			}
			if (result == null) {
				result = caseNamedElement(memoryPrototype);
			}
			if (result == null) {
				result = caseElement(memoryPrototype);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.SUBPROGRAM_TYPE: {
			SubprogramType subprogramType = (SubprogramType) theEObject;
			T result = caseSubprogramType(subprogramType);
			if (result == null) {
				result = caseComponentType(subprogramType);
			}
			if (result == null) {
				result = caseSubprogramClassifier(subprogramType);
			}
			if (result == null) {
				result = caseCallContext(subprogramType);
			}
			if (result == null) {
				result = caseComponentClassifier(subprogramType);
			}
			if (result == null) {
				result = caseSubprogram(subprogramType);
			}
			if (result == null) {
				result = caseSubprogramSubcomponentType(subprogramType);
			}
			if (result == null) {
				result = caseClassifier(subprogramType);
			}
			if (result == null) {
				result = caseSubcomponentType(subprogramType);
			}
			if (result == null) {
				result = caseFeatureClassifier(subprogramType);
			}
			if (result == null) {
				result = caseCalledSubprogram(subprogramType);
			}
			if (result == null) {
				result = caseNamespace(subprogramType);
			}
			if (result == null) {
				result = caseType(subprogramType);
			}
			if (result == null) {
				result = caseNamedElement(subprogramType);
			}
			if (result == null) {
				result = caseElement(subprogramType);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.SUBPROGRAM_IMPLEMENTATION: {
			SubprogramImplementation subprogramImplementation = (SubprogramImplementation) theEObject;
			T result = caseSubprogramImplementation(subprogramImplementation);
			if (result == null) {
				result = caseBehavioredImplementation(subprogramImplementation);
			}
			if (result == null) {
				result = caseSubprogramClassifier(subprogramImplementation);
			}
			if (result == null) {
				result = caseComponentImplementation(subprogramImplementation);
			}
			if (result == null) {
				result = caseSubprogram(subprogramImplementation);
			}
			if (result == null) {
				result = caseSubprogramSubcomponentType(subprogramImplementation);
			}
			if (result == null) {
				result = caseComponentClassifier(subprogramImplementation);
			}
			if (result == null) {
				result = caseCalledSubprogram(subprogramImplementation);
			}
			if (result == null) {
				result = caseClassifier(subprogramImplementation);
			}
			if (result == null) {
				result = caseSubcomponentType(subprogramImplementation);
			}
			if (result == null) {
				result = caseFeatureClassifier(subprogramImplementation);
			}
			if (result == null) {
				result = caseNamespace(subprogramImplementation);
			}
			if (result == null) {
				result = caseType(subprogramImplementation);
			}
			if (result == null) {
				result = caseNamedElement(subprogramImplementation);
			}
			if (result == null) {
				result = caseElement(subprogramImplementation);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.SUBPROGRAM_PROTOTYPE: {
			SubprogramPrototype subprogramPrototype = (SubprogramPrototype) theEObject;
			T result = caseSubprogramPrototype(subprogramPrototype);
			if (result == null) {
				result = caseComponentPrototype(subprogramPrototype);
			}
			if (result == null) {
				result = caseSubprogram(subprogramPrototype);
			}
			if (result == null) {
				result = caseSubprogramSubcomponentType(subprogramPrototype);
			}
			if (result == null) {
				result = casePrototype(subprogramPrototype);
			}
			if (result == null) {
				result = caseSubcomponentType(subprogramPrototype);
			}
			if (result == null) {
				result = caseFeatureClassifier(subprogramPrototype);
			}
			if (result == null) {
				result = caseStructuralFeature(subprogramPrototype);
			}
			if (result == null) {
				result = caseCalledSubprogram(subprogramPrototype);
			}
			if (result == null) {
				result = caseType(subprogramPrototype);
			}
			if (result == null) {
				result = caseRefinableElement(subprogramPrototype);
			}
			if (result == null) {
				result = caseClassifierFeature(subprogramPrototype);
			}
			if (result == null) {
				result = caseNamedElement(subprogramPrototype);
			}
			if (result == null) {
				result = caseElement(subprogramPrototype);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.SUBPROGRAM_GROUP_CLASSIFIER: {
			SubprogramGroupClassifier subprogramGroupClassifier = (SubprogramGroupClassifier) theEObject;
			T result = caseSubprogramGroupClassifier(subprogramGroupClassifier);
			if (result == null) {
				result = caseComponentClassifier(subprogramGroupClassifier);
			}
			if (result == null) {
				result = caseSubprogramGroup(subprogramGroupClassifier);
			}
			if (result == null) {
				result = caseSubprogramGroupSubcomponentType(subprogramGroupClassifier);
			}
			if (result == null) {
				result = caseClassifier(subprogramGroupClassifier);
			}
			if (result == null) {
				result = caseSubcomponentType(subprogramGroupClassifier);
			}
			if (result == null) {
				result = caseFeatureClassifier(subprogramGroupClassifier);
			}
			if (result == null) {
				result = caseNamespace(subprogramGroupClassifier);
			}
			if (result == null) {
				result = caseType(subprogramGroupClassifier);
			}
			if (result == null) {
				result = caseNamedElement(subprogramGroupClassifier);
			}
			if (result == null) {
				result = caseElement(subprogramGroupClassifier);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.SUBPROGRAM_GROUP_TYPE: {
			SubprogramGroupType subprogramGroupType = (SubprogramGroupType) theEObject;
			T result = caseSubprogramGroupType(subprogramGroupType);
			if (result == null) {
				result = caseComponentType(subprogramGroupType);
			}
			if (result == null) {
				result = caseSubprogramGroupClassifier(subprogramGroupType);
			}
			if (result == null) {
				result = caseCallContext(subprogramGroupType);
			}
			if (result == null) {
				result = caseComponentClassifier(subprogramGroupType);
			}
			if (result == null) {
				result = caseSubprogramGroup(subprogramGroupType);
			}
			if (result == null) {
				result = caseSubprogramGroupSubcomponentType(subprogramGroupType);
			}
			if (result == null) {
				result = caseClassifier(subprogramGroupType);
			}
			if (result == null) {
				result = caseSubcomponentType(subprogramGroupType);
			}
			if (result == null) {
				result = caseFeatureClassifier(subprogramGroupType);
			}
			if (result == null) {
				result = caseNamespace(subprogramGroupType);
			}
			if (result == null) {
				result = caseType(subprogramGroupType);
			}
			if (result == null) {
				result = caseNamedElement(subprogramGroupType);
			}
			if (result == null) {
				result = caseElement(subprogramGroupType);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.SUBPROGRAM_GROUP_IMPLEMENTATION: {
			SubprogramGroupImplementation subprogramGroupImplementation = (SubprogramGroupImplementation) theEObject;
			T result = caseSubprogramGroupImplementation(subprogramGroupImplementation);
			if (result == null) {
				result = caseComponentImplementation(subprogramGroupImplementation);
			}
			if (result == null) {
				result = caseSubprogramGroupClassifier(subprogramGroupImplementation);
			}
			if (result == null) {
				result = caseComponentClassifier(subprogramGroupImplementation);
			}
			if (result == null) {
				result = caseSubprogramGroup(subprogramGroupImplementation);
			}
			if (result == null) {
				result = caseSubprogramGroupSubcomponentType(subprogramGroupImplementation);
			}
			if (result == null) {
				result = caseClassifier(subprogramGroupImplementation);
			}
			if (result == null) {
				result = caseSubcomponentType(subprogramGroupImplementation);
			}
			if (result == null) {
				result = caseFeatureClassifier(subprogramGroupImplementation);
			}
			if (result == null) {
				result = caseNamespace(subprogramGroupImplementation);
			}
			if (result == null) {
				result = caseType(subprogramGroupImplementation);
			}
			if (result == null) {
				result = caseNamedElement(subprogramGroupImplementation);
			}
			if (result == null) {
				result = caseElement(subprogramGroupImplementation);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.SUBPROGRAM_GROUP_PROTOTYPE: {
			SubprogramGroupPrototype subprogramGroupPrototype = (SubprogramGroupPrototype) theEObject;
			T result = caseSubprogramGroupPrototype(subprogramGroupPrototype);
			if (result == null) {
				result = caseComponentPrototype(subprogramGroupPrototype);
			}
			if (result == null) {
				result = caseSubprogramGroup(subprogramGroupPrototype);
			}
			if (result == null) {
				result = caseSubprogramGroupSubcomponentType(subprogramGroupPrototype);
			}
			if (result == null) {
				result = casePrototype(subprogramGroupPrototype);
			}
			if (result == null) {
				result = caseSubcomponentType(subprogramGroupPrototype);
			}
			if (result == null) {
				result = caseFeatureClassifier(subprogramGroupPrototype);
			}
			if (result == null) {
				result = caseStructuralFeature(subprogramGroupPrototype);
			}
			if (result == null) {
				result = caseCalledSubprogram(subprogramGroupPrototype);
			}
			if (result == null) {
				result = caseType(subprogramGroupPrototype);
			}
			if (result == null) {
				result = caseRefinableElement(subprogramGroupPrototype);
			}
			if (result == null) {
				result = caseClassifierFeature(subprogramGroupPrototype);
			}
			if (result == null) {
				result = caseNamedElement(subprogramGroupPrototype);
			}
			if (result == null) {
				result = caseElement(subprogramGroupPrototype);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.SYSTEM_CLASSIFIER: {
			SystemClassifier systemClassifier = (SystemClassifier) theEObject;
			T result = caseSystemClassifier(systemClassifier);
			if (result == null) {
				result = caseComponentClassifier(systemClassifier);
			}
			if (result == null) {
				result = caseSystem(systemClassifier);
			}
			if (result == null) {
				result = caseSystemSubcomponentType(systemClassifier);
			}
			if (result == null) {
				result = caseClassifier(systemClassifier);
			}
			if (result == null) {
				result = caseSubcomponentType(systemClassifier);
			}
			if (result == null) {
				result = caseFeatureClassifier(systemClassifier);
			}
			if (result == null) {
				result = caseNamespace(systemClassifier);
			}
			if (result == null) {
				result = caseType(systemClassifier);
			}
			if (result == null) {
				result = caseNamedElement(systemClassifier);
			}
			if (result == null) {
				result = caseElement(systemClassifier);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.SYSTEM_TYPE: {
			SystemType systemType = (SystemType) theEObject;
			T result = caseSystemType(systemType);
			if (result == null) {
				result = caseComponentType(systemType);
			}
			if (result == null) {
				result = caseSystemClassifier(systemType);
			}
			if (result == null) {
				result = caseComponentClassifier(systemType);
			}
			if (result == null) {
				result = caseSystem(systemType);
			}
			if (result == null) {
				result = caseSystemSubcomponentType(systemType);
			}
			if (result == null) {
				result = caseClassifier(systemType);
			}
			if (result == null) {
				result = caseSubcomponentType(systemType);
			}
			if (result == null) {
				result = caseFeatureClassifier(systemType);
			}
			if (result == null) {
				result = caseNamespace(systemType);
			}
			if (result == null) {
				result = caseType(systemType);
			}
			if (result == null) {
				result = caseNamedElement(systemType);
			}
			if (result == null) {
				result = caseElement(systemType);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.SYSTEM_IMPLEMENTATION: {
			SystemImplementation systemImplementation = (SystemImplementation) theEObject;
			T result = caseSystemImplementation(systemImplementation);
			if (result == null) {
				result = caseComponentImplementation(systemImplementation);
			}
			if (result == null) {
				result = caseSystemClassifier(systemImplementation);
			}
			if (result == null) {
				result = caseComponentClassifier(systemImplementation);
			}
			if (result == null) {
				result = caseSystem(systemImplementation);
			}
			if (result == null) {
				result = caseSystemSubcomponentType(systemImplementation);
			}
			if (result == null) {
				result = caseClassifier(systemImplementation);
			}
			if (result == null) {
				result = caseSubcomponentType(systemImplementation);
			}
			if (result == null) {
				result = caseFeatureClassifier(systemImplementation);
			}
			if (result == null) {
				result = caseNamespace(systemImplementation);
			}
			if (result == null) {
				result = caseType(systemImplementation);
			}
			if (result == null) {
				result = caseNamedElement(systemImplementation);
			}
			if (result == null) {
				result = caseElement(systemImplementation);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.SYSTEM_PROTOTYPE: {
			SystemPrototype systemPrototype = (SystemPrototype) theEObject;
			T result = caseSystemPrototype(systemPrototype);
			if (result == null) {
				result = caseComponentPrototype(systemPrototype);
			}
			if (result == null) {
				result = caseSystem(systemPrototype);
			}
			if (result == null) {
				result = caseSystemSubcomponentType(systemPrototype);
			}
			if (result == null) {
				result = casePrototype(systemPrototype);
			}
			if (result == null) {
				result = caseSubcomponentType(systemPrototype);
			}
			if (result == null) {
				result = caseFeatureClassifier(systemPrototype);
			}
			if (result == null) {
				result = caseStructuralFeature(systemPrototype);
			}
			if (result == null) {
				result = caseCalledSubprogram(systemPrototype);
			}
			if (result == null) {
				result = caseType(systemPrototype);
			}
			if (result == null) {
				result = caseRefinableElement(systemPrototype);
			}
			if (result == null) {
				result = caseClassifierFeature(systemPrototype);
			}
			if (result == null) {
				result = caseNamedElement(systemPrototype);
			}
			if (result == null) {
				result = caseElement(systemPrototype);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.PROCESSOR_CLASSIFIER: {
			ProcessorClassifier processorClassifier = (ProcessorClassifier) theEObject;
			T result = caseProcessorClassifier(processorClassifier);
			if (result == null) {
				result = caseComponentClassifier(processorClassifier);
			}
			if (result == null) {
				result = caseProcessor(processorClassifier);
			}
			if (result == null) {
				result = caseProcessorSubcomponentType(processorClassifier);
			}
			if (result == null) {
				result = caseClassifier(processorClassifier);
			}
			if (result == null) {
				result = caseSubcomponentType(processorClassifier);
			}
			if (result == null) {
				result = caseFeatureClassifier(processorClassifier);
			}
			if (result == null) {
				result = caseNamespace(processorClassifier);
			}
			if (result == null) {
				result = caseType(processorClassifier);
			}
			if (result == null) {
				result = caseNamedElement(processorClassifier);
			}
			if (result == null) {
				result = caseElement(processorClassifier);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.PROCESSOR_TYPE: {
			ProcessorType processorType = (ProcessorType) theEObject;
			T result = caseProcessorType(processorType);
			if (result == null) {
				result = caseComponentType(processorType);
			}
			if (result == null) {
				result = caseProcessorClassifier(processorType);
			}
			if (result == null) {
				result = caseComponentClassifier(processorType);
			}
			if (result == null) {
				result = caseProcessor(processorType);
			}
			if (result == null) {
				result = caseProcessorSubcomponentType(processorType);
			}
			if (result == null) {
				result = caseClassifier(processorType);
			}
			if (result == null) {
				result = caseSubcomponentType(processorType);
			}
			if (result == null) {
				result = caseFeatureClassifier(processorType);
			}
			if (result == null) {
				result = caseNamespace(processorType);
			}
			if (result == null) {
				result = caseType(processorType);
			}
			if (result == null) {
				result = caseNamedElement(processorType);
			}
			if (result == null) {
				result = caseElement(processorType);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.PROCESSOR_IMPLEMENTATION: {
			ProcessorImplementation processorImplementation = (ProcessorImplementation) theEObject;
			T result = caseProcessorImplementation(processorImplementation);
			if (result == null) {
				result = caseComponentImplementation(processorImplementation);
			}
			if (result == null) {
				result = caseProcessorClassifier(processorImplementation);
			}
			if (result == null) {
				result = caseComponentClassifier(processorImplementation);
			}
			if (result == null) {
				result = caseProcessor(processorImplementation);
			}
			if (result == null) {
				result = caseProcessorSubcomponentType(processorImplementation);
			}
			if (result == null) {
				result = caseClassifier(processorImplementation);
			}
			if (result == null) {
				result = caseSubcomponentType(processorImplementation);
			}
			if (result == null) {
				result = caseFeatureClassifier(processorImplementation);
			}
			if (result == null) {
				result = caseNamespace(processorImplementation);
			}
			if (result == null) {
				result = caseType(processorImplementation);
			}
			if (result == null) {
				result = caseNamedElement(processorImplementation);
			}
			if (result == null) {
				result = caseElement(processorImplementation);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.PROCESSOR_PROTOTYPE: {
			ProcessorPrototype processorPrototype = (ProcessorPrototype) theEObject;
			T result = caseProcessorPrototype(processorPrototype);
			if (result == null) {
				result = caseComponentPrototype(processorPrototype);
			}
			if (result == null) {
				result = caseProcessor(processorPrototype);
			}
			if (result == null) {
				result = caseProcessorSubcomponentType(processorPrototype);
			}
			if (result == null) {
				result = casePrototype(processorPrototype);
			}
			if (result == null) {
				result = caseSubcomponentType(processorPrototype);
			}
			if (result == null) {
				result = caseFeatureClassifier(processorPrototype);
			}
			if (result == null) {
				result = caseStructuralFeature(processorPrototype);
			}
			if (result == null) {
				result = caseCalledSubprogram(processorPrototype);
			}
			if (result == null) {
				result = caseType(processorPrototype);
			}
			if (result == null) {
				result = caseRefinableElement(processorPrototype);
			}
			if (result == null) {
				result = caseClassifierFeature(processorPrototype);
			}
			if (result == null) {
				result = caseNamedElement(processorPrototype);
			}
			if (result == null) {
				result = caseElement(processorPrototype);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.PROCESS_CLASSIFIER: {
			ProcessClassifier processClassifier = (ProcessClassifier) theEObject;
			T result = caseProcessClassifier(processClassifier);
			if (result == null) {
				result = caseComponentClassifier(processClassifier);
			}
			if (result == null) {
				result = caseProcess(processClassifier);
			}
			if (result == null) {
				result = caseProcessSubcomponentType(processClassifier);
			}
			if (result == null) {
				result = caseClassifier(processClassifier);
			}
			if (result == null) {
				result = caseSubcomponentType(processClassifier);
			}
			if (result == null) {
				result = caseFeatureClassifier(processClassifier);
			}
			if (result == null) {
				result = caseNamespace(processClassifier);
			}
			if (result == null) {
				result = caseType(processClassifier);
			}
			if (result == null) {
				result = caseNamedElement(processClassifier);
			}
			if (result == null) {
				result = caseElement(processClassifier);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.PROCESS_TYPE: {
			ProcessType processType = (ProcessType) theEObject;
			T result = caseProcessType(processType);
			if (result == null) {
				result = caseComponentType(processType);
			}
			if (result == null) {
				result = caseProcessClassifier(processType);
			}
			if (result == null) {
				result = caseComponentClassifier(processType);
			}
			if (result == null) {
				result = caseProcess(processType);
			}
			if (result == null) {
				result = caseProcessSubcomponentType(processType);
			}
			if (result == null) {
				result = caseClassifier(processType);
			}
			if (result == null) {
				result = caseSubcomponentType(processType);
			}
			if (result == null) {
				result = caseFeatureClassifier(processType);
			}
			if (result == null) {
				result = caseNamespace(processType);
			}
			if (result == null) {
				result = caseType(processType);
			}
			if (result == null) {
				result = caseNamedElement(processType);
			}
			if (result == null) {
				result = caseElement(processType);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.PROCESS_IMPLEMENTATION: {
			ProcessImplementation processImplementation = (ProcessImplementation) theEObject;
			T result = caseProcessImplementation(processImplementation);
			if (result == null) {
				result = caseComponentImplementation(processImplementation);
			}
			if (result == null) {
				result = caseProcessClassifier(processImplementation);
			}
			if (result == null) {
				result = caseComponentClassifier(processImplementation);
			}
			if (result == null) {
				result = caseProcess(processImplementation);
			}
			if (result == null) {
				result = caseProcessSubcomponentType(processImplementation);
			}
			if (result == null) {
				result = caseClassifier(processImplementation);
			}
			if (result == null) {
				result = caseSubcomponentType(processImplementation);
			}
			if (result == null) {
				result = caseFeatureClassifier(processImplementation);
			}
			if (result == null) {
				result = caseNamespace(processImplementation);
			}
			if (result == null) {
				result = caseType(processImplementation);
			}
			if (result == null) {
				result = caseNamedElement(processImplementation);
			}
			if (result == null) {
				result = caseElement(processImplementation);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.PROCESS_PROTOTYPE: {
			ProcessPrototype processPrototype = (ProcessPrototype) theEObject;
			T result = caseProcessPrototype(processPrototype);
			if (result == null) {
				result = caseComponentPrototype(processPrototype);
			}
			if (result == null) {
				result = caseProcess(processPrototype);
			}
			if (result == null) {
				result = caseProcessSubcomponentType(processPrototype);
			}
			if (result == null) {
				result = casePrototype(processPrototype);
			}
			if (result == null) {
				result = caseSubcomponentType(processPrototype);
			}
			if (result == null) {
				result = caseFeatureClassifier(processPrototype);
			}
			if (result == null) {
				result = caseStructuralFeature(processPrototype);
			}
			if (result == null) {
				result = caseCalledSubprogram(processPrototype);
			}
			if (result == null) {
				result = caseType(processPrototype);
			}
			if (result == null) {
				result = caseRefinableElement(processPrototype);
			}
			if (result == null) {
				result = caseClassifierFeature(processPrototype);
			}
			if (result == null) {
				result = caseNamedElement(processPrototype);
			}
			if (result == null) {
				result = caseElement(processPrototype);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.THREAD_CLASSIFIER: {
			ThreadClassifier threadClassifier = (ThreadClassifier) theEObject;
			T result = caseThreadClassifier(threadClassifier);
			if (result == null) {
				result = caseComponentClassifier(threadClassifier);
			}
			if (result == null) {
				result = caseThread(threadClassifier);
			}
			if (result == null) {
				result = caseThreadSubcomponentType(threadClassifier);
			}
			if (result == null) {
				result = caseClassifier(threadClassifier);
			}
			if (result == null) {
				result = caseSubcomponentType(threadClassifier);
			}
			if (result == null) {
				result = caseFeatureClassifier(threadClassifier);
			}
			if (result == null) {
				result = caseNamespace(threadClassifier);
			}
			if (result == null) {
				result = caseType(threadClassifier);
			}
			if (result == null) {
				result = caseNamedElement(threadClassifier);
			}
			if (result == null) {
				result = caseElement(threadClassifier);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.THREAD_TYPE: {
			ThreadType threadType = (ThreadType) theEObject;
			T result = caseThreadType(threadType);
			if (result == null) {
				result = caseComponentType(threadType);
			}
			if (result == null) {
				result = caseThreadClassifier(threadType);
			}
			if (result == null) {
				result = caseComponentClassifier(threadType);
			}
			if (result == null) {
				result = caseThread(threadType);
			}
			if (result == null) {
				result = caseThreadSubcomponentType(threadType);
			}
			if (result == null) {
				result = caseClassifier(threadType);
			}
			if (result == null) {
				result = caseSubcomponentType(threadType);
			}
			if (result == null) {
				result = caseFeatureClassifier(threadType);
			}
			if (result == null) {
				result = caseNamespace(threadType);
			}
			if (result == null) {
				result = caseType(threadType);
			}
			if (result == null) {
				result = caseNamedElement(threadType);
			}
			if (result == null) {
				result = caseElement(threadType);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.THREAD_IMPLEMENTATION: {
			ThreadImplementation threadImplementation = (ThreadImplementation) theEObject;
			T result = caseThreadImplementation(threadImplementation);
			if (result == null) {
				result = caseBehavioredImplementation(threadImplementation);
			}
			if (result == null) {
				result = caseThreadClassifier(threadImplementation);
			}
			if (result == null) {
				result = caseComponentImplementation(threadImplementation);
			}
			if (result == null) {
				result = caseThread(threadImplementation);
			}
			if (result == null) {
				result = caseThreadSubcomponentType(threadImplementation);
			}
			if (result == null) {
				result = caseComponentClassifier(threadImplementation);
			}
			if (result == null) {
				result = caseClassifier(threadImplementation);
			}
			if (result == null) {
				result = caseSubcomponentType(threadImplementation);
			}
			if (result == null) {
				result = caseFeatureClassifier(threadImplementation);
			}
			if (result == null) {
				result = caseNamespace(threadImplementation);
			}
			if (result == null) {
				result = caseType(threadImplementation);
			}
			if (result == null) {
				result = caseNamedElement(threadImplementation);
			}
			if (result == null) {
				result = caseElement(threadImplementation);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.THREAD_PROTOTYPE: {
			ThreadPrototype threadPrototype = (ThreadPrototype) theEObject;
			T result = caseThreadPrototype(threadPrototype);
			if (result == null) {
				result = caseComponentPrototype(threadPrototype);
			}
			if (result == null) {
				result = caseThread(threadPrototype);
			}
			if (result == null) {
				result = caseThreadSubcomponentType(threadPrototype);
			}
			if (result == null) {
				result = casePrototype(threadPrototype);
			}
			if (result == null) {
				result = caseSubcomponentType(threadPrototype);
			}
			if (result == null) {
				result = caseFeatureClassifier(threadPrototype);
			}
			if (result == null) {
				result = caseStructuralFeature(threadPrototype);
			}
			if (result == null) {
				result = caseCalledSubprogram(threadPrototype);
			}
			if (result == null) {
				result = caseType(threadPrototype);
			}
			if (result == null) {
				result = caseRefinableElement(threadPrototype);
			}
			if (result == null) {
				result = caseClassifierFeature(threadPrototype);
			}
			if (result == null) {
				result = caseNamedElement(threadPrototype);
			}
			if (result == null) {
				result = caseElement(threadPrototype);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.THREAD_GROUP_CLASSIFIER: {
			ThreadGroupClassifier threadGroupClassifier = (ThreadGroupClassifier) theEObject;
			T result = caseThreadGroupClassifier(threadGroupClassifier);
			if (result == null) {
				result = caseComponentClassifier(threadGroupClassifier);
			}
			if (result == null) {
				result = caseThreadGroup(threadGroupClassifier);
			}
			if (result == null) {
				result = caseThreadGroupSubcomponentType(threadGroupClassifier);
			}
			if (result == null) {
				result = caseClassifier(threadGroupClassifier);
			}
			if (result == null) {
				result = caseSubcomponentType(threadGroupClassifier);
			}
			if (result == null) {
				result = caseFeatureClassifier(threadGroupClassifier);
			}
			if (result == null) {
				result = caseNamespace(threadGroupClassifier);
			}
			if (result == null) {
				result = caseType(threadGroupClassifier);
			}
			if (result == null) {
				result = caseNamedElement(threadGroupClassifier);
			}
			if (result == null) {
				result = caseElement(threadGroupClassifier);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.THREAD_GROUP_TYPE: {
			ThreadGroupType threadGroupType = (ThreadGroupType) theEObject;
			T result = caseThreadGroupType(threadGroupType);
			if (result == null) {
				result = caseComponentType(threadGroupType);
			}
			if (result == null) {
				result = caseThreadGroupClassifier(threadGroupType);
			}
			if (result == null) {
				result = caseComponentClassifier(threadGroupType);
			}
			if (result == null) {
				result = caseThreadGroup(threadGroupType);
			}
			if (result == null) {
				result = caseThreadGroupSubcomponentType(threadGroupType);
			}
			if (result == null) {
				result = caseClassifier(threadGroupType);
			}
			if (result == null) {
				result = caseSubcomponentType(threadGroupType);
			}
			if (result == null) {
				result = caseFeatureClassifier(threadGroupType);
			}
			if (result == null) {
				result = caseNamespace(threadGroupType);
			}
			if (result == null) {
				result = caseType(threadGroupType);
			}
			if (result == null) {
				result = caseNamedElement(threadGroupType);
			}
			if (result == null) {
				result = caseElement(threadGroupType);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION: {
			ThreadGroupImplementation threadGroupImplementation = (ThreadGroupImplementation) theEObject;
			T result = caseThreadGroupImplementation(threadGroupImplementation);
			if (result == null) {
				result = caseComponentImplementation(threadGroupImplementation);
			}
			if (result == null) {
				result = caseThreadGroupClassifier(threadGroupImplementation);
			}
			if (result == null) {
				result = caseComponentClassifier(threadGroupImplementation);
			}
			if (result == null) {
				result = caseThreadGroup(threadGroupImplementation);
			}
			if (result == null) {
				result = caseThreadGroupSubcomponentType(threadGroupImplementation);
			}
			if (result == null) {
				result = caseClassifier(threadGroupImplementation);
			}
			if (result == null) {
				result = caseSubcomponentType(threadGroupImplementation);
			}
			if (result == null) {
				result = caseFeatureClassifier(threadGroupImplementation);
			}
			if (result == null) {
				result = caseNamespace(threadGroupImplementation);
			}
			if (result == null) {
				result = caseType(threadGroupImplementation);
			}
			if (result == null) {
				result = caseNamedElement(threadGroupImplementation);
			}
			if (result == null) {
				result = caseElement(threadGroupImplementation);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.THREAD_GROUP_PROTOTYPE: {
			ThreadGroupPrototype threadGroupPrototype = (ThreadGroupPrototype) theEObject;
			T result = caseThreadGroupPrototype(threadGroupPrototype);
			if (result == null) {
				result = caseComponentPrototype(threadGroupPrototype);
			}
			if (result == null) {
				result = caseThreadGroup(threadGroupPrototype);
			}
			if (result == null) {
				result = caseThreadGroupSubcomponentType(threadGroupPrototype);
			}
			if (result == null) {
				result = casePrototype(threadGroupPrototype);
			}
			if (result == null) {
				result = caseSubcomponentType(threadGroupPrototype);
			}
			if (result == null) {
				result = caseFeatureClassifier(threadGroupPrototype);
			}
			if (result == null) {
				result = caseStructuralFeature(threadGroupPrototype);
			}
			if (result == null) {
				result = caseCalledSubprogram(threadGroupPrototype);
			}
			if (result == null) {
				result = caseType(threadGroupPrototype);
			}
			if (result == null) {
				result = caseRefinableElement(threadGroupPrototype);
			}
			if (result == null) {
				result = caseClassifierFeature(threadGroupPrototype);
			}
			if (result == null) {
				result = caseNamedElement(threadGroupPrototype);
			}
			if (result == null) {
				result = caseElement(threadGroupPrototype);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.VIRTUAL_BUS_CLASSIFIER: {
			VirtualBusClassifier virtualBusClassifier = (VirtualBusClassifier) theEObject;
			T result = caseVirtualBusClassifier(virtualBusClassifier);
			if (result == null) {
				result = caseComponentClassifier(virtualBusClassifier);
			}
			if (result == null) {
				result = caseVirtualBus(virtualBusClassifier);
			}
			if (result == null) {
				result = caseVirtualBusSubcomponentType(virtualBusClassifier);
			}
			if (result == null) {
				result = caseClassifier(virtualBusClassifier);
			}
			if (result == null) {
				result = caseSubcomponentType(virtualBusClassifier);
			}
			if (result == null) {
				result = caseFeatureClassifier(virtualBusClassifier);
			}
			if (result == null) {
				result = caseNamespace(virtualBusClassifier);
			}
			if (result == null) {
				result = caseType(virtualBusClassifier);
			}
			if (result == null) {
				result = caseNamedElement(virtualBusClassifier);
			}
			if (result == null) {
				result = caseElement(virtualBusClassifier);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.VIRTUAL_BUS_TYPE: {
			VirtualBusType virtualBusType = (VirtualBusType) theEObject;
			T result = caseVirtualBusType(virtualBusType);
			if (result == null) {
				result = caseComponentType(virtualBusType);
			}
			if (result == null) {
				result = caseVirtualBusClassifier(virtualBusType);
			}
			if (result == null) {
				result = caseComponentClassifier(virtualBusType);
			}
			if (result == null) {
				result = caseVirtualBus(virtualBusType);
			}
			if (result == null) {
				result = caseVirtualBusSubcomponentType(virtualBusType);
			}
			if (result == null) {
				result = caseClassifier(virtualBusType);
			}
			if (result == null) {
				result = caseSubcomponentType(virtualBusType);
			}
			if (result == null) {
				result = caseFeatureClassifier(virtualBusType);
			}
			if (result == null) {
				result = caseNamespace(virtualBusType);
			}
			if (result == null) {
				result = caseType(virtualBusType);
			}
			if (result == null) {
				result = caseNamedElement(virtualBusType);
			}
			if (result == null) {
				result = caseElement(virtualBusType);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.VIRTUAL_BUS_IMPLEMENTATION: {
			VirtualBusImplementation virtualBusImplementation = (VirtualBusImplementation) theEObject;
			T result = caseVirtualBusImplementation(virtualBusImplementation);
			if (result == null) {
				result = caseComponentImplementation(virtualBusImplementation);
			}
			if (result == null) {
				result = caseVirtualBusClassifier(virtualBusImplementation);
			}
			if (result == null) {
				result = caseComponentClassifier(virtualBusImplementation);
			}
			if (result == null) {
				result = caseVirtualBus(virtualBusImplementation);
			}
			if (result == null) {
				result = caseVirtualBusSubcomponentType(virtualBusImplementation);
			}
			if (result == null) {
				result = caseClassifier(virtualBusImplementation);
			}
			if (result == null) {
				result = caseSubcomponentType(virtualBusImplementation);
			}
			if (result == null) {
				result = caseFeatureClassifier(virtualBusImplementation);
			}
			if (result == null) {
				result = caseNamespace(virtualBusImplementation);
			}
			if (result == null) {
				result = caseType(virtualBusImplementation);
			}
			if (result == null) {
				result = caseNamedElement(virtualBusImplementation);
			}
			if (result == null) {
				result = caseElement(virtualBusImplementation);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.VIRTUAL_BUS_PROTOTYPE: {
			VirtualBusPrototype virtualBusPrototype = (VirtualBusPrototype) theEObject;
			T result = caseVirtualBusPrototype(virtualBusPrototype);
			if (result == null) {
				result = caseComponentPrototype(virtualBusPrototype);
			}
			if (result == null) {
				result = caseVirtualBus(virtualBusPrototype);
			}
			if (result == null) {
				result = caseVirtualBusSubcomponentType(virtualBusPrototype);
			}
			if (result == null) {
				result = casePrototype(virtualBusPrototype);
			}
			if (result == null) {
				result = caseSubcomponentType(virtualBusPrototype);
			}
			if (result == null) {
				result = caseFeatureClassifier(virtualBusPrototype);
			}
			if (result == null) {
				result = caseStructuralFeature(virtualBusPrototype);
			}
			if (result == null) {
				result = caseCalledSubprogram(virtualBusPrototype);
			}
			if (result == null) {
				result = caseType(virtualBusPrototype);
			}
			if (result == null) {
				result = caseRefinableElement(virtualBusPrototype);
			}
			if (result == null) {
				result = caseClassifierFeature(virtualBusPrototype);
			}
			if (result == null) {
				result = caseNamedElement(virtualBusPrototype);
			}
			if (result == null) {
				result = caseElement(virtualBusPrototype);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.VIRTUAL_PROCESSOR_CLASSIFIER: {
			VirtualProcessorClassifier virtualProcessorClassifier = (VirtualProcessorClassifier) theEObject;
			T result = caseVirtualProcessorClassifier(virtualProcessorClassifier);
			if (result == null) {
				result = caseComponentClassifier(virtualProcessorClassifier);
			}
			if (result == null) {
				result = caseVirtualProcessor(virtualProcessorClassifier);
			}
			if (result == null) {
				result = caseVirtualProcessorSubcomponentType(virtualProcessorClassifier);
			}
			if (result == null) {
				result = caseClassifier(virtualProcessorClassifier);
			}
			if (result == null) {
				result = caseSubcomponentType(virtualProcessorClassifier);
			}
			if (result == null) {
				result = caseFeatureClassifier(virtualProcessorClassifier);
			}
			if (result == null) {
				result = caseNamespace(virtualProcessorClassifier);
			}
			if (result == null) {
				result = caseType(virtualProcessorClassifier);
			}
			if (result == null) {
				result = caseNamedElement(virtualProcessorClassifier);
			}
			if (result == null) {
				result = caseElement(virtualProcessorClassifier);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.VIRTUAL_PROCESSOR_TYPE: {
			VirtualProcessorType virtualProcessorType = (VirtualProcessorType) theEObject;
			T result = caseVirtualProcessorType(virtualProcessorType);
			if (result == null) {
				result = caseComponentType(virtualProcessorType);
			}
			if (result == null) {
				result = caseVirtualProcessorClassifier(virtualProcessorType);
			}
			if (result == null) {
				result = caseComponentClassifier(virtualProcessorType);
			}
			if (result == null) {
				result = caseVirtualProcessor(virtualProcessorType);
			}
			if (result == null) {
				result = caseVirtualProcessorSubcomponentType(virtualProcessorType);
			}
			if (result == null) {
				result = caseClassifier(virtualProcessorType);
			}
			if (result == null) {
				result = caseSubcomponentType(virtualProcessorType);
			}
			if (result == null) {
				result = caseFeatureClassifier(virtualProcessorType);
			}
			if (result == null) {
				result = caseNamespace(virtualProcessorType);
			}
			if (result == null) {
				result = caseType(virtualProcessorType);
			}
			if (result == null) {
				result = caseNamedElement(virtualProcessorType);
			}
			if (result == null) {
				result = caseElement(virtualProcessorType);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION: {
			VirtualProcessorImplementation virtualProcessorImplementation = (VirtualProcessorImplementation) theEObject;
			T result = caseVirtualProcessorImplementation(virtualProcessorImplementation);
			if (result == null) {
				result = caseComponentImplementation(virtualProcessorImplementation);
			}
			if (result == null) {
				result = caseVirtualProcessorClassifier(virtualProcessorImplementation);
			}
			if (result == null) {
				result = caseComponentClassifier(virtualProcessorImplementation);
			}
			if (result == null) {
				result = caseVirtualProcessor(virtualProcessorImplementation);
			}
			if (result == null) {
				result = caseVirtualProcessorSubcomponentType(virtualProcessorImplementation);
			}
			if (result == null) {
				result = caseClassifier(virtualProcessorImplementation);
			}
			if (result == null) {
				result = caseSubcomponentType(virtualProcessorImplementation);
			}
			if (result == null) {
				result = caseFeatureClassifier(virtualProcessorImplementation);
			}
			if (result == null) {
				result = caseNamespace(virtualProcessorImplementation);
			}
			if (result == null) {
				result = caseType(virtualProcessorImplementation);
			}
			if (result == null) {
				result = caseNamedElement(virtualProcessorImplementation);
			}
			if (result == null) {
				result = caseElement(virtualProcessorImplementation);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.VIRTUAL_PROCESSOR_PROTOTYPE: {
			VirtualProcessorPrototype virtualProcessorPrototype = (VirtualProcessorPrototype) theEObject;
			T result = caseVirtualProcessorPrototype(virtualProcessorPrototype);
			if (result == null) {
				result = caseComponentPrototype(virtualProcessorPrototype);
			}
			if (result == null) {
				result = caseVirtualProcessor(virtualProcessorPrototype);
			}
			if (result == null) {
				result = caseVirtualProcessorSubcomponentType(virtualProcessorPrototype);
			}
			if (result == null) {
				result = casePrototype(virtualProcessorPrototype);
			}
			if (result == null) {
				result = caseSubcomponentType(virtualProcessorPrototype);
			}
			if (result == null) {
				result = caseFeatureClassifier(virtualProcessorPrototype);
			}
			if (result == null) {
				result = caseStructuralFeature(virtualProcessorPrototype);
			}
			if (result == null) {
				result = caseCalledSubprogram(virtualProcessorPrototype);
			}
			if (result == null) {
				result = caseType(virtualProcessorPrototype);
			}
			if (result == null) {
				result = caseRefinableElement(virtualProcessorPrototype);
			}
			if (result == null) {
				result = caseClassifierFeature(virtualProcessorPrototype);
			}
			if (result == null) {
				result = caseNamedElement(virtualProcessorPrototype);
			}
			if (result == null) {
				result = caseElement(virtualProcessorPrototype);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.BASIC_PROPERTY_ASSOCIATION: {
			BasicPropertyAssociation basicPropertyAssociation = (BasicPropertyAssociation) theEObject;
			T result = caseBasicPropertyAssociation(basicPropertyAssociation);
			if (result == null) {
				result = caseElement(basicPropertyAssociation);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.PROPERTY_CONSTANT: {
			PropertyConstant propertyConstant = (PropertyConstant) theEObject;
			T result = casePropertyConstant(propertyConstant);
			if (result == null) {
				result = caseTypedElement(propertyConstant);
			}
			if (result == null) {
				result = caseAbstractNamedValue(propertyConstant);
			}
			if (result == null) {
				result = caseArraySizeProperty(propertyConstant);
			}
			if (result == null) {
				result = caseNamedElement(propertyConstant);
			}
			if (result == null) {
				result = caseElement(propertyConstant);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.STRING_LITERAL: {
			StringLiteral stringLiteral = (StringLiteral) theEObject;
			T result = caseStringLiteral(stringLiteral);
			if (result == null) {
				result = casePropertyValue(stringLiteral);
			}
			if (result == null) {
				result = casePropertyExpression(stringLiteral);
			}
			if (result == null) {
				result = caseElement(stringLiteral);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.PROPERTY_VALUE: {
			PropertyValue propertyValue = (PropertyValue) theEObject;
			T result = casePropertyValue(propertyValue);
			if (result == null) {
				result = casePropertyExpression(propertyValue);
			}
			if (result == null) {
				result = caseElement(propertyValue);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.NUMBER_VALUE: {
			NumberValue numberValue = (NumberValue) theEObject;
			T result = caseNumberValue(numberValue);
			if (result == null) {
				result = casePropertyValue(numberValue);
			}
			if (result == null) {
				result = casePropertyExpression(numberValue);
			}
			if (result == null) {
				result = caseElement(numberValue);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.UNIT_LITERAL: {
			UnitLiteral unitLiteral = (UnitLiteral) theEObject;
			T result = caseUnitLiteral(unitLiteral);
			if (result == null) {
				result = caseEnumerationLiteral(unitLiteral);
			}
			if (result == null) {
				result = caseNamedElement(unitLiteral);
			}
			if (result == null) {
				result = caseAbstractNamedValue(unitLiteral);
			}
			if (result == null) {
				result = caseElement(unitLiteral);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.ENUMERATION_LITERAL: {
			EnumerationLiteral enumerationLiteral = (EnumerationLiteral) theEObject;
			T result = caseEnumerationLiteral(enumerationLiteral);
			if (result == null) {
				result = caseNamedElement(enumerationLiteral);
			}
			if (result == null) {
				result = caseAbstractNamedValue(enumerationLiteral);
			}
			if (result == null) {
				result = caseElement(enumerationLiteral);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.CLASSIFIER_VALUE: {
			ClassifierValue classifierValue = (ClassifierValue) theEObject;
			T result = caseClassifierValue(classifierValue);
			if (result == null) {
				result = casePropertyOwner(classifierValue);
			}
			if (result == null) {
				result = casePropertyValue(classifierValue);
			}
			if (result == null) {
				result = casePropertyExpression(classifierValue);
			}
			if (result == null) {
				result = caseElement(classifierValue);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.REFERENCE_VALUE: {
			ReferenceValue referenceValue = (ReferenceValue) theEObject;
			T result = caseReferenceValue(referenceValue);
			if (result == null) {
				result = caseContainedNamedElement(referenceValue);
			}
			if (result == null) {
				result = casePropertyValue(referenceValue);
			}
			if (result == null) {
				result = casePropertyExpression(referenceValue);
			}
			if (result == null) {
				result = caseElement(referenceValue);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.BOOLEAN_LITERAL: {
			BooleanLiteral booleanLiteral = (BooleanLiteral) theEObject;
			T result = caseBooleanLiteral(booleanLiteral);
			if (result == null) {
				result = casePropertyValue(booleanLiteral);
			}
			if (result == null) {
				result = casePropertyExpression(booleanLiteral);
			}
			if (result == null) {
				result = caseElement(booleanLiteral);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.RANGE_VALUE: {
			RangeValue rangeValue = (RangeValue) theEObject;
			T result = caseRangeValue(rangeValue);
			if (result == null) {
				result = casePropertyValue(rangeValue);
			}
			if (result == null) {
				result = casePropertyExpression(rangeValue);
			}
			if (result == null) {
				result = caseElement(rangeValue);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.INTEGER_LITERAL: {
			IntegerLiteral integerLiteral = (IntegerLiteral) theEObject;
			T result = caseIntegerLiteral(integerLiteral);
			if (result == null) {
				result = caseNumberValue(integerLiteral);
			}
			if (result == null) {
				result = casePropertyValue(integerLiteral);
			}
			if (result == null) {
				result = casePropertyExpression(integerLiteral);
			}
			if (result == null) {
				result = caseElement(integerLiteral);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.REAL_LITERAL: {
			RealLiteral realLiteral = (RealLiteral) theEObject;
			T result = caseRealLiteral(realLiteral);
			if (result == null) {
				result = caseNumberValue(realLiteral);
			}
			if (result == null) {
				result = casePropertyValue(realLiteral);
			}
			if (result == null) {
				result = casePropertyExpression(realLiteral);
			}
			if (result == null) {
				result = caseElement(realLiteral);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.OPERATION: {
			Operation operation = (Operation) theEObject;
			T result = caseOperation(operation);
			if (result == null) {
				result = casePropertyExpression(operation);
			}
			if (result == null) {
				result = caseElement(operation);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.RECORD_VALUE: {
			RecordValue recordValue = (RecordValue) theEObject;
			T result = caseRecordValue(recordValue);
			if (result == null) {
				result = casePropertyValue(recordValue);
			}
			if (result == null) {
				result = casePropertyExpression(recordValue);
			}
			if (result == null) {
				result = caseElement(recordValue);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.COMPUTED_VALUE: {
			ComputedValue computedValue = (ComputedValue) theEObject;
			T result = caseComputedValue(computedValue);
			if (result == null) {
				result = casePropertyValue(computedValue);
			}
			if (result == null) {
				result = casePropertyExpression(computedValue);
			}
			if (result == null) {
				result = caseElement(computedValue);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.LIST_VALUE: {
			ListValue listValue = (ListValue) theEObject;
			T result = caseListValue(listValue);
			if (result == null) {
				result = casePropertyExpression(listValue);
			}
			if (result == null) {
				result = caseElement(listValue);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.NAMED_VALUE: {
			NamedValue namedValue = (NamedValue) theEObject;
			T result = caseNamedValue(namedValue);
			if (result == null) {
				result = casePropertyValue(namedValue);
			}
			if (result == null) {
				result = casePropertyExpression(namedValue);
			}
			if (result == null) {
				result = caseElement(namedValue);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.PROPERTY_SET: {
			PropertySet propertySet = (PropertySet) theEObject;
			T result = casePropertySet(propertySet);
			if (result == null) {
				result = caseNamespace(propertySet);
			}
			if (result == null) {
				result = caseModelUnit(propertySet);
			}
			if (result == null) {
				result = caseNamedElement(propertySet);
			}
			if (result == null) {
				result = caseElement(propertySet);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.GLOBAL_NAMESPACE: {
			GlobalNamespace globalNamespace = (GlobalNamespace) theEObject;
			T result = caseGlobalNamespace(globalNamespace);
			if (result == null) {
				result = caseNamespace(globalNamespace);
			}
			if (result == null) {
				result = caseNamedElement(globalNamespace);
			}
			if (result == null) {
				result = caseElement(globalNamespace);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.NON_LIST_TYPE: {
			NonListType nonListType = (NonListType) theEObject;
			T result = caseNonListType(nonListType);
			if (result == null) {
				result = casePropertyType(nonListType);
			}
			if (result == null) {
				result = caseType(nonListType);
			}
			if (result == null) {
				result = caseNamedElement(nonListType);
			}
			if (result == null) {
				result = caseElement(nonListType);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.AADL_BOOLEAN: {
			AadlBoolean aadlBoolean = (AadlBoolean) theEObject;
			T result = caseAadlBoolean(aadlBoolean);
			if (result == null) {
				result = caseNonListType(aadlBoolean);
			}
			if (result == null) {
				result = casePropertyType(aadlBoolean);
			}
			if (result == null) {
				result = caseType(aadlBoolean);
			}
			if (result == null) {
				result = caseNamedElement(aadlBoolean);
			}
			if (result == null) {
				result = caseElement(aadlBoolean);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.AADL_STRING: {
			AadlString aadlString = (AadlString) theEObject;
			T result = caseAadlString(aadlString);
			if (result == null) {
				result = caseNonListType(aadlString);
			}
			if (result == null) {
				result = casePropertyType(aadlString);
			}
			if (result == null) {
				result = caseType(aadlString);
			}
			if (result == null) {
				result = caseNamedElement(aadlString);
			}
			if (result == null) {
				result = caseElement(aadlString);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.AADL_INTEGER: {
			AadlInteger aadlInteger = (AadlInteger) theEObject;
			T result = caseAadlInteger(aadlInteger);
			if (result == null) {
				result = caseNumberType(aadlInteger);
			}
			if (result == null) {
				result = caseNonListType(aadlInteger);
			}
			if (result == null) {
				result = casePropertyType(aadlInteger);
			}
			if (result == null) {
				result = caseType(aadlInteger);
			}
			if (result == null) {
				result = caseNamedElement(aadlInteger);
			}
			if (result == null) {
				result = caseElement(aadlInteger);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.NUMBER_TYPE: {
			NumberType numberType = (NumberType) theEObject;
			T result = caseNumberType(numberType);
			if (result == null) {
				result = caseNonListType(numberType);
			}
			if (result == null) {
				result = casePropertyType(numberType);
			}
			if (result == null) {
				result = caseType(numberType);
			}
			if (result == null) {
				result = caseNamedElement(numberType);
			}
			if (result == null) {
				result = caseElement(numberType);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.UNITS_TYPE: {
			UnitsType unitsType = (UnitsType) theEObject;
			T result = caseUnitsType(unitsType);
			if (result == null) {
				result = caseEnumerationType(unitsType);
			}
			if (result == null) {
				result = caseNamespace(unitsType);
			}
			if (result == null) {
				result = caseNonListType(unitsType);
			}
			if (result == null) {
				result = casePropertyType(unitsType);
			}
			if (result == null) {
				result = caseElement(unitsType);
			}
			if (result == null) {
				result = caseType(unitsType);
			}
			if (result == null) {
				result = caseNamedElement(unitsType);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.ENUMERATION_TYPE: {
			EnumerationType enumerationType = (EnumerationType) theEObject;
			T result = caseEnumerationType(enumerationType);
			if (result == null) {
				result = caseNamespace(enumerationType);
			}
			if (result == null) {
				result = caseNonListType(enumerationType);
			}
			if (result == null) {
				result = casePropertyType(enumerationType);
			}
			if (result == null) {
				result = caseElement(enumerationType);
			}
			if (result == null) {
				result = caseType(enumerationType);
			}
			if (result == null) {
				result = caseNamedElement(enumerationType);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.NUMERIC_RANGE: {
			NumericRange numericRange = (NumericRange) theEObject;
			T result = caseNumericRange(numericRange);
			if (result == null) {
				result = caseElement(numericRange);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.AADL_REAL: {
			AadlReal aadlReal = (AadlReal) theEObject;
			T result = caseAadlReal(aadlReal);
			if (result == null) {
				result = caseNumberType(aadlReal);
			}
			if (result == null) {
				result = caseNonListType(aadlReal);
			}
			if (result == null) {
				result = casePropertyType(aadlReal);
			}
			if (result == null) {
				result = caseType(aadlReal);
			}
			if (result == null) {
				result = caseNamedElement(aadlReal);
			}
			if (result == null) {
				result = caseElement(aadlReal);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.CLASSIFIER_TYPE: {
			ClassifierType classifierType = (ClassifierType) theEObject;
			T result = caseClassifierType(classifierType);
			if (result == null) {
				result = caseNonListType(classifierType);
			}
			if (result == null) {
				result = casePropertyType(classifierType);
			}
			if (result == null) {
				result = caseType(classifierType);
			}
			if (result == null) {
				result = caseNamedElement(classifierType);
			}
			if (result == null) {
				result = caseElement(classifierType);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.RANGE_TYPE: {
			RangeType rangeType = (RangeType) theEObject;
			T result = caseRangeType(rangeType);
			if (result == null) {
				result = caseNonListType(rangeType);
			}
			if (result == null) {
				result = casePropertyType(rangeType);
			}
			if (result == null) {
				result = caseType(rangeType);
			}
			if (result == null) {
				result = caseNamedElement(rangeType);
			}
			if (result == null) {
				result = caseElement(rangeType);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.RECORD_TYPE: {
			RecordType recordType = (RecordType) theEObject;
			T result = caseRecordType(recordType);
			if (result == null) {
				result = caseNamespace(recordType);
			}
			if (result == null) {
				result = caseNonListType(recordType);
			}
			if (result == null) {
				result = casePropertyType(recordType);
			}
			if (result == null) {
				result = caseElement(recordType);
			}
			if (result == null) {
				result = caseType(recordType);
			}
			if (result == null) {
				result = caseNamedElement(recordType);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.RECORD_FIELD: {
			RecordField recordField = (RecordField) theEObject;
			T result = caseRecordField(recordField);
			if (result == null) {
				result = caseBasicProperty(recordField);
			}
			if (result == null) {
				result = caseTypedElement(recordField);
			}
			if (result == null) {
				result = caseNamedElement(recordField);
			}
			if (result == null) {
				result = caseElement(recordField);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.REFERENCE_TYPE: {
			ReferenceType referenceType = (ReferenceType) theEObject;
			T result = caseReferenceType(referenceType);
			if (result == null) {
				result = caseNonListType(referenceType);
			}
			if (result == null) {
				result = casePropertyType(referenceType);
			}
			if (result == null) {
				result = caseType(referenceType);
			}
			if (result == null) {
				result = caseNamedElement(referenceType);
			}
			if (result == null) {
				result = caseElement(referenceType);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case Aadl2Package.LIST_TYPE: {
			ListType listType = (ListType) theEObject;
			T result = caseListType(listType);
			if (result == null) {
				result = casePropertyType(listType);
			}
			if (result == null) {
				result = caseType(listType);
			}
			if (result == null) {
				result = caseNamedElement(listType);
			}
			if (result == null) {
				result = caseElement(listType);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElement(Element object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Comment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Comment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComment(Comment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Namespace</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Namespace</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamespace(Namespace object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Association</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Association</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyAssociation(PropertyAssociation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Basic Property Association</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Basic Property Association</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBasicPropertyAssociation(BasicPropertyAssociation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseType(Type object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typed Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypedElement(TypedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Classifier Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Classifier Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassifierFeature(ClassifierFeature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Refinable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Refinable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRefinableElement(RefinableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Classifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Classifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeatureClassifier(FeatureClassifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Behavioral Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Behavioral Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBehavioralFeature(BehavioralFeature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Array Dimension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Array Dimension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArrayDimension(ArrayDimension object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Classifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Classifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassifier(Classifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Generalization</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Generalization</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGeneralization(Generalization object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Directed Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Directed Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDirectedRelationship(DirectedRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelationship(Relationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Prototype</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrototype(Prototype object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Classifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Classifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentClassifier(ComponentClassifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Subcomponent Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subcomponent Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubcomponentType(SubcomponentType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mode</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mode</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMode(Mode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mode Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mode Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModeFeature(ModeFeature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mode Transition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mode Transition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModeTransition(ModeTransition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mode Transition Trigger</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mode Transition Trigger</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModeTransitionTrigger(ModeTransitionTrigger object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Trigger Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Trigger Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTriggerPort(TriggerPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContext(Context object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePort(Port object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Directed Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Directed Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDirectedFeature(DirectedFeature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Prototype Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Prototype Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrototypeBinding(PrototypeBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Arrayable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Arrayable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArrayableElement(ArrayableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Array Size</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Array Size</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArraySize(ArraySize object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Annex Subclause</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Annex Subclause</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnnexSubclause(AnnexSubclause object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Structural Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Structural Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStructuralFeature(StructuralFeature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Modal Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Modal Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModalElement(ModalElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mode Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mode Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModeBinding(ModeBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Subcomponent Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Subcomponent Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractSubcomponentType(AbstractSubcomponentType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Implementation Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Implementation Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentImplementationReference(ComponentImplementationReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Connection End</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Connection End</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeatureConnectionEnd(FeatureConnectionEnd object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Subcomponent</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subcomponent</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubcomponent(Subcomponent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Extension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Extension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeExtension(TypeExtension object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentType(ComponentType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeature(Feature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Flow Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Flow Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFlowSpecification(FlowSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Flow Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Flow Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFlowFeature(FlowFeature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Flow</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Flow</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFlow(Flow object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>End To End Flow Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>End To End Flow Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEndToEndFlowElement(EndToEndFlowElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Flow End</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Flow End</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFlowEnd(FlowEnd object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeatureGroup(FeatureGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Group Connection End</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Group Connection End</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeatureGroupConnectionEnd(FeatureGroupConnectionEnd object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeatureType(FeatureType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Call Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Call Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCallContext(CallContext object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connection End</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connection End</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnectionEnd(ConnectionEnd object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Group Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Group Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeatureGroupType(FeatureGroupType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Group Extension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Group Extension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGroupExtension(GroupExtension object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Implementation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentImplementation(ComponentImplementation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Flow Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Flow Implementation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFlowImplementation(FlowImplementation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnection(Connection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connected Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connected Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnectedElement(ConnectedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Flow Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Flow Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFlowElement(FlowElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Realization</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Realization</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRealization(Realization object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Subcomponent</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Subcomponent</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractSubcomponent(AbstractSubcomponent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Prototype</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentPrototype(ComponentPrototype object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Prototype Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Prototype Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentPrototypeBinding(ComponentPrototypeBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Prototype Actual</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Prototype Actual</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentPrototypeActual(ComponentPrototypeActual object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Group Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Group Prototype</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeatureGroupPrototype(FeatureGroupPrototype object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Group Prototype Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Group Prototype Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeatureGroupPrototypeBinding(FeatureGroupPrototypeBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Group Prototype Actual</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Group Prototype Actual</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeatureGroupPrototypeActual(FeatureGroupPrototypeActual object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Prototype</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeaturePrototype(FeaturePrototype object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Prototype Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Prototype Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeaturePrototypeBinding(FeaturePrototypeBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Prototype Actual</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Prototype Actual</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeaturePrototypeActual(FeaturePrototypeActual object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Access Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Access Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAccessSpecification(AccessSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Port Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Port Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePortSpecification(PortSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Prototype Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Prototype Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeaturePrototypeReference(FeaturePrototypeReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstract(Abstract object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Classifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Classifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractClassifier(AbstractClassifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>End To End Flow</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>End To End Flow</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEndToEndFlow(EndToEndFlow object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>End To End Flow Segment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>End To End Flow Segment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEndToEndFlowSegment(EndToEndFlowSegment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeatureConnection(FeatureConnection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Public Package Section</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Public Package Section</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePublicPackageSection(PublicPackageSection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Package Section</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Package Section</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePackageSection(PackageSection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Package Rename</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Package Rename</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePackageRename(PackageRename object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Aadl Package</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Aadl Package</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAadlPackage(AadlPackage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelUnit(ModelUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Private Package Section</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Private Package Section</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrivatePackageSection(PrivatePackageSection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Type Rename</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Type Rename</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentTypeRename(ComponentTypeRename object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Group Type Rename</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Group Type Rename</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeatureGroupTypeRename(FeatureGroupTypeRename object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Annex Library</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Annex Library</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnnexLibrary(AnnexLibrary object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Global Namespace</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Global Namespace</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGlobalNamespace(GlobalNamespace object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Non List Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Non List Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNonListType(NonListType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertySet(PropertySet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyType(PropertyType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProperty(Property object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Contained Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Contained Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContainedNamedElement(ContainedNamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Array Range</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Array Range</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArrayRange(ArrayRange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Modal Property Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Modal Property Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModalPropertyValue(ModalPropertyValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Containment Path Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Containment Path Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContainmentPathElement(ContainmentPathElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyExpression(PropertyExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Basic Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Basic Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBasicProperty(BasicProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Constant</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Constant</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyConstant(PropertyConstant object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Default Annex Library</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Default Annex Library</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDefaultAnnexLibrary(DefaultAnnexLibrary object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Default Annex Subclause</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Default Annex Subclause</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDefaultAnnexSubclause(DefaultAnnexSubclause object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractFeature(AbstractFeature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Modal Path</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Modal Path</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModalPath(ModalPath object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Flow Segment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Flow Segment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFlowSegment(FlowSegment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Access Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Access Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAccessConnection(AccessConnection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterConnection(ParameterConnection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter Connection End</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter Connection End</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterConnectionEnd(ParameterConnectionEnd object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Port Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Port Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePortConnection(PortConnection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Port Connection End</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Port Connection End</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePortConnectionEnd(PortConnectionEnd object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Access Connection End</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Access Connection End</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAccessConnectionEnd(AccessConnectionEnd object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Group Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Group Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeatureGroupConnection(FeatureGroupConnection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Processor Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Processor Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessorFeature(ProcessorFeature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Internal Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Internal Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInternalFeature(InternalFeature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Source</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Source</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventSource(EventSource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Data Source</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Data Source</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventDataSource(EventDataSource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Port Proxy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Port Proxy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePortProxy(PortProxy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Subprogram Proxy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subprogram Proxy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubprogramProxy(SubprogramProxy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Access</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Access</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataAccess(DataAccess object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Classifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Classifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataClassifier(DataClassifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Subcomponent Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Subcomponent Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataSubcomponentType(DataSubcomponentType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseData(Data object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bus Access</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bus Access</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBusAccess(BusAccess object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Access</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Access</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAccess(Access object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bus Classifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bus Classifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBusClassifier(BusClassifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bus Subcomponent Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bus Subcomponent Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBusSubcomponentType(BusSubcomponentType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bus</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bus</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBus(Bus object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Subprogram Access</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subprogram Access</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubprogramAccess(SubprogramAccess object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Called Subprogram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Called Subprogram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCalledSubprogram(CalledSubprogram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Subprogram Classifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subprogram Classifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubprogramClassifier(SubprogramClassifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Subprogram Subcomponent Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subprogram Subcomponent Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubprogramSubcomponentType(SubprogramSubcomponentType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Subprogram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subprogram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubprogram(Subprogram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataPort(DataPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventPort(EventPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Data Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Data Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventDataPort(EventDataPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameter(Parameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Subprogram Group Access</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subprogram Group Access</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubprogramGroupAccess(SubprogramGroupAccess object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Subprogram Group Classifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subprogram Group Classifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubprogramGroupClassifier(SubprogramGroupClassifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Subprogram Group Subcomponent Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subprogram Group Subcomponent Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubprogramGroupSubcomponentType(SubprogramGroupSubcomponentType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Subprogram Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subprogram Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubprogramGroup(SubprogramGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Implementation Extension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Implementation Extension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImplementationExtension(ImplementationExtension object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Device</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Device</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDevice(Device object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Device Subcomponent Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Device Subcomponent Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeviceSubcomponentType(DeviceSubcomponentType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Device Classifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Device Classifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeviceClassifier(DeviceClassifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Device Subcomponent</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Device Subcomponent</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeviceSubcomponent(DeviceSubcomponent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Device Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Device Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeviceType(DeviceType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Device Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Device Implementation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeviceImplementation(DeviceImplementation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Device Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Device Prototype</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDevicePrototype(DevicePrototype object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bus Subcomponent</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bus Subcomponent</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBusSubcomponent(BusSubcomponent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractType(AbstractType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Implementation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractImplementation(AbstractImplementation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Behaviored Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Behaviored Implementation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBehavioredImplementation(BehavioredImplementation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Subcomponent</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Subcomponent</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataSubcomponent(DataSubcomponent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Memory Subcomponent</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Memory Subcomponent</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMemorySubcomponent(MemorySubcomponent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Memory</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Memory</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMemory(Memory object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Memory Subcomponent Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Memory Subcomponent Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMemorySubcomponentType(MemorySubcomponentType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Memory Classifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Memory Classifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMemoryClassifier(MemoryClassifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Process Subcomponent</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Process Subcomponent</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessSubcomponent(ProcessSubcomponent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Process Subcomponent Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Process Subcomponent Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessSubcomponentType(ProcessSubcomponentType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Process</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Process</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcess(org.osate.aadl2.Process object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Process Classifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Process Classifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessClassifier(ProcessClassifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Processor Subcomponent</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Processor Subcomponent</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessorSubcomponent(ProcessorSubcomponent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Processor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Processor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessor(Processor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Processor Subcomponent Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Processor Subcomponent Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessorSubcomponentType(ProcessorSubcomponentType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Processor Classifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Processor Classifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessorClassifier(ProcessorClassifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>System Subcomponent</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>System Subcomponent</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSystemSubcomponent(SystemSubcomponent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>System Subcomponent Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>System Subcomponent Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSystemSubcomponentType(SystemSubcomponentType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSystem(org.osate.aadl2.System object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>System Classifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>System Classifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSystemClassifier(SystemClassifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Subprogram Subcomponent</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subprogram Subcomponent</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubprogramSubcomponent(SubprogramSubcomponent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Subprogram Group Subcomponent</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subprogram Group Subcomponent</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubprogramGroupSubcomponent(SubprogramGroupSubcomponent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Thread Subcomponent</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Thread Subcomponent</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThreadSubcomponent(ThreadSubcomponent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Thread Subcomponent Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Thread Subcomponent Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThreadSubcomponentType(ThreadSubcomponentType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Thread</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Thread</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThread(org.osate.aadl2.Thread object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Thread Classifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Thread Classifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThreadClassifier(ThreadClassifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Thread Group Subcomponent</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Thread Group Subcomponent</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThreadGroupSubcomponent(ThreadGroupSubcomponent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Thread Group Subcomponent Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Thread Group Subcomponent Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThreadGroupSubcomponentType(ThreadGroupSubcomponentType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Thread Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Thread Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThreadGroup(org.osate.aadl2.ThreadGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Thread Group Classifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Thread Group Classifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThreadGroupClassifier(ThreadGroupClassifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Virtual Bus Subcomponent</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Virtual Bus Subcomponent</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVirtualBusSubcomponent(VirtualBusSubcomponent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Virtual Bus</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Virtual Bus</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVirtualBus(VirtualBus object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Virtual Bus Classifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Virtual Bus Classifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVirtualBusClassifier(VirtualBusClassifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Virtual Processor Subcomponent</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Virtual Processor Subcomponent</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVirtualProcessorSubcomponent(VirtualProcessorSubcomponent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Virtual Processor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Virtual Processor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVirtualProcessor(VirtualProcessor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Virtual Bus Subcomponent Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Virtual Bus Subcomponent Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVirtualBusSubcomponentType(VirtualBusSubcomponentType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Virtual Processor Subcomponent Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Virtual Processor Subcomponent Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVirtualProcessorSubcomponentType(VirtualProcessorSubcomponentType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Prototype</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractPrototype(AbstractPrototype object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Virtual Processor Classifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Virtual Processor Classifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVirtualProcessorClassifier(VirtualProcessorClassifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Subprogram Call Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subprogram Call Sequence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubprogramCallSequence(SubprogramCallSequence object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Subprogram Call</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subprogram Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubprogramCall(SubprogramCall object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bus Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bus Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBusType(BusType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bus Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bus Implementation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBusImplementation(BusImplementation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bus Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bus Prototype</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBusPrototype(BusPrototype object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataType(DataType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Implementation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataImplementation(DataImplementation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Prototype</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataPrototype(DataPrototype object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Memory Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Memory Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMemoryType(MemoryType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Memory Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Memory Implementation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMemoryImplementation(MemoryImplementation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Memory Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Memory Prototype</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMemoryPrototype(MemoryPrototype object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>System Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>System Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSystemType(SystemType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>System Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>System Implementation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSystemImplementation(SystemImplementation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>System Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>System Prototype</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSystemPrototype(SystemPrototype object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Thread Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Thread Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThreadType(ThreadType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Thread Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Thread Implementation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThreadImplementation(ThreadImplementation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Thread Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Thread Prototype</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThreadPrototype(ThreadPrototype object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Thread Group Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Thread Group Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThreadGroupType(ThreadGroupType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Thread Group Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Thread Group Implementation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThreadGroupImplementation(ThreadGroupImplementation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Thread Group Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Thread Group Prototype</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThreadGroupPrototype(ThreadGroupPrototype object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Virtual Bus Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Virtual Bus Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVirtualBusType(VirtualBusType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Virtual Bus Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Virtual Bus Implementation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVirtualBusImplementation(VirtualBusImplementation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Virtual Bus Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Virtual Bus Prototype</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVirtualBusPrototype(VirtualBusPrototype object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Virtual Processor Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Virtual Processor Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVirtualProcessorType(VirtualProcessorType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Virtual Processor Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Virtual Processor Implementation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVirtualProcessorImplementation(VirtualProcessorImplementation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Virtual Processor Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Virtual Processor Prototype</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVirtualProcessorPrototype(VirtualProcessorPrototype object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Subprogram Group Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subprogram Group Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubprogramGroupType(SubprogramGroupType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Subprogram Group Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subprogram Group Implementation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubprogramGroupImplementation(SubprogramGroupImplementation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Subprogram Group Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subprogram Group Prototype</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubprogramGroupPrototype(SubprogramGroupPrototype object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Processor Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Processor Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessorType(ProcessorType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Processor Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Processor Implementation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessorImplementation(ProcessorImplementation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Processor Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Processor Prototype</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessorPrototype(ProcessorPrototype object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Process Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Process Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessType(ProcessType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Process Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Process Implementation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessImplementation(ProcessImplementation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Process Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Process Prototype</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessPrototype(ProcessPrototype object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Subprogram Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subprogram Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubprogramType(SubprogramType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Subprogram Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subprogram Implementation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubprogramImplementation(SubprogramImplementation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Subprogram Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subprogram Prototype</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubprogramPrototype(SubprogramPrototype object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Named Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Named Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractNamedValue(AbstractNamedValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Array Size Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Array Size Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArraySizeProperty(ArraySizeProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyValue(PropertyValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Number Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Number Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNumberType(NumberType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Units Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Units Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnitsType(UnitsType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Aadl Integer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Aadl Integer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAadlInteger(AadlInteger object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Aadl Real</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Aadl Real</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAadlReal(AadlReal object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Aadl Boolean</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Aadl Boolean</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAadlBoolean(AadlBoolean object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Aadl String</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Aadl String</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAadlString(AadlString object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enumeration Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enumeration Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumerationType(EnumerationType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Numeric Range</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Numeric Range</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNumericRange(NumericRange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enumeration Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enumeration Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumerationLiteral(EnumerationLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unit Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unit Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnitLiteral(UnitLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringLiteral(StringLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Number Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Number Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNumberValue(NumberValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Classifier Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Classifier Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassifierValue(ClassifierValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReferenceValue(ReferenceValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanLiteral(BooleanLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Range Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Range Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRangeValue(RangeValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntegerLiteral(IntegerLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Real Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Real Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRealLiteral(RealLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperation(Operation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Record Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Record Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRecordValue(RecordValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Computed Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Computed Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComputedValue(ComputedValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>List Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>List Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseListValue(ListValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedValue(NamedValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Classifier Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Classifier Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassifierType(ClassifierType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Metaclass Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Metaclass Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMetaclassReference(MetaclassReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Owner</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Owner</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyOwner(PropertyOwner object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReferenceType(ReferenceType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>List Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>List Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseListType(ListType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Range Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Range Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRangeType(RangeType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Record Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Record Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRecordType(RecordType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Record Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Record Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRecordField(RecordField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} // Aadl2Switch
