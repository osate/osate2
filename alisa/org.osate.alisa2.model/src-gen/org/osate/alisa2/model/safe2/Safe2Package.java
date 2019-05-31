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
	 * The feature id for the '<em><b>Explanations</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNDAMENTAL__EXPLANATIONS = NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Fundamental</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNDAMENTAL_FEATURE_COUNT = NODE_FEATURE_COUNT + 2;

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
	 * The feature id for the '<em><b>Explanations</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCIDENT__EXPLANATIONS = FUNDAMENTAL__EXPLANATIONS;

	/**
	 * The feature id for the '<em><b>Accidentlevel</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCIDENT__ACCIDENTLEVEL = FUNDAMENTAL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Hazard</b></em>' containment reference list.
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
	 * The feature id for the '<em><b>Explanations</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAZARD__EXPLANATIONS = FUNDAMENTAL__EXPLANATIONS;

	/**
	 * The feature id for the '<em><b>Accident</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAZARD__ACCIDENT = FUNDAMENTAL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAZARD__CONSTRAINT = FUNDAMENTAL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Environment Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAZARD__ENVIRONMENT_ELEMENT = FUNDAMENTAL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>System Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAZARD__SYSTEM_ELEMENT = FUNDAMENTAL_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Hazardous Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAZARD__HAZARDOUS_FACTOR = FUNDAMENTAL_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Error Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAZARD__ERROR_TYPE = FUNDAMENTAL_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Hazard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAZARD_FEATURE_COUNT = FUNDAMENTAL_FEATURE_COUNT + 6;

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
	 * The feature id for the '<em><b>Explanations</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCIDENT_LEVEL__EXPLANATIONS = FUNDAMENTAL__EXPLANATIONS;

	/**
	 * The feature id for the '<em><b>Accident</b></em>' containment reference list.
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
	 * The feature id for the '<em><b>Explanations</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__EXPLANATIONS = FUNDAMENTAL__EXPLANATIONS;

	/**
	 * The feature id for the '<em><b>Hazard</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__HAZARD = FUNDAMENTAL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__PORT = FUNDAMENTAL_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_FEATURE_COUNT = FUNDAMENTAL_FEATURE_COUNT + 2;

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
	 * The meta object id for the '{@link org.osate.alisa2.model.safe2.impl.SystemOverviewImpl <em>System Overview</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.alisa2.model.safe2.impl.SystemOverviewImpl
	 * @see org.osate.alisa2.model.safe2.impl.Safe2PackageImpl#getSystemOverview()
	 * @generated
	 */
	int SYSTEM_OVERVIEW = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_OVERVIEW__NAME = NODE__NAME;

	/**
	 * The feature id for the '<em><b>Fundamentals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_OVERVIEW__FUNDAMENTALS = NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Top Level Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_OVERVIEW__TOP_LEVEL_ELEMENT = NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>System Overview</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_OVERVIEW_FEATURE_COUNT = NODE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>System Overview</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_OVERVIEW_OPERATION_COUNT = NODE_OPERATION_COUNT + 0;

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
	 * Returns the meta object for the attribute list '{@link org.osate.alisa2.model.safe2.Fundamental#getExplanations <em>Explanations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Explanations</em>'.
	 * @see org.osate.alisa2.model.safe2.Fundamental#getExplanations()
	 * @see #getFundamental()
	 * @generated
	 */
	EAttribute getFundamental_Explanations();

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
	 * Returns the meta object for the container reference '{@link org.osate.alisa2.model.safe2.Accident#getAccidentlevel <em>Accidentlevel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Accidentlevel</em>'.
	 * @see org.osate.alisa2.model.safe2.Accident#getAccidentlevel()
	 * @see #getAccident()
	 * @generated
	 */
	EReference getAccident_Accidentlevel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.alisa2.model.safe2.Accident#getHazard <em>Hazard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Hazard</em>'.
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
	 * Returns the meta object for the container reference '{@link org.osate.alisa2.model.safe2.Hazard#getAccident <em>Accident</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Accident</em>'.
	 * @see org.osate.alisa2.model.safe2.Hazard#getAccident()
	 * @see #getHazard()
	 * @generated
	 */
	EReference getHazard_Accident();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.alisa2.model.safe2.Hazard#getConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraint</em>'.
	 * @see org.osate.alisa2.model.safe2.Hazard#getConstraint()
	 * @see #getHazard()
	 * @generated
	 */
	EReference getHazard_Constraint();

	/**
	 * Returns the meta object for the reference '{@link org.osate.alisa2.model.safe2.Hazard#getEnvironmentElement <em>Environment Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Environment Element</em>'.
	 * @see org.osate.alisa2.model.safe2.Hazard#getEnvironmentElement()
	 * @see #getHazard()
	 * @generated
	 */
	EReference getHazard_EnvironmentElement();

	/**
	 * Returns the meta object for the reference '{@link org.osate.alisa2.model.safe2.Hazard#getSystemElement <em>System Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>System Element</em>'.
	 * @see org.osate.alisa2.model.safe2.Hazard#getSystemElement()
	 * @see #getHazard()
	 * @generated
	 */
	EReference getHazard_SystemElement();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.alisa2.model.safe2.Hazard#getHazardousFactor <em>Hazardous Factor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hazardous Factor</em>'.
	 * @see org.osate.alisa2.model.safe2.Hazard#getHazardousFactor()
	 * @see #getHazard()
	 * @generated
	 */
	EAttribute getHazard_HazardousFactor();

	/**
	 * Returns the meta object for the reference '{@link org.osate.alisa2.model.safe2.Hazard#getErrorType <em>Error Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Error Type</em>'.
	 * @see org.osate.alisa2.model.safe2.Hazard#getErrorType()
	 * @see #getHazard()
	 * @generated
	 */
	EReference getHazard_ErrorType();

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
	 * Returns the meta object for the containment reference list '{@link org.osate.alisa2.model.safe2.AccidentLevel#getAccident <em>Accident</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Accident</em>'.
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
	 * Returns the meta object for the container reference '{@link org.osate.alisa2.model.safe2.Constraint#getHazard <em>Hazard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Hazard</em>'.
	 * @see org.osate.alisa2.model.safe2.Constraint#getHazard()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_Hazard();

	/**
	 * Returns the meta object for the reference '{@link org.osate.alisa2.model.safe2.Constraint#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Port</em>'.
	 * @see org.osate.alisa2.model.safe2.Constraint#getPort()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_Port();

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
	 * Returns the meta object for class '{@link org.osate.alisa2.model.safe2.SystemOverview <em>System Overview</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System Overview</em>'.
	 * @see org.osate.alisa2.model.safe2.SystemOverview
	 * @generated
	 */
	EClass getSystemOverview();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.alisa2.model.safe2.SystemOverview#getFundamentals <em>Fundamentals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fundamentals</em>'.
	 * @see org.osate.alisa2.model.safe2.SystemOverview#getFundamentals()
	 * @see #getSystemOverview()
	 * @generated
	 */
	EReference getSystemOverview_Fundamentals();

	/**
	 * Returns the meta object for the reference '{@link org.osate.alisa2.model.safe2.SystemOverview#getTopLevelElement <em>Top Level Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Top Level Element</em>'.
	 * @see org.osate.alisa2.model.safe2.SystemOverview#getTopLevelElement()
	 * @see #getSystemOverview()
	 * @generated
	 */
	EReference getSystemOverview_TopLevelElement();

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
		 * The meta object literal for the '<em><b>Explanations</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNDAMENTAL__EXPLANATIONS = eINSTANCE.getFundamental_Explanations();

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
		 * The meta object literal for the '<em><b>Accidentlevel</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACCIDENT__ACCIDENTLEVEL = eINSTANCE.getAccident_Accidentlevel();

		/**
		 * The meta object literal for the '<em><b>Hazard</b></em>' containment reference list feature.
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
		 * The meta object literal for the '<em><b>Accident</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HAZARD__ACCIDENT = eINSTANCE.getHazard_Accident();

		/**
		 * The meta object literal for the '<em><b>Constraint</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HAZARD__CONSTRAINT = eINSTANCE.getHazard_Constraint();

		/**
		 * The meta object literal for the '<em><b>Environment Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HAZARD__ENVIRONMENT_ELEMENT = eINSTANCE.getHazard_EnvironmentElement();

		/**
		 * The meta object literal for the '<em><b>System Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HAZARD__SYSTEM_ELEMENT = eINSTANCE.getHazard_SystemElement();

		/**
		 * The meta object literal for the '<em><b>Hazardous Factor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HAZARD__HAZARDOUS_FACTOR = eINSTANCE.getHazard_HazardousFactor();

		/**
		 * The meta object literal for the '<em><b>Error Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HAZARD__ERROR_TYPE = eINSTANCE.getHazard_ErrorType();

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
		 * The meta object literal for the '<em><b>Accident</b></em>' containment reference list feature.
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
		 * The meta object literal for the '<em><b>Hazard</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__HAZARD = eINSTANCE.getConstraint_Hazard();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__PORT = eINSTANCE.getConstraint_Port();

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

		/**
		 * The meta object literal for the '{@link org.osate.alisa2.model.safe2.impl.SystemOverviewImpl <em>System Overview</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.alisa2.model.safe2.impl.SystemOverviewImpl
		 * @see org.osate.alisa2.model.safe2.impl.Safe2PackageImpl#getSystemOverview()
		 * @generated
		 */
		EClass SYSTEM_OVERVIEW = eINSTANCE.getSystemOverview();

		/**
		 * The meta object literal for the '<em><b>Fundamentals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_OVERVIEW__FUNDAMENTALS = eINSTANCE.getSystemOverview_Fundamentals();

		/**
		 * The meta object literal for the '<em><b>Top Level Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_OVERVIEW__TOP_LEVEL_ELEMENT = eINSTANCE.getSystemOverview_TopLevelElement();

	}

} //Safe2Package
