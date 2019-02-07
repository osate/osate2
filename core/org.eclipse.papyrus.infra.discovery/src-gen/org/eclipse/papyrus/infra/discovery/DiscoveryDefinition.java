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
 * A representation of the model object '<em><b>Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.discovery.DiscoveryDefinition#getCategories <em>Categories</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.discovery.DiscoveryDefinition#getFilters <em>Filters</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.discovery.DiscoveryPackage#getDiscoveryDefinition()
 * @model
 * @generated
 */
public interface DiscoveryDefinition extends EObject {
	/**
	 * Returns the value of the '<em><b>Categories</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.discovery.Category}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Categories</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Categories</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.discovery.DiscoveryPackage#getDiscoveryDefinition_Categories()
	 * @model containment="true" keys="name"
	 * @generated
	 */
	EList<Category> getCategories();

	/**
	 * Returns the value of the '<em><b>Filters</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.discovery.Group}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filters</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Filters</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.discovery.DiscoveryPackage#getDiscoveryDefinition_Filters()
	 * @model containment="true"
	 * @generated
	 */
	EList<Group> getFilters();

} // DiscoveryDefinition
