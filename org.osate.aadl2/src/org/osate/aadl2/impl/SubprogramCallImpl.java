/**
 * <copyright>
 * Copyright  2011 by Carnegie Mellon University, all rights reserved.
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
 */
package org.osate.aadl2.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.CallContext;
import org.osate.aadl2.CalledSubprogram;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Feature;
import org.osate.aadl2.Namespace;
import org.osate.aadl2.Property;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.properties.InvalidModelException;
import org.osate.aadl2.properties.PropertyAcc;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subprogram Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.SubprogramCallImpl#getCalledSubprogram <em>Called Subprogram</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.SubprogramCallImpl#getContext <em>Context</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubprogramCallImpl extends BehavioralFeatureImpl implements SubprogramCall {
	/**
	 * The cached value of the '{@link #getCalledSubprogram() <em>Called Subprogram</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCalledSubprogram()
	 * @generated
	 * @ordered
	 */
	protected CalledSubprogram calledSubprogram;

	/**
	 * The cached value of the '{@link #getContext() <em>Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
	protected CallContext context;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubprogramCallImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getSubprogramCall();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CalledSubprogram getCalledSubprogram() {
		if (calledSubprogram != null && ((EObject) calledSubprogram).eIsProxy()) {
			InternalEObject oldCalledSubprogram = (InternalEObject) calledSubprogram;
			calledSubprogram = (CalledSubprogram) eResolveProxy(oldCalledSubprogram);
			if (calledSubprogram != oldCalledSubprogram) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Aadl2Package.SUBPROGRAM_CALL__CALLED_SUBPROGRAM, oldCalledSubprogram, calledSubprogram));
				}
			}
		}
		return calledSubprogram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CalledSubprogram basicGetCalledSubprogram() {
		return calledSubprogram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCalledSubprogram(CalledSubprogram newCalledSubprogram) {
		CalledSubprogram oldCalledSubprogram = calledSubprogram;
		calledSubprogram = newCalledSubprogram;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.SUBPROGRAM_CALL__CALLED_SUBPROGRAM,
					oldCalledSubprogram, calledSubprogram));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CallContext getContext() {
		if (context != null && ((EObject) context).eIsProxy()) {
			InternalEObject oldContext = (InternalEObject) context;
			context = (CallContext) eResolveProxy(oldContext);
			if (context != oldContext) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Aadl2Package.SUBPROGRAM_CALL__CONTEXT,
							oldContext, context));
				}
			}
		}
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallContext basicGetContext() {
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setContext(CallContext newContext) {
		CallContext oldContext = context;
		context = newContext;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.SUBPROGRAM_CALL__CONTEXT, oldContext,
					context));
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
		case Aadl2Package.SUBPROGRAM_CALL__CALLED_SUBPROGRAM:
			if (resolve) {
				return getCalledSubprogram();
			}
			return basicGetCalledSubprogram();
		case Aadl2Package.SUBPROGRAM_CALL__CONTEXT:
			if (resolve) {
				return getContext();
			}
			return basicGetContext();
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
		case Aadl2Package.SUBPROGRAM_CALL__CALLED_SUBPROGRAM:
			setCalledSubprogram((CalledSubprogram) newValue);
			return;
		case Aadl2Package.SUBPROGRAM_CALL__CONTEXT:
			setContext((CallContext) newValue);
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
		case Aadl2Package.SUBPROGRAM_CALL__CALLED_SUBPROGRAM:
			setCalledSubprogram((CalledSubprogram) null);
			return;
		case Aadl2Package.SUBPROGRAM_CALL__CONTEXT:
			setContext((CallContext) null);
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
		case Aadl2Package.SUBPROGRAM_CALL__CALLED_SUBPROGRAM:
			return calledSubprogram != null;
		case Aadl2Package.SUBPROGRAM_CALL__CONTEXT:
			return context != null;
		}
		return super.eIsSet(featureID);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.osate.aadl2.impl.NamedElementImpl#getNamespace()
	 */
	@Override
	public Namespace getNamespace() {
		return (Namespace) eContainer().eContainer();
	}

	// XXX: [AADL 1 -> AADL 2] Added to make property lookup work.
	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.osate.aadl2.impl.NamedElementImpl#getPropertyValueInternal
	 * (org.osate.aadl2.Property,
	 * org.osate.aadl2.properties.AadlPropertyValue, boolean)
	 */
	@Override
	public final void getPropertyValueInternal(final Property prop, final PropertyAcc pas,
			final boolean fromInstanceSlaveCall) throws InvalidModelException {
		final ComponentImplementation owner = (ComponentImplementation) getContainingClassifier();

		// local contained value
		if (!fromInstanceSlaveCall && pas.addLocalContained(this, owner)) {
			return;
		}

		// get local value
		if (pas.addLocal(this)) {
			return;
		}

		// get values from called subprogram
		if (getCalledSubprogram() instanceof Classifier) {
			((Classifier) getCalledSubprogram()).getPropertyValueInternal(prop, pas, fromInstanceSlaveCall);
		} else if (getCalledSubprogram() instanceof Feature) {
			((Feature) getCalledSubprogram()).getPropertyValueInternal(prop, pas, fromInstanceSlaveCall);
		}

		// get values from container
		if (!fromInstanceSlaveCall && prop.isInherit()) {
			owner.getPropertyValueInternal(prop, pas, fromInstanceSlaveCall);
		}
	}

} // SubprogramCallImpl
