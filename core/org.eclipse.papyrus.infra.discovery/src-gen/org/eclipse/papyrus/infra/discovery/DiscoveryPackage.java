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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 *
 * @see org.eclipse.papyrus.infra.discovery.DiscoveryFactory
 * @model kind="package"
 * @generated
 */
public interface DiscoveryPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	String eNAME = "discovery";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/discovery/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	String eNS_PREFIX = "discovery";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	DiscoveryPackage eINSTANCE = org.eclipse.papyrus.infra.discovery.impl.DiscoveryPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.discovery.impl.InstallableComponentImpl <em>Installable Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.eclipse.papyrus.infra.discovery.impl.InstallableComponentImpl
	 * @see org.eclipse.papyrus.infra.discovery.impl.DiscoveryPackageImpl#getInstallableComponent()
	 * @generated
	 */
	int INSTALLABLE_COMPONENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_COMPONENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_COMPONENT__PROVIDER = 1;

	/**
	 * The feature id for the '<em><b>Sites URLS</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_COMPONENT__SITES_URLS = 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_COMPONENT__DESCRIPTION = 3;

	/**
	 * The feature id for the '<em><b>Overview</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_COMPONENT__OVERVIEW = 4;

	/**
	 * The feature id for the '<em><b>Category</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_COMPONENT__CATEGORY = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_COMPONENT__ID = 6;

	/**
	 * The feature id for the '<em><b>License</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_COMPONENT__LICENSE = 7;

	/**
	 * The feature id for the '<em><b>Selected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_COMPONENT__SELECTED = 8;

	/**
	 * The feature id for the '<em><b>Available</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_COMPONENT__AVAILABLE = 9;

	/**
	 * The feature id for the '<em><b>Installed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_COMPONENT__INSTALLED = 10;

	/**
	 * The feature id for the '<em><b>Groups</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_COMPONENT__GROUPS = 11;

	/**
	 * The feature id for the '<em><b>Image32</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_COMPONENT__IMAGE32 = 12;

	/**
	 * The feature id for the '<em><b>Incubation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_COMPONENT__INCUBATION = 13;

	/**
	 * The feature id for the '<em><b>Messages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_COMPONENT__MESSAGES = 14;

	/**
	 * The feature id for the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_COMPONENT__VISIBLE = 15;

	/**
	 * The feature id for the '<em><b>Hidding Feature ID</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_COMPONENT__HIDDING_FEATURE_ID = 16;

	/**
	 * The number of structural features of the '<em>Installable Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_COMPONENT_FEATURE_COUNT = 17;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.discovery.impl.OverviewImpl <em>Overview</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.eclipse.papyrus.infra.discovery.impl.OverviewImpl
	 * @see org.eclipse.papyrus.infra.discovery.impl.DiscoveryPackageImpl#getOverview()
	 * @generated
	 */
	int OVERVIEW = 1;

	/**
	 * The feature id for the '<em><b>Summary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int OVERVIEW__SUMMARY = 0;

	/**
	 * The feature id for the '<em><b>Screenshot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int OVERVIEW__SCREENSHOT = 1;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int OVERVIEW__URL = 2;

	/**
	 * The number of structural features of the '<em>Overview</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int OVERVIEW_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.discovery.impl.CategoryImpl <em>Category</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.eclipse.papyrus.infra.discovery.impl.CategoryImpl
	 * @see org.eclipse.papyrus.infra.discovery.impl.DiscoveryPackageImpl#getCategory()
	 * @generated
	 */
	int CATEGORY = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int CATEGORY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int CATEGORY__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Components</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int CATEGORY__COMPONENTS = 2;

	/**
	 * The feature id for the '<em><b>Relevance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int CATEGORY__RELEVANCE = 3;

	/**
	 * The feature id for the '<em><b>Overview</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int CATEGORY__OVERVIEW = 4;

	/**
	 * The feature id for the '<em><b>Image48</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int CATEGORY__IMAGE48 = 5;

	/**
	 * The number of structural features of the '<em>Category</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int CATEGORY_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.discovery.impl.DiscoveryDefinitionImpl <em>Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.eclipse.papyrus.infra.discovery.impl.DiscoveryDefinitionImpl
	 * @see org.eclipse.papyrus.infra.discovery.impl.DiscoveryPackageImpl#getDiscoveryDefinition()
	 * @generated
	 */
	int DISCOVERY_DEFINITION = 3;

	/**
	 * The feature id for the '<em><b>Categories</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DISCOVERY_DEFINITION__CATEGORIES = 0;

	/**
	 * The feature id for the '<em><b>Filters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DISCOVERY_DEFINITION__FILTERS = 1;

	/**
	 * The number of structural features of the '<em>Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DISCOVERY_DEFINITION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.discovery.impl.GroupImpl <em>Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.eclipse.papyrus.infra.discovery.impl.GroupImpl
	 * @see org.eclipse.papyrus.infra.discovery.impl.DiscoveryPackageImpl#getGroup()
	 * @generated
	 */
	int GROUP = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int GROUP__NAME = 0;

	/**
	 * The number of structural features of the '<em>Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int GROUP_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.discovery.impl.MessageImpl <em>Message</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.eclipse.papyrus.infra.discovery.impl.MessageImpl
	 * @see org.eclipse.papyrus.infra.discovery.impl.DiscoveryPackageImpl#getMessage()
	 * @generated
	 */
	int MESSAGE = 5;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MESSAGE__TITLE = 0;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MESSAGE__MESSAGE = 1;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MESSAGE__ICON = 2;

	/**
	 * The number of structural features of the '<em>Message</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.discovery.Severity <em>Severity</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.eclipse.papyrus.infra.discovery.Severity
	 * @see org.eclipse.papyrus.infra.discovery.impl.DiscoveryPackageImpl#getSeverity()
	 * @generated
	 */
	int SEVERITY = 6;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.discovery.InstallableComponent <em>Installable Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Installable Component</em>'.
	 * @see org.eclipse.papyrus.infra.discovery.InstallableComponent
	 * @generated
	 */
	EClass getInstallableComponent();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.discovery.InstallableComponent#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.infra.discovery.InstallableComponent#getName()
	 * @see #getInstallableComponent()
	 * @generated
	 */
	EAttribute getInstallableComponent_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.discovery.InstallableComponent#getProvider <em>Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Provider</em>'.
	 * @see org.eclipse.papyrus.infra.discovery.InstallableComponent#getProvider()
	 * @see #getInstallableComponent()
	 * @generated
	 */
	EAttribute getInstallableComponent_Provider();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.infra.discovery.InstallableComponent#getSitesURLS <em>Sites URLS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute list '<em>Sites URLS</em>'.
	 * @see org.eclipse.papyrus.infra.discovery.InstallableComponent#getSitesURLS()
	 * @see #getInstallableComponent()
	 * @generated
	 */
	EAttribute getInstallableComponent_SitesURLS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.discovery.InstallableComponent#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.papyrus.infra.discovery.InstallableComponent#getDescription()
	 * @see #getInstallableComponent()
	 * @generated
	 */
	EAttribute getInstallableComponent_Description();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.discovery.InstallableComponent#getOverview <em>Overview</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference '<em>Overview</em>'.
	 * @see org.eclipse.papyrus.infra.discovery.InstallableComponent#getOverview()
	 * @see #getInstallableComponent()
	 * @generated
	 */
	EReference getInstallableComponent_Overview();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.infra.discovery.InstallableComponent#getCategory <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the container reference '<em>Category</em>'.
	 * @see org.eclipse.papyrus.infra.discovery.InstallableComponent#getCategory()
	 * @see #getInstallableComponent()
	 * @generated
	 */
	EReference getInstallableComponent_Category();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.infra.discovery.InstallableComponent#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute list '<em>Id</em>'.
	 * @see org.eclipse.papyrus.infra.discovery.InstallableComponent#getId()
	 * @see #getInstallableComponent()
	 * @generated
	 */
	EAttribute getInstallableComponent_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.discovery.InstallableComponent#getLicense <em>License</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>License</em>'.
	 * @see org.eclipse.papyrus.infra.discovery.InstallableComponent#getLicense()
	 * @see #getInstallableComponent()
	 * @generated
	 */
	EAttribute getInstallableComponent_License();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.discovery.InstallableComponent#isSelected <em>Selected</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Selected</em>'.
	 * @see org.eclipse.papyrus.infra.discovery.InstallableComponent#isSelected()
	 * @see #getInstallableComponent()
	 * @generated
	 */
	EAttribute getInstallableComponent_Selected();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.discovery.InstallableComponent#isAvailable <em>Available</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Available</em>'.
	 * @see org.eclipse.papyrus.infra.discovery.InstallableComponent#isAvailable()
	 * @see #getInstallableComponent()
	 * @generated
	 */
	EAttribute getInstallableComponent_Available();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.discovery.InstallableComponent#isInstalled <em>Installed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Installed</em>'.
	 * @see org.eclipse.papyrus.infra.discovery.InstallableComponent#isInstalled()
	 * @see #getInstallableComponent()
	 * @generated
	 */
	EAttribute getInstallableComponent_Installed();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.discovery.InstallableComponent#getGroups <em>Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference list '<em>Groups</em>'.
	 * @see org.eclipse.papyrus.infra.discovery.InstallableComponent#getGroups()
	 * @see #getInstallableComponent()
	 * @generated
	 */
	EReference getInstallableComponent_Groups();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.discovery.InstallableComponent#getImage32 <em>Image32</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Image32</em>'.
	 * @see org.eclipse.papyrus.infra.discovery.InstallableComponent#getImage32()
	 * @see #getInstallableComponent()
	 * @generated
	 */
	EAttribute getInstallableComponent_Image32();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.discovery.InstallableComponent#isIncubation <em>Incubation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Incubation</em>'.
	 * @see org.eclipse.papyrus.infra.discovery.InstallableComponent#isIncubation()
	 * @see #getInstallableComponent()
	 * @generated
	 */
	EAttribute getInstallableComponent_Incubation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.discovery.InstallableComponent#getMessages <em>Messages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference list '<em>Messages</em>'.
	 * @see org.eclipse.papyrus.infra.discovery.InstallableComponent#getMessages()
	 * @see #getInstallableComponent()
	 * @generated
	 */
	EReference getInstallableComponent_Messages();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.discovery.InstallableComponent#isVisible <em>Visible</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Visible</em>'.
	 * @see org.eclipse.papyrus.infra.discovery.InstallableComponent#isVisible()
	 * @see #getInstallableComponent()
	 * @generated
	 */
	EAttribute getInstallableComponent_Visible();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.infra.discovery.InstallableComponent#getHiddingFeatureID <em>Hidding Feature ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute list '<em>Hidding Feature ID</em>'.
	 * @see org.eclipse.papyrus.infra.discovery.InstallableComponent#getHiddingFeatureID()
	 * @see #getInstallableComponent()
	 * @generated
	 */
	EAttribute getInstallableComponent_HiddingFeatureID();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.discovery.Overview <em>Overview</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Overview</em>'.
	 * @see org.eclipse.papyrus.infra.discovery.Overview
	 * @generated
	 */
	EClass getOverview();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.discovery.Overview#getSummary <em>Summary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Summary</em>'.
	 * @see org.eclipse.papyrus.infra.discovery.Overview#getSummary()
	 * @see #getOverview()
	 * @generated
	 */
	EAttribute getOverview_Summary();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.discovery.Overview#getScreenshot <em>Screenshot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Screenshot</em>'.
	 * @see org.eclipse.papyrus.infra.discovery.Overview#getScreenshot()
	 * @see #getOverview()
	 * @generated
	 */
	EAttribute getOverview_Screenshot();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.discovery.Overview#getUrl <em>Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Url</em>'.
	 * @see org.eclipse.papyrus.infra.discovery.Overview#getUrl()
	 * @see #getOverview()
	 * @generated
	 */
	EAttribute getOverview_Url();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.discovery.Category <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Category</em>'.
	 * @see org.eclipse.papyrus.infra.discovery.Category
	 * @generated
	 */
	EClass getCategory();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.discovery.Category#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.infra.discovery.Category#getName()
	 * @see #getCategory()
	 * @generated
	 */
	EAttribute getCategory_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.discovery.Category#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.papyrus.infra.discovery.Category#getDescription()
	 * @see #getCategory()
	 * @generated
	 */
	EAttribute getCategory_Description();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.discovery.Category#getComponents <em>Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference list '<em>Components</em>'.
	 * @see org.eclipse.papyrus.infra.discovery.Category#getComponents()
	 * @see #getCategory()
	 * @generated
	 */
	EReference getCategory_Components();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.discovery.Category#getRelevance <em>Relevance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Relevance</em>'.
	 * @see org.eclipse.papyrus.infra.discovery.Category#getRelevance()
	 * @see #getCategory()
	 * @generated
	 */
	EAttribute getCategory_Relevance();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.discovery.Category#getOverview <em>Overview</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference '<em>Overview</em>'.
	 * @see org.eclipse.papyrus.infra.discovery.Category#getOverview()
	 * @see #getCategory()
	 * @generated
	 */
	EReference getCategory_Overview();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.discovery.Category#getImage48 <em>Image48</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Image48</em>'.
	 * @see org.eclipse.papyrus.infra.discovery.Category#getImage48()
	 * @see #getCategory()
	 * @generated
	 */
	EAttribute getCategory_Image48();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.discovery.DiscoveryDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Definition</em>'.
	 * @see org.eclipse.papyrus.infra.discovery.DiscoveryDefinition
	 * @generated
	 */
	EClass getDiscoveryDefinition();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.discovery.DiscoveryDefinition#getCategories <em>Categories</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference list '<em>Categories</em>'.
	 * @see org.eclipse.papyrus.infra.discovery.DiscoveryDefinition#getCategories()
	 * @see #getDiscoveryDefinition()
	 * @generated
	 */
	EReference getDiscoveryDefinition_Categories();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.discovery.DiscoveryDefinition#getFilters <em>Filters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference list '<em>Filters</em>'.
	 * @see org.eclipse.papyrus.infra.discovery.DiscoveryDefinition#getFilters()
	 * @see #getDiscoveryDefinition()
	 * @generated
	 */
	EReference getDiscoveryDefinition_Filters();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.discovery.Group <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Group</em>'.
	 * @see org.eclipse.papyrus.infra.discovery.Group
	 * @generated
	 */
	EClass getGroup();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.discovery.Group#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.infra.discovery.Group#getName()
	 * @see #getGroup()
	 * @generated
	 */
	EAttribute getGroup_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.discovery.Message <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Message</em>'.
	 * @see org.eclipse.papyrus.infra.discovery.Message
	 * @generated
	 */
	EClass getMessage();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.discovery.Message#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see org.eclipse.papyrus.infra.discovery.Message#getTitle()
	 * @see #getMessage()
	 * @generated
	 */
	EAttribute getMessage_Title();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.discovery.Message#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.eclipse.papyrus.infra.discovery.Message#getMessage()
	 * @see #getMessage()
	 * @generated
	 */
	EAttribute getMessage_Message();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.discovery.Message#getIcon <em>Icon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Icon</em>'.
	 * @see org.eclipse.papyrus.infra.discovery.Message#getIcon()
	 * @see #getMessage()
	 * @generated
	 */
	EAttribute getMessage_Icon();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.infra.discovery.Severity <em>Severity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for enum '<em>Severity</em>'.
	 * @see org.eclipse.papyrus.infra.discovery.Severity
	 * @generated
	 */
	EEnum getSeverity();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DiscoveryFactory getDiscoveryFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.discovery.impl.InstallableComponentImpl <em>Installable Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.eclipse.papyrus.infra.discovery.impl.InstallableComponentImpl
		 * @see org.eclipse.papyrus.infra.discovery.impl.DiscoveryPackageImpl#getInstallableComponent()
		 * @generated
		 */
		EClass INSTALLABLE_COMPONENT = eINSTANCE.getInstallableComponent();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute INSTALLABLE_COMPONENT__NAME = eINSTANCE.getInstallableComponent_Name();

		/**
		 * The meta object literal for the '<em><b>Provider</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute INSTALLABLE_COMPONENT__PROVIDER = eINSTANCE.getInstallableComponent_Provider();

		/**
		 * The meta object literal for the '<em><b>Sites URLS</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute INSTALLABLE_COMPONENT__SITES_URLS = eINSTANCE.getInstallableComponent_SitesURLS();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute INSTALLABLE_COMPONENT__DESCRIPTION = eINSTANCE.getInstallableComponent_Description();

		/**
		 * The meta object literal for the '<em><b>Overview</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference INSTALLABLE_COMPONENT__OVERVIEW = eINSTANCE.getInstallableComponent_Overview();

		/**
		 * The meta object literal for the '<em><b>Category</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference INSTALLABLE_COMPONENT__CATEGORY = eINSTANCE.getInstallableComponent_Category();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute INSTALLABLE_COMPONENT__ID = eINSTANCE.getInstallableComponent_Id();

		/**
		 * The meta object literal for the '<em><b>License</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute INSTALLABLE_COMPONENT__LICENSE = eINSTANCE.getInstallableComponent_License();

		/**
		 * The meta object literal for the '<em><b>Selected</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute INSTALLABLE_COMPONENT__SELECTED = eINSTANCE.getInstallableComponent_Selected();

		/**
		 * The meta object literal for the '<em><b>Available</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute INSTALLABLE_COMPONENT__AVAILABLE = eINSTANCE.getInstallableComponent_Available();

		/**
		 * The meta object literal for the '<em><b>Installed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute INSTALLABLE_COMPONENT__INSTALLED = eINSTANCE.getInstallableComponent_Installed();

		/**
		 * The meta object literal for the '<em><b>Groups</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference INSTALLABLE_COMPONENT__GROUPS = eINSTANCE.getInstallableComponent_Groups();

		/**
		 * The meta object literal for the '<em><b>Image32</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute INSTALLABLE_COMPONENT__IMAGE32 = eINSTANCE.getInstallableComponent_Image32();

		/**
		 * The meta object literal for the '<em><b>Incubation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute INSTALLABLE_COMPONENT__INCUBATION = eINSTANCE.getInstallableComponent_Incubation();

		/**
		 * The meta object literal for the '<em><b>Messages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference INSTALLABLE_COMPONENT__MESSAGES = eINSTANCE.getInstallableComponent_Messages();

		/**
		 * The meta object literal for the '<em><b>Visible</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute INSTALLABLE_COMPONENT__VISIBLE = eINSTANCE.getInstallableComponent_Visible();

		/**
		 * The meta object literal for the '<em><b>Hidding Feature ID</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute INSTALLABLE_COMPONENT__HIDDING_FEATURE_ID = eINSTANCE.getInstallableComponent_HiddingFeatureID();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.discovery.impl.OverviewImpl <em>Overview</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.eclipse.papyrus.infra.discovery.impl.OverviewImpl
		 * @see org.eclipse.papyrus.infra.discovery.impl.DiscoveryPackageImpl#getOverview()
		 * @generated
		 */
		EClass OVERVIEW = eINSTANCE.getOverview();

		/**
		 * The meta object literal for the '<em><b>Summary</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute OVERVIEW__SUMMARY = eINSTANCE.getOverview_Summary();

		/**
		 * The meta object literal for the '<em><b>Screenshot</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute OVERVIEW__SCREENSHOT = eINSTANCE.getOverview_Screenshot();

		/**
		 * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute OVERVIEW__URL = eINSTANCE.getOverview_Url();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.discovery.impl.CategoryImpl <em>Category</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.eclipse.papyrus.infra.discovery.impl.CategoryImpl
		 * @see org.eclipse.papyrus.infra.discovery.impl.DiscoveryPackageImpl#getCategory()
		 * @generated
		 */
		EClass CATEGORY = eINSTANCE.getCategory();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute CATEGORY__NAME = eINSTANCE.getCategory_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute CATEGORY__DESCRIPTION = eINSTANCE.getCategory_Description();

		/**
		 * The meta object literal for the '<em><b>Components</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference CATEGORY__COMPONENTS = eINSTANCE.getCategory_Components();

		/**
		 * The meta object literal for the '<em><b>Relevance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute CATEGORY__RELEVANCE = eINSTANCE.getCategory_Relevance();

		/**
		 * The meta object literal for the '<em><b>Overview</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference CATEGORY__OVERVIEW = eINSTANCE.getCategory_Overview();

		/**
		 * The meta object literal for the '<em><b>Image48</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute CATEGORY__IMAGE48 = eINSTANCE.getCategory_Image48();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.discovery.impl.DiscoveryDefinitionImpl <em>Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.eclipse.papyrus.infra.discovery.impl.DiscoveryDefinitionImpl
		 * @see org.eclipse.papyrus.infra.discovery.impl.DiscoveryPackageImpl#getDiscoveryDefinition()
		 * @generated
		 */
		EClass DISCOVERY_DEFINITION = eINSTANCE.getDiscoveryDefinition();

		/**
		 * The meta object literal for the '<em><b>Categories</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference DISCOVERY_DEFINITION__CATEGORIES = eINSTANCE.getDiscoveryDefinition_Categories();

		/**
		 * The meta object literal for the '<em><b>Filters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference DISCOVERY_DEFINITION__FILTERS = eINSTANCE.getDiscoveryDefinition_Filters();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.discovery.impl.GroupImpl <em>Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.eclipse.papyrus.infra.discovery.impl.GroupImpl
		 * @see org.eclipse.papyrus.infra.discovery.impl.DiscoveryPackageImpl#getGroup()
		 * @generated
		 */
		EClass GROUP = eINSTANCE.getGroup();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute GROUP__NAME = eINSTANCE.getGroup_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.discovery.impl.MessageImpl <em>Message</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.eclipse.papyrus.infra.discovery.impl.MessageImpl
		 * @see org.eclipse.papyrus.infra.discovery.impl.DiscoveryPackageImpl#getMessage()
		 * @generated
		 */
		EClass MESSAGE = eINSTANCE.getMessage();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute MESSAGE__TITLE = eINSTANCE.getMessage_Title();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute MESSAGE__MESSAGE = eINSTANCE.getMessage_Message();

		/**
		 * The meta object literal for the '<em><b>Icon</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute MESSAGE__ICON = eINSTANCE.getMessage_Icon();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.discovery.Severity <em>Severity</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.eclipse.papyrus.infra.discovery.Severity
		 * @see org.eclipse.papyrus.infra.discovery.impl.DiscoveryPackageImpl#getSeverity()
		 * @generated
		 */
		EEnum SEVERITY = eINSTANCE.getSeverity();

	}

} // DiscoveryPackage
