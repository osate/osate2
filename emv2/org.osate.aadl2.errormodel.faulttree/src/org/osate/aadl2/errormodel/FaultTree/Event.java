/**
 */
package org.osate.aadl2.errormodel.FaultTree;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.Event#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.Event#getDescription <em>Description</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.Event#getSubEvents <em>Sub Events</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.Event#getK <em>K</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.Event#getProbability <em>Probability</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.Event#getRelatedObject <em>Related Object</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.Event#getReferenceCount <em>Reference Count</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.Event#getType <em>Type</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.Event#getSubEventLogic <em>Sub Event Logic</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.errormodel.FaultTree.FaultTreePackage#getEvent()
 * @model
 * @generated
 */
public interface Event extends EObject {
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
	 * @see org.osate.aadl2.errormodel.FaultTree.FaultTreePackage#getEvent_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.FaultTree.Event#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.osate.aadl2.errormodel.FaultTree.FaultTreePackage#getEvent_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.FaultTree.Event#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Sub Events</b></em>' reference list.
	 * The list contents are of type {@link org.osate.aadl2.errormodel.FaultTree.Event}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Events</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Events</em>' reference list.
	 * @see org.osate.aadl2.errormodel.FaultTree.FaultTreePackage#getEvent_SubEvents()
	 * @model
	 * @generated
	 */
	EList<Event> getSubEvents();

	/**
	 * Returns the value of the '<em><b>K</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>K</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>K</em>' attribute.
	 * @see #setK(int)
	 * @see org.osate.aadl2.errormodel.FaultTree.FaultTreePackage#getEvent_K()
	 * @model default="1"
	 * @generated
	 */
	int getK();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.FaultTree.Event#getK <em>K</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>K</em>' attribute.
	 * @see #getK()
	 * @generated
	 */
	void setK(int value);

	/**
	 * Returns the value of the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Probability</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Probability</em>' attribute.
	 * @see #setProbability(double)
	 * @see org.osate.aadl2.errormodel.FaultTree.FaultTreePackage#getEvent_Probability()
	 * @model
	 * @generated
	 */
	double getProbability();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.FaultTree.Event#getProbability <em>Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Probability</em>' attribute.
	 * @see #getProbability()
	 * @generated
	 */
	void setProbability(double value);

	/**
	 * Returns the value of the '<em><b>Related Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Object</em>' reference.
	 * @see #setRelatedObject(EObject)
	 * @see org.osate.aadl2.errormodel.FaultTree.FaultTreePackage#getEvent_RelatedObject()
	 * @model
	 * @generated
	 */
	EObject getRelatedObject();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.FaultTree.Event#getRelatedObject <em>Related Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Related Object</em>' reference.
	 * @see #getRelatedObject()
	 * @generated
	 */
	void setRelatedObject(EObject value);

	/**
	 * Returns the value of the '<em><b>Reference Count</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference Count</em>' attribute.
	 * @see #setReferenceCount(int)
	 * @see org.osate.aadl2.errormodel.FaultTree.FaultTreePackage#getEvent_ReferenceCount()
	 * @model default="0"
	 * @generated
	 */
	int getReferenceCount();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.FaultTree.Event#getReferenceCount <em>Reference Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference Count</em>' attribute.
	 * @see #getReferenceCount()
	 * @generated
	 */
	void setReferenceCount(int value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.osate.aadl2.errormodel.FaultTree.EventType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.osate.aadl2.errormodel.FaultTree.EventType
	 * @see #setType(EventType)
	 * @see org.osate.aadl2.errormodel.FaultTree.FaultTreePackage#getEvent_Type()
	 * @model
	 * @generated
	 */
	EventType getType();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.FaultTree.Event#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.osate.aadl2.errormodel.FaultTree.EventType
	 * @see #getType()
	 * @generated
	 */
	void setType(EventType value);

	/**
	 * Returns the value of the '<em><b>Sub Event Logic</b></em>' attribute.
	 * The literals are from the enumeration {@link org.osate.aadl2.errormodel.FaultTree.LogicOperation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Event Logic</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Event Logic</em>' attribute.
	 * @see org.osate.aadl2.errormodel.FaultTree.LogicOperation
	 * @see #setSubEventLogic(LogicOperation)
	 * @see org.osate.aadl2.errormodel.FaultTree.FaultTreePackage#getEvent_SubEventLogic()
	 * @model
	 * @generated
	 */
	LogicOperation getSubEventLogic();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.FaultTree.Event#getSubEventLogic <em>Sub Event Logic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub Event Logic</em>' attribute.
	 * @see org.osate.aadl2.errormodel.FaultTree.LogicOperation
	 * @see #getSubEventLogic()
	 * @generated
	 */
	void setSubEventLogic(LogicOperation value);

} // Event
