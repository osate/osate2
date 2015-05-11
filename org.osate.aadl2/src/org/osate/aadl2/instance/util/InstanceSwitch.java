/**
 * <copyright>
 * </copyright>
 *
 * $Id: InstanceSwitch.java,v 1.12 2011-04-11 13:35:57 lwrage Exp $
 */
package org.osate.aadl2.instance.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.osate.aadl2.ClassifierFeature;
import org.osate.aadl2.Element;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeFeature;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.PropertyValue;
import org.osate.aadl2.instance.AnnexInstance;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.FlowElementInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.InstancePackage;
import org.osate.aadl2.instance.InstanceReferenceValue;
import org.osate.aadl2.instance.ModeInstance;
import org.osate.aadl2.instance.ModeTransitionInstance;
import org.osate.aadl2.instance.PropertyAssociationInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;

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
 * @see org.osate.aadl2.instance.InstancePackage
 * @generated
 */
public class InstanceSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static InstancePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceSwitch() {
		if (modelPackage == null) {
			modelPackage = InstancePackage.eINSTANCE;
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
		case InstancePackage.FEATURE_INSTANCE: {
			FeatureInstance featureInstance = (FeatureInstance) theEObject;
			T result = caseFeatureInstance(featureInstance);
			if (result == null) {
				result = caseConnectionInstanceEnd(featureInstance);
			}
			if (result == null) {
				result = caseInstanceObject(featureInstance);
			}
			if (result == null) {
				result = caseNamedElement(featureInstance);
			}
			if (result == null) {
				result = caseElement(featureInstance);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case InstancePackage.INSTANCE_OBJECT: {
			InstanceObject instanceObject = (InstanceObject) theEObject;
			T result = caseInstanceObject(instanceObject);
			if (result == null) {
				result = caseNamedElement(instanceObject);
			}
			if (result == null) {
				result = caseElement(instanceObject);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case InstancePackage.ANNEX_INSTANCE: {
			AnnexInstance annexInstance = (AnnexInstance) theEObject;
			T result = caseAnnexInstance(annexInstance);
			if (result == null) {
				result = caseNamedElement(annexInstance);
			}
			if (result == null) {
				result = caseElement(annexInstance);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case InstancePackage.PROPERTY_ASSOCIATION_INSTANCE: {
			PropertyAssociationInstance propertyAssociationInstance = (PropertyAssociationInstance) theEObject;
			T result = casePropertyAssociationInstance(propertyAssociationInstance);
			if (result == null) {
				result = casePropertyAssociation(propertyAssociationInstance);
			}
			if (result == null) {
				result = caseElement(propertyAssociationInstance);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case InstancePackage.CONNECTION_INSTANCE_END: {
			ConnectionInstanceEnd connectionInstanceEnd = (ConnectionInstanceEnd) theEObject;
			T result = caseConnectionInstanceEnd(connectionInstanceEnd);
			if (result == null) {
				result = caseInstanceObject(connectionInstanceEnd);
			}
			if (result == null) {
				result = caseNamedElement(connectionInstanceEnd);
			}
			if (result == null) {
				result = caseElement(connectionInstanceEnd);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case InstancePackage.CONNECTION_INSTANCE: {
			ConnectionInstance connectionInstance = (ConnectionInstance) theEObject;
			T result = caseConnectionInstance(connectionInstance);
			if (result == null) {
				result = caseFlowElementInstance(connectionInstance);
			}
			if (result == null) {
				result = caseInstanceObject(connectionInstance);
			}
			if (result == null) {
				result = caseNamedElement(connectionInstance);
			}
			if (result == null) {
				result = caseElement(connectionInstance);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case InstancePackage.FLOW_ELEMENT_INSTANCE: {
			FlowElementInstance flowElementInstance = (FlowElementInstance) theEObject;
			T result = caseFlowElementInstance(flowElementInstance);
			if (result == null) {
				result = caseInstanceObject(flowElementInstance);
			}
			if (result == null) {
				result = caseNamedElement(flowElementInstance);
			}
			if (result == null) {
				result = caseElement(flowElementInstance);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case InstancePackage.SYSTEM_OPERATION_MODE: {
			SystemOperationMode systemOperationMode = (SystemOperationMode) theEObject;
			T result = caseSystemOperationMode(systemOperationMode);
			if (result == null) {
				result = caseMode(systemOperationMode);
			}
			if (result == null) {
				result = caseModeFeature(systemOperationMode);
			}
			if (result == null) {
				result = caseClassifierFeature(systemOperationMode);
			}
			if (result == null) {
				result = caseNamedElement(systemOperationMode);
			}
			if (result == null) {
				result = caseElement(systemOperationMode);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case InstancePackage.MODE_INSTANCE: {
			ModeInstance modeInstance = (ModeInstance) theEObject;
			T result = caseModeInstance(modeInstance);
			if (result == null) {
				result = caseInstanceObject(modeInstance);
			}
			if (result == null) {
				result = caseNamedElement(modeInstance);
			}
			if (result == null) {
				result = caseElement(modeInstance);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case InstancePackage.MODE_TRANSITION_INSTANCE: {
			ModeTransitionInstance modeTransitionInstance = (ModeTransitionInstance) theEObject;
			T result = caseModeTransitionInstance(modeTransitionInstance);
			if (result == null) {
				result = caseConnectionInstanceEnd(modeTransitionInstance);
			}
			if (result == null) {
				result = caseInstanceObject(modeTransitionInstance);
			}
			if (result == null) {
				result = caseNamedElement(modeTransitionInstance);
			}
			if (result == null) {
				result = caseElement(modeTransitionInstance);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case InstancePackage.CONNECTION_REFERENCE: {
			ConnectionReference connectionReference = (ConnectionReference) theEObject;
			T result = caseConnectionReference(connectionReference);
			if (result == null) {
				result = caseInstanceObject(connectionReference);
			}
			if (result == null) {
				result = caseNamedElement(connectionReference);
			}
			if (result == null) {
				result = caseElement(connectionReference);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case InstancePackage.COMPONENT_INSTANCE: {
			ComponentInstance componentInstance = (ComponentInstance) theEObject;
			T result = caseComponentInstance(componentInstance);
			if (result == null) {
				result = caseConnectionInstanceEnd(componentInstance);
			}
			if (result == null) {
				result = caseFlowElementInstance(componentInstance);
			}
			if (result == null) {
				result = caseInstanceObject(componentInstance);
			}
			if (result == null) {
				result = caseNamedElement(componentInstance);
			}
			if (result == null) {
				result = caseElement(componentInstance);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case InstancePackage.FLOW_SPECIFICATION_INSTANCE: {
			FlowSpecificationInstance flowSpecificationInstance = (FlowSpecificationInstance) theEObject;
			T result = caseFlowSpecificationInstance(flowSpecificationInstance);
			if (result == null) {
				result = caseFlowElementInstance(flowSpecificationInstance);
			}
			if (result == null) {
				result = caseInstanceObject(flowSpecificationInstance);
			}
			if (result == null) {
				result = caseNamedElement(flowSpecificationInstance);
			}
			if (result == null) {
				result = caseElement(flowSpecificationInstance);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case InstancePackage.END_TO_END_FLOW_INSTANCE: {
			EndToEndFlowInstance endToEndFlowInstance = (EndToEndFlowInstance) theEObject;
			T result = caseEndToEndFlowInstance(endToEndFlowInstance);
			if (result == null) {
				result = caseFlowElementInstance(endToEndFlowInstance);
			}
			if (result == null) {
				result = caseInstanceObject(endToEndFlowInstance);
			}
			if (result == null) {
				result = caseNamedElement(endToEndFlowInstance);
			}
			if (result == null) {
				result = caseElement(endToEndFlowInstance);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case InstancePackage.SYSTEM_INSTANCE: {
			SystemInstance systemInstance = (SystemInstance) theEObject;
			T result = caseSystemInstance(systemInstance);
			if (result == null) {
				result = caseComponentInstance(systemInstance);
			}
			if (result == null) {
				result = caseConnectionInstanceEnd(systemInstance);
			}
			if (result == null) {
				result = caseFlowElementInstance(systemInstance);
			}
			if (result == null) {
				result = caseInstanceObject(systemInstance);
			}
			if (result == null) {
				result = caseNamedElement(systemInstance);
			}
			if (result == null) {
				result = caseElement(systemInstance);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case InstancePackage.INSTANCE_REFERENCE_VALUE: {
			InstanceReferenceValue instanceReferenceValue = (InstanceReferenceValue) theEObject;
			T result = caseInstanceReferenceValue(instanceReferenceValue);
			if (result == null) {
				result = casePropertyValue(instanceReferenceValue);
			}
			if (result == null) {
				result = casePropertyExpression(instanceReferenceValue);
			}
			if (result == null) {
				result = caseElement(instanceReferenceValue);
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
	 * Returns the result of interpreting the object as an instance of '<em>Feature Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeatureInstance(FeatureInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstanceObject(InstanceObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Annex Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Annex Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnnexInstance(AnnexInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Association Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Association Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyAssociationInstance(PropertyAssociationInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connection Instance End</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connection Instance End</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnectionInstanceEnd(ConnectionInstanceEnd object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connection Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connection Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnectionInstance(ConnectionInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Flow Element Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Flow Element Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFlowElementInstance(FlowElementInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>System Operation Mode</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>System Operation Mode</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSystemOperationMode(SystemOperationMode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mode Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mode Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModeInstance(ModeInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mode Transition Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mode Transition Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModeTransitionInstance(ModeTransitionInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connection Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connection Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnectionReference(ConnectionReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentInstance(ComponentInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Flow Specification Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Flow Specification Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFlowSpecificationInstance(FlowSpecificationInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>End To End Flow Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>End To End Flow Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEndToEndFlowInstance(EndToEndFlowInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>System Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>System Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSystemInstance(SystemInstance object) {
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
	public T caseInstanceReferenceValue(InstanceReferenceValue object) {
		return null;
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

} // InstanceSwitch
