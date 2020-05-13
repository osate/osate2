/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.aadl2.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Element;
import org.osate.aadl2.PrivatePackageSection;
import org.osate.aadl2.PublicPackageSection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Aadl Package</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.AadlPackageImpl#getOwnedElements <em>Owned Element</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.AadlPackageImpl#getPublicSection <em>Public Section</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.AadlPackageImpl#getPrivateSection <em>Private Section</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.AadlPackageImpl#getOwnedPublicSection <em>Owned Public Section</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.AadlPackageImpl#getOwnedPrivateSection <em>Owned Private Section</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AadlPackageImpl extends ModelUnitImpl implements AadlPackage {
	/**
	 * The cached value of the '{@link #getPublicSection() <em>Public Section</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublicSection()
	 * @generated
	 * @ordered
	 */
	protected PublicPackageSection publicSection;

	/**
	 * The cached value of the '{@link #getPrivateSection() <em>Private Section</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrivateSection()
	 * @generated
	 * @ordered
	 */
	protected PrivatePackageSection privateSection;

	/**
	 * The cached value of the '{@link #getOwnedPublicSection() <em>Owned Public Section</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedPublicSection()
	 * @generated
	 * @ordered
	 */
	protected PublicPackageSection ownedPublicSection;

	/**
	 * The cached value of the '{@link #getOwnedPrivateSection() <em>Owned Private Section</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedPrivateSection()
	 * @generated
	 * @ordered
	 */
	protected PrivatePackageSection ownedPrivateSection;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AadlPackageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getAadlPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Element> getOwnedElements() {
		return new DerivedUnionEObjectEList<Element>(Element.class, this, Aadl2Package.AADL_PACKAGE__OWNED_ELEMENT,
				OWNED_ELEMENT_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedElements() <em>Owned Element</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedElements()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_ELEMENT_ESUBSETS = new int[] { Aadl2Package.AADL_PACKAGE__OWNED_COMMENT,
			Aadl2Package.AADL_PACKAGE__OWNED_PUBLIC_SECTION, Aadl2Package.AADL_PACKAGE__OWNED_PRIVATE_SECTION };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PublicPackageSection getPublicSectionGen() {
		if (publicSection != null && ((EObject) publicSection).eIsProxy()) {
			InternalEObject oldPublicSection = (InternalEObject) publicSection;
			publicSection = (PublicPackageSection) eResolveProxy(oldPublicSection);
			if (publicSection != oldPublicSection) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Aadl2Package.AADL_PACKAGE__PUBLIC_SECTION,
							oldPublicSection, publicSection));
				}
			}
		}
		return publicSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public PublicPackageSection getPublicSection() {
		if (publicSection == null) {
			publicSection = ownedPublicSection;
		}
		return getPublicSectionGen();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PublicPackageSection basicGetPublicSectionGen() {
		return publicSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public PublicPackageSection basicGetPublicSection() {
		if (publicSection == null) {
			publicSection = ownedPublicSection;
		}
		return basicGetPublicSectionGen();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setPublicSection(PublicPackageSection newPublicSection) {
		PublicPackageSection oldPublicSection = publicSection;
		publicSection = newPublicSection;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.AADL_PACKAGE__PUBLIC_SECTION,
					oldPublicSection, publicSection));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrivatePackageSection getPrivateSectionGen() {
		if (privateSection != null && ((EObject) privateSection).eIsProxy()) {
			InternalEObject oldPrivateSection = (InternalEObject) privateSection;
			privateSection = (PrivatePackageSection) eResolveProxy(oldPrivateSection);
			if (privateSection != oldPrivateSection) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Aadl2Package.AADL_PACKAGE__PRIVATE_SECTION, oldPrivateSection, privateSection));
				}
			}
		}
		return privateSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public PrivatePackageSection getPrivateSection() {
		if (privateSection == null) {
			privateSection = ownedPrivateSection;
		}
		return getPrivateSectionGen();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrivatePackageSection basicGetPrivateSectionGen() {
		return privateSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public PrivatePackageSection basicGetPrivateSection() {
		if (privateSection == null) {
			privateSection = ownedPrivateSection;
		}
		return basicGetPrivateSectionGen();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setPrivateSection(PrivatePackageSection newPrivateSection) {
		PrivatePackageSection oldPrivateSection = privateSection;
		privateSection = newPrivateSection;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.AADL_PACKAGE__PRIVATE_SECTION,
					oldPrivateSection, privateSection));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PublicPackageSection getOwnedPublicSection() {
		return ownedPublicSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedPublicSection(PublicPackageSection newOwnedPublicSection,
			NotificationChain msgs) {
		PublicPackageSection oldOwnedPublicSection = ownedPublicSection;
		ownedPublicSection = newOwnedPublicSection;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					Aadl2Package.AADL_PACKAGE__OWNED_PUBLIC_SECTION, oldOwnedPublicSection, newOwnedPublicSection);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		Resource.Internal eInternalResource = eInternalResource();
		if (eInternalResource == null || !eInternalResource.isLoading()) {
			if (newOwnedPublicSection != null) {
				if (newOwnedPublicSection != publicSection) {
					setPublicSection(newOwnedPublicSection);
				}
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedPublicSection(PublicPackageSection newOwnedPublicSection) {
		if (newOwnedPublicSection != ownedPublicSection) {
			NotificationChain msgs = null;
			if (ownedPublicSection != null) {
				msgs = ((InternalEObject) ownedPublicSection).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - Aadl2Package.AADL_PACKAGE__OWNED_PUBLIC_SECTION, null, msgs);
			}
			if (newOwnedPublicSection != null) {
				msgs = ((InternalEObject) newOwnedPublicSection).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - Aadl2Package.AADL_PACKAGE__OWNED_PUBLIC_SECTION, null, msgs);
			}
			msgs = basicSetOwnedPublicSection(newOwnedPublicSection, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.AADL_PACKAGE__OWNED_PUBLIC_SECTION,
					newOwnedPublicSection, newOwnedPublicSection));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PublicPackageSection createOwnedPublicSection() {
		PublicPackageSection newOwnedPublicSection = (PublicPackageSection) create(
				Aadl2Package.eINSTANCE.getPublicPackageSection());
		setOwnedPublicSection(newOwnedPublicSection);
		return newOwnedPublicSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrivatePackageSection getOwnedPrivateSection() {
		return ownedPrivateSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedPrivateSection(PrivatePackageSection newOwnedPrivateSection,
			NotificationChain msgs) {
		PrivatePackageSection oldOwnedPrivateSection = ownedPrivateSection;
		ownedPrivateSection = newOwnedPrivateSection;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					Aadl2Package.AADL_PACKAGE__OWNED_PRIVATE_SECTION, oldOwnedPrivateSection, newOwnedPrivateSection);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		Resource.Internal eInternalResource = eInternalResource();
		if (eInternalResource == null || !eInternalResource.isLoading()) {
			if (newOwnedPrivateSection != null) {
				if (newOwnedPrivateSection != privateSection) {
					setPrivateSection(newOwnedPrivateSection);
				}
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedPrivateSection(PrivatePackageSection newOwnedPrivateSection) {
		if (newOwnedPrivateSection != ownedPrivateSection) {
			NotificationChain msgs = null;
			if (ownedPrivateSection != null) {
				msgs = ((InternalEObject) ownedPrivateSection).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - Aadl2Package.AADL_PACKAGE__OWNED_PRIVATE_SECTION, null, msgs);
			}
			if (newOwnedPrivateSection != null) {
				msgs = ((InternalEObject) newOwnedPrivateSection).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - Aadl2Package.AADL_PACKAGE__OWNED_PRIVATE_SECTION, null, msgs);
			}
			msgs = basicSetOwnedPrivateSection(newOwnedPrivateSection, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.AADL_PACKAGE__OWNED_PRIVATE_SECTION,
					newOwnedPrivateSection, newOwnedPrivateSection));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrivatePackageSection createOwnedPrivateSection() {
		PrivatePackageSection newOwnedPrivateSection = (PrivatePackageSection) create(
				Aadl2Package.eINSTANCE.getPrivatePackageSection());
		setOwnedPrivateSection(newOwnedPrivateSection);
		return newOwnedPrivateSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.AADL_PACKAGE__OWNED_PUBLIC_SECTION:
			return basicSetOwnedPublicSection(null, msgs);
		case Aadl2Package.AADL_PACKAGE__OWNED_PRIVATE_SECTION:
			return basicSetOwnedPrivateSection(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Aadl2Package.AADL_PACKAGE__PUBLIC_SECTION:
			if (resolve) {
				return getPublicSection();
			}
			return basicGetPublicSection();
		case Aadl2Package.AADL_PACKAGE__PRIVATE_SECTION:
			if (resolve) {
				return getPrivateSection();
			}
			return basicGetPrivateSection();
		case Aadl2Package.AADL_PACKAGE__OWNED_PUBLIC_SECTION:
			return getOwnedPublicSection();
		case Aadl2Package.AADL_PACKAGE__OWNED_PRIVATE_SECTION:
			return getOwnedPrivateSection();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case Aadl2Package.AADL_PACKAGE__PUBLIC_SECTION:
			setPublicSection((PublicPackageSection) newValue);
			return;
		case Aadl2Package.AADL_PACKAGE__PRIVATE_SECTION:
			setPrivateSection((PrivatePackageSection) newValue);
			return;
		case Aadl2Package.AADL_PACKAGE__OWNED_PUBLIC_SECTION:
			setOwnedPublicSection((PublicPackageSection) newValue);
			return;
		case Aadl2Package.AADL_PACKAGE__OWNED_PRIVATE_SECTION:
			setOwnedPrivateSection((PrivatePackageSection) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
		case Aadl2Package.AADL_PACKAGE__PUBLIC_SECTION:
			setPublicSection((PublicPackageSection) null);
			return;
		case Aadl2Package.AADL_PACKAGE__PRIVATE_SECTION:
			setPrivateSection((PrivatePackageSection) null);
			return;
		case Aadl2Package.AADL_PACKAGE__OWNED_PUBLIC_SECTION:
			setOwnedPublicSection((PublicPackageSection) null);
			return;
		case Aadl2Package.AADL_PACKAGE__OWNED_PRIVATE_SECTION:
			setOwnedPrivateSection((PrivatePackageSection) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case Aadl2Package.AADL_PACKAGE__PUBLIC_SECTION:
			if (publicSection == null) {
				publicSection = ownedPublicSection;
			}
			return publicSection != null;
		case Aadl2Package.AADL_PACKAGE__PRIVATE_SECTION:
			if (privateSection == null) {
				privateSection = ownedPrivateSection;
			}
			return privateSection != null;
		case Aadl2Package.AADL_PACKAGE__OWNED_PUBLIC_SECTION:
			return ownedPublicSection != null;
		case Aadl2Package.AADL_PACKAGE__OWNED_PRIVATE_SECTION:
			return ownedPrivateSection != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOwnedElements() {
		return super.isSetOwnedElements() || eIsSet(Aadl2Package.AADL_PACKAGE__OWNED_PUBLIC_SECTION)
				|| eIsSet(Aadl2Package.AADL_PACKAGE__OWNED_PRIVATE_SECTION);
	}

} // AadlPackageImpl
