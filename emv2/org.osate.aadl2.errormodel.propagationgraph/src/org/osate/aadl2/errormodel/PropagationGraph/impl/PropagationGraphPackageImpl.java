/**
 */
package org.osate.aadl2.errormodel.PropagationGraph.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.osate.aadl2.errormodel.PropagationGraph.PropagationGraph;
import org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphFactory;
import org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPackage;
import org.osate.aadl2.errormodel.PropagationGraph.PropagationNode;
import org.osate.aadl2.errormodel.PropagationGraph.PropagationPath;
import org.osate.aadl2.errormodel.PropagationGraph.PropagationPathEnd;
import org.osate.aadl2.errormodel.PropagationGraph.PropagationType;

import org.osate.aadl2.instance.InstancePackage;

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PropagationGraphPackageImpl extends EPackageImpl implements PropagationGraphPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propagationGraphEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propagationPathEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propagationNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propagationPathEndEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum propagationTypeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PropagationGraphPackageImpl() {
		super(eNS_URI, PropagationGraphFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link PropagationGraphPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PropagationGraphPackage init() {
		if (isInited) return (PropagationGraphPackage)EPackage.Registry.INSTANCE.getEPackage(PropagationGraphPackage.eNS_URI);

		// Obtain or create and register package
		PropagationGraphPackageImpl thePropagationGraphPackage = (PropagationGraphPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PropagationGraphPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PropagationGraphPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ErrorModelPackage.eINSTANCE.eClass();
		InstancePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		thePropagationGraphPackage.createPackageContents();

		// Initialize created meta-data
		thePropagationGraphPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePropagationGraphPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PropagationGraphPackage.eNS_URI, thePropagationGraphPackage);
		return thePropagationGraphPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropagationGraph() {
		return propagationGraphEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropagationGraph_Name() {
		return (EAttribute)propagationGraphEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropagationGraph_Description() {
		return (EAttribute)propagationGraphEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropagationGraph_Components() {
		return (EReference)propagationGraphEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropagationGraph_PropagationPaths() {
		return (EReference)propagationGraphEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropagationGraph_Nodes() {
		return (EReference)propagationGraphEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropagationPath() {
		return propagationPathEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropagationPath_Name() {
		return (EAttribute)propagationPathEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropagationPath_PathSrc() {
		return (EReference)propagationPathEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropagationPath_PathDst() {
		return (EReference)propagationPathEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropagationPath_Highlight() {
		return (EAttribute)propagationPathEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropagationPath_Type() {
		return (EAttribute)propagationPathEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropagationNode() {
		return propagationNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropagationNode_Name() {
		return (EAttribute)propagationNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropagationNode_Highlight() {
		return (EAttribute)propagationNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropagationNode_ComponentInstance() {
		return (EReference)propagationNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropagationPathEnd() {
		return propagationPathEndEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropagationPathEnd_InstanceObject() {
		return (EReference)propagationPathEndEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropagationPathEnd_ErrorPropagation() {
		return (EReference)propagationPathEndEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropagationPathEnd_ComponentInstance() {
		return (EReference)propagationPathEndEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPropagationType() {
		return propagationTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropagationGraphFactory getPropagationGraphFactory() {
		return (PropagationGraphFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		propagationGraphEClass = createEClass(PROPAGATION_GRAPH);
		createEAttribute(propagationGraphEClass, PROPAGATION_GRAPH__NAME);
		createEAttribute(propagationGraphEClass, PROPAGATION_GRAPH__DESCRIPTION);
		createEReference(propagationGraphEClass, PROPAGATION_GRAPH__COMPONENTS);
		createEReference(propagationGraphEClass, PROPAGATION_GRAPH__PROPAGATION_PATHS);
		createEReference(propagationGraphEClass, PROPAGATION_GRAPH__NODES);

		propagationPathEClass = createEClass(PROPAGATION_PATH);
		createEAttribute(propagationPathEClass, PROPAGATION_PATH__NAME);
		createEReference(propagationPathEClass, PROPAGATION_PATH__PATH_SRC);
		createEReference(propagationPathEClass, PROPAGATION_PATH__PATH_DST);
		createEAttribute(propagationPathEClass, PROPAGATION_PATH__HIGHLIGHT);
		createEAttribute(propagationPathEClass, PROPAGATION_PATH__TYPE);

		propagationNodeEClass = createEClass(PROPAGATION_NODE);
		createEAttribute(propagationNodeEClass, PROPAGATION_NODE__NAME);
		createEAttribute(propagationNodeEClass, PROPAGATION_NODE__HIGHLIGHT);
		createEReference(propagationNodeEClass, PROPAGATION_NODE__COMPONENT_INSTANCE);

		propagationPathEndEClass = createEClass(PROPAGATION_PATH_END);
		createEReference(propagationPathEndEClass, PROPAGATION_PATH_END__INSTANCE_OBJECT);
		createEReference(propagationPathEndEClass, PROPAGATION_PATH_END__ERROR_PROPAGATION);
		createEReference(propagationPathEndEClass, PROPAGATION_PATH_END__COMPONENT_INSTANCE);

		// Create enums
		propagationTypeEEnum = createEEnum(PROPAGATION_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		InstancePackage theInstancePackage = (InstancePackage)EPackage.Registry.INSTANCE.getEPackage(InstancePackage.eNS_URI);
		ErrorModelPackage theErrorModelPackage = (ErrorModelPackage)EPackage.Registry.INSTANCE.getEPackage(ErrorModelPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(propagationGraphEClass, PropagationGraph.class, "PropagationGraph", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPropagationGraph_Name(), ecorePackage.getEString(), "name", null, 0, 1, PropagationGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropagationGraph_Description(), ecorePackage.getEString(), "description", null, 0, 1, PropagationGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropagationGraph_Components(), theInstancePackage.getComponentInstance(), null, "components", null, 0, -1, PropagationGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropagationGraph_PropagationPaths(), this.getPropagationPath(), null, "propagationPaths", null, 0, -1, PropagationGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropagationGraph_Nodes(), this.getPropagationNode(), null, "nodes", null, 0, -1, PropagationGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propagationPathEClass, PropagationPath.class, "PropagationPath", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPropagationPath_Name(), ecorePackage.getEString(), "name", null, 0, 1, PropagationPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropagationPath_PathSrc(), this.getPropagationPathEnd(), null, "pathSrc", null, 0, 1, PropagationPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropagationPath_PathDst(), this.getPropagationPathEnd(), null, "pathDst", null, 0, 1, PropagationPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropagationPath_Highlight(), ecorePackage.getEBoolean(), "highlight", null, 0, 1, PropagationPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropagationPath_Type(), this.getPropagationType(), "type", null, 0, 1, PropagationPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propagationNodeEClass, PropagationNode.class, "PropagationNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPropagationNode_Name(), ecorePackage.getEString(), "name", null, 0, 1, PropagationNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropagationNode_Highlight(), ecorePackage.getEBoolean(), "highlight", null, 0, 1, PropagationNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropagationNode_ComponentInstance(), theInstancePackage.getComponentInstance(), null, "componentInstance", null, 0, 1, PropagationNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propagationPathEndEClass, PropagationPathEnd.class, "PropagationPathEnd", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropagationPathEnd_InstanceObject(), theInstancePackage.getInstanceObject(), null, "instanceObject", null, 0, 1, PropagationPathEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropagationPathEnd_ErrorPropagation(), theErrorModelPackage.getErrorPropagation(), null, "errorPropagation", null, 0, 1, PropagationPathEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropagationPathEnd_ComponentInstance(), theInstancePackage.getComponentInstance(), null, "componentInstance", null, 0, 1, PropagationPathEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(propagationTypeEEnum, PropagationType.class, "PropagationType");
		addEEnumLiteral(propagationTypeEEnum, PropagationType.CONNECTION);
		addEEnumLiteral(propagationTypeEEnum, PropagationType.BINDING);
		addEEnumLiteral(propagationTypeEEnum, PropagationType.USER_DEFINED);

		// Create resource
		createResource(eNS_URI);
	}

} //PropagationGraphPackageImpl
