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
 * $Id: ComponentImplementationReferenceImpl.java,v 1.4 2009-02-19 19:07:41 lwrage Exp $
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
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentImplementationReference;
import org.osate.aadl2.PrototypeBinding;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component Implementation Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.ComponentImplementationReferenceImpl#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ComponentImplementationReferenceImpl#getOwnedPrototypeBindings <em>Owned Prototype Binding</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentImplementationReferenceImpl extends ElementImpl implements ComponentImplementationReference {
	/**
	 * The cached value of the '{@link #getImplementation() <em>Implementation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementation()
	 * @generated
	 * @ordered
	 */
	protected ComponentImplementation implementation;

	/**
	 * The cached value of the '{@link #getOwnedPrototypeBindings() <em>Owned Prototype Binding</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedPrototypeBindings()
	 * @generated
	 * @ordered
	 */
	protected EList<PrototypeBinding> ownedPrototypeBindings;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentImplementationReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getComponentImplementationReference();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComponentImplementation getImplementation() {
		if (implementation != null && ((EObject) implementation).eIsProxy()) {
			InternalEObject oldImplementation = (InternalEObject) implementation;
			implementation = (ComponentImplementation) eResolveProxy(oldImplementation);
			if (implementation != oldImplementation) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Aadl2Package.COMPONENT_IMPLEMENTATION_REFERENCE__IMPLEMENTATION, oldImplementation,
							implementation));
				}
			}
		}
		return implementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentImplementation basicGetImplementation() {
		return implementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setImplementation(ComponentImplementation newImplementation) {
		ComponentImplementation oldImplementation = implementation;
		implementation = newImplementation;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					Aadl2Package.COMPONENT_IMPLEMENTATION_REFERENCE__IMPLEMENTATION, oldImplementation, implementation));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PrototypeBinding> getOwnedPrototypeBindings() {
		if (ownedPrototypeBindings == null) {
			ownedPrototypeBindings = new EObjectContainmentEList<PrototypeBinding>(PrototypeBinding.class, this,
					Aadl2Package.COMPONENT_IMPLEMENTATION_REFERENCE__OWNED_PROTOTYPE_BINDING);
		}
		return ownedPrototypeBindings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PrototypeBinding createOwnedPrototypeBinding(EClass eClass) {
		PrototypeBinding newOwnedPrototypeBinding = (PrototypeBinding) create(eClass);
		getOwnedPrototypeBindings().add(newOwnedPrototypeBinding);
		return newOwnedPrototypeBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.COMPONENT_IMPLEMENTATION_REFERENCE__OWNED_PROTOTYPE_BINDING:
			return ((InternalEList<?>) getOwnedPrototypeBindings()).basicRemove(otherEnd, msgs);
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
		case Aadl2Package.COMPONENT_IMPLEMENTATION_REFERENCE__IMPLEMENTATION:
			if (resolve) {
				return getImplementation();
			}
			return basicGetImplementation();
		case Aadl2Package.COMPONENT_IMPLEMENTATION_REFERENCE__OWNED_PROTOTYPE_BINDING:
			return getOwnedPrototypeBindings();
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
		case Aadl2Package.COMPONENT_IMPLEMENTATION_REFERENCE__IMPLEMENTATION:
			setImplementation((ComponentImplementation) newValue);
			return;
		case Aadl2Package.COMPONENT_IMPLEMENTATION_REFERENCE__OWNED_PROTOTYPE_BINDING:
			getOwnedPrototypeBindings().clear();
			getOwnedPrototypeBindings().addAll((Collection<? extends PrototypeBinding>) newValue);
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
		case Aadl2Package.COMPONENT_IMPLEMENTATION_REFERENCE__IMPLEMENTATION:
			setImplementation((ComponentImplementation) null);
			return;
		case Aadl2Package.COMPONENT_IMPLEMENTATION_REFERENCE__OWNED_PROTOTYPE_BINDING:
			getOwnedPrototypeBindings().clear();
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
		case Aadl2Package.COMPONENT_IMPLEMENTATION_REFERENCE__IMPLEMENTATION:
			return implementation != null;
		case Aadl2Package.COMPONENT_IMPLEMENTATION_REFERENCE__OWNED_PROTOTYPE_BINDING:
			return ownedPrototypeBindings != null && !ownedPrototypeBindings.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // ComponentImplementationReferenceImpl
