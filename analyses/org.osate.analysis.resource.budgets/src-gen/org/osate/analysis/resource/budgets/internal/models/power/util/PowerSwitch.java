/**
 * Copyright Text	Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file)....
 */
package org.osate.analysis.resource.budgets.internal.models.power.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.osate.analysis.model.AnalysisElement;
import org.osate.analysis.resource.budgets.internal.models.power.PowerConsumer;
import org.osate.analysis.resource.budgets.internal.models.power.PowerElement;
import org.osate.analysis.resource.budgets.internal.models.power.PowerModel;
import org.osate.analysis.resource.budgets.internal.models.power.PowerPackage;
import org.osate.analysis.resource.budgets.internal.models.power.PowerSupplier;
import org.osate.analysis.resource.budgets.internal.models.power.PowerTransmissionSystem;

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
 * @see org.osate.analysis.resource.budgets.internal.models.power.PowerPackage
 * @generated
 * @since 4.1
 */
public class PowerSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PowerPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PowerSwitch() {
		if (modelPackage == null) {
			modelPackage = PowerPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
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
			case PowerPackage.POWER_ELEMENT: {
				PowerElement powerElement = (PowerElement)theEObject;
				T result = casePowerElement(powerElement);
				if (result == null) {
					result = caseAnalysisElement(powerElement);
				}
				if (result == null) {
					result = defaultCase(theEObject);
				}
				return result;
			}
			case PowerPackage.POWER_TRANSMISSION_SYSTEM: {
				PowerTransmissionSystem powerTransmissionSystem = (PowerTransmissionSystem)theEObject;
				T result = casePowerTransmissionSystem(powerTransmissionSystem);
				if (result == null) {
					result = casePowerElement(powerTransmissionSystem);
				}
				if (result == null) {
					result = caseAnalysisElement(powerTransmissionSystem);
				}
				if (result == null) {
					result = defaultCase(theEObject);
				}
				return result;
			}
			case PowerPackage.POWER_SUPPLIER: {
				PowerSupplier powerSupplier = (PowerSupplier)theEObject;
				T result = casePowerSupplier(powerSupplier);
				if (result == null) {
					result = casePowerElement(powerSupplier);
				}
				if (result == null) {
					result = caseAnalysisElement(powerSupplier);
				}
				if (result == null) {
					result = defaultCase(theEObject);
				}
				return result;
			}
			case PowerPackage.POWER_CONSUMER: {
				PowerConsumer powerConsumer = (PowerConsumer)theEObject;
				T result = casePowerConsumer(powerConsumer);
				if (result == null) {
					result = casePowerElement(powerConsumer);
				}
				if (result == null) {
					result = caseAnalysisElement(powerConsumer);
				}
				if (result == null) {
					result = defaultCase(theEObject);
				}
				return result;
			}
			case PowerPackage.POWER_MODEL: {
				PowerModel powerModel = (PowerModel)theEObject;
				T result = casePowerModel(powerModel);
				if (result == null) {
					result = caseAnalysisElement(powerModel);
				}
				if (result == null) {
					result = defaultCase(theEObject);
				}
				return result;
			}
			default: return defaultCase(theEObject);
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
	public T casePowerElement(PowerElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transmission System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transmission System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePowerTransmissionSystem(PowerTransmissionSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Supplier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Supplier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePowerSupplier(PowerSupplier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Consumer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Consumer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePowerConsumer(PowerConsumer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePowerModel(PowerModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Analysis Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Analysis Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnalysisElement(AnalysisElement object) {
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

} //PowerSwitch
