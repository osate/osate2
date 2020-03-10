/**
 */
package org.osate.xtext.aadl2.errormodel.EMV2Instance;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ECollection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.ECollection#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage#getECollection()
 * @model
 * @generated
 */
public interface ECollection extends Literal {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.EMV2Instance.Literal}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage#getECollection_Elements()
	 * @model containment="true"
	 * @generated
	 */
	EList<Literal> getElements();

} // ECollection
