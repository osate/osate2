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
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE ''DELIVERABLES'') ARE ON AN ''AS-IS'' BASIS.
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
 * $Id: InstancePackageImpl.java,v 1.13 2010-06-14 17:29:03 lwrage Exp $
 */
package org.osate.aadl2.instance.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.ConnectionKind;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.FlowElementInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.instance.InstanceFactory;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.InstancePackage;
import org.osate.aadl2.instance.InstanceReferenceValue;
import org.osate.aadl2.instance.ModeInstance;
import org.osate.aadl2.instance.ModeTransitionInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class InstancePackageImpl extends EPackageImpl implements
		InstancePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instanceObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectionInstanceEndEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectionInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flowElementInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass systemOperationModeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modeInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modeTransitionInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectionReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flowSpecificationInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass endToEndFlowInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass systemInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instanceReferenceValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum connectionKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum featureCategoryEEnum = null;

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
	 * @see org.osate.aadl2.instance.InstancePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private InstancePackageImpl() {
		super(eNS_URI, InstanceFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link InstancePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static InstancePackage init() {
		if (isInited)
			return (InstancePackage) EPackage.Registry.INSTANCE
					.getEPackage(InstancePackage.eNS_URI);

		// Obtain or create and register package
		InstancePackageImpl theInstancePackage = (InstancePackageImpl) (EPackage.Registry.INSTANCE
				.get(eNS_URI) instanceof InstancePackageImpl ? EPackage.Registry.INSTANCE
				.get(eNS_URI) : new InstancePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		Aadl2Package.eINSTANCE.eClass();

		// Create package meta-data objects
		theInstancePackage.createPackageContents();

		// Initialize created meta-data
		theInstancePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theInstancePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(InstancePackage.eNS_URI,
				theInstancePackage);
		return theInstancePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureInstance() {
		return featureInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureInstance_Feature() {
		return (EReference) featureInstanceEClass.getEStructuralFeatures().get(
				5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureInstance_Index() {
		return (EAttribute) featureInstanceEClass.getEStructuralFeatures().get(
				6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureInstance_SrcFlowSpec() {
		return (EReference) featureInstanceEClass.getEStructuralFeatures().get(
				0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureInstance_DstFlowSpec() {
		return (EReference) featureInstanceEClass.getEStructuralFeatures().get(
				1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureInstance_FeatureInstance() {
		return (EReference) featureInstanceEClass.getEStructuralFeatures().get(
				2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureInstance_Category() {
		return (EAttribute) featureInstanceEClass.getEStructuralFeatures().get(
				3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureInstance_Direction() {
		return (EAttribute) featureInstanceEClass.getEStructuralFeatures().get(
				4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstanceObject() {
		return instanceObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnectionInstanceEnd() {
		return connectionInstanceEndEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectionInstanceEnd_SrcConnectionInstance() {
		return (EReference) connectionInstanceEndEClass
				.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectionInstanceEnd_DstConnectionInstance() {
		return (EReference) connectionInstanceEndEClass
				.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnectionInstance() {
		return connectionInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectionInstance_InSystemOperationMode() {
		return (EReference) connectionInstanceEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectionInstance_InModeTransition() {
		return (EReference) connectionInstanceEClass.getEStructuralFeatures()
				.get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionInstance_Complete() {
		return (EAttribute) connectionInstanceEClass.getEStructuralFeatures()
				.get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionInstance_Kind() {
		return (EAttribute) connectionInstanceEClass.getEStructuralFeatures()
				.get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectionInstance_Destination() {
		return (EReference) connectionInstanceEClass.getEStructuralFeatures()
				.get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectionInstance_ConnectionReference() {
		return (EReference) connectionInstanceEClass.getEStructuralFeatures()
				.get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionInstance_Bidirectional() {
		return (EAttribute) connectionInstanceEClass.getEStructuralFeatures()
				.get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectionInstance_Source() {
		return (EReference) connectionInstanceEClass.getEStructuralFeatures()
				.get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFlowElementInstance() {
		return flowElementInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSystemOperationMode() {
		return systemOperationModeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemOperationMode_CurrentMode() {
		return (EReference) systemOperationModeEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModeInstance() {
		return modeInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModeInstance_SrcModeTransition() {
		return (EReference) modeInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModeInstance_DstModeTransition() {
		return (EReference) modeInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModeInstance_Mode() {
		return (EReference) modeInstanceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModeInstance_Derived() {
		return (EAttribute) modeInstanceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModeInstance_Parent() {
		return (EReference) modeInstanceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModeInstance_Initial() {
		return (EAttribute) modeInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModeTransitionInstance() {
		return modeTransitionInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModeTransitionInstance_Destination() {
		return (EReference) modeTransitionInstanceEClass
				.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModeTransitionInstance_ModeTransition() {
		return (EReference) modeTransitionInstanceEClass
				.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModeTransitionInstance_Source() {
		return (EReference) modeTransitionInstanceEClass
				.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnectionReference() {
		return connectionReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectionReference_Context() {
		return (EReference) connectionReferenceEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectionReference_Connection() {
		return (EReference) connectionReferenceEClass.getEStructuralFeatures()
				.get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectionReference_Source() {
		return (EReference) connectionReferenceEClass.getEStructuralFeatures()
				.get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectionReference_Destination() {
		return (EReference) connectionReferenceEClass.getEStructuralFeatures()
				.get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentInstance() {
		return componentInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentInstance_FeatureInstance() {
		return (EReference) componentInstanceEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentInstance_ComponentInstance() {
		return (EReference) componentInstanceEClass.getEStructuralFeatures()
				.get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentInstance_Subcomponent() {
		return (EReference) componentInstanceEClass.getEStructuralFeatures()
				.get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentInstance_Index() {
		return (EAttribute) componentInstanceEClass.getEStructuralFeatures()
				.get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFlowSpecificationInstance() {
		return flowSpecificationInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlowSpecificationInstance_Source() {
		return (EReference) flowSpecificationInstanceEClass
				.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlowSpecificationInstance_Destination() {
		return (EReference) flowSpecificationInstanceEClass
				.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlowSpecificationInstance_FlowSpecification() {
		return (EReference) flowSpecificationInstanceEClass
				.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlowSpecificationInstance_InMode() {
		return (EReference) flowSpecificationInstanceEClass
				.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlowSpecificationInstance_InModeTransition() {
		return (EReference) flowSpecificationInstanceEClass
				.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentInstance_ModeInstance() {
		return (EReference) componentInstanceEClass.getEStructuralFeatures()
				.get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentInstance_ModeTransitionInstance() {
		return (EReference) componentInstanceEClass.getEStructuralFeatures()
				.get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentInstance_Category() {
		return (EAttribute) componentInstanceEClass.getEStructuralFeatures()
				.get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentInstance_InMode() {
		return (EReference) componentInstanceEClass.getEStructuralFeatures()
				.get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentInstance_FlowSpecification() {
		return (EReference) componentInstanceEClass.getEStructuralFeatures()
				.get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentInstance_EndToEndFlow() {
		return (EReference) componentInstanceEClass.getEStructuralFeatures()
				.get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentInstance_ConnectionInstance() {
		return (EReference) componentInstanceEClass.getEStructuralFeatures()
				.get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEndToEndFlowInstance() {
		return endToEndFlowInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEndToEndFlowInstance_FlowElement() {
		return (EReference) endToEndFlowInstanceEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEndToEndFlowInstance_InMode() {
		return (EReference) endToEndFlowInstanceEClass.getEStructuralFeatures()
				.get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEndToEndFlowInstance_EndToEndFlow() {
		return (EReference) endToEndFlowInstanceEClass.getEStructuralFeatures()
				.get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEndToEndFlowInstance_InSystemOperationMode() {
		return (EReference) endToEndFlowInstanceEClass.getEStructuralFeatures()
				.get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSystemInstance() {
		return systemInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemInstance_SystemOperationMode() {
		return (EReference) systemInstanceEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemInstance_SystemImplementation() {
		return (EReference) systemInstanceEClass.getEStructuralFeatures()
				.get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstanceReferenceValue() {
		return instanceReferenceValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstanceReferenceValue_ReferencedInstanceObject() {
		return (EReference) instanceReferenceValueEClass
				.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getConnectionKind() {
		return connectionKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFeatureCategory() {
		return featureCategoryEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceFactory getInstanceFactory() {
		return (InstanceFactory) getEFactoryInstance();
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
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		featureInstanceEClass = createEClass(FEATURE_INSTANCE);
		createEReference(featureInstanceEClass, FEATURE_INSTANCE__SRC_FLOW_SPEC);
		createEReference(featureInstanceEClass, FEATURE_INSTANCE__DST_FLOW_SPEC);
		createEReference(featureInstanceEClass,
				FEATURE_INSTANCE__FEATURE_INSTANCE);
		createEAttribute(featureInstanceEClass, FEATURE_INSTANCE__CATEGORY);
		createEAttribute(featureInstanceEClass, FEATURE_INSTANCE__DIRECTION);
		createEReference(featureInstanceEClass, FEATURE_INSTANCE__FEATURE);
		createEAttribute(featureInstanceEClass, FEATURE_INSTANCE__INDEX);

		instanceObjectEClass = createEClass(INSTANCE_OBJECT);

		connectionInstanceEndEClass = createEClass(CONNECTION_INSTANCE_END);
		createEReference(connectionInstanceEndEClass,
				CONNECTION_INSTANCE_END__SRC_CONNECTION_INSTANCE);
		createEReference(connectionInstanceEndEClass,
				CONNECTION_INSTANCE_END__DST_CONNECTION_INSTANCE);

		connectionInstanceEClass = createEClass(CONNECTION_INSTANCE);
		createEReference(connectionInstanceEClass,
				CONNECTION_INSTANCE__IN_SYSTEM_OPERATION_MODE);
		createEReference(connectionInstanceEClass,
				CONNECTION_INSTANCE__IN_MODE_TRANSITION);
		createEAttribute(connectionInstanceEClass,
				CONNECTION_INSTANCE__COMPLETE);
		createEAttribute(connectionInstanceEClass, CONNECTION_INSTANCE__KIND);
		createEReference(connectionInstanceEClass,
				CONNECTION_INSTANCE__DESTINATION);
		createEReference(connectionInstanceEClass,
				CONNECTION_INSTANCE__CONNECTION_REFERENCE);
		createEAttribute(connectionInstanceEClass,
				CONNECTION_INSTANCE__BIDIRECTIONAL);
		createEReference(connectionInstanceEClass, CONNECTION_INSTANCE__SOURCE);

		flowElementInstanceEClass = createEClass(FLOW_ELEMENT_INSTANCE);

		systemOperationModeEClass = createEClass(SYSTEM_OPERATION_MODE);
		createEReference(systemOperationModeEClass,
				SYSTEM_OPERATION_MODE__CURRENT_MODE);

		modeInstanceEClass = createEClass(MODE_INSTANCE);
		createEReference(modeInstanceEClass, MODE_INSTANCE__SRC_MODE_TRANSITION);
		createEReference(modeInstanceEClass, MODE_INSTANCE__DST_MODE_TRANSITION);
		createEAttribute(modeInstanceEClass, MODE_INSTANCE__INITIAL);
		createEReference(modeInstanceEClass, MODE_INSTANCE__MODE);
		createEAttribute(modeInstanceEClass, MODE_INSTANCE__DERIVED);
		createEReference(modeInstanceEClass, MODE_INSTANCE__PARENT);

		modeTransitionInstanceEClass = createEClass(MODE_TRANSITION_INSTANCE);
		createEReference(modeTransitionInstanceEClass,
				MODE_TRANSITION_INSTANCE__DESTINATION);
		createEReference(modeTransitionInstanceEClass,
				MODE_TRANSITION_INSTANCE__MODE_TRANSITION);
		createEReference(modeTransitionInstanceEClass,
				MODE_TRANSITION_INSTANCE__SOURCE);

		connectionReferenceEClass = createEClass(CONNECTION_REFERENCE);
		createEReference(connectionReferenceEClass,
				CONNECTION_REFERENCE__CONTEXT);
		createEReference(connectionReferenceEClass,
				CONNECTION_REFERENCE__CONNECTION);
		createEReference(connectionReferenceEClass,
				CONNECTION_REFERENCE__SOURCE);
		createEReference(connectionReferenceEClass,
				CONNECTION_REFERENCE__DESTINATION);

		componentInstanceEClass = createEClass(COMPONENT_INSTANCE);
		createEReference(componentInstanceEClass,
				COMPONENT_INSTANCE__FEATURE_INSTANCE);
		createEReference(componentInstanceEClass,
				COMPONENT_INSTANCE__COMPONENT_INSTANCE);
		createEReference(componentInstanceEClass,
				COMPONENT_INSTANCE__MODE_INSTANCE);
		createEReference(componentInstanceEClass,
				COMPONENT_INSTANCE__MODE_TRANSITION_INSTANCE);
		createEAttribute(componentInstanceEClass, COMPONENT_INSTANCE__CATEGORY);
		createEReference(componentInstanceEClass, COMPONENT_INSTANCE__IN_MODE);
		createEReference(componentInstanceEClass,
				COMPONENT_INSTANCE__FLOW_SPECIFICATION);
		createEReference(componentInstanceEClass,
				COMPONENT_INSTANCE__END_TO_END_FLOW);
		createEReference(componentInstanceEClass,
				COMPONENT_INSTANCE__CONNECTION_INSTANCE);
		createEReference(componentInstanceEClass,
				COMPONENT_INSTANCE__SUBCOMPONENT);
		createEAttribute(componentInstanceEClass, COMPONENT_INSTANCE__INDEX);

		flowSpecificationInstanceEClass = createEClass(FLOW_SPECIFICATION_INSTANCE);
		createEReference(flowSpecificationInstanceEClass,
				FLOW_SPECIFICATION_INSTANCE__SOURCE);
		createEReference(flowSpecificationInstanceEClass,
				FLOW_SPECIFICATION_INSTANCE__DESTINATION);
		createEReference(flowSpecificationInstanceEClass,
				FLOW_SPECIFICATION_INSTANCE__FLOW_SPECIFICATION);
		createEReference(flowSpecificationInstanceEClass,
				FLOW_SPECIFICATION_INSTANCE__IN_MODE);
		createEReference(flowSpecificationInstanceEClass,
				FLOW_SPECIFICATION_INSTANCE__IN_MODE_TRANSITION);

		endToEndFlowInstanceEClass = createEClass(END_TO_END_FLOW_INSTANCE);
		createEReference(endToEndFlowInstanceEClass,
				END_TO_END_FLOW_INSTANCE__FLOW_ELEMENT);
		createEReference(endToEndFlowInstanceEClass,
				END_TO_END_FLOW_INSTANCE__IN_MODE);
		createEReference(endToEndFlowInstanceEClass,
				END_TO_END_FLOW_INSTANCE__IN_SYSTEM_OPERATION_MODE);
		createEReference(endToEndFlowInstanceEClass,
				END_TO_END_FLOW_INSTANCE__END_TO_END_FLOW);

		systemInstanceEClass = createEClass(SYSTEM_INSTANCE);
		createEReference(systemInstanceEClass,
				SYSTEM_INSTANCE__SYSTEM_OPERATION_MODE);
		createEReference(systemInstanceEClass,
				SYSTEM_INSTANCE__SYSTEM_IMPLEMENTATION);

		instanceReferenceValueEClass = createEClass(INSTANCE_REFERENCE_VALUE);
		createEReference(instanceReferenceValueEClass,
				INSTANCE_REFERENCE_VALUE__REFERENCED_INSTANCE_OBJECT);

		// Create enums
		connectionKindEEnum = createEEnum(CONNECTION_KIND);
		featureCategoryEEnum = createEEnum(FEATURE_CATEGORY);
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
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		Aadl2Package theAadl2Package = (Aadl2Package) EPackage.Registry.INSTANCE
				.getEPackage(Aadl2Package.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		featureInstanceEClass.getESuperTypes().add(
				this.getConnectionInstanceEnd());
		featureInstanceEClass.getESuperTypes().add(this.getInstanceObject());
		instanceObjectEClass.getESuperTypes().add(
				theAadl2Package.getNamedElement());
		connectionInstanceEndEClass.getESuperTypes().add(
				this.getInstanceObject());
		connectionInstanceEClass.getESuperTypes().add(
				this.getFlowElementInstance());
		flowElementInstanceEClass.getESuperTypes()
				.add(this.getInstanceObject());
		systemOperationModeEClass.getESuperTypes().add(
				theAadl2Package.getMode());
		modeInstanceEClass.getESuperTypes().add(this.getInstanceObject());
		modeTransitionInstanceEClass.getESuperTypes().add(
				this.getConnectionInstanceEnd());
		modeTransitionInstanceEClass.getESuperTypes().add(
				this.getInstanceObject());
		connectionReferenceEClass.getESuperTypes()
				.add(this.getInstanceObject());
		componentInstanceEClass.getESuperTypes().add(
				this.getConnectionInstanceEnd());
		componentInstanceEClass.getESuperTypes().add(
				this.getFlowElementInstance());
		flowSpecificationInstanceEClass.getESuperTypes().add(
				this.getFlowElementInstance());
		endToEndFlowInstanceEClass.getESuperTypes().add(
				this.getFlowElementInstance());
		systemInstanceEClass.getESuperTypes().add(this.getComponentInstance());
		instanceReferenceValueEClass.getESuperTypes().add(
				theAadl2Package.getPropertyValue());

		// Initialize classes and features; add operations and parameters
		initEClass(
				featureInstanceEClass,
				FeatureInstance.class,
				"FeatureInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getFeatureInstance_SrcFlowSpec(),
				this.getFlowSpecificationInstance(),
				this.getFlowSpecificationInstance_Source(),
				"srcFlowSpec", null, 0, -1, FeatureInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getFeatureInstance_DstFlowSpec(),
				this.getFlowSpecificationInstance(),
				this.getFlowSpecificationInstance_Destination(),
				"dstFlowSpec", null, 0, -1, FeatureInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getFeatureInstance_FeatureInstance(),
				this.getFeatureInstance(),
				null,
				"featureInstance", null, 0, -1, FeatureInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getFeatureInstance_Category(),
				this.getFeatureCategory(),
				"category", null, 1, 1, FeatureInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getFeatureInstance_Direction(),
				theAadl2Package.getDirectionType(),
				"direction", null, 1, 1, FeatureInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getFeatureInstance_Feature(),
				theAadl2Package.getFeature(),
				null,
				"feature", null, 1, 1, FeatureInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getFeatureInstance_Index(),
				theAadl2Package.getInteger(),
				"index", null, 0, 1, FeatureInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		initEClass(
				instanceObjectEClass,
				InstanceObject.class,
				"InstanceObject", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
				connectionInstanceEndEClass,
				ConnectionInstanceEnd.class,
				"ConnectionInstanceEnd", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getConnectionInstanceEnd_SrcConnectionInstance(),
				this.getConnectionInstance(),
				this.getConnectionInstance_Source(),
				"srcConnectionInstance", null, 0, -1, ConnectionInstanceEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getConnectionInstanceEnd_DstConnectionInstance(),
				this.getConnectionInstance(),
				this.getConnectionInstance_Destination(),
				"dstConnectionInstance", null, 0, -1, ConnectionInstanceEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		initEClass(
				connectionInstanceEClass,
				ConnectionInstance.class,
				"ConnectionInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getConnectionInstance_InSystemOperationMode(),
				this.getSystemOperationMode(),
				null,
				"inSystemOperationMode", null, 0, -1, ConnectionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getConnectionInstance_InModeTransition(),
				this.getModeTransitionInstance(),
				null,
				"inModeTransition", null, 0, -1, ConnectionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getConnectionInstance_Complete(),
				theAadl2Package.getBoolean(),
				"complete", null, 1, 1, ConnectionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getConnectionInstance_Kind(),
				this.getConnectionKind(),
				"kind", null, 1, 1, ConnectionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getConnectionInstance_Destination(),
				this.getConnectionInstanceEnd(),
				this.getConnectionInstanceEnd_DstConnectionInstance(),
				"destination", null, 1, 1, ConnectionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getConnectionInstance_ConnectionReference(),
				this.getConnectionReference(),
				null,
				"connectionReference", null, 1, -1, ConnectionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getConnectionInstance_Bidirectional(),
				theAadl2Package.getBoolean(),
				"bidirectional", null, 1, 1, ConnectionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getConnectionInstance_Source(),
				this.getConnectionInstanceEnd(),
				this.getConnectionInstanceEnd_SrcConnectionInstance(),
				"source", null, 1, 1, ConnectionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		initEClass(
				flowElementInstanceEClass,
				FlowElementInstance.class,
				"FlowElementInstance", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
				systemOperationModeEClass,
				SystemOperationMode.class,
				"SystemOperationMode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getSystemOperationMode_CurrentMode(),
				this.getModeInstance(),
				null,
				"currentMode", null, 0, -1, SystemOperationMode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				modeInstanceEClass,
				ModeInstance.class,
				"ModeInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getModeInstance_SrcModeTransition(),
				this.getModeTransitionInstance(),
				this.getModeTransitionInstance_Source(),
				"srcModeTransition", null, 0, -1, ModeInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getModeInstance_DstModeTransition(),
				this.getModeTransitionInstance(),
				this.getModeTransitionInstance_Destination(),
				"dstModeTransition", null, 0, -1, ModeInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getModeInstance_Initial(),
				theAadl2Package.getBoolean(),
				"initial", "false", 1, 1, ModeInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEReference(
				getModeInstance_Mode(),
				theAadl2Package.getMode(),
				null,
				"mode", null, 1, 1, ModeInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getModeInstance_Derived(),
				theAadl2Package.getBoolean(),
				"derived", "false", 1, 1, ModeInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEReference(
				getModeInstance_Parent(),
				this.getModeInstance(),
				null,
				"parent", null, 0, -1, ModeInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		initEClass(
				modeTransitionInstanceEClass,
				ModeTransitionInstance.class,
				"ModeTransitionInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getModeTransitionInstance_Destination(),
				this.getModeInstance(),
				this.getModeInstance_DstModeTransition(),
				"destination", null, 1, 1, ModeTransitionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getModeTransitionInstance_ModeTransition(),
				theAadl2Package.getModeTransition(),
				null,
				"modeTransition", null, 1, 1, ModeTransitionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getModeTransitionInstance_Source(),
				this.getModeInstance(),
				this.getModeInstance_SrcModeTransition(),
				"source", null, 1, 1, ModeTransitionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		initEClass(
				connectionReferenceEClass,
				ConnectionReference.class,
				"ConnectionReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getConnectionReference_Context(),
				this.getComponentInstance(),
				null,
				"context", null, 1, 1, ConnectionReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getConnectionReference_Connection(),
				theAadl2Package.getConnection(),
				null,
				"connection", null, 1, 1, ConnectionReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getConnectionReference_Source(),
				this.getConnectionInstanceEnd(),
				null,
				"source", null, 1, 1, ConnectionReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getConnectionReference_Destination(),
				this.getConnectionInstanceEnd(),
				null,
				"destination", null, 1, 1, ConnectionReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		initEClass(
				componentInstanceEClass,
				ComponentInstance.class,
				"ComponentInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getComponentInstance_FeatureInstance(),
				this.getFeatureInstance(),
				null,
				"featureInstance", null, 0, -1, ComponentInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getComponentInstance_ComponentInstance(),
				this.getComponentInstance(),
				null,
				"componentInstance", null, 0, -1, ComponentInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getComponentInstance_ModeInstance(),
				this.getModeInstance(),
				null,
				"modeInstance", null, 0, -1, ComponentInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getComponentInstance_ModeTransitionInstance(),
				this.getModeTransitionInstance(),
				null,
				"modeTransitionInstance", null, 0, -1, ComponentInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getComponentInstance_Category(),
				theAadl2Package.getComponentCategory(),
				"category", null, 1, 1, ComponentInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getComponentInstance_InMode(),
				this.getModeInstance(),
				null,
				"inMode", null, 0, -1, ComponentInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getComponentInstance_FlowSpecification(),
				this.getFlowSpecificationInstance(),
				null,
				"flowSpecification", null, 0, -1, ComponentInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getComponentInstance_EndToEndFlow(),
				this.getEndToEndFlowInstance(),
				null,
				"endToEndFlow", null, 0, -1, ComponentInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getComponentInstance_ConnectionInstance(),
				this.getConnectionInstance(),
				null,
				"connectionInstance", null, 0, -1, ComponentInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getComponentInstance_Subcomponent(),
				theAadl2Package.getSubcomponent(),
				null,
				"subcomponent", null, 0, 1, ComponentInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getComponentInstance_Index(),
				theAadl2Package.getInteger(),
				"index", null, 0, -1, ComponentInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		initEClass(
				flowSpecificationInstanceEClass,
				FlowSpecificationInstance.class,
				"FlowSpecificationInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getFlowSpecificationInstance_Source(),
				this.getFeatureInstance(),
				this.getFeatureInstance_SrcFlowSpec(),
				"source", null, 0, 1, FlowSpecificationInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getFlowSpecificationInstance_Destination(),
				this.getFeatureInstance(),
				this.getFeatureInstance_DstFlowSpec(),
				"destination", null, 0, 1, FlowSpecificationInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getFlowSpecificationInstance_FlowSpecification(),
				theAadl2Package.getFlowSpecification(),
				null,
				"flowSpecification", null, 1, 1, FlowSpecificationInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getFlowSpecificationInstance_InMode(),
				this.getModeInstance(),
				null,
				"inMode", null, 0, -1, FlowSpecificationInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getFlowSpecificationInstance_InModeTransition(),
				this.getModeTransitionInstance(),
				null,
				"inModeTransition", null, 0, -1, FlowSpecificationInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		initEClass(
				endToEndFlowInstanceEClass,
				EndToEndFlowInstance.class,
				"EndToEndFlowInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getEndToEndFlowInstance_FlowElement(),
				this.getFlowElementInstance(),
				null,
				"flowElement", null, 0, -1, EndToEndFlowInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getEndToEndFlowInstance_InMode(),
				this.getModeInstance(),
				null,
				"inMode", null, 0, -1, EndToEndFlowInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getEndToEndFlowInstance_InSystemOperationMode(),
				this.getSystemOperationMode(),
				null,
				"inSystemOperationMode", null, 0, -1, EndToEndFlowInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getEndToEndFlowInstance_EndToEndFlow(),
				theAadl2Package.getEndToEndFlow(),
				null,
				"endToEndFlow", null, 1, 1, EndToEndFlowInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		initEClass(
				systemInstanceEClass,
				SystemInstance.class,
				"SystemInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getSystemInstance_SystemOperationMode(),
				this.getSystemOperationMode(),
				null,
				"systemOperationMode", null, 0, -1, SystemInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getSystemInstance_SystemImplementation(),
				theAadl2Package.getSystemImplementation(),
				null,
				"systemImplementation", null, 1, 1, SystemInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		initEClass(
				instanceReferenceValueEClass,
				InstanceReferenceValue.class,
				"InstanceReferenceValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getInstanceReferenceValue_ReferencedInstanceObject(),
				this.getInstanceObject(),
				null,
				"referencedInstanceObject", null, 1, 1, InstanceReferenceValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		// Initialize enums and add enum literals
		initEEnum(connectionKindEEnum, ConnectionKind.class, "ConnectionKind"); //$NON-NLS-1$
		addEEnumLiteral(connectionKindEEnum, ConnectionKind.FEATURE_CONNECTION);
		addEEnumLiteral(connectionKindEEnum, ConnectionKind.ACCESS_CONNECTION);
		addEEnumLiteral(connectionKindEEnum,
				ConnectionKind.PARAMETER_CONNECTION);
		addEEnumLiteral(connectionKindEEnum, ConnectionKind.PORT_CONNECTION);
		addEEnumLiteral(connectionKindEEnum,
				ConnectionKind.MODE_TRANSITION_CONNECTION);
		addEEnumLiteral(connectionKindEEnum,
				ConnectionKind.FEATURE_GROUP_CONNECTION);

		initEEnum(featureCategoryEEnum, FeatureCategory.class,
				"FeatureCategory"); //$NON-NLS-1$
		addEEnumLiteral(featureCategoryEEnum, FeatureCategory.DATA_PORT);
		addEEnumLiteral(featureCategoryEEnum, FeatureCategory.EVENT_PORT);
		addEEnumLiteral(featureCategoryEEnum, FeatureCategory.EVENT_DATA_PORT);
		addEEnumLiteral(featureCategoryEEnum, FeatureCategory.PARAMETER);
		addEEnumLiteral(featureCategoryEEnum, FeatureCategory.BUS_ACCESS);
		addEEnumLiteral(featureCategoryEEnum, FeatureCategory.DATA_ACCESS);
		addEEnumLiteral(featureCategoryEEnum, FeatureCategory.SUBPROGRAM_ACCESS);
		addEEnumLiteral(featureCategoryEEnum,
				FeatureCategory.SUBPROGRAM_GROUP_ACCESS);
		addEEnumLiteral(featureCategoryEEnum, FeatureCategory.FEATURE_GROUP);
		addEEnumLiteral(featureCategoryEEnum, FeatureCategory.ABSTRACT_FEATURE);

		// Create resource
		createResource(eNS_URI);
	}

} //InstancePackageImpl
