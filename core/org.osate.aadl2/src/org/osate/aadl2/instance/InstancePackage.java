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
 * $Id: InstancePackage.java,v 1.16 2010-06-14 17:29:03 lwrage Exp $
 */
package org.osate.aadl2.instance;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.osate.aadl2.Aadl2Package;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.osate.aadl2.instance.InstanceFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='aadl2Instance'"
 * @generated
 */
public interface InstancePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "instance";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://aadl.info/AADL/2.0/instance";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "instance";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	InstancePackage eINSTANCE = org.osate.aadl2.instance.impl.InstancePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.osate.aadl2.instance.impl.InstanceObjectImpl <em>Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.instance.impl.InstanceObjectImpl
	 * @see org.osate.aadl2.instance.impl.InstancePackageImpl#getInstanceObject()
	 * @generated
	 */
	int INSTANCE_OBJECT = 1;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_OBJECT__OWNED_ELEMENT = Aadl2Package.NAMED_ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_OBJECT__OWNED_COMMENT = Aadl2Package.NAMED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_OBJECT__NAME = Aadl2Package.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_OBJECT__QUALIFIED_NAME = Aadl2Package.NAMED_ELEMENT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_OBJECT__OWNED_PROPERTY_ASSOCIATION = Aadl2Package.NAMED_ELEMENT__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_OBJECT__ANNEX_INSTANCE = Aadl2Package.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_OBJECT_FEATURE_COUNT = Aadl2Package.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.instance.impl.FeatureInstanceImpl <em>Feature Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.instance.impl.FeatureInstanceImpl
	 * @see org.osate.aadl2.instance.impl.InstancePackageImpl#getFeatureInstance()
	 * @generated
	 */
	int FEATURE_INSTANCE = 0;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.instance.impl.ConnectionInstanceEndImpl <em>Connection Instance End</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.instance.impl.ConnectionInstanceEndImpl
	 * @see org.osate.aadl2.instance.impl.InstancePackageImpl#getConnectionInstanceEnd()
	 * @generated
	 */
	int CONNECTION_INSTANCE_END = 4;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_INSTANCE_END__OWNED_ELEMENT = INSTANCE_OBJECT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_INSTANCE_END__OWNED_COMMENT = INSTANCE_OBJECT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_INSTANCE_END__NAME = INSTANCE_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_INSTANCE_END__QUALIFIED_NAME = INSTANCE_OBJECT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_INSTANCE_END__OWNED_PROPERTY_ASSOCIATION = INSTANCE_OBJECT__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_INSTANCE_END__ANNEX_INSTANCE = INSTANCE_OBJECT__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Src Connection Instance</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_INSTANCE_END__SRC_CONNECTION_INSTANCE = INSTANCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Dst Connection Instance</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_INSTANCE_END__DST_CONNECTION_INSTANCE = INSTANCE_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Connection Instance End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_INSTANCE_END_FEATURE_COUNT = INSTANCE_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_INSTANCE__OWNED_ELEMENT = CONNECTION_INSTANCE_END__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_INSTANCE__OWNED_COMMENT = CONNECTION_INSTANCE_END__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_INSTANCE__NAME = CONNECTION_INSTANCE_END__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_INSTANCE__QUALIFIED_NAME = CONNECTION_INSTANCE_END__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_INSTANCE__OWNED_PROPERTY_ASSOCIATION = CONNECTION_INSTANCE_END__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_INSTANCE__ANNEX_INSTANCE = CONNECTION_INSTANCE_END__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Src Connection Instance</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_INSTANCE__SRC_CONNECTION_INSTANCE = CONNECTION_INSTANCE_END__SRC_CONNECTION_INSTANCE;

	/**
	 * The feature id for the '<em><b>Dst Connection Instance</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_INSTANCE__DST_CONNECTION_INSTANCE = CONNECTION_INSTANCE_END__DST_CONNECTION_INSTANCE;

	/**
	 * The feature id for the '<em><b>Src Flow Spec</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_INSTANCE__SRC_FLOW_SPEC = CONNECTION_INSTANCE_END_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Dst Flow Spec</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_INSTANCE__DST_FLOW_SPEC = CONNECTION_INSTANCE_END_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Feature Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_INSTANCE__FEATURE_INSTANCE = CONNECTION_INSTANCE_END_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_INSTANCE__CATEGORY = CONNECTION_INSTANCE_END_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_INSTANCE__DIRECTION = CONNECTION_INSTANCE_END_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_INSTANCE__FEATURE = CONNECTION_INSTANCE_END_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_INSTANCE__INDEX = CONNECTION_INSTANCE_END_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Feature Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_INSTANCE_FEATURE_COUNT = CONNECTION_INSTANCE_END_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.instance.impl.AnnexInstanceImpl <em>Annex Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.instance.impl.AnnexInstanceImpl
	 * @see org.osate.aadl2.instance.impl.InstancePackageImpl#getAnnexInstance()
	 * @generated
	 */
	int ANNEX_INSTANCE = 2;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNEX_INSTANCE__OWNED_ELEMENT = Aadl2Package.NAMED_ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNEX_INSTANCE__OWNED_COMMENT = Aadl2Package.NAMED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNEX_INSTANCE__NAME = Aadl2Package.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNEX_INSTANCE__QUALIFIED_NAME = Aadl2Package.NAMED_ELEMENT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNEX_INSTANCE__OWNED_PROPERTY_ASSOCIATION = Aadl2Package.NAMED_ELEMENT__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Subclause</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNEX_INSTANCE__ANNEX_SUBCLAUSE = Aadl2Package.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Annex Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNEX_INSTANCE_FEATURE_COUNT = Aadl2Package.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.instance.impl.PropertyAssociationInstanceImpl <em>Property Association Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.instance.impl.PropertyAssociationInstanceImpl
	 * @see org.osate.aadl2.instance.impl.InstancePackageImpl#getPropertyAssociationInstance()
	 * @generated
	 */
	int PROPERTY_ASSOCIATION_INSTANCE = 3;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ASSOCIATION_INSTANCE__OWNED_ELEMENT = Aadl2Package.PROPERTY_ASSOCIATION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ASSOCIATION_INSTANCE__OWNED_COMMENT = Aadl2Package.PROPERTY_ASSOCIATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ASSOCIATION_INSTANCE__PROPERTY = Aadl2Package.PROPERTY_ASSOCIATION__PROPERTY;

	/**
	 * The feature id for the '<em><b>Applies To</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ASSOCIATION_INSTANCE__APPLIES_TO = Aadl2Package.PROPERTY_ASSOCIATION__APPLIES_TO;

	/**
	 * The feature id for the '<em><b>In Binding</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ASSOCIATION_INSTANCE__IN_BINDING = Aadl2Package.PROPERTY_ASSOCIATION__IN_BINDING;

	/**
	 * The feature id for the '<em><b>Append</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ASSOCIATION_INSTANCE__APPEND = Aadl2Package.PROPERTY_ASSOCIATION__APPEND;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ASSOCIATION_INSTANCE__CONSTANT = Aadl2Package.PROPERTY_ASSOCIATION__CONSTANT;

	/**
	 * The feature id for the '<em><b>Owned Value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ASSOCIATION_INSTANCE__OWNED_VALUE = Aadl2Package.PROPERTY_ASSOCIATION__OWNED_VALUE;

	/**
	 * The feature id for the '<em><b>Property Association</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ASSOCIATION_INSTANCE__PROPERTY_ASSOCIATION = Aadl2Package.PROPERTY_ASSOCIATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Property Association Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ASSOCIATION_INSTANCE_FEATURE_COUNT = Aadl2Package.PROPERTY_ASSOCIATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.instance.impl.FlowElementInstanceImpl <em>Flow Element Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.instance.impl.FlowElementInstanceImpl
	 * @see org.osate.aadl2.instance.impl.InstancePackageImpl#getFlowElementInstance()
	 * @generated
	 */
	int FLOW_ELEMENT_INSTANCE = 6;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ELEMENT_INSTANCE__OWNED_ELEMENT = INSTANCE_OBJECT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ELEMENT_INSTANCE__OWNED_COMMENT = INSTANCE_OBJECT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ELEMENT_INSTANCE__NAME = INSTANCE_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ELEMENT_INSTANCE__QUALIFIED_NAME = INSTANCE_OBJECT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ELEMENT_INSTANCE__OWNED_PROPERTY_ASSOCIATION = INSTANCE_OBJECT__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ELEMENT_INSTANCE__ANNEX_INSTANCE = INSTANCE_OBJECT__ANNEX_INSTANCE;

	/**
	 * The number of structural features of the '<em>Flow Element Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ELEMENT_INSTANCE_FEATURE_COUNT = INSTANCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.instance.impl.ConnectionInstanceImpl <em>Connection Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.instance.impl.ConnectionInstanceImpl
	 * @see org.osate.aadl2.instance.impl.InstancePackageImpl#getConnectionInstance()
	 * @generated
	 */
	int CONNECTION_INSTANCE = 5;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_INSTANCE__OWNED_ELEMENT = FLOW_ELEMENT_INSTANCE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_INSTANCE__OWNED_COMMENT = FLOW_ELEMENT_INSTANCE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_INSTANCE__NAME = FLOW_ELEMENT_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_INSTANCE__QUALIFIED_NAME = FLOW_ELEMENT_INSTANCE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_INSTANCE__OWNED_PROPERTY_ASSOCIATION = FLOW_ELEMENT_INSTANCE__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_INSTANCE__ANNEX_INSTANCE = FLOW_ELEMENT_INSTANCE__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>In System Operation Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_INSTANCE__IN_SYSTEM_OPERATION_MODE = FLOW_ELEMENT_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>In Mode Transition</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_INSTANCE__IN_MODE_TRANSITION = FLOW_ELEMENT_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_INSTANCE__COMPLETE = FLOW_ELEMENT_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_INSTANCE__KIND = FLOW_ELEMENT_INSTANCE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_INSTANCE__DESTINATION = FLOW_ELEMENT_INSTANCE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Connection Reference</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_INSTANCE__CONNECTION_REFERENCE = FLOW_ELEMENT_INSTANCE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Bidirectional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_INSTANCE__BIDIRECTIONAL = FLOW_ELEMENT_INSTANCE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_INSTANCE__SOURCE = FLOW_ELEMENT_INSTANCE_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Connection Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_INSTANCE_FEATURE_COUNT = FLOW_ELEMENT_INSTANCE_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.instance.impl.SystemOperationModeImpl <em>System Operation Mode</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.instance.impl.SystemOperationModeImpl
	 * @see org.osate.aadl2.instance.impl.InstancePackageImpl#getSystemOperationMode()
	 * @generated
	 */
	int SYSTEM_OPERATION_MODE = 7;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_OPERATION_MODE__OWNED_ELEMENT = Aadl2Package.MODE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_OPERATION_MODE__OWNED_COMMENT = Aadl2Package.MODE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_OPERATION_MODE__NAME = Aadl2Package.MODE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_OPERATION_MODE__QUALIFIED_NAME = Aadl2Package.MODE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_OPERATION_MODE__OWNED_PROPERTY_ASSOCIATION = Aadl2Package.MODE__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Featuring Classifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_OPERATION_MODE__FEATURING_CLASSIFIER = Aadl2Package.MODE__FEATURING_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Initial</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_OPERATION_MODE__INITIAL = Aadl2Package.MODE__INITIAL;

	/**
	 * The feature id for the '<em><b>Derived</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_OPERATION_MODE__DERIVED = Aadl2Package.MODE__DERIVED;

	/**
	 * The feature id for the '<em><b>Current Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_OPERATION_MODE__CURRENT_MODE = Aadl2Package.MODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>System Operation Mode</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_OPERATION_MODE_FEATURE_COUNT = Aadl2Package.MODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.instance.impl.ModeInstanceImpl <em>Mode Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.instance.impl.ModeInstanceImpl
	 * @see org.osate.aadl2.instance.impl.InstancePackageImpl#getModeInstance()
	 * @generated
	 */
	int MODE_INSTANCE = 8;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_INSTANCE__OWNED_ELEMENT = INSTANCE_OBJECT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_INSTANCE__OWNED_COMMENT = INSTANCE_OBJECT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_INSTANCE__NAME = INSTANCE_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_INSTANCE__QUALIFIED_NAME = INSTANCE_OBJECT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_INSTANCE__OWNED_PROPERTY_ASSOCIATION = INSTANCE_OBJECT__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_INSTANCE__ANNEX_INSTANCE = INSTANCE_OBJECT__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Src Mode Transition</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_INSTANCE__SRC_MODE_TRANSITION = INSTANCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Dst Mode Transition</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_INSTANCE__DST_MODE_TRANSITION = INSTANCE_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Initial</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_INSTANCE__INITIAL = INSTANCE_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_INSTANCE__MODE = INSTANCE_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Derived</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_INSTANCE__DERIVED = INSTANCE_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_INSTANCE__PARENT = INSTANCE_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Mode Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_INSTANCE_FEATURE_COUNT = INSTANCE_OBJECT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.instance.impl.ModeTransitionInstanceImpl <em>Mode Transition Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.instance.impl.ModeTransitionInstanceImpl
	 * @see org.osate.aadl2.instance.impl.InstancePackageImpl#getModeTransitionInstance()
	 * @generated
	 */
	int MODE_TRANSITION_INSTANCE = 9;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_TRANSITION_INSTANCE__OWNED_ELEMENT = CONNECTION_INSTANCE_END__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_TRANSITION_INSTANCE__OWNED_COMMENT = CONNECTION_INSTANCE_END__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_TRANSITION_INSTANCE__NAME = CONNECTION_INSTANCE_END__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_TRANSITION_INSTANCE__QUALIFIED_NAME = CONNECTION_INSTANCE_END__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_TRANSITION_INSTANCE__OWNED_PROPERTY_ASSOCIATION = CONNECTION_INSTANCE_END__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_TRANSITION_INSTANCE__ANNEX_INSTANCE = CONNECTION_INSTANCE_END__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Src Connection Instance</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_TRANSITION_INSTANCE__SRC_CONNECTION_INSTANCE = CONNECTION_INSTANCE_END__SRC_CONNECTION_INSTANCE;

	/**
	 * The feature id for the '<em><b>Dst Connection Instance</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_TRANSITION_INSTANCE__DST_CONNECTION_INSTANCE = CONNECTION_INSTANCE_END__DST_CONNECTION_INSTANCE;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_TRANSITION_INSTANCE__DESTINATION = CONNECTION_INSTANCE_END_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mode Transition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_TRANSITION_INSTANCE__MODE_TRANSITION = CONNECTION_INSTANCE_END_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_TRANSITION_INSTANCE__SOURCE = CONNECTION_INSTANCE_END_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Mode Transition Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_TRANSITION_INSTANCE_FEATURE_COUNT = CONNECTION_INSTANCE_END_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.instance.impl.ConnectionReferenceImpl <em>Connection Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.instance.impl.ConnectionReferenceImpl
	 * @see org.osate.aadl2.instance.impl.InstancePackageImpl#getConnectionReference()
	 * @generated
	 */
	int CONNECTION_REFERENCE = 10;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REFERENCE__OWNED_ELEMENT = INSTANCE_OBJECT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REFERENCE__OWNED_COMMENT = INSTANCE_OBJECT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REFERENCE__NAME = INSTANCE_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REFERENCE__QUALIFIED_NAME = INSTANCE_OBJECT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REFERENCE__OWNED_PROPERTY_ASSOCIATION = INSTANCE_OBJECT__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REFERENCE__ANNEX_INSTANCE = INSTANCE_OBJECT__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REFERENCE__CONTEXT = INSTANCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REFERENCE__CONNECTION = INSTANCE_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REFERENCE__SOURCE = INSTANCE_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REFERENCE__DESTINATION = INSTANCE_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Connection Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REFERENCE_FEATURE_COUNT = INSTANCE_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.instance.impl.ComponentInstanceImpl <em>Component Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.instance.impl.ComponentInstanceImpl
	 * @see org.osate.aadl2.instance.impl.InstancePackageImpl#getComponentInstance()
	 * @generated
	 */
	int COMPONENT_INSTANCE = 11;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_INSTANCE__OWNED_ELEMENT = CONNECTION_INSTANCE_END__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_INSTANCE__OWNED_COMMENT = CONNECTION_INSTANCE_END__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_INSTANCE__NAME = CONNECTION_INSTANCE_END__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_INSTANCE__QUALIFIED_NAME = CONNECTION_INSTANCE_END__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_INSTANCE__OWNED_PROPERTY_ASSOCIATION = CONNECTION_INSTANCE_END__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_INSTANCE__ANNEX_INSTANCE = CONNECTION_INSTANCE_END__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Src Connection Instance</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_INSTANCE__SRC_CONNECTION_INSTANCE = CONNECTION_INSTANCE_END__SRC_CONNECTION_INSTANCE;

	/**
	 * The feature id for the '<em><b>Dst Connection Instance</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_INSTANCE__DST_CONNECTION_INSTANCE = CONNECTION_INSTANCE_END__DST_CONNECTION_INSTANCE;

	/**
	 * The feature id for the '<em><b>Feature Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_INSTANCE__FEATURE_INSTANCE = CONNECTION_INSTANCE_END_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Component Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_INSTANCE__COMPONENT_INSTANCE = CONNECTION_INSTANCE_END_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Mode Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_INSTANCE__MODE_INSTANCE = CONNECTION_INSTANCE_END_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Mode Transition Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_INSTANCE__MODE_TRANSITION_INSTANCE = CONNECTION_INSTANCE_END_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_INSTANCE__CATEGORY = CONNECTION_INSTANCE_END_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>In Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_INSTANCE__IN_MODE = CONNECTION_INSTANCE_END_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Flow Specification</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_INSTANCE__FLOW_SPECIFICATION = CONNECTION_INSTANCE_END_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>End To End Flow</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_INSTANCE__END_TO_END_FLOW = CONNECTION_INSTANCE_END_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Connection Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_INSTANCE__CONNECTION_INSTANCE = CONNECTION_INSTANCE_END_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Subcomponent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_INSTANCE__SUBCOMPONENT = CONNECTION_INSTANCE_END_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_INSTANCE__INDEX = CONNECTION_INSTANCE_END_FEATURE_COUNT + 10;

	/**
	 * The number of structural features of the '<em>Component Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_INSTANCE_FEATURE_COUNT = CONNECTION_INSTANCE_END_FEATURE_COUNT + 11;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.instance.impl.FlowSpecificationInstanceImpl <em>Flow Specification Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.instance.impl.FlowSpecificationInstanceImpl
	 * @see org.osate.aadl2.instance.impl.InstancePackageImpl#getFlowSpecificationInstance()
	 * @generated
	 */
	int FLOW_SPECIFICATION_INSTANCE = 12;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_SPECIFICATION_INSTANCE__OWNED_ELEMENT = FLOW_ELEMENT_INSTANCE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_SPECIFICATION_INSTANCE__OWNED_COMMENT = FLOW_ELEMENT_INSTANCE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_SPECIFICATION_INSTANCE__NAME = FLOW_ELEMENT_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_SPECIFICATION_INSTANCE__QUALIFIED_NAME = FLOW_ELEMENT_INSTANCE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_SPECIFICATION_INSTANCE__OWNED_PROPERTY_ASSOCIATION = FLOW_ELEMENT_INSTANCE__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_SPECIFICATION_INSTANCE__ANNEX_INSTANCE = FLOW_ELEMENT_INSTANCE__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_SPECIFICATION_INSTANCE__SOURCE = FLOW_ELEMENT_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_SPECIFICATION_INSTANCE__DESTINATION = FLOW_ELEMENT_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Flow Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_SPECIFICATION_INSTANCE__FLOW_SPECIFICATION = FLOW_ELEMENT_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>In Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_SPECIFICATION_INSTANCE__IN_MODE = FLOW_ELEMENT_INSTANCE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>In Mode Transition</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_SPECIFICATION_INSTANCE__IN_MODE_TRANSITION = FLOW_ELEMENT_INSTANCE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Flow Specification Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_SPECIFICATION_INSTANCE_FEATURE_COUNT = FLOW_ELEMENT_INSTANCE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.instance.impl.EndToEndFlowInstanceImpl <em>End To End Flow Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.instance.impl.EndToEndFlowInstanceImpl
	 * @see org.osate.aadl2.instance.impl.InstancePackageImpl#getEndToEndFlowInstance()
	 * @generated
	 */
	int END_TO_END_FLOW_INSTANCE = 13;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_TO_END_FLOW_INSTANCE__OWNED_ELEMENT = FLOW_ELEMENT_INSTANCE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_TO_END_FLOW_INSTANCE__OWNED_COMMENT = FLOW_ELEMENT_INSTANCE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_TO_END_FLOW_INSTANCE__NAME = FLOW_ELEMENT_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_TO_END_FLOW_INSTANCE__QUALIFIED_NAME = FLOW_ELEMENT_INSTANCE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_TO_END_FLOW_INSTANCE__OWNED_PROPERTY_ASSOCIATION = FLOW_ELEMENT_INSTANCE__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_TO_END_FLOW_INSTANCE__ANNEX_INSTANCE = FLOW_ELEMENT_INSTANCE__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Flow Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_TO_END_FLOW_INSTANCE__FLOW_ELEMENT = FLOW_ELEMENT_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>In Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_TO_END_FLOW_INSTANCE__IN_MODE = FLOW_ELEMENT_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>In System Operation Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_TO_END_FLOW_INSTANCE__IN_SYSTEM_OPERATION_MODE = FLOW_ELEMENT_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>End To End Flow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_TO_END_FLOW_INSTANCE__END_TO_END_FLOW = FLOW_ELEMENT_INSTANCE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>End To End Flow Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_TO_END_FLOW_INSTANCE_FEATURE_COUNT = FLOW_ELEMENT_INSTANCE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.instance.impl.SystemInstanceImpl <em>System Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.instance.impl.SystemInstanceImpl
	 * @see org.osate.aadl2.instance.impl.InstancePackageImpl#getSystemInstance()
	 * @generated
	 */
	int SYSTEM_INSTANCE = 14;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_INSTANCE__OWNED_ELEMENT = COMPONENT_INSTANCE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_INSTANCE__OWNED_COMMENT = COMPONENT_INSTANCE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_INSTANCE__NAME = COMPONENT_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_INSTANCE__QUALIFIED_NAME = COMPONENT_INSTANCE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_INSTANCE__OWNED_PROPERTY_ASSOCIATION = COMPONENT_INSTANCE__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_INSTANCE__ANNEX_INSTANCE = COMPONENT_INSTANCE__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Src Connection Instance</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_INSTANCE__SRC_CONNECTION_INSTANCE = COMPONENT_INSTANCE__SRC_CONNECTION_INSTANCE;

	/**
	 * The feature id for the '<em><b>Dst Connection Instance</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_INSTANCE__DST_CONNECTION_INSTANCE = COMPONENT_INSTANCE__DST_CONNECTION_INSTANCE;

	/**
	 * The feature id for the '<em><b>Feature Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_INSTANCE__FEATURE_INSTANCE = COMPONENT_INSTANCE__FEATURE_INSTANCE;

	/**
	 * The feature id for the '<em><b>Component Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_INSTANCE__COMPONENT_INSTANCE = COMPONENT_INSTANCE__COMPONENT_INSTANCE;

	/**
	 * The feature id for the '<em><b>Mode Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_INSTANCE__MODE_INSTANCE = COMPONENT_INSTANCE__MODE_INSTANCE;

	/**
	 * The feature id for the '<em><b>Mode Transition Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_INSTANCE__MODE_TRANSITION_INSTANCE = COMPONENT_INSTANCE__MODE_TRANSITION_INSTANCE;

	/**
	 * The feature id for the '<em><b>Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_INSTANCE__CATEGORY = COMPONENT_INSTANCE__CATEGORY;

	/**
	 * The feature id for the '<em><b>In Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_INSTANCE__IN_MODE = COMPONENT_INSTANCE__IN_MODE;

	/**
	 * The feature id for the '<em><b>Flow Specification</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_INSTANCE__FLOW_SPECIFICATION = COMPONENT_INSTANCE__FLOW_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>End To End Flow</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_INSTANCE__END_TO_END_FLOW = COMPONENT_INSTANCE__END_TO_END_FLOW;

	/**
	 * The feature id for the '<em><b>Connection Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_INSTANCE__CONNECTION_INSTANCE = COMPONENT_INSTANCE__CONNECTION_INSTANCE;

	/**
	 * The feature id for the '<em><b>Subcomponent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_INSTANCE__SUBCOMPONENT = COMPONENT_INSTANCE__SUBCOMPONENT;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_INSTANCE__INDEX = COMPONENT_INSTANCE__INDEX;

	/**
	 * The feature id for the '<em><b>System Operation Mode</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_INSTANCE__SYSTEM_OPERATION_MODE = COMPONENT_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Component Implementation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_INSTANCE__COMPONENT_IMPLEMENTATION = COMPONENT_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>System Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_INSTANCE_FEATURE_COUNT = COMPONENT_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.instance.impl.InstanceReferenceValueImpl <em>Reference Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.instance.impl.InstanceReferenceValueImpl
	 * @see org.osate.aadl2.instance.impl.InstancePackageImpl#getInstanceReferenceValue()
	 * @generated
	 */
	int INSTANCE_REFERENCE_VALUE = 15;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_REFERENCE_VALUE__OWNED_ELEMENT = Aadl2Package.PROPERTY_VALUE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_REFERENCE_VALUE__OWNED_COMMENT = Aadl2Package.PROPERTY_VALUE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Referenced Instance Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_REFERENCE_VALUE__REFERENCED_INSTANCE_OBJECT = Aadl2Package.PROPERTY_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Reference Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_REFERENCE_VALUE_FEATURE_COUNT = Aadl2Package.PROPERTY_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.instance.ConnectionKind <em>Connection Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.instance.ConnectionKind
	 * @see org.osate.aadl2.instance.impl.InstancePackageImpl#getConnectionKind()
	 * @generated
	 */
	int CONNECTION_KIND = 16;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.instance.FeatureCategory <em>Feature Category</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.instance.FeatureCategory
	 * @see org.osate.aadl2.instance.impl.InstancePackageImpl#getFeatureCategory()
	 * @generated
	 */
	int FEATURE_CATEGORY = 17;

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.instance.FeatureInstance <em>Feature Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Instance</em>'.
	 * @see org.osate.aadl2.instance.FeatureInstance
	 * @generated
	 */
	EClass getFeatureInstance();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.instance.FeatureInstance#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feature</em>'.
	 * @see org.osate.aadl2.instance.FeatureInstance#getFeature()
	 * @see #getFeatureInstance()
	 * @generated
	 */
	EReference getFeatureInstance_Feature();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.aadl2.instance.FeatureInstance#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see org.osate.aadl2.instance.FeatureInstance#getIndex()
	 * @see #getFeatureInstance()
	 * @generated
	 */
	EAttribute getFeatureInstance_Index();

	/**
	 * Returns the meta object for the reference list '{@link org.osate.aadl2.instance.FeatureInstance#getSrcFlowSpecs <em>Src Flow Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Src Flow Spec</em>'.
	 * @see org.osate.aadl2.instance.FeatureInstance#getSrcFlowSpecs()
	 * @see #getFeatureInstance()
	 * @generated
	 */
	EReference getFeatureInstance_SrcFlowSpec();

	/**
	 * Returns the meta object for the reference list '{@link org.osate.aadl2.instance.FeatureInstance#getDstFlowSpecs <em>Dst Flow Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Dst Flow Spec</em>'.
	 * @see org.osate.aadl2.instance.FeatureInstance#getDstFlowSpecs()
	 * @see #getFeatureInstance()
	 * @generated
	 */
	EReference getFeatureInstance_DstFlowSpec();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.aadl2.instance.FeatureInstance#getFeatureInstances <em>Feature Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Feature Instance</em>'.
	 * @see org.osate.aadl2.instance.FeatureInstance#getFeatureInstances()
	 * @see #getFeatureInstance()
	 * @generated
	 */
	EReference getFeatureInstance_FeatureInstance();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.aadl2.instance.FeatureInstance#getCategory <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Category</em>'.
	 * @see org.osate.aadl2.instance.FeatureInstance#getCategory()
	 * @see #getFeatureInstance()
	 * @generated
	 */
	EAttribute getFeatureInstance_Category();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.aadl2.instance.FeatureInstance#getDirection <em>Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Direction</em>'.
	 * @see org.osate.aadl2.instance.FeatureInstance#getDirection()
	 * @see #getFeatureInstance()
	 * @generated
	 */
	EAttribute getFeatureInstance_Direction();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.instance.InstanceObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object</em>'.
	 * @see org.osate.aadl2.instance.InstanceObject
	 * @generated
	 */
	EClass getInstanceObject();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.aadl2.instance.InstanceObject#getAnnexInstances <em>Annex Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Annex Instance</em>'.
	 * @see org.osate.aadl2.instance.InstanceObject#getAnnexInstances()
	 * @see #getInstanceObject()
	 * @generated
	 */
	EReference getInstanceObject_AnnexInstance();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.instance.AnnexInstance <em>Annex Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annex Instance</em>'.
	 * @see org.osate.aadl2.instance.AnnexInstance
	 * @generated
	 */
	EClass getAnnexInstance();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.instance.AnnexInstance#getAnnexSubclause <em>Annex Subclause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Annex Subclause</em>'.
	 * @see org.osate.aadl2.instance.AnnexInstance#getAnnexSubclause()
	 * @see #getAnnexInstance()
	 * @generated
	 */
	EReference getAnnexInstance_AnnexSubclause();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.instance.PropertyAssociationInstance <em>Property Association Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Association Instance</em>'.
	 * @see org.osate.aadl2.instance.PropertyAssociationInstance
	 * @generated
	 */
	EClass getPropertyAssociationInstance();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.instance.PropertyAssociationInstance#getPropertyAssociation <em>Property Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Property Association</em>'.
	 * @see org.osate.aadl2.instance.PropertyAssociationInstance#getPropertyAssociation()
	 * @see #getPropertyAssociationInstance()
	 * @generated
	 */
	EReference getPropertyAssociationInstance_PropertyAssociation();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.instance.ConnectionInstanceEnd <em>Connection Instance End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection Instance End</em>'.
	 * @see org.osate.aadl2.instance.ConnectionInstanceEnd
	 * @generated
	 */
	EClass getConnectionInstanceEnd();

	/**
	 * Returns the meta object for the reference list '{@link org.osate.aadl2.instance.ConnectionInstanceEnd#getSrcConnectionInstances <em>Src Connection Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Src Connection Instance</em>'.
	 * @see org.osate.aadl2.instance.ConnectionInstanceEnd#getSrcConnectionInstances()
	 * @see #getConnectionInstanceEnd()
	 * @generated
	 */
	EReference getConnectionInstanceEnd_SrcConnectionInstance();

	/**
	 * Returns the meta object for the reference list '{@link org.osate.aadl2.instance.ConnectionInstanceEnd#getDstConnectionInstances <em>Dst Connection Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Dst Connection Instance</em>'.
	 * @see org.osate.aadl2.instance.ConnectionInstanceEnd#getDstConnectionInstances()
	 * @see #getConnectionInstanceEnd()
	 * @generated
	 */
	EReference getConnectionInstanceEnd_DstConnectionInstance();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.instance.ConnectionInstance <em>Connection Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection Instance</em>'.
	 * @see org.osate.aadl2.instance.ConnectionInstance
	 * @generated
	 */
	EClass getConnectionInstance();

	/**
	 * Returns the meta object for the reference list '{@link org.osate.aadl2.instance.ConnectionInstance#getInSystemOperationModes <em>In System Operation Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>In System Operation Mode</em>'.
	 * @see org.osate.aadl2.instance.ConnectionInstance#getInSystemOperationModes()
	 * @see #getConnectionInstance()
	 * @generated
	 */
	EReference getConnectionInstance_InSystemOperationMode();

	/**
	 * Returns the meta object for the reference list '{@link org.osate.aadl2.instance.ConnectionInstance#getInModeTransitions <em>In Mode Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>In Mode Transition</em>'.
	 * @see org.osate.aadl2.instance.ConnectionInstance#getInModeTransitions()
	 * @see #getConnectionInstance()
	 * @generated
	 */
	EReference getConnectionInstance_InModeTransition();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.aadl2.instance.ConnectionInstance#isComplete <em>Complete</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Complete</em>'.
	 * @see org.osate.aadl2.instance.ConnectionInstance#isComplete()
	 * @see #getConnectionInstance()
	 * @generated
	 */
	EAttribute getConnectionInstance_Complete();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.aadl2.instance.ConnectionInstance#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.osate.aadl2.instance.ConnectionInstance#getKind()
	 * @see #getConnectionInstance()
	 * @generated
	 */
	EAttribute getConnectionInstance_Kind();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.instance.ConnectionInstance#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Destination</em>'.
	 * @see org.osate.aadl2.instance.ConnectionInstance#getDestination()
	 * @see #getConnectionInstance()
	 * @generated
	 */
	EReference getConnectionInstance_Destination();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.aadl2.instance.ConnectionInstance#getConnectionReferences <em>Connection Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Connection Reference</em>'.
	 * @see org.osate.aadl2.instance.ConnectionInstance#getConnectionReferences()
	 * @see #getConnectionInstance()
	 * @generated
	 */
	EReference getConnectionInstance_ConnectionReference();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.aadl2.instance.ConnectionInstance#isBidirectional <em>Bidirectional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bidirectional</em>'.
	 * @see org.osate.aadl2.instance.ConnectionInstance#isBidirectional()
	 * @see #getConnectionInstance()
	 * @generated
	 */
	EAttribute getConnectionInstance_Bidirectional();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.instance.ConnectionInstance#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.osate.aadl2.instance.ConnectionInstance#getSource()
	 * @see #getConnectionInstance()
	 * @generated
	 */
	EReference getConnectionInstance_Source();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.instance.FlowElementInstance <em>Flow Element Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Flow Element Instance</em>'.
	 * @see org.osate.aadl2.instance.FlowElementInstance
	 * @generated
	 */
	EClass getFlowElementInstance();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.instance.SystemOperationMode <em>System Operation Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System Operation Mode</em>'.
	 * @see org.osate.aadl2.instance.SystemOperationMode
	 * @generated
	 */
	EClass getSystemOperationMode();

	/**
	 * Returns the meta object for the reference list '{@link org.osate.aadl2.instance.SystemOperationMode#getCurrentModes <em>Current Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Current Mode</em>'.
	 * @see org.osate.aadl2.instance.SystemOperationMode#getCurrentModes()
	 * @see #getSystemOperationMode()
	 * @generated
	 */
	EReference getSystemOperationMode_CurrentMode();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.instance.ModeInstance <em>Mode Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mode Instance</em>'.
	 * @see org.osate.aadl2.instance.ModeInstance
	 * @generated
	 */
	EClass getModeInstance();

	/**
	 * Returns the meta object for the reference list '{@link org.osate.aadl2.instance.ModeInstance#getSrcModeTransitions <em>Src Mode Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Src Mode Transition</em>'.
	 * @see org.osate.aadl2.instance.ModeInstance#getSrcModeTransitions()
	 * @see #getModeInstance()
	 * @generated
	 */
	EReference getModeInstance_SrcModeTransition();

	/**
	 * Returns the meta object for the reference list '{@link org.osate.aadl2.instance.ModeInstance#getDstModeTransitions <em>Dst Mode Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Dst Mode Transition</em>'.
	 * @see org.osate.aadl2.instance.ModeInstance#getDstModeTransitions()
	 * @see #getModeInstance()
	 * @generated
	 */
	EReference getModeInstance_DstModeTransition();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.instance.ModeInstance#getMode <em>Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Mode</em>'.
	 * @see org.osate.aadl2.instance.ModeInstance#getMode()
	 * @see #getModeInstance()
	 * @generated
	 */
	EReference getModeInstance_Mode();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.aadl2.instance.ModeInstance#isDerived <em>Derived</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Derived</em>'.
	 * @see org.osate.aadl2.instance.ModeInstance#isDerived()
	 * @see #getModeInstance()
	 * @generated
	 */
	EAttribute getModeInstance_Derived();

	/**
	 * Returns the meta object for the reference list '{@link org.osate.aadl2.instance.ModeInstance#getParents <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parent</em>'.
	 * @see org.osate.aadl2.instance.ModeInstance#getParents()
	 * @see #getModeInstance()
	 * @generated
	 */
	EReference getModeInstance_Parent();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.aadl2.instance.ModeInstance#isInitial <em>Initial</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initial</em>'.
	 * @see org.osate.aadl2.instance.ModeInstance#isInitial()
	 * @see #getModeInstance()
	 * @generated
	 */
	EAttribute getModeInstance_Initial();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.instance.ModeTransitionInstance <em>Mode Transition Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mode Transition Instance</em>'.
	 * @see org.osate.aadl2.instance.ModeTransitionInstance
	 * @generated
	 */
	EClass getModeTransitionInstance();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.instance.ModeTransitionInstance#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Destination</em>'.
	 * @see org.osate.aadl2.instance.ModeTransitionInstance#getDestination()
	 * @see #getModeTransitionInstance()
	 * @generated
	 */
	EReference getModeTransitionInstance_Destination();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.instance.ModeTransitionInstance#getModeTransition <em>Mode Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Mode Transition</em>'.
	 * @see org.osate.aadl2.instance.ModeTransitionInstance#getModeTransition()
	 * @see #getModeTransitionInstance()
	 * @generated
	 */
	EReference getModeTransitionInstance_ModeTransition();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.instance.ModeTransitionInstance#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.osate.aadl2.instance.ModeTransitionInstance#getSource()
	 * @see #getModeTransitionInstance()
	 * @generated
	 */
	EReference getModeTransitionInstance_Source();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.instance.ConnectionReference <em>Connection Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection Reference</em>'.
	 * @see org.osate.aadl2.instance.ConnectionReference
	 * @generated
	 */
	EClass getConnectionReference();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.instance.ConnectionReference#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Context</em>'.
	 * @see org.osate.aadl2.instance.ConnectionReference#getContext()
	 * @see #getConnectionReference()
	 * @generated
	 */
	EReference getConnectionReference_Context();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.instance.ConnectionReference#getConnection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Connection</em>'.
	 * @see org.osate.aadl2.instance.ConnectionReference#getConnection()
	 * @see #getConnectionReference()
	 * @generated
	 */
	EReference getConnectionReference_Connection();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.instance.ConnectionReference#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.osate.aadl2.instance.ConnectionReference#getSource()
	 * @see #getConnectionReference()
	 * @generated
	 */
	EReference getConnectionReference_Source();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.instance.ConnectionReference#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Destination</em>'.
	 * @see org.osate.aadl2.instance.ConnectionReference#getDestination()
	 * @see #getConnectionReference()
	 * @generated
	 */
	EReference getConnectionReference_Destination();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.instance.ComponentInstance <em>Component Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Instance</em>'.
	 * @see org.osate.aadl2.instance.ComponentInstance
	 * @generated
	 */
	EClass getComponentInstance();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.aadl2.instance.ComponentInstance#getFeatureInstances <em>Feature Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Feature Instance</em>'.
	 * @see org.osate.aadl2.instance.ComponentInstance#getFeatureInstances()
	 * @see #getComponentInstance()
	 * @generated
	 */
	EReference getComponentInstance_FeatureInstance();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.aadl2.instance.ComponentInstance#getComponentInstances <em>Component Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Component Instance</em>'.
	 * @see org.osate.aadl2.instance.ComponentInstance#getComponentInstances()
	 * @see #getComponentInstance()
	 * @generated
	 */
	EReference getComponentInstance_ComponentInstance();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.instance.ComponentInstance#getSubcomponent <em>Subcomponent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Subcomponent</em>'.
	 * @see org.osate.aadl2.instance.ComponentInstance#getSubcomponent()
	 * @see #getComponentInstance()
	 * @generated
	 */
	EReference getComponentInstance_Subcomponent();

	/**
	 * Returns the meta object for the attribute list '{@link org.osate.aadl2.instance.ComponentInstance#getIndices <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Index</em>'.
	 * @see org.osate.aadl2.instance.ComponentInstance#getIndices()
	 * @see #getComponentInstance()
	 * @generated
	 */
	EAttribute getComponentInstance_Index();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.instance.FlowSpecificationInstance <em>Flow Specification Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Flow Specification Instance</em>'.
	 * @see org.osate.aadl2.instance.FlowSpecificationInstance
	 * @generated
	 */
	EClass getFlowSpecificationInstance();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.instance.FlowSpecificationInstance#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.osate.aadl2.instance.FlowSpecificationInstance#getSource()
	 * @see #getFlowSpecificationInstance()
	 * @generated
	 */
	EReference getFlowSpecificationInstance_Source();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.instance.FlowSpecificationInstance#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Destination</em>'.
	 * @see org.osate.aadl2.instance.FlowSpecificationInstance#getDestination()
	 * @see #getFlowSpecificationInstance()
	 * @generated
	 */
	EReference getFlowSpecificationInstance_Destination();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.instance.FlowSpecificationInstance#getFlowSpecification <em>Flow Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Flow Specification</em>'.
	 * @see org.osate.aadl2.instance.FlowSpecificationInstance#getFlowSpecification()
	 * @see #getFlowSpecificationInstance()
	 * @generated
	 */
	EReference getFlowSpecificationInstance_FlowSpecification();

	/**
	 * Returns the meta object for the reference list '{@link org.osate.aadl2.instance.FlowSpecificationInstance#getInModes <em>In Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>In Mode</em>'.
	 * @see org.osate.aadl2.instance.FlowSpecificationInstance#getInModes()
	 * @see #getFlowSpecificationInstance()
	 * @generated
	 */
	EReference getFlowSpecificationInstance_InMode();

	/**
	 * Returns the meta object for the reference list '{@link org.osate.aadl2.instance.FlowSpecificationInstance#getInModeTransitions <em>In Mode Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>In Mode Transition</em>'.
	 * @see org.osate.aadl2.instance.FlowSpecificationInstance#getInModeTransitions()
	 * @see #getFlowSpecificationInstance()
	 * @generated
	 */
	EReference getFlowSpecificationInstance_InModeTransition();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.aadl2.instance.ComponentInstance#getModeInstances <em>Mode Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mode Instance</em>'.
	 * @see org.osate.aadl2.instance.ComponentInstance#getModeInstances()
	 * @see #getComponentInstance()
	 * @generated
	 */
	EReference getComponentInstance_ModeInstance();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.aadl2.instance.ComponentInstance#getModeTransitionInstances <em>Mode Transition Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mode Transition Instance</em>'.
	 * @see org.osate.aadl2.instance.ComponentInstance#getModeTransitionInstances()
	 * @see #getComponentInstance()
	 * @generated
	 */
	EReference getComponentInstance_ModeTransitionInstance();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.aadl2.instance.ComponentInstance#getCategory <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Category</em>'.
	 * @see org.osate.aadl2.instance.ComponentInstance#getCategory()
	 * @see #getComponentInstance()
	 * @generated
	 */
	EAttribute getComponentInstance_Category();

	/**
	 * Returns the meta object for the reference list '{@link org.osate.aadl2.instance.ComponentInstance#getInModes <em>In Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>In Mode</em>'.
	 * @see org.osate.aadl2.instance.ComponentInstance#getInModes()
	 * @see #getComponentInstance()
	 * @generated
	 */
	EReference getComponentInstance_InMode();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.aadl2.instance.ComponentInstance#getFlowSpecifications <em>Flow Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Flow Specification</em>'.
	 * @see org.osate.aadl2.instance.ComponentInstance#getFlowSpecifications()
	 * @see #getComponentInstance()
	 * @generated
	 */
	EReference getComponentInstance_FlowSpecification();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.aadl2.instance.ComponentInstance#getEndToEndFlows <em>End To End Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>End To End Flow</em>'.
	 * @see org.osate.aadl2.instance.ComponentInstance#getEndToEndFlows()
	 * @see #getComponentInstance()
	 * @generated
	 */
	EReference getComponentInstance_EndToEndFlow();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.aadl2.instance.ComponentInstance#getConnectionInstances <em>Connection Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Connection Instance</em>'.
	 * @see org.osate.aadl2.instance.ComponentInstance#getConnectionInstances()
	 * @see #getComponentInstance()
	 * @generated
	 */
	EReference getComponentInstance_ConnectionInstance();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.instance.EndToEndFlowInstance <em>End To End Flow Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>End To End Flow Instance</em>'.
	 * @see org.osate.aadl2.instance.EndToEndFlowInstance
	 * @generated
	 */
	EClass getEndToEndFlowInstance();

	/**
	 * Returns the meta object for the reference list '{@link org.osate.aadl2.instance.EndToEndFlowInstance#getFlowElements <em>Flow Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Flow Element</em>'.
	 * @see org.osate.aadl2.instance.EndToEndFlowInstance#getFlowElements()
	 * @see #getEndToEndFlowInstance()
	 * @generated
	 */
	EReference getEndToEndFlowInstance_FlowElement();

	/**
	 * Returns the meta object for the reference list '{@link org.osate.aadl2.instance.EndToEndFlowInstance#getInModes <em>In Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>In Mode</em>'.
	 * @see org.osate.aadl2.instance.EndToEndFlowInstance#getInModes()
	 * @see #getEndToEndFlowInstance()
	 * @generated
	 */
	EReference getEndToEndFlowInstance_InMode();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.instance.EndToEndFlowInstance#getEndToEndFlow <em>End To End Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>End To End Flow</em>'.
	 * @see org.osate.aadl2.instance.EndToEndFlowInstance#getEndToEndFlow()
	 * @see #getEndToEndFlowInstance()
	 * @generated
	 */
	EReference getEndToEndFlowInstance_EndToEndFlow();

	/**
	 * Returns the meta object for the reference list '{@link org.osate.aadl2.instance.EndToEndFlowInstance#getInSystemOperationModes <em>In System Operation Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>In System Operation Mode</em>'.
	 * @see org.osate.aadl2.instance.EndToEndFlowInstance#getInSystemOperationModes()
	 * @see #getEndToEndFlowInstance()
	 * @generated
	 */
	EReference getEndToEndFlowInstance_InSystemOperationMode();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.instance.SystemInstance <em>System Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System Instance</em>'.
	 * @see org.osate.aadl2.instance.SystemInstance
	 * @generated
	 */
	EClass getSystemInstance();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.aadl2.instance.SystemInstance#getSystemOperationModes <em>System Operation Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>System Operation Mode</em>'.
	 * @see org.osate.aadl2.instance.SystemInstance#getSystemOperationModes()
	 * @see #getSystemInstance()
	 * @generated
	 */
	EReference getSystemInstance_SystemOperationMode();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.instance.SystemInstance#getComponentImplementation <em>Component Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Component Implementation</em>'.
	 * @see org.osate.aadl2.instance.SystemInstance#getComponentImplementation()
	 * @see #getSystemInstance()
	 * @generated
	 */
	EReference getSystemInstance_ComponentImplementation();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.instance.InstanceReferenceValue <em>Reference Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Value</em>'.
	 * @see org.osate.aadl2.instance.InstanceReferenceValue
	 * @generated
	 */
	EClass getInstanceReferenceValue();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.instance.InstanceReferenceValue#getReferencedInstanceObject <em>Referenced Instance Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referenced Instance Object</em>'.
	 * @see org.osate.aadl2.instance.InstanceReferenceValue#getReferencedInstanceObject()
	 * @see #getInstanceReferenceValue()
	 * @generated
	 */
	EReference getInstanceReferenceValue_ReferencedInstanceObject();

	/**
	 * Returns the meta object for enum '{@link org.osate.aadl2.instance.ConnectionKind <em>Connection Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Connection Kind</em>'.
	 * @see org.osate.aadl2.instance.ConnectionKind
	 * @generated
	 */
	EEnum getConnectionKind();

	/**
	 * Returns the meta object for enum '{@link org.osate.aadl2.instance.FeatureCategory <em>Feature Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Feature Category</em>'.
	 * @see org.osate.aadl2.instance.FeatureCategory
	 * @generated
	 */
	EEnum getFeatureCategory();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	InstanceFactory getInstanceFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.osate.aadl2.instance.impl.FeatureInstanceImpl <em>Feature Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.instance.impl.FeatureInstanceImpl
		 * @see org.osate.aadl2.instance.impl.InstancePackageImpl#getFeatureInstance()
		 * @generated
		 */
		EClass FEATURE_INSTANCE = eINSTANCE.getFeatureInstance();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_INSTANCE__FEATURE = eINSTANCE.getFeatureInstance_Feature();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_INSTANCE__INDEX = eINSTANCE.getFeatureInstance_Index();

		/**
		 * The meta object literal for the '<em><b>Src Flow Spec</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_INSTANCE__SRC_FLOW_SPEC = eINSTANCE.getFeatureInstance_SrcFlowSpec();

		/**
		 * The meta object literal for the '<em><b>Dst Flow Spec</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_INSTANCE__DST_FLOW_SPEC = eINSTANCE.getFeatureInstance_DstFlowSpec();

		/**
		 * The meta object literal for the '<em><b>Feature Instance</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_INSTANCE__FEATURE_INSTANCE = eINSTANCE.getFeatureInstance_FeatureInstance();

		/**
		 * The meta object literal for the '<em><b>Category</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_INSTANCE__CATEGORY = eINSTANCE.getFeatureInstance_Category();

		/**
		 * The meta object literal for the '<em><b>Direction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_INSTANCE__DIRECTION = eINSTANCE.getFeatureInstance_Direction();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.instance.impl.InstanceObjectImpl <em>Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.instance.impl.InstanceObjectImpl
		 * @see org.osate.aadl2.instance.impl.InstancePackageImpl#getInstanceObject()
		 * @generated
		 */
		EClass INSTANCE_OBJECT = eINSTANCE.getInstanceObject();

		/**
		 * The meta object literal for the '<em><b>Annex Instance</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANCE_OBJECT__ANNEX_INSTANCE = eINSTANCE.getInstanceObject_AnnexInstance();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.instance.impl.AnnexInstanceImpl <em>Annex Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.instance.impl.AnnexInstanceImpl
		 * @see org.osate.aadl2.instance.impl.InstancePackageImpl#getAnnexInstance()
		 * @generated
		 */
		EClass ANNEX_INSTANCE = eINSTANCE.getAnnexInstance();

		/**
		 * The meta object literal for the '<em><b>Annex Subclause</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNEX_INSTANCE__ANNEX_SUBCLAUSE = eINSTANCE.getAnnexInstance_AnnexSubclause();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.instance.impl.PropertyAssociationInstanceImpl <em>Property Association Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.instance.impl.PropertyAssociationInstanceImpl
		 * @see org.osate.aadl2.instance.impl.InstancePackageImpl#getPropertyAssociationInstance()
		 * @generated
		 */
		EClass PROPERTY_ASSOCIATION_INSTANCE = eINSTANCE.getPropertyAssociationInstance();

		/**
		 * The meta object literal for the '<em><b>Property Association</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_ASSOCIATION_INSTANCE__PROPERTY_ASSOCIATION = eINSTANCE
				.getPropertyAssociationInstance_PropertyAssociation();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.instance.impl.ConnectionInstanceEndImpl <em>Connection Instance End</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.instance.impl.ConnectionInstanceEndImpl
		 * @see org.osate.aadl2.instance.impl.InstancePackageImpl#getConnectionInstanceEnd()
		 * @generated
		 */
		EClass CONNECTION_INSTANCE_END = eINSTANCE.getConnectionInstanceEnd();

		/**
		 * The meta object literal for the '<em><b>Src Connection Instance</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION_INSTANCE_END__SRC_CONNECTION_INSTANCE = eINSTANCE
				.getConnectionInstanceEnd_SrcConnectionInstance();

		/**
		 * The meta object literal for the '<em><b>Dst Connection Instance</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION_INSTANCE_END__DST_CONNECTION_INSTANCE = eINSTANCE
				.getConnectionInstanceEnd_DstConnectionInstance();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.instance.impl.ConnectionInstanceImpl <em>Connection Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.instance.impl.ConnectionInstanceImpl
		 * @see org.osate.aadl2.instance.impl.InstancePackageImpl#getConnectionInstance()
		 * @generated
		 */
		EClass CONNECTION_INSTANCE = eINSTANCE.getConnectionInstance();

		/**
		 * The meta object literal for the '<em><b>In System Operation Mode</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION_INSTANCE__IN_SYSTEM_OPERATION_MODE = eINSTANCE
				.getConnectionInstance_InSystemOperationMode();

		/**
		 * The meta object literal for the '<em><b>In Mode Transition</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION_INSTANCE__IN_MODE_TRANSITION = eINSTANCE.getConnectionInstance_InModeTransition();

		/**
		 * The meta object literal for the '<em><b>Complete</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_INSTANCE__COMPLETE = eINSTANCE.getConnectionInstance_Complete();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_INSTANCE__KIND = eINSTANCE.getConnectionInstance_Kind();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION_INSTANCE__DESTINATION = eINSTANCE.getConnectionInstance_Destination();

		/**
		 * The meta object literal for the '<em><b>Connection Reference</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION_INSTANCE__CONNECTION_REFERENCE = eINSTANCE.getConnectionInstance_ConnectionReference();

		/**
		 * The meta object literal for the '<em><b>Bidirectional</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_INSTANCE__BIDIRECTIONAL = eINSTANCE.getConnectionInstance_Bidirectional();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION_INSTANCE__SOURCE = eINSTANCE.getConnectionInstance_Source();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.instance.impl.FlowElementInstanceImpl <em>Flow Element Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.instance.impl.FlowElementInstanceImpl
		 * @see org.osate.aadl2.instance.impl.InstancePackageImpl#getFlowElementInstance()
		 * @generated
		 */
		EClass FLOW_ELEMENT_INSTANCE = eINSTANCE.getFlowElementInstance();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.instance.impl.SystemOperationModeImpl <em>System Operation Mode</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.instance.impl.SystemOperationModeImpl
		 * @see org.osate.aadl2.instance.impl.InstancePackageImpl#getSystemOperationMode()
		 * @generated
		 */
		EClass SYSTEM_OPERATION_MODE = eINSTANCE.getSystemOperationMode();

		/**
		 * The meta object literal for the '<em><b>Current Mode</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_OPERATION_MODE__CURRENT_MODE = eINSTANCE.getSystemOperationMode_CurrentMode();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.instance.impl.ModeInstanceImpl <em>Mode Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.instance.impl.ModeInstanceImpl
		 * @see org.osate.aadl2.instance.impl.InstancePackageImpl#getModeInstance()
		 * @generated
		 */
		EClass MODE_INSTANCE = eINSTANCE.getModeInstance();

		/**
		 * The meta object literal for the '<em><b>Src Mode Transition</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODE_INSTANCE__SRC_MODE_TRANSITION = eINSTANCE.getModeInstance_SrcModeTransition();

		/**
		 * The meta object literal for the '<em><b>Dst Mode Transition</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODE_INSTANCE__DST_MODE_TRANSITION = eINSTANCE.getModeInstance_DstModeTransition();

		/**
		 * The meta object literal for the '<em><b>Mode</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODE_INSTANCE__MODE = eINSTANCE.getModeInstance_Mode();

		/**
		 * The meta object literal for the '<em><b>Derived</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODE_INSTANCE__DERIVED = eINSTANCE.getModeInstance_Derived();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODE_INSTANCE__PARENT = eINSTANCE.getModeInstance_Parent();

		/**
		 * The meta object literal for the '<em><b>Initial</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODE_INSTANCE__INITIAL = eINSTANCE.getModeInstance_Initial();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.instance.impl.ModeTransitionInstanceImpl <em>Mode Transition Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.instance.impl.ModeTransitionInstanceImpl
		 * @see org.osate.aadl2.instance.impl.InstancePackageImpl#getModeTransitionInstance()
		 * @generated
		 */
		EClass MODE_TRANSITION_INSTANCE = eINSTANCE.getModeTransitionInstance();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODE_TRANSITION_INSTANCE__DESTINATION = eINSTANCE.getModeTransitionInstance_Destination();

		/**
		 * The meta object literal for the '<em><b>Mode Transition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODE_TRANSITION_INSTANCE__MODE_TRANSITION = eINSTANCE.getModeTransitionInstance_ModeTransition();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODE_TRANSITION_INSTANCE__SOURCE = eINSTANCE.getModeTransitionInstance_Source();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.instance.impl.ConnectionReferenceImpl <em>Connection Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.instance.impl.ConnectionReferenceImpl
		 * @see org.osate.aadl2.instance.impl.InstancePackageImpl#getConnectionReference()
		 * @generated
		 */
		EClass CONNECTION_REFERENCE = eINSTANCE.getConnectionReference();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION_REFERENCE__CONTEXT = eINSTANCE.getConnectionReference_Context();

		/**
		 * The meta object literal for the '<em><b>Connection</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION_REFERENCE__CONNECTION = eINSTANCE.getConnectionReference_Connection();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION_REFERENCE__SOURCE = eINSTANCE.getConnectionReference_Source();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION_REFERENCE__DESTINATION = eINSTANCE.getConnectionReference_Destination();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.instance.impl.ComponentInstanceImpl <em>Component Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.instance.impl.ComponentInstanceImpl
		 * @see org.osate.aadl2.instance.impl.InstancePackageImpl#getComponentInstance()
		 * @generated
		 */
		EClass COMPONENT_INSTANCE = eINSTANCE.getComponentInstance();

		/**
		 * The meta object literal for the '<em><b>Feature Instance</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_INSTANCE__FEATURE_INSTANCE = eINSTANCE.getComponentInstance_FeatureInstance();

		/**
		 * The meta object literal for the '<em><b>Component Instance</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_INSTANCE__COMPONENT_INSTANCE = eINSTANCE.getComponentInstance_ComponentInstance();

		/**
		 * The meta object literal for the '<em><b>Subcomponent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_INSTANCE__SUBCOMPONENT = eINSTANCE.getComponentInstance_Subcomponent();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_INSTANCE__INDEX = eINSTANCE.getComponentInstance_Index();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.instance.impl.FlowSpecificationInstanceImpl <em>Flow Specification Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.instance.impl.FlowSpecificationInstanceImpl
		 * @see org.osate.aadl2.instance.impl.InstancePackageImpl#getFlowSpecificationInstance()
		 * @generated
		 */
		EClass FLOW_SPECIFICATION_INSTANCE = eINSTANCE.getFlowSpecificationInstance();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLOW_SPECIFICATION_INSTANCE__SOURCE = eINSTANCE.getFlowSpecificationInstance_Source();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLOW_SPECIFICATION_INSTANCE__DESTINATION = eINSTANCE.getFlowSpecificationInstance_Destination();

		/**
		 * The meta object literal for the '<em><b>Flow Specification</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLOW_SPECIFICATION_INSTANCE__FLOW_SPECIFICATION = eINSTANCE
				.getFlowSpecificationInstance_FlowSpecification();

		/**
		 * The meta object literal for the '<em><b>In Mode</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLOW_SPECIFICATION_INSTANCE__IN_MODE = eINSTANCE.getFlowSpecificationInstance_InMode();

		/**
		 * The meta object literal for the '<em><b>In Mode Transition</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLOW_SPECIFICATION_INSTANCE__IN_MODE_TRANSITION = eINSTANCE
				.getFlowSpecificationInstance_InModeTransition();

		/**
		 * The meta object literal for the '<em><b>Mode Instance</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_INSTANCE__MODE_INSTANCE = eINSTANCE.getComponentInstance_ModeInstance();

		/**
		 * The meta object literal for the '<em><b>Mode Transition Instance</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_INSTANCE__MODE_TRANSITION_INSTANCE = eINSTANCE
				.getComponentInstance_ModeTransitionInstance();

		/**
		 * The meta object literal for the '<em><b>Category</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_INSTANCE__CATEGORY = eINSTANCE.getComponentInstance_Category();

		/**
		 * The meta object literal for the '<em><b>In Mode</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_INSTANCE__IN_MODE = eINSTANCE.getComponentInstance_InMode();

		/**
		 * The meta object literal for the '<em><b>Flow Specification</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_INSTANCE__FLOW_SPECIFICATION = eINSTANCE.getComponentInstance_FlowSpecification();

		/**
		 * The meta object literal for the '<em><b>End To End Flow</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_INSTANCE__END_TO_END_FLOW = eINSTANCE.getComponentInstance_EndToEndFlow();

		/**
		 * The meta object literal for the '<em><b>Connection Instance</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_INSTANCE__CONNECTION_INSTANCE = eINSTANCE.getComponentInstance_ConnectionInstance();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.instance.impl.EndToEndFlowInstanceImpl <em>End To End Flow Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.instance.impl.EndToEndFlowInstanceImpl
		 * @see org.osate.aadl2.instance.impl.InstancePackageImpl#getEndToEndFlowInstance()
		 * @generated
		 */
		EClass END_TO_END_FLOW_INSTANCE = eINSTANCE.getEndToEndFlowInstance();

		/**
		 * The meta object literal for the '<em><b>Flow Element</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference END_TO_END_FLOW_INSTANCE__FLOW_ELEMENT = eINSTANCE.getEndToEndFlowInstance_FlowElement();

		/**
		 * The meta object literal for the '<em><b>In Mode</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference END_TO_END_FLOW_INSTANCE__IN_MODE = eINSTANCE.getEndToEndFlowInstance_InMode();

		/**
		 * The meta object literal for the '<em><b>End To End Flow</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference END_TO_END_FLOW_INSTANCE__END_TO_END_FLOW = eINSTANCE.getEndToEndFlowInstance_EndToEndFlow();

		/**
		 * The meta object literal for the '<em><b>In System Operation Mode</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference END_TO_END_FLOW_INSTANCE__IN_SYSTEM_OPERATION_MODE = eINSTANCE
				.getEndToEndFlowInstance_InSystemOperationMode();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.instance.impl.SystemInstanceImpl <em>System Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.instance.impl.SystemInstanceImpl
		 * @see org.osate.aadl2.instance.impl.InstancePackageImpl#getSystemInstance()
		 * @generated
		 */
		EClass SYSTEM_INSTANCE = eINSTANCE.getSystemInstance();

		/**
		 * The meta object literal for the '<em><b>System Operation Mode</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_INSTANCE__SYSTEM_OPERATION_MODE = eINSTANCE.getSystemInstance_SystemOperationMode();

		/**
		 * The meta object literal for the '<em><b>Component Implementation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_INSTANCE__COMPONENT_IMPLEMENTATION = eINSTANCE.getSystemInstance_ComponentImplementation();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.instance.impl.InstanceReferenceValueImpl <em>Reference Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.instance.impl.InstanceReferenceValueImpl
		 * @see org.osate.aadl2.instance.impl.InstancePackageImpl#getInstanceReferenceValue()
		 * @generated
		 */
		EClass INSTANCE_REFERENCE_VALUE = eINSTANCE.getInstanceReferenceValue();

		/**
		 * The meta object literal for the '<em><b>Referenced Instance Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANCE_REFERENCE_VALUE__REFERENCED_INSTANCE_OBJECT = eINSTANCE
				.getInstanceReferenceValue_ReferencedInstanceObject();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.instance.ConnectionKind <em>Connection Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.instance.ConnectionKind
		 * @see org.osate.aadl2.instance.impl.InstancePackageImpl#getConnectionKind()
		 * @generated
		 */
		EEnum CONNECTION_KIND = eINSTANCE.getConnectionKind();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.instance.FeatureCategory <em>Feature Category</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.instance.FeatureCategory
		 * @see org.osate.aadl2.instance.impl.InstancePackageImpl#getFeatureCategory()
		 * @generated
		 */
		EEnum FEATURE_CATEGORY = eINSTANCE.getFeatureCategory();

	}

} // InstancePackage
