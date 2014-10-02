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
 * $Id: AccessSpecificationImpl.java,v 1.2 2009-02-13 17:51:15 lwrage Exp $
 */
package org.osate.aadl2.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AccessCategory;
import org.osate.aadl2.AccessSpecification;
import org.osate.aadl2.AccessType;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentPrototype;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Access Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.AccessSpecificationImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.AccessSpecificationImpl#getCategory <em>Category</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.AccessSpecificationImpl#getClassifier <em>Classifier</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.AccessSpecificationImpl#getComponentPrototype <em>Component Prototype</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AccessSpecificationImpl extends FeaturePrototypeActualImpl implements AccessSpecification {
	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final AccessType KIND_EDEFAULT = AccessType.PROVIDES;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected AccessType kind = KIND_EDEFAULT;

	/**
	 * The default value of the '{@link #getCategory() <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategory()
	 * @generated
	 * @ordered
	 */
	protected static final AccessCategory CATEGORY_EDEFAULT = AccessCategory.BUS;

	/**
	 * The cached value of the '{@link #getCategory() <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategory()
	 * @generated
	 * @ordered
	 */
	protected AccessCategory category = CATEGORY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getClassifier() <em>Classifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassifier()
	 * @generated
	 * @ordered
	 */
	protected ComponentClassifier classifier;

	/**
	 * The cached value of the '{@link #getComponentPrototype() <em>Component Prototype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentPrototype()
	 * @generated
	 * @ordered
	 */
	protected ComponentPrototype componentPrototype;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AccessSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getAccessSpecification();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AccessType getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setKind(AccessType newKind) {
		AccessType oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.ACCESS_SPECIFICATION__KIND, oldKind,
					kind));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AccessCategory getCategory() {
		return category;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCategory(AccessCategory newCategory) {
		AccessCategory oldCategory = category;
		category = newCategory == null ? CATEGORY_EDEFAULT : newCategory;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.ACCESS_SPECIFICATION__CATEGORY,
					oldCategory, category));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComponentClassifier getClassifier() {
		if (classifier != null && ((EObject) classifier).eIsProxy()) {
			InternalEObject oldClassifier = (InternalEObject) classifier;
			classifier = (ComponentClassifier) eResolveProxy(oldClassifier);
			if (classifier != oldClassifier) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Aadl2Package.ACCESS_SPECIFICATION__CLASSIFIER, oldClassifier, classifier));
				}
			}
		}
		return classifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentClassifier basicGetClassifier() {
		return classifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setClassifier(ComponentClassifier newClassifier) {
		ComponentClassifier oldClassifier = classifier;
		classifier = newClassifier;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.ACCESS_SPECIFICATION__CLASSIFIER,
					oldClassifier, classifier));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComponentPrototype getComponentPrototype() {
		if (componentPrototype != null && ((EObject) componentPrototype).eIsProxy()) {
			InternalEObject oldComponentPrototype = (InternalEObject) componentPrototype;
			componentPrototype = (ComponentPrototype) eResolveProxy(oldComponentPrototype);
			if (componentPrototype != oldComponentPrototype) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Aadl2Package.ACCESS_SPECIFICATION__COMPONENT_PROTOTYPE, oldComponentPrototype,
							componentPrototype));
				}
			}
		}
		return componentPrototype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentPrototype basicGetComponentPrototype() {
		return componentPrototype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setComponentPrototype(ComponentPrototype newComponentPrototype) {
		ComponentPrototype oldComponentPrototype = componentPrototype;
		componentPrototype = newComponentPrototype;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					Aadl2Package.ACCESS_SPECIFICATION__COMPONENT_PROTOTYPE, oldComponentPrototype, componentPrototype));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Aadl2Package.ACCESS_SPECIFICATION__KIND:
			return getKind();
		case Aadl2Package.ACCESS_SPECIFICATION__CATEGORY:
			return getCategory();
		case Aadl2Package.ACCESS_SPECIFICATION__CLASSIFIER:
			if (resolve) {
				return getClassifier();
			}
			return basicGetClassifier();
		case Aadl2Package.ACCESS_SPECIFICATION__COMPONENT_PROTOTYPE:
			if (resolve) {
				return getComponentPrototype();
			}
			return basicGetComponentPrototype();
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
		case Aadl2Package.ACCESS_SPECIFICATION__KIND:
			setKind((AccessType) newValue);
			return;
		case Aadl2Package.ACCESS_SPECIFICATION__CATEGORY:
			setCategory((AccessCategory) newValue);
			return;
		case Aadl2Package.ACCESS_SPECIFICATION__CLASSIFIER:
			setClassifier((ComponentClassifier) newValue);
			return;
		case Aadl2Package.ACCESS_SPECIFICATION__COMPONENT_PROTOTYPE:
			setComponentPrototype((ComponentPrototype) newValue);
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
		case Aadl2Package.ACCESS_SPECIFICATION__KIND:
			setKind(KIND_EDEFAULT);
			return;
		case Aadl2Package.ACCESS_SPECIFICATION__CATEGORY:
			setCategory(CATEGORY_EDEFAULT);
			return;
		case Aadl2Package.ACCESS_SPECIFICATION__CLASSIFIER:
			setClassifier((ComponentClassifier) null);
			return;
		case Aadl2Package.ACCESS_SPECIFICATION__COMPONENT_PROTOTYPE:
			setComponentPrototype((ComponentPrototype) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case Aadl2Package.ACCESS_SPECIFICATION__KIND:
			return kind != KIND_EDEFAULT;
		case Aadl2Package.ACCESS_SPECIFICATION__CATEGORY:
			return category != CATEGORY_EDEFAULT;
		case Aadl2Package.ACCESS_SPECIFICATION__CLASSIFIER:
			return classifier != null;
		case Aadl2Package.ACCESS_SPECIFICATION__COMPONENT_PROTOTYPE:
			return componentPrototype != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (kind: ");
		result.append(kind);
		result.append(", category: ");
		result.append(category);
		result.append(')');
		return result.toString();
	}

} // AccessSpecificationImpl
