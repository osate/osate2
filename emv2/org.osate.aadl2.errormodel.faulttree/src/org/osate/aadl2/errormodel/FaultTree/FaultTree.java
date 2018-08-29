/**
 */
package org.osate.aadl2.errormodel.FaultTree;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fault Tree</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.FaultTree#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.FaultTree#getMessage <em>Message</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.FaultTree#getFaultTreeType <em>Fault Tree Type</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.FaultTree#getRoot <em>Root</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.FaultTree#getInstanceRoot <em>Instance Root</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.FaultTree#getEvents <em>Events</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.errormodel.FaultTree.FaultTreePackage#getFaultTree()
 * @model
 * @generated
 */
public interface FaultTree extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.osate.aadl2.errormodel.FaultTree.FaultTreePackage#getFaultTree_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.FaultTree.FaultTree#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message</em>' attribute.
	 * @see #setMessage(String)
	 * @see org.osate.aadl2.errormodel.FaultTree.FaultTreePackage#getFaultTree_Message()
	 * @model
	 * @generated
	 */
	String getMessage();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.FaultTree.FaultTree#getMessage <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' attribute.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(String value);

	/**
	 * Returns the value of the '<em><b>Fault Tree Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.osate.aadl2.errormodel.FaultTree.FaultTreeType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault Tree Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault Tree Type</em>' attribute.
	 * @see org.osate.aadl2.errormodel.FaultTree.FaultTreeType
	 * @see #setFaultTreeType(FaultTreeType)
	 * @see org.osate.aadl2.errormodel.FaultTree.FaultTreePackage#getFaultTree_FaultTreeType()
	 * @model
	 * @generated
	 */
	FaultTreeType getFaultTreeType();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.FaultTree.FaultTree#getFaultTreeType <em>Fault Tree Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault Tree Type</em>' attribute.
	 * @see org.osate.aadl2.errormodel.FaultTree.FaultTreeType
	 * @see #getFaultTreeType()
	 * @generated
	 */
	void setFaultTreeType(FaultTreeType value);

	/**
	 * Returns the value of the '<em><b>Events</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.errormodel.FaultTree.Event}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Events</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Events</em>' containment reference list.
	 * @see org.osate.aadl2.errormodel.FaultTree.FaultTreePackage#getFaultTree_Events()
	 * @model containment="true"
	 * @generated
	 */
	EList<Event> getEvents();

	/**
	 * Returns the value of the '<em><b>Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root</em>' reference.
	 * @see #setRoot(Event)
	 * @see org.osate.aadl2.errormodel.FaultTree.FaultTreePackage#getFaultTree_Root()
	 * @model
	 * @generated
	 */
	Event getRoot();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.FaultTree.FaultTree#getRoot <em>Root</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root</em>' reference.
	 * @see #getRoot()
	 * @generated
	 */
	void setRoot(Event value);

	/**
	 * Returns the value of the '<em><b>Instance Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instance Root</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance Root</em>' reference.
	 * @see #setInstanceRoot(EObject)
	 * @see org.osate.aadl2.errormodel.FaultTree.FaultTreePackage#getFaultTree_InstanceRoot()
	 * @model
	 * @generated
	 */
	EObject getInstanceRoot();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.FaultTree.FaultTree#getInstanceRoot <em>Instance Root</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance Root</em>' reference.
	 * @see #getInstanceRoot()
	 * @generated
	 */
	void setInstanceRoot(EObject value);

} // FaultTree
