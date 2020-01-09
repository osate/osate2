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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.DefaultAnnexSubclause;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Default Annex Subclause</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.DefaultAnnexSubclauseImpl#getSourceText <em>Source Text</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.DefaultAnnexSubclauseImpl#getParsedAnnexSubclause <em>Parsed Annex Subclause</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DefaultAnnexSubclauseImpl extends AnnexSubclauseImpl implements DefaultAnnexSubclause {
	/**
	 * The default value of the '{@link #getSourceText() <em>Source Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceText()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourceText() <em>Source Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceText()
	 * @generated
	 * @ordered
	 */
	protected String sourceText = SOURCE_TEXT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParsedAnnexSubclause() <em>Parsed Annex Subclause</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParsedAnnexSubclause()
	 * @generated
	 * @ordered
	 */
	protected AnnexSubclause parsedAnnexSubclause;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DefaultAnnexSubclauseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getDefaultAnnexSubclause();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSourceText() {
		return sourceText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceText(String newSourceText) {
		String oldSourceText = sourceText;
		sourceText = newSourceText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.DEFAULT_ANNEX_SUBCLAUSE__SOURCE_TEXT,
					oldSourceText, sourceText));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnexSubclause getParsedAnnexSubclause() {
		return parsedAnnexSubclause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParsedAnnexSubclause(AnnexSubclause newParsedAnnexSubclause,
			NotificationChain msgs) {
		AnnexSubclause oldParsedAnnexSubclause = parsedAnnexSubclause;
		parsedAnnexSubclause = newParsedAnnexSubclause;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					Aadl2Package.DEFAULT_ANNEX_SUBCLAUSE__PARSED_ANNEX_SUBCLAUSE, oldParsedAnnexSubclause,
					newParsedAnnexSubclause);
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
	public void setParsedAnnexSubclause(AnnexSubclause newParsedAnnexSubclause) {
		if (newParsedAnnexSubclause != parsedAnnexSubclause) {
			NotificationChain msgs = null;
			if (parsedAnnexSubclause != null)
				msgs = ((InternalEObject) parsedAnnexSubclause).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - Aadl2Package.DEFAULT_ANNEX_SUBCLAUSE__PARSED_ANNEX_SUBCLAUSE, null,
						msgs);
			if (newParsedAnnexSubclause != null)
				msgs = ((InternalEObject) newParsedAnnexSubclause).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - Aadl2Package.DEFAULT_ANNEX_SUBCLAUSE__PARSED_ANNEX_SUBCLAUSE, null,
						msgs);
			msgs = basicSetParsedAnnexSubclause(newParsedAnnexSubclause, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					Aadl2Package.DEFAULT_ANNEX_SUBCLAUSE__PARSED_ANNEX_SUBCLAUSE, newParsedAnnexSubclause,
					newParsedAnnexSubclause));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnexSubclause createParsedAnnexSubclause(EClass eClass) {
		AnnexSubclause newParsedAnnexSubclause = (AnnexSubclause) create(eClass);
		setParsedAnnexSubclause(newParsedAnnexSubclause);
		return newParsedAnnexSubclause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnexSubclause createParsedAnnexSubclause() {
		return createParsedAnnexSubclause(Aadl2Package.eINSTANCE.getAnnexSubclause());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.DEFAULT_ANNEX_SUBCLAUSE__PARSED_ANNEX_SUBCLAUSE:
			return basicSetParsedAnnexSubclause(null, msgs);
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
		case Aadl2Package.DEFAULT_ANNEX_SUBCLAUSE__SOURCE_TEXT:
			return getSourceText();
		case Aadl2Package.DEFAULT_ANNEX_SUBCLAUSE__PARSED_ANNEX_SUBCLAUSE:
			return getParsedAnnexSubclause();
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
		case Aadl2Package.DEFAULT_ANNEX_SUBCLAUSE__SOURCE_TEXT:
			setSourceText((String) newValue);
			return;
		case Aadl2Package.DEFAULT_ANNEX_SUBCLAUSE__PARSED_ANNEX_SUBCLAUSE:
			setParsedAnnexSubclause((AnnexSubclause) newValue);
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
		case Aadl2Package.DEFAULT_ANNEX_SUBCLAUSE__SOURCE_TEXT:
			setSourceText(SOURCE_TEXT_EDEFAULT);
			return;
		case Aadl2Package.DEFAULT_ANNEX_SUBCLAUSE__PARSED_ANNEX_SUBCLAUSE:
			setParsedAnnexSubclause((AnnexSubclause) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case Aadl2Package.DEFAULT_ANNEX_SUBCLAUSE__SOURCE_TEXT:
			return SOURCE_TEXT_EDEFAULT == null ? sourceText != null : !SOURCE_TEXT_EDEFAULT.equals(sourceText);
		case Aadl2Package.DEFAULT_ANNEX_SUBCLAUSE__PARSED_ANNEX_SUBCLAUSE:
			return parsedAnnexSubclause != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (sourceText: ");
		result.append(sourceText);
		result.append(')');
		return result.toString();
	}

} // DefaultAnnexSubclauseImpl
