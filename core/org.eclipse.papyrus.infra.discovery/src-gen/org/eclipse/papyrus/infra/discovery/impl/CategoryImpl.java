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
package org.eclipse.papyrus.infra.discovery.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.infra.discovery.Category;
import org.eclipse.papyrus.infra.discovery.DiscoveryPackage;
import org.eclipse.papyrus.infra.discovery.InstallableComponent;
import org.eclipse.papyrus.infra.discovery.Overview;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Category</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.discovery.impl.CategoryImpl#getName <em>Name</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.discovery.impl.CategoryImpl#getDescription <em>Description</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.discovery.impl.CategoryImpl#getComponents <em>Components</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.discovery.impl.CategoryImpl#getRelevance <em>Relevance</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.discovery.impl.CategoryImpl#getOverview <em>Overview</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.discovery.impl.CategoryImpl#getImage48 <em>Image48</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CategoryImpl extends MinimalEObjectImpl implements Category {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getComponents() <em>Components</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getComponents()
	 * @generated
	 * @ordered
	 */
	protected EList<InstallableComponent> components;

	/**
	 * The default value of the '{@link #getRelevance() <em>Relevance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getRelevance()
	 * @generated
	 * @ordered
	 */
	protected static final Integer RELEVANCE_EDEFAULT = new Integer(5);

	/**
	 * The cached value of the '{@link #getRelevance() <em>Relevance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getRelevance()
	 * @generated
	 * @ordered
	 */
	protected Integer relevance = RELEVANCE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOverview() <em>Overview</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getOverview()
	 * @generated
	 * @ordered
	 */
	protected Overview overview;

	/**
	 * The default value of the '{@link #getImage48() <em>Image48</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getImage48()
	 * @generated
	 * @ordered
	 */
	protected static final String IMAGE48_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImage48() <em>Image48</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getImage48()
	 * @generated
	 * @ordered
	 */
	protected String image48 = IMAGE48_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected CategoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiscoveryPackage.Literals.CATEGORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, DiscoveryPackage.CATEGORY__NAME, oldName, name));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, DiscoveryPackage.CATEGORY__DESCRIPTION, oldDescription, description));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EList<InstallableComponent> getComponents() {
		if (components == null) {
			components = new EObjectContainmentWithInverseEList<InstallableComponent>(InstallableComponent.class, this, DiscoveryPackage.CATEGORY__COMPONENTS, DiscoveryPackage.INSTALLABLE_COMPONENT__CATEGORY);
		}
		return components;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public Integer getRelevance() {
		return relevance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setRelevance(Integer newRelevance) {
		Integer oldRelevance = relevance;
		relevance = newRelevance;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, DiscoveryPackage.CATEGORY__RELEVANCE, oldRelevance, relevance));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public Overview getOverview() {
		return overview;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetOverview(Overview newOverview, NotificationChain msgs) {
		Overview oldOverview = overview;
		overview = newOverview;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiscoveryPackage.CATEGORY__OVERVIEW, oldOverview, newOverview);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setOverview(Overview newOverview) {
		if (newOverview != overview) {
			NotificationChain msgs = null;
			if (overview != null) {
				msgs = ((InternalEObject) overview).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiscoveryPackage.CATEGORY__OVERVIEW, null, msgs);
			}
			if (newOverview != null) {
				msgs = ((InternalEObject) newOverview).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiscoveryPackage.CATEGORY__OVERVIEW, null, msgs);
			}
			msgs = basicSetOverview(newOverview, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		}
		else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, DiscoveryPackage.CATEGORY__OVERVIEW, newOverview, newOverview));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public String getImage48() {
		return image48;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setImage48(String newImage48) {
		String oldImage48 = image48;
		image48 = newImage48;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, DiscoveryPackage.CATEGORY__IMAGE48, oldImage48, image48));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case DiscoveryPackage.CATEGORY__COMPONENTS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getComponents()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case DiscoveryPackage.CATEGORY__COMPONENTS:
			return ((InternalEList<?>) getComponents()).basicRemove(otherEnd, msgs);
		case DiscoveryPackage.CATEGORY__OVERVIEW:
			return basicSetOverview(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case DiscoveryPackage.CATEGORY__NAME:
			return getName();
		case DiscoveryPackage.CATEGORY__DESCRIPTION:
			return getDescription();
		case DiscoveryPackage.CATEGORY__COMPONENTS:
			return getComponents();
		case DiscoveryPackage.CATEGORY__RELEVANCE:
			return getRelevance();
		case DiscoveryPackage.CATEGORY__OVERVIEW:
			return getOverview();
		case DiscoveryPackage.CATEGORY__IMAGE48:
			return getImage48();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case DiscoveryPackage.CATEGORY__NAME:
			setName((String) newValue);
			return;
		case DiscoveryPackage.CATEGORY__DESCRIPTION:
			setDescription((String) newValue);
			return;
		case DiscoveryPackage.CATEGORY__COMPONENTS:
			getComponents().clear();
			getComponents().addAll((Collection<? extends InstallableComponent>) newValue);
			return;
		case DiscoveryPackage.CATEGORY__RELEVANCE:
			setRelevance((Integer) newValue);
			return;
		case DiscoveryPackage.CATEGORY__OVERVIEW:
			setOverview((Overview) newValue);
			return;
		case DiscoveryPackage.CATEGORY__IMAGE48:
			setImage48((String) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case DiscoveryPackage.CATEGORY__NAME:
			setName(NAME_EDEFAULT);
			return;
		case DiscoveryPackage.CATEGORY__DESCRIPTION:
			setDescription(DESCRIPTION_EDEFAULT);
			return;
		case DiscoveryPackage.CATEGORY__COMPONENTS:
			getComponents().clear();
			return;
		case DiscoveryPackage.CATEGORY__RELEVANCE:
			setRelevance(RELEVANCE_EDEFAULT);
			return;
		case DiscoveryPackage.CATEGORY__OVERVIEW:
			setOverview((Overview) null);
			return;
		case DiscoveryPackage.CATEGORY__IMAGE48:
			setImage48(IMAGE48_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case DiscoveryPackage.CATEGORY__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case DiscoveryPackage.CATEGORY__DESCRIPTION:
			return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
		case DiscoveryPackage.CATEGORY__COMPONENTS:
			return components != null && !components.isEmpty();
		case DiscoveryPackage.CATEGORY__RELEVANCE:
			return RELEVANCE_EDEFAULT == null ? relevance != null : !RELEVANCE_EDEFAULT.equals(relevance);
		case DiscoveryPackage.CATEGORY__OVERVIEW:
			return overview != null;
		case DiscoveryPackage.CATEGORY__IMAGE48:
			return IMAGE48_EDEFAULT == null ? image48 != null : !IMAGE48_EDEFAULT.equals(image48);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", description: ");
		result.append(description);
		result.append(", relevance: ");
		result.append(relevance);
		result.append(", image48: ");
		result.append(image48);
		result.append(')');
		return result.toString();
	}

} // CategoryImpl
