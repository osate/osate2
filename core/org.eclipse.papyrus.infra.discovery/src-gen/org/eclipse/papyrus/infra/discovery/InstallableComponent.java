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
 * A representation of the model object '<em><b>Installable Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.discovery.InstallableComponent#getName <em>Name</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.discovery.InstallableComponent#getProvider <em>Provider</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.discovery.InstallableComponent#getSitesURLS <em>Sites URLS</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.discovery.InstallableComponent#getDescription <em>Description</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.discovery.InstallableComponent#getOverview <em>Overview</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.discovery.InstallableComponent#getCategory <em>Category</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.discovery.InstallableComponent#getId <em>Id</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.discovery.InstallableComponent#getLicense <em>License</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.discovery.InstallableComponent#isSelected <em>Selected</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.discovery.InstallableComponent#isAvailable <em>Available</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.discovery.InstallableComponent#isInstalled <em>Installed</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.discovery.InstallableComponent#getGroups <em>Groups</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.discovery.InstallableComponent#getImage32 <em>Image32</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.discovery.InstallableComponent#isIncubation <em>Incubation</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.discovery.InstallableComponent#getMessages <em>Messages</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.discovery.InstallableComponent#isVisible <em>Visible</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.discovery.InstallableComponent#getHiddingFeatureID <em>Hidding Feature ID</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.discovery.DiscoveryPackage#getInstallableComponent()
 * @model
 * @generated
 */
public interface InstallableComponent extends EObject {
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
	 * @see org.eclipse.papyrus.infra.discovery.DiscoveryPackage#getInstallableComponent_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.discovery.InstallableComponent#getName <em>Name</em>}' attribute.
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
	 * Returns the value of the '<em><b>Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provider</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Provider</em>' attribute.
	 * @see #setProvider(String)
	 * @see org.eclipse.papyrus.infra.discovery.DiscoveryPackage#getInstallableComponent_Provider()
	 * @model required="true"
	 * @generated
	 */
	String getProvider();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.discovery.InstallableComponent#getProvider <em>Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Provider</em>' attribute.
	 * @see #getProvider()
	 * @generated
	 */
	void setProvider(String value);

	/**
	 * Returns the value of the '<em><b>Sites URLS</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sites URLS</em>' attribute list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Sites URLS</em>' attribute list.
	 * @see org.eclipse.papyrus.infra.discovery.DiscoveryPackage#getInstallableComponent_SitesURLS()
	 * @model required="true"
	 * @generated
	 */
	EList<String> getSitesURLS();

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
	 * @see org.eclipse.papyrus.infra.discovery.DiscoveryPackage#getInstallableComponent_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.discovery.InstallableComponent#getDescription <em>Description</em>}' attribute.
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
	 * Returns the value of the '<em><b>Overview</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overview</em>' containment reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Overview</em>' containment reference.
	 * @see #setOverview(Overview)
	 * @see org.eclipse.papyrus.infra.discovery.DiscoveryPackage#getInstallableComponent_Overview()
	 * @model containment="true"
	 * @generated
	 */
	Overview getOverview();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.discovery.InstallableComponent#getOverview <em>Overview</em>}' containment reference.
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
	 * Returns the value of the '<em><b>Category</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.infra.discovery.Category#getComponents <em>Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Category</em>' container reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Category</em>' container reference.
	 * @see #setCategory(Category)
	 * @see org.eclipse.papyrus.infra.discovery.DiscoveryPackage#getInstallableComponent_Category()
	 * @see org.eclipse.papyrus.infra.discovery.Category#getComponents
	 * @model opposite="components" required="true" transient="false"
	 * @generated
	 */
	Category getCategory();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.discovery.InstallableComponent#getCategory <em>Category</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Category</em>' container reference.
	 * @see #getCategory()
	 * @generated
	 */
	void setCategory(Category value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Id</em>' attribute list.
	 * @see org.eclipse.papyrus.infra.discovery.DiscoveryPackage#getInstallableComponent_Id()
	 * @model required="true"
	 * @generated
	 */
	EList<String> getId();

	/**
	 * Returns the value of the '<em><b>License</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>License</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>License</em>' attribute.
	 * @see #setLicense(String)
	 * @see org.eclipse.papyrus.infra.discovery.DiscoveryPackage#getInstallableComponent_License()
	 * @model required="true"
	 * @generated
	 */
	String getLicense();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.discovery.InstallableComponent#getLicense <em>License</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>License</em>' attribute.
	 * @see #getLicense()
	 * @generated
	 */
	void setLicense(String value);

	/**
	 * Returns the value of the '<em><b>Selected</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Selected</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Selected</em>' attribute.
	 * @see #setSelected(boolean)
	 * @see org.eclipse.papyrus.infra.discovery.DiscoveryPackage#getInstallableComponent_Selected()
	 * @model default="false" required="true" transient="true"
	 * @generated
	 */
	boolean isSelected();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.discovery.InstallableComponent#isSelected <em>Selected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Selected</em>' attribute.
	 * @see #isSelected()
	 * @generated
	 */
	void setSelected(boolean value);

	/**
	 * Returns the value of the '<em><b>Available</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Available</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Available</em>' attribute.
	 * @see #setAvailable(boolean)
	 * @see org.eclipse.papyrus.infra.discovery.DiscoveryPackage#getInstallableComponent_Available()
	 * @model default="false" required="true" transient="true"
	 * @generated
	 */
	boolean isAvailable();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.discovery.InstallableComponent#isAvailable <em>Available</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Available</em>' attribute.
	 * @see #isAvailable()
	 * @generated
	 */
	void setAvailable(boolean value);

	/**
	 * Returns the value of the '<em><b>Installed</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Installed</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Installed</em>' attribute.
	 * @see #setInstalled(boolean)
	 * @see org.eclipse.papyrus.infra.discovery.DiscoveryPackage#getInstallableComponent_Installed()
	 * @model default="false" required="true" transient="true"
	 * @generated
	 */
	boolean isInstalled();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.discovery.InstallableComponent#isInstalled <em>Installed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Installed</em>' attribute.
	 * @see #isInstalled()
	 * @generated
	 */
	void setInstalled(boolean value);

	/**
	 * Returns the value of the '<em><b>Groups</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.discovery.Group}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Groups</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Groups</em>' reference list.
	 * @see org.eclipse.papyrus.infra.discovery.DiscoveryPackage#getInstallableComponent_Groups()
	 * @model
	 * @generated
	 */
	EList<Group> getGroups();

	/**
	 * Returns the value of the '<em><b>Image32</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Image32</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Image32</em>' attribute.
	 * @see #setImage32(String)
	 * @see org.eclipse.papyrus.infra.discovery.DiscoveryPackage#getInstallableComponent_Image32()
	 * @model
	 * @generated
	 */
	String getImage32();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.discovery.InstallableComponent#getImage32 <em>Image32</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Image32</em>' attribute.
	 * @see #getImage32()
	 * @generated
	 */
	void setImage32(String value);

	/**
	 * Returns the value of the '<em><b>Incubation</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incubation</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Incubation</em>' attribute.
	 * @see #setIncubation(boolean)
	 * @see org.eclipse.papyrus.infra.discovery.DiscoveryPackage#getInstallableComponent_Incubation()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isIncubation();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.discovery.InstallableComponent#isIncubation <em>Incubation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Incubation</em>' attribute.
	 * @see #isIncubation()
	 * @generated
	 */
	void setIncubation(boolean value);

	/**
	 * Returns the value of the '<em><b>Messages</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.discovery.Message}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Messages</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Messages</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.discovery.DiscoveryPackage#getInstallableComponent_Messages()
	 * @model containment="true"
	 * @generated
	 */
	EList<Message> getMessages();

	/**
	 * Returns the value of the '<em><b>Visible</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visible</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Visible</em>' attribute.
	 * @see #setVisible(boolean)
	 * @see org.eclipse.papyrus.infra.discovery.DiscoveryPackage#getInstallableComponent_Visible()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isVisible();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.discovery.InstallableComponent#isVisible <em>Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Visible</em>' attribute.
	 * @see #isVisible()
	 * @generated
	 */
	void setVisible(boolean value);

	/**
	 * Returns the value of the '<em><b>Hidding Feature ID</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hidding Feature ID</em>' attribute list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Hidding Feature ID</em>' attribute list.
	 * @see org.eclipse.papyrus.infra.discovery.DiscoveryPackage#getInstallableComponent_HiddingFeatureID()
	 * @model
	 * @generated
	 */
	EList<String> getHiddingFeatureID();

} // InstallableComponent
