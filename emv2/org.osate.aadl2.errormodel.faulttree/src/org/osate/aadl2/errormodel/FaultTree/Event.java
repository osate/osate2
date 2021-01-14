/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.aadl2.errormodel.FaultTree;

import java.math.BigDecimal;
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
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.Event#getMessage <em>Message</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.Event#getSubEvents <em>Sub Events</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.Event#getK <em>K</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.Event#getAssignedProbability <em>Assigned Probability</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.Event#getComputedProbability <em>Computed Probability</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.Event#getRelatedInstanceObject <em>Related Instance Object</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.Event#getRelatedErrorType <em>Related Error Type</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.Event#getReferenceCount <em>Reference Count</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.Event#getType <em>Type</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.Event#getSubEventLogic <em>Sub Event Logic</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.Event#getRelatedEMV2Object <em>Related EMV2 Object</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.Event#getScale <em>Scale</em>}</li>
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
	 * Returns the value of the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message</em>' attribute.
	 * @see #setMessage(String)
	 * @see org.osate.aadl2.errormodel.FaultTree.FaultTreePackage#getEvent_Message()
	 * @model
	 * @generated
	 */
	String getMessage();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.FaultTree.Event#getMessage <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' attribute.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(String value);

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
	 * Returns the value of the '<em><b>Assigned Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assigned Probability</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assigned Probability</em>' attribute.
	 * @see #setAssignedProbability(BigDecimal)
	 * @see org.osate.aadl2.errormodel.FaultTree.FaultTreePackage#getEvent_AssignedProbability()
	 * @model
	 * @generated
	 */
	BigDecimal getAssignedProbability();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.FaultTree.Event#getAssignedProbability <em>Assigned Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assigned Probability</em>' attribute.
	 * @see #getAssignedProbability()
	 * @generated
	 */
	void setAssignedProbability(BigDecimal value);

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Probability</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	BigDecimal getProbability();

	/**
	 * Returns the value of the '<em><b>Computed Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Computed Probability</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Computed Probability</em>' attribute.
	 * @see #setComputedProbability(BigDecimal)
	 * @see org.osate.aadl2.errormodel.FaultTree.FaultTreePackage#getEvent_ComputedProbability()
	 * @model
	 * @generated
	 */
	BigDecimal getComputedProbability();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.FaultTree.Event#getComputedProbability <em>Computed Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Computed Probability</em>' attribute.
	 * @see #getComputedProbability()
	 * @generated
	 */
	void setComputedProbability(BigDecimal value);

	/**
	 * Returns the value of the '<em><b>Related Instance Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Instance Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Instance Object</em>' reference.
	 * @see #setRelatedInstanceObject(EObject)
	 * @see org.osate.aadl2.errormodel.FaultTree.FaultTreePackage#getEvent_RelatedInstanceObject()
	 * @model
	 * @generated
	 */
	EObject getRelatedInstanceObject();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.FaultTree.Event#getRelatedInstanceObject <em>Related Instance Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Related Instance Object</em>' reference.
	 * @see #getRelatedInstanceObject()
	 * @generated
	 */
	void setRelatedInstanceObject(EObject value);

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

	/**
	 * Returns the value of the '<em><b>Related EMV2 Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related EMV2 Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related EMV2 Object</em>' reference.
	 * @see #setRelatedEMV2Object(EObject)
	 * @see org.osate.aadl2.errormodel.FaultTree.FaultTreePackage#getEvent_RelatedEMV2Object()
	 * @model
	 * @generated
	 */
	EObject getRelatedEMV2Object();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.FaultTree.Event#getRelatedEMV2Object <em>Related EMV2 Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Related EMV2 Object</em>' reference.
	 * @see #getRelatedEMV2Object()
	 * @generated
	 */
	void setRelatedEMV2Object(EObject value);

	/**
	 * Returns the value of the '<em><b>Scale</b></em>' attribute.
	 * The default value is <code>"1.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scale</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scale</em>' attribute.
	 * @see #setScale(BigDecimal)
	 * @see org.osate.aadl2.errormodel.FaultTree.FaultTreePackage#getEvent_Scale()
	 * @model default="1.0"
	 * @generated
	 */
	BigDecimal getScale();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.FaultTree.Event#getScale <em>Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scale</em>' attribute.
	 * @see #getScale()
	 * @generated
	 */
	void setScale(BigDecimal value);

	/**
	 * Returns the value of the '<em><b>Related Error Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Error Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Error Type</em>' reference.
	 * @see #setRelatedErrorType(EObject)
	 * @see org.osate.aadl2.errormodel.FaultTree.FaultTreePackage#getEvent_RelatedErrorType()
	 * @model
	 * @generated
	 */
	EObject getRelatedErrorType();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.FaultTree.Event#getRelatedErrorType <em>Related Error Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Related Error Type</em>' reference.
	 * @see #getRelatedErrorType()
	 * @generated
	 */
	void setRelatedErrorType(EObject value);

} // Event
