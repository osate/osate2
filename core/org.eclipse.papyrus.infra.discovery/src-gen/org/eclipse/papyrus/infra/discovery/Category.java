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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Category</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.discovery.Category#getName <em>Name</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.discovery.Category#getDescription <em>Description</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.discovery.Category#getComponents <em>Components</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.discovery.Category#getRelevance <em>Relevance</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.discovery.Category#getOverview <em>Overview</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.discovery.Category#getImage48 <em>Image48</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.discovery.DiscoveryPackage#getCategory()
 * @model
 * @generated
 */
public interface Category extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.papyrus.infra.discovery.DiscoveryPackage#getCategory_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.discovery.Category#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.eclipse.papyrus.infra.discovery.DiscoveryPackage#getCategory_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.discovery.Category#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Components</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.discovery.InstallableComponent}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.infra.discovery.InstallableComponent#getCategory <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Components</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Components</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.discovery.DiscoveryPackage#getCategory_Components()
	 * @see org.eclipse.papyrus.infra.discovery.InstallableComponent#getCategory
	 * @model opposite="category" containment="true" keys="name"
	 * @generated
	 */
	EList<InstallableComponent> getComponents();

	/**
	 * Returns the value of the '<em><b>Relevance</b></em>' attribute.
	 * The default value is <code>"5"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relevance</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Relevance</em>' attribute.
	 * @see #setRelevance(Integer)
	 * @see org.eclipse.papyrus.infra.discovery.DiscoveryPackage#getCategory_Relevance()
	 * @model default="5" required="true"
	 * @generated
	 */
	Integer getRelevance();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.discovery.Category#getRelevance <em>Relevance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Relevance</em>' attribute.
	 * @see #getRelevance()
	 * @generated
	 */
	void setRelevance(Integer value);

	/**
	 * Returns the value of the '<em><b>Overview</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overview</em>' containment reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Overview</em>' containment reference.
	 * @see #setOverview(Overview)
	 * @see org.eclipse.papyrus.infra.discovery.DiscoveryPackage#getCategory_Overview()
	 * @model containment="true"
	 * @generated
	 */
	Overview getOverview();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.discovery.Category#getOverview <em>Overview</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Overview</em>' containment reference.
	 * @see #getOverview()
	 * @generated
	 */
	void setOverview(Overview value);

	/**
	 * Returns the value of the '<em><b>Image48</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Image48</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Image48</em>' attribute.
	 * @see #setImage48(String)
	 * @see org.eclipse.papyrus.infra.discovery.DiscoveryPackage#getCategory_Image48()
	 * @model
	 * @generated
	 */
	String getImage48();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.discovery.Category#getImage48 <em>Image48</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Image48</em>' attribute.
	 * @see #getImage48()
	 * @generated
	 */
	void setImage48(String value);

} // Category
