/**
 * <copyright>
 * Copyright  2008 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE ''DELIVERABLES'') ARE ON AN ''AS-IS'' BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 *
 *
 * $Id: AadlPackageImpl.java,v 1.17 2008-08-26 19:31:48 lwrage Exp $
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
import org.eclipse.uml2.common.util.CacheAdapter;
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
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.AadlPackageImpl#getOwnedElements <em>Owned Element</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.AadlPackageImpl#getPublicSection <em>Public Section</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.AadlPackageImpl#getPrivateSection <em>Private Section</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.AadlPackageImpl#getOwnedPublicSection <em>Owned Public Section</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.AadlPackageImpl#getOwnedPrivateSection <em>Owned Private Section</em>}</li>
 * </ul>
 * </p>
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
	@Override
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getAadlPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Element> getOwnedElements() {
		CacheAdapter cache = getCacheAdapter();
		if (cache != null) {
			Resource eResource = eResource();
			@SuppressWarnings("unchecked")
			EList<Element> ownedElements = (EList<Element>) cache.get(eResource, this,
					Aadl2Package.eINSTANCE.getElement_OwnedElement());
			if (ownedElements == null) {
				cache.put(eResource, this, Aadl2Package.eINSTANCE.getElement_OwnedElement(),
						ownedElements = new DerivedUnionEObjectEList<Element>(Element.class, this,
								Aadl2Package.AADL_PACKAGE__OWNED_ELEMENT, OWNED_ELEMENT_ESUBSETS));
			}
			return ownedElements;
		}
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Aadl2Package.AADL_PACKAGE__PUBLIC_SECTION, oldPublicSection, publicSection));
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
	public void setOwnedPublicSection(PublicPackageSection newOwnedPublicSection) {
		if (newOwnedPublicSection != ownedPublicSection) {
			NotificationChain msgs = null;
			if (ownedPublicSection != null) {
				msgs = ((InternalEObject) ownedPublicSection).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
						- Aadl2Package.AADL_PACKAGE__OWNED_PUBLIC_SECTION, null, msgs);
			}
			if (newOwnedPublicSection != null) {
				msgs = ((InternalEObject) newOwnedPublicSection).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- Aadl2Package.AADL_PACKAGE__OWNED_PUBLIC_SECTION, null, msgs);
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
	@Override
	public PublicPackageSection createOwnedPublicSection() {
		PublicPackageSection newOwnedPublicSection = (PublicPackageSection) create(Aadl2Package.eINSTANCE
				.getPublicPackageSection());
		setOwnedPublicSection(newOwnedPublicSection);
		return newOwnedPublicSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public void setOwnedPrivateSection(PrivatePackageSection newOwnedPrivateSection) {
		if (newOwnedPrivateSection != ownedPrivateSection) {
			NotificationChain msgs = null;
			if (ownedPrivateSection != null) {
				msgs = ((InternalEObject) ownedPrivateSection).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
						- Aadl2Package.AADL_PACKAGE__OWNED_PRIVATE_SECTION, null, msgs);
			}
			if (newOwnedPrivateSection != null) {
				msgs = ((InternalEObject) newOwnedPrivateSection).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- Aadl2Package.AADL_PACKAGE__OWNED_PRIVATE_SECTION, null, msgs);
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
	@Override
	public PrivatePackageSection createOwnedPrivateSection() {
		PrivatePackageSection newOwnedPrivateSection = (PrivatePackageSection) create(Aadl2Package.eINSTANCE
				.getPrivatePackageSection());
		setOwnedPrivateSection(newOwnedPrivateSection);
		return newOwnedPrivateSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
	public boolean isSetOwnedElements() {
		return super.isSetOwnedElements() || eIsSet(Aadl2Package.AADL_PACKAGE__OWNED_PUBLIC_SECTION)
				|| eIsSet(Aadl2Package.AADL_PACKAGE__OWNED_PRIVATE_SECTION);
	}

} // AadlPackageImpl
