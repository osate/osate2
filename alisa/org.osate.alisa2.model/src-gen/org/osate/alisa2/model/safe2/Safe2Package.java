/**
 */
package org.osate.alisa2.model.safe2;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.osate.alisa2.model.safe2.Safe2Factory
 * @model kind="package"
 * @generated
 */
public interface Safe2Package extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "safe2";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/safe2";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "safe2";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Safe2Package eINSTANCE = org.osate.alisa2.model.safe2.impl.Safe2PackageImpl.init();

	/**
	 * The meta object id for the '{@link org.osate.alisa2.model.safe2.Node <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.alisa2.model.safe2.Node
	 * @see org.osate.alisa2.model.safe2.impl.Safe2PackageImpl#getNode()
	 * @generated
	 */
	int NODE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__NAME = 0;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.osate.alisa2.model.safe2.Fundamental <em>Fundamental</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.alisa2.model.safe2.Fundamental
	 * @see org.osate.alisa2.model.safe2.impl.Safe2PackageImpl#getFundamental()
	 * @generated
	 */
	int FUNDAMENTAL = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNDAMENTAL__NAME = NODE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNDAMENTAL__DESCRIPTION = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Fundamental</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNDAMENTAL_FEATURE_COUNT = NODE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Fundamental</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNDAMENTAL_OPERATION_COUNT = NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.alisa2.model.safe2.impl.AccidentImpl <em>Accident</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.alisa2.model.safe2.impl.AccidentImpl
	 * @see org.osate.alisa2.model.safe2.impl.Safe2PackageImpl#getAccident()
	 * @generated
	 */
	int ACCIDENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCIDENT__NAME = FUNDAMENTAL__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCIDENT__DESCRIPTION = FUNDAMENTAL__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Accidentlevel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCIDENT__ACCIDENTLEVEL = FUNDAMENTAL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Hazard</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCIDENT__HAZARD = FUNDAMENTAL_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Accident</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCIDENT_FEATURE_COUNT = FUNDAMENTAL_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Accident</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCIDENT_OPERATION_COUNT = FUNDAMENTAL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.alisa2.model.safe2.impl.HazardImpl <em>Hazard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.alisa2.model.safe2.impl.HazardImpl
	 * @see org.osate.alisa2.model.safe2.impl.Safe2PackageImpl#getHazard()
	 * @generated
	 */
	int HAZARD = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAZARD__NAME = FUNDAMENTAL__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAZARD__DESCRIPTION = FUNDAMENTAL__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Accident</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAZARD__ACCIDENT = FUNDAMENTAL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAZARD__CONSTRAINT = FUNDAMENTAL_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Hazard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAZARD_FEATURE_COUNT = FUNDAMENTAL_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Hazard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAZARD_OPERATION_COUNT = FUNDAMENTAL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.alisa2.model.safe2.impl.AccidentLevelImpl <em>Accident Level</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.alisa2.model.safe2.impl.AccidentLevelImpl
	 * @see org.osate.alisa2.model.safe2.impl.Safe2PackageImpl#getAccidentLevel()
	 * @generated
	 */
	int ACCIDENT_LEVEL = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCIDENT_LEVEL__NAME = FUNDAMENTAL__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCIDENT_LEVEL__DESCRIPTION = FUNDAMENTAL__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Accident</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCIDENT_LEVEL__ACCIDENT = FUNDAMENTAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Accident Level</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCIDENT_LEVEL_FEATURE_COUNT = FUNDAMENTAL_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Accident Level</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCIDENT_LEVEL_OPERATION_COUNT = FUNDAMENTAL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.alisa2.model.safe2.impl.ConstraintImpl <em>Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.alisa2.model.safe2.impl.ConstraintImpl
	 * @see org.osate.alisa2.model.safe2.impl.Safe2PackageImpl#getConstraint()
	 * @generated
	 */
	int CONSTRAINT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__NAME = FUNDAMENTAL__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__DESCRIPTION = FUNDAMENTAL__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Error Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__ERROR_TYPE = FUNDAMENTAL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__ELEMENT = FUNDAMENTAL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Hazard</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__HAZARD = FUNDAMENTAL_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_FEATURE_COUNT = FUNDAMENTAL_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_OPERATION_COUNT = FUNDAMENTAL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.alisa2.model.safe2.impl.ControlActionImpl <em>Control Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.alisa2.model.safe2.impl.ControlActionImpl
	 * @see org.osate.alisa2.model.safe2.impl.Safe2PackageImpl#getControlAction()
	 * @generated
	 */
	int CONTROL_ACTION = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_ACTION__NAME = NODE__NAME;

	/**
	 * The number of structural features of the '<em>Control Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_ACTION_FEATURE_COUNT = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Control Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_ACTION_OPERATION_COUNT = NODE_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.osate.alisa2.model.safe2.Fundamental <em>Fundamental</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fundamental</em>'.
	 * @see org.osate.alisa2.model.safe2.Fundamental
	 * @generated
	 */
	EClass getFundamental();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.alisa2.model.safe2.Fundamental#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.osate.alisa2.model.safe2.Fundamental#getDescription()
	 * @see #getFundamental()
	 * @generated
	 */
	EAttribute getFundamental_Description();

	/**
	 * Returns the meta object for class '{@link org.osate.alisa2.model.safe2.Accident <em>Accident</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Accident</em>'.
	 * @see org.osate.alisa2.model.safe2.Accident
	 * @generated
	 */
	EClass getAccident();

	/**
	 * Returns the meta object for the reference '{@link org.osate.alisa2.model.safe2.Accident#getAccidentlevel <em>Accidentlevel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Accidentlevel</em>'.
	 * @see org.osate.alisa2.model.safe2.Accident#getAccidentlevel()
	 * @see #getAccident()
	 * @generated
	 */
	EReference getAccident_Accidentlevel();

	/**
	 * Returns the meta object for the reference list '{@link org.osate.alisa2.model.safe2.Accident#getHazard <em>Hazard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Hazard</em>'.
	 * @see org.osate.alisa2.model.safe2.Accident#getHazard()
	 * @see #getAccident()
	 * @generated
	 */
	EReference getAccident_Hazard();

	/**
	 * Returns the meta object for class '{@link org.osate.alisa2.model.safe2.Hazard <em>Hazard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hazard</em>'.
	 * @see org.osate.alisa2.model.safe2.Hazard
	 * @generated
	 */
	EClass getHazard();

	/**
	 * Returns the meta object for the reference '{@link org.osate.alisa2.model.safe2.Hazard#getAccident <em>Accident</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Accident</em>'.
	 * @see org.osate.alisa2.model.safe2.Hazard#getAccident()
	 * @see #getHazard()
	 * @generated
	 */
	EReference getHazard_Accident();

	/**
	 * Returns the meta object for the reference list '{@link org.osate.alisa2.model.safe2.Hazard#getConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Constraint</em>'.
	 * @see org.osate.alisa2.model.safe2.Hazard#getConstraint()
	 * @see #getHazard()
	 * @generated
	 */
	EReference getHazard_Constraint();

	/**
	 * Returns the meta object for class '{@link org.osate.alisa2.model.safe2.AccidentLevel <em>Accident Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Accident Level</em>'.
	 * @see org.osate.alisa2.model.safe2.AccidentLevel
	 * @generated
	 */
	EClass getAccidentLevel();

	/**
	 * Returns the meta object for the reference list '{@link org.osate.alisa2.model.safe2.AccidentLevel#getAccident <em>Accident</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Accident</em>'.
	 * @see org.osate.alisa2.model.safe2.AccidentLevel#getAccident()
	 * @see #getAccidentLevel()
	 * @generated
	 */
	EReference getAccidentLevel_Accident();

	/**
	 * Returns the meta object for class '{@link org.osate.alisa2.model.safe2.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint</em>'.
	 * @see org.osate.alisa2.model.safe2.Constraint
	 * @generated
	 */
	EClass getConstraint();

	/**
	 * Returns the meta object for the reference '{@link org.osate.alisa2.model.safe2.Constraint#getErrorType <em>Error Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Error Type</em>'.
	 * @see org.osate.alisa2.model.safe2.Constraint#getErrorType()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_ErrorType();

	/**
	 * Returns the meta object for the reference '{@link org.osate.alisa2.model.safe2.Constraint#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element</em>'.
	 * @see org.osate.alisa2.model.safe2.Constraint#getElement()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_Element();

	/**
	 * Returns the meta object for the reference '{@link org.osate.alisa2.model.safe2.Constraint#getHazard <em>Hazard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Hazard</em>'.
	 * @see org.osate.alisa2.model.safe2.Constraint#getHazard()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_Hazard();

	/**
	 * Returns the meta object for class '{@link org.osate.alisa2.model.safe2.ControlAction <em>Control Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Control Action</em>'.
	 * @see org.osate.alisa2.model.safe2.ControlAction
	 * @generated
	 */
	EClass getControlAction();

	/**
	 * Returns the meta object for class '{@link org.osate.alisa2.model.safe2.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see org.osate.alisa2.model.safe2.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.alisa2.model.safe2.Node#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.osate.alisa2.model.safe2.Node#getName()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Name();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Safe2Factory getSafe2Factory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.osate.alisa2.model.safe2.Fundamental <em>Fundamental</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.alisa2.model.safe2.Fundamental
		 * @see org.osate.alisa2.model.safe2.impl.Safe2PackageImpl#getFundamental()
		 * @generated
		 */
		EClass FUNDAMENTAL = eINSTANCE.getFundamental();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNDAMENTAL__DESCRIPTION = eINSTANCE.getFundamental_Description();

		/**
		 * The meta object literal for the '{@link org.osate.alisa2.model.safe2.impl.AccidentImpl <em>Accident</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.alisa2.model.safe2.impl.AccidentImpl
		 * @see org.osate.alisa2.model.safe2.impl.Safe2PackageImpl#getAccident()
		 * @generated
		 */
		EClass ACCIDENT = eINSTANCE.getAccident();

		/**
		 * The meta object literal for the '<em><b>Accidentlevel</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACCIDENT__ACCIDENTLEVEL = eINSTANCE.getAccident_Accidentlevel();

		/**
		 * The meta object literal for the '<em><b>Hazard</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACCIDENT__HAZARD = eINSTANCE.getAccident_Hazard();

		/**
		 * The meta object literal for the '{@link org.osate.alisa2.model.safe2.impl.HazardImpl <em>Hazard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.alisa2.model.safe2.impl.HazardImpl
		 * @see org.osate.alisa2.model.safe2.impl.Safe2PackageImpl#getHazard()
		 * @generated
		 */
		EClass HAZARD = eINSTANCE.getHazard();

		/**
		 * The meta object literal for the '<em><b>Accident</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HAZARD__ACCIDENT = eINSTANCE.getHazard_Accident();

		/**
		 * The meta object literal for the '<em><b>Constraint</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HAZARD__CONSTRAINT = eINSTANCE.getHazard_Constraint();

		/**
		 * The meta object literal for the '{@link org.osate.alisa2.model.safe2.impl.AccidentLevelImpl <em>Accident Level</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.alisa2.model.safe2.impl.AccidentLevelImpl
		 * @see org.osate.alisa2.model.safe2.impl.Safe2PackageImpl#getAccidentLevel()
		 * @generated
		 */
		EClass ACCIDENT_LEVEL = eINSTANCE.getAccidentLevel();

		/**
		 * The meta object literal for the '<em><b>Accident</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACCIDENT_LEVEL__ACCIDENT = eINSTANCE.getAccidentLevel_Accident();

		/**
		 * The meta object literal for the '{@link org.osate.alisa2.model.safe2.impl.ConstraintImpl <em>Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.alisa2.model.safe2.impl.ConstraintImpl
		 * @see org.osate.alisa2.model.safe2.impl.Safe2PackageImpl#getConstraint()
		 * @generated
		 */
		EClass CONSTRAINT = eINSTANCE.getConstraint();

		/**
		 * The meta object literal for the '<em><b>Error Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__ERROR_TYPE = eINSTANCE.getConstraint_ErrorType();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__ELEMENT = eINSTANCE.getConstraint_Element();

		/**
		 * The meta object literal for the '<em><b>Hazard</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__HAZARD = eINSTANCE.getConstraint_Hazard();

		/**
		 * The meta object literal for the '{@link org.osate.alisa2.model.safe2.impl.ControlActionImpl <em>Control Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.alisa2.model.safe2.impl.ControlActionImpl
		 * @see org.osate.alisa2.model.safe2.impl.Safe2PackageImpl#getControlAction()
		 * @generated
		 */
		EClass CONTROL_ACTION = eINSTANCE.getControlAction();

		/**
		 * The meta object literal for the '{@link org.osate.alisa2.model.safe2.Node <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.alisa2.model.safe2.Node
		 * @see org.osate.alisa2.model.safe2.impl.Safe2PackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__NAME = eINSTANCE.getNode_Name();

	}

} //Safe2Package
