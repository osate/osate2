/**
 *
 *   Copyright (c)  2012 CEA LIST.
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 *
 *   Contributors:
 *       CEA LIST - initial API and implementation
 *
 */
package org.eclipse.papyrus.infra.discovery;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Message</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.discovery.Message#getTitle <em>Title</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.discovery.Message#getMessage <em>Message</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.discovery.Message#getIcon <em>Icon</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.discovery.DiscoveryPackage#getMessage()
 * @model
 * @generated
 */
public interface Message extends EObject {
	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see org.eclipse.papyrus.infra.discovery.DiscoveryPackage#getMessage_Title()
	 * @model required="true"
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.discovery.Message#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Message</em>' attribute.
	 * @see #setMessage(String)
	 * @see org.eclipse.papyrus.infra.discovery.DiscoveryPackage#getMessage_Message()
	 * @model required="true"
	 * @generated
	 */
	String getMessage();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.discovery.Message#getMessage <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Message</em>' attribute.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(String value);

	/**
	 * Returns the value of the '<em><b>Icon</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.infra.discovery.Severity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Icon</em>' attribute.
	 * @see org.eclipse.papyrus.infra.discovery.Severity
	 * @see #setIcon(Severity)
	 * @see org.eclipse.papyrus.infra.discovery.DiscoveryPackage#getMessage_Icon()
	 * @model required="true"
	 * @generated
	 */
	Severity getIcon();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.discovery.Message#getIcon <em>Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Icon</em>' attribute.
	 * @see org.eclipse.papyrus.infra.discovery.Severity
	 * @see #getIcon()
	 * @generated
	 */
	void setIcon(Severity value);

} // Message
