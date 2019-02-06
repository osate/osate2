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
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.infra.discovery.Category;
import org.eclipse.papyrus.infra.discovery.DiscoveryPackage;
import org.eclipse.papyrus.infra.discovery.Group;
import org.eclipse.papyrus.infra.discovery.InstallableComponent;
import org.eclipse.papyrus.infra.discovery.Message;
import org.eclipse.papyrus.infra.discovery.Overview;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Installable Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.discovery.impl.InstallableComponentImpl#getName <em>Name</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.discovery.impl.InstallableComponentImpl#getProvider <em>Provider</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.discovery.impl.InstallableComponentImpl#getSitesURLS <em>Sites URLS</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.discovery.impl.InstallableComponentImpl#getDescription <em>Description</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.discovery.impl.InstallableComponentImpl#getOverview <em>Overview</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.discovery.impl.InstallableComponentImpl#getCategory <em>Category</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.discovery.impl.InstallableComponentImpl#getId <em>Id</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.discovery.impl.InstallableComponentImpl#getLicense <em>License</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.discovery.impl.InstallableComponentImpl#isSelected <em>Selected</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.discovery.impl.InstallableComponentImpl#isAvailable <em>Available</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.discovery.impl.InstallableComponentImpl#isInstalled <em>Installed</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.discovery.impl.InstallableComponentImpl#getGroups <em>Groups</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.discovery.impl.InstallableComponentImpl#getImage32 <em>Image32</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.discovery.impl.InstallableComponentImpl#isIncubation <em>Incubation</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.discovery.impl.InstallableComponentImpl#getMessages <em>Messages</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.discovery.impl.InstallableComponentImpl#isVisible <em>Visible</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.discovery.impl.InstallableComponentImpl#getHiddingFeatureID <em>Hidding Feature ID</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InstallableComponentImpl extends MinimalEObjectImpl implements InstallableComponent {
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
	 * The default value of the '{@link #getProvider() <em>Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getProvider()
	 * @generated
	 * @ordered
	 */
	protected static final String PROVIDER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProvider() <em>Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getProvider()
	 * @generated
	 * @ordered
	 */
	protected String provider = PROVIDER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSitesURLS() <em>Sites URLS</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getSitesURLS()
	 * @generated
	 * @ordered
	 */
	protected EList<String> sitesURLS;

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
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected EList<String> id;

	/**
	 * The default value of the '{@link #getLicense() <em>License</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getLicense()
	 * @generated
	 * @ordered
	 */
	protected static final String LICENSE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLicense() <em>License</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getLicense()
	 * @generated
	 * @ordered
	 */
	protected String license = LICENSE_EDEFAULT;

	/**
	 * The default value of the '{@link #isSelected() <em>Selected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #isSelected()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SELECTED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSelected() <em>Selected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #isSelected()
	 * @generated
	 * @ordered
	 */
	protected boolean selected = SELECTED_EDEFAULT;

	/**
	 * The default value of the '{@link #isAvailable() <em>Available</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #isAvailable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean AVAILABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAvailable() <em>Available</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #isAvailable()
	 * @generated
	 * @ordered
	 */
	protected boolean available = AVAILABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #isInstalled() <em>Installed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #isInstalled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INSTALLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInstalled() <em>Installed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #isInstalled()
	 * @generated
	 * @ordered
	 */
	protected boolean installed = INSTALLED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getGroups() <em>Groups</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getGroups()
	 * @generated
	 * @ordered
	 */
	protected EList<Group> groups;

	/**
	 * The default value of the '{@link #getImage32() <em>Image32</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getImage32()
	 * @generated
	 * @ordered
	 */
	protected static final String IMAGE32_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImage32() <em>Image32</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getImage32()
	 * @generated
	 * @ordered
	 */
	protected String image32 = IMAGE32_EDEFAULT;

	/**
	 * The default value of the '{@link #isIncubation() <em>Incubation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #isIncubation()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INCUBATION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIncubation() <em>Incubation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #isIncubation()
	 * @generated
	 * @ordered
	 */
	protected boolean incubation = INCUBATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMessages() <em>Messages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getMessages()
	 * @generated
	 * @ordered
	 */
	protected EList<Message> messages;

	/**
	 * The default value of the '{@link #isVisible() <em>Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #isVisible()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VISIBLE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isVisible() <em>Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #isVisible()
	 * @generated
	 * @ordered
	 */
	protected boolean visible = VISIBLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getHiddingFeatureID() <em>Hidding Feature ID</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getHiddingFeatureID()
	 * @generated
	 * @ordered
	 */
	protected EList<String> hiddingFeatureID;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected InstallableComponentImpl() {
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
		return DiscoveryPackage.Literals.INSTALLABLE_COMPONENT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DiscoveryPackage.INSTALLABLE_COMPONENT__NAME, oldName, name));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public String getProvider() {
		return provider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setProvider(String newProvider) {
		String oldProvider = provider;
		provider = newProvider;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, DiscoveryPackage.INSTALLABLE_COMPONENT__PROVIDER, oldProvider, provider));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EList<String> getSitesURLS() {
		if (sitesURLS == null) {
			sitesURLS = new EDataTypeUniqueEList<String>(String.class, this, DiscoveryPackage.INSTALLABLE_COMPONENT__SITES_URLS);
		}
		return sitesURLS;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DiscoveryPackage.INSTALLABLE_COMPONENT__DESCRIPTION, oldDescription, description));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiscoveryPackage.INSTALLABLE_COMPONENT__OVERVIEW, oldOverview, newOverview);
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
				msgs = ((InternalEObject) overview).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiscoveryPackage.INSTALLABLE_COMPONENT__OVERVIEW, null, msgs);
			}
			if (newOverview != null) {
				msgs = ((InternalEObject) newOverview).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiscoveryPackage.INSTALLABLE_COMPONENT__OVERVIEW, null, msgs);
			}
			msgs = basicSetOverview(newOverview, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		}
		else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, DiscoveryPackage.INSTALLABLE_COMPONENT__OVERVIEW, newOverview, newOverview));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public Category getCategory() {
		if (eContainerFeatureID() != DiscoveryPackage.INSTALLABLE_COMPONENT__CATEGORY) {
			return null;
		}
		return (Category) eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetCategory(Category newCategory, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newCategory, DiscoveryPackage.INSTALLABLE_COMPONENT__CATEGORY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setCategory(Category newCategory) {
		if (newCategory != eInternalContainer() || (eContainerFeatureID() != DiscoveryPackage.INSTALLABLE_COMPONENT__CATEGORY && newCategory != null)) {
			if (EcoreUtil.isAncestor(this, newCategory)) {
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			}
			NotificationChain msgs = null;
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			if (newCategory != null) {
				msgs = ((InternalEObject) newCategory).eInverseAdd(this, DiscoveryPackage.CATEGORY__COMPONENTS, Category.class, msgs);
			}
			msgs = basicSetCategory(newCategory, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		}
		else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, DiscoveryPackage.INSTALLABLE_COMPONENT__CATEGORY, newCategory, newCategory));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EList<String> getId() {
		if (id == null) {
			id = new EDataTypeUniqueEList<String>(String.class, this, DiscoveryPackage.INSTALLABLE_COMPONENT__ID);
		}
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public String getLicense() {
		return license;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setLicense(String newLicense) {
		String oldLicense = license;
		license = newLicense;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, DiscoveryPackage.INSTALLABLE_COMPONENT__LICENSE, oldLicense, license));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean isSelected() {
		return selected;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setSelected(boolean newSelected) {
		boolean oldSelected = selected;
		selected = newSelected;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, DiscoveryPackage.INSTALLABLE_COMPONENT__SELECTED, oldSelected, selected));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean isAvailable() {
		return available;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setAvailable(boolean newAvailable) {
		boolean oldAvailable = available;
		available = newAvailable;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, DiscoveryPackage.INSTALLABLE_COMPONENT__AVAILABLE, oldAvailable, available));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean isInstalled() {
		return installed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setInstalled(boolean newInstalled) {
		boolean oldInstalled = installed;
		installed = newInstalled;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, DiscoveryPackage.INSTALLABLE_COMPONENT__INSTALLED, oldInstalled, installed));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EList<Group> getGroups() {
		if (groups == null) {
			groups = new EObjectResolvingEList<Group>(Group.class, this, DiscoveryPackage.INSTALLABLE_COMPONENT__GROUPS);
		}
		return groups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public String getImage32() {
		return image32;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setImage32(String newImage32) {
		String oldImage32 = image32;
		image32 = newImage32;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, DiscoveryPackage.INSTALLABLE_COMPONENT__IMAGE32, oldImage32, image32));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean isIncubation() {
		return incubation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setIncubation(boolean newIncubation) {
		boolean oldIncubation = incubation;
		incubation = newIncubation;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, DiscoveryPackage.INSTALLABLE_COMPONENT__INCUBATION, oldIncubation, incubation));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EList<Message> getMessages() {
		if (messages == null) {
			messages = new EObjectContainmentEList<Message>(Message.class, this, DiscoveryPackage.INSTALLABLE_COMPONENT__MESSAGES);
		}
		return messages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean isVisible() {
		return visible;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setVisible(boolean newVisible) {
		boolean oldVisible = visible;
		visible = newVisible;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, DiscoveryPackage.INSTALLABLE_COMPONENT__VISIBLE, oldVisible, visible));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EList<String> getHiddingFeatureID() {
		if (hiddingFeatureID == null) {
			hiddingFeatureID = new EDataTypeUniqueEList<String>(String.class, this, DiscoveryPackage.INSTALLABLE_COMPONENT__HIDDING_FEATURE_ID);
		}
		return hiddingFeatureID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case DiscoveryPackage.INSTALLABLE_COMPONENT__CATEGORY:
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			return basicSetCategory((Category) otherEnd, msgs);
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
		case DiscoveryPackage.INSTALLABLE_COMPONENT__OVERVIEW:
			return basicSetOverview(null, msgs);
		case DiscoveryPackage.INSTALLABLE_COMPONENT__CATEGORY:
			return basicSetCategory(null, msgs);
		case DiscoveryPackage.INSTALLABLE_COMPONENT__MESSAGES:
			return ((InternalEList<?>) getMessages()).basicRemove(otherEnd, msgs);
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
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case DiscoveryPackage.INSTALLABLE_COMPONENT__CATEGORY:
			return eInternalContainer().eInverseRemove(this, DiscoveryPackage.CATEGORY__COMPONENTS, Category.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
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
		case DiscoveryPackage.INSTALLABLE_COMPONENT__NAME:
			return getName();
		case DiscoveryPackage.INSTALLABLE_COMPONENT__PROVIDER:
			return getProvider();
		case DiscoveryPackage.INSTALLABLE_COMPONENT__SITES_URLS:
			return getSitesURLS();
		case DiscoveryPackage.INSTALLABLE_COMPONENT__DESCRIPTION:
			return getDescription();
		case DiscoveryPackage.INSTALLABLE_COMPONENT__OVERVIEW:
			return getOverview();
		case DiscoveryPackage.INSTALLABLE_COMPONENT__CATEGORY:
			return getCategory();
		case DiscoveryPackage.INSTALLABLE_COMPONENT__ID:
			return getId();
		case DiscoveryPackage.INSTALLABLE_COMPONENT__LICENSE:
			return getLicense();
		case DiscoveryPackage.INSTALLABLE_COMPONENT__SELECTED:
			return isSelected();
		case DiscoveryPackage.INSTALLABLE_COMPONENT__AVAILABLE:
			return isAvailable();
		case DiscoveryPackage.INSTALLABLE_COMPONENT__INSTALLED:
			return isInstalled();
		case DiscoveryPackage.INSTALLABLE_COMPONENT__GROUPS:
			return getGroups();
		case DiscoveryPackage.INSTALLABLE_COMPONENT__IMAGE32:
			return getImage32();
		case DiscoveryPackage.INSTALLABLE_COMPONENT__INCUBATION:
			return isIncubation();
		case DiscoveryPackage.INSTALLABLE_COMPONENT__MESSAGES:
			return getMessages();
		case DiscoveryPackage.INSTALLABLE_COMPONENT__VISIBLE:
			return isVisible();
		case DiscoveryPackage.INSTALLABLE_COMPONENT__HIDDING_FEATURE_ID:
			return getHiddingFeatureID();
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
		case DiscoveryPackage.INSTALLABLE_COMPONENT__NAME:
			setName((String) newValue);
			return;
		case DiscoveryPackage.INSTALLABLE_COMPONENT__PROVIDER:
			setProvider((String) newValue);
			return;
		case DiscoveryPackage.INSTALLABLE_COMPONENT__SITES_URLS:
			getSitesURLS().clear();
			getSitesURLS().addAll((Collection<? extends String>) newValue);
			return;
		case DiscoveryPackage.INSTALLABLE_COMPONENT__DESCRIPTION:
			setDescription((String) newValue);
			return;
		case DiscoveryPackage.INSTALLABLE_COMPONENT__OVERVIEW:
			setOverview((Overview) newValue);
			return;
		case DiscoveryPackage.INSTALLABLE_COMPONENT__CATEGORY:
			setCategory((Category) newValue);
			return;
		case DiscoveryPackage.INSTALLABLE_COMPONENT__ID:
			getId().clear();
			getId().addAll((Collection<? extends String>) newValue);
			return;
		case DiscoveryPackage.INSTALLABLE_COMPONENT__LICENSE:
			setLicense((String) newValue);
			return;
		case DiscoveryPackage.INSTALLABLE_COMPONENT__SELECTED:
			setSelected((Boolean) newValue);
			return;
		case DiscoveryPackage.INSTALLABLE_COMPONENT__AVAILABLE:
			setAvailable((Boolean) newValue);
			return;
		case DiscoveryPackage.INSTALLABLE_COMPONENT__INSTALLED:
			setInstalled((Boolean) newValue);
			return;
		case DiscoveryPackage.INSTALLABLE_COMPONENT__GROUPS:
			getGroups().clear();
			getGroups().addAll((Collection<? extends Group>) newValue);
			return;
		case DiscoveryPackage.INSTALLABLE_COMPONENT__IMAGE32:
			setImage32((String) newValue);
			return;
		case DiscoveryPackage.INSTALLABLE_COMPONENT__INCUBATION:
			setIncubation((Boolean) newValue);
			return;
		case DiscoveryPackage.INSTALLABLE_COMPONENT__MESSAGES:
			getMessages().clear();
			getMessages().addAll((Collection<? extends Message>) newValue);
			return;
		case DiscoveryPackage.INSTALLABLE_COMPONENT__VISIBLE:
			setVisible((Boolean) newValue);
			return;
		case DiscoveryPackage.INSTALLABLE_COMPONENT__HIDDING_FEATURE_ID:
			getHiddingFeatureID().clear();
			getHiddingFeatureID().addAll((Collection<? extends String>) newValue);
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
		case DiscoveryPackage.INSTALLABLE_COMPONENT__NAME:
			setName(NAME_EDEFAULT);
			return;
		case DiscoveryPackage.INSTALLABLE_COMPONENT__PROVIDER:
			setProvider(PROVIDER_EDEFAULT);
			return;
		case DiscoveryPackage.INSTALLABLE_COMPONENT__SITES_URLS:
			getSitesURLS().clear();
			return;
		case DiscoveryPackage.INSTALLABLE_COMPONENT__DESCRIPTION:
			setDescription(DESCRIPTION_EDEFAULT);
			return;
		case DiscoveryPackage.INSTALLABLE_COMPONENT__OVERVIEW:
			setOverview((Overview) null);
			return;
		case DiscoveryPackage.INSTALLABLE_COMPONENT__CATEGORY:
			setCategory((Category) null);
			return;
		case DiscoveryPackage.INSTALLABLE_COMPONENT__ID:
			getId().clear();
			return;
		case DiscoveryPackage.INSTALLABLE_COMPONENT__LICENSE:
			setLicense(LICENSE_EDEFAULT);
			return;
		case DiscoveryPackage.INSTALLABLE_COMPONENT__SELECTED:
			setSelected(SELECTED_EDEFAULT);
			return;
		case DiscoveryPackage.INSTALLABLE_COMPONENT__AVAILABLE:
			setAvailable(AVAILABLE_EDEFAULT);
			return;
		case DiscoveryPackage.INSTALLABLE_COMPONENT__INSTALLED:
			setInstalled(INSTALLED_EDEFAULT);
			return;
		case DiscoveryPackage.INSTALLABLE_COMPONENT__GROUPS:
			getGroups().clear();
			return;
		case DiscoveryPackage.INSTALLABLE_COMPONENT__IMAGE32:
			setImage32(IMAGE32_EDEFAULT);
			return;
		case DiscoveryPackage.INSTALLABLE_COMPONENT__INCUBATION:
			setIncubation(INCUBATION_EDEFAULT);
			return;
		case DiscoveryPackage.INSTALLABLE_COMPONENT__MESSAGES:
			getMessages().clear();
			return;
		case DiscoveryPackage.INSTALLABLE_COMPONENT__VISIBLE:
			setVisible(VISIBLE_EDEFAULT);
			return;
		case DiscoveryPackage.INSTALLABLE_COMPONENT__HIDDING_FEATURE_ID:
			getHiddingFeatureID().clear();
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
		case DiscoveryPackage.INSTALLABLE_COMPONENT__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case DiscoveryPackage.INSTALLABLE_COMPONENT__PROVIDER:
			return PROVIDER_EDEFAULT == null ? provider != null : !PROVIDER_EDEFAULT.equals(provider);
		case DiscoveryPackage.INSTALLABLE_COMPONENT__SITES_URLS:
			return sitesURLS != null && !sitesURLS.isEmpty();
		case DiscoveryPackage.INSTALLABLE_COMPONENT__DESCRIPTION:
			return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
		case DiscoveryPackage.INSTALLABLE_COMPONENT__OVERVIEW:
			return overview != null;
		case DiscoveryPackage.INSTALLABLE_COMPONENT__CATEGORY:
			return getCategory() != null;
		case DiscoveryPackage.INSTALLABLE_COMPONENT__ID:
			return id != null && !id.isEmpty();
		case DiscoveryPackage.INSTALLABLE_COMPONENT__LICENSE:
			return LICENSE_EDEFAULT == null ? license != null : !LICENSE_EDEFAULT.equals(license);
		case DiscoveryPackage.INSTALLABLE_COMPONENT__SELECTED:
			return selected != SELECTED_EDEFAULT;
		case DiscoveryPackage.INSTALLABLE_COMPONENT__AVAILABLE:
			return available != AVAILABLE_EDEFAULT;
		case DiscoveryPackage.INSTALLABLE_COMPONENT__INSTALLED:
			return installed != INSTALLED_EDEFAULT;
		case DiscoveryPackage.INSTALLABLE_COMPONENT__GROUPS:
			return groups != null && !groups.isEmpty();
		case DiscoveryPackage.INSTALLABLE_COMPONENT__IMAGE32:
			return IMAGE32_EDEFAULT == null ? image32 != null : !IMAGE32_EDEFAULT.equals(image32);
		case DiscoveryPackage.INSTALLABLE_COMPONENT__INCUBATION:
			return incubation != INCUBATION_EDEFAULT;
		case DiscoveryPackage.INSTALLABLE_COMPONENT__MESSAGES:
			return messages != null && !messages.isEmpty();
		case DiscoveryPackage.INSTALLABLE_COMPONENT__VISIBLE:
			return visible != VISIBLE_EDEFAULT;
		case DiscoveryPackage.INSTALLABLE_COMPONENT__HIDDING_FEATURE_ID:
			return hiddingFeatureID != null && !hiddingFeatureID.isEmpty();
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
		result.append(", provider: ");
		result.append(provider);
		result.append(", sitesURLS: ");
		result.append(sitesURLS);
		result.append(", description: ");
		result.append(description);
		result.append(", id: ");
		result.append(id);
		result.append(", license: ");
		result.append(license);
		result.append(", selected: ");
		result.append(selected);
		result.append(", available: ");
		result.append(available);
		result.append(", installed: ");
		result.append(installed);
		result.append(", image32: ");
		result.append(image32);
		result.append(", incubation: ");
		result.append(incubation);
		result.append(", visible: ");
		result.append(visible);
		result.append(", hiddingFeatureID: ");
		result.append(hiddingFeatureID);
		result.append(')');
		return result.toString();
	}

} // InstallableComponentImpl
