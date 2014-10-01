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
 * $Id: ContainmentPathElementImpl.java,v 1.6 2009-01-12 16:25:09 jseibel Exp $
 */
package org.osate.aadl2.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ArrayRange;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.NamedElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Containment Path Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.ContainmentPathElementImpl#getArrayRanges <em>Array Range</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ContainmentPathElementImpl#getNamedElement <em>Named Element</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ContainmentPathElementImpl#getAnnexName <em>Annex Name</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ContainmentPathElementImpl#getPath <em>Path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContainmentPathElementImpl extends ElementImpl implements ContainmentPathElement {
	/**
	 * The cached value of the '{@link #getArrayRanges() <em>Array Range</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArrayRanges()
	 * @generated
	 * @ordered
	 */
	protected EList<ArrayRange> arrayRanges;

	/**
	 * The cached value of the '{@link #getNamedElement() <em>Named Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamedElement()
	 * @generated
	 * @ordered
	 */
	protected NamedElement namedElement;

	/**
	 * The default value of the '{@link #getAnnexName() <em>Annex Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnexName()
	 * @generated
	 * @ordered
	 */
	protected static final String ANNEX_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAnnexName() <em>Annex Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnexName()
	 * @generated
	 * @ordered
	 */
	protected String annexName = ANNEX_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPath() <em>Path</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected ContainmentPathElement path;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContainmentPathElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getContainmentPathElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ArrayRange> getArrayRanges() {
		if (arrayRanges == null) {
			arrayRanges = new EObjectContainmentEList<ArrayRange>(ArrayRange.class, this,
					Aadl2Package.CONTAINMENT_PATH_ELEMENT__ARRAY_RANGE);
		}
		return arrayRanges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ArrayRange createArrayRange() {
		ArrayRange newArrayRange = (ArrayRange) create(Aadl2Package.eINSTANCE.getArrayRange());
		getArrayRanges().add(newArrayRange);
		return newArrayRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NamedElement getNamedElement() {
		if (namedElement != null && ((EObject) namedElement).eIsProxy()) {
			InternalEObject oldNamedElement = (InternalEObject) namedElement;
			namedElement = (NamedElement) eResolveProxy(oldNamedElement);
			if (namedElement != oldNamedElement) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Aadl2Package.CONTAINMENT_PATH_ELEMENT__NAMED_ELEMENT, oldNamedElement, namedElement));
				}
			}
		}
		return namedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement basicGetNamedElement() {
		return namedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNamedElement(NamedElement newNamedElement) {
		NamedElement oldNamedElement = namedElement;
		namedElement = newNamedElement;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.CONTAINMENT_PATH_ELEMENT__NAMED_ELEMENT,
					oldNamedElement, namedElement));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getAnnexName() {
		return annexName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAnnexName(String newAnnexName) {
		String oldAnnexName = annexName;
		annexName = newAnnexName;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.CONTAINMENT_PATH_ELEMENT__ANNEX_NAME,
					oldAnnexName, annexName));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ContainmentPathElement getPath() {
		return path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPath(ContainmentPathElement newPath, NotificationChain msgs) {
		ContainmentPathElement oldPath = path;
		path = newPath;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					Aadl2Package.CONTAINMENT_PATH_ELEMENT__PATH, oldPath, newPath);
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
	 * @generated
	 */
	@Override
	public void setPath(ContainmentPathElement newPath) {
		if (newPath != path) {
			NotificationChain msgs = null;
			if (path != null) {
				msgs = ((InternalEObject) path).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
						- Aadl2Package.CONTAINMENT_PATH_ELEMENT__PATH, null, msgs);
			}
			if (newPath != null) {
				msgs = ((InternalEObject) newPath).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- Aadl2Package.CONTAINMENT_PATH_ELEMENT__PATH, null, msgs);
			}
			msgs = basicSetPath(newPath, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.CONTAINMENT_PATH_ELEMENT__PATH, newPath,
					newPath));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ContainmentPathElement createPath() {
		ContainmentPathElement newPath = (ContainmentPathElement) create(Aadl2Package.eINSTANCE
				.getContainmentPathElement());
		setPath(newPath);
		return newPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.CONTAINMENT_PATH_ELEMENT__ARRAY_RANGE:
			return ((InternalEList<?>) getArrayRanges()).basicRemove(otherEnd, msgs);
		case Aadl2Package.CONTAINMENT_PATH_ELEMENT__PATH:
			return basicSetPath(null, msgs);
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
		case Aadl2Package.CONTAINMENT_PATH_ELEMENT__ARRAY_RANGE:
			return getArrayRanges();
		case Aadl2Package.CONTAINMENT_PATH_ELEMENT__NAMED_ELEMENT:
			if (resolve) {
				return getNamedElement();
			}
			return basicGetNamedElement();
		case Aadl2Package.CONTAINMENT_PATH_ELEMENT__ANNEX_NAME:
			return getAnnexName();
		case Aadl2Package.CONTAINMENT_PATH_ELEMENT__PATH:
			return getPath();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case Aadl2Package.CONTAINMENT_PATH_ELEMENT__ARRAY_RANGE:
			getArrayRanges().clear();
			getArrayRanges().addAll((Collection<? extends ArrayRange>) newValue);
			return;
		case Aadl2Package.CONTAINMENT_PATH_ELEMENT__NAMED_ELEMENT:
			setNamedElement((NamedElement) newValue);
			return;
		case Aadl2Package.CONTAINMENT_PATH_ELEMENT__ANNEX_NAME:
			setAnnexName((String) newValue);
			return;
		case Aadl2Package.CONTAINMENT_PATH_ELEMENT__PATH:
			setPath((ContainmentPathElement) newValue);
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
		case Aadl2Package.CONTAINMENT_PATH_ELEMENT__ARRAY_RANGE:
			getArrayRanges().clear();
			return;
		case Aadl2Package.CONTAINMENT_PATH_ELEMENT__NAMED_ELEMENT:
			setNamedElement((NamedElement) null);
			return;
		case Aadl2Package.CONTAINMENT_PATH_ELEMENT__ANNEX_NAME:
			setAnnexName(ANNEX_NAME_EDEFAULT);
			return;
		case Aadl2Package.CONTAINMENT_PATH_ELEMENT__PATH:
			setPath((ContainmentPathElement) null);
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
		case Aadl2Package.CONTAINMENT_PATH_ELEMENT__ARRAY_RANGE:
			return arrayRanges != null && !arrayRanges.isEmpty();
		case Aadl2Package.CONTAINMENT_PATH_ELEMENT__NAMED_ELEMENT:
			return namedElement != null;
		case Aadl2Package.CONTAINMENT_PATH_ELEMENT__ANNEX_NAME:
			return ANNEX_NAME_EDEFAULT == null ? annexName != null : !ANNEX_NAME_EDEFAULT.equals(annexName);
		case Aadl2Package.CONTAINMENT_PATH_ELEMENT__PATH:
			return path != null;
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
		result.append(" (annexName: ");
		result.append(annexName);
		result.append(')');
		return result.toString();
	}

} // ContainmentPathElementImpl
