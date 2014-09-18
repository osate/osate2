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
 * $Id: ContainedNamedElementImpl.java,v 1.3 2008-12-22 18:15:11 lwrage Exp $
 */
package org.osate.aadl2.impl;

import static org.eclipse.emf.common.util.ECollections.newBasicEList;
import static org.eclipse.emf.common.util.ECollections.unmodifiableEList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ContainmentPathElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Contained Named Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.ContainedNamedElementImpl#getPathElement <em>Path Element</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ContainedNamedElementImpl#getContainmentPathElements <em>Containment Path Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContainedNamedElementImpl extends ElementImpl implements ContainedNamedElement {
	/**
	 * The cached value of the '{@link #getPathElement() <em>Path Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPathElement()
	 * @generated
	 * @ordered
	 */
	protected ContainmentPathElement pathElement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContainedNamedElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getContainedNamedElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ContainmentPathElement getPathElement() {
		return pathElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPathElement(ContainmentPathElement newPathElement, NotificationChain msgs) {
		ContainmentPathElement oldPathElement = pathElement;
		pathElement = newPathElement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					Aadl2Package.CONTAINED_NAMED_ELEMENT__PATH_ELEMENT, oldPathElement, newPathElement);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPathElement(ContainmentPathElement newPathElement) {
		if (newPathElement != pathElement) {
			NotificationChain msgs = null;
			if (pathElement != null)
				msgs = ((InternalEObject) pathElement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
						- Aadl2Package.CONTAINED_NAMED_ELEMENT__PATH_ELEMENT, null, msgs);
			if (newPathElement != null)
				msgs = ((InternalEObject) newPathElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- Aadl2Package.CONTAINED_NAMED_ELEMENT__PATH_ELEMENT, null, msgs);
			msgs = basicSetPathElement(newPathElement, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.CONTAINED_NAMED_ELEMENT__PATH_ELEMENT,
					newPathElement, newPathElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ContainmentPathElement createPathElement() {
		ContainmentPathElement newPathElement = (ContainmentPathElement) create(Aadl2Package.eINSTANCE
				.getContainmentPathElement());
		setPathElement(newPathElement);
		return newPathElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Get the path elements as a list. For backward-compatibility after metamodel change.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<ContainmentPathElement> getContainmentPathElements() {
		EList<ContainmentPathElement> result = newBasicEList();
		ContainedNamedElement next = this;

		while (next != null) {
			result.add(next.getPathElement());
			next = next.getPathElement().getContainedNamedElement();
		}
		return unmodifiableEList(result);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.CONTAINED_NAMED_ELEMENT__PATH_ELEMENT:
			return basicSetPathElement(null, msgs);
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
		case Aadl2Package.CONTAINED_NAMED_ELEMENT__PATH_ELEMENT:
			return getPathElement();
		case Aadl2Package.CONTAINED_NAMED_ELEMENT__CONTAINMENT_PATH_ELEMENT:
			return getContainmentPathElements();
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
		case Aadl2Package.CONTAINED_NAMED_ELEMENT__PATH_ELEMENT:
			setPathElement((ContainmentPathElement) newValue);
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
		case Aadl2Package.CONTAINED_NAMED_ELEMENT__PATH_ELEMENT:
			setPathElement((ContainmentPathElement) null);
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
		case Aadl2Package.CONTAINED_NAMED_ELEMENT__PATH_ELEMENT:
			return pathElement != null;
		case Aadl2Package.CONTAINED_NAMED_ELEMENT__CONTAINMENT_PATH_ELEMENT:
			return !getContainmentPathElements().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // ContainedNamedElementImpl
