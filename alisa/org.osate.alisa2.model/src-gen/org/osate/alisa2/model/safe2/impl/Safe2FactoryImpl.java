/**
 */
package org.osate.alisa2.model.safe2.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.osate.alisa2.model.safe2.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Safe2FactoryImpl extends EFactoryImpl implements Safe2Factory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Safe2Factory init() {
		try {
			Safe2Factory theSafe2Factory = (Safe2Factory)EPackage.Registry.INSTANCE.getEFactory(Safe2Package.eNS_URI);
			if (theSafe2Factory != null) {
				return theSafe2Factory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Safe2FactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Safe2FactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case Safe2Package.ACCIDENT: return createAccident();
			case Safe2Package.HAZARD: return createHazard();
			case Safe2Package.ACCIDENT_LEVEL: return createAccidentLevel();
			case Safe2Package.CONSTRAINT: return createConstraint();
			case Safe2Package.CONTROL_ACTION: return createControlAction();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Accident createAccident() {
		AccidentImpl accident = new AccidentImpl();
		return accident;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Hazard createHazard() {
		HazardImpl hazard = new HazardImpl();
		return hazard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AccidentLevel createAccidentLevel() {
		AccidentLevelImpl accidentLevel = new AccidentLevelImpl();
		return accidentLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Constraint createConstraint() {
		ConstraintImpl constraint = new ConstraintImpl();
		return constraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControlAction createControlAction() {
		ControlActionImpl controlAction = new ControlActionImpl();
		return controlAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Safe2Package getSafe2Package() {
		return (Safe2Package)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Safe2Package getPackage() {
		return Safe2Package.eINSTANCE;
	}

} //Safe2FactoryImpl
