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
 * $Id: PortSpecificationImpl.java,v 1.2 2009-02-13 17:51:15 lwrage Exp $
 */
package org.osate.aadl2.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentPrototype;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.PortCategory;
import org.osate.aadl2.PortSpecification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Port Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.PortSpecificationImpl#getDirection <em>Direction</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PortSpecificationImpl#getCategory <em>Category</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PortSpecificationImpl#getClassifier <em>Classifier</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PortSpecificationImpl#getComponentPrototype <em>Component Prototype</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PortSpecificationImpl#isIn <em>In</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PortSpecificationImpl#isOut <em>Out</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PortSpecificationImpl extends FeaturePrototypeActualImpl implements PortSpecification {
	/**
	 * The default value of the '{@link #getDirection() <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected static final DirectionType DIRECTION_EDEFAULT = DirectionType.IN;

	/**
	 * The default value of the '{@link #getCategory() <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategory()
	 * @generated
	 * @ordered
	 */
	protected static final PortCategory CATEGORY_EDEFAULT = PortCategory.DATA;

	/**
	 * The cached value of the '{@link #getCategory() <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategory()
	 * @generated
	 * @ordered
	 */
	protected PortCategory category = CATEGORY_EDEFAULT;

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
	 * The default value of the '{@link #isIn() <em>In</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIn()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IN_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIn() <em>In</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIn()
	 * @generated
	 * @ordered
	 */
	protected boolean in = IN_EDEFAULT;

	/**
	 * The default value of the '{@link #isOut() <em>Out</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOut()
	 * @generated
	 * @ordered
	 */
	protected static final boolean OUT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isOut() <em>Out</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOut()
	 * @generated
	 * @ordered
	 */
	protected boolean out = OUT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PortSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getPortSpecification();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public DirectionType getDirection() {
		// DONE: implement this method to return the 'Direction' attribute
		if (in) {
			if (out) {
				return DirectionType.IN_OUT;
			} else {
				return DirectionType.IN;
			}
		} else {
			if (out) {
				return DirectionType.OUT;
			} else {
				return DirectionType.IN_OUT;
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PortCategory getCategory() {
		return category;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCategory(PortCategory newCategory) {
		PortCategory oldCategory = category;
		category = newCategory == null ? CATEGORY_EDEFAULT : newCategory;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.PORT_SPECIFICATION__CATEGORY,
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
							Aadl2Package.PORT_SPECIFICATION__CLASSIFIER, oldClassifier, classifier));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.PORT_SPECIFICATION__CLASSIFIER,
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
							Aadl2Package.PORT_SPECIFICATION__COMPONENT_PROTOTYPE, oldComponentPrototype,
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
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.PORT_SPECIFICATION__COMPONENT_PROTOTYPE,
					oldComponentPrototype, componentPrototype));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIn() {
		return in;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIn(boolean newIn) {
		boolean oldIn = in;
		in = newIn;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.PORT_SPECIFICATION__IN, oldIn, in));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isOut() {
		return out;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOut(boolean newOut) {
		boolean oldOut = out;
		out = newOut;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.PORT_SPECIFICATION__OUT, oldOut, out));
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
		case Aadl2Package.PORT_SPECIFICATION__DIRECTION:
			return getDirection();
		case Aadl2Package.PORT_SPECIFICATION__CATEGORY:
			return getCategory();
		case Aadl2Package.PORT_SPECIFICATION__CLASSIFIER:
			if (resolve) {
				return getClassifier();
			}
			return basicGetClassifier();
		case Aadl2Package.PORT_SPECIFICATION__COMPONENT_PROTOTYPE:
			if (resolve) {
				return getComponentPrototype();
			}
			return basicGetComponentPrototype();
		case Aadl2Package.PORT_SPECIFICATION__IN:
			return isIn();
		case Aadl2Package.PORT_SPECIFICATION__OUT:
			return isOut();
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
		case Aadl2Package.PORT_SPECIFICATION__CATEGORY:
			setCategory((PortCategory) newValue);
			return;
		case Aadl2Package.PORT_SPECIFICATION__CLASSIFIER:
			setClassifier((ComponentClassifier) newValue);
			return;
		case Aadl2Package.PORT_SPECIFICATION__COMPONENT_PROTOTYPE:
			setComponentPrototype((ComponentPrototype) newValue);
			return;
		case Aadl2Package.PORT_SPECIFICATION__IN:
			setIn((Boolean) newValue);
			return;
		case Aadl2Package.PORT_SPECIFICATION__OUT:
			setOut((Boolean) newValue);
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
		case Aadl2Package.PORT_SPECIFICATION__CATEGORY:
			setCategory(CATEGORY_EDEFAULT);
			return;
		case Aadl2Package.PORT_SPECIFICATION__CLASSIFIER:
			setClassifier((ComponentClassifier) null);
			return;
		case Aadl2Package.PORT_SPECIFICATION__COMPONENT_PROTOTYPE:
			setComponentPrototype((ComponentPrototype) null);
			return;
		case Aadl2Package.PORT_SPECIFICATION__IN:
			setIn(IN_EDEFAULT);
			return;
		case Aadl2Package.PORT_SPECIFICATION__OUT:
			setOut(OUT_EDEFAULT);
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
		case Aadl2Package.PORT_SPECIFICATION__DIRECTION:
			return getDirection() != DIRECTION_EDEFAULT;
		case Aadl2Package.PORT_SPECIFICATION__CATEGORY:
			return category != CATEGORY_EDEFAULT;
		case Aadl2Package.PORT_SPECIFICATION__CLASSIFIER:
			return classifier != null;
		case Aadl2Package.PORT_SPECIFICATION__COMPONENT_PROTOTYPE:
			return componentPrototype != null;
		case Aadl2Package.PORT_SPECIFICATION__IN:
			return in != IN_EDEFAULT;
		case Aadl2Package.PORT_SPECIFICATION__OUT:
			return out != OUT_EDEFAULT;
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
		result.append(" (category: ");
		result.append(category);
		result.append(", in: ");
		result.append(in);
		result.append(", out: ");
		result.append(out);
		result.append(')');
		return result.toString();
	}

} // PortSpecificationImpl
